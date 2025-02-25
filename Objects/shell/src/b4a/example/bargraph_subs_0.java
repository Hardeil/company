package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class bargraph_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim activityPanel As Panel";
bargraph._activitypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_activitypanel",bargraph._activitypanel);
 //BA.debugLineNum = 4;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _drawwrappedtextrotated(RemoteObject __ref,RemoteObject _canvas,RemoteObject _text,RemoteObject _x,RemoteObject _y,RemoteObject _maxwidth,RemoteObject _fontsize,RemoteObject _color,RemoteObject _alignment,RemoteObject _angle) throws Exception{
try {
		Debug.PushSubsStack("DrawWrappedTextRotated (bargraph) ","bargraph",3,__ref.getField(false, "ba"),__ref,144);
if (RapidSub.canDelegate("drawwrappedtextrotated")) { return __ref.runUserSub(false, "bargraph","drawwrappedtextrotated", __ref, _canvas, _text, _x, _y, _maxwidth, _fontsize, _color, _alignment, _angle);}
RemoteObject _words = null;
RemoteObject _line = RemoteObject.createImmutable("");
RemoteObject _lineheight = RemoteObject.createImmutable(0);
RemoteObject _originaly = RemoteObject.createImmutable(0);
RemoteObject _word = RemoteObject.createImmutable("");
RemoteObject _testline = RemoteObject.createImmutable("");
RemoteObject _textwidth = RemoteObject.createImmutable(0);
Debug.locals.put("canvas", _canvas);
Debug.locals.put("text", _text);
Debug.locals.put("x", _x);
Debug.locals.put("y", _y);
Debug.locals.put("maxWidth", _maxwidth);
Debug.locals.put("fontSize", _fontsize);
Debug.locals.put("color", _color);
Debug.locals.put("alignment", _alignment);
Debug.locals.put("angle", _angle);
 BA.debugLineNum = 144;BA.debugLine="Sub DrawWrappedTextRotated(canvas As Canvas, text";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="Dim words() As String = Regex.Split(\" \", text)";
Debug.ShouldStop(65536);
_words = bargraph.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(" ")),(Object)(_text));Debug.locals.put("words", _words);Debug.locals.put("words", _words);
 BA.debugLineNum = 146;BA.debugLine="Dim line As String = \"\"";
Debug.ShouldStop(131072);
_line = BA.ObjectToString("");Debug.locals.put("line", _line);Debug.locals.put("line", _line);
 BA.debugLineNum = 147;BA.debugLine="Dim lineHeight As Int = 20dip ' Space between lin";
Debug.ShouldStop(262144);
_lineheight = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)));Debug.locals.put("lineHeight", _lineheight);Debug.locals.put("lineHeight", _lineheight);
 BA.debugLineNum = 148;BA.debugLine="Dim originalY As Int = y ' Store original Y posit";
Debug.ShouldStop(524288);
_originaly = _y;Debug.locals.put("originalY", _originaly);Debug.locals.put("originalY", _originaly);
 BA.debugLineNum = 150;BA.debugLine="For Each word As String In words";
Debug.ShouldStop(2097152);
{
final RemoteObject group5 = _words;
final int groupLen5 = group5.getField(true,"length").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_word = group5.getArrayElement(true,RemoteObject.createImmutable(index5));Debug.locals.put("word", _word);
Debug.locals.put("word", _word);
 BA.debugLineNum = 151;BA.debugLine="Dim testLine As String = line & word & \" \"";
Debug.ShouldStop(4194304);
_testline = RemoteObject.concat(_line,_word,RemoteObject.createImmutable(" "));Debug.locals.put("testLine", _testline);Debug.locals.put("testLine", _testline);
 BA.debugLineNum = 152;BA.debugLine="Dim textWidth As Int = canvas.MeasureStringWidth";
Debug.ShouldStop(8388608);
_textwidth = BA.numberCast(int.class, _canvas.runMethod(true,"MeasureStringWidth",(Object)(_testline),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(_fontsize)));Debug.locals.put("textWidth", _textwidth);Debug.locals.put("textWidth", _textwidth);
 BA.debugLineNum = 154;BA.debugLine="If textWidth > maxWidth And line <> \"\" Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean(">",_textwidth,BA.numberCast(double.class, _maxwidth)) && RemoteObject.solveBoolean("!",_line,BA.ObjectToString(""))) { 
 BA.debugLineNum = 156;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEF";
Debug.ShouldStop(134217728);
_canvas.runVoidMethod ("DrawTextRotated",__ref.getField(false, "ba"),(Object)(_line),(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, _y)),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD")),(Object)(_fontsize),(Object)(_color),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),_alignment)),(Object)(_angle));
 BA.debugLineNum = 157;BA.debugLine="y = y + lineHeight ' Move to next line";
Debug.ShouldStop(268435456);
_y = RemoteObject.solve(new RemoteObject[] {_y,_lineheight}, "+",1, 1);Debug.locals.put("y", _y);
 BA.debugLineNum = 158;BA.debugLine="line = word & \" \" ' Start new line";
Debug.ShouldStop(536870912);
_line = RemoteObject.concat(_word,RemoteObject.createImmutable(" "));Debug.locals.put("line", _line);
 }else {
 BA.debugLineNum = 160;BA.debugLine="line = testLine ' Add word to current line";
Debug.ShouldStop(-2147483648);
_line = _testline;Debug.locals.put("line", _line);
 };
 }
}Debug.locals.put("word", _word);
;
 BA.debugLineNum = 165;BA.debugLine="If line <> \"\" Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("!",_line,BA.ObjectToString(""))) { 
 BA.debugLineNum = 166;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEFA";
Debug.ShouldStop(32);
_canvas.runVoidMethod ("DrawTextRotated",__ref.getField(false, "ba"),(Object)(_line),(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, _y)),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD")),(Object)(_fontsize),(Object)(_color),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),_alignment)),(Object)(_angle));
 BA.debugLineNum = 167;BA.debugLine="y = y + lineHeight ' Move final Y position";
Debug.ShouldStop(64);
_y = RemoteObject.solve(new RemoteObject[] {_y,_lineheight}, "+",1, 1);Debug.locals.put("y", _y);
 };
 BA.debugLineNum = 171;BA.debugLine="Return y - originalY";
Debug.ShouldStop(1024);
if (true) return RemoteObject.solve(new RemoteObject[] {_y,_originaly}, "-",1, 1);
 BA.debugLineNum = 172;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _formatnumberwithlabel(RemoteObject __ref,RemoteObject _number) throws Exception{
try {
		Debug.PushSubsStack("FormatNumberWithLabel (bargraph) ","bargraph",3,__ref.getField(false, "ba"),__ref,134);
if (RapidSub.canDelegate("formatnumberwithlabel")) { return __ref.runUserSub(false, "bargraph","formatnumberwithlabel", __ref, _number);}
Debug.locals.put("number", _number);
 BA.debugLineNum = 134;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
Debug.ShouldStop(32);
 BA.debugLineNum = 135;BA.debugLine="If number >= 1000000 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000000))) { 
 BA.debugLineNum = 136;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
Debug.ShouldStop(128);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000000)}, "/",0, 0))),RemoteObject.createImmutable("M"));
 }else 
{ BA.debugLineNum = 137;BA.debugLine="Else If number >= 1000 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000))) { 
 BA.debugLineNum = 138;BA.debugLine="Return Floor(number / 1000) & \"k\"";
Debug.ShouldStop(512);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000)}, "/",0, 0))),RemoteObject.createImmutable("k"));
 }else {
 BA.debugLineNum = 140;BA.debugLine="Return number ' No formatting needed for v";
Debug.ShouldStop(2048);
if (true) return BA.NumberToString(_number);
 }}
;
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _formatnumberwithsuffix(RemoteObject __ref,RemoteObject _number) throws Exception{
try {
		Debug.PushSubsStack("FormatNumberWithSuffix (bargraph) ","bargraph",3,__ref.getField(false, "ba"),__ref,124);
if (RapidSub.canDelegate("formatnumberwithsuffix")) { return __ref.runUserSub(false, "bargraph","formatnumberwithsuffix", __ref, _number);}
Debug.locals.put("number", _number);
 BA.debugLineNum = 124;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 125;BA.debugLine="If number >= 1000000 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000000))) { 
 BA.debugLineNum = 126;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("M"));
 }else 
{ BA.debugLineNum = 127;BA.debugLine="Else If number >= 1000 Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000))) { 
 BA.debugLineNum = 128;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
Debug.ShouldStop(-2147483648);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("k"));
 }else {
 BA.debugLineNum = 130;BA.debugLine="Return NumberFormat(number, 1, 0)";
Debug.ShouldStop(2);
if (true) return bargraph.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _number)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 0)));
 }}
;
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _active,RemoteObject _panel,RemoteObject _sale1,RemoteObject _sale2,RemoteObject _sale3,RemoteObject _product,RemoteObject _legend,RemoteObject _maxsales,RemoteObject _titlestring) throws Exception{
try {
		Debug.PushSubsStack("Initialize (bargraph) ","bargraph",3,__ref.getField(false, "ba"),__ref,6);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "bargraph","initialize", __ref, _ba, _active, _panel, _sale1, _sale2, _sale3, _product, _legend, _maxsales, _titlestring);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
RemoteObject _alignleftcenter = RemoteObject.createImmutable(0);
RemoteObject _aligntopcenter = RemoteObject.createImmutable(0);
RemoteObject _title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _legendpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _color = null;
RemoteObject _legendwidth = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _colorlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _legendlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _graphcanvas = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _maxsale = RemoteObject.createImmutable(0);
RemoteObject _cv = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _totalproducts = RemoteObject.createImmutable(0);
RemoteObject _barsperproduct = RemoteObject.createImmutable(0);
RemoteObject _totalbars = RemoteObject.createImmutable(0);
RemoteObject _gap = RemoteObject.createImmutable(0);
RemoteObject _productgap = RemoteObject.createImmutable(0);
RemoteObject _padding = RemoteObject.createImmutable(0);
RemoteObject _availablewidth = RemoteObject.createImmutable(0);
RemoteObject _barwidth = RemoteObject.createImmutable(0);
RemoteObject _xstart = RemoteObject.createImmutable(0);
RemoteObject _xpos = RemoteObject.createImmutable(0);
RemoteObject _salevalues = null;
int _j = 0;
RemoteObject _sale = RemoteObject.createImmutable(0);
RemoteObject _barheight = RemoteObject.createImmutable(0);
RemoteObject _xbar = RemoteObject.createImmutable(0);
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _fontsize = RemoteObject.createImmutable(0);
RemoteObject _productlabely = RemoteObject.createImmutable(0);
RemoteObject _productlabelx = RemoteObject.createImmutable(0);
RemoteObject _numlabels = RemoteObject.createImmutable(0);
RemoteObject _labelvalue = RemoteObject.createImmutable(0);
RemoteObject _labelypos = RemoteObject.createImmutable(0);
Debug.locals.put("ba", _ba);
Debug.locals.put("Active", _active);
Debug.locals.put("panel", _panel);
Debug.locals.put("sale1", _sale1);
Debug.locals.put("sale2", _sale2);
Debug.locals.put("sale3", _sale3);
Debug.locals.put("product", _product);
Debug.locals.put("maxSales", _maxsales);
Debug.locals.put("TitleString", _titlestring);
 BA.debugLineNum = 6;BA.debugLine="Public Sub Initialize(Active As Activity, panel As";
Debug.ShouldStop(32);
 BA.debugLineNum = 7;BA.debugLine="panel.RemoveAllViews";
Debug.ShouldStop(64);
_panel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 8;BA.debugLine="panel.Height = 400dip";
Debug.ShouldStop(128);
_panel.runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400))));
 BA.debugLineNum = 10;BA.debugLine="Dim activityPanel As Panel";
Debug.ShouldStop(512);
bargraph._activitypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_activitypanel",bargraph._activitypanel);
 BA.debugLineNum = 11;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
Debug.ShouldStop(1024);
__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("activityPanel")));
 BA.debugLineNum = 13;BA.debugLine="activityPanel.Width = 80%x";
Debug.ShouldStop(4096);
__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"setWidth",bargraph.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),__ref.getField(false, "ba")));
 BA.debugLineNum = 14;BA.debugLine="If Active.Width > 800 Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean(">",_active.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 15;BA.debugLine="activityPanel.Width = 55%x";
Debug.ShouldStop(16384);
__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"setWidth",bargraph.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 55)),__ref.getField(false, "ba")));
 };
 BA.debugLineNum = 17;BA.debugLine="activityPanel.Height = 250dip";
Debug.ShouldStop(65536);
__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))));
 BA.debugLineNum = 18;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
Debug.ShouldStop(131072);
__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runVoidMethod ("setColor",bargraph.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 70)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211))));
 BA.debugLineNum = 20;BA.debugLine="Dim alignLeftCenter As Int = (Active.Width - acti";
Debug.ShouldStop(524288);
_alignleftcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_active.runMethod(true,"getWidth"),__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignLeftCenter", _alignleftcenter);Debug.locals.put("alignLeftCenter", _alignleftcenter);
 BA.debugLineNum = 21;BA.debugLine="Dim alignTopCenter As Int = (panel.Height - activ";
Debug.ShouldStop(1048576);
_aligntopcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getHeight"),__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignTopCenter", _aligntopcenter);Debug.locals.put("alignTopCenter", _aligntopcenter);
 BA.debugLineNum = 23;BA.debugLine="Dim Title As Label";
Debug.ShouldStop(4194304);
_title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Title", _title);
 BA.debugLineNum = 24;BA.debugLine="Title.Initialize(\"\")";
Debug.ShouldStop(8388608);
_title.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 25;BA.debugLine="Title.Text = TitleString";
Debug.ShouldStop(16777216);
_title.runMethod(true,"setText",BA.ObjectToCharSequence(_titlestring));
 BA.debugLineNum = 26;BA.debugLine="Title.TextSize = 20";
Debug.ShouldStop(33554432);
_title.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 27;BA.debugLine="Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(67108864);
_title.runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 28;BA.debugLine="Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(134217728);
_title.runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 29;BA.debugLine="Title.TextColor = Colors.Black";
Debug.ShouldStop(268435456);
_title.runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 32;BA.debugLine="Dim legendPanel As Panel";
Debug.ShouldStop(-2147483648);
_legendpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("legendPanel", _legendpanel);
 BA.debugLineNum = 33;BA.debugLine="legendPanel.Initialize(\"\")";
Debug.ShouldStop(1);
_legendpanel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 34;BA.debugLine="legendPanel.Width = panel.Width";
Debug.ShouldStop(2);
_legendpanel.runMethod(true,"setWidth",_panel.runMethod(true,"getWidth"));
 BA.debugLineNum = 35;BA.debugLine="legendPanel.Height = 30dip";
Debug.ShouldStop(4);
_legendpanel.runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 36;BA.debugLine="panel.AddView(legendPanel, (panel.Width/2) + 20di";
Debug.ShouldStop(8);
_panel.runVoidMethod ("AddView",(Object)((_legendpanel.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "+",1, 0))),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 38;BA.debugLine="Dim legend() As String = Array As String(\"Sales 1";
Debug.ShouldStop(32);
_legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Sales 1"),BA.ObjectToString("Sales 2"),RemoteObject.createImmutable("Sales 3")});Debug.locals.put("legend", _legend);Debug.locals.put("legend", _legend);
 BA.debugLineNum = 39;BA.debugLine="Dim color() As Int = Array As Int(Colors.RGB(255,";
Debug.ShouldStop(64);
_color = RemoteObject.createNewArray("int",new int[] {3},new Object[] {bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))),bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 200)),(Object)(BA.numberCast(int.class, 20)),(Object)(BA.numberCast(int.class, 20))),bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 10)))});Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 41;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
Debug.ShouldStop(256);
_legendwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_legendpanel.runMethod(true,"getWidth"),_legend.getField(true,"length")}, "/",0, 0));Debug.locals.put("legendWidth", _legendwidth);Debug.locals.put("legendWidth", _legendwidth);
 BA.debugLineNum = 43;BA.debugLine="For i = 0 To legend.Length - 1";
Debug.ShouldStop(1024);
{
final int step28 = 1;
final int limit28 = RemoteObject.solve(new RemoteObject[] {_legend.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step28 > 0 && _i <= limit28) || (step28 < 0 && _i >= limit28) ;_i = ((int)(0 + _i + step28))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 44;BA.debugLine="Dim colorLabel As Label";
Debug.ShouldStop(2048);
_colorlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("colorLabel", _colorlabel);
 BA.debugLineNum = 45;BA.debugLine="colorLabel.Initialize(\"\")";
Debug.ShouldStop(4096);
_colorlabel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 46;BA.debugLine="colorLabel.Color = color(i)";
Debug.ShouldStop(8192);
_colorlabel.runVoidMethod ("setColor",_color.getArrayElement(true,BA.numberCast(int.class, _i)));
 BA.debugLineNum = 47;BA.debugLine="legendPanel.AddView(colorLabel, (legendWidth * i";
Debug.ShouldStop(16384);
_legendpanel.runVoidMethod ("AddView",(Object)((_colorlabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_legendwidth,RemoteObject.createImmutable(_i)}, "*",0, 1)),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "+",1, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {_legendpanel.runMethod(true,"getHeight"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 18)))}, "-",1, 1)));
 BA.debugLineNum = 49;BA.debugLine="Dim legendLabel As Label";
Debug.ShouldStop(65536);
_legendlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("legendLabel", _legendlabel);
 BA.debugLineNum = 50;BA.debugLine="legendLabel.Initialize(\"\")";
Debug.ShouldStop(131072);
_legendlabel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 51;BA.debugLine="legendLabel.Text = legend(i)";
Debug.ShouldStop(262144);
_legendlabel.runMethod(true,"setText",BA.ObjectToCharSequence(_legend.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 52;BA.debugLine="legendLabel.TextColor = Colors.black  ' Set text";
Debug.ShouldStop(524288);
_legendlabel.runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 53;BA.debugLine="legendLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(1048576);
_legendlabel.runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 54;BA.debugLine="legendPanel.AddView(legendLabel, (legendWidth *";
Debug.ShouldStop(2097152);
_legendpanel.runVoidMethod ("AddView",(Object)((_legendlabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_legendwidth,RemoteObject.createImmutable(_i)}, "*",0, 1)),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "+",1, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(RemoteObject.solve(new RemoteObject[] {_legendwidth,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 1)),(Object)(_legendpanel.runMethod(true,"getHeight")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 58;BA.debugLine="panel.AddView(Title, 0, alignTopCenter / 2, panel";
Debug.ShouldStop(33554432);
_panel.runVoidMethod ("AddView",(Object)((_title.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_aligntopcenter,RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(_panel.runMethod(true,"getWidth")),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 61;BA.debugLine="panel.AddView(activityPanel, alignLeftCenter, ali";
Debug.ShouldStop(268435456);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).getObject())),(Object)(_alignleftcenter),(Object)(_aligntopcenter),(Object)(__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"getWidth")),(Object)(__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"getHeight")));
 BA.debugLineNum = 64;BA.debugLine="Dim graphCanvas As Canvas";
Debug.ShouldStop(-2147483648);
_graphcanvas = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("graphCanvas", _graphcanvas);
 BA.debugLineNum = 65;BA.debugLine="graphCanvas.Initialize(activityPanel)";
Debug.ShouldStop(1);
_graphcanvas.runVoidMethod ("Initialize",(Object)((__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).getObject())));
 BA.debugLineNum = 68;BA.debugLine="Dim maxSale As Int = maxSales * 1.2";
Debug.ShouldStop(8);
_maxsale = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_maxsales,RemoteObject.createImmutable(1.2)}, "*",0, 0));Debug.locals.put("maxSale", _maxsale);Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 70;BA.debugLine="Dim cv As Canvas";
Debug.ShouldStop(32);
_cv = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cv", _cv);
 BA.debugLineNum = 71;BA.debugLine="cv.Initialize(panel)";
Debug.ShouldStop(64);
_cv.runVoidMethod ("Initialize",(Object)((_panel.getObject())));
 BA.debugLineNum = 74;BA.debugLine="Dim totalProducts As Int =  sale1.Length";
Debug.ShouldStop(512);
_totalproducts = _sale1.getField(true,"length");Debug.locals.put("totalProducts", _totalproducts);Debug.locals.put("totalProducts", _totalproducts);
 BA.debugLineNum = 75;BA.debugLine="Dim barsPerProduct As Int = 3";
Debug.ShouldStop(1024);
_barsperproduct = BA.numberCast(int.class, 3);Debug.locals.put("barsPerProduct", _barsperproduct);Debug.locals.put("barsPerProduct", _barsperproduct);
 BA.debugLineNum = 76;BA.debugLine="Dim totalBars As Int = totalProducts * barsPerPro";
Debug.ShouldStop(2048);
_totalbars = RemoteObject.solve(new RemoteObject[] {_totalproducts,_barsperproduct}, "*",0, 1);Debug.locals.put("totalBars", _totalbars);Debug.locals.put("totalBars", _totalbars);
 BA.debugLineNum = 77;BA.debugLine="Dim gap As Int = 5dip";
Debug.ShouldStop(4096);
_gap = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("gap", _gap);Debug.locals.put("gap", _gap);
 BA.debugLineNum = 78;BA.debugLine="Dim productGap As Int = 15dip";
Debug.ShouldStop(8192);
_productgap = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)));Debug.locals.put("productGap", _productgap);Debug.locals.put("productGap", _productgap);
 BA.debugLineNum = 79;BA.debugLine="Dim padding As Int = 20dip";
Debug.ShouldStop(16384);
_padding = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 81;BA.debugLine="Dim availableWidth As Int = activityPanel.Width -";
Debug.ShouldStop(65536);
_availablewidth = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_padding,RemoteObject.createImmutable(2)}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_totalproducts,RemoteObject.createImmutable(1)}, "-",1, 1)),_productgap}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_totalbars,_totalproducts}, "-",1, 1)),_gap}, "*",0, 1))}, "---",3, 1);Debug.locals.put("availableWidth", _availablewidth);Debug.locals.put("availableWidth", _availablewidth);
 BA.debugLineNum = 82;BA.debugLine="Dim barWidth As Int = availableWidth / totalBars";
Debug.ShouldStop(131072);
_barwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_availablewidth,_totalbars}, "/",0, 0));Debug.locals.put("barWidth", _barwidth);Debug.locals.put("barWidth", _barwidth);
 BA.debugLineNum = 83;BA.debugLine="Dim xStart As Int = padding";
Debug.ShouldStop(262144);
_xstart = _padding;Debug.locals.put("xStart", _xstart);Debug.locals.put("xStart", _xstart);
 BA.debugLineNum = 85;BA.debugLine="Dim graphCanvas As Canvas";
Debug.ShouldStop(1048576);
_graphcanvas = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("graphCanvas", _graphcanvas);
 BA.debugLineNum = 86;BA.debugLine="graphCanvas.Initialize(activityPanel)";
Debug.ShouldStop(2097152);
_graphcanvas.runVoidMethod ("Initialize",(Object)((__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).getObject())));
 BA.debugLineNum = 88;BA.debugLine="For i = 0 To totalProducts - 1";
Debug.ShouldStop(8388608);
{
final int step58 = 1;
final int limit58 = RemoteObject.solve(new RemoteObject[] {_totalproducts,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step58 > 0 && _i <= limit58) || (step58 < 0 && _i >= limit58) ;_i = ((int)(0 + _i + step58))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 89;BA.debugLine="Dim xPos As Int = xStart + i * (barsPerProduct *";
Debug.ShouldStop(16777216);
_xpos = RemoteObject.solve(new RemoteObject[] {_xstart,RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {_barsperproduct,(RemoteObject.solve(new RemoteObject[] {_barwidth,_gap}, "+",1, 1)),_productgap}, "*+",1, 1))}, "+*",1, 1);Debug.locals.put("xPos", _xpos);Debug.locals.put("xPos", _xpos);
 BA.debugLineNum = 90;BA.debugLine="Dim saleValues() As Int = Array As Int(sale1(i),";
Debug.ShouldStop(33554432);
_salevalues = RemoteObject.createNewArray("int",new int[] {3},new Object[] {_sale1.getArrayElement(true,BA.numberCast(int.class, _i)),_sale2.getArrayElement(true,BA.numberCast(int.class, _i)),_sale3.getArrayElement(true,BA.numberCast(int.class, _i))});Debug.locals.put("saleValues", _salevalues);Debug.locals.put("saleValues", _salevalues);
 BA.debugLineNum = 92;BA.debugLine="For j = 0 To barsPerProduct - 1";
Debug.ShouldStop(134217728);
{
final int step61 = 1;
final int limit61 = RemoteObject.solve(new RemoteObject[] {_barsperproduct,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_j = 0 ;
for (;(step61 > 0 && _j <= limit61) || (step61 < 0 && _j >= limit61) ;_j = ((int)(0 + _j + step61))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 93;BA.debugLine="Dim sale As Int = saleValues(j)";
Debug.ShouldStop(268435456);
_sale = _salevalues.getArrayElement(true,BA.numberCast(int.class, _j));Debug.locals.put("sale", _sale);Debug.locals.put("sale", _sale);
 BA.debugLineNum = 94;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * (acti";
Debug.ShouldStop(536870912);
_barheight = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_sale,_maxsale}, "/",0, 0)),(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"getHeight"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1))}, "*",0, 0));Debug.locals.put("barHeight", _barheight);Debug.locals.put("barHeight", _barheight);
 BA.debugLineNum = 95;BA.debugLine="Dim xBar As Int = xPos + j * (barWidth + gap)";
Debug.ShouldStop(1073741824);
_xbar = RemoteObject.solve(new RemoteObject[] {_xpos,RemoteObject.createImmutable(_j),(RemoteObject.solve(new RemoteObject[] {_barwidth,_gap}, "+",1, 1))}, "+*",1, 1);Debug.locals.put("xBar", _xbar);Debug.locals.put("xBar", _xbar);
 BA.debugLineNum = 97;BA.debugLine="Dim r As Rect";
Debug.ShouldStop(1);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r", _r);
 BA.debugLineNum = 98;BA.debugLine="r.Initialize(xBar, activityPanel.Height - barHe";
Debug.ShouldStop(2);
_r.runVoidMethod ("Initialize",(Object)(_xbar),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"getHeight"),_barheight}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_xbar,_barwidth}, "+",1, 1)),(Object)(_panel.runMethod(true,"getHeight")));
 BA.debugLineNum = 99;BA.debugLine="graphCanvas.DrawRect(r, color(j), True, 2dip)";
Debug.ShouldStop(4);
_graphcanvas.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(_color.getArrayElement(true,BA.numberCast(int.class, _j))),(Object)(bargraph.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 102;BA.debugLine="Dim fontSize As Int = 8";
Debug.ShouldStop(32);
_fontsize = BA.numberCast(int.class, 8);Debug.locals.put("fontSize", _fontsize);Debug.locals.put("fontSize", _fontsize);
 BA.debugLineNum = 103;BA.debugLine="If Active.Width > 800 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean(">",_active.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 104;BA.debugLine="fontSize = 10";
Debug.ShouldStop(128);
_fontsize = BA.numberCast(int.class, 10);Debug.locals.put("fontSize", _fontsize);
 };
 BA.debugLineNum = 106;BA.debugLine="graphCanvas.DrawText( FormatNumberWithSuffix(sa";
Debug.ShouldStop(512);
_graphcanvas.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(__ref.runClassMethod (b4a.example.bargraph.class, "_formatnumberwithsuffix" /*RemoteObject*/ ,(Object)(_sale))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_xbar,(RemoteObject.solve(new RemoteObject[] {_barwidth,RemoteObject.createImmutable(2)}, "/",0, 0))}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"getHeight"),_barheight,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "--",2, 1))),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, _fontsize)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("CENTER"))));
 }
}Debug.locals.put("j", _j);
;
 BA.debugLineNum = 109;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
Debug.ShouldStop(4096);
_productlabely = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"getHeight"),_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1);Debug.locals.put("productLabelY", _productlabely);Debug.locals.put("productLabelY", _productlabely);
 BA.debugLineNum = 110;BA.debugLine="Dim productLabelX As Int = alignLeftCenter + 50d";
Debug.ShouldStop(8192);
_productlabelx = RemoteObject.solve(new RemoteObject[] {_alignleftcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "+",1, 1);Debug.locals.put("productLabelX", _productlabelx);Debug.locals.put("productLabelX", _productlabelx);
 BA.debugLineNum = 111;BA.debugLine="cv.DrawText(product(i), xPos + productLabelX, pr";
Debug.ShouldStop(16384);
_cv.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(_product.getArrayElement(true,BA.numberCast(int.class, _i))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_xpos,_productlabelx}, "+",1, 1))),(Object)(BA.numberCast(float.class, _productlabely)),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, 12)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("CENTER"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 113;BA.debugLine="Dim numLabels As Int = 10";
Debug.ShouldStop(65536);
_numlabels = BA.numberCast(int.class, 10);Debug.locals.put("numLabels", _numlabels);Debug.locals.put("numLabels", _numlabels);
 BA.debugLineNum = 114;BA.debugLine="For i = 0 To numLabels";
Debug.ShouldStop(131072);
{
final int step79 = 1;
final int limit79 = _numlabels.<Integer>get().intValue();
_i = 0 ;
for (;(step79 > 0 && _i <= limit79) || (step79 < 0 && _i >= limit79) ;_i = ((int)(0 + _i + step79))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 115;BA.debugLine="Dim labelValue As Int = Round((maxSale / numLabe";
Debug.ShouldStop(262144);
_labelvalue = BA.numberCast(int.class, bargraph.__c.runMethod(true,"Round",(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_maxsale,_numlabels}, "/",0, 0)),RemoteObject.createImmutable(_i)}, "*",0, 0))));Debug.locals.put("labelValue", _labelvalue);Debug.locals.put("labelValue", _labelvalue);
 BA.debugLineNum = 116;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ((";
Debug.ShouldStop(524288);
_labelypos = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_labelvalue,_maxsale}, "/",0, 0)),__ref.getField(false,"_activitypanel" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))}, "-",1, 0));Debug.locals.put("labelYPos", _labelypos);Debug.locals.put("labelYPos", _labelypos);
 BA.debugLineNum = 119;BA.debugLine="cv.DrawText(FormatNumberWithLabel(labelValue), a";
Debug.ShouldStop(4194304);
_cv.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(__ref.runClassMethod (b4a.example.bargraph.class, "_formatnumberwithlabel" /*RemoteObject*/ ,(Object)(_labelvalue))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_alignleftcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_labelypos,_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "++",2, 1))),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, 10)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("RIGHT"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 121;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}