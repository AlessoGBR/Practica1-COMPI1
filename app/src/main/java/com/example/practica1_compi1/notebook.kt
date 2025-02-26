package com.example.practica1_compi1

import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.practica1_compi1.bknd.procesarTexto

class notebook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_notebook)

        val dynamicContainer = findViewById<ViewGroup>(R.id.dynamicContainer)
        val btnTexto = findViewById<Button>(R.id.texto)
        val btnCodigo = findViewById<Button>(R.id.codigo)

        btnTexto.setOnClickListener {
            agregarCampoDinamico(dynamicContainer, "Escribe texto aquí...")
        }

        btnCodigo.setOnClickListener {
            agregarCampoDinamico(dynamicContainer, "Ingresa código aquí...")
        }


    }

    private fun agregarCampoDinamico(container: ViewGroup, hint: String) {

        val horizontalLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 16, 0, 0)
            }
            setPadding(8, 8, 8, 8)
        }

        val editText = EditText(this).apply {
            this.hint = hint
            minLines = 4
            maxLines = 8
            gravity = Gravity.TOP or Gravity.START
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE
            layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply {
                setMargins(0, 0, 12, 0)
            }
        }

        fun crearBoton(icono: Int, descripcion: String, onClick: () -> Unit): ImageButton {
            return ImageButton(this).apply {
                setImageResource(icono)
                contentDescription = descripcion
                background = null
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(4, 0, 4, 0)
                }
                setOnClickListener { onClick() }
            }
        }

        val playButton = crearBoton(android.R.drawable.ic_media_play, "Ejecutar") {
            val contenido = editText.text.toString()
            Toast.makeText(this, "Ejecutando: $contenido", Toast.LENGTH_SHORT).show()
            val resultado = procesarTexto().mostrarTexto(contenido)
            Toast.makeText(this,"Resultado : $resultado", Toast.LENGTH_SHORT).show()
        }

        val menuButton = crearBoton(android.R.drawable.ic_menu_more, "Opciones") {
            val popupMenu = PopupMenu(this@notebook, playButton).apply {
                menu.add("Borrar campo")
                menu.add("Limpiar texto")

                setOnMenuItemClickListener { item ->
                    when (item.title) {
                        "Borrar campo" -> {
                            AlertDialog.Builder(this@notebook).apply {
                                setTitle("Confirmar")
                                setMessage("¿Deseas borrar este campo?")
                                setPositiveButton("Sí") { _, _ ->
                                    (horizontalLayout.parent as? ViewGroup)?.removeView(horizontalLayout)
                                    Toast.makeText(context, "Campo borrado", Toast.LENGTH_SHORT).show()
                                }
                                setNegativeButton("Cancelar", null)
                                show()
                            }
                            true
                        }
                        "Limpiar texto" -> {
                            editText.text.clear()
                            Toast.makeText(this@notebook, "Texto limpiado", Toast.LENGTH_SHORT).show()
                            true
                        }
                        else -> false
                    }
                }
            }
            popupMenu.show()
        }

        horizontalLayout.apply {
            addView(playButton)
            addView(editText)
            addView(menuButton)
        }

        if (container !is LinearLayout || container.orientation != LinearLayout.VERTICAL) {
            val verticalLayout = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }

            while (container.childCount > 0) {
                val child = container.getChildAt(0)
                container.removeViewAt(0)
                verticalLayout.addView(child)
            }

            verticalLayout.addView(horizontalLayout)
            container.addView(verticalLayout)
        } else {
            container.addView(horizontalLayout)
        }
    }

}