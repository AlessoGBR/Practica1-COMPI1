
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Thu Feb 27 04:00:49 CST 2025
//----------------------------------------------------

package com.example.practica1_compi1.bknd.Parcer;

import java_cup.runtime.*;
import java.lang.Math;
import com.example.practica1_compi1.bknd.Obj.Texto;
import com.example.practica1_compi1.bknd.Obj.Header;
import com.example.practica1_compi1.bknd.Obj.Paragraph;
import com.example.practica1_compi1.bknd.Obj.TextStyle;
import com.example.practica1_compi1.bknd.Obj.Lista;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Thu Feb 27 04:00:49 CST 2025
  */
public class Parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\027\000\002\002\004\000\002\004\003\000\002\004" +
    "\003\000\002\004\003\000\002\002\004\000\002\006\004" +
    "\000\002\006\003\000\002\007\004\000\002\007\003\000" +
    "\002\007\004\000\002\007\003\000\002\007\004\000\002" +
    "\007\004\000\002\007\003\000\002\007\004\000\002\007" +
    "\003\000\002\003\003\000\002\003\003\000\002\003\003" +
    "\000\002\005\004\000\002\005\004\000\002\005\006\000" +
    "\002\005\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\037\000\024\003\016\004\005\007\011\016\014\017" +
    "\012\020\006\021\010\022\013\023\017\001\002\000\006" +
    "\016\041\017\040\001\002\000\022\002\ufff4\004\ufff4\016" +
    "\ufff4\017\ufff4\020\ufff4\021\ufff4\022\ufff4\024\037\001\002" +
    "\000\020\002\ufff1\004\ufff1\016\ufff1\017\ufff1\020\ufff1\021" +
    "\ufff1\022\ufff1\001\002\000\020\002\ufff2\004\ufff2\016\ufff2" +
    "\017\ufff2\020\ufff2\021\ufff2\022\ufff2\001\002\000\020\002" +
    "\ufff0\004\ufff0\016\ufff0\017\ufff0\020\ufff0\021\ufff0\022\ufff0" +
    "\001\002\000\004\017\036\001\002\000\020\002\ufff7\004" +
    "\ufff7\016\ufff7\017\ufff7\020\ufff7\021\ufff7\022\ufff7\001\002" +
    "\000\020\002\uffef\004\uffef\016\uffef\017\uffef\020\uffef\021" +
    "\uffef\022\uffef\001\002\000\006\016\ufffb\017\ufffb\001\002" +
    "\000\020\002\000\004\032\016\014\017\034\020\006\021" +
    "\010\022\013\001\002\000\004\002\ufffe\001\002\000\004" +
    "\017\031\001\002\000\020\002\ufff9\004\ufff9\016\ufff9\017" +
    "\ufff9\020\ufff9\021\ufff9\022\ufff9\001\002\000\010\002\uffff" +
    "\004\025\007\024\001\002\000\004\002\023\001\002\000" +
    "\004\002\001\001\002\000\004\017\030\001\002\000\004" +
    "\024\026\001\002\000\004\017\027\001\002\000\010\002" +
    "\uffec\004\uffec\007\uffec\001\002\000\010\002\uffeb\004\uffeb" +
    "\007\uffeb\001\002\000\010\002\uffee\004\uffee\007\uffee\001" +
    "\002\000\020\002\ufff6\004\ufff6\016\ufff6\017\ufff6\020\ufff6" +
    "\021\ufff6\022\ufff6\001\002\000\020\002\ufff3\004\ufff3\016" +
    "\ufff3\017\ufff3\020\ufff3\021\ufff3\022\ufff3\001\002\000\020" +
    "\002\ufff8\004\ufff8\016\ufff8\017\ufff8\020\ufff8\021\ufff8\022" +
    "\ufff8\001\002\000\020\002\ufffa\004\ufffa\016\ufffa\017\ufffa" +
    "\020\ufffa\021\ufffa\022\ufffa\001\002\000\010\002\uffed\004" +
    "\uffed\007\uffed\001\002\000\020\002\ufff5\004\ufff5\016\ufff5" +
    "\017\ufff5\020\ufff5\021\ufff5\022\ufff5\001\002\000\020\002" +
    "\ufffd\004\ufffd\016\ufffd\017\ufffd\020\ufffd\021\ufffd\022\ufffd" +
    "\001\002\000\006\016\ufffc\017\ufffc\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\037\000\016\002\006\003\017\004\021\005\020\006" +
    "\003\007\014\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\010\002\032\003\034\006\003\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    public void syntax_error(Symbol token) {
        System.out.println("Syntax error: " + token.value + " at line " + token.left);
    }

    public void unrecovered_syntax_error(Symbol token) {

    }


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // listDecl ::= listDecl PLUS STRING 
            {
              Lista RESULT =null;
		int ldleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int ldright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Lista ld = (Lista)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int stleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int stright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object st = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 ld.addTexto(new Texto(TextStyle.ELEMENT_LIST.ordinal(), st.toString() )); RESULT = ld;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("listDecl",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // listDecl ::= listDecl NUMBER DOT STRING 
            {
              Lista RESULT =null;
		int ldleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int ldright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		Lista ld = (Lista)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int nleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Object n = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int stleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int stright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object st = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 ld.addTexto(new Texto(TextStyle.ELEMENT_LIST.ordinal(), st.toString() )); RESULT = ld;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("listDecl",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // listDecl ::= PLUS STRING 
            {
              Lista RESULT =null;
		int stleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int stright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object st = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 Lista list = new Lista(TextStyle.BULLETED_LIST.ordinal()); list.addTexto(new Texto(TextStyle.ELEMENT_LIST.ordinal(), st.toString() )); RESULT = list;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("listDecl",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // listDecl ::= INITLIST STRING 
            {
              Lista RESULT =null;
		int illeft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int ilright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object il = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int stleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int stright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object st = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 Lista list = new Lista(TextStyle.NUMERED_LIST.ordinal()); list.addTexto(new Texto(TextStyle.ELEMENT_LIST.ordinal(), st.toString() )); RESULT = list;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("listDecl",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // textDecl ::= BLITALIC 
            {
              Texto RESULT =null;
		int btleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int btright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object bt = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 Texto t = new Texto(TextStyle.BLITALIC.ordinal(), bt.toString() ); RESULT = t;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("textDecl",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // textDecl ::= ITALIC 
            {
              Texto RESULT =null;
		int itleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int itright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object it = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 Texto t = new Texto(TextStyle.ITALIC.ordinal(), it.toString() ); RESULT = t;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("textDecl",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // textDecl ::= BLACKED 
            {
              Texto RESULT =null;
		int blleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int blright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object bl = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 Texto t = new Texto(TextStyle.BLACKED.ordinal(), bl.toString() ); RESULT = t;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("textDecl",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // paragDecl ::= S 
            {
              Paragraph RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Texto s = (Texto)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 Paragraph p = new Paragraph(); p.addTexto(s); RESULT = p;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paragDecl",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // paragDecl ::= paragDecl S 
            {
              Paragraph RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Paragraph p = (Paragraph)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Texto s = (Texto)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 p.addTexto(s); RESULT = p;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paragDecl",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // paragDecl ::= NUMBER 
            {
              Paragraph RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object n = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 Paragraph p = new Paragraph(); p.addTexto(new Texto(TextStyle.NORMAL.ordinal(), n.toString())); RESULT = p;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paragDecl",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // paragDecl ::= NUMBER DOT 
            {
              Paragraph RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object n = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 Paragraph p = new Paragraph(n.toString() + ".");  RESULT = p;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paragDecl",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // paragDecl ::= paragDecl NUMBER 
            {
              Paragraph RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Paragraph p = (Paragraph)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int nleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object n = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 p.addTexto(new Texto(TextStyle.NORMAL.ordinal(), n.toString())); RESULT = p;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paragDecl",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // paragDecl ::= STRING 
            {
              Paragraph RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 Paragraph p = new Paragraph(); p.addTexto(new Texto(TextStyle.NORMAL.ordinal(), s.toString())); RESULT = p;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paragDecl",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // paragDecl ::= paragDecl STRING 
            {
              Paragraph RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Paragraph p = (Paragraph)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int txtleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int txtright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object txt = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 if(p.getTexts() != null){
                                                            p.addTexto(new Texto(TextStyle.NORMAL.ordinal(), txt.toString()));
                                                            RESULT = p;
                                                        } else {
                                                            Paragraph p2 = new Paragraph();
                                                            p2.addTexto(new Texto(TextStyle.NORMAL.ordinal(), p.getContent()));
                                                            p2.addTexto(new Texto(TextStyle.NORMAL.ordinal(), txt.toString()));
                                                            RESULT = p2;
                                                        };
                                                       
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paragDecl",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // paragDecl ::= textDecl 
            {
              Paragraph RESULT =null;
		int txtsleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int txtsright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Texto txts = (Texto)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 Paragraph p = new Paragraph(); p.addTexto(txts); RESULT = p;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paragDecl",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // paragDecl ::= paragDecl textDecl 
            {
              Paragraph RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Paragraph p = (Paragraph)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int txtleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int txtright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Texto txt = (Texto)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 p.addTexto(txt); RESULT = p;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paragDecl",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // headersDecl ::= NUMERAL 
            {
              Header RESULT =null;
		 Header h = new Header(); RESULT = h;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("headersDecl",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // headersDecl ::= headersDecl NUMERAL 
            {
              Header RESULT =null;
		int headerleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int headerright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Header header = (Header)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 header.incrementLevel(); RESULT = header;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("headersDecl",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // S ::= headersDecl STRING 
            {
              Texto RESULT =null;
		int hleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int hright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Header h = (Header)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		  System.out.println("Header: " + h + " String: " + s);
                                                        h.setContent(s.toString());
                                                        RESULT = h; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("S",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // pDef ::= error 
            {
              Texto RESULT =null;
		 System.out.println("Error in the paragraph");
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("pDef",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // pDef ::= listDecl 
            {
              Texto RESULT =null;
		int ldleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int ldright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Lista ld = (Lista)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = ld; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("pDef",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // pDef ::= paragDecl 
            {
              Texto RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int pright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Paragraph p = (Paragraph)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = p; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("pDef",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= pDef EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Texto start_val = (Texto)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

