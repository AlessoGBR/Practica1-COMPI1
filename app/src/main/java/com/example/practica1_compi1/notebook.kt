package com.example.practica1_compi1

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.text.InputType
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.StyleSpan
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings.TextSize
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.practica1_compi1.bknd.Obj.Header
import com.example.practica1_compi1.bknd.Obj.Lista
import com.example.practica1_compi1.bknd.Obj.Paragraph
import com.example.practica1_compi1.bknd.Obj.TextStyle
import com.example.practica1_compi1.bknd.Obj.Texto
import com.example.practica1_compi1.bknd.procesarTexto
import com.example.practica1_compi1.bknd.procesarCodigo

class notebook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_notebook)

        val dynamicContainer = findViewById<ViewGroup>(R.id.dynamicContainer)
        val btnTexto = findViewById<Button>(R.id.texto)
        val btnCodigo = findViewById<Button>(R.id.codigo)

        btnTexto.setOnClickListener {
            agregarCampoDinamicoTexto(dynamicContainer, "Escribe texto aquí...")
        }

        btnCodigo.setOnClickListener {
            agregarCampoDinamicoCodigo(dynamicContainer, "Ingresa código aquí...")
        }


    }

    private fun agregarCampoDinamicoTexto(container: ViewGroup, hint: String) {

        val cardView = CardView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(16, 16, 16, 16)
            }
            radius = 16f
            cardElevation = 8f
            setContentPadding(16, 16, 16, 16)
            setCardBackgroundColor(ContextCompat.getColor(this@notebook, R.color.white))
        }

        val horizontalLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
            setPadding(8, 8, 8, 8)
        }

        val editText = EditText(this).apply {
            this.hint = hint
            minLines = 4
            maxLines = 8
            gravity = Gravity.TOP or Gravity.START
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE
            layoutParams =
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply {
                    setMargins(0, 0, 12, 0)
                }
            background = createRoundedBackground()
            setTextColor(ContextCompat.getColor(this@notebook, R.color.black))
        }

        val resultadoText = TextView(this).apply {
            textSize = 16f
            setPadding(16, 16, 16, 16)
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(16, 8, 16, 16)
            }
            visibility = View.GONE
            setTextColor(ContextCompat.getColor(this@notebook, R.color.black))
            background = createRoundedBackground()
        }

        fun crearBoton(icono: Int, descripcion: String, onClick: () -> Unit): ImageButton {
            return ImageButton(this).apply {
                setImageResource(icono)
                contentDescription = descripcion
                background = createRoundedBackground()
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(4, 0, 4, 0)
                }
                setOnClickListener { onClick() }
            }
        }

        val playButton = crearBoton(android.R.drawable.ic_media_play, "Ejecutar") {
            val contenido = editText.text.toString()
            Toast.makeText(this, "Ejecutando: $contenido", Toast.LENGTH_SHORT).show()
            val resultado = procesarTexto().verTextoKt(contenido)
            resultadoText.text = ""
            when (resultado) {
                is Paragraph -> {
                    val p = resultado
                    for (t in p.texts) {
                        applyTextFormat(resultadoText, t)
                    }
                }

                is Lista -> {
                    applyTextFormat(resultadoText, resultado as Lista)
                }
            }

            resultadoText.visibility = View.VISIBLE
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
                                    (cardView.parent as? ViewGroup)?.removeView(cardView)
                                    Toast.makeText(context, "Campo borrado", Toast.LENGTH_SHORT)
                                        .show()
                                    resultadoText.visibility = View.GONE
                                }
                                setNegativeButton("Cancelar", null)
                                show()
                            }
                            true
                        }

                        "Limpiar texto" -> {
                            editText.text.clear()
                            Toast.makeText(this@notebook, "Texto limpiado", Toast.LENGTH_SHORT)
                                .show()
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

        cardView.addView(horizontalLayout)

        val verticalLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        verticalLayout.addView(cardView)
        verticalLayout.addView(resultadoText)

        if (container !is LinearLayout || container.orientation != LinearLayout.VERTICAL) {
            val newVerticalLayout = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }

            while (container.childCount > 0) {
                val child = container.getChildAt(0)
                container.removeViewAt(0)
                newVerticalLayout.addView(child)
            }

            newVerticalLayout.addView(verticalLayout)
            container.addView(newVerticalLayout)
        } else {
            container.addView(verticalLayout)
        }
    }

    // aplicando los formatos del texto creado para el cambio en kotlin
    private fun applyTextFormat(resultadoText: TextView, response: Texto) {
        val spannableBuilder = SpannableStringBuilder(resultadoText.text)
        if (response is Header) {
            val textSize = when (response.level) {
                1 -> 24f
                2 -> 22f
                3 -> 20f
                4 -> 18f
                5 -> 16f
                6 -> 14f
                else -> 16f
            }
            val headerSpan = SpannableString(response.content)
            headerSpan.setSpan(
                AbsoluteSizeSpan(textSize.toInt(), true),
                0,
                response.content.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            spannableBuilder.append(headerSpan)
        } else if (response is Lista) {
            when (response.style) {
                TextStyle.NUMERED_LIST.ordinal -> {
                    var currentIndex = 1
                    response.getTexts().forEach { textoElemento ->
                        if (textoElemento.content.isNotBlank()) {
                            val itemText = "$currentIndex. ${textoElemento.content}"
                            val spannableItem = SpannableString(itemText)

                            spannableItem.setSpan(
                                StyleSpan(Typeface.BOLD),
                                0,
                                itemText.indexOf(""),
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                            spannableBuilder.append(spannableItem)
                            currentIndex++
                        }
                    }
                }

                TextStyle.BULLETED_LIST.ordinal -> {
                    response.getTexts().forEach { textoElemento ->
                        if (textoElemento.content.isNotBlank()) {
                            val itemText = "- ${textoElemento.content}"
                            val spannableItem = SpannableString(itemText)

                            spannableItem.setSpan(
                                StyleSpan(Typeface.BOLD),
                                0,
                                itemText.indexOf(""),
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                            spannableBuilder.append(spannableItem)
                        }
                    }
                }
            }

        } else {
            val spannable = SpannableString(response.content)
            when (response.style) {
                TextStyle.BLACKED.ordinal -> {
                    spannable.setSpan(
                        StyleSpan(Typeface.BOLD),
                        0,
                        response.content.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    spannableBuilder.append(spannable)
                }

                TextStyle.ITALIC.ordinal -> {
                    spannable.setSpan(
                        StyleSpan(Typeface.ITALIC),
                        0,
                        response.content.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    spannableBuilder.append(spannable)
                }

                TextStyle.BLITALIC.ordinal -> {
                    spannable.setSpan(
                        StyleSpan(Typeface.BOLD_ITALIC),
                        0,
                        response.content.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    spannableBuilder.append(spannable)
                }

                TextStyle.NORMAL.ordinal -> {
                    spannable.setSpan(
                        StyleSpan(Typeface.NORMAL),
                        0,
                        response.content.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    spannableBuilder.append(spannable)
                }
            }

        }
        resultadoText.text = spannableBuilder
    }

    //    CAMPO PARA EL CODIGO
    private fun agregarCampoDinamicoCodigo(container: ViewGroup, hint: String) {

        val cardView = CardView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(16, 16, 16, 16)
            }
            radius = 16f
            cardElevation = 8f
            setContentPadding(16, 16, 16, 16)
            setCardBackgroundColor(ContextCompat.getColor(this@notebook, R.color.white))
        }

        val horizontalLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
            setPadding(8, 8, 8, 8)
        }

        val editText = EditText(this).apply {
            this.hint = hint
            minLines = 4
            maxLines = 8
            gravity = Gravity.TOP or Gravity.START
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE
            layoutParams =
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply {
                    setMargins(0, 0, 12, 0)
                }
            background = createRoundedBackground()
            setTextColor(ContextCompat.getColor(this@notebook, R.color.black))
        }

        val resultadoText = TextView(this).apply {
            textSize = 16f
            setPadding(16, 16, 16, 16)
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(16, 8, 16, 16)
            }
            visibility = View.GONE
            setTextColor(ContextCompat.getColor(this@notebook, R.color.black))
            background = createRoundedBackground()
        }

        fun crearBoton(icono: Int, descripcion: String, onClick: () -> Unit): ImageButton {
            return ImageButton(this).apply {
                setImageResource(icono)
                contentDescription = descripcion
                background = createRoundedBackground()
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(4, 0, 4, 0)
                }
                setOnClickListener { onClick() }
            }
        }

        val playButton = crearBoton(android.R.drawable.ic_media_play, "Ejecutar") {
            val contenido = editText.text.toString()
            Toast.makeText(this, "Ejecutando: $contenido", Toast.LENGTH_SHORT).show()
            val resultado = procesarCodigo().verTextoKt(contenido)
            resultadoText.visibility = View.VISIBLE
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
                                    (cardView.parent as? ViewGroup)?.removeView(cardView)
                                    Toast.makeText(context, "Campo borrado", Toast.LENGTH_SHORT)
                                        .show()
                                    resultadoText.visibility = View.GONE
                                }
                                setNegativeButton("Cancelar", null)
                                show()
                            }
                            true
                        }

                        "Limpiar texto" -> {
                            editText.text.clear()
                            Toast.makeText(this@notebook, "Texto limpiado", Toast.LENGTH_SHORT)
                                .show()
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

        cardView.addView(horizontalLayout)

        val verticalLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        verticalLayout.addView(cardView)
        verticalLayout.addView(resultadoText)

        if (container !is LinearLayout || container.orientation != LinearLayout.VERTICAL) {
            val newVerticalLayout = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }

            while (container.childCount > 0) {
                val child = container.getChildAt(0)
                container.removeViewAt(0)
                newVerticalLayout.addView(child)
            }

            newVerticalLayout.addView(verticalLayout)
            container.addView(newVerticalLayout)
        } else {
            container.addView(verticalLayout)
        }
    }

    private fun createRoundedBackground(): Drawable {
        val shape = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = 16f
            setColor(ContextCompat.getColor(this@notebook, R.color.white))
        }
        return shape
    }

}