package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class bargraph_subs_0 {


public static RemoteObject  _chkchange_checkedchange(RemoteObject __ref,RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("chkChange_CheckedChange (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,463);
if (RapidSub.canDelegate("chkchange_checkedchange")) { return __ref.runUserSub(false, "bargraph","chkchange_checkedchange", __ref, _checked);}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _index = RemoteObject.createImmutable(0);
RemoteObject _checkedcount = RemoteObject.createImmutable(0);
int _i = 0;
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 463;BA.debugLine="Sub chkChange_CheckedChange(Checked As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 464;BA.debugLine="If Sender Is CheckBox Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("i",bargraph.__c.runMethod(false,"Sender",__ref.getField(false, "ba")), RemoteObject.createImmutable("android.widget.CheckBox"))) { 
 BA.debugLineNum = 465;BA.debugLine="Dim chk As CheckBox = Sender";
Debug.ShouldStop(65536);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper"), bargraph.__c.runMethod(false,"Sender",__ref.getField(false, "ba")));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 466;BA.debugLine="Dim index As Int = chk.Tag";
Debug.ShouldStop(131072);
_index = BA.numberCast(int.class, _chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 468;BA.debugLine="Dim checkedCount As Int = 0";
Debug.ShouldStop(524288);
_checkedcount = BA.numberCast(int.class, 0);Debug.locals.put("checkedCount", _checkedcount);Debug.locals.put("checkedCount", _checkedcount);
 BA.debugLineNum = 469;BA.debugLine="For i = 0 To checkedSales.Length - 1";
Debug.ShouldStop(1048576);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 470;BA.debugLine="If checkedSales(i) = True Then checkedCount = c";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)),bargraph.__c.getField(true,"True"))) { 
_checkedcount = RemoteObject.solve(new RemoteObject[] {_checkedcount,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("checkedCount", _checkedcount);};
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 473;BA.debugLine="If Checked = False And checkedCount = 1 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_checked,bargraph.__c.getField(true,"False")) && RemoteObject.solveBoolean("=",_checkedcount,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 474;BA.debugLine="chk.Checked = True";
Debug.ShouldStop(33554432);
_chk.runMethodAndSync(true,"setChecked",bargraph.__c.getField(true,"True"));
 BA.debugLineNum = 475;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 478;BA.debugLine="checkedSales(index) = Checked";
Debug.ShouldStop(536870912);
__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).setArrayElement (_checked,_index);
 BA.debugLineNum = 479;BA.debugLine="UpdateGraph ' Call DrawGraph without parameters";
Debug.ShouldStop(1073741824);
__ref.runClassMethod (b4a.example.bargraph.class, "_updategraph" /*RemoteObject*/ );
 }else {
 BA.debugLineNum = 481;BA.debugLine="Log(\"Error: Sender is not a CheckBox\")";
Debug.ShouldStop(1);
bargraph.__c.runVoidMethod ("LogImpl","23997714",RemoteObject.createImmutable("Error: Sender is not a CheckBox"),0);
 };
 BA.debugLineNum = 483;BA.debugLine="End Sub";
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
bargraph._checkboxes = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper", new int[] {0}, new Object[]{});__ref.setField("_checkboxes",bargraph._checkboxes);
 //BA.debugLineNum = 3;BA.debugLine="Public checkedSales() As Boolean";
bargraph._checkedsales = RemoteObject.createNewArray ("boolean", new int[] {0}, new Object[]{});__ref.setField("_checkedsales",bargraph._checkedsales);
 //BA.debugLineNum = 4;BA.debugLine="Dim color() As Int = Array As Int(Colors.RGB(255,";
bargraph._color = RemoteObject.createNewArray("int",new int[] {3},new Object[] {bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))),bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 200)),(Object)(BA.numberCast(int.class, 20)),(Object)(BA.numberCast(int.class, 20))),bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 10)))});__ref.setField("_color",bargraph._color);
 //BA.debugLineNum = 5;BA.debugLine="Dim legendPanel As Panel";
bargraph._legendpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_legendpanel",bargraph._legendpanel);
 //BA.debugLineNum = 6;BA.debugLine="Dim salePanel As Panel";
bargraph._salepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_salepanel",bargraph._salepanel);
 //BA.debugLineNum = 7;BA.debugLine="Dim radioPanel As Panel";
bargraph._radiopanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_radiopanel",bargraph._radiopanel);
 //BA.debugLineNum = 8;BA.debugLine="Dim sortPanel As Panel";
bargraph._sortpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_sortpanel",bargraph._sortpanel);
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
 //BA.debugLineNum = 34;BA.debugLine="Dim sortMainpanel As Panel";
bargraph._sortmainpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_sortmainpanel",bargraph._sortmainpanel);
 //BA.debugLineNum = 35;BA.debugLine="Dim showHideBtn As Button";
bargraph._showhidebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");__ref.setField("_showhidebtn",bargraph._showhidebtn);
 //BA.debugLineNum = 36;BA.debugLine="Dim paginationLabel As Label";
bargraph._paginationlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");__ref.setField("_paginationlabel",bargraph._paginationlabel);
 //BA.debugLineNum = 37;BA.debugLine="Dim pageNo As Int = 1";
bargraph._pageno = BA.numberCast(int.class, 1);__ref.setField("_pageno",bargraph._pageno);
 //BA.debugLineNum = 38;BA.debugLine="Dim totalPages As Int = 1";
bargraph._totalpages = BA.numberCast(int.class, 1);__ref.setField("_totalpages",bargraph._totalpages);
 //BA.debugLineNum = 39;BA.debugLine="Dim hideShowBoolean As Boolean";
bargraph._hideshowboolean = RemoteObject.createImmutable(false);__ref.setField("_hideshowboolean",bargraph._hideshowboolean);
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _drawgraph(RemoteObject __ref,RemoteObject _active,RemoteObject _panel,RemoteObject _sale1,RemoteObject _sale2,RemoteObject _sale3,RemoteObject _product,RemoteObject _maxsales,RemoteObject _titlestring) throws Exception{
try {
		Debug.PushSubsStack("DrawGraph (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,221);
if (RapidSub.canDelegate("drawgraph")) { return __ref.runUserSub(false, "bargraph","drawgraph", __ref, _active, _panel, _sale1, _sale2, _sale3, _product, _maxsales, _titlestring);}
RemoteObject _halfwidth = RemoteObject.createImmutable(0);
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
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
RemoteObject _productlabelwidth = RemoteObject.createImmutable(0);
RemoteObject _numlabels = RemoteObject.createImmutable(0);
RemoteObject _labelvalue = RemoteObject.createImmutable(0);
RemoteObject _labelypos = RemoteObject.createImmutable(0);
RemoteObject _yaxislabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _buttonwidth = RemoteObject.createImmutable(0);
RemoteObject _buttonheight = RemoteObject.createImmutable(0);
RemoteObject _btnmainpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _paginationpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
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
 BA.debugLineNum = 221;BA.debugLine="Public Sub DrawGraph(Active As Activity, panel As";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 222;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 223;BA.debugLine="panel.Invalidate";
Debug.ShouldStop(1073741824);
_panel.runVoidMethod ("Invalidate");
 BA.debugLineNum = 224;BA.debugLine="panel.RemoveAllViews";
Debug.ShouldStop(-2147483648);
_panel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 225;BA.debugLine="panel.Height = 530dip";
Debug.ShouldStop(1);
_panel.runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 530))));
 BA.debugLineNum = 226;BA.debugLine="If panel.Width = 0 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_panel.runMethod(true,"getWidth"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 227;BA.debugLine="panel.Width = 800dip";
Debug.ShouldStop(4);
_panel.runMethod(true,"setWidth",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 800))));
 };
 BA.debugLineNum = 229;BA.debugLine="Dim halfWidth As Int = panel.Width / 2";
Debug.ShouldStop(16);
_halfwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("halfWidth", _halfwidth);Debug.locals.put("halfWidth", _halfwidth);
 BA.debugLineNum = 230;BA.debugLine="If sortMainpanel.IsInitialized = False Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).runMethod(true,"IsInitialized"),bargraph.__c.getField(true,"False"))) { 
 BA.debugLineNum = 231;BA.debugLine="sortMainpanel.Initialize(\"\")";
Debug.ShouldStop(64);
__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 };
 BA.debugLineNum = 233;BA.debugLine="sortMainpanel.Left = 0dip";
Debug.ShouldStop(256);
__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).runMethod(true,"setLeft",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 234;BA.debugLine="sortMainpanel.Top = 5dip";
Debug.ShouldStop(512);
__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).runMethod(true,"setTop",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))));
 BA.debugLineNum = 235;BA.debugLine="sortMainpanel.Width = halfWidth";
Debug.ShouldStop(1024);
__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).runMethod(true,"setWidth",_halfwidth);
 BA.debugLineNum = 236;BA.debugLine="sortMainpanel.Height = 120dip";
Debug.ShouldStop(2048);
__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))));
 BA.debugLineNum = 237;BA.debugLine="panel.AddView(sortMainpanel, 0dip, 5dip, halfWid";
Debug.ShouldStop(4096);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).getObject())),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(_halfwidth),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))));
 BA.debugLineNum = 239;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(16384);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 240;BA.debugLine="cd.Initialize2(Colors.White, 5dip, 1dip, Colors.";
Debug.ShouldStop(32768);
_cd.runVoidMethod ("Initialize2",(Object)(bargraph.__c.getField(false,"Colors").getField(true,"White")),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 241;BA.debugLine="panel.AddView(legendPanel, halfWidth +10dip, 10d";
Debug.ShouldStop(65536);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_halfwidth,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "+",1, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {_halfwidth,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 45)))));
 BA.debugLineNum = 242;BA.debugLine="legendPanel.Background = cd";
Debug.ShouldStop(131072);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 244;BA.debugLine="radioLabelLegendTitles.Initialize(\"radioLabelLeg";
Debug.ShouldStop(524288);
__ref.getField(false,"_radiolabellegendtitles" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("radioLabelLegendTitles")));
 BA.debugLineNum = 245;BA.debugLine="radioLabelLegendTitles.Text = \"Shown Details\"";
Debug.ShouldStop(1048576);
__ref.getField(false,"_radiolabellegendtitles" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence("Shown Details"));
 BA.debugLineNum = 246;BA.debugLine="radioLabelLegendTitles.TextSize = 8";
Debug.ShouldStop(2097152);
__ref.getField(false,"_radiolabellegendtitles" /*RemoteObject*/ ).runMethod(true,"setTextSize",BA.numberCast(float.class, 8));
 BA.debugLineNum = 247;BA.debugLine="radioLabelLegendTitles.Typeface = Typeface.MONOS";
Debug.ShouldStop(4194304);
__ref.getField(false,"_radiolabellegendtitles" /*RemoteObject*/ ).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 248;BA.debugLine="radioLabelLegendTitles.Gravity = Gravity.CENTER";
Debug.ShouldStop(8388608);
__ref.getField(false,"_radiolabellegendtitles" /*RemoteObject*/ ).runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 249;BA.debugLine="radioLabelLegendTitles.TextColor = Colors.Black";
Debug.ShouldStop(16777216);
__ref.getField(false,"_radiolabellegendtitles" /*RemoteObject*/ ).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 250;BA.debugLine="radioLabelLegendTitles.Color = Colors.White";
Debug.ShouldStop(33554432);
__ref.getField(false,"_radiolabellegendtitles" /*RemoteObject*/ ).runVoidMethod ("setColor",bargraph.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 251;BA.debugLine="panel.AddView(radioLabelLegendTitles, halfWidth+";
Debug.ShouldStop(67108864);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_radiolabellegendtitles" /*RemoteObject*/ ).getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_halfwidth,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))}, "+",1, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2.5)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 BA.debugLineNum = 254;BA.debugLine="Dim activityPanel As Panel";
Debug.ShouldStop(536870912);
_activitypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("activityPanel", _activitypanel);
 BA.debugLineNum = 255;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
Debug.ShouldStop(1073741824);
_activitypanel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("activityPanel")));
 BA.debugLineNum = 257;BA.debugLine="activityPanel.Width = 80%x";
Debug.ShouldStop(1);
_activitypanel.runMethod(true,"setWidth",bargraph.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),__ref.getField(false, "ba")));
 BA.debugLineNum = 258;BA.debugLine="If Active.Width > 800 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean(">",_active.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 259;BA.debugLine="activityPanel.Width = 55%x";
Debug.ShouldStop(4);
_activitypanel.runMethod(true,"setWidth",bargraph.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 55)),__ref.getField(false, "ba")));
 };
 BA.debugLineNum = 261;BA.debugLine="activityPanel.Height = 250dip";
Debug.ShouldStop(16);
_activitypanel.runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))));
 BA.debugLineNum = 262;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211,";
Debug.ShouldStop(32);
_activitypanel.runVoidMethod ("setColor",bargraph.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 70)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211))));
 BA.debugLineNum = 264;BA.debugLine="Dim alignLeftCenter As Int = (Active.Width - act";
Debug.ShouldStop(128);
_alignleftcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_active.runMethod(true,"getWidth"),_activitypanel.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignLeftCenter", _alignleftcenter);Debug.locals.put("alignLeftCenter", _alignleftcenter);
 BA.debugLineNum = 265;BA.debugLine="Dim alignTopCenter As Int = (panel.Height - acti";
Debug.ShouldStop(256);
_aligntopcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getHeight"),_activitypanel.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "/-",1, 0));Debug.locals.put("alignTopCenter", _aligntopcenter);Debug.locals.put("alignTopCenter", _aligntopcenter);
 BA.debugLineNum = 267;BA.debugLine="Dim Title As Label";
Debug.ShouldStop(1024);
_title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Title", _title);
 BA.debugLineNum = 268;BA.debugLine="Title.Initialize(\"\")";
Debug.ShouldStop(2048);
_title.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 269;BA.debugLine="Title.Text = TitleString";
Debug.ShouldStop(4096);
_title.runMethod(true,"setText",BA.ObjectToCharSequence(_titlestring));
 BA.debugLineNum = 270;BA.debugLine="Title.TextSize = 20";
Debug.ShouldStop(8192);
_title.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 271;BA.debugLine="Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(16384);
_title.runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 272;BA.debugLine="Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(32768);
_title.runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 273;BA.debugLine="Title.TextColor = Colors.Black";
Debug.ShouldStop(65536);
_title.runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 274;BA.debugLine="panel.AddView(Title, 0, alignTopCenter / 2 +55di";
Debug.ShouldStop(131072);
_panel.runVoidMethod ("AddView",(Object)((_title.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_aligntopcenter,RemoteObject.createImmutable(2),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))}, "/+",1, 0))),(Object)(_panel.runMethod(true,"getWidth")),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 276;BA.debugLine="panel.AddView(activityPanel, alignLeftCenter, al";
Debug.ShouldStop(524288);
_panel.runVoidMethod ("AddView",(Object)((_activitypanel.getObject())),(Object)(_alignleftcenter),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_aligntopcenter,(RemoteObject.solve(new RemoteObject[] {_aligntopcenter,RemoteObject.createImmutable(4)}, "/",0, 0))}, "+",1, 0))),(Object)(_activitypanel.runMethod(true,"getWidth")),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 278;BA.debugLine="Dim graphCanvas As Canvas";
Debug.ShouldStop(2097152);
_graphcanvas = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("graphCanvas", _graphcanvas);
 BA.debugLineNum = 279;BA.debugLine="graphCanvas.Initialize(activityPanel)";
Debug.ShouldStop(4194304);
_graphcanvas.runVoidMethod ("Initialize",(Object)((_activitypanel.getObject())));
 BA.debugLineNum = 281;BA.debugLine="Dim maxSale As Int = maxSales * 1.2";
Debug.ShouldStop(16777216);
_maxsale = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_maxsales,RemoteObject.createImmutable(1.2)}, "*",0, 0));Debug.locals.put("maxSale", _maxsale);Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 282;BA.debugLine="Dim cv As Canvas";
Debug.ShouldStop(33554432);
_cv = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cv", _cv);
 BA.debugLineNum = 283;BA.debugLine="cv.Initialize(panel)";
Debug.ShouldStop(67108864);
_cv.runVoidMethod ("Initialize",(Object)((_panel.getObject())));
 BA.debugLineNum = 285;BA.debugLine="Dim totalProducts As Int = sale1.Length";
Debug.ShouldStop(268435456);
_totalproducts = _sale1.getField(true,"length");Debug.locals.put("totalProducts", _totalproducts);Debug.locals.put("totalProducts", _totalproducts);
 BA.debugLineNum = 286;BA.debugLine="Dim startIndex As Int = (currentPage - 1) * item";
Debug.ShouldStop(536870912);
_startindex = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_currentpage" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1)),__ref.getField(true,"_itemsperpage" /*RemoteObject*/ )}, "*",0, 1);Debug.locals.put("startIndex", _startindex);Debug.locals.put("startIndex", _startindex);
 BA.debugLineNum = 287;BA.debugLine="Dim endIndex As Int = Min(startIndex + itemsPerP";
Debug.ShouldStop(1073741824);
_endindex = BA.numberCast(int.class, bargraph.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_startindex,__ref.getField(true,"_itemsperpage" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+-",2, 1))),(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_totalproducts,RemoteObject.createImmutable(1)}, "-",1, 1)))));Debug.locals.put("endIndex", _endindex);Debug.locals.put("endIndex", _endindex);
 BA.debugLineNum = 288;BA.debugLine="Dim barsPerProduct As Int = 3";
Debug.ShouldStop(-2147483648);
_barsperproduct = BA.numberCast(int.class, 3);Debug.locals.put("barsPerProduct", _barsperproduct);Debug.locals.put("barsPerProduct", _barsperproduct);
 BA.debugLineNum = 289;BA.debugLine="Dim totalBars As Int = (endIndex - startIndex +";
Debug.ShouldStop(1);
_totalbars = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_endindex,_startindex,RemoteObject.createImmutable(1)}, "-+",2, 1)),_barsperproduct}, "*",0, 1);Debug.locals.put("totalBars", _totalbars);Debug.locals.put("totalBars", _totalbars);
 BA.debugLineNum = 290;BA.debugLine="Dim gap As Int = 5dip";
Debug.ShouldStop(2);
_gap = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("gap", _gap);Debug.locals.put("gap", _gap);
 BA.debugLineNum = 291;BA.debugLine="Dim productGap As Int = 0dip";
Debug.ShouldStop(4);
_productgap = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("productGap", _productgap);Debug.locals.put("productGap", _productgap);
 BA.debugLineNum = 292;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(8);
_padding = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 294;BA.debugLine="Dim availableWidth As Int = activityPanel.Width";
Debug.ShouldStop(32);
_availablewidth = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_padding,RemoteObject.createImmutable(2)}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_endindex,_startindex,RemoteObject.createImmutable(1)}, "-+",2, 1)),RemoteObject.createImmutable(1)}, "-",1, 1)),_productgap}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_totalbars,(RemoteObject.solve(new RemoteObject[] {_endindex,_startindex,RemoteObject.createImmutable(1)}, "-+",2, 1))}, "-",1, 1)),_gap}, "*",0, 1))}, "---",3, 1);Debug.locals.put("availableWidth", _availablewidth);Debug.locals.put("availableWidth", _availablewidth);
 BA.debugLineNum = 295;BA.debugLine="Dim barWidth As Int = availableWidth / totalBars";
Debug.ShouldStop(64);
_barwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_availablewidth,_totalbars}, "/",0, 0));Debug.locals.put("barWidth", _barwidth);Debug.locals.put("barWidth", _barwidth);
 BA.debugLineNum = 296;BA.debugLine="Dim xStart As Int = padding";
Debug.ShouldStop(128);
_xstart = _padding;Debug.locals.put("xStart", _xstart);Debug.locals.put("xStart", _xstart);
 BA.debugLineNum = 298;BA.debugLine="For i = startIndex To endIndex";
Debug.ShouldStop(512);
{
final int step64 = 1;
final int limit64 = _endindex.<Integer>get().intValue();
_i = _startindex.<Integer>get().intValue() ;
for (;(step64 > 0 && _i <= limit64) || (step64 < 0 && _i >= limit64) ;_i = ((int)(0 + _i + step64))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 299;BA.debugLine="Dim xPos As Int = xStart + (i - startIndex) * (";
Debug.ShouldStop(1024);
_xpos = RemoteObject.solve(new RemoteObject[] {_xstart,(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),_startindex}, "-",1, 1)),(RemoteObject.solve(new RemoteObject[] {_barsperproduct,(RemoteObject.solve(new RemoteObject[] {_barwidth,_gap}, "+",1, 1)),_productgap}, "*+",1, 1))}, "+*",1, 1);Debug.locals.put("xPos", _xpos);Debug.locals.put("xPos", _xpos);
 BA.debugLineNum = 300;BA.debugLine="Dim saleValues() As Int = Array As Int(sale1(i)";
Debug.ShouldStop(2048);
_salevalues = RemoteObject.createNewArray("int",new int[] {3},new Object[] {_sale1.getArrayElement(true,BA.numberCast(int.class, _i)),_sale2.getArrayElement(true,BA.numberCast(int.class, _i)),_sale3.getArrayElement(true,BA.numberCast(int.class, _i))});Debug.locals.put("saleValues", _salevalues);Debug.locals.put("saleValues", _salevalues);
 BA.debugLineNum = 301;BA.debugLine="Dim indexOffset As Int = 0";
Debug.ShouldStop(4096);
_indexoffset = BA.numberCast(int.class, 0);Debug.locals.put("indexOffset", _indexoffset);Debug.locals.put("indexOffset", _indexoffset);
 BA.debugLineNum = 303;BA.debugLine="For j = 0 To barsPerProduct - 1";
Debug.ShouldStop(16384);
{
final int step68 = 1;
final int limit68 = RemoteObject.solve(new RemoteObject[] {_barsperproduct,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_j = 0 ;
for (;(step68 > 0 && _j <= limit68) || (step68 < 0 && _j >= limit68) ;_j = ((int)(0 + _j + step68))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 304;BA.debugLine="If j < checkedSales.Length And checkedSales(j)";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("<",RemoteObject.createImmutable(_j),BA.numberCast(double.class, __ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getField(true,"length"))) && RemoteObject.solveBoolean(".",__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _j)))) { 
 BA.debugLineNum = 305;BA.debugLine="Dim sale As Int = saleValues(j)";
Debug.ShouldStop(65536);
_sale = _salevalues.getArrayElement(true,BA.numberCast(int.class, _j));Debug.locals.put("sale", _sale);Debug.locals.put("sale", _sale);
 BA.debugLineNum = 306;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * (ac";
Debug.ShouldStop(131072);
_barheight = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_sale,_maxsale}, "/",0, 0)),(_activitypanel.runMethod(true,"getHeight"))}, "*",0, 0));Debug.locals.put("barHeight", _barheight);Debug.locals.put("barHeight", _barheight);
 BA.debugLineNum = 307;BA.debugLine="Dim xBar As Int = xPos + indexOffset * barWid";
Debug.ShouldStop(262144);
_xbar = RemoteObject.solve(new RemoteObject[] {_xpos,_indexoffset,_barwidth}, "+*",1, 1);Debug.locals.put("xBar", _xbar);Debug.locals.put("xBar", _xbar);
 BA.debugLineNum = 309;BA.debugLine="Dim r As Rect";
Debug.ShouldStop(1048576);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r", _r);
 BA.debugLineNum = 310;BA.debugLine="r.Initialize(xBar, activityPanel.Height - bar";
Debug.ShouldStop(2097152);
_r.runVoidMethod ("Initialize",(Object)(_xbar),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_xbar,_barwidth}, "+",1, 1)),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 311;BA.debugLine="graphCanvas.DrawRect(r, color(j), True, 2dip)";
Debug.ShouldStop(4194304);
_graphcanvas.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(__ref.getField(false,"_color" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _j))),(Object)(bargraph.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 313;BA.debugLine="Dim fontSize As Int = 8";
Debug.ShouldStop(16777216);
_fontsize = BA.numberCast(int.class, 8);Debug.locals.put("fontSize", _fontsize);Debug.locals.put("fontSize", _fontsize);
 BA.debugLineNum = 314;BA.debugLine="If Active.Width > 800 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean(">",_active.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 315;BA.debugLine="fontSize = 10";
Debug.ShouldStop(67108864);
_fontsize = BA.numberCast(int.class, 10);Debug.locals.put("fontSize", _fontsize);
 };
 BA.debugLineNum = 317;BA.debugLine="graphCanvas.DrawText(FormatNumberWithSuffix(s";
Debug.ShouldStop(268435456);
_graphcanvas.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(__ref.runClassMethod (b4a.example.bargraph.class, "_formatnumberwithsuffix" /*RemoteObject*/ ,(Object)(_sale))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_xbar,(RemoteObject.solve(new RemoteObject[] {_barwidth,RemoteObject.createImmutable(2)}, "/",0, 0))}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "--",2, 1))),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, _fontsize)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("CENTER"))));
 BA.debugLineNum = 318;BA.debugLine="indexOffset = indexOffset + 1";
Debug.ShouldStop(536870912);
_indexoffset = RemoteObject.solve(new RemoteObject[] {_indexoffset,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("indexOffset", _indexoffset);
 };
 }
}Debug.locals.put("j", _j);
;
 BA.debugLineNum = 322;BA.debugLine="Dim productLabel As Label";
Debug.ShouldStop(2);
_productlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("productLabel", _productlabel);
 BA.debugLineNum = 323;BA.debugLine="productLabel.Initialize(\"productLabel\")";
Debug.ShouldStop(4);
_productlabel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("productLabel")));
 BA.debugLineNum = 324;BA.debugLine="productLabel.Text = product(i)";
Debug.ShouldStop(8);
_productlabel.runMethod(true,"setText",BA.ObjectToCharSequence(_product.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 325;BA.debugLine="productLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(16);
_productlabel.runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 326;BA.debugLine="productLabel.TextSize = 12";
Debug.ShouldStop(32);
_productlabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 327;BA.debugLine="productLabel.Tag = comId1(i)";
Debug.ShouldStop(64);
_productlabel.runMethod(false,"setTag",(__ref.getField(false,"_comid1" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 328;BA.debugLine="productLabel.TextColor = Colors.Black";
Debug.ShouldStop(128);
_productlabel.runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 329;BA.debugLine="productLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(256);
_productlabel.runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 330;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
Debug.ShouldStop(512);
_productlabely = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1);Debug.locals.put("productLabelY", _productlabely);Debug.locals.put("productLabelY", _productlabely);
 BA.debugLineNum = 331;BA.debugLine="Dim productLabelX As Int = alignLeftCenter";
Debug.ShouldStop(1024);
_productlabelx = _alignleftcenter;Debug.locals.put("productLabelX", _productlabelx);Debug.locals.put("productLabelX", _productlabelx);
 BA.debugLineNum = 332;BA.debugLine="Dim productLabelWidth As Int = (activityPanel.W";
Debug.ShouldStop(2048);
_productlabelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getWidth"),_totalproducts}, "/",0, 0)),(RemoteObject.solve(new RemoteObject[] {_padding,_gap}, "+",1, 1))}, "-",1, 0));Debug.locals.put("productLabelWidth", _productlabelwidth);Debug.locals.put("productLabelWidth", _productlabelwidth);
 BA.debugLineNum = 333;BA.debugLine="panel.AddView(productLabel, xPos + productLabel";
Debug.ShouldStop(4096);
_panel.runVoidMethod ("AddView",(Object)((_productlabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_xpos,_productlabelx}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_productlabely,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "+",1, 1)),(Object)(_productlabelwidth),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 336;BA.debugLine="Dim numLabels As Int = 10";
Debug.ShouldStop(32768);
_numlabels = BA.numberCast(int.class, 10);Debug.locals.put("numLabels", _numlabels);Debug.locals.put("numLabels", _numlabels);
 BA.debugLineNum = 337;BA.debugLine="For i = 0 To numLabels";
Debug.ShouldStop(65536);
{
final int step98 = 1;
final int limit98 = _numlabels.<Integer>get().intValue();
_i = 0 ;
for (;(step98 > 0 && _i <= limit98) || (step98 < 0 && _i >= limit98) ;_i = ((int)(0 + _i + step98))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 338;BA.debugLine="Dim labelValue As Int = Round((maxSale / numLab";
Debug.ShouldStop(131072);
_labelvalue = BA.numberCast(int.class, bargraph.__c.runMethod(true,"Round",(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_maxsale,_numlabels}, "/",0, 0)),RemoteObject.createImmutable(_i)}, "*",0, 0))));Debug.locals.put("labelValue", _labelvalue);Debug.locals.put("labelValue", _labelvalue);
 BA.debugLineNum = 339;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - (";
Debug.ShouldStop(262144);
_labelypos = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_labelvalue,_maxsale}, "/",0, 0)),_activitypanel.runMethod(true,"getHeight")}, "*",0, 0))}, "-",1, 0));Debug.locals.put("labelYPos", _labelypos);Debug.locals.put("labelYPos", _labelypos);
 BA.debugLineNum = 341;BA.debugLine="Dim yAxisLabel As Label";
Debug.ShouldStop(1048576);
_yaxislabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("yAxisLabel", _yaxislabel);
 BA.debugLineNum = 342;BA.debugLine="yAxisLabel.Initialize(\"\")";
Debug.ShouldStop(2097152);
_yaxislabel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 343;BA.debugLine="yAxisLabel.Text = FormatNumberWithLabel(labelVa";
Debug.ShouldStop(4194304);
_yaxislabel.runMethod(true,"setText",BA.ObjectToCharSequence(__ref.runClassMethod (b4a.example.bargraph.class, "_formatnumberwithlabel" /*RemoteObject*/ ,(Object)(_labelvalue))));
 BA.debugLineNum = 344;BA.debugLine="yAxisLabel.TextSize = 10";
Debug.ShouldStop(8388608);
_yaxislabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 345;BA.debugLine="yAxisLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(16777216);
_yaxislabel.runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 346;BA.debugLine="yAxisLabel.TextColor = Colors.Black";
Debug.ShouldStop(33554432);
_yaxislabel.runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 347;BA.debugLine="yAxisLabel.Gravity = Gravity.RIGHT";
Debug.ShouldStop(67108864);
_yaxislabel.runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"RIGHT"));
 BA.debugLineNum = 349;BA.debugLine="panel.AddView(yAxisLabel, alignLeftCenter - 40d";
Debug.ShouldStop(268435456);
_panel.runVoidMethod ("AddView",(Object)((_yaxislabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_alignleftcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getTop"),_labelypos,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "+-",2, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 351;BA.debugLine="btnBack.Enabled = currentPage > 1";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(true,"setEnabled",BA.ObjectToBoolean(RemoteObject.solveBoolean(">",__ref.getField(true,"_currentpage" /*RemoteObject*/ ),BA.numberCast(double.class, 1))));
 BA.debugLineNum = 352;BA.debugLine="btnNext.Enabled = (currentPage * itemsPerPage) <";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(true,"setEnabled",BA.ObjectToBoolean(RemoteObject.solveBoolean("<",(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_currentpage" /*RemoteObject*/ ),__ref.getField(true,"_itemsperpage" /*RemoteObject*/ )}, "*",0, 1)),BA.numberCast(double.class, _sale1.getField(true,"length")))));
 BA.debugLineNum = 355;BA.debugLine="Dim buttonWidth As Int = 50dip";
Debug.ShouldStop(4);
_buttonwidth = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)));Debug.locals.put("buttonWidth", _buttonwidth);Debug.locals.put("buttonWidth", _buttonwidth);
 BA.debugLineNum = 356;BA.debugLine="Dim buttonHeight As Int = 40dip";
Debug.ShouldStop(8);
_buttonheight = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)));Debug.locals.put("buttonHeight", _buttonheight);Debug.locals.put("buttonHeight", _buttonheight);
 BA.debugLineNum = 358;BA.debugLine="Dim btnMainPanel As Panel";
Debug.ShouldStop(32);
_btnmainpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("btnMainPanel", _btnmainpanel);
 BA.debugLineNum = 359;BA.debugLine="btnMainPanel.Initialize(\"\")";
Debug.ShouldStop(64);
_btnmainpanel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 360;BA.debugLine="panel.AddView(btnMainPanel, alignLeftCenter, pan";
Debug.ShouldStop(128);
_panel.runVoidMethod ("AddView",(Object)((_btnmainpanel.getObject())),(Object)(_alignleftcenter),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_aligntopcenter,RemoteObject.createImmutable(2)}, "/",0, 0)),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "+",1, 0))}, "-",1, 0))),(Object)(_activitypanel.runMethod(true,"getWidth")),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 362;BA.debugLine="Dim paginationPanel As Panel";
Debug.ShouldStop(512);
_paginationpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("paginationPanel", _paginationpanel);
 BA.debugLineNum = 363;BA.debugLine="paginationPanel.Initialize(\"\")";
Debug.ShouldStop(1024);
_paginationpanel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 364;BA.debugLine="btnMainPanel.AddView(paginationPanel, 0, 0, btnM";
Debug.ShouldStop(2048);
_btnmainpanel.runVoidMethod ("AddView",(Object)((_paginationpanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_btnmainpanel.runMethod(true,"getWidth"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))}, "-",1, 1)),(Object)(_btnmainpanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 367;BA.debugLine="If btnBack.Parent <> Null Then btnBack.Rem";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("N",__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(false,"getParent"))) { 
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runVoidMethod ("RemoveView");};
 BA.debugLineNum = 368;BA.debugLine="If btnNext.Parent <> Null Then btnNext.Rem";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("N",__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(false,"getParent"))) { 
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runVoidMethod ("RemoveView");};
 BA.debugLineNum = 369;BA.debugLine="If showHideBtn.Parent <> Null Then showHideBtn.R";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("N",__ref.getField(false,"_showhidebtn" /*RemoteObject*/ ).runMethod(false,"getParent"))) { 
__ref.getField(false,"_showhidebtn" /*RemoteObject*/ ).runVoidMethod ("RemoveView");};
 BA.debugLineNum = 372;BA.debugLine="btnBack.Text = \"<\"";
Debug.ShouldStop(524288);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence("<"));
 BA.debugLineNum = 373;BA.debugLine="btnBack.TextSize = 14";
Debug.ShouldStop(1048576);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 374;BA.debugLine="btnBack.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(2097152);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 375;BA.debugLine="btnBack.TextColor = Colors.White";
Debug.ShouldStop(4194304);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 376;BA.debugLine="Dim cdBack As ColorDrawable";
Debug.ShouldStop(8388608);
_cdback = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cdBack", _cdback);
 BA.debugLineNum = 377;BA.debugLine="cdBack.Initialize2(Colors.RGB(61, 12, 2), 10dip,";
Debug.ShouldStop(16777216);
_cdback.runVoidMethod ("Initialize2",(Object)(bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 378;BA.debugLine="btnBack.Background = cdBack";
Debug.ShouldStop(33554432);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(false,"setBackground",(_cdback.getObject()));
 BA.debugLineNum = 381;BA.debugLine="btnNext.Text = \">\"";
Debug.ShouldStop(268435456);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence(">"));
 BA.debugLineNum = 382;BA.debugLine="btnNext.TextSize = 14";
Debug.ShouldStop(536870912);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 383;BA.debugLine="btnNext.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 384;BA.debugLine="btnNext.TextColor = Colors.White";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 385;BA.debugLine="Dim cdNext As ColorDrawable";
Debug.ShouldStop(1);
_cdnext = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cdNext", _cdnext);
 BA.debugLineNum = 386;BA.debugLine="cdNext.Initialize2(Colors.RGB(185, 46, 52), 10di";
Debug.ShouldStop(2);
_cdnext.runVoidMethod ("Initialize2",(Object)(bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 185)),(Object)(BA.numberCast(int.class, 46)),(Object)(BA.numberCast(int.class, 52)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 387;BA.debugLine="btnNext.Background = cdNext";
Debug.ShouldStop(4);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(false,"setBackground",(_cdnext.getObject()));
 BA.debugLineNum = 390;BA.debugLine="paginationLabel.Initialize(\"\")";
Debug.ShouldStop(32);
__ref.getField(false,"_paginationlabel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 391;BA.debugLine="paginationLabel.Text = $\"Page ${pageNo} out of $";
Debug.ShouldStop(64);
__ref.getField(false,"_paginationlabel" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence((RemoteObject.concat(RemoteObject.createImmutable("Page "),bargraph.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((__ref.getField(true,"_pageno" /*RemoteObject*/ )))),RemoteObject.createImmutable(" out of "),bargraph.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((__ref.getField(true,"_totalpages" /*RemoteObject*/ )))),RemoteObject.createImmutable("")))));
 BA.debugLineNum = 392;BA.debugLine="paginationLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(128);
__ref.getField(false,"_paginationlabel" /*RemoteObject*/ ).runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 393;BA.debugLine="paginationLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(256);
__ref.getField(false,"_paginationlabel" /*RemoteObject*/ ).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 394;BA.debugLine="paginationPanel.AddView(paginationLabel, buttonW";
Debug.ShouldStop(512);
_paginationpanel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_paginationlabel" /*RemoteObject*/ ).getObject())),(Object)(_buttonwidth),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_paginationpanel.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_buttonwidth,RemoteObject.createImmutable(2)}, "*",0, 1))}, "-",1, 1)),(Object)(_paginationpanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 397;BA.debugLine="Dim buttonWidth As Int = 50dip";
Debug.ShouldStop(4096);
_buttonwidth = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)));Debug.locals.put("buttonWidth", _buttonwidth);Debug.locals.put("buttonWidth", _buttonwidth);
 BA.debugLineNum = 398;BA.debugLine="Dim buttonHeight As Int = 40dip";
Debug.ShouldStop(8192);
_buttonheight = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)));Debug.locals.put("buttonHeight", _buttonheight);Debug.locals.put("buttonHeight", _buttonheight);
 BA.debugLineNum = 399;BA.debugLine="paginationPanel.AddView(btnBack, 0, (paginationP";
Debug.ShouldStop(16384);
_paginationpanel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_btnback" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_paginationpanel.runMethod(true,"getHeight"),_buttonheight}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(_buttonwidth),(Object)(_buttonheight));
 BA.debugLineNum = 400;BA.debugLine="paginationPanel.AddView(btnNext, paginationPanel";
Debug.ShouldStop(32768);
_paginationpanel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_btnnext" /*RemoteObject*/ ).getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_paginationpanel.runMethod(true,"getWidth"),_buttonwidth}, "-",1, 1)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_paginationpanel.runMethod(true,"getHeight"),_buttonheight}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(_buttonwidth),(Object)(_buttonheight));
 BA.debugLineNum = 403;BA.debugLine="btnBack.Enabled = currentPage > 1";
Debug.ShouldStop(262144);
__ref.getField(false,"_btnback" /*RemoteObject*/ ).runMethod(true,"setEnabled",BA.ObjectToBoolean(RemoteObject.solveBoolean(">",__ref.getField(true,"_currentpage" /*RemoteObject*/ ),BA.numberCast(double.class, 1))));
 BA.debugLineNum = 404;BA.debugLine="btnNext.Enabled = (currentPage * itemsPerPage) <";
Debug.ShouldStop(524288);
__ref.getField(false,"_btnnext" /*RemoteObject*/ ).runMethod(true,"setEnabled",BA.ObjectToBoolean(RemoteObject.solveBoolean("<",(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_currentpage" /*RemoteObject*/ ),__ref.getField(true,"_itemsperpage" /*RemoteObject*/ )}, "*",0, 1)),BA.numberCast(double.class, _sale1.getField(true,"length")))));
 BA.debugLineNum = 407;BA.debugLine="showHideBtn.Text = \"Show Details\"";
Debug.ShouldStop(4194304);
__ref.getField(false,"_showhidebtn" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence("Show Details"));
 BA.debugLineNum = 408;BA.debugLine="showHideBtn.TextColor = Colors.White";
Debug.ShouldStop(8388608);
__ref.getField(false,"_showhidebtn" /*RemoteObject*/ ).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 409;BA.debugLine="showHideBtn.Background = cdBack";
Debug.ShouldStop(16777216);
__ref.getField(false,"_showhidebtn" /*RemoteObject*/ ).runMethod(false,"setBackground",(_cdback.getObject()));
 BA.debugLineNum = 410;BA.debugLine="btnMainPanel.AddView(showHideBtn, paginati";
Debug.ShouldStop(33554432);
_btnmainpanel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_showhidebtn" /*RemoteObject*/ ).getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_paginationpanel.runMethod(true,"getWidth"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_btnmainpanel.runMethod(true,"getWidth"),_paginationpanel.runMethod(true,"getWidth")}, "-",1, 1)),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)),(Object)(_buttonheight));
 BA.debugLineNum = 411;BA.debugLine="If hideShowBoolean = True Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_hideshowboolean" /*RemoteObject*/ ),bargraph.__c.getField(true,"True"))) { 
 BA.debugLineNum = 412;BA.debugLine="paginationPanel.Width = btnMainPanel.Width";
Debug.ShouldStop(134217728);
_paginationpanel.runMethod(true,"setWidth",_btnmainpanel.runMethod(true,"getWidth"));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e156) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e156.toString()); BA.debugLineNum = 418;BA.debugLine="Log(LastException)";
Debug.ShouldStop(2);
bargraph.__c.runVoidMethod ("LogImpl","23539141",BA.ObjectToString(bargraph.__c.runMethod(false,"LastException",__ref.getField(false, "ba"))),0);
 };
 BA.debugLineNum = 420;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("FormatNumberWithLabel (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,454);
if (RapidSub.canDelegate("formatnumberwithlabel")) { return __ref.runUserSub(false, "bargraph","formatnumberwithlabel", __ref, _number);}
Debug.locals.put("number", _number);
 BA.debugLineNum = 454;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
Debug.ShouldStop(32);
 BA.debugLineNum = 455;BA.debugLine="If number >= 1000000 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000000))) { 
 BA.debugLineNum = 456;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
Debug.ShouldStop(128);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000000)}, "/",0, 0))),RemoteObject.createImmutable("M"));
 }else 
{ BA.debugLineNum = 457;BA.debugLine="Else If number >= 1000 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000))) { 
 BA.debugLineNum = 458;BA.debugLine="Return Floor(number / 1000) & \"k\"";
Debug.ShouldStop(512);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000)}, "/",0, 0))),RemoteObject.createImmutable("k"));
 }else {
 BA.debugLineNum = 460;BA.debugLine="Return number";
Debug.ShouldStop(2048);
if (true) return BA.NumberToString(_number);
 }}
;
 BA.debugLineNum = 462;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("FormatNumberWithSuffix (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,444);
if (RapidSub.canDelegate("formatnumberwithsuffix")) { return __ref.runUserSub(false, "bargraph","formatnumberwithsuffix", __ref, _number);}
Debug.locals.put("number", _number);
 BA.debugLineNum = 444;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 445;BA.debugLine="If number >= 1000000 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000000))) { 
 BA.debugLineNum = 446;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("M"));
 }else 
{ BA.debugLineNum = 447;BA.debugLine="Else If number >= 1000 Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000))) { 
 BA.debugLineNum = 448;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
Debug.ShouldStop(-2147483648);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("k"));
 }else {
 BA.debugLineNum = 450;BA.debugLine="Return NumberFormat(number, 1, 0)";
Debug.ShouldStop(2);
if (true) return bargraph.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _number)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 0)));
 }}
;
 BA.debugLineNum = 452;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getcheckedsales(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetCheckedSales (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,485);
if (RapidSub.canDelegate("getcheckedsales")) { return __ref.runUserSub(false, "bargraph","getcheckedsales", __ref);}
 BA.debugLineNum = 485;BA.debugLine="Public Sub GetCheckedSales As Boolean()";
Debug.ShouldStop(16);
 BA.debugLineNum = 486;BA.debugLine="Return checkedSales";
Debug.ShouldStop(32);
if (true) return __ref.getField(false,"_checkedsales" /*RemoteObject*/ );
 BA.debugLineNum = 487;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getcurrentpage(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetCurrentPage (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,426);
if (RapidSub.canDelegate("getcurrentpage")) { return __ref.runUserSub(false, "bargraph","getcurrentpage", __ref);}
 BA.debugLineNum = 426;BA.debugLine="Public Sub GetCurrentPage As Int";
Debug.ShouldStop(512);
 BA.debugLineNum = 427;BA.debugLine="Return currentPage";
Debug.ShouldStop(1024);
if (true) return __ref.getField(true,"_currentpage" /*RemoteObject*/ );
 BA.debugLineNum = 428;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _active,RemoteObject _panel,RemoteObject _sale1,RemoteObject _sale2,RemoteObject _sale3,RemoteObject _product,RemoteObject _legend,RemoteObject _maxsales,RemoteObject _titlestring,RemoteObject _comid,RemoteObject _layout1,RemoteObject _nextbtn,RemoteObject _backbtn,RemoteObject _sortbtn,RemoteObject _btnsort2,RemoteObject _defaultbtn,RemoteObject _sales1btn,RemoteObject _sales2btn,RemoteObject _sales3btn,RemoteObject _hideshowbtn) throws Exception{
try {
		Debug.PushSubsStack("Initialize (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,42);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "bargraph","initialize", __ref, _ba, _active, _panel, _sale1, _sale2, _sale3, _product, _legend, _maxsales, _titlestring, _comid, _layout1, _nextbtn, _backbtn, _sortbtn, _btnsort2, _defaultbtn, _sales1btn, _sales2btn, _sales3btn, _hideshowbtn);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _halfwidth = RemoteObject.createImmutable(0);
RemoteObject _borderpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _legendwidth = RemoteObject.createImmutable(0);
RemoteObject _tempcheckboxes = null;
RemoteObject _tempcheckedsales = null;
int _i = 0;
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _radiobuttons = null;
RemoteObject _radiotexts = null;
RemoteObject _totalbuttons = RemoteObject.createImmutable(0);
RemoteObject _buttonwidth = RemoteObject.createImmutable(0);
RemoteObject _spacing = RemoteObject.createImmutable(0);
RemoteObject _cdnext = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _saleslabels = null;
RemoteObject _salestexts = null;
RemoteObject _totallabels = RemoteObject.createImmutable(0);
RemoteObject _labelwidth = RemoteObject.createImmutable(0);
RemoteObject _cdback = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
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
Debug.locals.put("hideShowBtn", _hideshowbtn);
 BA.debugLineNum = 42;BA.debugLine="Public Sub Initialize(Active As Activity, panel As";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="If Active.IsInitialized = False Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_active.runMethod(true,"IsInitialized"),bargraph.__c.getField(true,"False"))) { 
 BA.debugLineNum = 44;BA.debugLine="Log(\"Error: Activity is not initialized\")";
Debug.ShouldStop(2048);
bargraph.__c.runVoidMethod ("LogImpl","23473410",RemoteObject.createImmutable("Error: Activity is not initialized"),0);
 BA.debugLineNum = 45;BA.debugLine="Return";
Debug.ShouldStop(4096);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 47;BA.debugLine="Active1 = Active";
Debug.ShouldStop(16384);
__ref.setField ("_active1" /*RemoteObject*/ ,_active);
 BA.debugLineNum = 48;BA.debugLine="panel_l = panel";
Debug.ShouldStop(32768);
__ref.setField ("_panel_l" /*RemoteObject*/ ,_panel);
 BA.debugLineNum = 49;BA.debugLine="sale_1 = sale1";
Debug.ShouldStop(65536);
__ref.setField ("_sale_1" /*RemoteObject*/ ,_sale1);
 BA.debugLineNum = 50;BA.debugLine="sale_2 = sale2";
Debug.ShouldStop(131072);
__ref.setField ("_sale_2" /*RemoteObject*/ ,_sale2);
 BA.debugLineNum = 51;BA.debugLine="sale_3 = sale3";
Debug.ShouldStop(262144);
__ref.setField ("_sale_3" /*RemoteObject*/ ,_sale3);
 BA.debugLineNum = 52;BA.debugLine="product1 = product";
Debug.ShouldStop(524288);
__ref.setField ("_product1" /*RemoteObject*/ ,_product);
 BA.debugLineNum = 53;BA.debugLine="legend1 = legend";
Debug.ShouldStop(1048576);
__ref.setField ("_legend1" /*RemoteObject*/ ,_legend);
 BA.debugLineNum = 54;BA.debugLine="maxSales1 = maxSales";
Debug.ShouldStop(2097152);
__ref.setField ("_maxsales1" /*RemoteObject*/ ,_maxsales);
 BA.debugLineNum = 55;BA.debugLine="titleString1 = TitleString";
Debug.ShouldStop(4194304);
__ref.setField ("_titlestring1" /*RemoteObject*/ ,_titlestring);
 BA.debugLineNum = 56;BA.debugLine="comId1 = comId";
Debug.ShouldStop(8388608);
__ref.setField ("_comid1" /*RemoteObject*/ ,_comid);
 BA.debugLineNum = 57;BA.debugLine="layout = layout1";
Debug.ShouldStop(16777216);
__ref.setField ("_layout" /*RemoteObject*/ ,_layout1);
 BA.debugLineNum = 58;BA.debugLine="btnNext = NextBtn";
Debug.ShouldStop(33554432);
__ref.setField ("_btnnext" /*RemoteObject*/ ,_nextbtn);
 BA.debugLineNum = 59;BA.debugLine="btnBack = Backbtn";
Debug.ShouldStop(67108864);
__ref.setField ("_btnback" /*RemoteObject*/ ,_backbtn);
 BA.debugLineNum = 60;BA.debugLine="sortBtn1 = sortBtn";
Debug.ShouldStop(134217728);
__ref.setField ("_sortbtn1" /*RemoteObject*/ ,_sortbtn);
 BA.debugLineNum = 61;BA.debugLine="sortBtn2 = BtnSort2";
Debug.ShouldStop(268435456);
__ref.setField ("_sortbtn2" /*RemoteObject*/ ,_btnsort2);
 BA.debugLineNum = 62;BA.debugLine="defBtn = Defaultbtn";
Debug.ShouldStop(536870912);
__ref.setField ("_defbtn" /*RemoteObject*/ ,_defaultbtn);
 BA.debugLineNum = 63;BA.debugLine="sales1 = Sales1btn";
Debug.ShouldStop(1073741824);
__ref.setField ("_sales1" /*RemoteObject*/ ,_sales1btn);
 BA.debugLineNum = 64;BA.debugLine="sales2 = Sales2btn";
Debug.ShouldStop(-2147483648);
__ref.setField ("_sales2" /*RemoteObject*/ ,_sales2btn);
 BA.debugLineNum = 65;BA.debugLine="sales3 = Sales3btn";
Debug.ShouldStop(1);
__ref.setField ("_sales3" /*RemoteObject*/ ,_sales3btn);
 BA.debugLineNum = 66;BA.debugLine="showHideBtn = hideShowBtn";
Debug.ShouldStop(2);
__ref.setField ("_showhidebtn" /*RemoteObject*/ ,_hideshowbtn);
 BA.debugLineNum = 67;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(4);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 68;BA.debugLine="cd.Initialize2(Colors.White, 5dip, 1dip, Colors.B";
Debug.ShouldStop(8);
_cd.runVoidMethod ("Initialize2",(Object)(bargraph.__c.getField(false,"Colors").getField(true,"White")),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 70;BA.debugLine="defBtn.Checked = True";
Debug.ShouldStop(32);
__ref.getField(false,"_defbtn" /*RemoteObject*/ ).runMethodAndSync(true,"setChecked",bargraph.__c.getField(true,"True"));
 BA.debugLineNum = 71;BA.debugLine="sales1.Checked = True";
Debug.ShouldStop(64);
__ref.getField(false,"_sales1" /*RemoteObject*/ ).runMethodAndSync(true,"setChecked",bargraph.__c.getField(true,"True"));
 BA.debugLineNum = 73;BA.debugLine="If sale1.Length <> product.Length Or sale2.Length";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("!",_sale1.getField(true,"length"),BA.numberCast(double.class, _product.getField(true,"length"))) || RemoteObject.solveBoolean("!",_sale2.getField(true,"length"),BA.numberCast(double.class, _product.getField(true,"length"))) || RemoteObject.solveBoolean("!",_sale3.getField(true,"length"),BA.numberCast(double.class, _product.getField(true,"length")))) { 
 BA.debugLineNum = 74;BA.debugLine="Return";
Debug.ShouldStop(512);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 76;BA.debugLine="Dim halfWidth As Int = panel.Width / 2";
Debug.ShouldStop(2048);
_halfwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("halfWidth", _halfwidth);Debug.locals.put("halfWidth", _halfwidth);
 BA.debugLineNum = 78;BA.debugLine="legendPanel.Initialize(\"\")";
Debug.ShouldStop(8192);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 79;BA.debugLine="legendPanel.Width = halfWidth";
Debug.ShouldStop(16384);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"setWidth",_halfwidth);
 BA.debugLineNum = 80;BA.debugLine="legendPanel.Height = 60dip";
Debug.ShouldStop(32768);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60))));
 BA.debugLineNum = 82;BA.debugLine="radioPanel.Initialize(\"\")";
Debug.ShouldStop(131072);
__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 83;BA.debugLine="radioPanel.Width = halfWidth";
Debug.ShouldStop(262144);
__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"setWidth",_halfwidth);
 BA.debugLineNum = 84;BA.debugLine="radioPanel.Height = 30dip";
Debug.ShouldStop(524288);
__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 86;BA.debugLine="radioPanel.Color = Colors.Transparent ' Keep it t";
Debug.ShouldStop(2097152);
__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runVoidMethod ("setColor",bargraph.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 87;BA.debugLine="Dim borderPanel As Panel";
Debug.ShouldStop(4194304);
_borderpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("borderPanel", _borderpanel);
 BA.debugLineNum = 88;BA.debugLine="borderPanel.Initialize(\"\")";
Debug.ShouldStop(8388608);
_borderpanel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 89;BA.debugLine="borderPanel.Color = Colors.Black ' Border color";
Debug.ShouldStop(16777216);
_borderpanel.runVoidMethod ("setColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 90;BA.debugLine="panel.AddView(borderPanel, radioPanel.Left, radio";
Debug.ShouldStop(33554432);
_panel.runVoidMethod ("AddView",(Object)((_borderpanel.getObject())),(Object)(__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getLeft")),(Object)(__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getTop")),(Object)(__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getWidth")),(Object)(__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getHeight")));
 BA.debugLineNum = 91;BA.debugLine="panel.AddView(radioPanel, radioPanel.Left + 1dip,";
Debug.ShouldStop(67108864);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getLeft"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getTop"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getWidth"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_radiopanel" /*RemoteObject*/ ).runMethod(true,"getHeight"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 1)));
 BA.debugLineNum = 93;BA.debugLine="Dim legendWidth As Int = (legendPanel.Width-20dip";
Debug.ShouldStop(268435456);
_legendwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"getWidth"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),_legend.getField(true,"length")}, "/",0, 0));Debug.locals.put("legendWidth", _legendwidth);Debug.locals.put("legendWidth", _legendwidth);
 BA.debugLineNum = 94;BA.debugLine="checkBoxes = Array As CheckBox()";
Debug.ShouldStop(536870912);
__ref.setField ("_checkboxes" /*RemoteObject*/ ,RemoteObject.createNewArray("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper",new int[] {0},new Object[] {}));
 BA.debugLineNum = 95;BA.debugLine="checkedSales = Array As Boolean()";
Debug.ShouldStop(1073741824);
__ref.setField ("_checkedsales" /*RemoteObject*/ ,RemoteObject.createNewArray("boolean",new int[] {0},new Object[] {}));
 BA.debugLineNum = 97;BA.debugLine="Dim checkBoxes(legend.Length) As CheckBox";
Debug.ShouldStop(1);
bargraph._checkboxes = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper", new int[] {_legend.getField(true,"length").<Integer>get().intValue()}, new Object[]{});__ref.setField("_checkboxes",bargraph._checkboxes);
 BA.debugLineNum = 98;BA.debugLine="Dim checkedSales(legend.Length) As Boolean";
Debug.ShouldStop(2);
bargraph._checkedsales = RemoteObject.createNewArray ("boolean", new int[] {_legend.getField(true,"length").<Integer>get().intValue()}, new Object[]{});__ref.setField("_checkedsales",bargraph._checkedsales);
 BA.debugLineNum = 99;BA.debugLine="If isFirstInit Then";
Debug.ShouldStop(4);
if (__ref.getField(true,"_isfirstinit" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 101;BA.debugLine="Dim tempCheckBoxes(legend.Length) As CheckBox";
Debug.ShouldStop(16);
_tempcheckboxes = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper", new int[] {_legend.getField(true,"length").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("tempCheckBoxes", _tempcheckboxes);
 BA.debugLineNum = 102;BA.debugLine="checkBoxes = tempCheckBoxes";
Debug.ShouldStop(32);
__ref.setField ("_checkboxes" /*RemoteObject*/ ,_tempcheckboxes);
 BA.debugLineNum = 103;BA.debugLine="Dim tempCheckedSales(legend.Length) As Boolean";
Debug.ShouldStop(64);
_tempcheckedsales = RemoteObject.createNewArray ("boolean", new int[] {_legend.getField(true,"length").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("tempCheckedSales", _tempcheckedsales);
 BA.debugLineNum = 104;BA.debugLine="checkedSales = tempCheckedSales";
Debug.ShouldStop(128);
__ref.setField ("_checkedsales" /*RemoteObject*/ ,_tempcheckedsales);
 BA.debugLineNum = 107;BA.debugLine="For i = 0 To legend.Length - 1";
Debug.ShouldStop(1024);
{
final int step55 = 1;
final int limit55 = RemoteObject.solve(new RemoteObject[] {_legend.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step55 > 0 && _i <= limit55) || (step55 < 0 && _i >= limit55) ;_i = ((int)(0 + _i + step55))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 108;BA.debugLine="Dim chk As CheckBox";
Debug.ShouldStop(2048);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");Debug.locals.put("chk", _chk);
 BA.debugLineNum = 109;BA.debugLine="chk.Initialize(\"chkChange\")";
Debug.ShouldStop(4096);
_chk.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("chkChange")));
 BA.debugLineNum = 110;BA.debugLine="chk.Text = legend(i)";
Debug.ShouldStop(8192);
_chk.runMethod(true,"setText",BA.ObjectToCharSequence(_legend.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 111;BA.debugLine="chk.TextSize = 10";
Debug.ShouldStop(16384);
_chk.runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 112;BA.debugLine="chk.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(32768);
_chk.runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 113;BA.debugLine="chk.TextColor = color(i)";
Debug.ShouldStop(65536);
_chk.runMethod(true,"setTextColor",__ref.getField(false,"_color" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)));
 BA.debugLineNum = 114;BA.debugLine="chk.Gravity = Gravity.CENTER";
Debug.ShouldStop(131072);
_chk.runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 115;BA.debugLine="chk.Tag = i";
Debug.ShouldStop(262144);
_chk.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 116;BA.debugLine="chk.Checked = True  ' Default state";
Debug.ShouldStop(524288);
_chk.runMethodAndSync(true,"setChecked",bargraph.__c.getField(true,"True"));
 BA.debugLineNum = 117;BA.debugLine="checkedSales(i) = True";
Debug.ShouldStop(1048576);
__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).setArrayElement (bargraph.__c.getField(true,"True"),BA.numberCast(int.class, _i));
 BA.debugLineNum = 118;BA.debugLine="legendPanel.AddView(chk, (legendWidth * i), 10d";
Debug.ShouldStop(2097152);
__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((_chk.getObject())),(Object)((RemoteObject.solve(new RemoteObject[] {_legendwidth,RemoteObject.createImmutable(_i)}, "*",0, 1))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(_legendwidth),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_legendpanel" /*RemoteObject*/ ).runMethod(true,"getHeight"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)));
 BA.debugLineNum = 119;BA.debugLine="checkBoxes(i) = chk";
Debug.ShouldStop(4194304);
__ref.getField(false,"_checkboxes" /*RemoteObject*/ ).setArrayElement (_chk,BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 121;BA.debugLine="isFirstInit = False";
Debug.ShouldStop(16777216);
__ref.setField ("_isfirstinit" /*RemoteObject*/ ,bargraph.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 124;BA.debugLine="For i = 0 To checkBoxes.Length - 1";
Debug.ShouldStop(134217728);
{
final int step71 = 1;
final int limit71 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_checkboxes" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step71 > 0 && _i <= limit71) || (step71 < 0 && _i >= limit71) ;_i = ((int)(0 + _i + step71))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 125;BA.debugLine="checkBoxes(i).Checked = checkedSales(i)";
Debug.ShouldStop(268435456);
__ref.getField(false,"_checkboxes" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, _i)).runMethodAndSync(true,"setChecked",__ref.getField(false,"_checkedsales" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 131;BA.debugLine="sortMainpanel.Initialize(\"\")";
Debug.ShouldStop(4);
__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 132;BA.debugLine="panel.AddView(sortMainpanel, 0dip, 5dip, halfWidt";
Debug.ShouldStop(8);
_panel.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).getObject())),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(_halfwidth),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))));
 BA.debugLineNum = 135;BA.debugLine="Dim radioButtons() As RadioButton = Array As Radi";
Debug.ShouldStop(64);
_radiobuttons = RemoteObject.createNewArray("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper",new int[] {3},new Object[] {__ref.getField(false,"_sortbtn1" /*RemoteObject*/ ),__ref.getField(false,"_sortbtn2" /*RemoteObject*/ ),__ref.getField(false,"_defbtn" /*RemoteObject*/ )});Debug.locals.put("radioButtons", _radiobuttons);Debug.locals.put("radioButtons", _radiobuttons);
 BA.debugLineNum = 136;BA.debugLine="Dim radioTexts() As String = Array As String(\"ASC";
Debug.ShouldStop(128);
_radiotexts = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("ASC"),BA.ObjectToString("DESC"),RemoteObject.createImmutable("DEFAULT")});Debug.locals.put("radioTexts", _radiotexts);Debug.locals.put("radioTexts", _radiotexts);
 BA.debugLineNum = 138;BA.debugLine="salePanel.Initialize(\"\")";
Debug.ShouldStop(512);
__ref.getField(false,"_salepanel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 139;BA.debugLine="salePanel.Width = halfWidth";
Debug.ShouldStop(1024);
__ref.getField(false,"_salepanel" /*RemoteObject*/ ).runMethod(true,"setWidth",_halfwidth);
 BA.debugLineNum = 140;BA.debugLine="salePanel.Height = 30dip";
Debug.ShouldStop(2048);
__ref.getField(false,"_salepanel" /*RemoteObject*/ ).runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 141;BA.debugLine="salePanel.SendToBack";
Debug.ShouldStop(4096);
__ref.getField(false,"_salepanel" /*RemoteObject*/ ).runVoidMethod ("SendToBack");
 BA.debugLineNum = 142;BA.debugLine="sortMainpanel.AddView(salePanel, 10dip, 5dip, sor";
Debug.ShouldStop(8192);
__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_salepanel" /*RemoteObject*/ ).getObject())),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).runMethod(true,"getWidth"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 45)))));
 BA.debugLineNum = 143;BA.debugLine="salePanel.Background = cd";
Debug.ShouldStop(16384);
__ref.getField(false,"_salepanel" /*RemoteObject*/ ).runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 145;BA.debugLine="radioLabelSalesTitles.Initialize(\"radioLabelSales";
Debug.ShouldStop(65536);
__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("radioLabelSalesTitles")));
 BA.debugLineNum = 146;BA.debugLine="radioLabelSalesTitles.Text = \"Base on\"";
Debug.ShouldStop(131072);
__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence("Base on"));
 BA.debugLineNum = 147;BA.debugLine="radioLabelSalesTitles.TextSize = 8";
Debug.ShouldStop(262144);
__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).runMethod(true,"setTextSize",BA.numberCast(float.class, 8));
 BA.debugLineNum = 148;BA.debugLine="radioLabelSalesTitles.Gravity = Gravity.CENTER";
Debug.ShouldStop(524288);
__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 149;BA.debugLine="radioLabelSalesTitles.Typeface = Typeface.MONOSPA";
Debug.ShouldStop(1048576);
__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 150;BA.debugLine="radioLabelSalesTitles.TextColor = Colors.Black";
Debug.ShouldStop(2097152);
__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 151;BA.debugLine="radioLabelSalesTitles.Color = Colors.White";
Debug.ShouldStop(4194304);
__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).runVoidMethod ("setColor",bargraph.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 152;BA.debugLine="sortMainpanel.AddView(radioLabelSalesTitles, 15di";
Debug.ShouldStop(8388608);
__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_radiolabelsalestitles" /*RemoteObject*/ ).getObject())),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(BA.numberCast(int.class, -(double) (0 + bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))).<Integer>get().intValue()))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 BA.debugLineNum = 154;BA.debugLine="sortPanel.Initialize(\"\")";
Debug.ShouldStop(33554432);
__ref.getField(false,"_sortpanel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 155;BA.debugLine="sortPanel.Width = halfWidth ' Half of the main pa";
Debug.ShouldStop(67108864);
__ref.getField(false,"_sortpanel" /*RemoteObject*/ ).runMethod(true,"setWidth",_halfwidth);
 BA.debugLineNum = 156;BA.debugLine="sortPanel.Height = 30dip ' Height remains the sam";
Debug.ShouldStop(134217728);
__ref.getField(false,"_sortpanel" /*RemoteObject*/ ).runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 157;BA.debugLine="sortMainpanel.AddView(sortPanel, 10dip, salePanel";
Debug.ShouldStop(268435456);
__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_sortpanel" /*RemoteObject*/ ).getObject())),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_salepanel" /*RemoteObject*/ ).runMethod(true,"getHeight"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).runMethod(true,"getWidth"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 45)))));
 BA.debugLineNum = 158;BA.debugLine="sortPanel.Background = cd";
Debug.ShouldStop(536870912);
__ref.getField(false,"_sortpanel" /*RemoteObject*/ ).runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 160;BA.debugLine="radioLabelSortTitles.Initialize(\"radioLabelSortTi";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("radioLabelSortTitles")));
 BA.debugLineNum = 161;BA.debugLine="radioLabelSortTitles.Text = \"Sort By\"";
Debug.ShouldStop(1);
__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence("Sort By"));
 BA.debugLineNum = 162;BA.debugLine="radioLabelSortTitles.TextSize = 8";
Debug.ShouldStop(2);
__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).runMethod(true,"setTextSize",BA.numberCast(float.class, 8));
 BA.debugLineNum = 163;BA.debugLine="radioLabelSortTitles.Typeface = Typeface.MONOSPAC";
Debug.ShouldStop(4);
__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 164;BA.debugLine="radioLabelSortTitles.Gravity = Gravity.CENTER";
Debug.ShouldStop(8);
__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 165;BA.debugLine="radioLabelSortTitles.TextColor = Colors.Black";
Debug.ShouldStop(16);
__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 166;BA.debugLine="radioLabelSortTitles.Color = Colors.White";
Debug.ShouldStop(32);
__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).runVoidMethod ("setColor",bargraph.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 167;BA.debugLine="sortMainpanel.AddView(radioLabelSortTitles,15dip,";
Debug.ShouldStop(64);
__ref.getField(false,"_sortmainpanel" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_radiolabelsorttitles" /*RemoteObject*/ ).getObject())),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_salepanel" /*RemoteObject*/ ).runMethod(true,"getHeight"),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))}, "+",1, 1)),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 BA.debugLineNum = 170;BA.debugLine="If salePanel.Width = 0 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_salepanel" /*RemoteObject*/ ).runMethod(true,"getWidth"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 171;BA.debugLine="salePanel.Width = halfWidth ' Default width to h";
Debug.ShouldStop(1024);
__ref.getField(false,"_salepanel" /*RemoteObject*/ ).runMethod(true,"setWidth",_halfwidth);
 };
 BA.debugLineNum = 174;BA.debugLine="Dim totalButtons As Int = radioButtons.Length";
Debug.ShouldStop(8192);
_totalbuttons = _radiobuttons.getField(true,"length");Debug.locals.put("totalButtons", _totalbuttons);Debug.locals.put("totalButtons", _totalbuttons);
 BA.debugLineNum = 175;BA.debugLine="Dim buttonWidth As Int = (salePanel.Width - (tota";
Debug.ShouldStop(16384);
_buttonwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_salepanel" /*RemoteObject*/ ).runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_totalbuttons,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "*",0, 1))}, "-",1, 1)),_totalbuttons}, "/",0, 0));Debug.locals.put("buttonWidth", _buttonwidth);Debug.locals.put("buttonWidth", _buttonwidth);
 BA.debugLineNum = 176;BA.debugLine="Dim spacing As Int = 5dip ' Small gap between but";
Debug.ShouldStop(32768);
_spacing = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("spacing", _spacing);Debug.locals.put("spacing", _spacing);
 BA.debugLineNum = 178;BA.debugLine="For i = 0 To totalButtons - 1";
Debug.ShouldStop(131072);
{
final int step112 = 1;
final int limit112 = RemoteObject.solve(new RemoteObject[] {_totalbuttons,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step112 > 0 && _i <= limit112) || (step112 < 0 && _i >= limit112) ;_i = ((int)(0 + _i + step112))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 179;BA.debugLine="radioButtons(i).Text = radioTexts(i)";
Debug.ShouldStop(262144);
_radiobuttons.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setText",BA.ObjectToCharSequence(_radiotexts.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 180;BA.debugLine="radioButtons(i).TextSize = 10";
Debug.ShouldStop(524288);
_radiobuttons.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 181;BA.debugLine="radioButtons(i).Tag = radioTexts(i)";
Debug.ShouldStop(1048576);
_radiobuttons.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"setTag",(_radiotexts.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 182;BA.debugLine="radioButtons(i).Gravity = Gravity.CENTER_VERTICA";
Debug.ShouldStop(2097152);
_radiobuttons.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 183;BA.debugLine="radioButtons(i).Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(4194304);
_radiobuttons.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 184;BA.debugLine="radioButtons(i).TextColor = Colors.Black";
Debug.ShouldStop(8388608);
_radiobuttons.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 187;BA.debugLine="Dim cdNext As ColorDrawable";
Debug.ShouldStop(67108864);
_cdnext = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cdNext", _cdnext);
 BA.debugLineNum = 188;BA.debugLine="cdNext.Initialize2(Colors.RGB(128, 128, 128), 10";
Debug.ShouldStop(134217728);
_cdnext.runVoidMethod ("Initialize2",(Object)(bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 191;BA.debugLine="sortPanel.AddView(radioButtons(i), (i * (buttonW";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_sortpanel" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((_radiobuttons.getArrayElement(false,BA.numberCast(int.class, _i)).getObject())),(Object)((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {_buttonwidth,_spacing}, "+",1, 1))}, "*",0, 1))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(_buttonwidth),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 194;BA.debugLine="Dim salesLabels() As RadioButton = Array As Radio";
Debug.ShouldStop(2);
_saleslabels = RemoteObject.createNewArray("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper",new int[] {3},new Object[] {__ref.getField(false,"_sales1" /*RemoteObject*/ ),__ref.getField(false,"_sales2" /*RemoteObject*/ ),__ref.getField(false,"_sales3" /*RemoteObject*/ )});Debug.locals.put("salesLabels", _saleslabels);Debug.locals.put("salesLabels", _saleslabels);
 BA.debugLineNum = 195;BA.debugLine="Dim salesTexts() As String = Array As String(\"1\",";
Debug.ShouldStop(4);
_salestexts = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("1"),BA.ObjectToString("2"),RemoteObject.createImmutable("3")});Debug.locals.put("salesTexts", _salestexts);Debug.locals.put("salesTexts", _salestexts);
 BA.debugLineNum = 197;BA.debugLine="Dim totalLabels As Int = salesLabels.Length";
Debug.ShouldStop(16);
_totallabels = _saleslabels.getField(true,"length");Debug.locals.put("totalLabels", _totallabels);Debug.locals.put("totalLabels", _totallabels);
 BA.debugLineNum = 198;BA.debugLine="Dim labelWidth As Int = (sortPanel.Width - (total";
Debug.ShouldStop(32);
_labelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sortpanel" /*RemoteObject*/ ).runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_totallabels,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "*",0, 1))}, "-",1, 1)),_totallabels}, "/",0, 0));Debug.locals.put("labelWidth", _labelwidth);Debug.locals.put("labelWidth", _labelwidth);
 BA.debugLineNum = 199;BA.debugLine="Dim spacing As Int = 5dip ' Small spacing between";
Debug.ShouldStop(64);
_spacing = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("spacing", _spacing);Debug.locals.put("spacing", _spacing);
 BA.debugLineNum = 201;BA.debugLine="For i = 0 To totalLabels - 1";
Debug.ShouldStop(256);
{
final int step128 = 1;
final int limit128 = RemoteObject.solve(new RemoteObject[] {_totallabels,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step128 > 0 && _i <= limit128) || (step128 < 0 && _i >= limit128) ;_i = ((int)(0 + _i + step128))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 202;BA.debugLine="salesLabels(i).Text = legend(i)";
Debug.ShouldStop(512);
_saleslabels.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setText",BA.ObjectToCharSequence(_legend.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 203;BA.debugLine="salesLabels(i).TextSize = 10";
Debug.ShouldStop(1024);
_saleslabels.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 204;BA.debugLine="salesLabels(i).Tag = salesTexts(i)";
Debug.ShouldStop(2048);
_saleslabels.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"setTag",(_salestexts.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 205;BA.debugLine="salesLabels(i).Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(4096);
_saleslabels.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 206;BA.debugLine="salesLabels(i).TextColor = Colors.Black";
Debug.ShouldStop(8192);
_saleslabels.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 208;BA.debugLine="Dim cdBack As ColorDrawable";
Debug.ShouldStop(32768);
_cdback = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cdBack", _cdback);
 BA.debugLineNum = 209;BA.debugLine="cdBack.Initialize2(Colors.RGB(128, 128, 128), 10";
Debug.ShouldStop(65536);
_cdback.runVoidMethod ("Initialize2",(Object)(bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 213;BA.debugLine="salePanel.AddView(salesLabels(i), (i * (labelWid";
Debug.ShouldStop(1048576);
__ref.getField(false,"_salepanel" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((_saleslabels.getArrayElement(false,BA.numberCast(int.class, _i)).getObject())),(Object)((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {_labelwidth,_spacing}, "+",1, 1))}, "*",0, 1))),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(_labelwidth),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 218;BA.debugLine="DrawGraph(Active, panel, sale1, sale2, sale3, pro";
Debug.ShouldStop(33554432);
__ref.runClassMethod (b4a.example.bargraph.class, "_drawgraph" /*RemoteObject*/ ,(Object)(_active),(Object)(_panel),(Object)(_sale1),(Object)(_sale2),(Object)(_sale3),(Object)(_product),(Object)(_maxsales),(Object)(_titlestring));
 BA.debugLineNum = 219;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("productLabel_Click (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,435);
if (RapidSub.canDelegate("productlabel_click")) { return __ref.runUserSub(false, "bargraph","productlabel_click", __ref);}
RemoteObject _clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _selectedcompany = RemoteObject.createImmutable(0);
 BA.debugLineNum = 435;BA.debugLine="Sub productLabel_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 436;BA.debugLine="Dim clickedLabel As Label = Sender";
Debug.ShouldStop(524288);
_clickedlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), bargraph.__c.runMethod(false,"Sender",__ref.getField(false, "ba")));Debug.locals.put("clickedLabel", _clickedlabel);Debug.locals.put("clickedLabel", _clickedlabel);
 BA.debugLineNum = 437;BA.debugLine="Dim selectedCompany As Int = clickedLabel.Tag";
Debug.ShouldStop(1048576);
_selectedcompany = BA.numberCast(int.class, _clickedlabel.runMethod(false,"getTag"));Debug.locals.put("selectedCompany", _selectedcompany);Debug.locals.put("selectedCompany", _selectedcompany);
 BA.debugLineNum = 438;BA.debugLine="Log(\"Selected Company ID: \" & selectedCompany)";
Debug.ShouldStop(2097152);
bargraph.__c.runVoidMethod ("LogImpl","23801091",RemoteObject.concat(RemoteObject.createImmutable("Selected Company ID: "),_selectedcompany),0);
 BA.debugLineNum = 439;BA.debugLine="Starter.company_selected = selectedCompany";
Debug.ShouldStop(4194304);
bargraph._starter._company_selected /*RemoteObject*/  = BA.NumberToString(_selectedcompany);
 BA.debugLineNum = 440;BA.debugLine="StartActivity(layout)";
Debug.ShouldStop(8388608);
bargraph.__c.runVoidMethod ("StartActivity",__ref.getField(false, "ba"),(Object)((__ref.getField(true,"_layout" /*RemoteObject*/ ))));
 BA.debugLineNum = 441;BA.debugLine="Active1.Finish";
Debug.ShouldStop(16777216);
__ref.getField(false,"_active1" /*RemoteObject*/ ).runVoidMethod ("Finish");
 BA.debugLineNum = 442;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("SetCurrentPage (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,430);
if (RapidSub.canDelegate("setcurrentpage")) { return __ref.runUserSub(false, "bargraph","setcurrentpage", __ref, _page);}
Debug.locals.put("page", _page);
 BA.debugLineNum = 430;BA.debugLine="Public Sub SetCurrentPage(page As Int)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 431;BA.debugLine="currentPage = page";
Debug.ShouldStop(16384);
__ref.setField ("_currentpage" /*RemoteObject*/ ,_page);
 BA.debugLineNum = 432;BA.debugLine="UpdateGraph";
Debug.ShouldStop(32768);
__ref.runClassMethod (b4a.example.bargraph.class, "_updategraph" /*RemoteObject*/ );
 BA.debugLineNum = 433;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("UpdateGraph (bargraph) ","bargraph",2,__ref.getField(false, "ba"),__ref,422);
if (RapidSub.canDelegate("updategraph")) { return __ref.runUserSub(false, "bargraph","updategraph", __ref);}
 BA.debugLineNum = 422;BA.debugLine="Public Sub UpdateGraph";
Debug.ShouldStop(32);
 BA.debugLineNum = 423;BA.debugLine="DrawGraph(Active1, panel_l, sale_1, sale_2, sale_";
Debug.ShouldStop(64);
__ref.runClassMethod (b4a.example.bargraph.class, "_drawgraph" /*RemoteObject*/ ,(Object)(__ref.getField(false,"_active1" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_panel_l" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_1" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_2" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_sale_3" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_product1" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_maxsales1" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_titlestring1" /*RemoteObject*/ )));
 BA.debugLineNum = 424;BA.debugLine="End Sub";
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