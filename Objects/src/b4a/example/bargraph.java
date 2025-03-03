package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class bargraph extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.bargraph");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.bargraph.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[] _checkboxes = null;
public boolean[] _checkedsales = null;
public int[] _color = null;
public anywheresoftware.b4a.objects.PanelWrapper _legendpanel = null;
public anywheresoftware.b4a.objects.ActivityWrapper _active1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel_l = null;
public int[] _sale_1 = null;
public int[] _sale_2 = null;
public int[] _sale_3 = null;
public String[] _product1 = null;
public String[] _legend1 = null;
public int _maxsales1 = 0;
public String _titlestring1 = "";
public b4a.example.main _main = null;
public b4a.example.branch _branch = null;
public b4a.example.device _device = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public String  _initialize(b4a.example.bargraph __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _active,anywheresoftware.b4a.objects.PanelWrapper _panel,int[] _sale1,int[] _sale2,int[] _sale3,String[] _product,String[] _legend,int _maxsales,String _titlestring) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_active,_panel,_sale1,_sale2,_sale3,_product,_legend,_maxsales,_titlestring}));}
int _legendwidth = 0;
int _i = 0;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _legendlabel = null;
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Public Sub Initialize(Active As Activity, panel As";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Active1 = Active";
__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/  = _active;
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="panel_l = panel";
__ref._panel_l /*anywheresoftware.b4a.objects.PanelWrapper*/  = _panel;
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="sale_1 = sale1";
__ref._sale_1 /*int[]*/  = _sale1;
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="sale_2 = sale2";
__ref._sale_2 /*int[]*/  = _sale2;
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="sale_3 = sale3";
__ref._sale_3 /*int[]*/  = _sale3;
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="product1 = product";
__ref._product1 /*String[]*/  = _product;
RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="legend1 = legend";
__ref._legend1 /*String[]*/  = _legend;
RDebugUtils.currentLine=917512;
 //BA.debugLineNum = 917512;BA.debugLine="maxSales1 = maxSales";
__ref._maxsales1 /*int*/  = _maxsales;
RDebugUtils.currentLine=917513;
 //BA.debugLineNum = 917513;BA.debugLine="titleString1 = TitleString";
__ref._titlestring1 /*String*/  = _titlestring;
RDebugUtils.currentLine=917515;
 //BA.debugLineNum = 917515;BA.debugLine="legendPanel.Initialize(\"\")";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .Initialize(ba,"");
RDebugUtils.currentLine=917516;
 //BA.debugLineNum = 917516;BA.debugLine="legendPanel.Width = panel.Width";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setWidth(_panel.getWidth());
RDebugUtils.currentLine=917517;
 //BA.debugLineNum = 917517;BA.debugLine="legendPanel.Height = 30dip";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setHeight(__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=917519;
 //BA.debugLineNum = 917519;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
_legendwidth = (int) (__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()/(double)_legend.length);
RDebugUtils.currentLine=917520;
 //BA.debugLineNum = 917520;BA.debugLine="checkBoxes = Array As CheckBox()";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/  = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]{};
RDebugUtils.currentLine=917521;
 //BA.debugLineNum = 917521;BA.debugLine="checkedSales = Array As Boolean()";
__ref._checkedsales /*boolean[]*/  = new boolean[]{};
RDebugUtils.currentLine=917523;
 //BA.debugLineNum = 917523;BA.debugLine="Dim checkBoxes(sale1.Length) As CheckBox   ' Resi";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[_sale1.length];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=917524;
 //BA.debugLineNum = 917524;BA.debugLine="Dim checkedSales(sale1.Length) As Boolean";
_checkedsales = new boolean[_sale1.length];
;
RDebugUtils.currentLine=917525;
 //BA.debugLineNum = 917525;BA.debugLine="For i = 0 To legend.Length - 1";
{
final int step18 = 1;
final int limit18 = (int) (_legend.length-1);
_i = (int) (0) ;
for (;_i <= limit18 ;_i = _i + step18 ) {
RDebugUtils.currentLine=917531;
 //BA.debugLineNum = 917531;BA.debugLine="Dim legendLabel As CheckBox";
_legendlabel = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=917532;
 //BA.debugLineNum = 917532;BA.debugLine="legendLabel.Initialize(\"chkChange\")";
_legendlabel.Initialize(ba,"chkChange");
RDebugUtils.currentLine=917533;
 //BA.debugLineNum = 917533;BA.debugLine="legendLabel.Text = legend(i)";
_legendlabel.setText(BA.ObjectToCharSequence(_legend[_i]));
RDebugUtils.currentLine=917534;
 //BA.debugLineNum = 917534;BA.debugLine="legendLabel.TextColor = color(i)";
_legendlabel.setTextColor(__ref._color /*int[]*/ [_i]);
RDebugUtils.currentLine=917535;
 //BA.debugLineNum = 917535;BA.debugLine="legendLabel.Gravity = Gravity.CENTER";
_legendlabel.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=917536;
 //BA.debugLineNum = 917536;BA.debugLine="legendLabel.Checked = True";
_legendlabel.setChecked(__c.True);
RDebugUtils.currentLine=917537;
 //BA.debugLineNum = 917537;BA.debugLine="legendPanel.AddView(legendLabel, (legendWidth *";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(_legendlabel.getObject()),(int) ((_legendwidth*_i)+__c.DipToCurrent((int) (30))),__c.DipToCurrent((int) (0)),(int) (_legendwidth-__c.DipToCurrent((int) (30))),__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight());
RDebugUtils.currentLine=917539;
 //BA.debugLineNum = 917539;BA.debugLine="legendLabel.Tag = i ' Assign the index as the Ta";
_legendlabel.setTag((Object)(_i));
RDebugUtils.currentLine=917540;
 //BA.debugLineNum = 917540;BA.debugLine="checkBoxes(i) = legendLabel ' Store reference in";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/ [_i] = _legendlabel;
RDebugUtils.currentLine=917541;
 //BA.debugLineNum = 917541;BA.debugLine="checkedSales(i) = True ' Ensure the checkbox is";
__ref._checkedsales /*boolean[]*/ [_i] = __c.True;
 }
};
RDebugUtils.currentLine=917544;
 //BA.debugLineNum = 917544;BA.debugLine="DrawGraph(Active, panel, sale1, sale2, sale3, pro";
__ref._drawgraph /*String*/ (null,_active,_panel,_sale1,_sale2,_sale3,_product,_maxsales,_titlestring);
RDebugUtils.currentLine=917545;
 //BA.debugLineNum = 917545;BA.debugLine="End Sub";
return "";
}
public String  _chkchange_checkedchange(b4a.example.bargraph __ref,boolean _checked) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "chkchange_checkedchange", false))
	 {return ((String) Debug.delegate(ba, "chkchange_checkedchange", new Object[] {_checked}));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
int _index = 0;
int _checkedcount = 0;
int _i = 0;
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub chkChange_CheckedChange(Checked As Boolean)";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="If Sender Is CheckBox Then";
if (__c.Sender(ba) instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Dim chk As CheckBox = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper(), (android.widget.CheckBox)(__c.Sender(ba)));
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="If Not(IsNumber(chk.Tag)) Then";
if (__c.Not(__c.IsNumber(BA.ObjectToString(_chk.getTag())))) { 
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="Log(\"Error: Checkbox Tag is not a valid number\"";
__c.LogImpl("01048582","Error: Checkbox Tag is not a valid number",0);
RDebugUtils.currentLine=1048583;
 //BA.debugLineNum = 1048583;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1048586;
 //BA.debugLineNum = 1048586;BA.debugLine="Dim index As Int = chk.Tag";
_index = (int)(BA.ObjectToNumber(_chk.getTag()));
RDebugUtils.currentLine=1048587;
 //BA.debugLineNum = 1048587;BA.debugLine="Dim checkedCount As Int = 0";
_checkedcount = (int) (0);
RDebugUtils.currentLine=1048590;
 //BA.debugLineNum = 1048590;BA.debugLine="For i = 0 To checkedSales.Length - 1";
{
final int step9 = 1;
final int limit9 = (int) (__ref._checkedsales /*boolean[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
RDebugUtils.currentLine=1048591;
 //BA.debugLineNum = 1048591;BA.debugLine="If checkedSales(i) Then checkedCount = checkedC";
if (__ref._checkedsales /*boolean[]*/ [_i]) { 
_checkedcount = (int) (_checkedcount+1);};
 }
};
RDebugUtils.currentLine=1048595;
 //BA.debugLineNum = 1048595;BA.debugLine="If Checked = False And checkedCount = 1 Then";
if (_checked==__c.False && _checkedcount==1) { 
RDebugUtils.currentLine=1048596;
 //BA.debugLineNum = 1048596;BA.debugLine="chk.Checked = True";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=1048597;
 //BA.debugLineNum = 1048597;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1048601;
 //BA.debugLineNum = 1048601;BA.debugLine="checkedSales(index) = Checked";
__ref._checkedsales /*boolean[]*/ [_index] = _checked;
RDebugUtils.currentLine=1048604;
 //BA.debugLineNum = 1048604;BA.debugLine="Log(\"Checkbox \" & index & \" changed to: \" & chk.";
__c.LogImpl("01048604","Checkbox "+BA.NumberToString(_index)+" changed to: "+BA.ObjectToString(_chk.getChecked()),0);
RDebugUtils.currentLine=1048607;
 //BA.debugLineNum = 1048607;BA.debugLine="DrawGraph(Active1, panel_l, sale_1, sale_2, sale";
__ref._drawgraph /*String*/ (null,__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/ ,__ref._panel_l /*anywheresoftware.b4a.objects.PanelWrapper*/ ,__ref._sale_1 /*int[]*/ ,__ref._sale_2 /*int[]*/ ,__ref._sale_3 /*int[]*/ ,__ref._product1 /*String[]*/ ,__ref._maxsales1 /*int*/ ,__ref._titlestring1 /*String*/ );
RDebugUtils.currentLine=1048608;
 //BA.debugLineNum = 1048608;BA.debugLine="panel_l.Invalidate";
__ref._panel_l /*anywheresoftware.b4a.objects.PanelWrapper*/ .Invalidate();
 }else {
RDebugUtils.currentLine=1048610;
 //BA.debugLineNum = 1048610;BA.debugLine="Log(\"Error: Sender is not a CheckBox\")";
__c.LogImpl("01048610","Error: Sender is not a CheckBox",0);
 };
RDebugUtils.currentLine=1048612;
 //BA.debugLineNum = 1048612;BA.debugLine="End Sub";
return "";
}
public String  _drawgraph(b4a.example.bargraph __ref,anywheresoftware.b4a.objects.ActivityWrapper _active,anywheresoftware.b4a.objects.PanelWrapper _panel,int[] _sale1,int[] _sale2,int[] _sale3,String[] _product,int _maxsales,String _titlestring) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "drawgraph", false))
	 {return ((String) Debug.delegate(ba, "drawgraph", new Object[] {_active,_panel,_sale1,_sale2,_sale3,_product,_maxsales,_titlestring}));}
anywheresoftware.b4a.objects.PanelWrapper _activitypanel = null;
int _alignleftcenter = 0;
int _aligntopcenter = 0;
anywheresoftware.b4a.objects.LabelWrapper _title = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _graphcanvas = null;
int _maxsale = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cv = null;
int _totalproducts = 0;
int _barsperproduct = 0;
int _totalbars = 0;
int _gap = 0;
int _productgap = 0;
int _padding = 0;
int _availablewidth = 0;
int _barwidth = 0;
int _xstart = 0;
int _i = 0;
int _xpos = 0;
int[] _salevalues = null;
int _indexoffset = 0;
int _j = 0;
int _sale = 0;
int _barheight = 0;
int _xbar = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r = null;
int _fontsize = 0;
int _productlabely = 0;
int _productlabelx = 0;
int _numlabels = 0;
int _labelvalue = 0;
int _labelypos = 0;
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub DrawGraph(Active As Activity, panel As Panel,";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="panel.Invalidate";
_panel.Invalidate();
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="panel.RemoveAllViews";
_panel.RemoveAllViews();
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="panel.Height = 400dip";
_panel.setHeight(__c.DipToCurrent((int) (400)));
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="panel.AddView(legendPanel, 0, 0, panel.Width, 30d";
_panel.AddView((android.view.View)(__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()),(int) (0),(int) (0),_panel.getWidth(),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="Dim activityPanel As Panel";
_activitypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
_activitypanel.Initialize(ba,"activityPanel");
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="activityPanel.Width = 80%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (80),ba));
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="If Active.Width > 800 Then";
if (_active.getWidth()>800) { 
RDebugUtils.currentLine=983051;
 //BA.debugLineNum = 983051;BA.debugLine="activityPanel.Width = 55%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (55),ba));
 };
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="activityPanel.Height = 250dip";
_activitypanel.setHeight(__c.DipToCurrent((int) (250)));
RDebugUtils.currentLine=983054;
 //BA.debugLineNum = 983054;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
_activitypanel.setColor(__c.Colors.ARGB((int) (70),(int) (211),(int) (211),(int) (211)));
RDebugUtils.currentLine=983056;
 //BA.debugLineNum = 983056;BA.debugLine="Dim alignLeftCenter As Int = (Active.Width - acti";
_alignleftcenter = (int) ((_active.getWidth()-_activitypanel.getWidth())/(double)2);
RDebugUtils.currentLine=983057;
 //BA.debugLineNum = 983057;BA.debugLine="Dim alignTopCenter As Int = (panel.Height - activ";
_aligntopcenter = (int) ((_panel.getHeight()-_activitypanel.getHeight())/(double)2);
RDebugUtils.currentLine=983059;
 //BA.debugLineNum = 983059;BA.debugLine="Dim Title As Label";
_title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=983060;
 //BA.debugLineNum = 983060;BA.debugLine="Title.Initialize(\"\")";
_title.Initialize(ba,"");
RDebugUtils.currentLine=983061;
 //BA.debugLineNum = 983061;BA.debugLine="Title.Text = TitleString";
_title.setText(BA.ObjectToCharSequence(_titlestring));
RDebugUtils.currentLine=983062;
 //BA.debugLineNum = 983062;BA.debugLine="Title.TextSize = 20";
_title.setTextSize((float) (20));
RDebugUtils.currentLine=983063;
 //BA.debugLineNum = 983063;BA.debugLine="Title.Typeface = Typeface.MONOSPACE";
_title.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=983064;
 //BA.debugLineNum = 983064;BA.debugLine="Title.Gravity = Gravity.CENTER";
_title.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=983065;
 //BA.debugLineNum = 983065;BA.debugLine="Title.TextColor = Colors.Black";
_title.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=983066;
 //BA.debugLineNum = 983066;BA.debugLine="Title.SendToBack";
_title.SendToBack();
RDebugUtils.currentLine=983070;
 //BA.debugLineNum = 983070;BA.debugLine="panel.AddView(Title, 0, alignTopCenter / 2, panel";
_panel.AddView((android.view.View)(_title.getObject()),(int) (0),(int) (_aligntopcenter/(double)2),_panel.getWidth(),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=983073;
 //BA.debugLineNum = 983073;BA.debugLine="panel.AddView(activityPanel, alignLeftCenter, ali";
_panel.AddView((android.view.View)(_activitypanel.getObject()),_alignleftcenter,_aligntopcenter,_activitypanel.getWidth(),_activitypanel.getHeight());
RDebugUtils.currentLine=983076;
 //BA.debugLineNum = 983076;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=983077;
 //BA.debugLineNum = 983077;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(_activitypanel.getObject()));
RDebugUtils.currentLine=983080;
 //BA.debugLineNum = 983080;BA.debugLine="Dim maxSale As Int = maxSales";
_maxsale = _maxsales;
RDebugUtils.currentLine=983082;
 //BA.debugLineNum = 983082;BA.debugLine="Dim cv As Canvas";
_cv = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=983083;
 //BA.debugLineNum = 983083;BA.debugLine="cv.Initialize(panel)";
_cv.Initialize((android.view.View)(_panel.getObject()));
RDebugUtils.currentLine=983086;
 //BA.debugLineNum = 983086;BA.debugLine="Dim totalProducts As Int =  sale1.Length";
_totalproducts = _sale1.length;
RDebugUtils.currentLine=983087;
 //BA.debugLineNum = 983087;BA.debugLine="Dim barsPerProduct As Int = 3";
_barsperproduct = (int) (3);
RDebugUtils.currentLine=983088;
 //BA.debugLineNum = 983088;BA.debugLine="Dim totalBars As Int = totalProducts * barsPerPro";
_totalbars = (int) (_totalproducts*_barsperproduct);
RDebugUtils.currentLine=983089;
 //BA.debugLineNum = 983089;BA.debugLine="Dim gap As Int = 5dip";
_gap = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=983090;
 //BA.debugLineNum = 983090;BA.debugLine="Dim productGap As Int = 15dip";
_productgap = __c.DipToCurrent((int) (15));
RDebugUtils.currentLine=983091;
 //BA.debugLineNum = 983091;BA.debugLine="Dim padding As Int = 20dip";
_padding = __c.DipToCurrent((int) (20));
RDebugUtils.currentLine=983093;
 //BA.debugLineNum = 983093;BA.debugLine="Dim availableWidth As Int = activityPanel.Width -";
_availablewidth = (int) (_activitypanel.getWidth()-(_padding*2)-((_totalproducts-1)*_productgap)-((_totalbars-_totalproducts)*_gap));
RDebugUtils.currentLine=983094;
 //BA.debugLineNum = 983094;BA.debugLine="Dim barWidth As Int = availableWidth / totalBars";
_barwidth = (int) (_availablewidth/(double)_totalbars);
RDebugUtils.currentLine=983095;
 //BA.debugLineNum = 983095;BA.debugLine="Dim xStart As Int = padding";
_xstart = _padding;
RDebugUtils.currentLine=983097;
 //BA.debugLineNum = 983097;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=983098;
 //BA.debugLineNum = 983098;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(_activitypanel.getObject()));
RDebugUtils.currentLine=983100;
 //BA.debugLineNum = 983100;BA.debugLine="For i = 0 To totalProducts - 1";
{
final int step41 = 1;
final int limit41 = (int) (_totalproducts-1);
_i = (int) (0) ;
for (;_i <= limit41 ;_i = _i + step41 ) {
RDebugUtils.currentLine=983102;
 //BA.debugLineNum = 983102;BA.debugLine="Dim xPos As Int = xStart + i * (barsPerProduct *";
_xpos = (int) (_xstart+_i*(_barsperproduct*(_barwidth+_gap)+_productgap));
RDebugUtils.currentLine=983103;
 //BA.debugLineNum = 983103;BA.debugLine="Dim saleValues() As Int = Array As Int(sale1(i),";
_salevalues = new int[]{_sale1[_i],_sale2[_i],_sale3[_i]};
RDebugUtils.currentLine=983105;
 //BA.debugLineNum = 983105;BA.debugLine="Dim indexOffset As Int = 0";
_indexoffset = (int) (0);
RDebugUtils.currentLine=983107;
 //BA.debugLineNum = 983107;BA.debugLine="For j = 0 To barsPerProduct - 1";
{
final int step45 = 1;
final int limit45 = (int) (_barsperproduct-1);
_j = (int) (0) ;
for (;_j <= limit45 ;_j = _j + step45 ) {
RDebugUtils.currentLine=983108;
 //BA.debugLineNum = 983108;BA.debugLine="If j < checkedSales.Length And checkedSales(j)";
if (_j<__ref._checkedsales /*boolean[]*/ .length && __ref._checkedsales /*boolean[]*/ [_j]) { 
RDebugUtils.currentLine=983109;
 //BA.debugLineNum = 983109;BA.debugLine="Dim sale As Int = saleValues(j)";
_sale = _salevalues[_j];
RDebugUtils.currentLine=983110;
 //BA.debugLineNum = 983110;BA.debugLine="Dim barHeight As Int = (sale / maxSales) * (ac";
_barheight = (int) ((_sale/(double)_maxsales)*(_activitypanel.getHeight()));
RDebugUtils.currentLine=983112;
 //BA.debugLineNum = 983112;BA.debugLine="Dim xBar As Int = xPos + indexOffset * barWidt";
_xbar = (int) (_xpos+_indexoffset*_barwidth);
RDebugUtils.currentLine=983114;
 //BA.debugLineNum = 983114;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=983115;
 //BA.debugLineNum = 983115;BA.debugLine="r.Initialize(xBar, activityPanel.Height - barH";
_r.Initialize(_xbar,(int) (_activitypanel.getHeight()-_barheight),(int) (_xbar+_barwidth),_panel.getHeight());
RDebugUtils.currentLine=983116;
 //BA.debugLineNum = 983116;BA.debugLine="graphCanvas.DrawRect(r, color(j), True, 2dip)";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),__ref._color /*int[]*/ [_j],__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=983119;
 //BA.debugLineNum = 983119;BA.debugLine="Dim fontSize As Int = 8";
_fontsize = (int) (8);
RDebugUtils.currentLine=983120;
 //BA.debugLineNum = 983120;BA.debugLine="If Active.Width > 800 Then";
if (_active.getWidth()>800) { 
RDebugUtils.currentLine=983121;
 //BA.debugLineNum = 983121;BA.debugLine="fontSize = 10";
_fontsize = (int) (10);
 };
RDebugUtils.currentLine=983123;
 //BA.debugLineNum = 983123;BA.debugLine="graphCanvas.DrawText( FormatNumberWithSuffix(s";
_graphcanvas.DrawText(ba,__ref._formatnumberwithsuffix /*String*/ (null,_sale),(float) (_xbar+(_barwidth/(double)2)),(float) (_activitypanel.getHeight()-_barheight-__c.DipToCurrent((int) (5))),__c.Typeface.MONOSPACE,(float) (_fontsize),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
RDebugUtils.currentLine=983124;
 //BA.debugLineNum = 983124;BA.debugLine="indexOffset = indexOffset + 1 '";
_indexoffset = (int) (_indexoffset+1);
 };
 }
};
RDebugUtils.currentLine=983129;
 //BA.debugLineNum = 983129;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
_productlabely = (int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (20)));
RDebugUtils.currentLine=983130;
 //BA.debugLineNum = 983130;BA.debugLine="Dim productLabelX As Int = alignLeftCenter + 50d";
_productlabelx = (int) (_alignleftcenter+__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=983131;
 //BA.debugLineNum = 983131;BA.debugLine="cv.DrawText(product(i), xPos + productLabelX, pr";
_cv.DrawText(ba,_product[_i],(float) (_xpos+_productlabelx),(float) (_productlabely),__c.Typeface.MONOSPACE,(float) (12),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
 }
};
RDebugUtils.currentLine=983133;
 //BA.debugLineNum = 983133;BA.debugLine="Dim numLabels As Int =10";
_numlabels = (int) (10);
RDebugUtils.currentLine=983134;
 //BA.debugLineNum = 983134;BA.debugLine="For i = 0 To numLabels";
{
final int step66 = 1;
final int limit66 = _numlabels;
_i = (int) (0) ;
for (;_i <= limit66 ;_i = _i + step66 ) {
RDebugUtils.currentLine=983135;
 //BA.debugLineNum = 983135;BA.debugLine="Dim labelValue As Int = Round((maxSales / numLab";
_labelvalue = (int) (__c.Round((_maxsales/(double)_numlabels)*_i));
RDebugUtils.currentLine=983136;
 //BA.debugLineNum = 983136;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ((";
_labelypos = (int) (_activitypanel.getHeight()-((_labelvalue/(double)_maxsale)*_activitypanel.getHeight()));
RDebugUtils.currentLine=983139;
 //BA.debugLineNum = 983139;BA.debugLine="cv.DrawText(FormatNumberWithLabel(labelValue), a";
_cv.DrawText(ba,__ref._formatnumberwithlabel /*String*/ (null,_labelvalue),(float) (_alignleftcenter-__c.DipToCurrent((int) (10))),(float) (_labelypos+_aligntopcenter+__c.DipToCurrent((int) (5))),__c.Typeface.MONOSPACE,(float) (10),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"RIGHT"));
 }
};
RDebugUtils.currentLine=983141;
 //BA.debugLineNum = 983141;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Private checkBoxes() As CheckBox";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[(int) (0)];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Private checkedSales() As Boolean";
_checkedsales = new boolean[(int) (0)];
;
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="Dim color() As Int = Array As Int(Colors.RGB(255,";
_color = new int[]{__c.Colors.RGB((int) (255),(int) (0),(int) (0)),__c.Colors.RGB((int) (200),(int) (20),(int) (20)),__c.Colors.RGB((int) (100),(int) (10),(int) (10))};
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="Dim legendPanel As Panel";
_legendpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="Dim Active1 As Activity";
_active1 = new anywheresoftware.b4a.objects.ActivityWrapper();
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="Dim panel_l As Panel";
_panel_l = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="Dim sale_1() As Int";
_sale_1 = new int[(int) (0)];
;
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="Dim sale_2() As Int";
_sale_2 = new int[(int) (0)];
;
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="Dim sale_3() As Int";
_sale_3 = new int[(int) (0)];
;
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="Dim product1() As String";
_product1 = new String[(int) (0)];
java.util.Arrays.fill(_product1,"");
RDebugUtils.currentLine=851980;
 //BA.debugLineNum = 851980;BA.debugLine="Dim legend1() As String";
_legend1 = new String[(int) (0)];
java.util.Arrays.fill(_legend1,"");
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="Dim maxSales1 As Int = 0";
_maxsales1 = (int) (0);
RDebugUtils.currentLine=851982;
 //BA.debugLineNum = 851982;BA.debugLine="Dim titleString1 As String = \"\"";
_titlestring1 = "";
RDebugUtils.currentLine=851983;
 //BA.debugLineNum = 851983;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithsuffix(b4a.example.bargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithsuffix", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithsuffix", new Object[] {_number}));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
if (true) return __c.NumberFormat(_number/(double)1000000,(int) (1),(int) (1))+"M";
 }else 
{RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
if (true) return __c.NumberFormat(_number/(double)1000,(int) (1),(int) (1))+"k";
 }else {
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="Return NumberFormat(number, 1, 0)";
if (true) return __c.NumberFormat(_number,(int) (1),(int) (0));
 }}
;
RDebugUtils.currentLine=1114120;
 //BA.debugLineNum = 1114120;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithlabel(b4a.example.bargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithlabel", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithlabel", new Object[] {_number}));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000000))+"M";
 }else 
{RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="Return Floor(number / 1000) & \"k\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000))+"k";
 }else {
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="Return number ' No formatting needed for v";
if (true) return BA.NumberToString(_number);
 }}
;
RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="End Sub";
return "";
}
}