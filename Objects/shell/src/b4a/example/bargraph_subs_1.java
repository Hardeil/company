package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class bargraph_subs_1 {


public static RemoteObject  _chkchange_checkedchange(RemoteObject __ref,RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("chkChange_CheckedChange (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,162);
if (RapidSub.canDelegate("chkchange_checkedchange")) { return __ref.runUserSub(false, "bargraph","chkchange_checkedchange", __ref, _checked);}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _index = RemoteObject.createImmutable(0);
RemoteObject _checkedcount = RemoteObject.createImmutable(0);
int _i = 0;
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 162;BA.debugLine="Sub chkChange_CheckedChange(Checked As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 163;BA.debugLine="If Sender Is CheckBox Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("i",bargraph.__c.runMethod(false,"Sender",__ref.getField(false, "ba")), RemoteObject.createImmutable("android.widget.CheckBox"))) { 
 BA.debugLineNum = 164;BA.debugLine="Dim chk As CheckBox = Sender";
Debug.ShouldStop(8);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper"), bargraph.__c.runMethod(false,"Sender",__ref.getField(false, "ba")));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 167;BA.debugLine="If Not(IsNumber(chk.Tag)) Then";
Debug.ShouldStop(64);
if (bargraph.__c.runMethod(true,"Not",(Object)(bargraph.__c.runMethod(true,"IsNumber",(Object)(BA.ObjectToString(_chk.runMethod(false,"getTag")))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 168;BA.debugLine="Log(\"Error: Checkbox Tag is not a valid number\"";
Debug.ShouldStop(128);
bargraph.__c.runVoidMethod ("LogImpl","01048582",RemoteObject.createImmutable("Error: Checkbox Tag is not a valid number"),0);
 BA.debugLineNum = 169;BA.debugLine="Return";
Debug.ShouldStop(256);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 172;BA.debugLine="Dim index As Int = chk.Tag";
Debug.ShouldStop(2048);
_index = BA.numberCast(int.class, _chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 173;BA.debugLine="Dim checkedCount As Int = 0";
Debug.ShouldStop(4096);
_checkedcount = BA.numberCast(int.class, 0);Debug.locals.put("checkedCount", _checkedcount);Debug.locals.put("checkedCount", _checkedcount);
 BA.debugLineNum = 176;BA.debugLine="For i = 0 To checkedSales.Length - 1";
Debug.ShouldStop(32768);
{
final int step9 = 1;
final int limit9 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9) ;_i = ((int)(0 + _i + step9))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 177;BA.debugLine="If checkedSales(i) Then checkedCount = checkedC";
Debug.ShouldStop(65536);
if (__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)).<Boolean>get().booleanValue()) { 
_checkedcount = RemoteObject.solve(new RemoteObject[] {_checkedcount,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("checkedCount", _checkedcount);};
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 181;BA.debugLine="If Checked = False And checkedCount = 1 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_checked,bargraph.__c.getField(true,"False")) && RemoteObject.solveBoolean("=",_checkedcount,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 182;BA.debugLine="chk.Checked = True";
Debug.ShouldStop(2097152);
_chk.runMethodAndSync(true,"setChecked",bargraph.__c.getField(true,"True"));
 BA.debugLineNum = 183;BA.debugLine="Return";
Debug.ShouldStop(4194304);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 187;BA.debugLine="checkedSales(index) = Checked";
Debug.ShouldStop(67108864);
__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).setArrayElement (_checked,_index);
 BA.debugLineNum = 190;BA.debugLine="Log(\"Checkbox \" & index & \" changed to: \" & chk.";
Debug.ShouldStop(536870912);
bargraph.__c.runVoidMethod ("LogImpl","01048604",RemoteObject.concat(RemoteObject.createImmutable("Checkbox "),_index,RemoteObject.createImmutable(" changed to: "),_chk.runMethod(true,"getChecked")),0);
 BA.debugLineNum = 193;BA.debugLine="DrawGraph(Active1, panel_l, sale_1, sale_2, sale";
Debug.ShouldStop(1);
__ref.runClassMethod (b4a.example.bargraph.class, "_drawgraph" /*RemoteObject*/ ,(Object)(__ref.getField(false,"_active1" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_panel_l" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_1" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_2" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_3" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_product1" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_maxsales1" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_titlestring1" /*RemoteObject*/ )));
 BA.debugLineNum = 194;BA.debugLine="panel_l.Invalidate";
Debug.ShouldStop(2);
__ref.getField(false,"_panel_l" /*RemoteObject*/ ).runVoidMethod ("Invalidate");
 }else {
 BA.debugLineNum = 196;BA.debugLine="Log(\"Error: Sender is not a CheckBox\")";
Debug.ShouldStop(8);
bargraph.__c.runVoidMethod ("LogImpl","01048610",RemoteObject.createImmutable("Error: Sender is not a CheckBox"),0);
 };
 BA.debugLineNum = 198;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private checkBoxes() As CheckBox";
bargraph._checkboxes = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper", new int[] {0}, new Object[]{});__ref.setField("_checkboxes",bargraph._checkboxes);
 //BA.debugLineNum = 3;BA.debugLine="Private checkedSales() As Boolean";
bargraph._checkedsales = RemoteObject.createNewArray ("boolean", new int[] {0}, new Object[]{});__ref.setField("_checkedsales",bargraph._checkedsales);
 //BA.debugLineNum = 5;BA.debugLine="Dim color() As Int = Array As Int(Colors.RGB(255,";
bargraph._color = RemoteObject.createNewArray("int",new int[] {3},new Object[] {bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))),bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 200)),(Object)(BA.numberCast(int.class, 20)),(Object)(BA.numberCast(int.class, 20))),bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 10)))});__ref.setField("_color",bargraph._color);
 //BA.debugLineNum = 6;BA.debugLine="Dim legendPanel As Panel";
bargraph._legendpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_legendpanel",bargraph._legendpanel);
 //BA.debugLineNum = 7;BA.debugLine="Dim Active1 As Activity";
bargraph._active1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ActivityWrapper");__ref.setField("_active1",bargraph._active1);
 //BA.debugLineNum = 8;BA.debugLine="Dim panel_l As Panel";
bargraph._panel_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_panel_l",bargraph._panel_l);
 //BA.debugLineNum = 9;BA.debugLine="Dim sale_1() As Int";
bargraph._sale_1 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});__ref.setField("_sale_1",bargraph._sale_1);
 //BA.debugLineNum = 10;BA.debugLine="Dim sale_2() As Int";
bargraph._sale_2 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});__ref.setField("_sale_2",bargraph._sale_2);
 //BA.debugLineNum = 11;BA.debugLine="Dim sale_3() As Int";
bargraph._sale_3 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});__ref.setField("_sale_3",bargraph._sale_3);
 //BA.debugLineNum = 12;BA.debugLine="Dim product1() As String";
bargraph._product1 = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});__ref.setField("_product1",bargraph._product1);
 //BA.debugLineNum = 13;BA.debugLine="Dim legend1() As String";
bargraph._legend1 = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});__ref.setField("_legend1",bargraph._legend1);
 //BA.debugLineNum = 14;BA.debugLine="Dim maxSales1 As Int = 0";
bargraph._maxsales1 = BA.numberCast(int.class, 0);__ref.setField("_maxsales1",bargraph._maxsales1);
 //BA.debugLineNum = 15;BA.debugLine="Dim titleString1 As String = \"\"";
bargraph._titlestring1 = BA.ObjectToString("");__ref.setField("_titlestring1",bargraph._titlestring1);
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _drawgraph(RemoteObject __ref,RemoteObject _active,RemoteObject _panel,RemoteObject _sale1,RemoteObject _sale2,RemoteObject _sale3,RemoteObject _product,RemoteObject _maxsales,RemoteObject _titlestring) throws Exception{
try {
		Debug.PushSubsStack("DrawGraph (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,60);
if (RapidSub.canDelegate("drawgraph")) { return __ref.runUserSub(false, "bargraph","drawgraph", __ref, _active, _panel, _sale1, _sale2, _sale3, _product, _maxsales, _titlestring);}
RemoteObject _activitypanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _alignleftcenter = RemoteObject.createImmutable(0);
RemoteObject _aligntopcenter = RemoteObject.createImmutable(0);
RemoteObject _title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
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
int _i = 0;
RemoteObject _xpos = RemoteObject.createImmutable(0);
RemoteObject _salevalues = null;
RemoteObject _indexoffset = RemoteObject.createImmutable(0);
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
Debug.locals.put("Active", _active);
Debug.locals.put("panel", _panel);
Debug.locals.put("sale1", _sale1);
Debug.locals.put("sale2", _sale2);
Debug.locals.put("sale3", _sale3);
Debug.locals.put("product", _product);
Debug.locals.put("maxSales", _maxsales);
Debug.locals.put("TitleString", _titlestring);
 BA.debugLineNum = 60;BA.debugLine="Sub DrawGraph(Active As Activity, panel As Panel,";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="panel.Invalidate";
Debug.ShouldStop(268435456);
_panel.runVoidMethod ("Invalidate");
 BA.debugLineNum = 62;BA.debugLine="panel.RemoveAllViews";
Debug.ShouldStop(536870912);
_panel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 63;BA.debugLine="panel.Height = 400dip";
Debug.ShouldStop(1073741824);
_panel.runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400))));
 BA.debugLineNum = 65;BA.debugLine="panel.AddView(legendPanel, 0, 0, panel.Width, 30d";
Debug.ShouldStop(1);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_panel.runMethod(true,"getWidth")),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 66;BA.debugLine="Dim activityPanel As Panel";
Debug.ShouldStop(2);
_activitypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("activityPanel", _activitypanel);
 BA.debugLineNum = 67;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
Debug.ShouldStop(4);
_activitypanel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("activityPanel")));
 BA.debugLineNum = 69;BA.debugLine="activityPanel.Width = 80%x";
Debug.ShouldStop(16);
_activitypanel.runMethod(true,"setWidth",bargraph.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),__ref.getField(false, "ba")));
 BA.debugLineNum = 70;BA.debugLine="If Active.Width > 800 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean(">",_active.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 71;BA.debugLine="activityPanel.Width = 55%x";
Debug.ShouldStop(64);
_activitypanel.runMethod(true,"setWidth",bargraph.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 55)),__ref.getField(false, "ba")));
 };
 BA.debugLineNum = 73;BA.debugLine="activityPanel.Height = 250dip";
Debug.ShouldStop(256);
_activitypanel.runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))));
 BA.debugLineNum = 74;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
Debug.ShouldStop(512);
_activitypanel.runVoidMethod ("setColor",bargraph.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 70)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211))));
 BA.debugLineNum = 76;BA.debugLine="Dim alignLeftCenter As Int = (Active.Width - acti";
Debug.ShouldStop(2048);
_alignleftcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_active.runMethod(true,"getWidth"),_activitypanel.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignLeftCenter", _alignleftcenter);Debug.locals.put("alignLeftCenter", _alignleftcenter);
 BA.debugLineNum = 77;BA.debugLine="Dim alignTopCenter As Int = (panel.Height - activ";
Debug.ShouldStop(4096);
_aligntopcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getHeight"),_activitypanel.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignTopCenter", _aligntopcenter);Debug.locals.put("alignTopCenter", _aligntopcenter);
 BA.debugLineNum = 79;BA.debugLine="Dim Title As Label";
Debug.ShouldStop(16384);
_title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Title", _title);
 BA.debugLineNum = 80;BA.debugLine="Title.Initialize(\"\")";
Debug.ShouldStop(32768);
_title.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 81;BA.debugLine="Title.Text = TitleString";
Debug.ShouldStop(65536);
_title.runMethod(true,"setText",BA.ObjectToCharSequence(_titlestring));
 BA.debugLineNum = 82;BA.debugLine="Title.TextSize = 20";
Debug.ShouldStop(131072);
_title.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 83;BA.debugLine="Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(262144);
_title.runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 84;BA.debugLine="Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(524288);
_title.runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 85;BA.debugLine="Title.TextColor = Colors.Black";
Debug.ShouldStop(1048576);
_title.runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 86;BA.debugLine="Title.SendToBack";
Debug.ShouldStop(2097152);
_title.runVoidMethod ("SendToBack");
 BA.debugLineNum = 90;BA.debugLine="panel.AddView(Title, 0, alignTopCenter / 2, panel";
Debug.ShouldStop(33554432);
_panel.runVoidMethod ("AddView",(Object)((_title.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_aligntopcenter,RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(_panel.runMethod(true,"getWidth")),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 93;BA.debugLine="panel.AddView(activityPanel, alignLeftCenter, ali";
Debug.ShouldStop(268435456);
_panel.runVoidMethod ("AddView",(Object)((_activitypanel.getObject())),(Object)(_alignleftcenter),(Object)(_aligntopcenter),(Object)(_activitypanel.runMethod(true,"getWidth")),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 96;BA.debugLine="Dim graphCanvas As Canvas";
Debug.ShouldStop(-2147483648);
_graphcanvas = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("graphCanvas", _graphcanvas);
 BA.debugLineNum = 97;BA.debugLine="graphCanvas.Initialize(activityPanel)";
Debug.ShouldStop(1);
_graphcanvas.runVoidMethod ("Initialize",(Object)((_activitypanel.getObject())));
 BA.debugLineNum = 100;BA.debugLine="Dim maxSale As Int = maxSales";
Debug.ShouldStop(8);
_maxsale = _maxsales;Debug.locals.put("maxSale", _maxsale);Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 102;BA.debugLine="Dim cv As Canvas";
Debug.ShouldStop(32);
_cv = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cv", _cv);
 BA.debugLineNum = 103;BA.debugLine="cv.Initialize(panel)";
Debug.ShouldStop(64);
_cv.runVoidMethod ("Initialize",(Object)((_panel.getObject())));
 BA.debugLineNum = 106;BA.debugLine="Dim totalProducts As Int =  sale1.Length";
Debug.ShouldStop(512);
_totalproducts = _sale1.getField(true,"length");Debug.locals.put("totalProducts", _totalproducts);Debug.locals.put("totalProducts", _totalproducts);
 BA.debugLineNum = 107;BA.debugLine="Dim barsPerProduct As Int = 3";
Debug.ShouldStop(1024);
_barsperproduct = BA.numberCast(int.class, 3);Debug.locals.put("barsPerProduct", _barsperproduct);Debug.locals.put("barsPerProduct", _barsperproduct);
 BA.debugLineNum = 108;BA.debugLine="Dim totalBars As Int = totalProducts * barsPerPro";
Debug.ShouldStop(2048);
_totalbars = RemoteObject.solve(new RemoteObject[] {_totalproducts,_barsperproduct}, "*",0, 1);Debug.locals.put("totalBars", _totalbars);Debug.locals.put("totalBars", _totalbars);
 BA.debugLineNum = 109;BA.debugLine="Dim gap As Int = 5dip";
Debug.ShouldStop(4096);
_gap = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("gap", _gap);Debug.locals.put("gap", _gap);
 BA.debugLineNum = 110;BA.debugLine="Dim productGap As Int = 15dip";
Debug.ShouldStop(8192);
_productgap = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)));Debug.locals.put("productGap", _productgap);Debug.locals.put("productGap", _productgap);
 BA.debugLineNum = 111;BA.debugLine="Dim padding As Int = 20dip";
Debug.ShouldStop(16384);
_padding = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 113;BA.debugLine="Dim availableWidth As Int = activityPanel.Width -";
Debug.ShouldStop(65536);
_availablewidth = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_padding,RemoteObject.createImmutable(2)}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_totalproducts,RemoteObject.createImmutable(1)}, "-",1, 1)),_productgap}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_totalbars,_totalproducts}, "-",1, 1)),_gap}, "*",0, 1))}, "---",3, 1);Debug.locals.put("availableWidth", _availablewidth);Debug.locals.put("availableWidth", _availablewidth);
 BA.debugLineNum = 114;BA.debugLine="Dim barWidth As Int = availableWidth / totalBars";
Debug.ShouldStop(131072);
_barwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_availablewidth,_totalbars}, "/",0, 0));Debug.locals.put("barWidth", _barwidth);Debug.locals.put("barWidth", _barwidth);
 BA.debugLineNum = 115;BA.debugLine="Dim xStart As Int = padding";
Debug.ShouldStop(262144);
_xstart = _padding;Debug.locals.put("xStart", _xstart);Debug.locals.put("xStart", _xstart);
 BA.debugLineNum = 117;BA.debugLine="Dim graphCanvas As Canvas";
Debug.ShouldStop(1048576);
_graphcanvas = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("graphCanvas", _graphcanvas);
 BA.debugLineNum = 118;BA.debugLine="graphCanvas.Initialize(activityPanel)";
Debug.ShouldStop(2097152);
_graphcanvas.runVoidMethod ("Initialize",(Object)((_activitypanel.getObject())));
 BA.debugLineNum = 120;BA.debugLine="For i = 0 To totalProducts - 1";
Debug.ShouldStop(8388608);
{
final int step41 = 1;
final int limit41 = RemoteObject.solve(new RemoteObject[] {_totalproducts,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step41 > 0 && _i <= limit41) || (step41 < 0 && _i >= limit41) ;_i = ((int)(0 + _i + step41))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 122;BA.debugLine="Dim xPos As Int = xStart + i * (barsPerProduct *";
Debug.ShouldStop(33554432);
_xpos = RemoteObject.solve(new RemoteObject[] {_xstart,RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {_barsperproduct,(RemoteObject.solve(new RemoteObject[] {_barwidth,_gap}, "+",1, 1)),_productgap}, "*+",1, 1))}, "+*",1, 1);Debug.locals.put("xPos", _xpos);Debug.locals.put("xPos", _xpos);
 BA.debugLineNum = 123;BA.debugLine="Dim saleValues() As Int = Array As Int(sale1(i),";
Debug.ShouldStop(67108864);
_salevalues = RemoteObject.createNewArray("int",new int[] {3},new Object[] {_sale1.getArrayElement(true,BA.numberCast(int.class, _i)),_sale2.getArrayElement(true,BA.numberCast(int.class, _i)),_sale3.getArrayElement(true,BA.numberCast(int.class, _i))});Debug.locals.put("saleValues", _salevalues);Debug.locals.put("saleValues", _salevalues);
 BA.debugLineNum = 125;BA.debugLine="Dim indexOffset As Int = 0";
Debug.ShouldStop(268435456);
_indexoffset = BA.numberCast(int.class, 0);Debug.locals.put("indexOffset", _indexoffset);Debug.locals.put("indexOffset", _indexoffset);
 BA.debugLineNum = 127;BA.debugLine="For j = 0 To barsPerProduct - 1";
Debug.ShouldStop(1073741824);
{
final int step45 = 1;
final int limit45 = RemoteObject.solve(new RemoteObject[] {_barsperproduct,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_j = 0 ;
for (;(step45 > 0 && _j <= limit45) || (step45 < 0 && _j >= limit45) ;_j = ((int)(0 + _j + step45))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 128;BA.debugLine="If j < checkedSales.Length And checkedSales(j)";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("<",RemoteObject.createImmutable(_j),BA.numberCast(double.class, __ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getField(true,"length"))) && RemoteObject.solveBoolean(".",__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _j)))) { 
 BA.debugLineNum = 129;BA.debugLine="Dim sale As Int = saleValues(j)";
Debug.ShouldStop(1);
_sale = _salevalues.getArrayElement(true,BA.numberCast(int.class, _j));Debug.locals.put("sale", _sale);Debug.locals.put("sale", _sale);
 BA.debugLineNum = 130;BA.debugLine="Dim barHeight As Int = (sale / maxSales) * (ac";
Debug.ShouldStop(2);
_barheight = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_sale,_maxsales}, "/",0, 0)),(_activitypanel.runMethod(true,"getHeight"))}, "*",0, 0));Debug.locals.put("barHeight", _barheight);Debug.locals.put("barHeight", _barheight);
 BA.debugLineNum = 132;BA.debugLine="Dim xBar As Int = xPos + indexOffset * barWidt";
Debug.ShouldStop(8);
_xbar = RemoteObject.solve(new RemoteObject[] {_xpos,_indexoffset,_barwidth}, "+*",1, 1);Debug.locals.put("xBar", _xbar);Debug.locals.put("xBar", _xbar);
 BA.debugLineNum = 134;BA.debugLine="Dim r As Rect";
Debug.ShouldStop(32);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r", _r);
 BA.debugLineNum = 135;BA.debugLine="r.Initialize(xBar, activityPanel.Height - barH";
Debug.ShouldStop(64);
_r.runVoidMethod ("Initialize",(Object)(_xbar),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_xbar,_barwidth}, "+",1, 1)),(Object)(_panel.runMethod(true,"getHeight")));
 BA.debugLineNum = 136;BA.debugLine="graphCanvas.DrawRect(r, color(j), True, 2dip)";
Debug.ShouldStop(128);
_graphcanvas.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(__ref.getField(false,"_color" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _j))),(Object)(bargraph.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 139;BA.debugLine="Dim fontSize As Int = 8";
Debug.ShouldStop(1024);
_fontsize = BA.numberCast(int.class, 8);Debug.locals.put("fontSize", _fontsize);Debug.locals.put("fontSize", _fontsize);
 BA.debugLineNum = 140;BA.debugLine="If Active.Width > 800 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean(">",_active.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 141;BA.debugLine="fontSize = 10";
Debug.ShouldStop(4096);
_fontsize = BA.numberCast(int.class, 10);Debug.locals.put("fontSize", _fontsize);
 };
 BA.debugLineNum = 143;BA.debugLine="graphCanvas.DrawText( FormatNumberWithSuffix(s";
Debug.ShouldStop(16384);
_graphcanvas.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(__ref.runClassMethod (b4a.example.bargraph.class, "_formatnumberwithsuffix" /*RemoteObject*/ ,(Object)(_sale))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_xbar,(RemoteObject.solve(new RemoteObject[] {_barwidth,RemoteObject.createImmutable(2)}, "/",0, 0))}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "--",2, 1))),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, _fontsize)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("CENTER"))));
 BA.debugLineNum = 144;BA.debugLine="indexOffset = indexOffset + 1 '";
Debug.ShouldStop(32768);
_indexoffset = RemoteObject.solve(new RemoteObject[] {_indexoffset,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("indexOffset", _indexoffset);
 };
 }
}Debug.locals.put("j", _j);
;
 BA.debugLineNum = 149;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
Debug.ShouldStop(1048576);
_productlabely = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1);Debug.locals.put("productLabelY", _productlabely);Debug.locals.put("productLabelY", _productlabely);
 BA.debugLineNum = 150;BA.debugLine="Dim productLabelX As Int = alignLeftCenter + 50d";
Debug.ShouldStop(2097152);
_productlabelx = RemoteObject.solve(new RemoteObject[] {_alignleftcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "+",1, 1);Debug.locals.put("productLabelX", _productlabelx);Debug.locals.put("productLabelX", _productlabelx);
 BA.debugLineNum = 151;BA.debugLine="cv.DrawText(product(i), xPos + productLabelX, pr";
Debug.ShouldStop(4194304);
_cv.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(_product.getArrayElement(true,BA.numberCast(int.class, _i))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_xpos,_productlabelx}, "+",1, 1))),(Object)(BA.numberCast(float.class, _productlabely)),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, 12)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("CENTER"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 153;BA.debugLine="Dim numLabels As Int =10";
Debug.ShouldStop(16777216);
_numlabels = BA.numberCast(int.class, 10);Debug.locals.put("numLabels", _numlabels);Debug.locals.put("numLabels", _numlabels);
 BA.debugLineNum = 154;BA.debugLine="For i = 0 To numLabels";
Debug.ShouldStop(33554432);
{
final int step66 = 1;
final int limit66 = _numlabels.<Integer>get().intValue();
_i = 0 ;
for (;(step66 > 0 && _i <= limit66) || (step66 < 0 && _i >= limit66) ;_i = ((int)(0 + _i + step66))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 155;BA.debugLine="Dim labelValue As Int = Round((maxSales / numLab";
Debug.ShouldStop(67108864);
_labelvalue = BA.numberCast(int.class, bargraph.__c.runMethod(true,"Round",(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_maxsales,_numlabels}, "/",0, 0)),RemoteObject.createImmutable(_i)}, "*",0, 0))));Debug.locals.put("labelValue", _labelvalue);Debug.locals.put("labelValue", _labelvalue);
 BA.debugLineNum = 156;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ((";
Debug.ShouldStop(134217728);
_labelypos = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_labelvalue,_maxsale}, "/",0, 0)),_activitypanel.runMethod(true,"getHeight")}, "*",0, 0))}, "-",1, 0));Debug.locals.put("labelYPos", _labelypos);Debug.locals.put("labelYPos", _labelypos);
 BA.debugLineNum = 159;BA.debugLine="cv.DrawText(FormatNumberWithLabel(labelValue), a";
Debug.ShouldStop(1073741824);
_cv.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(__ref.runClassMethod (b4a.example.bargraph.class, "_formatnumberwithlabel" /*RemoteObject*/ ,(Object)(_labelvalue))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_alignleftcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_labelypos,_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "++",2, 1))),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, 10)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("RIGHT"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 161;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _formatnumberwithlabel(RemoteObject __ref,RemoteObject _number) throws Exception{
try {
		Debug.PushSubsStack("FormatNumberWithLabel (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,212);
if (RapidSub.canDelegate("formatnumberwithlabel")) { return __ref.runUserSub(false, "bargraph","formatnumberwithlabel", __ref, _number);}
Debug.locals.put("number", _number);
 BA.debugLineNum = 212;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
Debug.ShouldStop(524288);
 BA.debugLineNum = 213;BA.debugLine="If number >= 1000000 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000000))) { 
 BA.debugLineNum = 214;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
Debug.ShouldStop(2097152);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000000)}, "/",0, 0))),RemoteObject.createImmutable("M"));
 }else 
{ BA.debugLineNum = 215;BA.debugLine="Else If number >= 1000 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000))) { 
 BA.debugLineNum = 216;BA.debugLine="Return Floor(number / 1000) & \"k\"";
Debug.ShouldStop(8388608);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000)}, "/",0, 0))),RemoteObject.createImmutable("k"));
 }else {
 BA.debugLineNum = 218;BA.debugLine="Return number ' No formatting needed for v";
Debug.ShouldStop(33554432);
if (true) return BA.NumberToString(_number);
 }}
;
 BA.debugLineNum = 220;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("FormatNumberWithSuffix (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,202);
if (RapidSub.canDelegate("formatnumberwithsuffix")) { return __ref.runUserSub(false, "bargraph","formatnumberwithsuffix", __ref, _number);}
Debug.locals.put("number", _number);
 BA.debugLineNum = 202;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
Debug.ShouldStop(512);
 BA.debugLineNum = 203;BA.debugLine="If number >= 1000000 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000000))) { 
 BA.debugLineNum = 204;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
Debug.ShouldStop(2048);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("M"));
 }else 
{ BA.debugLineNum = 205;BA.debugLine="Else If number >= 1000 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000))) { 
 BA.debugLineNum = 206;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
Debug.ShouldStop(8192);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("k"));
 }else {
 BA.debugLineNum = 208;BA.debugLine="Return NumberFormat(number, 1, 0)";
Debug.ShouldStop(32768);
if (true) return bargraph.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _number)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 0)));
 }}
;
 BA.debugLineNum = 210;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Initialize (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,18);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "bargraph","initialize", __ref, _ba, _active, _panel, _sale1, _sale2, _sale3, _product, _legend, _maxsales, _titlestring);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
RemoteObject _legendwidth = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _legendlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
Debug.locals.put("ba", _ba);
Debug.locals.put("Active", _active);
Debug.locals.put("panel", _panel);
Debug.locals.put("sale1", _sale1);
Debug.locals.put("sale2", _sale2);
Debug.locals.put("sale3", _sale3);
Debug.locals.put("product", _product);
Debug.locals.put("legend", _legend);
Debug.locals.put("maxSales", _maxsales);
Debug.locals.put("TitleString", _titlestring);
 BA.debugLineNum = 18;BA.debugLine="Public Sub Initialize(Active As Activity, panel As";
Debug.ShouldStop(131072);
 BA.debugLineNum = 19;BA.debugLine="Active1 = Active";
Debug.ShouldStop(262144);
__ref.setField ("_active1" /*RemoteObject*/ ,_active);
 BA.debugLineNum = 20;BA.debugLine="panel_l = panel";
Debug.ShouldStop(524288);
__ref.setField ("_panel_l" /*RemoteObject*/ ,_panel);
 BA.debugLineNum = 21;BA.debugLine="sale_1 = sale1";
Debug.ShouldStop(1048576);
__ref.setField ("_sale_1" /*RemoteObject*/ ,_sale1);
 BA.debugLineNum = 22;BA.debugLine="sale_2 = sale2";
Debug.ShouldStop(2097152);
__ref.setField ("_sale_2" /*RemoteObject*/ ,_sale2);
 BA.debugLineNum = 23;BA.debugLine="sale_3 = sale3";
Debug.ShouldStop(4194304);
__ref.setField ("_sale_3" /*RemoteObject*/ ,_sale3);
 BA.debugLineNum = 24;BA.debugLine="product1 = product";
Debug.ShouldStop(8388608);
__ref.setField ("_product1" /*RemoteObject*/ ,_product);
 BA.debugLineNum = 25;BA.debugLine="legend1 = legend";
Debug.ShouldStop(16777216);
__ref.setField ("_legend1" /*RemoteObject*/ ,_legend);
 BA.debugLineNum = 26;BA.debugLine="maxSales1 = maxSales";
Debug.ShouldStop(33554432);
__ref.setField ("_maxsales1" /*RemoteObject*/ ,_maxsales);
 BA.debugLineNum = 27;BA.debugLine="titleString1 = TitleString";
Debug.ShouldStop(67108864);
__ref.setField ("_titlestring1" /*RemoteObject*/ ,_titlestring);
 BA.debugLineNum = 29;BA.debugLine="legendPanel.Initialize(\"\")";
Debug.ShouldStop(268435456);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 30;BA.debugLine="legendPanel.Width = panel.Width";
Debug.ShouldStop(536870912);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"setWidth",_panel.runMethod(true,"getWidth"));
 BA.debugLineNum = 31;BA.debugLine="legendPanel.Height = 30dip";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 33;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
Debug.ShouldStop(1);
_legendwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"getWidth"),_legend.getField(true,"length")}, "/",0, 0));Debug.locals.put("legendWidth", _legendwidth);Debug.locals.put("legendWidth", _legendwidth);
 BA.debugLineNum = 34;BA.debugLine="checkBoxes = Array As CheckBox()";
Debug.ShouldStop(2);
__ref.setField ("_checkboxes" /*RemoteObject*/ ,RemoteObject.createNewArray("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper",new int[] {0},new Object[] {}));
 BA.debugLineNum = 35;BA.debugLine="checkedSales = Array As Boolean()";
Debug.ShouldStop(4);
__ref.setField ("_checkedsales" /*RemoteObject*/ ,RemoteObject.createNewArray("boolean",new int[] {0},new Object[] {}));
 BA.debugLineNum = 37;BA.debugLine="Dim checkBoxes(sale1.Length) As CheckBox   ' Resi";
Debug.ShouldStop(16);
bargraph._checkboxes = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper", new int[] {_sale1.getField(true,"length").<Integer>get().intValue()}, new Object[]{});__ref.setField("_checkboxes",bargraph._checkboxes);
 BA.debugLineNum = 38;BA.debugLine="Dim checkedSales(sale1.Length) As Boolean";
Debug.ShouldStop(32);
bargraph._checkedsales = RemoteObject.createNewArray ("boolean", new int[] {_sale1.getField(true,"length").<Integer>get().intValue()}, new Object[]{});__ref.setField("_checkedsales",bargraph._checkedsales);
 BA.debugLineNum = 39;BA.debugLine="For i = 0 To legend.Length - 1";
Debug.ShouldStop(64);
{
final int step18 = 1;
final int limit18 = RemoteObject.solve(new RemoteObject[] {_legend.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step18 > 0 && _i <= limit18) || (step18 < 0 && _i >= limit18) ;_i = ((int)(0 + _i + step18))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 45;BA.debugLine="Dim legendLabel As CheckBox";
Debug.ShouldStop(4096);
_legendlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");Debug.locals.put("legendLabel", _legendlabel);
 BA.debugLineNum = 46;BA.debugLine="legendLabel.Initialize(\"chkChange\")";
Debug.ShouldStop(8192);
_legendlabel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("chkChange")));
 BA.debugLineNum = 47;BA.debugLine="legendLabel.Text = legend(i)";
Debug.ShouldStop(16384);
_legendlabel.runMethod(true,"setText",BA.ObjectToCharSequence(_legend.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 48;BA.debugLine="legendLabel.TextColor = color(i)";
Debug.ShouldStop(32768);
_legendlabel.runMethod(true,"setTextColor",__ref.getField(false,"_color" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)));
 BA.debugLineNum = 49;BA.debugLine="legendLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(65536);
_legendlabel.runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 50;BA.debugLine="legendLabel.Checked = True";
Debug.ShouldStop(131072);
_legendlabel.runMethodAndSync(true,"setChecked",bargraph.__c.getField(true,"True"));
 BA.debugLineNum = 51;BA.debugLine="legendPanel.AddView(legendLabel, (legendWidth *";
Debug.ShouldStop(262144);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((_legendlabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_legendwidth,RemoteObject.createImmutable(_i)}, "*",0, 1)),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "+",1, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(RemoteObject.solve(new RemoteObject[] {_legendwidth,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 1)),(Object)(__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"getHeight")));
 BA.debugLineNum = 53;BA.debugLine="legendLabel.Tag = i ' Assign the index as the Ta";
Debug.ShouldStop(1048576);
_legendlabel.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 54;BA.debugLine="checkBoxes(i) = legendLabel ' Store reference in";
Debug.ShouldStop(2097152);
__ref.getField(false,"_checkboxes" /*RemoteObject*/ ).setArrayElement (_legendlabel,BA.numberCast(int.class, _i));
 BA.debugLineNum = 55;BA.debugLine="checkedSales(i) = True ' Ensure the checkbox is";
Debug.ShouldStop(4194304);
__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).setArrayElement (bargraph.__c.getField(true,"True"),BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 58;BA.debugLine="DrawGraph(Active, panel, sale1, sale2, sale3, pro";
Debug.ShouldStop(33554432);
__ref.runClassMethod (b4a.example.bargraph.class, "_drawgraph" /*RemoteObject*/ ,(Object)(_active),(Object)(_panel),(Object)(_sale1),(Object)(_sale2),(Object)(_sale3),(Object)(_product),(Object)(_maxsales),(Object)(_titlestring));
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}