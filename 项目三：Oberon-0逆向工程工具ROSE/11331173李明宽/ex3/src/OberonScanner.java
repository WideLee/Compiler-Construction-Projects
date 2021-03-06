/* The following code was generated by JFlex 1.4.1 on 13-12-29 ����7:16 */

import java.io.*;

import org.omg.CORBA.PUBLIC_MEMBER;

import java_cup.runtime.*;
import exceptions.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 13-12-29 ����7:16 from the specification file
 * <tt>oberon.flex</tt>
 */
class OberonScanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  3,  0,  1,  2,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     1,  0,  0, 37,  0,  0, 38,  0,  4,  6,  5, 32, 45, 33, 41,  0, 
     8, 10, 10, 10, 10, 10, 10, 10,  9,  9, 40, 44, 36, 35, 34,  0, 
     0, 15, 11, 24, 22, 14, 29, 19, 31, 17,  7,  7, 13, 21, 16, 12, 
    27,  7, 20, 25, 18, 23, 28, 30,  7, 26,  7, 42,  0, 43,  0,  0, 
     0, 15, 11, 24, 22, 14, 29, 19, 31, 17,  7,  7, 13, 21, 16, 12, 
    27,  7, 20, 25, 18, 23, 28, 30,  7, 26,  7,  0,  0,  0, 39,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\15\6\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\4\0\2\27\1\30\1\31\2\6\1\32\1\33\4\6"+
    "\1\34\4\6\1\35\5\6\1\36\1\37\1\40\2\0"+
    "\3\6\1\41\5\6\1\42\1\43\2\6\1\44\1\6"+
    "\1\27\1\2\1\0\2\6\1\45\3\6\1\46\1\47"+
    "\6\6\1\50\1\51\1\52\3\6\1\53\1\6\1\54"+
    "\2\6\1\55\1\56\1\6\1\57\1\60\2\6\1\61";

  private static int [] zzUnpackAction() {
    int [] result = new int[120];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\56\0\56\0\134\0\212\0\270\0\56\0\346"+
    "\0\u0114\0\u0142\0\u0170\0\u019e\0\u01cc\0\u01fa\0\u0228\0\u0256"+
    "\0\u0284\0\u02b2\0\u02e0\0\u030e\0\u033c\0\u036a\0\u0398\0\56"+
    "\0\56\0\u03c6\0\56\0\u03f4\0\56\0\56\0\56\0\u0422"+
    "\0\56\0\56\0\56\0\56\0\56\0\56\0\u0450\0\270"+
    "\0\u047e\0\u04ac\0\56\0\u04da\0\u0508\0\u0536\0\u0564\0\346"+
    "\0\346\0\u0592\0\u05c0\0\u05ee\0\u061c\0\346\0\u064a\0\u0678"+
    "\0\u06a6\0\u06d4\0\346\0\u0702\0\u0730\0\u075e\0\u078c\0\u07ba"+
    "\0\56\0\56\0\56\0\u07e8\0\u0816\0\u0844\0\u0872\0\u08a0"+
    "\0\346\0\u08ce\0\u08fc\0\u092a\0\u0958\0\u0986\0\u09b4\0\346"+
    "\0\u09e2\0\u0a10\0\346\0\u0a3e\0\u07e8\0\u0a6c\0\u0a9a\0\u0ac8"+
    "\0\u0af6\0\346\0\u0b24\0\u0b52\0\u0b80\0\346\0\346\0\u0bae"+
    "\0\u0bdc\0\u0c0a\0\u0c38\0\u0c66\0\u0c94\0\346\0\346\0\346"+
    "\0\u0cc2\0\u0cf0\0\u0d1e\0\346\0\u0d4c\0\346\0\u0d7a\0\u0da8"+
    "\0\346\0\346\0\u0dd6\0\346\0\346\0\u0e04\0\u0e32\0\346";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[120];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\3\1\5\1\6\1\7\1\10"+
    "\1\11\2\12\1\13\1\14\1\10\1\15\1\16\1\10"+
    "\1\17\1\20\1\10\1\21\1\22\1\23\1\10\1\24"+
    "\2\10\1\25\1\26\1\10\1\27\1\10\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\4\46\1\47\1\50\53\46"+
    "\1\3\1\47\1\50\54\46\1\51\1\52\54\46\1\47"+
    "\1\50\1\53\53\46\1\47\1\50\1\46\31\10\22\46"+
    "\1\47\1\50\1\46\1\54\1\11\1\55\1\11\25\54"+
    "\22\46\1\47\1\50\1\46\1\54\3\12\25\54\22\46"+
    "\1\47\1\50\1\46\5\10\1\56\1\10\1\57\21\10"+
    "\22\46\1\47\1\50\1\46\15\10\1\60\10\10\1\61"+
    "\2\10\22\46\1\47\1\50\1\46\6\10\1\62\2\10"+
    "\1\63\17\10\22\46\1\47\1\50\1\46\15\10\1\64"+
    "\13\10\22\46\1\47\1\50\1\46\11\10\1\65\14\10"+
    "\1\66\2\10\22\46\1\47\1\50\1\46\23\10\1\67"+
    "\4\10\1\70\22\46\1\47\1\50\1\46\7\10\1\71"+
    "\21\10\22\46\1\47\1\50\1\46\5\10\1\72\23\10"+
    "\22\46\1\47\1\50\1\46\5\10\1\73\4\10\1\74"+
    "\16\10\22\46\1\47\1\50\1\46\5\10\1\75\23\10"+
    "\22\46\1\47\1\50\1\46\15\10\1\76\13\10\22\46"+
    "\1\47\1\50\1\46\10\10\1\77\20\10\22\46\1\47"+
    "\1\50\1\46\30\10\1\100\22\46\1\47\1\50\35\46"+
    "\1\101\16\46\1\47\1\50\35\46\1\102\16\46\1\47"+
    "\1\50\35\46\1\103\16\46\1\51\1\0\54\46\1\51"+
    "\1\50\50\46\5\52\1\104\1\105\47\52\4\46\1\47"+
    "\1\50\1\46\31\54\22\46\1\47\1\50\1\46\1\54"+
    "\3\55\25\54\22\46\1\47\1\50\1\46\5\10\1\106"+
    "\23\10\22\46\1\47\1\50\1\46\14\10\1\107\14\10"+
    "\22\46\1\47\1\50\1\46\22\10\1\110\6\10\22\46"+
    "\1\47\1\50\1\46\17\10\1\111\11\10\22\46\1\47"+
    "\1\50\1\46\15\10\1\112\13\10\22\46\1\47\1\50"+
    "\1\46\13\10\1\113\15\10\22\46\1\47\1\50\1\46"+
    "\24\10\1\114\4\10\22\46\1\47\1\50\1\46\7\10"+
    "\1\115\21\10\22\46\1\47\1\50\1\46\21\10\1\116"+
    "\7\10\22\46\1\47\1\50\1\46\17\10\1\117\11\10"+
    "\22\46\1\47\1\50\1\46\25\10\1\120\3\10\22\46"+
    "\1\47\1\50\1\46\11\10\1\121\17\10\22\46\1\47"+
    "\1\50\1\46\5\10\1\122\23\10\22\46\1\47\1\50"+
    "\1\46\15\10\1\123\13\10\22\46\1\47\1\50\1\46"+
    "\12\10\1\124\16\10\16\46\5\52\1\125\1\126\47\52"+
    "\5\105\1\127\50\105\4\46\1\47\1\50\1\46\6\10"+
    "\1\130\22\10\22\46\1\47\1\50\1\46\12\10\1\131"+
    "\16\10\22\46\1\47\1\50\1\46\7\10\1\132\2\10"+
    "\1\133\16\10\22\46\1\47\1\50\1\46\10\10\1\134"+
    "\20\10\22\46\1\47\1\50\1\46\7\10\1\135\21\10"+
    "\22\46\1\47\1\50\1\46\7\10\1\136\21\10\22\46"+
    "\1\47\1\50\1\46\11\10\1\137\17\10\22\46\1\47"+
    "\1\50\1\46\5\10\1\140\23\10\22\46\1\47\1\50"+
    "\1\46\20\10\1\141\10\10\22\46\1\47\1\50\1\46"+
    "\22\10\1\142\6\10\22\46\1\47\1\50\1\46\21\10"+
    "\1\143\7\10\22\46\1\47\1\50\1\46\6\10\1\144"+
    "\22\10\16\46\56\0\5\105\1\127\1\126\47\105\4\46"+
    "\1\47\1\50\1\46\7\10\1\145\21\10\22\46\1\47"+
    "\1\50\1\46\11\10\1\146\17\10\22\46\1\47\1\50"+
    "\1\46\26\10\1\147\2\10\22\46\1\47\1\50\1\46"+
    "\23\10\1\150\5\10\22\46\1\47\1\50\1\46\14\10"+
    "\1\151\14\10\22\46\1\47\1\50\1\46\15\10\1\152"+
    "\13\10\22\46\1\47\1\50\1\46\6\10\1\153\22\10"+
    "\22\46\1\47\1\50\1\46\13\10\1\154\15\10\22\46"+
    "\1\47\1\50\1\46\7\10\1\155\21\10\22\46\1\47"+
    "\1\50\1\46\7\10\1\156\21\10\22\46\1\47\1\50"+
    "\1\46\10\10\1\157\20\10\22\46\1\47\1\50\1\46"+
    "\7\10\1\160\21\10\22\46\1\47\1\50\1\46\17\10"+
    "\1\161\11\10\22\46\1\47\1\50\1\46\7\10\1\162"+
    "\21\10\22\46\1\47\1\50\1\46\17\10\1\163\11\10"+
    "\22\46\1\47\1\50\1\46\11\10\1\164\17\10\22\46"+
    "\1\47\1\50\1\46\15\10\1\165\13\10\22\46\1\47"+
    "\1\50\1\46\20\10\1\166\10\10\22\46\1\47\1\50"+
    "\1\46\15\10\1\167\13\10\22\46\1\47\1\50\1\46"+
    "\7\10\1\170\21\10\16\46";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3680];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\44\1\4\0\32\1\2\0\20\1\1\11\1\0"+
    "\41\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[120];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public static void init(){}
    private java_cup.runtime.Symbol symbol(int sym, Object value)
    {
      return new java_cup.runtime.Symbol(sym, yyline, yycolumn, value);
    }
    
    public int getLine(){
	return yyline+1;
    }
    public int getColumn(){
	return yycolumn;
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  OberonScanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  OberonScanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException, LexicalException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 23: 
          { throw new MismatchedCommentException(yyline, yycolumn);
          }
        case 50: break;
        case 38: 
          { return symbol(Symbol.TYPE, new String("TYPE"));
          }
        case 51: break;
        case 45: 
          { return symbol(Symbol.RECORD, new String("RECORD"));
          }
        case 52: break;
        case 22: 
          { return symbol(Symbol.COMMA, new String(","));
          }
        case 53: break;
        case 46: 
          { return symbol(Symbol.MODULE, new String("MODULE"));
          }
        case 54: break;
        case 15: 
          { return symbol(Symbol.AND, new String("&"));
          }
        case 55: break;
        case 48: 
          { return symbol(Symbol.INTEGER, new String("INTEGER"));
          }
        case 56: break;
        case 37: 
          { return symbol(Symbol.ELSE, new String("ELSE"));
          }
        case 57: break;
        case 43: 
          { return symbol(Symbol.CONST, new String("CONST"));
          }
        case 58: break;
        case 39: 
          { return symbol(Symbol.THEN, new String("THEN"));
          }
        case 59: break;
        case 1: 
          { throw new IllegalSymbolException(yyline, yycolumn);
          }
        case 60: break;
        case 9: 
          { return symbol(Symbol.ADD, new String("+"));
          }
        case 61: break;
        case 25: 
          { throw new IllegalOctalException(yyline, yycolumn);
          }
        case 62: break;
        case 19: 
          { return symbol(Symbol.LSQBRACKET, new String("["));
          }
        case 63: break;
        case 5: 
          { return symbol(Symbol.RPARENTHESE, new String(")"));
          }
        case 64: break;
        case 3: 
          { return symbol(Symbol.LPARENTHESE, new String("("));
          }
        case 65: break;
        case 27: 
          { return symbol(Symbol.OF, new String("OF"));
          }
        case 66: break;
        case 42: 
          { return symbol(Symbol.ARRAY, new String("ARRAY"));
          }
        case 67: break;
        case 8: 
          { if(yylength() > 12){
	    throw new IllegalIntegerRangeException(yyline, yycolumn);
	} else {
	    return symbol(Symbol.NUMBER, Integer.parseInt(yytext(), 10));
	}
          }
        case 68: break;
        case 47: 
          { return symbol(Symbol.BOOLEAN, new String("BOOLEAN"));
          }
        case 69: break;
        case 30: 
          { return symbol(Symbol.BIGEQ, new String(">="));
          }
        case 70: break;
        case 33: 
          { return symbol(Symbol.END, new String("END"));
          }
        case 71: break;
        case 14: 
          { return symbol(Symbol.NOTEQ, new String("#"));
          }
        case 72: break;
        case 29: 
          { return symbol(Symbol.DO, new String("DO"));
          }
        case 73: break;
        case 13: 
          { return symbol(Symbol.LESS, new String("<"));
          }
        case 74: break;
        case 11: 
          { return symbol(Symbol.BIG, new String(">"));
          }
        case 75: break;
        case 2: 
          { /*Do Nothing*/
          }
        case 76: break;
        case 12: 
          { return symbol(Symbol.EQUAL, new String("="));
          }
        case 77: break;
        case 16: 
          { return symbol(Symbol.NOT, new String("~"));
          }
        case 78: break;
        case 10: 
          { return symbol(Symbol.MINUS, new String("-"));
          }
        case 79: break;
        case 7: 
          { if(yylength() > 12){
	    throw new IllegalIntegerRangeException(yyline, yycolumn);
	} else {
	    return symbol(Symbol.NUMBER, Integer.parseInt(yytext(), 8));
	}
          }
        case 80: break;
        case 21: 
          { return symbol(Symbol.SEMI, new String(";"));
          }
        case 81: break;
        case 6: 
          { if(yylength() > 24){
	    throw new IllegalIdentifierLengthException(yyline, yycolumn);
	} else {
	return symbol(Symbol.IDENTIFIER, new String(yytext()).toLowerCase());
	}
          }
        case 82: break;
        case 24: 
          { throw new IllegalIntegerException(yyline, yycolumn);
          }
        case 83: break;
        case 26: 
          { return symbol(Symbol.OR, new String("OR"));
          }
        case 84: break;
        case 4: 
          { return symbol(Symbol.MUL, new String("*"));
          }
        case 85: break;
        case 31: 
          { return symbol(Symbol.LESSEQ, new String("<="));
          }
        case 86: break;
        case 49: 
          { return symbol(Symbol.PROCEDURE, new String("PROCEDURE"));
          }
        case 87: break;
        case 20: 
          { return symbol(Symbol.RSQBRACKET, new String("]"));
          }
        case 88: break;
        case 35: 
          { return symbol(Symbol.DIV, new String("DIV"));
          }
        case 89: break;
        case 17: 
          { return symbol(Symbol.COLON, new String(":"));
          }
        case 90: break;
        case 40: 
          { return symbol(Symbol.BEGIN, new String("BEGIN"));
          }
        case 91: break;
        case 36: 
          { return symbol(Symbol.VAR, new String("VAR"));
          }
        case 92: break;
        case 32: 
          { return symbol(Symbol.ASSIGN, new String(":="));
          }
        case 93: break;
        case 18: 
          { return symbol(Symbol.DOT, new String("."));
          }
        case 94: break;
        case 44: 
          { return symbol(Symbol.WHILE, new String("WHILE"));
          }
        case 95: break;
        case 41: 
          { return symbol(Symbol.ELSIF, new String("ELSIF"));
          }
        case 96: break;
        case 34: 
          { return symbol(Symbol.MOD, new String("MOD"));
          }
        case 97: break;
        case 28: 
          { return symbol(Symbol.IF, new String("IF"));
          }
        case 98: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {     return symbol(Symbol.EOF, new String("EOF"));
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
