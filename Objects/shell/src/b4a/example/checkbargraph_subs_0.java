package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class checkbargraph_subs_0 {


public static RemoteObject  _chkchange_checkedchange(RemoteObject __ref,RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("chkChange_CheckedChange (checkbargraph) ","checkbargraph",1,__ref.getField(false, "ba"),__ref,79);
if (RapidSub.canDelegate("chkchange_checkedchange")) { return __ref.runUserSub(false, "checkbargraph","chkchange_checkedchange", __ref, _checked);}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _index = RemoteObject.createImmutable(0);
RemoteObject _checkedcount = RemoteObject.createImmutable(0);
int _i = 0;
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 79;BA.debugLine="Sub chkChange_CheckedChange(Checked As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="If Sender Is CheckBox Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("i",checkbargraph.__c.runMethod(false,"Sender",__ref.getField(false, "ba")), RemoteObject.createImmutable("android.widget.CheckBox"))) { 
 BA.debugLineNum = 81;BA.debugLine="Dim chk As CheckBox = Sender";
Debug.ShouldStop(65536);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper"), checkbargraph.__c.runMethod(false,"Sender",__ref.getField(false, "ba")));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 82;BA.debugLine="Dim index As Int = chk.Tag";
Debug.ShouldStop(131072);
_index = BA.numberCast(int.class, _chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 84;BA.debugLine="Dim checkedCount As Int = 0";
Debug.ShouldStop(524288);
_checkedcount = BA.numberCast(int.class, 0);Debug.locals.put("checkedCount", _checkedcount);Debug.locals.put("checkedCount", _checkedcount);
 BA.debugLineNum = 85;BA.debugLine="For i = 0 To checkedSales.Length - 1";
Debug.ShouldStop(1048576);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 86;BA.debugLine="If checkedSales(i) = True Then checkedCount = c";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)),checkbargraph.__c.getField(true,"True"))) { 
_checkedcount = RemoteObject.solve(new RemoteObject[] {_checkedcount,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("checkedCount", _checkedcount);};
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 89;BA.debugLine="If Checked = False And checkedCount = 1 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_checked,checkbargraph.__c.getField(true,"False")) && RemoteObject.solveBoolean("=",_checkedcount,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 90;BA.debugLine="chk.Checked = True";
Debug.ShouldStop(33554432);
_chk.runMethodAndSync(true,"setChecked",checkbargraph.__c.getField(true,"True"));
 BA.debugLineNum = 91;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 94;BA.debugLine="checkedSales(index) = Checked";
Debug.ShouldStop(536870912);
__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).setArrayElement (_checked,_index);
 BA.debugLineNum = 95;BA.debugLine="DrawGraph ' Call DrawGraph without parameters";
Debug.ShouldStop(1073741824);
__ref.runClassMethod (b4a.example.checkbargraph.class, "_drawgraph" /*RemoteObject*/ );
 }else {
 BA.debugLineNum = 97;BA.debugLine="Log(\"Error: Sender is not a CheckBox\")";
Debug.ShouldStop(1);
checkbargraph.__c.runVoidMethod ("LogImpl","3524306",RemoteObject.createImmutable("Error: Sender is not a CheckBox"),0);
 };
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
checkbargraph._checkboxes = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper", new int[] {0}, new Object[]{});__ref.setField("_checkboxes",checkbargraph._checkboxes);
 //BA.debugLineNum = 3;BA.debugLine="Private checkedSales() As Boolean";
checkbargraph._checkedsales = RemoteObject.createNewArray ("boolean", new int[] {0}, new Object[]{});__ref.setField("_checkedsales",checkbargraph._checkedsales);
 //BA.debugLineNum = 6;BA.debugLine="Private Active As Activity";
checkbargraph._active = RemoteObject.createNew ("anywheresoftware.b4a.objects.ActivityWrapper");__ref.setField("_active",checkbargraph._active);
 //BA.debugLineNum = 7;BA.debugLine="Private barPanel As Panel";
checkbargraph._barpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_barpanel",checkbargraph._barpanel);
 //BA.debugLineNum = 8;BA.debugLine="Private nxtBtn As Button";
checkbargraph._nxtbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");__ref.setField("_nxtbtn",checkbargraph._nxtbtn);
 //BA.debugLineNum = 9;BA.debugLine="Private backBtn As Button";
checkbargraph._backbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");__ref.setField("_backbtn",checkbargraph._backbtn);
 //BA.debugLineNum = 10;BA.debugLine="Private sales() As Int";
checkbargraph._sales = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});__ref.setField("_sales",checkbargraph._sales);
 //BA.debugLineNum = 11;BA.debugLine="Private sales1() As Int";
checkbargraph._sales1 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});__ref.setField("_sales1",checkbargraph._sales1);
 //BA.debugLineNum = 12;BA.debugLine="Private sales2() As Int";
checkbargraph._sales2 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});__ref.setField("_sales2",checkbargraph._sales2);
 //BA.debugLineNum = 13;BA.debugLine="Private comName() As String";
checkbargraph._comname = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});__ref.setField("_comname",checkbargraph._comname);
 //BA.debugLineNum = 14;BA.debugLine="Private maxSale As Int";
checkbargraph._maxsale = RemoteObject.createImmutable(0);__ref.setField("_maxsale",checkbargraph._maxsale);
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _drawgraph(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("DrawGraph (checkbargraph) ","checkbargraph",1,__ref.getField(false, "ba"),__ref,75);
if (RapidSub.canDelegate("drawgraph")) { return __ref.runUserSub(false, "checkbargraph","drawgraph", __ref);}
 BA.debugLineNum = 75;BA.debugLine="Sub DrawGraph()";
Debug.ShouldStop(1024);
 BA.debugLineNum = 76;BA.debugLine="DrawGraph1(Active, barPanel, nxtBtn, backBtn, sal";
Debug.ShouldStop(2048);
__ref.runClassMethod (b4a.example.checkbargraph.class, "_drawgraph1" /*RemoteObject*/ ,(Object)(__ref.getField(false,"_active" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_barpanel" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_nxtbtn" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_backbtn" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sales" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sales1" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sales2" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_comname" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_maxsale" /*RemoteObject*/ )));
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawgraph1(RemoteObject __ref,RemoteObject _active1,RemoteObject _barpanel1,RemoteObject _nextbtn,RemoteObject _bckbtn,RemoteObject _sales_1,RemoteObject _sales_2,RemoteObject _sales_3,RemoteObject _comname1,RemoteObject _maxsale1) throws Exception{
try {
		Debug.PushSubsStack("DrawGraph1 (checkbargraph) ","checkbargraph",1,__ref.getField(false, "ba"),__ref,101);
if (RapidSub.canDelegate("drawgraph1")) { return __ref.runUserSub(false, "checkbargraph","drawgraph1", __ref, _active1, _barpanel1, _nextbtn, _bckbtn, _sales_1, _sales_2, _sales_3, _comname1, _maxsale1);}
RemoteObject _color = null;
RemoteObject _activitypanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _alignleftcenter = RemoteObject.createImmutable(0);
RemoteObject _aligntopcenter = RemoteObject.createImmutable(0);
RemoteObject _btnleft = RemoteObject.createImmutable(0);
RemoteObject _titlelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _graphcanvas = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _totalproducts = RemoteObject.createImmutable(0);
RemoteObject _barsperproduct = RemoteObject.createImmutable(0);
RemoteObject _gap = RemoteObject.createImmutable(0);
RemoteObject _productgap = RemoteObject.createImmutable(0);
RemoteObject _padding = RemoteObject.createImmutable(0);
RemoteObject _numlabels = RemoteObject.createImmutable(0);
RemoteObject _labelstep = RemoteObject.createImmutable(0);
RemoteObject _labelheightstep = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _lbly = RemoteObject.createImmutable(0);
RemoteObject _lblvalue = RemoteObject.createImmutable(0);
RemoteObject _lblleft = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _checkedcount = RemoteObject.createImmutable(0);
RemoteObject _availablewidth = RemoteObject.createImmutable(0);
RemoteObject _barwidth = RemoteObject.createImmutable(0);
RemoteObject _xstart = RemoteObject.createImmutable(0);
RemoteObject _xpos = RemoteObject.createImmutable(0);
RemoteObject _salevalues = null;
RemoteObject _indexoffset = RemoteObject.createImmutable(0);
int _j = 0;
RemoteObject _sale = RemoteObject.createImmutable(0);
RemoteObject _barheight = RemoteObject.createImmutable(0);
RemoteObject _xbar = RemoteObject.createImmutable(0);
RemoteObject _lblsale = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblsaleleft = RemoteObject.createImmutable(0);
RemoteObject _lblsaletop = RemoteObject.createImmutable(0);
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _lblcompany = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalbarwidth = RemoteObject.createImmutable(0);
RemoteObject _lblcompanywidth = RemoteObject.createImmutable(0);
RemoteObject _lblcompanyleft = RemoteObject.createImmutable(0);
RemoteObject _lblcompanytop = RemoteObject.createImmutable(0);
Debug.locals.put("Active1", _active1);
Debug.locals.put("barPanel1", _barpanel1);
Debug.locals.put("nextBtn", _nextbtn);
Debug.locals.put("bckBtn", _bckbtn);
Debug.locals.put("sales_1", _sales_1);
Debug.locals.put("sales_2", _sales_2);
Debug.locals.put("sales_3", _sales_3);
Debug.locals.put("comName1", _comname1);
Debug.locals.put("maxSale1", _maxsale1);
 BA.debugLineNum = 101;BA.debugLine="Public Sub DrawGraph1(Active1 As Activity,barPanel";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="barPanel1.Initialize(\"\")";
Debug.ShouldStop(32);
_barpanel1.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 103;BA.debugLine="barPanel1.RemoveAllViews ' Clear previous drawing";
Debug.ShouldStop(64);
_barpanel1.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 105;BA.debugLine="Dim Color() As Int = Array As Int(Colors.Red, Col";
Debug.ShouldStop(256);
_color = RemoteObject.createNewArray("int",new int[] {3},new Object[] {checkbargraph.__c.getField(false,"Colors").getField(true,"Red"),checkbargraph.__c.getField(false,"Colors").getField(true,"Green"),checkbargraph.__c.getField(false,"Colors").getField(true,"Blue")});Debug.locals.put("Color", _color);Debug.locals.put("Color", _color);
 BA.debugLineNum = 106;BA.debugLine="Dim activityPanel As Panel";
Debug.ShouldStop(512);
_activitypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("activityPanel", _activitypanel);
 BA.debugLineNum = 107;BA.debugLine="activityPanel.Initialize(\"\")";
Debug.ShouldStop(1024);
_activitypanel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 108;BA.debugLine="activityPanel.Width = 75%x";
Debug.ShouldStop(2048);
_activitypanel.runMethod(true,"setWidth",checkbargraph.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 75)),__ref.getField(false, "ba")));
 BA.debugLineNum = 109;BA.debugLine="If Active1.Width >800 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean(">",_active1.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 110;BA.debugLine="activityPanel.Width = 70%x";
Debug.ShouldStop(8192);
_activitypanel.runMethod(true,"setWidth",checkbargraph.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 70)),__ref.getField(false, "ba")));
 };
 BA.debugLineNum = 112;BA.debugLine="activityPanel.Height = 250dip";
Debug.ShouldStop(32768);
_activitypanel.runMethod(true,"setHeight",checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))));
 BA.debugLineNum = 113;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
Debug.ShouldStop(65536);
_activitypanel.runVoidMethod ("setColor",checkbargraph.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 70)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211))));
 BA.debugLineNum = 115;BA.debugLine="Dim alignLeftCenter As Int = 0 ' Ensure left alig";
Debug.ShouldStop(262144);
_alignleftcenter = BA.numberCast(int.class, 0);Debug.locals.put("alignLeftCenter", _alignleftcenter);Debug.locals.put("alignLeftCenter", _alignleftcenter);
 BA.debugLineNum = 116;BA.debugLine="If checkedSales.Length > 1 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean(">",__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getField(true,"length"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 117;BA.debugLine="alignLeftCenter = (barPanel1.Width - activityPan";
Debug.ShouldStop(1048576);
_alignleftcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_barpanel1.runMethod(true,"getWidth"),_activitypanel.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignLeftCenter", _alignleftcenter);
 };
 BA.debugLineNum = 120;BA.debugLine="Dim alignTopCenter As Int = (barPanel1.Height - a";
Debug.ShouldStop(8388608);
_aligntopcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_barpanel1.runMethod(true,"getHeight"),_activitypanel.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignTopCenter", _aligntopcenter);Debug.locals.put("alignTopCenter", _aligntopcenter);
 BA.debugLineNum = 121;BA.debugLine="Dim btnLeft As Int = 0";
Debug.ShouldStop(16777216);
_btnleft = BA.numberCast(int.class, 0);Debug.locals.put("btnLeft", _btnleft);Debug.locals.put("btnLeft", _btnleft);
 BA.debugLineNum = 123;BA.debugLine="Dim titleLabel As Label";
Debug.ShouldStop(67108864);
_titlelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("titleLabel", _titlelabel);
 BA.debugLineNum = 124;BA.debugLine="titleLabel.Initialize(\"\")";
Debug.ShouldStop(134217728);
_titlelabel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 125;BA.debugLine="titleLabel.Text=\"Total Sales For Each Company\"";
Debug.ShouldStop(268435456);
_titlelabel.runMethod(true,"setText",BA.ObjectToCharSequence("Total Sales For Each Company"));
 BA.debugLineNum = 126;BA.debugLine="titleLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(536870912);
_titlelabel.runMethod(true,"setGravity",checkbargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 127;BA.debugLine="titleLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(1073741824);
_titlelabel.runMethod(false,"setTypeface",checkbargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 128;BA.debugLine="titleLabel.TextSize = 20";
Debug.ShouldStop(-2147483648);
_titlelabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 129;BA.debugLine="titleLabel.TextColor = Colors.Black";
Debug.ShouldStop(1);
_titlelabel.runMethod(true,"setTextColor",checkbargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 130;BA.debugLine="barPanel1.AddView(titleLabel,0,alignTopCenter - 4";
Debug.ShouldStop(2);
_barpanel1.runVoidMethod ("AddView",(Object)((_titlelabel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_aligntopcenter,checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))}, "-",1, 1)),(Object)(_barpanel1.runMethod(true,"getWidth")),(Object)(checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 131;BA.debugLine="barPanel1.AddView(activityPanel, alignLeftCenter,";
Debug.ShouldStop(4);
_barpanel1.runVoidMethod ("AddView",(Object)((_activitypanel.getObject())),(Object)(_alignleftcenter),(Object)(_aligntopcenter),(Object)(_activitypanel.runMethod(true,"getWidth")),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 133;BA.debugLine="Dim graphCanvas As Canvas";
Debug.ShouldStop(16);
_graphcanvas = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("graphCanvas", _graphcanvas);
 BA.debugLineNum = 134;BA.debugLine="graphCanvas.Initialize(activityPanel)";
Debug.ShouldStop(32);
_graphcanvas.runVoidMethod ("Initialize",(Object)((_activitypanel.getObject())));
 BA.debugLineNum = 136;BA.debugLine="maxSale1 = maxSale1 * 1.2";
Debug.ShouldStop(128);
_maxsale1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_maxsale1,RemoteObject.createImmutable(1.2)}, "*",0, 0));Debug.locals.put("maxSale1", _maxsale1);
 BA.debugLineNum = 137;BA.debugLine="Dim totalProducts As Int = sales_1.Length";
Debug.ShouldStop(256);
_totalproducts = _sales_1.getField(true,"length");Debug.locals.put("totalProducts", _totalproducts);Debug.locals.put("totalProducts", _totalproducts);
 BA.debugLineNum = 138;BA.debugLine="Dim barsPerProduct As Int = 3";
Debug.ShouldStop(512);
_barsperproduct = BA.numberCast(int.class, 3);Debug.locals.put("barsPerProduct", _barsperproduct);Debug.locals.put("barsPerProduct", _barsperproduct);
 BA.debugLineNum = 139;BA.debugLine="Dim gap As Int = 15dip";
Debug.ShouldStop(1024);
_gap = checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)));Debug.locals.put("gap", _gap);Debug.locals.put("gap", _gap);
 BA.debugLineNum = 140;BA.debugLine="Dim productGap As Int = 5dip";
Debug.ShouldStop(2048);
_productgap = checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("productGap", _productgap);Debug.locals.put("productGap", _productgap);
 BA.debugLineNum = 141;BA.debugLine="Dim padding As Int = 0 ' Remove left padding when";
Debug.ShouldStop(4096);
_padding = BA.numberCast(int.class, 0);Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 144;BA.debugLine="Dim numLabels As Int = 10";
Debug.ShouldStop(32768);
_numlabels = BA.numberCast(int.class, 10);Debug.locals.put("numLabels", _numlabels);Debug.locals.put("numLabels", _numlabels);
 BA.debugLineNum = 145;BA.debugLine="Dim labelStep As Int = maxSale1 / numLabels";
Debug.ShouldStop(65536);
_labelstep = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_maxsale1,_numlabels}, "/",0, 0));Debug.locals.put("labelStep", _labelstep);Debug.locals.put("labelStep", _labelstep);
 BA.debugLineNum = 146;BA.debugLine="Dim labelHeightStep As Int = activityPanel.Height";
Debug.ShouldStop(131072);
_labelheightstep = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_numlabels}, "/",0, 0));Debug.locals.put("labelHeightStep", _labelheightstep);Debug.locals.put("labelHeightStep", _labelheightstep);
 BA.debugLineNum = 148;BA.debugLine="For i = 0 To numLabels";
Debug.ShouldStop(524288);
{
final int step38 = 1;
final int limit38 = _numlabels.<Integer>get().intValue();
_i = 0 ;
for (;(step38 > 0 && _i <= limit38) || (step38 < 0 && _i >= limit38) ;_i = ((int)(0 + _i + step38))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 149;BA.debugLine="Dim lblY As Int = activityPanel.Height - (i * la";
Debug.ShouldStop(1048576);
_lbly = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),_labelheightstep}, "*",0, 1)),_aligntopcenter,checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-+-",3, 1);Debug.locals.put("lblY", _lbly);Debug.locals.put("lblY", _lbly);
 BA.debugLineNum = 150;BA.debugLine="Dim lblValue As Int = i * labelStep";
Debug.ShouldStop(2097152);
_lblvalue = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),_labelstep}, "*",0, 1);Debug.locals.put("lblValue", _lblvalue);Debug.locals.put("lblValue", _lblvalue);
 BA.debugLineNum = 152;BA.debugLine="Dim lblLeft As Label";
Debug.ShouldStop(8388608);
_lblleft = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblLeft", _lblleft);
 BA.debugLineNum = 153;BA.debugLine="lblLeft.Initialize(\"\")";
Debug.ShouldStop(16777216);
_lblleft.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 154;BA.debugLine="lblLeft.Text = FormatNumberWithLabel(lblValue)";
Debug.ShouldStop(33554432);
_lblleft.runMethod(true,"setText",BA.ObjectToCharSequence(__ref.runClassMethod (b4a.example.checkbargraph.class, "_formatnumberwithlabel" /*RemoteObject*/ ,(Object)(_lblvalue))));
 BA.debugLineNum = 155;BA.debugLine="lblLeft.TextColor = Colors.Black";
Debug.ShouldStop(67108864);
_lblleft.runMethod(true,"setTextColor",checkbargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 156;BA.debugLine="lblLeft.Gravity = Gravity.RIGHT";
Debug.ShouldStop(134217728);
_lblleft.runMethod(true,"setGravity",checkbargraph.__c.getField(false,"Gravity").getField(true,"RIGHT"));
 BA.debugLineNum = 157;BA.debugLine="lblLeft.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(268435456);
_lblleft.runMethod(false,"setTypeface",checkbargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 158;BA.debugLine="lblLeft.TextSize = 10";
Debug.ShouldStop(536870912);
_lblleft.runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 159;BA.debugLine="lblLeft.Color = Colors.Transparent";
Debug.ShouldStop(1073741824);
_lblleft.runVoidMethod ("setColor",checkbargraph.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 161;BA.debugLine="barPanel1.AddView(lblLeft, alignLeftCenter - 45d";
Debug.ShouldStop(1);
_barpanel1.runVoidMethod ("AddView",(Object)((_lblleft.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_alignleftcenter,checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 45)))}, "-",1, 1)),(Object)(_lbly),(Object)(checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 164;BA.debugLine="Dim checkedCount As Int = 0";
Debug.ShouldStop(8);
_checkedcount = BA.numberCast(int.class, 0);Debug.locals.put("checkedCount", _checkedcount);Debug.locals.put("checkedCount", _checkedcount);
 BA.debugLineNum = 165;BA.debugLine="For i = 0 To checkedSales.Length - 1";
Debug.ShouldStop(16);
{
final int step52 = 1;
final int limit52 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step52 > 0 && _i <= limit52) || (step52 < 0 && _i >= limit52) ;_i = ((int)(0 + _i + step52))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 166;BA.debugLine="If checkedSales(i) Then checkedCount = checkedCo";
Debug.ShouldStop(32);
if (__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)).<Boolean>get().booleanValue()) { 
_checkedcount = RemoteObject.solve(new RemoteObject[] {_checkedcount,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("checkedCount", _checkedcount);};
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 169;BA.debugLine="Dim availableWidth As Int = activityPanel.Width -";
Debug.ShouldStop(256);
_availablewidth = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_totalproducts,RemoteObject.createImmutable(1)}, "-",1, 1)),_productgap}, "*",0, 1))}, "-",1, 1);Debug.locals.put("availableWidth", _availablewidth);Debug.locals.put("availableWidth", _availablewidth);
 BA.debugLineNum = 170;BA.debugLine="Dim barWidth As Int = availableWidth / (totalProd";
Debug.ShouldStop(512);
_barwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_availablewidth,(RemoteObject.solve(new RemoteObject[] {_totalproducts,_checkedcount}, "*",0, 1))}, "/",0, 0));Debug.locals.put("barWidth", _barwidth);Debug.locals.put("barWidth", _barwidth);
 BA.debugLineNum = 172;BA.debugLine="If sales_1.Length <= 4 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("k",_sales_1.getField(true,"length"),BA.numberCast(double.class, 4))) { 
 BA.debugLineNum = 173;BA.debugLine="barWidth = 30dip";
Debug.ShouldStop(4096);
_barwidth = checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)));Debug.locals.put("barWidth", _barwidth);
 };
 BA.debugLineNum = 175;BA.debugLine="If Active1.Width > 800 Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean(">",_active1.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 176;BA.debugLine="If checkedCount =1 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_checkedcount,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 177;BA.debugLine="barWidth = 30dip";
Debug.ShouldStop(65536);
_barwidth = checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)));Debug.locals.put("barWidth", _barwidth);
 BA.debugLineNum = 178;BA.debugLine="productGap = 45.5dip";
Debug.ShouldStop(131072);
_productgap = checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 45.5)));Debug.locals.put("productGap", _productgap);
 };
 }else {
 BA.debugLineNum = 181;BA.debugLine="If checkedCount =1 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_checkedcount,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 182;BA.debugLine="barWidth = 30dip";
Debug.ShouldStop(2097152);
_barwidth = checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)));Debug.locals.put("barWidth", _barwidth);
 BA.debugLineNum = 183;BA.debugLine="productGap = 18dip";
Debug.ShouldStop(4194304);
_productgap = checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 18)));Debug.locals.put("productGap", _productgap);
 };
 };
 BA.debugLineNum = 188;BA.debugLine="Dim xStart As Int = 5dip ' Start from left when o";
Debug.ShouldStop(134217728);
_xstart = checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("xStart", _xstart);Debug.locals.put("xStart", _xstart);
 BA.debugLineNum = 191;BA.debugLine="For i = 0 To totalProducts - 1";
Debug.ShouldStop(1073741824);
{
final int step72 = 1;
final int limit72 = RemoteObject.solve(new RemoteObject[] {_totalproducts,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step72 > 0 && _i <= limit72) || (step72 < 0 && _i >= limit72) ;_i = ((int)(0 + _i + step72))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 192;BA.debugLine="Dim xPos As Int = xStart + (i * (checkedCount *";
Debug.ShouldStop(-2147483648);
_xpos = RemoteObject.solve(new RemoteObject[] {_xstart,(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {_checkedcount,_barwidth,_productgap}, "*+",1, 1))}, "*",0, 1))}, "+",1, 1);Debug.locals.put("xPos", _xpos);Debug.locals.put("xPos", _xpos);
 BA.debugLineNum = 193;BA.debugLine="Dim saleValues() As Int = Array As Int(sales_1(i";
Debug.ShouldStop(1);
_salevalues = RemoteObject.createNewArray("int",new int[] {3},new Object[] {_sales_1.getArrayElement(true,BA.numberCast(int.class, _i)),_sales_2.getArrayElement(true,BA.numberCast(int.class, _i)),_sales_3.getArrayElement(true,BA.numberCast(int.class, _i))});Debug.locals.put("saleValues", _salevalues);Debug.locals.put("saleValues", _salevalues);
 BA.debugLineNum = 195;BA.debugLine="Dim indexOffset As Int = 0 ' Shift bars properly";
Debug.ShouldStop(4);
_indexoffset = BA.numberCast(int.class, 0);Debug.locals.put("indexOffset", _indexoffset);Debug.locals.put("indexOffset", _indexoffset);
 BA.debugLineNum = 197;BA.debugLine="For j = 0 To barsPerProduct - 1";
Debug.ShouldStop(16);
{
final int step76 = 1;
final int limit76 = RemoteObject.solve(new RemoteObject[] {_barsperproduct,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_j = 0 ;
for (;(step76 > 0 && _j <= limit76) || (step76 < 0 && _j >= limit76) ;_j = ((int)(0 + _j + step76))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 198;BA.debugLine="If j < checkedSales.Length And checkedSales(j)";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("<",RemoteObject.createImmutable(_j),BA.numberCast(double.class, __ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getField(true,"length"))) && RemoteObject.solveBoolean(".",__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _j)))) { 
 BA.debugLineNum = 199;BA.debugLine="Dim sale As Int = saleValues(j)";
Debug.ShouldStop(64);
_sale = _salevalues.getArrayElement(true,BA.numberCast(int.class, _j));Debug.locals.put("sale", _sale);Debug.locals.put("sale", _sale);
 BA.debugLineNum = 200;BA.debugLine="Dim barHeight As Int = (sale / maxSale1) * act";
Debug.ShouldStop(128);
_barheight = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_sale,_maxsale1}, "/",0, 0)),_activitypanel.runMethod(true,"getHeight")}, "*",0, 0));Debug.locals.put("barHeight", _barheight);Debug.locals.put("barHeight", _barheight);
 BA.debugLineNum = 201;BA.debugLine="Dim xBar As Int = xPos + indexOffset * barWidt";
Debug.ShouldStop(256);
_xbar = RemoteObject.solve(new RemoteObject[] {_xpos,_indexoffset,_barwidth}, "+*",1, 1);Debug.locals.put("xBar", _xbar);Debug.locals.put("xBar", _xbar);
 BA.debugLineNum = 204;BA.debugLine="Dim lblSale As Label";
Debug.ShouldStop(2048);
_lblsale = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblSale", _lblsale);
 BA.debugLineNum = 205;BA.debugLine="lblSale.Initialize(\"\")";
Debug.ShouldStop(4096);
_lblsale.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 206;BA.debugLine="lblSale.Text = FormatNumberWithSuffix(sale) '";
Debug.ShouldStop(8192);
_lblsale.runMethod(true,"setText",BA.ObjectToCharSequence(__ref.runClassMethod (b4a.example.checkbargraph.class, "_formatnumberwithsuffix" /*RemoteObject*/ ,(Object)(_sale))));
 BA.debugLineNum = 207;BA.debugLine="lblSale.TextColor = Colors.Black";
Debug.ShouldStop(16384);
_lblsale.runMethod(true,"setTextColor",checkbargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 208;BA.debugLine="lblSale.Gravity = Gravity.CENTER";
Debug.ShouldStop(32768);
_lblsale.runMethod(true,"setGravity",checkbargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 209;BA.debugLine="lblSale.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(65536);
_lblsale.runMethod(false,"setTypeface",checkbargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 210;BA.debugLine="lblSale.TextSize = 7";
Debug.ShouldStop(131072);
_lblsale.runMethod(true,"setTextSize",BA.numberCast(float.class, 7));
 BA.debugLineNum = 211;BA.debugLine="lblSale.Color = Colors.Transparent";
Debug.ShouldStop(262144);
_lblsale.runVoidMethod ("setColor",checkbargraph.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 212;BA.debugLine="If Active1.Width > 800 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean(">",_active1.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 213;BA.debugLine="If checkedCount > 2 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean(">",_checkedcount,BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 214;BA.debugLine="lblSale.TextSize = 5";
Debug.ShouldStop(2097152);
_lblsale.runMethod(true,"setTextSize",BA.numberCast(float.class, 5));
 };
 }else {
 BA.debugLineNum = 217;BA.debugLine="If checkedCount =3 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_checkedcount,BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 218;BA.debugLine="lblSale.TextSize = 4";
Debug.ShouldStop(33554432);
_lblsale.runMethod(true,"setTextSize",BA.numberCast(float.class, 4));
 };
 BA.debugLineNum = 220;BA.debugLine="If checkedCount =2 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_checkedcount,BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 221;BA.debugLine="lblSale.TextSize =3.8";
Debug.ShouldStop(268435456);
_lblsale.runMethod(true,"setTextSize",BA.numberCast(float.class, 3.8));
 };
 };
 BA.debugLineNum = 225;BA.debugLine="Dim lblSaleLeft As Int = xBar + alignLeftCente";
Debug.ShouldStop(1);
_lblsaleleft = RemoteObject.solve(new RemoteObject[] {_xbar,_alignleftcenter}, "+",1, 1);Debug.locals.put("lblSaleLeft", _lblsaleleft);Debug.locals.put("lblSaleLeft", _lblsaleleft);
 BA.debugLineNum = 226;BA.debugLine="Dim lblSaleTop As Int = activityPanel.Height -";
Debug.ShouldStop(2);
_lblsaletop = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight,checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15))),_aligntopcenter}, "--+",3, 1);Debug.locals.put("lblSaleTop", _lblsaletop);Debug.locals.put("lblSaleTop", _lblsaletop);
 BA.debugLineNum = 228;BA.debugLine="barPanel1.AddView(lblSale, lblSaleLeft, lblSal";
Debug.ShouldStop(8);
_barpanel1.runVoidMethod ("AddView",(Object)((_lblsale.getObject())),(Object)(_lblsaleleft),(Object)(_lblsaletop),(Object)(_barwidth),(Object)(checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))));
 BA.debugLineNum = 232;BA.debugLine="Dim r As Rect";
Debug.ShouldStop(128);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r", _r);
 BA.debugLineNum = 233;BA.debugLine="r.Initialize(xBar, activityPanel.Height - barH";
Debug.ShouldStop(256);
_r.runVoidMethod ("Initialize",(Object)(_xbar),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_xbar,_barwidth}, "+",1, 1)),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 234;BA.debugLine="graphCanvas.DrawRect(r, Color(j), True, 2dip)";
Debug.ShouldStop(512);
_graphcanvas.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(_color.getArrayElement(true,BA.numberCast(int.class, _j))),(Object)(checkbargraph.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 236;BA.debugLine="indexOffset = indexOffset + 1 ' Increase offse";
Debug.ShouldStop(2048);
_indexoffset = RemoteObject.solve(new RemoteObject[] {_indexoffset,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("indexOffset", _indexoffset);
 };
 }
}Debug.locals.put("j", _j);
;
 BA.debugLineNum = 239;BA.debugLine="Dim lblCompany As Label";
Debug.ShouldStop(16384);
_lblcompany = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblCompany", _lblcompany);
 BA.debugLineNum = 240;BA.debugLine="lblCompany.Initialize(\"\")";
Debug.ShouldStop(32768);
_lblcompany.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 241;BA.debugLine="lblCompany.Text = comName(i)";
Debug.ShouldStop(65536);
_lblcompany.runMethod(true,"setText",BA.ObjectToCharSequence(__ref.getField(false,"_comname" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 242;BA.debugLine="lblCompany.TextColor = Colors.Black";
Debug.ShouldStop(131072);
_lblcompany.runMethod(true,"setTextColor",checkbargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 243;BA.debugLine="lblCompany.Gravity = Gravity.CENTER";
Debug.ShouldStop(262144);
_lblcompany.runMethod(true,"setGravity",checkbargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 244;BA.debugLine="lblCompany.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(524288);
_lblcompany.runMethod(false,"setTypeface",checkbargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 245;BA.debugLine="lblCompany.TextSize = 10";
Debug.ShouldStop(1048576);
_lblcompany.runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 246;BA.debugLine="lblCompany.Color = Colors.Transparent";
Debug.ShouldStop(2097152);
_lblcompany.runVoidMethod ("setColor",checkbargraph.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 247;BA.debugLine="If Active1.Width <= 800 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("k",_active1.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 248;BA.debugLine="lblCompany.TextSize = 7";
Debug.ShouldStop(8388608);
_lblcompany.runMethod(true,"setTextSize",BA.numberCast(float.class, 7));
 BA.debugLineNum = 249;BA.debugLine="If checkedCount = 1 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_checkedcount,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 250;BA.debugLine="lblCompany.TextSize = 8";
Debug.ShouldStop(33554432);
_lblcompany.runMethod(true,"setTextSize",BA.numberCast(float.class, 8));
 };
 };
 BA.debugLineNum = 253;BA.debugLine="Dim totalBarWidth As Int = checkedCount * barWid";
Debug.ShouldStop(268435456);
_totalbarwidth = RemoteObject.solve(new RemoteObject[] {_checkedcount,_barwidth}, "*",0, 1);Debug.locals.put("totalBarWidth", _totalbarwidth);Debug.locals.put("totalBarWidth", _totalbarwidth);
 BA.debugLineNum = 254;BA.debugLine="Dim lblCompanyWidth As Int = totalBarWidth ' Set";
Debug.ShouldStop(536870912);
_lblcompanywidth = _totalbarwidth;Debug.locals.put("lblCompanyWidth", _lblcompanywidth);Debug.locals.put("lblCompanyWidth", _lblcompanywidth);
 BA.debugLineNum = 255;BA.debugLine="Dim lblCompanyLeft As Int = xPos + (totalBarWidt";
Debug.ShouldStop(1073741824);
_lblcompanyleft = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_xpos,(RemoteObject.solve(new RemoteObject[] {_totalbarwidth,RemoteObject.createImmutable(2)}, "/",0, 0)),(RemoteObject.solve(new RemoteObject[] {_lblcompanywidth,RemoteObject.createImmutable(2)}, "/",0, 0)),_alignleftcenter}, "+-+",3, 0));Debug.locals.put("lblCompanyLeft", _lblcompanyleft);Debug.locals.put("lblCompanyLeft", _lblcompanyleft);
 BA.debugLineNum = 256;BA.debugLine="If checkedCount =1 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_checkedcount,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 257;BA.debugLine="lblCompanyWidth = productGap";
Debug.ShouldStop(1);
_lblcompanywidth = _productgap;Debug.locals.put("lblCompanyWidth", _lblcompanywidth);
 BA.debugLineNum = 258;BA.debugLine="lblCompany.Gravity = Gravity.LEFT";
Debug.ShouldStop(2);
_lblcompany.runMethod(true,"setGravity",checkbargraph.__c.getField(false,"Gravity").getField(true,"LEFT"));
 BA.debugLineNum = 259;BA.debugLine="lblCompanyWidth = productGap + barWidth";
Debug.ShouldStop(4);
_lblcompanywidth = RemoteObject.solve(new RemoteObject[] {_productgap,_barwidth}, "+",1, 1);Debug.locals.put("lblCompanyWidth", _lblcompanywidth);
 };
 BA.debugLineNum = 262;BA.debugLine="Dim lblCompanyTop As Int = activityPanel.Height";
Debug.ShouldStop(32);
_lblcompanytop = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))),_aligntopcenter}, "++",2, 1);Debug.locals.put("lblCompanyTop", _lblcompanytop);Debug.locals.put("lblCompanyTop", _lblcompanytop);
 BA.debugLineNum = 264;BA.debugLine="barPanel1.AddView(lblCompany, lblCompanyLeft, lb";
Debug.ShouldStop(128);
_barpanel1.runVoidMethod ("AddView",(Object)((_lblcompany.getObject())),(Object)(_lblcompanyleft),(Object)(_lblcompanytop),(Object)(_lblcompanywidth),(Object)(checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 267;BA.debugLine="bckBtn.Initialize(\"backBtn\")";
Debug.ShouldStop(1024);
_bckbtn.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("backBtn")));
 BA.debugLineNum = 268;BA.debugLine="bckBtn.Color = Colors.ARGB(50,0,0,0)";
Debug.ShouldStop(2048);
_bckbtn.runVoidMethod ("setColor",checkbargraph.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 269;BA.debugLine="bckBtn.Gravity =Gravity.FILL";
Debug.ShouldStop(4096);
_bckbtn.runMethod(true,"setGravity",checkbargraph.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 271;BA.debugLine="If Active1.Width > 800 Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean(">",_active1.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 272;BA.debugLine="btnLeft = (alignLeftCenter/2)";
Debug.ShouldStop(32768);
_btnleft = BA.numberCast(int.class, (RemoteObject.solve(new RemoteObject[] {_alignleftcenter,RemoteObject.createImmutable(2)}, "/",0, 0)));Debug.locals.put("btnLeft", _btnleft);
 }else {
 BA.debugLineNum = 274;BA.debugLine="btnLeft = (alignLeftCenter/2)-30dip";
Debug.ShouldStop(131072);
_btnleft = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_alignleftcenter,RemoteObject.createImmutable(2)}, "/",0, 0)),checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 0));Debug.locals.put("btnLeft", _btnleft);
 };
 BA.debugLineNum = 276;BA.debugLine="barPanel1.AddView(bckBtn,btnLeft,(barPanel1.Heigh";
Debug.ShouldStop(524288);
_barpanel1.runVoidMethod ("AddView",(Object)((_bckbtn.getObject())),(Object)(_btnleft),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_barpanel1.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0)),checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 0))),(Object)(checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 278;BA.debugLine="nextBtn.Initialize(\"nextBtn\")";
Debug.ShouldStop(2097152);
_nextbtn.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("nextBtn")));
 BA.debugLineNum = 279;BA.debugLine="nextBtn.Color = Colors.ARGB(50,0,0,0)";
Debug.ShouldStop(4194304);
_nextbtn.runVoidMethod ("setColor",checkbargraph.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 280;BA.debugLine="barPanel1.AddView(nextBtn,activityPanel.Width+(al";
Debug.ShouldStop(8388608);
_barpanel1.runVoidMethod ("AddView",(Object)((_nextbtn.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getWidth"),(_alignleftcenter),checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))}, "++",2, 1)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_barpanel1.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0)),checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "-",1, 0))),(Object)(checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 281;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawwrappedtextrotated(RemoteObject __ref,RemoteObject _canvas,RemoteObject _text,RemoteObject _x,RemoteObject _y,RemoteObject _maxwidth,RemoteObject _fontsize,RemoteObject _color,RemoteObject _alignment,RemoteObject _angle) throws Exception{
try {
		Debug.PushSubsStack("DrawWrappedTextRotated (checkbargraph) ","checkbargraph",1,__ref.getField(false, "ba"),__ref,285);
if (RapidSub.canDelegate("drawwrappedtextrotated")) { return __ref.runUserSub(false, "checkbargraph","drawwrappedtextrotated", __ref, _canvas, _text, _x, _y, _maxwidth, _fontsize, _color, _alignment, _angle);}
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
 BA.debugLineNum = 285;BA.debugLine="Sub DrawWrappedTextRotated(canvas As Canvas, text";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 286;BA.debugLine="Dim words() As String = Regex.Split(\" \", text)";
Debug.ShouldStop(536870912);
_words = checkbargraph.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(" ")),(Object)(_text));Debug.locals.put("words", _words);Debug.locals.put("words", _words);
 BA.debugLineNum = 287;BA.debugLine="Dim line As String = \"\"";
Debug.ShouldStop(1073741824);
_line = BA.ObjectToString("");Debug.locals.put("line", _line);Debug.locals.put("line", _line);
 BA.debugLineNum = 288;BA.debugLine="Dim lineHeight As Int = 20dip ' Space between lin";
Debug.ShouldStop(-2147483648);
_lineheight = checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)));Debug.locals.put("lineHeight", _lineheight);Debug.locals.put("lineHeight", _lineheight);
 BA.debugLineNum = 289;BA.debugLine="Dim originalY As Int = y ' Store original Y posit";
Debug.ShouldStop(1);
_originaly = _y;Debug.locals.put("originalY", _originaly);Debug.locals.put("originalY", _originaly);
 BA.debugLineNum = 291;BA.debugLine="For Each word As String In words";
Debug.ShouldStop(4);
{
final RemoteObject group5 = _words;
final int groupLen5 = group5.getField(true,"length").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_word = group5.getArrayElement(true,RemoteObject.createImmutable(index5));Debug.locals.put("word", _word);
Debug.locals.put("word", _word);
 BA.debugLineNum = 292;BA.debugLine="Dim testLine As String = line & word & \" \"";
Debug.ShouldStop(8);
_testline = RemoteObject.concat(_line,_word,RemoteObject.createImmutable(" "));Debug.locals.put("testLine", _testline);Debug.locals.put("testLine", _testline);
 BA.debugLineNum = 293;BA.debugLine="Dim textWidth As Int = canvas.MeasureStringWidth";
Debug.ShouldStop(16);
_textwidth = BA.numberCast(int.class, _canvas.runMethod(true,"MeasureStringWidth",(Object)(_testline),(Object)(checkbargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(_fontsize)));Debug.locals.put("textWidth", _textwidth);Debug.locals.put("textWidth", _textwidth);
 BA.debugLineNum = 295;BA.debugLine="If textWidth > maxWidth And line <> \"\" Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean(">",_textwidth,BA.numberCast(double.class, _maxwidth)) && RemoteObject.solveBoolean("!",_line,BA.ObjectToString(""))) { 
 BA.debugLineNum = 297;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEF";
Debug.ShouldStop(256);
_canvas.runVoidMethod ("DrawTextRotated",__ref.getField(false, "ba"),(Object)(_line),(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, _y)),(Object)(checkbargraph.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD")),(Object)(_fontsize),(Object)(_color),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),_alignment)),(Object)(_angle));
 BA.debugLineNum = 298;BA.debugLine="y = y + lineHeight ' Move to next line";
Debug.ShouldStop(512);
_y = RemoteObject.solve(new RemoteObject[] {_y,_lineheight}, "+",1, 1);Debug.locals.put("y", _y);
 BA.debugLineNum = 299;BA.debugLine="line = word & \" \" ' Start new line";
Debug.ShouldStop(1024);
_line = RemoteObject.concat(_word,RemoteObject.createImmutable(" "));Debug.locals.put("line", _line);
 }else {
 BA.debugLineNum = 301;BA.debugLine="line = testLine ' Add word to current line";
Debug.ShouldStop(4096);
_line = _testline;Debug.locals.put("line", _line);
 };
 }
}Debug.locals.put("word", _word);
;
 BA.debugLineNum = 306;BA.debugLine="If line <> \"\" Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("!",_line,BA.ObjectToString(""))) { 
 BA.debugLineNum = 307;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEFA";
Debug.ShouldStop(262144);
_canvas.runVoidMethod ("DrawTextRotated",__ref.getField(false, "ba"),(Object)(_line),(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, _y)),(Object)(checkbargraph.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD")),(Object)(_fontsize),(Object)(_color),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),_alignment)),(Object)(_angle));
 BA.debugLineNum = 308;BA.debugLine="y = y + lineHeight ' Move final Y position";
Debug.ShouldStop(524288);
_y = RemoteObject.solve(new RemoteObject[] {_y,_lineheight}, "+",1, 1);Debug.locals.put("y", _y);
 };
 BA.debugLineNum = 312;BA.debugLine="Return y - originalY";
Debug.ShouldStop(8388608);
if (true) return RemoteObject.solve(new RemoteObject[] {_y,_originaly}, "-",1, 1);
 BA.debugLineNum = 313;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("FormatNumberWithLabel (checkbargraph) ","checkbargraph",1,__ref.getField(false, "ba"),__ref,325);
if (RapidSub.canDelegate("formatnumberwithlabel")) { return __ref.runUserSub(false, "checkbargraph","formatnumberwithlabel", __ref, _number);}
Debug.locals.put("number", _number);
 BA.debugLineNum = 325;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
Debug.ShouldStop(16);
 BA.debugLineNum = 326;BA.debugLine="If number >= 1000000 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000000))) { 
 BA.debugLineNum = 327;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
Debug.ShouldStop(64);
if (true) return RemoteObject.concat(checkbargraph.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000000)}, "/",0, 0))),RemoteObject.createImmutable("M"));
 }else 
{ BA.debugLineNum = 328;BA.debugLine="Else If number >= 1000 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000))) { 
 BA.debugLineNum = 329;BA.debugLine="Return Floor(number / 1000) & \"k\"";
Debug.ShouldStop(256);
if (true) return RemoteObject.concat(checkbargraph.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000)}, "/",0, 0))),RemoteObject.createImmutable("k"));
 }else {
 BA.debugLineNum = 331;BA.debugLine="Return Floor(number)";
Debug.ShouldStop(1024);
if (true) return BA.NumberToString(checkbargraph.__c.runMethod(true,"Floor",(Object)(BA.numberCast(double.class, _number))));
 }}
;
 BA.debugLineNum = 333;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("FormatNumberWithSuffix (checkbargraph) ","checkbargraph",1,__ref.getField(false, "ba"),__ref,315);
if (RapidSub.canDelegate("formatnumberwithsuffix")) { return __ref.runUserSub(false, "checkbargraph","formatnumberwithsuffix", __ref, _number);}
Debug.locals.put("number", _number);
 BA.debugLineNum = 315;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 316;BA.debugLine="If number >= 1000000 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000000))) { 
 BA.debugLineNum = 317;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
Debug.ShouldStop(268435456);
if (true) return RemoteObject.concat(checkbargraph.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("M"));
 }else 
{ BA.debugLineNum = 318;BA.debugLine="Else If number >= 1000 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000))) { 
 BA.debugLineNum = 319;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
Debug.ShouldStop(1073741824);
if (true) return RemoteObject.concat(checkbargraph.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("k"));
 }else {
 BA.debugLineNum = 321;BA.debugLine="Return NumberFormat(number, 1, 0)";
Debug.ShouldStop(1);
if (true) return checkbargraph.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _number)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 0)));
 }}
;
 BA.debugLineNum = 323;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _active1,RemoteObject _panel,RemoteObject _nextbtn,RemoteObject _bckbtn,RemoteObject _sales_1,RemoteObject _sales_2,RemoteObject _sales_3,RemoteObject _comname1,RemoteObject _maxsale1,RemoteObject _legend) throws Exception{
try {
		Debug.PushSubsStack("Initialize (checkbargraph) ","checkbargraph",1,__ref.getField(false, "ba"),__ref,17);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "checkbargraph","initialize", __ref, _ba, _active1, _panel, _nextbtn, _bckbtn, _sales_1, _sales_2, _sales_3, _comname1, _maxsale1, _legend);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
RemoteObject _legendcount = RemoteObject.createImmutable(0);
RemoteObject _legendpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _color = null;
RemoteObject _legendwidth = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _barpanel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
Debug.locals.put("ba", _ba);
Debug.locals.put("Active1", _active1);
Debug.locals.put("Panel", _panel);
Debug.locals.put("nextBtn", _nextbtn);
Debug.locals.put("bckBtn", _bckbtn);
Debug.locals.put("sales_1", _sales_1);
Debug.locals.put("sales_2", _sales_2);
Debug.locals.put("sales_3", _sales_3);
Debug.locals.put("comName1", _comname1);
Debug.locals.put("maxSale1", _maxsale1);
Debug.locals.put("legend", _legend);
 BA.debugLineNum = 17;BA.debugLine="Public Sub Initialize(Active1 As Activity, Panel A";
Debug.ShouldStop(65536);
 BA.debugLineNum = 19;BA.debugLine="Active = Active1";
Debug.ShouldStop(262144);
__ref.setField ("_active" /*RemoteObject*/ ,_active1);
 BA.debugLineNum = 20;BA.debugLine="nxtBtn = nextBtn";
Debug.ShouldStop(524288);
__ref.setField ("_nxtbtn" /*RemoteObject*/ ,_nextbtn);
 BA.debugLineNum = 21;BA.debugLine="backBtn = bckBtn";
Debug.ShouldStop(1048576);
__ref.setField ("_backbtn" /*RemoteObject*/ ,_bckbtn);
 BA.debugLineNum = 22;BA.debugLine="sales = sales_1";
Debug.ShouldStop(2097152);
__ref.setField ("_sales" /*RemoteObject*/ ,_sales_1);
 BA.debugLineNum = 23;BA.debugLine="sales1 = sales_2";
Debug.ShouldStop(4194304);
__ref.setField ("_sales1" /*RemoteObject*/ ,_sales_2);
 BA.debugLineNum = 24;BA.debugLine="sales2 = sales_3";
Debug.ShouldStop(8388608);
__ref.setField ("_sales2" /*RemoteObject*/ ,_sales_3);
 BA.debugLineNum = 25;BA.debugLine="comName = comName1";
Debug.ShouldStop(16777216);
__ref.setField ("_comname" /*RemoteObject*/ ,_comname1);
 BA.debugLineNum = 26;BA.debugLine="maxSale = maxSale1";
Debug.ShouldStop(33554432);
__ref.setField ("_maxsale" /*RemoteObject*/ ,_maxsale1);
 BA.debugLineNum = 27;BA.debugLine="Panel.Initialize(\"\")";
Debug.ShouldStop(67108864);
_panel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 28;BA.debugLine="nextBtn.Initialize(\"nxtBtn\")";
Debug.ShouldStop(134217728);
_nextbtn.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("nxtBtn")));
 BA.debugLineNum = 29;BA.debugLine="bckBtn.Initialize(\"bckBtn\")";
Debug.ShouldStop(268435456);
_bckbtn.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("bckBtn")));
 BA.debugLineNum = 32;BA.debugLine="Dim legendCount As Int = legend.Length";
Debug.ShouldStop(-2147483648);
_legendcount = _legend.getField(true,"length");Debug.locals.put("legendCount", _legendcount);Debug.locals.put("legendCount", _legendcount);
 BA.debugLineNum = 35;BA.debugLine="checkBoxes = Array As CheckBox()";
Debug.ShouldStop(4);
__ref.setField ("_checkboxes" /*RemoteObject*/ ,RemoteObject.createNewArray("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper",new int[] {0},new Object[] {}));
 BA.debugLineNum = 36;BA.debugLine="checkedSales = Array As Boolean()";
Debug.ShouldStop(8);
__ref.setField ("_checkedsales" /*RemoteObject*/ ,RemoteObject.createNewArray("boolean",new int[] {0},new Object[] {}));
 BA.debugLineNum = 38;BA.debugLine="Dim checkBoxes(legendCount) As CheckBox   ' Resiz";
Debug.ShouldStop(32);
checkbargraph._checkboxes = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper", new int[] {_legendcount.<Integer>get().intValue()}, new Object[]{});__ref.setField("_checkboxes",checkbargraph._checkboxes);
 BA.debugLineNum = 39;BA.debugLine="Dim checkedSales(legendCount) As Boolean";
Debug.ShouldStop(64);
checkbargraph._checkedsales = RemoteObject.createNewArray ("boolean", new int[] {_legendcount.<Integer>get().intValue()}, new Object[]{});__ref.setField("_checkedsales",checkbargraph._checkedsales);
 BA.debugLineNum = 41;BA.debugLine="Dim legendPanel As Panel";
Debug.ShouldStop(256);
_legendpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("legendPanel", _legendpanel);
 BA.debugLineNum = 42;BA.debugLine="legendPanel.Initialize(\"\")";
Debug.ShouldStop(512);
_legendpanel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 43;BA.debugLine="legendPanel.Width = Active.Width";
Debug.ShouldStop(1024);
_legendpanel.runMethod(true,"setWidth",__ref.getField(false,"_active" /*RemoteObject*/ ).runMethod(true,"getWidth"));
 BA.debugLineNum = 44;BA.debugLine="legendPanel.Height = 50dip";
Debug.ShouldStop(2048);
_legendpanel.runMethod(true,"setHeight",checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50))));
 BA.debugLineNum = 45;BA.debugLine="Panel.AddView(legendPanel, (Panel.Width / 3.5), 0";
Debug.ShouldStop(4096);
_panel.runVoidMethod ("AddView",(Object)((_legendpanel.getObject())),(Object)(BA.numberCast(int.class, (RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(3.5)}, "/",0, 0)))),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(1.5)}, "/",0, 0))),(Object)(checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 47;BA.debugLine="Dim Color() As Int = Array As Int(Colors.Red, Col";
Debug.ShouldStop(16384);
_color = RemoteObject.createNewArray("int",new int[] {3},new Object[] {checkbargraph.__c.getField(false,"Colors").getField(true,"Red"),checkbargraph.__c.getField(false,"Colors").getField(true,"Green"),checkbargraph.__c.getField(false,"Colors").getField(true,"Blue")});Debug.locals.put("Color", _color);Debug.locals.put("Color", _color);
 BA.debugLineNum = 48;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
Debug.ShouldStop(32768);
_legendwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_legendpanel.runMethod(true,"getWidth"),_legend.getField(true,"length")}, "/",0, 0));Debug.locals.put("legendWidth", _legendwidth);Debug.locals.put("legendWidth", _legendwidth);
 BA.debugLineNum = 50;BA.debugLine="For i = 0 To legendCount - 1";
Debug.ShouldStop(131072);
{
final int step24 = 1;
final int limit24 = RemoteObject.solve(new RemoteObject[] {_legendcount,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step24 > 0 && _i <= limit24) || (step24 < 0 && _i >= limit24) ;_i = ((int)(0 + _i + step24))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 51;BA.debugLine="Dim chk As CheckBox";
Debug.ShouldStop(262144);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");Debug.locals.put("chk", _chk);
 BA.debugLineNum = 52;BA.debugLine="chk.Initialize(\"chkChange\") ' Ensure correct eve";
Debug.ShouldStop(524288);
_chk.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("chkChange")));
 BA.debugLineNum = 53;BA.debugLine="chk.Text = legend(i)";
Debug.ShouldStop(1048576);
_chk.runMethod(true,"setText",BA.ObjectToCharSequence(_legend.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 54;BA.debugLine="chk.TextSize = 10";
Debug.ShouldStop(2097152);
_chk.runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 55;BA.debugLine="chk.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(4194304);
_chk.runMethod(false,"setTypeface",checkbargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 56;BA.debugLine="chk.TextColor = Color(i)";
Debug.ShouldStop(8388608);
_chk.runMethod(true,"setTextColor",_color.getArrayElement(true,BA.numberCast(int.class, _i)));
 BA.debugLineNum = 57;BA.debugLine="chk.Tag = i";
Debug.ShouldStop(16777216);
_chk.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 58;BA.debugLine="chk.Checked = True ' Initially checked";
Debug.ShouldStop(33554432);
_chk.runMethodAndSync(true,"setChecked",checkbargraph.__c.getField(true,"True"));
 BA.debugLineNum = 60;BA.debugLine="legendPanel.AddView(chk, (legendWidth * i) + 10d";
Debug.ShouldStop(134217728);
_legendpanel.runVoidMethod ("AddView",(Object)((_chk.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_legendwidth,RemoteObject.createImmutable(_i)}, "*",0, 1)),checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "+",1, 1)),(Object)(checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(RemoteObject.solve(new RemoteObject[] {_legendwidth,checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 62;BA.debugLine="checkBoxes(i) = chk ' Store reference in global";
Debug.ShouldStop(536870912);
__ref.getField(false,"_checkboxes" /*RemoteObject*/ ).setArrayElement (_chk,BA.numberCast(int.class, _i));
 BA.debugLineNum = 63;BA.debugLine="checkedSales(i) = True";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).setArrayElement (checkbargraph.__c.getField(true,"True"),BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 66;BA.debugLine="Dim barPanel1 As Panel";
Debug.ShouldStop(2);
_barpanel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("barPanel1", _barpanel1);
 BA.debugLineNum = 67;BA.debugLine="barPanel1.Initialize(\"\")";
Debug.ShouldStop(4);
_barpanel1.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 68;BA.debugLine="Panel.AddView(barPanel1, 0, legendPanel.Height, P";
Debug.ShouldStop(8);
_panel.runVoidMethod ("AddView",(Object)((_barpanel1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_legendpanel.runMethod(true,"getHeight")),(Object)(_panel.runMethod(true,"getWidth")),(Object)(checkbargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 350)))));
 BA.debugLineNum = 69;BA.debugLine="barPanel = barPanel1";
Debug.ShouldStop(16);
__ref.setField ("_barpanel" /*RemoteObject*/ ,_barpanel1);
 BA.debugLineNum = 71;BA.debugLine="DrawGraph";
Debug.ShouldStop(64);
__ref.runClassMethod (b4a.example.checkbargraph.class, "_drawgraph" /*RemoteObject*/ );
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}