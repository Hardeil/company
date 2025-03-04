package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class bargraph_subs_0 {


public static RemoteObject  _btnback_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("btnBack_Click (bargraph) ","bargraph",1,__ref.getField(false, "ba"),__ref,202);
if (RapidSub.canDelegate("btnback_click")) { return __ref.runUserSub(false, "bargraph","btnback_click", __ref);}
 BA.debugLineNum = 202;BA.debugLine="Sub btnBack_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 203;BA.debugLine="currentPage = currentPage - 1";
Debug.ShouldStop(1024);
__ref.setField ("_currentpage" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_currentpage" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1));
 BA.debugLineNum = 204;BA.debugLine="DrawGraph(Active1, panel_l, sale_1, sale_2, sale_";
Debug.ShouldStop(2048);
__ref.runClassMethod (b4a.example.bargraph.class, "_drawgraph" /*RemoteObject*/ ,(Object)(__ref.getField(false,"_active1" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_panel_l" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_1" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_2" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_3" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_product1" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_maxsales1" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_titlestring1" /*RemoteObject*/ )));
 BA.debugLineNum = 205;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnnext_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("btnNext_Click (bargraph) ","bargraph",1,__ref.getField(false, "ba"),__ref,197);
if (RapidSub.canDelegate("btnnext_click")) { return __ref.runUserSub(false, "bargraph","btnnext_click", __ref);}
 BA.debugLineNum = 197;BA.debugLine="Sub btnNext_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 198;BA.debugLine="currentPage = currentPage + 1";
Debug.ShouldStop(32);
__ref.setField ("_currentpage" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_currentpage" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1));
 BA.debugLineNum = 199;BA.debugLine="DrawGraph(Active1, panel_l, sale_1, sale_2, sale_";
Debug.ShouldStop(64);
__ref.runClassMethod (b4a.example.bargraph.class, "_drawgraph" /*RemoteObject*/ ,(Object)(__ref.getField(false,"_active1" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_panel_l" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_1" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_2" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_3" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_product1" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_maxsales1" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_titlestring1" /*RemoteObject*/ )));
 BA.debugLineNum = 200;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chkchange_checkedchange(RemoteObject __ref,RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("chkChange_CheckedChange (bargraph) ","bargraph",1,__ref.getField(false, "ba"),__ref,207);
if (RapidSub.canDelegate("chkchange_checkedchange")) { return __ref.runUserSub(false, "bargraph","chkchange_checkedchange", __ref, _checked);}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _index = RemoteObject.createImmutable(0);
RemoteObject _checkedcount = RemoteObject.createImmutable(0);
int _i = 0;
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 207;BA.debugLine="Sub chkChange_CheckedChange(Checked As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 208;BA.debugLine="If Sender Is CheckBox Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("i",bargraph.__c.runMethod(false,"Sender",__ref.getField(false, "ba")), RemoteObject.createImmutable("android.widget.CheckBox"))) { 
 BA.debugLineNum = 209;BA.debugLine="Dim chk As CheckBox = Sender";
Debug.ShouldStop(65536);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper"), bargraph.__c.runMethod(false,"Sender",__ref.getField(false, "ba")));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 210;BA.debugLine="Dim index As Int = chk.Tag";
Debug.ShouldStop(131072);
_index = BA.numberCast(int.class, _chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 212;BA.debugLine="Dim checkedCount As Int = 0";
Debug.ShouldStop(524288);
_checkedcount = BA.numberCast(int.class, 0);Debug.locals.put("checkedCount", _checkedcount);Debug.locals.put("checkedCount", _checkedcount);
 BA.debugLineNum = 213;BA.debugLine="For i = 0 To checkedSales.Length - 1";
Debug.ShouldStop(1048576);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 214;BA.debugLine="If checkedSales(i) = True Then checkedCount = c";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)),bargraph.__c.getField(true,"True"))) { 
_checkedcount = RemoteObject.solve(new RemoteObject[] {_checkedcount,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("checkedCount", _checkedcount);};
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 217;BA.debugLine="If Checked = False And checkedCount = 1 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_checked,bargraph.__c.getField(true,"False")) && RemoteObject.solveBoolean("=",_checkedcount,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 218;BA.debugLine="chk.Checked = True";
Debug.ShouldStop(33554432);
_chk.runMethodAndSync(true,"setChecked",bargraph.__c.getField(true,"True"));
 BA.debugLineNum = 219;BA.debugLine="Return";
Debug.ShouldStop(67108864);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 222;BA.debugLine="checkedSales(index) = Checked";
Debug.ShouldStop(536870912);
__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).setArrayElement (_checked,_index);
 BA.debugLineNum = 223;BA.debugLine="DrawGraph(Active1, panel_l, sale_1, sale_2, sale";
Debug.ShouldStop(1073741824);
__ref.runClassMethod (b4a.example.bargraph.class, "_drawgraph" /*RemoteObject*/ ,(Object)(__ref.getField(false,"_active1" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_panel_l" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_1" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_2" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_3" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_product1" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_maxsales1" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_titlestring1" /*RemoteObject*/ )));
 BA.debugLineNum = 224;BA.debugLine="panel_l.Invalidate";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_panel_l" /*RemoteObject*/ ).runVoidMethod ("Invalidate");
 }else {
 BA.debugLineNum = 226;BA.debugLine="Log(\"Error: Sender is not a CheckBox\")";
Debug.ShouldStop(2);
bargraph.__c.runVoidMethod ("LogImpl","8917523",RemoteObject.createImmutable("Error: Sender is not a CheckBox"),0);
 };
 BA.debugLineNum = 228;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
 //BA.debugLineNum = 4;BA.debugLine="Dim color() As Int = Array As Int(Colors.RGB(255,";
bargraph._color = RemoteObject.createNewArray("int",new int[] {3},new Object[] {bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))),bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 200)),(Object)(BA.numberCast(int.class, 20)),(Object)(BA.numberCast(int.class, 20))),bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 10)))});__ref.setField("_color",bargraph._color);
 //BA.debugLineNum = 5;BA.debugLine="Dim legendPanel As Panel";
bargraph._legendpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_legendpanel",bargraph._legendpanel);
 //BA.debugLineNum = 6;BA.debugLine="Dim Active1 As Activity";
bargraph._active1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ActivityWrapper");__ref.setField("_active1",bargraph._active1);
 //BA.debugLineNum = 7;BA.debugLine="Dim panel_l As Panel";
bargraph._panel_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_panel_l",bargraph._panel_l);
 //BA.debugLineNum = 8;BA.debugLine="Dim sale_1() As Int";
bargraph._sale_1 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});__ref.setField("_sale_1",bargraph._sale_1);
 //BA.debugLineNum = 9;BA.debugLine="Dim sale_2() As Int";
bargraph._sale_2 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});__ref.setField("_sale_2",bargraph._sale_2);
 //BA.debugLineNum = 10;BA.debugLine="Dim sale_3() As Int";
bargraph._sale_3 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});__ref.setField("_sale_3",bargraph._sale_3);
 //BA.debugLineNum = 11;BA.debugLine="Dim product1() As String";
bargraph._product1 = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});__ref.setField("_product1",bargraph._product1);
 //BA.debugLineNum = 12;BA.debugLine="Dim legend1() As String";
bargraph._legend1 = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});__ref.setField("_legend1",bargraph._legend1);
 //BA.debugLineNum = 13;BA.debugLine="Dim maxSales1 As Int = 0";
bargraph._maxsales1 = BA.numberCast(int.class, 0);__ref.setField("_maxsales1",bargraph._maxsales1);
 //BA.debugLineNum = 14;BA.debugLine="Dim titleString1 As String = \"\"";
bargraph._titlestring1 = BA.ObjectToString("");__ref.setField("_titlestring1",bargraph._titlestring1);
 //BA.debugLineNum = 15;BA.debugLine="Dim comId1() As Int";
bargraph._comid1 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});__ref.setField("_comid1",bargraph._comid1);
 //BA.debugLineNum = 17;BA.debugLine="Private currentPage As Int = 1";
bargraph._currentpage = BA.numberCast(int.class, 1);__ref.setField("_currentpage",bargraph._currentpage);
 //BA.debugLineNum = 18;BA.debugLine="Private itemsPerPage As Int = 5 ' Adjust this bas";
bargraph._itemsperpage = BA.numberCast(int.class, 5);__ref.setField("_itemsperpage",bargraph._itemsperpage);
 //BA.debugLineNum = 19;BA.debugLine="Private btnNext As Button";
bargraph._btnnext = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");__ref.setField("_btnnext",bargraph._btnnext);
 //BA.debugLineNum = 20;BA.debugLine="Private btnBack As Button";
bargraph._btnback = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");__ref.setField("_btnback",bargraph._btnback);
 //BA.debugLineNum = 21;BA.debugLine="Dim layout As String = \"\"";
bargraph._layout = BA.ObjectToString("");__ref.setField("_layout",bargraph._layout);
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _drawgraph(RemoteObject __ref,RemoteObject _active,RemoteObject _panel,RemoteObject _sale1,RemoteObject _sale2,RemoteObject _sale3,RemoteObject _product,RemoteObject _maxsales,RemoteObject _titlestring) throws Exception{
try {
		Debug.PushSubsStack("DrawGraph (bargraph) ","bargraph",1,__ref.getField(false, "ba"),__ref,75);
if (RapidSub.canDelegate("drawgraph")) { return __ref.runUserSub(false, "bargraph","drawgraph", __ref, _active, _panel, _sale1, _sale2, _sale3, _product, _maxsales, _titlestring);}
RemoteObject _activitypanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _alignleftcenter = RemoteObject.createImmutable(0);
RemoteObject _aligntopcenter = RemoteObject.createImmutable(0);
RemoteObject _title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _graphcanvas = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _maxsale = RemoteObject.createImmutable(0);
RemoteObject _cv = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _totalproducts = RemoteObject.createImmutable(0);
RemoteObject _startindex = RemoteObject.createImmutable(0);
RemoteObject _endindex = RemoteObject.createImmutable(0);
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
RemoteObject _productlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _productlabely = RemoteObject.createImmutable(0);
RemoteObject _productlabelx = RemoteObject.createImmutable(0);
RemoteObject _numlabels = RemoteObject.createImmutable(0);
RemoteObject _labelvalue = RemoteObject.createImmutable(0);
RemoteObject _labelypos = RemoteObject.createImmutable(0);
RemoteObject _cdback = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _cdnext = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
Debug.locals.put("Active", _active);
Debug.locals.put("panel", _panel);
Debug.locals.put("sale1", _sale1);
Debug.locals.put("sale2", _sale2);
Debug.locals.put("sale3", _sale3);
Debug.locals.put("product", _product);
Debug.locals.put("maxSales", _maxsales);
Debug.locals.put("TitleString", _titlestring);
 BA.debugLineNum = 75;BA.debugLine="Sub DrawGraph(Active As Activity, panel As Panel,";
Debug.ShouldStop(1024);
 BA.debugLineNum = 76;BA.debugLine="panel.Invalidate";
Debug.ShouldStop(2048);
_panel.runVoidMethod ("Invalidate");
 BA.debugLineNum = 77;BA.debugLine="panel.RemoveAllViews";
Debug.ShouldStop(4096);
_panel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 78;BA.debugLine="panel.Height = 450dip ' Increased height to accom";
Debug.ShouldStop(8192);
_panel.runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 450))));
 BA.debugLineNum = 80;BA.debugLine="panel.AddView(legendPanel, 0, 0, panel.Width, 30d";
Debug.ShouldStop(32768);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_panel.runMethod(true,"getWidth")),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 81;BA.debugLine="Dim activityPanel As Panel";
Debug.ShouldStop(65536);
_activitypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("activityPanel", _activitypanel);
 BA.debugLineNum = 82;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
Debug.ShouldStop(131072);
_activitypanel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("activityPanel")));
 BA.debugLineNum = 84;BA.debugLine="activityPanel.Width = 80%x";
Debug.ShouldStop(524288);
_activitypanel.runMethod(true,"setWidth",bargraph.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),__ref.getField(false, "ba")));
 BA.debugLineNum = 85;BA.debugLine="If Active.Width > 800 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean(">",_active.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 86;BA.debugLine="activityPanel.Width = 55%x";
Debug.ShouldStop(2097152);
_activitypanel.runMethod(true,"setWidth",bargraph.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 55)),__ref.getField(false, "ba")));
 };
 BA.debugLineNum = 88;BA.debugLine="activityPanel.Height = 250dip";
Debug.ShouldStop(8388608);
_activitypanel.runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))));
 BA.debugLineNum = 89;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
Debug.ShouldStop(16777216);
_activitypanel.runVoidMethod ("setColor",bargraph.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 70)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211))));
 BA.debugLineNum = 91;BA.debugLine="Dim alignLeftCenter As Int = (Active.Width - acti";
Debug.ShouldStop(67108864);
_alignleftcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_active.runMethod(true,"getWidth"),_activitypanel.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignLeftCenter", _alignleftcenter);Debug.locals.put("alignLeftCenter", _alignleftcenter);
 BA.debugLineNum = 92;BA.debugLine="Dim alignTopCenter As Int = (panel.Height - activ";
Debug.ShouldStop(134217728);
_aligntopcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getHeight"),_activitypanel.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "/-",1, 0));Debug.locals.put("alignTopCenter", _aligntopcenter);Debug.locals.put("alignTopCenter", _aligntopcenter);
 BA.debugLineNum = 94;BA.debugLine="Dim Title As Label";
Debug.ShouldStop(536870912);
_title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Title", _title);
 BA.debugLineNum = 95;BA.debugLine="Title.Initialize(\"\")";
Debug.ShouldStop(1073741824);
_title.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 96;BA.debugLine="Title.Text = TitleString";
Debug.ShouldStop(-2147483648);
_title.runMethod(true,"setText",BA.ObjectToCharSequence(_titlestring));
 BA.debugLineNum = 97;BA.debugLine="Title.TextSize = 20";
Debug.ShouldStop(1);
_title.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 98;BA.debugLine="Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(2);
_title.runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 99;BA.debugLine="Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(4);
_title.runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 100;BA.debugLine="Title.TextColor = Colors.Black";
Debug.ShouldStop(8);
_title.runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 101;BA.debugLine="panel.AddView(Title, 0, alignTopCenter / 2, panel";
Debug.ShouldStop(16);
_panel.runVoidMethod ("AddView",(Object)((_title.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_aligntopcenter,RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(_panel.runMethod(true,"getWidth")),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 103;BA.debugLine="panel.AddView(activityPanel, alignLeftCenter, ali";
Debug.ShouldStop(64);
_panel.runVoidMethod ("AddView",(Object)((_activitypanel.getObject())),(Object)(_alignleftcenter),(Object)(_aligntopcenter),(Object)(_activitypanel.runMethod(true,"getWidth")),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 105;BA.debugLine="Dim graphCanvas As Canvas";
Debug.ShouldStop(256);
_graphcanvas = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("graphCanvas", _graphcanvas);
 BA.debugLineNum = 106;BA.debugLine="graphCanvas.Initialize(activityPanel)";
Debug.ShouldStop(512);
_graphcanvas.runVoidMethod ("Initialize",(Object)((_activitypanel.getObject())));
 BA.debugLineNum = 108;BA.debugLine="Dim maxSale As Int = maxSales * 1.2";
Debug.ShouldStop(2048);
_maxsale = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_maxsales,RemoteObject.createImmutable(1.2)}, "*",0, 0));Debug.locals.put("maxSale", _maxsale);Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 109;BA.debugLine="Dim cv As Canvas";
Debug.ShouldStop(4096);
_cv = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cv", _cv);
 BA.debugLineNum = 110;BA.debugLine="cv.Initialize(panel)";
Debug.ShouldStop(8192);
_cv.runVoidMethod ("Initialize",(Object)((_panel.getObject())));
 BA.debugLineNum = 113;BA.debugLine="Dim totalProducts As Int = sale1.Length";
Debug.ShouldStop(65536);
_totalproducts = _sale1.getField(true,"length");Debug.locals.put("totalProducts", _totalproducts);Debug.locals.put("totalProducts", _totalproducts);
 BA.debugLineNum = 114;BA.debugLine="Dim startIndex As Int = (currentPage - 1) * items";
Debug.ShouldStop(131072);
_startindex = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_currentpage" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1)),__ref.getField(true,"_itemsperpage" /*RemoteObject*/ )}, "*",0, 1);Debug.locals.put("startIndex", _startindex);Debug.locals.put("startIndex", _startindex);
 BA.debugLineNum = 115;BA.debugLine="Dim endIndex As Int = Min(startIndex + itemsPerPa";
Debug.ShouldStop(262144);
_endindex = BA.numberCast(int.class, bargraph.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_startindex,__ref.getField(true,"_itemsperpage" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+-",2, 1))),(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_totalproducts,RemoteObject.createImmutable(1)}, "-",1, 1)))));Debug.locals.put("endIndex", _endindex);Debug.locals.put("endIndex", _endindex);
 BA.debugLineNum = 116;BA.debugLine="Dim barsPerProduct As Int = 3";
Debug.ShouldStop(524288);
_barsperproduct = BA.numberCast(int.class, 3);Debug.locals.put("barsPerProduct", _barsperproduct);Debug.locals.put("barsPerProduct", _barsperproduct);
 BA.debugLineNum = 117;BA.debugLine="Dim totalBars As Int = (endIndex - startIndex + 1";
Debug.ShouldStop(1048576);
_totalbars = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_endindex,_startindex,RemoteObject.createImmutable(1)}, "-+",2, 1)),_barsperproduct}, "*",0, 1);Debug.locals.put("totalBars", _totalbars);Debug.locals.put("totalBars", _totalbars);
 BA.debugLineNum = 118;BA.debugLine="Dim gap As Int = 5dip";
Debug.ShouldStop(2097152);
_gap = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("gap", _gap);Debug.locals.put("gap", _gap);
 BA.debugLineNum = 119;BA.debugLine="Dim productGap As Int = 0dip";
Debug.ShouldStop(4194304);
_productgap = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("productGap", _productgap);Debug.locals.put("productGap", _productgap);
 BA.debugLineNum = 120;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(8388608);
_padding = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 122;BA.debugLine="Dim availableWidth As Int = activityPanel.Width -";
Debug.ShouldStop(33554432);
_availablewidth = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_padding,RemoteObject.createImmutable(2)}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_endindex,_startindex,RemoteObject.createImmutable(1)}, "-+",2, 1)),RemoteObject.createImmutable(1)}, "-",1, 1)),_productgap}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_totalbars,(RemoteObject.solve(new RemoteObject[] {_endindex,_startindex,RemoteObject.createImmutable(1)}, "-+",2, 1))}, "-",1, 1)),_gap}, "*",0, 1))}, "---",3, 1);Debug.locals.put("availableWidth", _availablewidth);Debug.locals.put("availableWidth", _availablewidth);
 BA.debugLineNum = 123;BA.debugLine="Dim barWidth As Int = availableWidth / totalBars";
Debug.ShouldStop(67108864);
_barwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_availablewidth,_totalbars}, "/",0, 0));Debug.locals.put("barWidth", _barwidth);Debug.locals.put("barWidth", _barwidth);
 BA.debugLineNum = 124;BA.debugLine="Dim xStart As Int = padding";
Debug.ShouldStop(134217728);
_xstart = _padding;Debug.locals.put("xStart", _xstart);Debug.locals.put("xStart", _xstart);
 BA.debugLineNum = 126;BA.debugLine="For i = startIndex To endIndex";
Debug.ShouldStop(536870912);
{
final int step40 = 1;
final int limit40 = _endindex.<Integer>get().intValue();
_i = _startindex.<Integer>get().intValue() ;
for (;(step40 > 0 && _i <= limit40) || (step40 < 0 && _i >= limit40) ;_i = ((int)(0 + _i + step40))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 127;BA.debugLine="Dim xPos As Int = xStart + (i - startIndex) * (b";
Debug.ShouldStop(1073741824);
_xpos = RemoteObject.solve(new RemoteObject[] {_xstart,(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),_startindex}, "-",1, 1)),(RemoteObject.solve(new RemoteObject[] {_barsperproduct,(RemoteObject.solve(new RemoteObject[] {_barwidth,_gap}, "+",1, 1)),_productgap}, "*+",1, 1))}, "+*",1, 1);Debug.locals.put("xPos", _xpos);Debug.locals.put("xPos", _xpos);
 BA.debugLineNum = 128;BA.debugLine="Dim saleValues() As Int = Array As Int(sale1(i),";
Debug.ShouldStop(-2147483648);
_salevalues = RemoteObject.createNewArray("int",new int[] {3},new Object[] {_sale1.getArrayElement(true,BA.numberCast(int.class, _i)),_sale2.getArrayElement(true,BA.numberCast(int.class, _i)),_sale3.getArrayElement(true,BA.numberCast(int.class, _i))});Debug.locals.put("saleValues", _salevalues);Debug.locals.put("saleValues", _salevalues);
 BA.debugLineNum = 129;BA.debugLine="Dim indexOffset As Int = 0";
Debug.ShouldStop(1);
_indexoffset = BA.numberCast(int.class, 0);Debug.locals.put("indexOffset", _indexoffset);Debug.locals.put("indexOffset", _indexoffset);
 BA.debugLineNum = 131;BA.debugLine="For j = 0 To barsPerProduct - 1";
Debug.ShouldStop(4);
{
final int step44 = 1;
final int limit44 = RemoteObject.solve(new RemoteObject[] {_barsperproduct,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_j = 0 ;
for (;(step44 > 0 && _j <= limit44) || (step44 < 0 && _j >= limit44) ;_j = ((int)(0 + _j + step44))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 132;BA.debugLine="If j < checkedSales.Length And checkedSales(j)";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("<",RemoteObject.createImmutable(_j),BA.numberCast(double.class, __ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getField(true,"length"))) && RemoteObject.solveBoolean(".",__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _j)))) { 
 BA.debugLineNum = 133;BA.debugLine="Dim sale As Int = saleValues(j)";
Debug.ShouldStop(16);
_sale = _salevalues.getArrayElement(true,BA.numberCast(int.class, _j));Debug.locals.put("sale", _sale);Debug.locals.put("sale", _sale);
 BA.debugLineNum = 134;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * (act";
Debug.ShouldStop(32);
_barheight = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_sale,_maxsale}, "/",0, 0)),(_activitypanel.runMethod(true,"getHeight"))}, "*",0, 0));Debug.locals.put("barHeight", _barheight);Debug.locals.put("barHeight", _barheight);
 BA.debugLineNum = 135;BA.debugLine="Dim xBar As Int = xPos + indexOffset * barWidt";
Debug.ShouldStop(64);
_xbar = RemoteObject.solve(new RemoteObject[] {_xpos,_indexoffset,_barwidth}, "+*",1, 1);Debug.locals.put("xBar", _xbar);Debug.locals.put("xBar", _xbar);
 BA.debugLineNum = 137;BA.debugLine="Dim r As Rect";
Debug.ShouldStop(256);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r", _r);
 BA.debugLineNum = 138;BA.debugLine="r.Initialize(xBar, activityPanel.Height - barH";
Debug.ShouldStop(512);
_r.runVoidMethod ("Initialize",(Object)(_xbar),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_xbar,_barwidth}, "+",1, 1)),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 139;BA.debugLine="graphCanvas.DrawRect(r, color(j), True, 2dip)";
Debug.ShouldStop(1024);
_graphcanvas.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(__ref.getField(false,"_color" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _j))),(Object)(bargraph.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 141;BA.debugLine="Dim fontSize As Int = 8";
Debug.ShouldStop(4096);
_fontsize = BA.numberCast(int.class, 8);Debug.locals.put("fontSize", _fontsize);Debug.locals.put("fontSize", _fontsize);
 BA.debugLineNum = 142;BA.debugLine="If Active.Width > 800 Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean(">",_active.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 143;BA.debugLine="fontSize = 10";
Debug.ShouldStop(16384);
_fontsize = BA.numberCast(int.class, 10);Debug.locals.put("fontSize", _fontsize);
 };
 BA.debugLineNum = 145;BA.debugLine="graphCanvas.DrawText(FormatNumberWithSuffix(sa";
Debug.ShouldStop(65536);
_graphcanvas.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(__ref.runClassMethod (b4a.example.bargraph.class, "_formatnumberwithsuffix" /*RemoteObject*/ ,(Object)(_sale))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_xbar,(RemoteObject.solve(new RemoteObject[] {_barwidth,RemoteObject.createImmutable(2)}, "/",0, 0))}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "--",2, 1))),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, _fontsize)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("CENTER"))));
 BA.debugLineNum = 146;BA.debugLine="indexOffset = indexOffset + 1";
Debug.ShouldStop(131072);
_indexoffset = RemoteObject.solve(new RemoteObject[] {_indexoffset,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("indexOffset", _indexoffset);
 };
 }
}Debug.locals.put("j", _j);
;
 BA.debugLineNum = 150;BA.debugLine="Dim productLabel As Label";
Debug.ShouldStop(2097152);
_productlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("productLabel", _productlabel);
 BA.debugLineNum = 151;BA.debugLine="productLabel.Initialize(\"productLabel\")";
Debug.ShouldStop(4194304);
_productlabel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("productLabel")));
 BA.debugLineNum = 152;BA.debugLine="productLabel.Text = product(i)";
Debug.ShouldStop(8388608);
_productlabel.runMethod(true,"setText",BA.ObjectToCharSequence(_product.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 153;BA.debugLine="productLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(16777216);
_productlabel.runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 154;BA.debugLine="productLabel.TextSize = 12";
Debug.ShouldStop(33554432);
_productlabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 155;BA.debugLine="productLabel.Tag = comId1(i)";
Debug.ShouldStop(67108864);
_productlabel.runMethod(false,"setTag",(__ref.getField(false,"_comid1" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 156;BA.debugLine="productLabel.TextColor = Colors.Black";
Debug.ShouldStop(134217728);
_productlabel.runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 157;BA.debugLine="productLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(268435456);
_productlabel.runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 158;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
Debug.ShouldStop(536870912);
_productlabely = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1);Debug.locals.put("productLabelY", _productlabely);Debug.locals.put("productLabelY", _productlabely);
 BA.debugLineNum = 159;BA.debugLine="Dim productLabelX As Int = alignLeftCenter";
Debug.ShouldStop(1073741824);
_productlabelx = _alignleftcenter;Debug.locals.put("productLabelX", _productlabelx);Debug.locals.put("productLabelX", _productlabelx);
 BA.debugLineNum = 160;BA.debugLine="panel.AddView(productLabel, xPos + productLabelX";
Debug.ShouldStop(-2147483648);
_panel.runVoidMethod ("AddView",(Object)((_productlabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_xpos,_productlabelx}, "+",1, 1)),(Object)(_productlabely),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 164;BA.debugLine="Dim numLabels As Int = 10";
Debug.ShouldStop(8);
_numlabels = BA.numberCast(int.class, 10);Debug.locals.put("numLabels", _numlabels);Debug.locals.put("numLabels", _numlabels);
 BA.debugLineNum = 165;BA.debugLine="For i = 0 To numLabels";
Debug.ShouldStop(16);
{
final int step73 = 1;
final int limit73 = _numlabels.<Integer>get().intValue();
_i = 0 ;
for (;(step73 > 0 && _i <= limit73) || (step73 < 0 && _i >= limit73) ;_i = ((int)(0 + _i + step73))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 166;BA.debugLine="Dim labelValue As Int = Round((maxSale / numLabe";
Debug.ShouldStop(32);
_labelvalue = BA.numberCast(int.class, bargraph.__c.runMethod(true,"Round",(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_maxsale,_numlabels}, "/",0, 0)),RemoteObject.createImmutable(_i)}, "*",0, 0))));Debug.locals.put("labelValue", _labelvalue);Debug.locals.put("labelValue", _labelvalue);
 BA.debugLineNum = 167;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ((";
Debug.ShouldStop(64);
_labelypos = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_labelvalue,_maxsale}, "/",0, 0)),_activitypanel.runMethod(true,"getHeight")}, "*",0, 0))}, "-",1, 0));Debug.locals.put("labelYPos", _labelypos);Debug.locals.put("labelYPos", _labelypos);
 BA.debugLineNum = 168;BA.debugLine="cv.DrawText(FormatNumberWithLabel(labelValue), a";
Debug.ShouldStop(128);
_cv.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(__ref.runClassMethod (b4a.example.bargraph.class, "_formatnumberwithlabel" /*RemoteObject*/ ,(Object)(_labelvalue))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_alignleftcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_labelypos,_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "++",2, 1))),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, 10)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("RIGHT"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 172;BA.debugLine="btnBack.Initialize(\"btnBack\")";
Debug.ShouldStop(2048);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("btnBack")));
 BA.debugLineNum = 173;BA.debugLine="btnBack.Text = \"Back\"";
Debug.ShouldStop(4096);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence("Back"));
 BA.debugLineNum = 174;BA.debugLine="btnBack.TextSize = 14";
Debug.ShouldStop(8192);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 175;BA.debugLine="btnBack.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(16384);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 176;BA.debugLine="btnBack.TextColor = Colors.White";
Debug.ShouldStop(32768);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 177;BA.debugLine="Dim cdBack As ColorDrawable";
Debug.ShouldStop(65536);
_cdback = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cdBack", _cdback);
 BA.debugLineNum = 178;BA.debugLine="cdBack.Initialize2(Colors.RGB(61, 12, 2), 10dip,";
Debug.ShouldStop(131072);
_cdback.runVoidMethod ("Initialize2",(Object)(bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 179;BA.debugLine="btnBack.Background = cdBack";
Debug.ShouldStop(262144);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(false,"setBackground",(_cdback.getObject()));
 BA.debugLineNum = 180;BA.debugLine="panel.AddView(btnBack, alignLeftCenter, activityP";
Debug.ShouldStop(524288);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_btnback" /*RemoteObject*/ ).getObject())),(Object)(_alignleftcenter),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "++",2, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 182;BA.debugLine="btnNext.Initialize(\"btnNext\")";
Debug.ShouldStop(2097152);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("btnNext")));
 BA.debugLineNum = 183;BA.debugLine="btnNext.Text = \"Next\"";
Debug.ShouldStop(4194304);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence("Next"));
 BA.debugLineNum = 184;BA.debugLine="btnNext.TextSize = 14";
Debug.ShouldStop(8388608);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 185;BA.debugLine="btnNext.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(16777216);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 186;BA.debugLine="btnNext.TextColor = Colors.White";
Debug.ShouldStop(33554432);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 187;BA.debugLine="Dim cdNext As ColorDrawable";
Debug.ShouldStop(67108864);
_cdnext = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cdNext", _cdnext);
 BA.debugLineNum = 188;BA.debugLine="cdNext.Initialize2(Colors.RGB(185, 46, 52), 10dip";
Debug.ShouldStop(134217728);
_cdnext.runVoidMethod ("Initialize2",(Object)(bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 185)),(Object)(BA.numberCast(int.class, 46)),(Object)(BA.numberCast(int.class, 52)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 189;BA.debugLine="btnNext.Background = cdNext";
Debug.ShouldStop(268435456);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(false,"setBackground",(_cdnext.getObject()));
 BA.debugLineNum = 190;BA.debugLine="panel.AddView(btnNext, panel.Width - alignLeftCen";
Debug.ShouldStop(536870912);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_btnnext" /*RemoteObject*/ ).getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),_alignleftcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))}, "--",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "++",2, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 193;BA.debugLine="btnBack.Enabled = (currentPage > 1)";
Debug.ShouldStop(1);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(true,"setEnabled",BA.ObjectToBoolean((RemoteObject.solveBoolean(">",__ref.getField(true,"_currentpage" /*RemoteObject*/ ),BA.numberCast(double.class, 1)))));
 BA.debugLineNum = 194;BA.debugLine="btnNext.Enabled = (endIndex < totalProducts - 1)";
Debug.ShouldStop(2);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(true,"setEnabled",BA.ObjectToBoolean((RemoteObject.solveBoolean("<",_endindex,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_totalproducts,RemoteObject.createImmutable(1)}, "-",1, 1))))));
 BA.debugLineNum = 195;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("FormatNumberWithLabel (bargraph) ","bargraph",1,__ref.getField(false, "ba"),__ref,249);
if (RapidSub.canDelegate("formatnumberwithlabel")) { return __ref.runUserSub(false, "bargraph","formatnumberwithlabel", __ref, _number);}
Debug.locals.put("number", _number);
 BA.debugLineNum = 249;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 250;BA.debugLine="If number >= 1000000 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000000))) { 
 BA.debugLineNum = 251;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
Debug.ShouldStop(67108864);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000000)}, "/",0, 0))),RemoteObject.createImmutable("M"));
 }else 
{ BA.debugLineNum = 252;BA.debugLine="Else If number >= 1000 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000))) { 
 BA.debugLineNum = 253;BA.debugLine="Return Floor(number / 1000) & \"k\"";
Debug.ShouldStop(268435456);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000)}, "/",0, 0))),RemoteObject.createImmutable("k"));
 }else {
 BA.debugLineNum = 255;BA.debugLine="Return number";
Debug.ShouldStop(1073741824);
Debug.CheckDeviceExceptions();if (true) return BA.NumberToString(_number);
 }}
;
 BA.debugLineNum = 257;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("FormatNumberWithSuffix (bargraph) ","bargraph",1,__ref.getField(false, "ba"),__ref,239);
if (RapidSub.canDelegate("formatnumberwithsuffix")) { return __ref.runUserSub(false, "bargraph","formatnumberwithsuffix", __ref, _number);}
Debug.locals.put("number", _number);
 BA.debugLineNum = 239;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
Debug.ShouldStop(16384);
 BA.debugLineNum = 240;BA.debugLine="If number >= 1000000 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000000))) { 
 BA.debugLineNum = 241;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
Debug.ShouldStop(65536);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("M"));
 }else 
{ BA.debugLineNum = 242;BA.debugLine="Else If number >= 1000 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000))) { 
 BA.debugLineNum = 243;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
Debug.ShouldStop(262144);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("k"));
 }else {
 BA.debugLineNum = 245;BA.debugLine="Return NumberFormat(number, 1, 0)";
Debug.ShouldStop(1048576);
Debug.CheckDeviceExceptions();if (true) return bargraph.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _number)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 0)));
 }}
;
 BA.debugLineNum = 247;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _active,RemoteObject _panel,RemoteObject _sale1,RemoteObject _sale2,RemoteObject _sale3,RemoteObject _product,RemoteObject _legend,RemoteObject _maxsales,RemoteObject _titlestring,RemoteObject _comid,RemoteObject _layout1) throws Exception{
try {
		Debug.PushSubsStack("Initialize (bargraph) ","bargraph",1,__ref.getField(false, "ba"),__ref,24);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "bargraph","initialize", __ref, _ba, _active, _panel, _sale1, _sale2, _sale3, _product, _legend, _maxsales, _titlestring, _comid, _layout1);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
RemoteObject _legendwidth = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
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
Debug.locals.put("comId", _comid);
Debug.locals.put("layout1", _layout1);
 BA.debugLineNum = 24;BA.debugLine="Public Sub Initialize(Active As Activity, panel As";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="Active1 = Active";
Debug.ShouldStop(16777216);
__ref.setField ("_active1" /*RemoteObject*/ ,_active);
 BA.debugLineNum = 26;BA.debugLine="panel_l = panel";
Debug.ShouldStop(33554432);
__ref.setField ("_panel_l" /*RemoteObject*/ ,_panel);
 BA.debugLineNum = 27;BA.debugLine="sale_1 = sale1";
Debug.ShouldStop(67108864);
__ref.setField ("_sale_1" /*RemoteObject*/ ,_sale1);
 BA.debugLineNum = 28;BA.debugLine="sale_2 = sale2";
Debug.ShouldStop(134217728);
__ref.setField ("_sale_2" /*RemoteObject*/ ,_sale2);
 BA.debugLineNum = 29;BA.debugLine="sale_3 = sale3";
Debug.ShouldStop(268435456);
__ref.setField ("_sale_3" /*RemoteObject*/ ,_sale3);
 BA.debugLineNum = 30;BA.debugLine="product1 = product";
Debug.ShouldStop(536870912);
__ref.setField ("_product1" /*RemoteObject*/ ,_product);
 BA.debugLineNum = 31;BA.debugLine="legend1 = legend";
Debug.ShouldStop(1073741824);
__ref.setField ("_legend1" /*RemoteObject*/ ,_legend);
 BA.debugLineNum = 32;BA.debugLine="maxSales1 = maxSales";
Debug.ShouldStop(-2147483648);
__ref.setField ("_maxsales1" /*RemoteObject*/ ,_maxsales);
 BA.debugLineNum = 33;BA.debugLine="titleString1 = TitleString";
Debug.ShouldStop(1);
__ref.setField ("_titlestring1" /*RemoteObject*/ ,_titlestring);
 BA.debugLineNum = 34;BA.debugLine="comId1 = comId";
Debug.ShouldStop(2);
__ref.setField ("_comid1" /*RemoteObject*/ ,_comid);
 BA.debugLineNum = 35;BA.debugLine="layout = layout1";
Debug.ShouldStop(4);
__ref.setField ("_layout" /*RemoteObject*/ ,_layout1);
 BA.debugLineNum = 36;BA.debugLine="If sale1.Length <> product.Length Or sale2.Length";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("!",_sale1.getField(true,"length"),BA.numberCast(double.class, _product.getField(true,"length"))) || RemoteObject.solveBoolean("!",_sale2.getField(true,"length"),BA.numberCast(double.class, _product.getField(true,"length"))) || RemoteObject.solveBoolean("!",_sale3.getField(true,"length"),BA.numberCast(double.class, _product.getField(true,"length")))) { 
 BA.debugLineNum = 37;BA.debugLine="Return ' Exit if validation fails";
Debug.ShouldStop(16);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 40;BA.debugLine="legendPanel.Initialize(\"\")";
Debug.ShouldStop(128);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 41;BA.debugLine="legendPanel.Width = panel.Width";
Debug.ShouldStop(256);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"setWidth",_panel.runMethod(true,"getWidth"));
 BA.debugLineNum = 42;BA.debugLine="legendPanel.Height = 30dip";
Debug.ShouldStop(512);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 44;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
Debug.ShouldStop(2048);
_legendwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"getWidth"),_legend.getField(true,"length")}, "/",0, 0));Debug.locals.put("legendWidth", _legendwidth);Debug.locals.put("legendWidth", _legendwidth);
 BA.debugLineNum = 45;BA.debugLine="checkBoxes = Array As CheckBox()";
Debug.ShouldStop(4096);
__ref.setField ("_checkboxes" /*RemoteObject*/ ,RemoteObject.createNewArray("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper",new int[] {0},new Object[] {}));
 BA.debugLineNum = 46;BA.debugLine="checkedSales = Array As Boolean()";
Debug.ShouldStop(8192);
__ref.setField ("_checkedsales" /*RemoteObject*/ ,RemoteObject.createNewArray("boolean",new int[] {0},new Object[] {}));
 BA.debugLineNum = 48;BA.debugLine="Dim checkBoxes(legend.Length) As CheckBox   ' Res";
Debug.ShouldStop(32768);
bargraph._checkboxes = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper", new int[] {_legend.getField(true,"length").<Integer>get().intValue()}, new Object[]{});__ref.setField("_checkboxes",bargraph._checkboxes);
 BA.debugLineNum = 49;BA.debugLine="Dim checkedSales(legend.Length) As Boolean";
Debug.ShouldStop(65536);
bargraph._checkedsales = RemoteObject.createNewArray ("boolean", new int[] {_legend.getField(true,"length").<Integer>get().intValue()}, new Object[]{});__ref.setField("_checkedsales",bargraph._checkedsales);
 BA.debugLineNum = 50;BA.debugLine="For i = 0 To legend.Length - 1";
Debug.ShouldStop(131072);
{
final int step23 = 1;
final int limit23 = RemoteObject.solve(new RemoteObject[] {_legend.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step23 > 0 && _i <= limit23) || (step23 < 0 && _i >= limit23) ;_i = ((int)(0 + _i + step23))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 56;BA.debugLine="Dim chk As CheckBox";
Debug.ShouldStop(8388608);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");Debug.locals.put("chk", _chk);
 BA.debugLineNum = 57;BA.debugLine="chk.Initialize(\"chkChange\")";
Debug.ShouldStop(16777216);
_chk.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("chkChange")));
 BA.debugLineNum = 58;BA.debugLine="chk.Text = legend(i)";
Debug.ShouldStop(33554432);
_chk.runMethod(true,"setText",BA.ObjectToCharSequence(_legend.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 59;BA.debugLine="chk.TextSize = 10";
Debug.ShouldStop(67108864);
_chk.runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 60;BA.debugLine="chk.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(134217728);
_chk.runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 61;BA.debugLine="chk.TextColor = color(i)";
Debug.ShouldStop(268435456);
_chk.runMethod(true,"setTextColor",__ref.getField(false,"_color" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)));
 BA.debugLineNum = 62;BA.debugLine="chk.Tag = i";
Debug.ShouldStop(536870912);
_chk.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 63;BA.debugLine="chk.Checked = True";
Debug.ShouldStop(1073741824);
_chk.runMethodAndSync(true,"setChecked",bargraph.__c.getField(true,"True"));
 BA.debugLineNum = 64;BA.debugLine="legendPanel.AddView(chk, (legendWidth * i) + 30d";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((_chk.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_legendwidth,RemoteObject.createImmutable(_i)}, "*",0, 1)),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "+",1, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(RemoteObject.solve(new RemoteObject[] {_legendwidth,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 1)),(Object)(__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"getHeight")));
 BA.debugLineNum = 67;BA.debugLine="checkBoxes(i) = chk ' Store reference in global";
Debug.ShouldStop(4);
__ref.getField(false,"_checkboxes" /*RemoteObject*/ ).setArrayElement (_chk,BA.numberCast(int.class, _i));
 BA.debugLineNum = 68;BA.debugLine="checkedSales(i) = True ' Ensure the checkbox is";
Debug.ShouldStop(8);
__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).setArrayElement (bargraph.__c.getField(true,"True"),BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 71;BA.debugLine="DrawGraph(Active, panel, sale1, sale2, sale3, pro";
Debug.ShouldStop(64);
__ref.runClassMethod (b4a.example.bargraph.class, "_drawgraph" /*RemoteObject*/ ,(Object)(_active),(Object)(_panel),(Object)(_sale1),(Object)(_sale2),(Object)(_sale3),(Object)(_product),(Object)(_maxsales),(Object)(_titlestring));
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
public static RemoteObject  _productlabel_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("productLabel_Click (bargraph) ","bargraph",1,__ref.getField(false, "ba"),__ref,230);
if (RapidSub.canDelegate("productlabel_click")) { return __ref.runUserSub(false, "bargraph","productlabel_click", __ref);}
RemoteObject _clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _selectedcompany = RemoteObject.createImmutable(0);
 BA.debugLineNum = 230;BA.debugLine="Sub productLabel_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 231;BA.debugLine="Dim clickedLabel As Label = Sender";
Debug.ShouldStop(64);
_clickedlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), bargraph.__c.runMethod(false,"Sender",__ref.getField(false, "ba")));Debug.locals.put("clickedLabel", _clickedlabel);Debug.locals.put("clickedLabel", _clickedlabel);
 BA.debugLineNum = 232;BA.debugLine="Dim selectedCompany As Int = clickedLabel.Tag";
Debug.ShouldStop(128);
_selectedcompany = BA.numberCast(int.class, _clickedlabel.runMethod(false,"getTag"));Debug.locals.put("selectedCompany", _selectedcompany);Debug.locals.put("selectedCompany", _selectedcompany);
 BA.debugLineNum = 233;BA.debugLine="Log(\"Selected Company ID: \" & selectedCompany)";
Debug.ShouldStop(256);
bargraph.__c.runVoidMethod ("LogImpl","8983043",RemoteObject.concat(RemoteObject.createImmutable("Selected Company ID: "),_selectedcompany),0);
 BA.debugLineNum = 234;BA.debugLine="Starter.company_selected = selectedCompany";
Debug.ShouldStop(512);
bargraph._starter._company_selected /*RemoteObject*/  = BA.NumberToString(_selectedcompany);
 BA.debugLineNum = 235;BA.debugLine="StartActivity(layout)";
Debug.ShouldStop(1024);
bargraph.__c.runVoidMethod ("StartActivity",__ref.getField(false, "ba"),(Object)((__ref.getField(true,"_layout" /*RemoteObject*/ ))));
 BA.debugLineNum = 236;BA.debugLine="Active1.Finish";
Debug.ShouldStop(2048);
__ref.getField(false,"_active1" /*RemoteObject*/ ).runVoidMethod ("Finish");
 BA.debugLineNum = 237;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}