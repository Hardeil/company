package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class bargraph_subs_0 {


public static RemoteObject  _chkchange_checkedchange(RemoteObject __ref,RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("chkChange_CheckedChange (bargraph) ","bargraph",5,__ref.getField(false, "ba"),__ref,410);
if (RapidSub.canDelegate("chkchange_checkedchange")) { return __ref.runUserSub(false, "bargraph","chkchange_checkedchange", __ref, _checked);}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _index = RemoteObject.createImmutable(0);
RemoteObject _checkedcount = RemoteObject.createImmutable(0);
int _i = 0;
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 410;BA.debugLine="Sub chkChange_CheckedChange(Checked As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 411;BA.debugLine="If Sender Is CheckBox Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("i",bargraph.__c.runMethod(false,"Sender",__ref.getField(false, "ba")), RemoteObject.createImmutable("android.widget.CheckBox"))) { 
 BA.debugLineNum = 412;BA.debugLine="Dim chk As CheckBox = Sender";
Debug.ShouldStop(134217728);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper"), bargraph.__c.runMethod(false,"Sender",__ref.getField(false, "ba")));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 413;BA.debugLine="Dim index As Int = chk.Tag";
Debug.ShouldStop(268435456);
_index = BA.numberCast(int.class, _chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 415;BA.debugLine="Dim checkedCount As Int = 0";
Debug.ShouldStop(1073741824);
_checkedcount = BA.numberCast(int.class, 0);Debug.locals.put("checkedCount", _checkedcount);Debug.locals.put("checkedCount", _checkedcount);
 BA.debugLineNum = 416;BA.debugLine="For i = 0 To checkedSales.Length - 1";
Debug.ShouldStop(-2147483648);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 417;BA.debugLine="If checkedSales(i) = True Then checkedCount = c";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)),bargraph.__c.getField(true,"True"))) { 
_checkedcount = RemoteObject.solve(new RemoteObject[] {_checkedcount,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("checkedCount", _checkedcount);};
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 420;BA.debugLine="If Checked = False And checkedCount = 1 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_checked,bargraph.__c.getField(true,"False")) && RemoteObject.solveBoolean("=",_checkedcount,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 421;BA.debugLine="chk.Checked = True";
Debug.ShouldStop(16);
_chk.runMethodAndSync(true,"setChecked",bargraph.__c.getField(true,"True"));
 BA.debugLineNum = 422;BA.debugLine="Return";
Debug.ShouldStop(32);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 425;BA.debugLine="checkedSales(index) = Checked";
Debug.ShouldStop(256);
__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).setArrayElement (_checked,_index);
 BA.debugLineNum = 426;BA.debugLine="UpdateGraph ' Call DrawGraph without parameters";
Debug.ShouldStop(512);
__ref.runClassMethod (b4a.example.bargraph.class, "_updategraph" /*RemoteObject*/ );
 }else {
 BA.debugLineNum = 428;BA.debugLine="Log(\"Error: Sender is not a CheckBox\")";
Debug.ShouldStop(2048);
bargraph.__c.runVoidMethod ("LogImpl","55177362",RemoteObject.createImmutable("Error: Sender is not a CheckBox"),0);
 };
 BA.debugLineNum = 430;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
 //BA.debugLineNum = 3;BA.debugLine="Public checkedSales() As Boolean";
bargraph._checkedsales = RemoteObject.createNewArray ("boolean", new int[] {0}, new Object[]{});__ref.setField("_checkedsales",bargraph._checkedsales);
 //BA.debugLineNum = 4;BA.debugLine="Dim color() As Int = Array As Int(Colors.RGB(255,";
bargraph._color = RemoteObject.createNewArray("int",new int[] {3},new Object[] {bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))),bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 200)),(Object)(BA.numberCast(int.class, 20)),(Object)(BA.numberCast(int.class, 20))),bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 10)))});__ref.setField("_color",bargraph._color);
 //BA.debugLineNum = 5;BA.debugLine="Dim legendPanel As Panel";
bargraph._legendpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_legendpanel",bargraph._legendpanel);
 //BA.debugLineNum = 6;BA.debugLine="Dim sortPanels As Panel";
bargraph._sortpanels = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_sortpanels",bargraph._sortpanels);
 //BA.debugLineNum = 7;BA.debugLine="Dim radioPanel As Panel";
bargraph._radiopanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_radiopanel",bargraph._radiopanel);
 //BA.debugLineNum = 8;BA.debugLine="Dim salesPanels As Panel";
bargraph._salespanels = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_salespanels",bargraph._salespanels);
 //BA.debugLineNum = 9;BA.debugLine="Dim radioLabelSalesTitles As Label";
bargraph._radiolabelsalestitles = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");__ref.setField("_radiolabelsalestitles",bargraph._radiolabelsalestitles);
 //BA.debugLineNum = 10;BA.debugLine="Dim radioLabelSortTitles As Label";
bargraph._radiolabelsorttitles = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");__ref.setField("_radiolabelsorttitles",bargraph._radiolabelsorttitles);
 //BA.debugLineNum = 11;BA.debugLine="Dim radioLabelLegendTitles As Label";
bargraph._radiolabellegendtitles = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");__ref.setField("_radiolabellegendtitles",bargraph._radiolabellegendtitles);
 //BA.debugLineNum = 12;BA.debugLine="Dim Active1 As Activity";
bargraph._active1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ActivityWrapper");__ref.setField("_active1",bargraph._active1);
 //BA.debugLineNum = 13;BA.debugLine="Dim panel_l As Panel";
bargraph._panel_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_panel_l",bargraph._panel_l);
 //BA.debugLineNum = 14;BA.debugLine="Dim sale_1() As Int";
bargraph._sale_1 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});__ref.setField("_sale_1",bargraph._sale_1);
 //BA.debugLineNum = 15;BA.debugLine="Dim sale_2() As Int";
bargraph._sale_2 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});__ref.setField("_sale_2",bargraph._sale_2);
 //BA.debugLineNum = 16;BA.debugLine="Dim sale_3() As Int";
bargraph._sale_3 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});__ref.setField("_sale_3",bargraph._sale_3);
 //BA.debugLineNum = 17;BA.debugLine="Dim product1() As String";
bargraph._product1 = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});__ref.setField("_product1",bargraph._product1);
 //BA.debugLineNum = 18;BA.debugLine="Dim legend1() As String";
bargraph._legend1 = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});__ref.setField("_legend1",bargraph._legend1);
 //BA.debugLineNum = 19;BA.debugLine="Dim maxSales1 As Int = 0";
bargraph._maxsales1 = BA.numberCast(int.class, 0);__ref.setField("_maxsales1",bargraph._maxsales1);
 //BA.debugLineNum = 20;BA.debugLine="Dim titleString1 As String = \"\"";
bargraph._titlestring1 = BA.ObjectToString("");__ref.setField("_titlestring1",bargraph._titlestring1);
 //BA.debugLineNum = 21;BA.debugLine="Dim comId1() As Int";
bargraph._comid1 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});__ref.setField("_comid1",bargraph._comid1);
 //BA.debugLineNum = 22;BA.debugLine="Private currentPage As Int = 1";
bargraph._currentpage = BA.numberCast(int.class, 1);__ref.setField("_currentpage",bargraph._currentpage);
 //BA.debugLineNum = 23;BA.debugLine="Private itemsPerPage As Int = 5";
bargraph._itemsperpage = BA.numberCast(int.class, 5);__ref.setField("_itemsperpage",bargraph._itemsperpage);
 //BA.debugLineNum = 24;BA.debugLine="Public btnNext As Button";
bargraph._btnnext = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");__ref.setField("_btnnext",bargraph._btnnext);
 //BA.debugLineNum = 25;BA.debugLine="Public btnBack As Button";
bargraph._btnback = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");__ref.setField("_btnback",bargraph._btnback);
 //BA.debugLineNum = 26;BA.debugLine="Public sortBtn1 As RadioButton";
bargraph._sortbtn1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");__ref.setField("_sortbtn1",bargraph._sortbtn1);
 //BA.debugLineNum = 27;BA.debugLine="Public sortBtn2 As RadioButton";
bargraph._sortbtn2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");__ref.setField("_sortbtn2",bargraph._sortbtn2);
 //BA.debugLineNum = 28;BA.debugLine="Public defBtn As RadioButton";
bargraph._defbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");__ref.setField("_defbtn",bargraph._defbtn);
 //BA.debugLineNum = 29;BA.debugLine="Public sales1 As RadioButton";
bargraph._sales1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");__ref.setField("_sales1",bargraph._sales1);
 //BA.debugLineNum = 30;BA.debugLine="Public sales2 As RadioButton";
bargraph._sales2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");__ref.setField("_sales2",bargraph._sales2);
 //BA.debugLineNum = 31;BA.debugLine="Public sales3 As RadioButton";
bargraph._sales3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");__ref.setField("_sales3",bargraph._sales3);
 //BA.debugLineNum = 32;BA.debugLine="Dim layout As String = \"\"";
bargraph._layout = BA.ObjectToString("");__ref.setField("_layout",bargraph._layout);
 //BA.debugLineNum = 33;BA.debugLine="Private isFirstInit As Boolean = True";
bargraph._isfirstinit = bargraph.__c.getField(true,"True");__ref.setField("_isfirstinit",bargraph._isfirstinit);
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _drawgraph(RemoteObject __ref,RemoteObject _active,RemoteObject _panel,RemoteObject _sale1,RemoteObject _sale2,RemoteObject _sale3,RemoteObject _product,RemoteObject _maxsales,RemoteObject _titlestring) throws Exception{
try {
		Debug.PushSubsStack("DrawGraph (bargraph) ","bargraph",5,__ref.getField(false, "ba"),__ref,218);
if (RapidSub.canDelegate("drawgraph")) { return __ref.runUserSub(false, "bargraph","drawgraph", __ref, _active, _panel, _sale1, _sale2, _sale3, _product, _maxsales, _titlestring);}
RemoteObject _halfwidth = RemoteObject.createImmutable(0);
RemoteObject _radiolabelwidth = RemoteObject.createImmutable(0);
RemoteObject _radiolabelheight = RemoteObject.createImmutable(0);
RemoteObject _radiolabelx = RemoteObject.createImmutable(0);
RemoteObject _radiolabely = RemoteObject.createImmutable(0);
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
RemoteObject _buttonwidth = RemoteObject.createImmutable(0);
RemoteObject _buttonheight = RemoteObject.createImmutable(0);
RemoteObject _buttonspacing = RemoteObject.createImmutable(0);
RemoteObject _graphbottom = RemoteObject.createImmutable(0);
RemoteObject _buttony = RemoteObject.createImmutable(0);
RemoteObject _btnbackx = RemoteObject.createImmutable(0);
RemoteObject _btnnextx = RemoteObject.createImmutable(0);
Debug.locals.put("Active", _active);
Debug.locals.put("panel", _panel);
Debug.locals.put("sale1", _sale1);
Debug.locals.put("sale2", _sale2);
Debug.locals.put("sale3", _sale3);
Debug.locals.put("product", _product);
Debug.locals.put("maxSales", _maxsales);
Debug.locals.put("TitleString", _titlestring);
 BA.debugLineNum = 218;BA.debugLine="Public Sub DrawGraph(Active As Activity, panel As";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 219;BA.debugLine="Try";
Debug.ShouldStop(67108864);
try { BA.debugLineNum = 220;BA.debugLine="panel.Invalidate";
Debug.ShouldStop(134217728);
_panel.runVoidMethod ("Invalidate");
 BA.debugLineNum = 221;BA.debugLine="panel.RemoveAllViews";
Debug.ShouldStop(268435456);
_panel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 222;BA.debugLine="panel.Height = 450dip";
Debug.ShouldStop(536870912);
_panel.runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 450))));
 BA.debugLineNum = 223;BA.debugLine="If panel.Width = 0 Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_panel.runMethod(true,"getWidth"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 224;BA.debugLine="panel.Width = 800dip";
Debug.ShouldStop(-2147483648);
_panel.runMethod(true,"setWidth",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 800))));
 };
 BA.debugLineNum = 229;BA.debugLine="Dim halfWidth As Int = panel.Width / 2";
Debug.ShouldStop(16);
_halfwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("halfWidth", _halfwidth);Debug.locals.put("halfWidth", _halfwidth);
 BA.debugLineNum = 230;BA.debugLine="salesPanels.Width = halfWidth ' Make salesPanels";
Debug.ShouldStop(32);
__ref.getField(false,"_salespanels" /*RemoteObject*/ ).runMethod(true,"setWidth",_halfwidth);
 BA.debugLineNum = 231;BA.debugLine="salesPanels.Height = 30dip";
Debug.ShouldStop(64);
__ref.getField(false,"_salespanels" /*RemoteObject*/ ).runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 232;BA.debugLine="sortPanels.Width = halfWidth";
Debug.ShouldStop(128);
__ref.getField(false,"_sortpanels" /*RemoteObject*/ ).runMethod(true,"setWidth",_halfwidth);
 BA.debugLineNum = 233;BA.debugLine="sortPanels.Height = 30dip";
Debug.ShouldStop(256);
__ref.getField(false,"_sortpanels" /*RemoteObject*/ ).runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 235;BA.debugLine="panel.AddView(legendPanel, halfWidth, 20dip, hal";
Debug.ShouldStop(1024);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).getObject())),(Object)(_halfwidth),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(_halfwidth),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))));
 BA.debugLineNum = 237;BA.debugLine="Dim radioLabelWidth As Int = halfWidth";
Debug.ShouldStop(4096);
_radiolabelwidth = _halfwidth;Debug.locals.put("radioLabelWidth", _radiolabelwidth);Debug.locals.put("radioLabelWidth", _radiolabelwidth);
 BA.debugLineNum = 238;BA.debugLine="Dim radioLabelHeight As Int = 35dip";
Debug.ShouldStop(8192);
_radiolabelheight = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)));Debug.locals.put("radioLabelHeight", _radiolabelheight);Debug.locals.put("radioLabelHeight", _radiolabelheight);
 BA.debugLineNum = 239;BA.debugLine="Dim radioLabelX As Int = (panel.Width - radioLab";
Debug.ShouldStop(16384);
_radiolabelx = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),_radiolabelwidth}, "-",1, 1)),RemoteObject.createImmutable(2),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 170)))}, "/+",1, 0));Debug.locals.put("radioLabelX", _radiolabelx);Debug.locals.put("radioLabelX", _radiolabelx);
 BA.debugLineNum = 240;BA.debugLine="Dim radioLabelY As Int = 5dip";
Debug.ShouldStop(32768);
_radiolabely = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("radioLabelY", _radiolabely);Debug.locals.put("radioLabelY", _radiolabely);
 BA.debugLineNum = 242;BA.debugLine="radioLabelSalesTitles.Visible = sale1.Length >=";
Debug.ShouldStop(131072);
__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).runMethod(true,"setVisible",BA.ObjectToBoolean(RemoteObject.solveBoolean("g",_sale1.getField(true,"length"),BA.numberCast(double.class, 5))));
 BA.debugLineNum = 243;BA.debugLine="radioLabelSortTitles.Visible = sale1.Length >= 5";
Debug.ShouldStop(262144);
__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).runMethod(true,"setVisible",BA.ObjectToBoolean(RemoteObject.solveBoolean("g",_sale1.getField(true,"length"),BA.numberCast(double.class, 5))));
 BA.debugLineNum = 245;BA.debugLine="panel.AddView(radioLabelLegendTitles, halfWidth+";
Debug.ShouldStop(1048576);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_radiolabellegendtitles" /*RemoteObject*/ ).getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_halfwidth,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 47)))}, "+",1, 1)),(Object)(_radiolabely),(Object)(_radiolabelwidth),(Object)(_radiolabelheight));
 BA.debugLineNum = 247;BA.debugLine="If sale1.Length >=5 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("g",_sale1.getField(true,"length"),BA.numberCast(double.class, 5))) { 
 BA.debugLineNum = 248;BA.debugLine="panel.AddView(radioLabelSalesTitles, 0, radioLa";
Debug.ShouldStop(8388608);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_radiolabely),(Object)(_radiolabelwidth),(Object)(_radiolabelheight));
 BA.debugLineNum = 249;BA.debugLine="panel.AddView(radioLabelSortTitles, 0, radioLab";
Debug.ShouldStop(16777216);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_radiolabely,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48)))}, "+",1, 1)),(Object)(_radiolabelwidth),(Object)(_radiolabelheight));
 BA.debugLineNum = 250;BA.debugLine="panel.AddView(salesPanels, 0dip, 20dip, halfWid";
Debug.ShouldStop(33554432);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_salespanels" /*RemoteObject*/ ).getObject())),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(_halfwidth),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))));
 BA.debugLineNum = 251;BA.debugLine="panel.AddView(sortPanels, 0dip, 60dip, halfWidt";
Debug.ShouldStop(67108864);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_sortpanels" /*RemoteObject*/ ).getObject())),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))),(Object)(_halfwidth),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 38)))));
 };
 BA.debugLineNum = 257;BA.debugLine="Dim activityPanel As Panel";
Debug.ShouldStop(1);
_activitypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("activityPanel", _activitypanel);
 BA.debugLineNum = 258;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
Debug.ShouldStop(2);
_activitypanel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("activityPanel")));
 BA.debugLineNum = 260;BA.debugLine="activityPanel.Width = 80%x";
Debug.ShouldStop(8);
_activitypanel.runMethod(true,"setWidth",bargraph.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),__ref.getField(false, "ba")));
 BA.debugLineNum = 261;BA.debugLine="If Active.Width > 800 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean(">",_active.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 262;BA.debugLine="activityPanel.Width = 55%x";
Debug.ShouldStop(32);
_activitypanel.runMethod(true,"setWidth",bargraph.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 55)),__ref.getField(false, "ba")));
 };
 BA.debugLineNum = 264;BA.debugLine="activityPanel.Height = 250dip";
Debug.ShouldStop(128);
_activitypanel.runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))));
 BA.debugLineNum = 265;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211,";
Debug.ShouldStop(256);
_activitypanel.runVoidMethod ("setColor",bargraph.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 70)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211))));
 BA.debugLineNum = 267;BA.debugLine="Dim alignLeftCenter As Int = (Active.Width - act";
Debug.ShouldStop(1024);
_alignleftcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_active.runMethod(true,"getWidth"),_activitypanel.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignLeftCenter", _alignleftcenter);Debug.locals.put("alignLeftCenter", _alignleftcenter);
 BA.debugLineNum = 268;BA.debugLine="Dim alignTopCenter As Int = (panel.Height - acti";
Debug.ShouldStop(2048);
_aligntopcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getHeight"),_activitypanel.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "/-",1, 0));Debug.locals.put("alignTopCenter", _aligntopcenter);Debug.locals.put("alignTopCenter", _aligntopcenter);
 BA.debugLineNum = 270;BA.debugLine="Dim Title As Label";
Debug.ShouldStop(8192);
_title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Title", _title);
 BA.debugLineNum = 271;BA.debugLine="Title.Initialize(\"\")";
Debug.ShouldStop(16384);
_title.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 272;BA.debugLine="Title.Text = TitleString";
Debug.ShouldStop(32768);
_title.runMethod(true,"setText",BA.ObjectToCharSequence(_titlestring));
 BA.debugLineNum = 273;BA.debugLine="Title.TextSize = 20";
Debug.ShouldStop(65536);
_title.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 274;BA.debugLine="Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(131072);
_title.runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 275;BA.debugLine="Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(262144);
_title.runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 276;BA.debugLine="Title.TextColor = Colors.Black";
Debug.ShouldStop(524288);
_title.runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 277;BA.debugLine="panel.AddView(Title, 0, alignTopCenter / 2 +55di";
Debug.ShouldStop(1048576);
_panel.runVoidMethod ("AddView",(Object)((_title.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_aligntopcenter,RemoteObject.createImmutable(2),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))}, "/+",1, 0))),(Object)(_panel.runMethod(true,"getWidth")),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 279;BA.debugLine="panel.AddView(activityPanel, alignLeftCenter, al";
Debug.ShouldStop(4194304);
_panel.runVoidMethod ("AddView",(Object)((_activitypanel.getObject())),(Object)(_alignleftcenter),(Object)(RemoteObject.solve(new RemoteObject[] {_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 47)))}, "+",1, 1)),(Object)(_activitypanel.runMethod(true,"getWidth")),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 281;BA.debugLine="Dim graphCanvas As Canvas";
Debug.ShouldStop(16777216);
_graphcanvas = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("graphCanvas", _graphcanvas);
 BA.debugLineNum = 282;BA.debugLine="graphCanvas.Initialize(activityPanel)";
Debug.ShouldStop(33554432);
_graphcanvas.runVoidMethod ("Initialize",(Object)((_activitypanel.getObject())));
 BA.debugLineNum = 284;BA.debugLine="Dim maxSale As Int = maxSales * 1.2";
Debug.ShouldStop(134217728);
_maxsale = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_maxsales,RemoteObject.createImmutable(1.2)}, "*",0, 0));Debug.locals.put("maxSale", _maxsale);Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 285;BA.debugLine="Dim cv As Canvas";
Debug.ShouldStop(268435456);
_cv = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cv", _cv);
 BA.debugLineNum = 286;BA.debugLine="cv.Initialize(panel)";
Debug.ShouldStop(536870912);
_cv.runVoidMethod ("Initialize",(Object)((_panel.getObject())));
 BA.debugLineNum = 288;BA.debugLine="Dim totalProducts As Int = sale1.Length";
Debug.ShouldStop(-2147483648);
_totalproducts = _sale1.getField(true,"length");Debug.locals.put("totalProducts", _totalproducts);Debug.locals.put("totalProducts", _totalproducts);
 BA.debugLineNum = 289;BA.debugLine="Dim startIndex As Int = (currentPage - 1) * item";
Debug.ShouldStop(1);
_startindex = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_currentpage" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1)),__ref.getField(true,"_itemsperpage" /*RemoteObject*/ )}, "*",0, 1);Debug.locals.put("startIndex", _startindex);Debug.locals.put("startIndex", _startindex);
 BA.debugLineNum = 290;BA.debugLine="Dim endIndex As Int = Min(startIndex + itemsPerP";
Debug.ShouldStop(2);
_endindex = BA.numberCast(int.class, bargraph.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_startindex,__ref.getField(true,"_itemsperpage" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+-",2, 1))),(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_totalproducts,RemoteObject.createImmutable(1)}, "-",1, 1)))));Debug.locals.put("endIndex", _endindex);Debug.locals.put("endIndex", _endindex);
 BA.debugLineNum = 291;BA.debugLine="Dim barsPerProduct As Int = 3";
Debug.ShouldStop(4);
_barsperproduct = BA.numberCast(int.class, 3);Debug.locals.put("barsPerProduct", _barsperproduct);Debug.locals.put("barsPerProduct", _barsperproduct);
 BA.debugLineNum = 292;BA.debugLine="Dim totalBars As Int = (endIndex - startIndex +";
Debug.ShouldStop(8);
_totalbars = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_endindex,_startindex,RemoteObject.createImmutable(1)}, "-+",2, 1)),_barsperproduct}, "*",0, 1);Debug.locals.put("totalBars", _totalbars);Debug.locals.put("totalBars", _totalbars);
 BA.debugLineNum = 293;BA.debugLine="Dim gap As Int = 5dip";
Debug.ShouldStop(16);
_gap = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("gap", _gap);Debug.locals.put("gap", _gap);
 BA.debugLineNum = 294;BA.debugLine="Dim productGap As Int = 0dip";
Debug.ShouldStop(32);
_productgap = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("productGap", _productgap);Debug.locals.put("productGap", _productgap);
 BA.debugLineNum = 295;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(64);
_padding = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 297;BA.debugLine="Dim availableWidth As Int = activityPanel.Width";
Debug.ShouldStop(256);
_availablewidth = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_padding,RemoteObject.createImmutable(2)}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_endindex,_startindex,RemoteObject.createImmutable(1)}, "-+",2, 1)),RemoteObject.createImmutable(1)}, "-",1, 1)),_productgap}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_totalbars,(RemoteObject.solve(new RemoteObject[] {_endindex,_startindex,RemoteObject.createImmutable(1)}, "-+",2, 1))}, "-",1, 1)),_gap}, "*",0, 1))}, "---",3, 1);Debug.locals.put("availableWidth", _availablewidth);Debug.locals.put("availableWidth", _availablewidth);
 BA.debugLineNum = 298;BA.debugLine="Dim barWidth As Int = availableWidth / totalBars";
Debug.ShouldStop(512);
_barwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_availablewidth,_totalbars}, "/",0, 0));Debug.locals.put("barWidth", _barwidth);Debug.locals.put("barWidth", _barwidth);
 BA.debugLineNum = 299;BA.debugLine="Dim xStart As Int = padding";
Debug.ShouldStop(1024);
_xstart = _padding;Debug.locals.put("xStart", _xstart);Debug.locals.put("xStart", _xstart);
 BA.debugLineNum = 301;BA.debugLine="For i = startIndex To endIndex";
Debug.ShouldStop(4096);
{
final int step62 = 1;
final int limit62 = _endindex.<Integer>get().intValue();
_i = _startindex.<Integer>get().intValue() ;
for (;(step62 > 0 && _i <= limit62) || (step62 < 0 && _i >= limit62) ;_i = ((int)(0 + _i + step62))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 302;BA.debugLine="Dim xPos As Int = xStart + (i - startIndex) * (";
Debug.ShouldStop(8192);
_xpos = RemoteObject.solve(new RemoteObject[] {_xstart,(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),_startindex}, "-",1, 1)),(RemoteObject.solve(new RemoteObject[] {_barsperproduct,(RemoteObject.solve(new RemoteObject[] {_barwidth,_gap}, "+",1, 1)),_productgap}, "*+",1, 1))}, "+*",1, 1);Debug.locals.put("xPos", _xpos);Debug.locals.put("xPos", _xpos);
 BA.debugLineNum = 303;BA.debugLine="Dim saleValues() As Int = Array As Int(sale1(i)";
Debug.ShouldStop(16384);
_salevalues = RemoteObject.createNewArray("int",new int[] {3},new Object[] {_sale1.getArrayElement(true,BA.numberCast(int.class, _i)),_sale2.getArrayElement(true,BA.numberCast(int.class, _i)),_sale3.getArrayElement(true,BA.numberCast(int.class, _i))});Debug.locals.put("saleValues", _salevalues);Debug.locals.put("saleValues", _salevalues);
 BA.debugLineNum = 304;BA.debugLine="Dim indexOffset As Int = 0";
Debug.ShouldStop(32768);
_indexoffset = BA.numberCast(int.class, 0);Debug.locals.put("indexOffset", _indexoffset);Debug.locals.put("indexOffset", _indexoffset);
 BA.debugLineNum = 306;BA.debugLine="For j = 0 To barsPerProduct - 1";
Debug.ShouldStop(131072);
{
final int step66 = 1;
final int limit66 = RemoteObject.solve(new RemoteObject[] {_barsperproduct,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_j = 0 ;
for (;(step66 > 0 && _j <= limit66) || (step66 < 0 && _j >= limit66) ;_j = ((int)(0 + _j + step66))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 307;BA.debugLine="If j < checkedSales.Length And checkedSales(j)";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("<",RemoteObject.createImmutable(_j),BA.numberCast(double.class, __ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getField(true,"length"))) && RemoteObject.solveBoolean(".",__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _j)))) { 
 BA.debugLineNum = 308;BA.debugLine="Dim sale As Int = saleValues(j)";
Debug.ShouldStop(524288);
_sale = _salevalues.getArrayElement(true,BA.numberCast(int.class, _j));Debug.locals.put("sale", _sale);Debug.locals.put("sale", _sale);
 BA.debugLineNum = 309;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * (ac";
Debug.ShouldStop(1048576);
_barheight = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_sale,_maxsale}, "/",0, 0)),(_activitypanel.runMethod(true,"getHeight"))}, "*",0, 0));Debug.locals.put("barHeight", _barheight);Debug.locals.put("barHeight", _barheight);
 BA.debugLineNum = 310;BA.debugLine="Dim xBar As Int = xPos + indexOffset * barWid";
Debug.ShouldStop(2097152);
_xbar = RemoteObject.solve(new RemoteObject[] {_xpos,_indexoffset,_barwidth}, "+*",1, 1);Debug.locals.put("xBar", _xbar);Debug.locals.put("xBar", _xbar);
 BA.debugLineNum = 312;BA.debugLine="Dim r As Rect";
Debug.ShouldStop(8388608);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r", _r);
 BA.debugLineNum = 313;BA.debugLine="r.Initialize(xBar, activityPanel.Height - bar";
Debug.ShouldStop(16777216);
_r.runVoidMethod ("Initialize",(Object)(_xbar),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_xbar,_barwidth}, "+",1, 1)),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 314;BA.debugLine="graphCanvas.DrawRect(r, color(j), True, 2dip)";
Debug.ShouldStop(33554432);
_graphcanvas.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(__ref.getField(false,"_color" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _j))),(Object)(bargraph.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 316;BA.debugLine="Dim fontSize As Int = 8";
Debug.ShouldStop(134217728);
_fontsize = BA.numberCast(int.class, 8);Debug.locals.put("fontSize", _fontsize);Debug.locals.put("fontSize", _fontsize);
 BA.debugLineNum = 317;BA.debugLine="If Active.Width > 800 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean(">",_active.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 318;BA.debugLine="fontSize = 10";
Debug.ShouldStop(536870912);
_fontsize = BA.numberCast(int.class, 10);Debug.locals.put("fontSize", _fontsize);
 };
 BA.debugLineNum = 320;BA.debugLine="graphCanvas.DrawText(FormatNumberWithSuffix(s";
Debug.ShouldStop(-2147483648);
_graphcanvas.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(__ref.runClassMethod (b4a.example.bargraph.class, "_formatnumberwithsuffix" /*RemoteObject*/ ,(Object)(_sale))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_xbar,(RemoteObject.solve(new RemoteObject[] {_barwidth,RemoteObject.createImmutable(2)}, "/",0, 0))}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "--",2, 1))),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, _fontsize)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("CENTER"))));
 BA.debugLineNum = 321;BA.debugLine="indexOffset = indexOffset + 1";
Debug.ShouldStop(1);
_indexoffset = RemoteObject.solve(new RemoteObject[] {_indexoffset,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("indexOffset", _indexoffset);
 };
 }
}Debug.locals.put("j", _j);
;
 BA.debugLineNum = 325;BA.debugLine="Dim productLabel As Label";
Debug.ShouldStop(16);
_productlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("productLabel", _productlabel);
 BA.debugLineNum = 326;BA.debugLine="productLabel.Initialize(\"productLabel\")";
Debug.ShouldStop(32);
_productlabel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("productLabel")));
 BA.debugLineNum = 327;BA.debugLine="productLabel.Text = product(i)";
Debug.ShouldStop(64);
_productlabel.runMethod(true,"setText",BA.ObjectToCharSequence(_product.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 328;BA.debugLine="productLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(128);
_productlabel.runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 329;BA.debugLine="productLabel.TextSize = 12";
Debug.ShouldStop(256);
_productlabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 330;BA.debugLine="productLabel.Tag = comId1(i)";
Debug.ShouldStop(512);
_productlabel.runMethod(false,"setTag",(__ref.getField(false,"_comid1" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 331;BA.debugLine="productLabel.TextColor = Colors.Black";
Debug.ShouldStop(1024);
_productlabel.runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 332;BA.debugLine="productLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(2048);
_productlabel.runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 333;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
Debug.ShouldStop(4096);
_productlabely = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "++",2, 1);Debug.locals.put("productLabelY", _productlabely);Debug.locals.put("productLabelY", _productlabely);
 BA.debugLineNum = 334;BA.debugLine="Dim productLabelX As Int = alignLeftCenter";
Debug.ShouldStop(8192);
_productlabelx = _alignleftcenter;Debug.locals.put("productLabelX", _productlabelx);Debug.locals.put("productLabelX", _productlabelx);
 BA.debugLineNum = 335;BA.debugLine="panel.AddView(productLabel, xPos + productLabel";
Debug.ShouldStop(16384);
_panel.runVoidMethod ("AddView",(Object)((_productlabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_xpos,_productlabelx}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_productlabely,RemoteObject.createImmutable(20)}, "+",1, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 338;BA.debugLine="Dim numLabels As Int = 10";
Debug.ShouldStop(131072);
_numlabels = BA.numberCast(int.class, 10);Debug.locals.put("numLabels", _numlabels);Debug.locals.put("numLabels", _numlabels);
 BA.debugLineNum = 339;BA.debugLine="For i = 0 To numLabels";
Debug.ShouldStop(262144);
{
final int step95 = 1;
final int limit95 = _numlabels.<Integer>get().intValue();
_i = 0 ;
for (;(step95 > 0 && _i <= limit95) || (step95 < 0 && _i >= limit95) ;_i = ((int)(0 + _i + step95))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 340;BA.debugLine="Dim labelValue As Int = Round((maxSale / numLab";
Debug.ShouldStop(524288);
_labelvalue = BA.numberCast(int.class, bargraph.__c.runMethod(true,"Round",(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_maxsale,_numlabels}, "/",0, 0)),RemoteObject.createImmutable(_i)}, "*",0, 0))));Debug.locals.put("labelValue", _labelvalue);Debug.locals.put("labelValue", _labelvalue);
 BA.debugLineNum = 341;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - (";
Debug.ShouldStop(1048576);
_labelypos = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_labelvalue,_maxsale}, "/",0, 0)),_activitypanel.runMethod(true,"getHeight")}, "*",0, 0))}, "-",1, 0));Debug.locals.put("labelYPos", _labelypos);Debug.locals.put("labelYPos", _labelypos);
 BA.debugLineNum = 342;BA.debugLine="cv.DrawText(FormatNumberWithLabel(labelValue),";
Debug.ShouldStop(2097152);
_cv.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(__ref.runClassMethod (b4a.example.bargraph.class, "_formatnumberwithlabel" /*RemoteObject*/ ,(Object)(_labelvalue))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_alignleftcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_labelypos,_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48)))}, "++",2, 1))),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, 10)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("RIGHT"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 349;BA.debugLine="Dim buttonWidth As Int = 100dip";
Debug.ShouldStop(268435456);
_buttonwidth = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)));Debug.locals.put("buttonWidth", _buttonwidth);Debug.locals.put("buttonWidth", _buttonwidth);
 BA.debugLineNum = 350;BA.debugLine="Dim buttonHeight As Int = 40dip";
Debug.ShouldStop(536870912);
_buttonheight = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)));Debug.locals.put("buttonHeight", _buttonheight);Debug.locals.put("buttonHeight", _buttonheight);
 BA.debugLineNum = 351;BA.debugLine="Dim buttonSpacing As Int = 25dip ' Adjust as nee";
Debug.ShouldStop(1073741824);
_buttonspacing = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)));Debug.locals.put("buttonSpacing", _buttonspacing);Debug.locals.put("buttonSpacing", _buttonspacing);
 BA.debugLineNum = 353;BA.debugLine="Dim graphBottom As Int = activityPanel.Top + act";
Debug.ShouldStop(1);
_graphbottom = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getTop"),_activitypanel.runMethod(true,"getHeight")}, "+",1, 1);Debug.locals.put("graphBottom", _graphbottom);Debug.locals.put("graphBottom", _graphbottom);
 BA.debugLineNum = 354;BA.debugLine="Dim buttonY As Int = graphBottom + buttonSpacing";
Debug.ShouldStop(2);
_buttony = RemoteObject.solve(new RemoteObject[] {_graphbottom,_buttonspacing}, "+",1, 1);Debug.locals.put("buttonY", _buttony);Debug.locals.put("buttonY", _buttony);
 BA.debugLineNum = 356;BA.debugLine="Dim btnBackX As Int = (panel.Width / 2) - button";
Debug.ShouldStop(8);
_btnbackx = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)),_buttonwidth,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))}, "--",2, 0));Debug.locals.put("btnBackX", _btnbackx);Debug.locals.put("btnBackX", _btnbackx);
 BA.debugLineNum = 357;BA.debugLine="Dim btnNextX As Int = (panel.Width / 2) + 100dip";
Debug.ShouldStop(16);
_btnnextx = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))}, "+",1, 0));Debug.locals.put("btnNextX", _btnnextx);Debug.locals.put("btnNextX", _btnnextx);
 BA.debugLineNum = 359;BA.debugLine="panel.AddView(btnBack, btnBackX, buttonY, button";
Debug.ShouldStop(64);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_btnback" /*RemoteObject*/ ).getObject())),(Object)(_btnbackx),(Object)(_buttony),(Object)(_buttonwidth),(Object)(_buttonheight));
 BA.debugLineNum = 360;BA.debugLine="panel.AddView(btnNext, btnNextX, buttonY, button";
Debug.ShouldStop(128);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_btnnext" /*RemoteObject*/ ).getObject())),(Object)(_btnnextx),(Object)(_buttony),(Object)(_buttonwidth),(Object)(_buttonheight));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e110) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e110.toString()); BA.debugLineNum = 365;BA.debugLine="Log(LastException)";
Debug.ShouldStop(4096);
bargraph.__c.runVoidMethod ("LogImpl","54718739",BA.ObjectToString(bargraph.__c.runMethod(false,"LastException",__ref.getField(false, "ba"))),0);
 };
 BA.debugLineNum = 367;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("FormatNumberWithLabel (bargraph) ","bargraph",5,__ref.getField(false, "ba"),__ref,401);
if (RapidSub.canDelegate("formatnumberwithlabel")) { return __ref.runUserSub(false, "bargraph","formatnumberwithlabel", __ref, _number);}
Debug.locals.put("number", _number);
 BA.debugLineNum = 401;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
Debug.ShouldStop(65536);
 BA.debugLineNum = 402;BA.debugLine="If number >= 1000000 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000000))) { 
 BA.debugLineNum = 403;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
Debug.ShouldStop(262144);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000000)}, "/",0, 0))),RemoteObject.createImmutable("M"));
 }else 
{ BA.debugLineNum = 404;BA.debugLine="Else If number >= 1000 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000))) { 
 BA.debugLineNum = 405;BA.debugLine="Return Floor(number / 1000) & \"k\"";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000)}, "/",0, 0))),RemoteObject.createImmutable("k"));
 }else {
 BA.debugLineNum = 407;BA.debugLine="Return number";
Debug.ShouldStop(4194304);
if (true) return BA.NumberToString(_number);
 }}
;
 BA.debugLineNum = 409;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("FormatNumberWithSuffix (bargraph) ","bargraph",5,__ref.getField(false, "ba"),__ref,391);
if (RapidSub.canDelegate("formatnumberwithsuffix")) { return __ref.runUserSub(false, "bargraph","formatnumberwithsuffix", __ref, _number);}
Debug.locals.put("number", _number);
 BA.debugLineNum = 391;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
Debug.ShouldStop(64);
 BA.debugLineNum = 392;BA.debugLine="If number >= 1000000 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000000))) { 
 BA.debugLineNum = 393;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
Debug.ShouldStop(256);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("M"));
 }else 
{ BA.debugLineNum = 394;BA.debugLine="Else If number >= 1000 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000))) { 
 BA.debugLineNum = 395;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
Debug.ShouldStop(1024);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("k"));
 }else {
 BA.debugLineNum = 397;BA.debugLine="Return NumberFormat(number, 1, 0)";
Debug.ShouldStop(4096);
if (true) return bargraph.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _number)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 0)));
 }}
;
 BA.debugLineNum = 399;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getcurrentpage(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetCurrentPage (bargraph) ","bargraph",5,__ref.getField(false, "ba"),__ref,373);
if (RapidSub.canDelegate("getcurrentpage")) { return __ref.runUserSub(false, "bargraph","getcurrentpage", __ref);}
 BA.debugLineNum = 373;BA.debugLine="Public Sub GetCurrentPage As Int";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 374;BA.debugLine="Return currentPage";
Debug.ShouldStop(2097152);
if (true) return __ref.getField(true,"_currentpage" /*RemoteObject*/ );
 BA.debugLineNum = 375;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _active,RemoteObject _panel,RemoteObject _sale1,RemoteObject _sale2,RemoteObject _sale3,RemoteObject _product,RemoteObject _legend,RemoteObject _maxsales,RemoteObject _titlestring,RemoteObject _comid,RemoteObject _layout1,RemoteObject _nextbtn,RemoteObject _backbtn,RemoteObject _sortbtn,RemoteObject _btnsort2,RemoteObject _defaultbtn,RemoteObject _sales1btn,RemoteObject _sales2btn,RemoteObject _sales3btn) throws Exception{
try {
		Debug.PushSubsStack("Initialize (bargraph) ","bargraph",5,__ref.getField(false, "ba"),__ref,36);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "bargraph","initialize", __ref, _ba, _active, _panel, _sale1, _sale2, _sale3, _product, _legend, _maxsales, _titlestring, _comid, _layout1, _nextbtn, _backbtn, _sortbtn, _btnsort2, _defaultbtn, _sales1btn, _sales2btn, _sales3btn);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
RemoteObject _borderpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _legendwidth = RemoteObject.createImmutable(0);
RemoteObject _tempcheckboxes = null;
RemoteObject _tempcheckedsales = null;
int _i = 0;
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _cdback = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _cdnext = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _radiobuttons = null;
RemoteObject _radiotexts = null;
RemoteObject _totalbuttons = RemoteObject.createImmutable(0);
RemoteObject _buttonwidth = RemoteObject.createImmutable(0);
RemoteObject _spacing = RemoteObject.createImmutable(0);
RemoteObject _saleslabels = null;
RemoteObject _salestexts = null;
RemoteObject _totallabels = RemoteObject.createImmutable(0);
RemoteObject _labelwidth = RemoteObject.createImmutable(0);
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
Debug.locals.put("NextBtn", _nextbtn);
Debug.locals.put("Backbtn", _backbtn);
Debug.locals.put("sortBtn", _sortbtn);
Debug.locals.put("BtnSort2", _btnsort2);
Debug.locals.put("Defaultbtn", _defaultbtn);
Debug.locals.put("Sales1btn", _sales1btn);
Debug.locals.put("Sales2btn", _sales2btn);
Debug.locals.put("Sales3btn", _sales3btn);
 BA.debugLineNum = 36;BA.debugLine="Public Sub Initialize(Active As Activity, panel As";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="If Active.IsInitialized = False Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_active.runMethod(true,"IsInitialized"),bargraph.__c.getField(true,"False"))) { 
 BA.debugLineNum = 38;BA.debugLine="Log(\"Error: Activity is not initialized\")";
Debug.ShouldStop(32);
bargraph.__c.runVoidMethod ("LogImpl","54653058",RemoteObject.createImmutable("Error: Activity is not initialized"),0);
 BA.debugLineNum = 39;BA.debugLine="Return";
Debug.ShouldStop(64);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 41;BA.debugLine="Active1 = Active";
Debug.ShouldStop(256);
__ref.setField ("_active1" /*RemoteObject*/ ,_active);
 BA.debugLineNum = 42;BA.debugLine="panel_l = panel";
Debug.ShouldStop(512);
__ref.setField ("_panel_l" /*RemoteObject*/ ,_panel);
 BA.debugLineNum = 43;BA.debugLine="sale_1 = sale1";
Debug.ShouldStop(1024);
__ref.setField ("_sale_1" /*RemoteObject*/ ,_sale1);
 BA.debugLineNum = 44;BA.debugLine="sale_2 = sale2";
Debug.ShouldStop(2048);
__ref.setField ("_sale_2" /*RemoteObject*/ ,_sale2);
 BA.debugLineNum = 45;BA.debugLine="sale_3 = sale3";
Debug.ShouldStop(4096);
__ref.setField ("_sale_3" /*RemoteObject*/ ,_sale3);
 BA.debugLineNum = 46;BA.debugLine="product1 = product";
Debug.ShouldStop(8192);
__ref.setField ("_product1" /*RemoteObject*/ ,_product);
 BA.debugLineNum = 47;BA.debugLine="legend1 = legend";
Debug.ShouldStop(16384);
__ref.setField ("_legend1" /*RemoteObject*/ ,_legend);
 BA.debugLineNum = 48;BA.debugLine="maxSales1 = maxSales";
Debug.ShouldStop(32768);
__ref.setField ("_maxsales1" /*RemoteObject*/ ,_maxsales);
 BA.debugLineNum = 49;BA.debugLine="titleString1 = TitleString";
Debug.ShouldStop(65536);
__ref.setField ("_titlestring1" /*RemoteObject*/ ,_titlestring);
 BA.debugLineNum = 50;BA.debugLine="comId1 = comId";
Debug.ShouldStop(131072);
__ref.setField ("_comid1" /*RemoteObject*/ ,_comid);
 BA.debugLineNum = 51;BA.debugLine="layout = layout1";
Debug.ShouldStop(262144);
__ref.setField ("_layout" /*RemoteObject*/ ,_layout1);
 BA.debugLineNum = 52;BA.debugLine="btnNext = NextBtn";
Debug.ShouldStop(524288);
__ref.setField ("_btnnext" /*RemoteObject*/ ,_nextbtn);
 BA.debugLineNum = 53;BA.debugLine="btnBack = Backbtn";
Debug.ShouldStop(1048576);
__ref.setField ("_btnback" /*RemoteObject*/ ,_backbtn);
 BA.debugLineNum = 54;BA.debugLine="sortBtn1 = sortBtn";
Debug.ShouldStop(2097152);
__ref.setField ("_sortbtn1" /*RemoteObject*/ ,_sortbtn);
 BA.debugLineNum = 55;BA.debugLine="sortBtn2 = BtnSort2";
Debug.ShouldStop(4194304);
__ref.setField ("_sortbtn2" /*RemoteObject*/ ,_btnsort2);
 BA.debugLineNum = 56;BA.debugLine="defBtn = Defaultbtn";
Debug.ShouldStop(8388608);
__ref.setField ("_defbtn" /*RemoteObject*/ ,_defaultbtn);
 BA.debugLineNum = 57;BA.debugLine="sales1 = Sales1btn";
Debug.ShouldStop(16777216);
__ref.setField ("_sales1" /*RemoteObject*/ ,_sales1btn);
 BA.debugLineNum = 58;BA.debugLine="sales2 = Sales2btn";
Debug.ShouldStop(33554432);
__ref.setField ("_sales2" /*RemoteObject*/ ,_sales2btn);
 BA.debugLineNum = 59;BA.debugLine="sales3 = Sales3btn";
Debug.ShouldStop(67108864);
__ref.setField ("_sales3" /*RemoteObject*/ ,_sales3btn);
 BA.debugLineNum = 61;BA.debugLine="If sale1.Length <> product.Length Or sale2.Length";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("!",_sale1.getField(true,"length"),BA.numberCast(double.class, _product.getField(true,"length"))) || RemoteObject.solveBoolean("!",_sale2.getField(true,"length"),BA.numberCast(double.class, _product.getField(true,"length"))) || RemoteObject.solveBoolean("!",_sale3.getField(true,"length"),BA.numberCast(double.class, _product.getField(true,"length")))) { 
 BA.debugLineNum = 62;BA.debugLine="Return";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 65;BA.debugLine="legendPanel.Initialize(\"\")";
Debug.ShouldStop(1);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 66;BA.debugLine="legendPanel.Width = panel.Width/2";
Debug.ShouldStop(2);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 67;BA.debugLine="legendPanel.Height = 30dip";
Debug.ShouldStop(4);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 69;BA.debugLine="sortPanels.Initialize(\"\")";
Debug.ShouldStop(16);
__ref.getField(false,"_sortpanels" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 70;BA.debugLine="sortPanels.Width = panel.Width/2";
Debug.ShouldStop(32);
__ref.getField(false,"_sortpanels" /*RemoteObject*/ ).runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 71;BA.debugLine="sortPanels.Height = 30dip";
Debug.ShouldStop(64);
__ref.getField(false,"_sortpanels" /*RemoteObject*/ ).runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 73;BA.debugLine="salesPanels.Initialize(\"\")";
Debug.ShouldStop(256);
__ref.getField(false,"_salespanels" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 74;BA.debugLine="salesPanels.Width = panel.Width / 2 ' Half of the";
Debug.ShouldStop(512);
__ref.getField(false,"_salespanels" /*RemoteObject*/ ).runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 75;BA.debugLine="salesPanels.Height = 30dip ' Height remains the s";
Debug.ShouldStop(1024);
__ref.getField(false,"_salespanels" /*RemoteObject*/ ).runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 77;BA.debugLine="radioPanel.Initialize(\"\")";
Debug.ShouldStop(4096);
__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 78;BA.debugLine="radioPanel.Width = panel.Width/2";
Debug.ShouldStop(8192);
__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 79;BA.debugLine="radioPanel.Height = 30dip";
Debug.ShouldStop(16384);
__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 81;BA.debugLine="radioLabelSalesTitles.Initialize(\"radioLabelSales";
Debug.ShouldStop(65536);
__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("radioLabelSalesTitles")));
 BA.debugLineNum = 82;BA.debugLine="radioLabelLegendTitles.Initialize(\"radioLabelLege";
Debug.ShouldStop(131072);
__ref.getField(false,"_radiolabellegendtitles" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("radioLabelLegendTitles")));
 BA.debugLineNum = 83;BA.debugLine="radioLabelSortTitles.Initialize(\"radioLabelSortTi";
Debug.ShouldStop(262144);
__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("radioLabelSortTitles")));
 BA.debugLineNum = 85;BA.debugLine="radioPanel.Color = Colors.Transparent ' Keep it t";
Debug.ShouldStop(1048576);
__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runVoidMethod ("setColor",bargraph.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 86;BA.debugLine="Dim borderPanel As Panel";
Debug.ShouldStop(2097152);
_borderpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("borderPanel", _borderpanel);
 BA.debugLineNum = 87;BA.debugLine="borderPanel.Initialize(\"\")";
Debug.ShouldStop(4194304);
_borderpanel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 88;BA.debugLine="borderPanel.Color = Colors.Black ' Border color";
Debug.ShouldStop(8388608);
_borderpanel.runVoidMethod ("setColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 89;BA.debugLine="panel.AddView(borderPanel, radioPanel.Left, radio";
Debug.ShouldStop(16777216);
_panel.runVoidMethod ("AddView",(Object)((_borderpanel.getObject())),(Object)(__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getLeft")),(Object)(__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getTop")),(Object)(__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getWidth")),(Object)(__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getHeight")));
 BA.debugLineNum = 90;BA.debugLine="panel.AddView(radioPanel, radioPanel.Left + 1dip,";
Debug.ShouldStop(33554432);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getLeft"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getTop"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getWidth"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getHeight"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 1)));
 BA.debugLineNum = 96;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
Debug.ShouldStop(-2147483648);
_legendwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"getWidth"),_legend.getField(true,"length")}, "/",0, 0));Debug.locals.put("legendWidth", _legendwidth);Debug.locals.put("legendWidth", _legendwidth);
 BA.debugLineNum = 97;BA.debugLine="checkBoxes = Array As CheckBox()";
Debug.ShouldStop(1);
__ref.setField ("_checkboxes" /*RemoteObject*/ ,RemoteObject.createNewArray("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper",new int[] {0},new Object[] {}));
 BA.debugLineNum = 98;BA.debugLine="checkedSales = Array As Boolean()";
Debug.ShouldStop(2);
__ref.setField ("_checkedsales" /*RemoteObject*/ ,RemoteObject.createNewArray("boolean",new int[] {0},new Object[] {}));
 BA.debugLineNum = 100;BA.debugLine="Dim checkBoxes(legend.Length) As CheckBox";
Debug.ShouldStop(8);
bargraph._checkboxes = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper", new int[] {_legend.getField(true,"length").<Integer>get().intValue()}, new Object[]{});__ref.setField("_checkboxes",bargraph._checkboxes);
 BA.debugLineNum = 101;BA.debugLine="Dim checkedSales(legend.Length) As Boolean";
Debug.ShouldStop(16);
bargraph._checkedsales = RemoteObject.createNewArray ("boolean", new int[] {_legend.getField(true,"length").<Integer>get().intValue()}, new Object[]{});__ref.setField("_checkedsales",bargraph._checkedsales);
 BA.debugLineNum = 102;BA.debugLine="If isFirstInit Then";
Debug.ShouldStop(32);
if (__ref.getField(true,"_isfirstinit" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 104;BA.debugLine="Dim tempCheckBoxes(legend.Length) As CheckBox";
Debug.ShouldStop(128);
_tempcheckboxes = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper", new int[] {_legend.getField(true,"length").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("tempCheckBoxes", _tempcheckboxes);
 BA.debugLineNum = 105;BA.debugLine="checkBoxes = tempCheckBoxes";
Debug.ShouldStop(256);
__ref.setField ("_checkboxes" /*RemoteObject*/ ,_tempcheckboxes);
 BA.debugLineNum = 106;BA.debugLine="Dim tempCheckedSales(legend.Length) As Boolean";
Debug.ShouldStop(512);
_tempcheckedsales = RemoteObject.createNewArray ("boolean", new int[] {_legend.getField(true,"length").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("tempCheckedSales", _tempcheckedsales);
 BA.debugLineNum = 107;BA.debugLine="checkedSales = tempCheckedSales";
Debug.ShouldStop(1024);
__ref.setField ("_checkedsales" /*RemoteObject*/ ,_tempcheckedsales);
 BA.debugLineNum = 110;BA.debugLine="For i = 0 To legend.Length - 1";
Debug.ShouldStop(8192);
{
final int step58 = 1;
final int limit58 = RemoteObject.solve(new RemoteObject[] {_legend.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step58 > 0 && _i <= limit58) || (step58 < 0 && _i >= limit58) ;_i = ((int)(0 + _i + step58))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 111;BA.debugLine="Dim chk As CheckBox";
Debug.ShouldStop(16384);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");Debug.locals.put("chk", _chk);
 BA.debugLineNum = 112;BA.debugLine="chk.Initialize(\"chkChange\")";
Debug.ShouldStop(32768);
_chk.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("chkChange")));
 BA.debugLineNum = 113;BA.debugLine="chk.Text = legend(i)";
Debug.ShouldStop(65536);
_chk.runMethod(true,"setText",BA.ObjectToCharSequence(_legend.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 114;BA.debugLine="chk.TextSize = 10";
Debug.ShouldStop(131072);
_chk.runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 115;BA.debugLine="chk.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(262144);
_chk.runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 116;BA.debugLine="chk.TextColor = color(i)";
Debug.ShouldStop(524288);
_chk.runMethod(true,"setTextColor",__ref.getField(false,"_color" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)));
 BA.debugLineNum = 117;BA.debugLine="chk.Tag = i";
Debug.ShouldStop(1048576);
_chk.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 118;BA.debugLine="chk.Checked = True  ' Default state";
Debug.ShouldStop(2097152);
_chk.runMethodAndSync(true,"setChecked",bargraph.__c.getField(true,"True"));
 BA.debugLineNum = 119;BA.debugLine="checkedSales(i) = True";
Debug.ShouldStop(4194304);
__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).setArrayElement (bargraph.__c.getField(true,"True"),BA.numberCast(int.class, _i));
 BA.debugLineNum = 120;BA.debugLine="legendPanel.AddView(chk, (legendWidth * i) + 30";
Debug.ShouldStop(8388608);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((_chk.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_legendwidth,RemoteObject.createImmutable(_i)}, "*",0, 1)),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "+",1, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(RemoteObject.solve(new RemoteObject[] {_legendwidth,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 1)),(Object)(__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"getHeight")));
 BA.debugLineNum = 121;BA.debugLine="checkBoxes(i) = chk";
Debug.ShouldStop(16777216);
__ref.getField(false,"_checkboxes" /*RemoteObject*/ ).setArrayElement (_chk,BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 123;BA.debugLine="isFirstInit = False";
Debug.ShouldStop(67108864);
__ref.setField ("_isfirstinit" /*RemoteObject*/ ,bargraph.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 126;BA.debugLine="For i = 0 To checkBoxes.Length - 1";
Debug.ShouldStop(536870912);
{
final int step73 = 1;
final int limit73 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_checkboxes" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step73 > 0 && _i <= limit73) || (step73 < 0 && _i >= limit73) ;_i = ((int)(0 + _i + step73))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 127;BA.debugLine="checkBoxes(i).Checked = checkedSales(i)";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_checkboxes" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, _i)).runMethodAndSync(true,"setChecked",__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 133;BA.debugLine="btnBack.Text = \"Back\"";
Debug.ShouldStop(16);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence("Back"));
 BA.debugLineNum = 134;BA.debugLine="btnBack.TextSize = 14";
Debug.ShouldStop(32);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 135;BA.debugLine="btnBack.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(64);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 136;BA.debugLine="btnBack.TextColor = Colors.White";
Debug.ShouldStop(128);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 137;BA.debugLine="Dim cdBack As ColorDrawable";
Debug.ShouldStop(256);
_cdback = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cdBack", _cdback);
 BA.debugLineNum = 138;BA.debugLine="cdBack.Initialize2(Colors.RGB(61, 12, 2), 10dip,";
Debug.ShouldStop(512);
_cdback.runVoidMethod ("Initialize2",(Object)(bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 139;BA.debugLine="btnBack.Background = cdBack";
Debug.ShouldStop(1024);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(false,"setBackground",(_cdback.getObject()));
 BA.debugLineNum = 142;BA.debugLine="btnNext.Text = \"Next\"";
Debug.ShouldStop(8192);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence("Next"));
 BA.debugLineNum = 143;BA.debugLine="btnNext.TextSize = 14";
Debug.ShouldStop(16384);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 144;BA.debugLine="btnNext.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(32768);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 145;BA.debugLine="btnNext.TextColor = Colors.White";
Debug.ShouldStop(65536);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 146;BA.debugLine="Dim cdNext As ColorDrawable";
Debug.ShouldStop(131072);
_cdnext = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cdNext", _cdnext);
 BA.debugLineNum = 147;BA.debugLine="cdNext.Initialize2(Colors.RGB(185, 46, 52), 10dip";
Debug.ShouldStop(262144);
_cdnext.runVoidMethod ("Initialize2",(Object)(bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 185)),(Object)(BA.numberCast(int.class, 46)),(Object)(BA.numberCast(int.class, 52)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 148;BA.debugLine="btnNext.Background = cdNext";
Debug.ShouldStop(524288);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(false,"setBackground",(_cdnext.getObject()));
 BA.debugLineNum = 150;BA.debugLine="Dim radioButtons() As RadioButton = Array As Radi";
Debug.ShouldStop(2097152);
_radiobuttons = RemoteObject.createNewArray("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper",new int[] {3},new Object[] {__ref.getField(false,"_sortbtn1" /*RemoteObject*/ ),__ref.getField(false,"_sortbtn2" /*RemoteObject*/ ),__ref.getField(false,"_defbtn" /*RemoteObject*/ )});Debug.locals.put("radioButtons", _radiobuttons);Debug.locals.put("radioButtons", _radiobuttons);
 BA.debugLineNum = 151;BA.debugLine="Dim radioTexts() As String = Array As String(\"ASC";
Debug.ShouldStop(4194304);
_radiotexts = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("ASC"),BA.ObjectToString("DESC"),RemoteObject.createImmutable("DEFAULT")});Debug.locals.put("radioTexts", _radiotexts);Debug.locals.put("radioTexts", _radiotexts);
 BA.debugLineNum = 153;BA.debugLine="If sortPanels.Width = 0 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_sortpanels" /*RemoteObject*/ ).runMethod(true,"getWidth"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 154;BA.debugLine="sortPanels.Width = panel.Width / 2 ' Default wid";
Debug.ShouldStop(33554432);
__ref.getField(false,"_sortpanels" /*RemoteObject*/ ).runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)));
 };
 BA.debugLineNum = 157;BA.debugLine="Dim totalButtons As Int = radioButtons.Length";
Debug.ShouldStop(268435456);
_totalbuttons = _radiobuttons.getField(true,"length");Debug.locals.put("totalButtons", _totalbuttons);Debug.locals.put("totalButtons", _totalbuttons);
 BA.debugLineNum = 158;BA.debugLine="Dim buttonWidth As Int = (sortPanels.Width - (tot";
Debug.ShouldStop(536870912);
_buttonwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sortpanels" /*RemoteObject*/ ).runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_totalbuttons,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "*",0, 1))}, "-",1, 1)),_totalbuttons}, "/",0, 0));Debug.locals.put("buttonWidth", _buttonwidth);Debug.locals.put("buttonWidth", _buttonwidth);
 BA.debugLineNum = 159;BA.debugLine="Dim spacing As Int = 5dip ' Small gap between but";
Debug.ShouldStop(1073741824);
_spacing = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("spacing", _spacing);Debug.locals.put("spacing", _spacing);
 BA.debugLineNum = 161;BA.debugLine="For i = 0 To totalButtons - 1";
Debug.ShouldStop(1);
{
final int step99 = 1;
final int limit99 = RemoteObject.solve(new RemoteObject[] {_totalbuttons,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step99 > 0 && _i <= limit99) || (step99 < 0 && _i >= limit99) ;_i = ((int)(0 + _i + step99))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 162;BA.debugLine="radioButtons(i).Text = radioTexts(i)";
Debug.ShouldStop(2);
_radiobuttons.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setText",BA.ObjectToCharSequence(_radiotexts.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 163;BA.debugLine="radioButtons(i).TextSize = 10";
Debug.ShouldStop(4);
_radiobuttons.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 164;BA.debugLine="radioButtons(i).Tag = radioTexts(i)";
Debug.ShouldStop(8);
_radiobuttons.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"setTag",(_radiotexts.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 165;BA.debugLine="radioButtons(i).Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(16);
_radiobuttons.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 166;BA.debugLine="radioButtons(i).TextColor = Colors.Black";
Debug.ShouldStop(32);
_radiobuttons.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 168;BA.debugLine="Dim cdNext As ColorDrawable";
Debug.ShouldStop(128);
_cdnext = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cdNext", _cdnext);
 BA.debugLineNum = 169;BA.debugLine="cdNext.Initialize2(Colors.RGB(128, 128, 128), 10";
Debug.ShouldStop(256);
_cdnext.runVoidMethod ("Initialize2",(Object)(bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 172;BA.debugLine="sortPanels.AddView(radioButtons(i), (i * (button";
Debug.ShouldStop(2048);
__ref.getField(false,"_sortpanels" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((_radiobuttons.getArrayElement(false,BA.numberCast(int.class, _i)).getObject())),(Object)((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {_buttonwidth,_spacing}, "+",1, 1))}, "*",0, 1))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(_buttonwidth),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 175;BA.debugLine="Dim salesLabels() As RadioButton = Array As Radio";
Debug.ShouldStop(16384);
_saleslabels = RemoteObject.createNewArray("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper",new int[] {3},new Object[] {__ref.getField(false,"_sales1" /*RemoteObject*/ ),__ref.getField(false,"_sales2" /*RemoteObject*/ ),__ref.getField(false,"_sales3" /*RemoteObject*/ )});Debug.locals.put("salesLabels", _saleslabels);Debug.locals.put("salesLabels", _saleslabels);
 BA.debugLineNum = 176;BA.debugLine="Dim salesTexts() As String = Array As String(\"1\",";
Debug.ShouldStop(32768);
_salestexts = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("1"),BA.ObjectToString("2"),RemoteObject.createImmutable("3")});Debug.locals.put("salesTexts", _salestexts);Debug.locals.put("salesTexts", _salestexts);
 BA.debugLineNum = 178;BA.debugLine="Dim totalLabels As Int = salesLabels.Length";
Debug.ShouldStop(131072);
_totallabels = _saleslabels.getField(true,"length");Debug.locals.put("totalLabels", _totallabels);Debug.locals.put("totalLabels", _totallabels);
 BA.debugLineNum = 179;BA.debugLine="Dim labelWidth As Int = (salesPanels.Width - (tot";
Debug.ShouldStop(262144);
_labelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_salespanels" /*RemoteObject*/ ).runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_totallabels,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "*",0, 1))}, "-",1, 1)),_totallabels}, "/",0, 0));Debug.locals.put("labelWidth", _labelwidth);Debug.locals.put("labelWidth", _labelwidth);
 BA.debugLineNum = 180;BA.debugLine="Dim spacing As Int = 5dip ' Small spacing between";
Debug.ShouldStop(524288);
_spacing = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("spacing", _spacing);Debug.locals.put("spacing", _spacing);
 BA.debugLineNum = 182;BA.debugLine="For i = 0 To totalLabels - 1";
Debug.ShouldStop(2097152);
{
final int step114 = 1;
final int limit114 = RemoteObject.solve(new RemoteObject[] {_totallabels,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step114 > 0 && _i <= limit114) || (step114 < 0 && _i >= limit114) ;_i = ((int)(0 + _i + step114))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 183;BA.debugLine="salesLabels(i).Text = \"Sales\" & (i + 1)";
Debug.ShouldStop(4194304);
_saleslabels.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Sales"),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)))));
 BA.debugLineNum = 184;BA.debugLine="salesLabels(i).TextSize = 10";
Debug.ShouldStop(8388608);
_saleslabels.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 185;BA.debugLine="salesLabels(i).Tag = salesTexts(i)";
Debug.ShouldStop(16777216);
_saleslabels.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"setTag",(_salestexts.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 186;BA.debugLine="salesLabels(i).Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(33554432);
_saleslabels.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 187;BA.debugLine="salesLabels(i).TextColor = Colors.Black";
Debug.ShouldStop(67108864);
_saleslabels.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 189;BA.debugLine="Dim cdBack As ColorDrawable";
Debug.ShouldStop(268435456);
_cdback = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cdBack", _cdback);
 BA.debugLineNum = 190;BA.debugLine="cdBack.Initialize2(Colors.RGB(128, 128, 128), 10";
Debug.ShouldStop(536870912);
_cdback.runVoidMethod ("Initialize2",(Object)(bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 194;BA.debugLine="salesPanels.AddView(salesLabels(i), (i * (labelW";
Debug.ShouldStop(2);
__ref.getField(false,"_salespanels" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((_saleslabels.getArrayElement(false,BA.numberCast(int.class, _i)).getObject())),(Object)((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {_labelwidth,_spacing}, "+",1, 1))}, "*",0, 1))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(_labelwidth),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 198;BA.debugLine="radioLabelSalesTitles.Text = \"Base on\"";
Debug.ShouldStop(32);
__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence("Base on"));
 BA.debugLineNum = 199;BA.debugLine="radioLabelSalesTitles.TextSize = 12";
Debug.ShouldStop(64);
__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 200;BA.debugLine="radioLabelSalesTitles.Typeface = Typeface.MONOSPA";
Debug.ShouldStop(128);
__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 201;BA.debugLine="radioLabelSalesTitles.TextColor = Colors.Black";
Debug.ShouldStop(256);
__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 203;BA.debugLine="radioLabelSortTitles.Text = \"Sort By\"";
Debug.ShouldStop(1024);
__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence("Sort By"));
 BA.debugLineNum = 204;BA.debugLine="radioLabelSortTitles.TextSize = 12";
Debug.ShouldStop(2048);
__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 205;BA.debugLine="radioLabelSortTitles.Typeface = Typeface.MONOSPAC";
Debug.ShouldStop(4096);
__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 206;BA.debugLine="radioLabelSortTitles.TextColor = Colors.Black";
Debug.ShouldStop(8192);
__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 209;BA.debugLine="radioLabelLegendTitles.Text = \"Shown\"";
Debug.ShouldStop(65536);
__ref.getField(false,"_radiolabellegendtitles" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence("Shown"));
 BA.debugLineNum = 210;BA.debugLine="radioLabelLegendTitles.TextSize = 12";
Debug.ShouldStop(131072);
__ref.getField(false,"_radiolabellegendtitles" /*RemoteObject*/ ).runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 211;BA.debugLine="radioLabelLegendTitles.Typeface = Typeface.MONOSP";
Debug.ShouldStop(262144);
__ref.getField(false,"_radiolabellegendtitles" /*RemoteObject*/ ).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 212;BA.debugLine="radioLabelLegendTitles.TextColor = Colors.Black";
Debug.ShouldStop(524288);
__ref.getField(false,"_radiolabellegendtitles" /*RemoteObject*/ ).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 215;BA.debugLine="DrawGraph(Active, panel, sale1, sale2, sale3, pro";
Debug.ShouldStop(4194304);
__ref.runClassMethod (b4a.example.bargraph.class, "_drawgraph" /*RemoteObject*/ ,(Object)(_active),(Object)(_panel),(Object)(_sale1),(Object)(_sale2),(Object)(_sale3),(Object)(_product),(Object)(_maxsales),(Object)(_titlestring));
 BA.debugLineNum = 216;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("productLabel_Click (bargraph) ","bargraph",5,__ref.getField(false, "ba"),__ref,382);
if (RapidSub.canDelegate("productlabel_click")) { return __ref.runUserSub(false, "bargraph","productlabel_click", __ref);}
RemoteObject _clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _selectedcompany = RemoteObject.createImmutable(0);
 BA.debugLineNum = 382;BA.debugLine="Sub productLabel_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 383;BA.debugLine="Dim clickedLabel As Label = Sender";
Debug.ShouldStop(1073741824);
_clickedlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), bargraph.__c.runMethod(false,"Sender",__ref.getField(false, "ba")));Debug.locals.put("clickedLabel", _clickedlabel);Debug.locals.put("clickedLabel", _clickedlabel);
 BA.debugLineNum = 384;BA.debugLine="Dim selectedCompany As Int = clickedLabel.Tag";
Debug.ShouldStop(-2147483648);
_selectedcompany = BA.numberCast(int.class, _clickedlabel.runMethod(false,"getTag"));Debug.locals.put("selectedCompany", _selectedcompany);Debug.locals.put("selectedCompany", _selectedcompany);
 BA.debugLineNum = 385;BA.debugLine="Log(\"Selected Company ID: \" & selectedCompany)";
Debug.ShouldStop(1);
bargraph.__c.runVoidMethod ("LogImpl","54980739",RemoteObject.concat(RemoteObject.createImmutable("Selected Company ID: "),_selectedcompany),0);
 BA.debugLineNum = 386;BA.debugLine="Starter.company_selected = selectedCompany";
Debug.ShouldStop(2);
bargraph._starter._company_selected /*RemoteObject*/  = BA.NumberToString(_selectedcompany);
 BA.debugLineNum = 387;BA.debugLine="StartActivity(layout)";
Debug.ShouldStop(4);
bargraph.__c.runVoidMethod ("StartActivity",__ref.getField(false, "ba"),(Object)((__ref.getField(true,"_layout" /*RemoteObject*/ ))));
 BA.debugLineNum = 388;BA.debugLine="Active1.Finish";
Debug.ShouldStop(8);
__ref.getField(false,"_active1" /*RemoteObject*/ ).runVoidMethod ("Finish");
 BA.debugLineNum = 389;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setcurrentpage(RemoteObject __ref,RemoteObject _page) throws Exception{
try {
		Debug.PushSubsStack("SetCurrentPage (bargraph) ","bargraph",5,__ref.getField(false, "ba"),__ref,377);
if (RapidSub.canDelegate("setcurrentpage")) { return __ref.runUserSub(false, "bargraph","setcurrentpage", __ref, _page);}
Debug.locals.put("page", _page);
 BA.debugLineNum = 377;BA.debugLine="Public Sub SetCurrentPage(page As Int)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 378;BA.debugLine="currentPage = page";
Debug.ShouldStop(33554432);
__ref.setField ("_currentpage" /*RemoteObject*/ ,_page);
 BA.debugLineNum = 379;BA.debugLine="UpdateGraph";
Debug.ShouldStop(67108864);
__ref.runClassMethod (b4a.example.bargraph.class, "_updategraph" /*RemoteObject*/ );
 BA.debugLineNum = 380;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _updategraph(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("UpdateGraph (bargraph) ","bargraph",5,__ref.getField(false, "ba"),__ref,369);
if (RapidSub.canDelegate("updategraph")) { return __ref.runUserSub(false, "bargraph","updategraph", __ref);}
 BA.debugLineNum = 369;BA.debugLine="Public Sub UpdateGraph";
Debug.ShouldStop(65536);
 BA.debugLineNum = 370;BA.debugLine="DrawGraph(Active1, panel_l, sale_1, sale_2, sale_";
Debug.ShouldStop(131072);
__ref.runClassMethod (b4a.example.bargraph.class, "_drawgraph" /*RemoteObject*/ ,(Object)(__ref.getField(false,"_active1" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_panel_l" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_1" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_2" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_3" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_product1" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_maxsales1" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_titlestring1" /*RemoteObject*/ )));
 BA.debugLineNum = 371;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}