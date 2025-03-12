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
public int[] _comid1 = null;
public int _currentpage = 0;
public int _itemsperpage = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _btnnext = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnback = null;
public String _layout = "";
public boolean _isfirstinit = false;
public b4a.example.main _main = null;
public b4a.example.device _device = null;
public b4a.example.starter _starter = null;
public b4a.example.branch _branch = null;
public b4a.example.httputils2service _httputils2service = null;
public String  _initialize(b4a.example.bargraph __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _active,anywheresoftware.b4a.objects.PanelWrapper _panel,int[] _sale1,int[] _sale2,int[] _sale3,String[] _product,String[] _legend,int _maxsales,String _titlestring,int[] _comid,String _layout1,anywheresoftware.b4a.objects.ButtonWrapper _nextbtn,anywheresoftware.b4a.objects.ButtonWrapper _backbtn) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_active,_panel,_sale1,_sale2,_sale3,_product,_legend,_maxsales,_titlestring,_comid,_layout1,_nextbtn,_backbtn}));}
int _legendwidth = 0;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[] _tempcheckboxes = null;
boolean[] _tempcheckedsales = null;
int _i = 0;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cdback = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cdnext = null;
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Public Sub Initialize(Active As Activity, panel As";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="If Active.IsInitialized = False Then";
if (_active.IsInitialized()==__c.False) { 
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="Log(\"Error: Activity is not initialized\")";
__c.LogImpl("34980738","Error: Activity is not initialized",0);
RDebugUtils.currentLine=4980739;
 //BA.debugLineNum = 4980739;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=4980741;
 //BA.debugLineNum = 4980741;BA.debugLine="Active1 = Active";
__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/  = _active;
RDebugUtils.currentLine=4980742;
 //BA.debugLineNum = 4980742;BA.debugLine="panel_l = panel";
__ref._panel_l /*anywheresoftware.b4a.objects.PanelWrapper*/  = _panel;
RDebugUtils.currentLine=4980743;
 //BA.debugLineNum = 4980743;BA.debugLine="sale_1 = sale1";
__ref._sale_1 /*int[]*/  = _sale1;
RDebugUtils.currentLine=4980744;
 //BA.debugLineNum = 4980744;BA.debugLine="sale_2 = sale2";
__ref._sale_2 /*int[]*/  = _sale2;
RDebugUtils.currentLine=4980745;
 //BA.debugLineNum = 4980745;BA.debugLine="sale_3 = sale3";
__ref._sale_3 /*int[]*/  = _sale3;
RDebugUtils.currentLine=4980746;
 //BA.debugLineNum = 4980746;BA.debugLine="product1 = product";
__ref._product1 /*String[]*/  = _product;
RDebugUtils.currentLine=4980747;
 //BA.debugLineNum = 4980747;BA.debugLine="legend1 = legend";
__ref._legend1 /*String[]*/  = _legend;
RDebugUtils.currentLine=4980748;
 //BA.debugLineNum = 4980748;BA.debugLine="maxSales1 = maxSales";
__ref._maxsales1 /*int*/  = _maxsales;
RDebugUtils.currentLine=4980749;
 //BA.debugLineNum = 4980749;BA.debugLine="titleString1 = TitleString";
__ref._titlestring1 /*String*/  = _titlestring;
RDebugUtils.currentLine=4980750;
 //BA.debugLineNum = 4980750;BA.debugLine="comId1 = comId";
__ref._comid1 /*int[]*/  = _comid;
RDebugUtils.currentLine=4980751;
 //BA.debugLineNum = 4980751;BA.debugLine="layout = layout1";
__ref._layout /*String*/  = _layout1;
RDebugUtils.currentLine=4980752;
 //BA.debugLineNum = 4980752;BA.debugLine="btnNext = NextBtn";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/  = _nextbtn;
RDebugUtils.currentLine=4980753;
 //BA.debugLineNum = 4980753;BA.debugLine="btnBack = Backbtn";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/  = _backbtn;
RDebugUtils.currentLine=4980754;
 //BA.debugLineNum = 4980754;BA.debugLine="If sale1.Length <> product.Length Or sale2.Length";
if (_sale1.length!=_product.length || _sale2.length!=_product.length || _sale3.length!=_product.length) { 
RDebugUtils.currentLine=4980755;
 //BA.debugLineNum = 4980755;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=4980758;
 //BA.debugLineNum = 4980758;BA.debugLine="legendPanel.Initialize(\"\")";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .Initialize(ba,"");
RDebugUtils.currentLine=4980759;
 //BA.debugLineNum = 4980759;BA.debugLine="legendPanel.Width = panel.Width";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setWidth(_panel.getWidth());
RDebugUtils.currentLine=4980760;
 //BA.debugLineNum = 4980760;BA.debugLine="legendPanel.Height = 30dip";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setHeight(__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=4980762;
 //BA.debugLineNum = 4980762;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
_legendwidth = (int) (__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()/(double)_legend.length);
RDebugUtils.currentLine=4980763;
 //BA.debugLineNum = 4980763;BA.debugLine="checkBoxes = Array As CheckBox()";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/  = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]{};
RDebugUtils.currentLine=4980764;
 //BA.debugLineNum = 4980764;BA.debugLine="checkedSales = Array As Boolean()";
__ref._checkedsales /*boolean[]*/  = new boolean[]{};
RDebugUtils.currentLine=4980766;
 //BA.debugLineNum = 4980766;BA.debugLine="Dim checkBoxes(legend.Length) As CheckBox";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[_legend.length];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=4980767;
 //BA.debugLineNum = 4980767;BA.debugLine="Dim checkedSales(legend.Length) As Boolean";
_checkedsales = new boolean[_legend.length];
;
RDebugUtils.currentLine=4980768;
 //BA.debugLineNum = 4980768;BA.debugLine="If isFirstInit Then";
if (__ref._isfirstinit /*boolean*/ ) { 
RDebugUtils.currentLine=4980770;
 //BA.debugLineNum = 4980770;BA.debugLine="Dim tempCheckBoxes(legend.Length) As CheckBox";
_tempcheckboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[_legend.length];
{
int d0 = _tempcheckboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_tempcheckboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=4980771;
 //BA.debugLineNum = 4980771;BA.debugLine="checkBoxes = tempCheckBoxes";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/  = _tempcheckboxes;
RDebugUtils.currentLine=4980772;
 //BA.debugLineNum = 4980772;BA.debugLine="Dim tempCheckedSales(legend.Length) As Boolean";
_tempcheckedsales = new boolean[_legend.length];
;
RDebugUtils.currentLine=4980773;
 //BA.debugLineNum = 4980773;BA.debugLine="checkedSales = tempCheckedSales";
__ref._checkedsales /*boolean[]*/  = _tempcheckedsales;
RDebugUtils.currentLine=4980776;
 //BA.debugLineNum = 4980776;BA.debugLine="For i = 0 To legend.Length - 1";
{
final int step34 = 1;
final int limit34 = (int) (_legend.length-1);
_i = (int) (0) ;
for (;_i <= limit34 ;_i = _i + step34 ) {
RDebugUtils.currentLine=4980777;
 //BA.debugLineNum = 4980777;BA.debugLine="Dim chk As CheckBox";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=4980778;
 //BA.debugLineNum = 4980778;BA.debugLine="chk.Initialize(\"chkChange\")";
_chk.Initialize(ba,"chkChange");
RDebugUtils.currentLine=4980779;
 //BA.debugLineNum = 4980779;BA.debugLine="chk.Text = legend(i)";
_chk.setText(BA.ObjectToCharSequence(_legend[_i]));
RDebugUtils.currentLine=4980780;
 //BA.debugLineNum = 4980780;BA.debugLine="chk.TextSize = 10";
_chk.setTextSize((float) (10));
RDebugUtils.currentLine=4980781;
 //BA.debugLineNum = 4980781;BA.debugLine="chk.Typeface = Typeface.MONOSPACE";
_chk.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=4980782;
 //BA.debugLineNum = 4980782;BA.debugLine="chk.TextColor = color(i)";
_chk.setTextColor(__ref._color /*int[]*/ [_i]);
RDebugUtils.currentLine=4980783;
 //BA.debugLineNum = 4980783;BA.debugLine="chk.Tag = i";
_chk.setTag((Object)(_i));
RDebugUtils.currentLine=4980784;
 //BA.debugLineNum = 4980784;BA.debugLine="chk.Checked = True  ' Default state";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=4980785;
 //BA.debugLineNum = 4980785;BA.debugLine="checkedSales(i) = True";
__ref._checkedsales /*boolean[]*/ [_i] = __c.True;
RDebugUtils.currentLine=4980786;
 //BA.debugLineNum = 4980786;BA.debugLine="legendPanel.AddView(chk, (legendWidth * i) + 30";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(_chk.getObject()),(int) ((_legendwidth*_i)+__c.DipToCurrent((int) (30))),__c.DipToCurrent((int) (0)),(int) (_legendwidth-__c.DipToCurrent((int) (30))),__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight());
RDebugUtils.currentLine=4980787;
 //BA.debugLineNum = 4980787;BA.debugLine="checkBoxes(i) = chk";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/ [_i] = _chk;
 }
};
RDebugUtils.currentLine=4980789;
 //BA.debugLineNum = 4980789;BA.debugLine="isFirstInit = False";
__ref._isfirstinit /*boolean*/  = __c.False;
 }else {
RDebugUtils.currentLine=4980792;
 //BA.debugLineNum = 4980792;BA.debugLine="For i = 0 To checkBoxes.Length - 1";
{
final int step49 = 1;
final int limit49 = (int) (__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit49 ;_i = _i + step49 ) {
RDebugUtils.currentLine=4980793;
 //BA.debugLineNum = 4980793;BA.debugLine="checkBoxes(i).Checked = checkedSales(i)";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/ [_i].setChecked(__ref._checkedsales /*boolean[]*/ [_i]);
 }
};
 };
RDebugUtils.currentLine=4980799;
 //BA.debugLineNum = 4980799;BA.debugLine="btnBack.Text = \"Back\"";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setText(BA.ObjectToCharSequence("Back"));
RDebugUtils.currentLine=4980800;
 //BA.debugLineNum = 4980800;BA.debugLine="btnBack.TextSize = 14";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextSize((float) (14));
RDebugUtils.currentLine=4980801;
 //BA.debugLineNum = 4980801;BA.debugLine="btnBack.Typeface = Typeface.MONOSPACE";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=4980802;
 //BA.debugLineNum = 4980802;BA.debugLine="btnBack.TextColor = Colors.White";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextColor(__c.Colors.White);
RDebugUtils.currentLine=4980803;
 //BA.debugLineNum = 4980803;BA.debugLine="Dim cdBack As ColorDrawable";
_cdback = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=4980804;
 //BA.debugLineNum = 4980804;BA.debugLine="cdBack.Initialize2(Colors.RGB(61, 12, 2), 10dip,";
_cdback.Initialize2(__c.Colors.RGB((int) (61),(int) (12),(int) (2)),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (2)),__c.Colors.Black);
RDebugUtils.currentLine=4980805;
 //BA.debugLineNum = 4980805;BA.debugLine="btnBack.Background = cdBack";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setBackground((android.graphics.drawable.Drawable)(_cdback.getObject()));
RDebugUtils.currentLine=4980808;
 //BA.debugLineNum = 4980808;BA.debugLine="btnNext.Text = \"Next\"";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setText(BA.ObjectToCharSequence("Next"));
RDebugUtils.currentLine=4980809;
 //BA.debugLineNum = 4980809;BA.debugLine="btnNext.TextSize = 14";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextSize((float) (14));
RDebugUtils.currentLine=4980810;
 //BA.debugLineNum = 4980810;BA.debugLine="btnNext.Typeface = Typeface.MONOSPACE";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=4980811;
 //BA.debugLineNum = 4980811;BA.debugLine="btnNext.TextColor = Colors.White";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextColor(__c.Colors.White);
RDebugUtils.currentLine=4980812;
 //BA.debugLineNum = 4980812;BA.debugLine="Dim cdNext As ColorDrawable";
_cdnext = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=4980813;
 //BA.debugLineNum = 4980813;BA.debugLine="cdNext.Initialize2(Colors.RGB(185, 46, 52), 10dip";
_cdnext.Initialize2(__c.Colors.RGB((int) (185),(int) (46),(int) (52)),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (2)),__c.Colors.Black);
RDebugUtils.currentLine=4980814;
 //BA.debugLineNum = 4980814;BA.debugLine="btnNext.Background = cdNext";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setBackground((android.graphics.drawable.Drawable)(_cdnext.getObject()));
RDebugUtils.currentLine=4980816;
 //BA.debugLineNum = 4980816;BA.debugLine="DrawGraph(Active, panel, sale1, sale2, sale3, pro";
__ref._drawgraph /*String*/ (null,_active,_panel,_sale1,_sale2,_sale3,_product,_maxsales,_titlestring);
RDebugUtils.currentLine=4980817;
 //BA.debugLineNum = 4980817;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Sub chkChange_CheckedChange(Checked As Boolean)";
RDebugUtils.currentLine=5505025;
 //BA.debugLineNum = 5505025;BA.debugLine="If Sender Is CheckBox Then";
if (__c.Sender(ba) instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=5505026;
 //BA.debugLineNum = 5505026;BA.debugLine="Dim chk As CheckBox = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper(), (android.widget.CheckBox)(__c.Sender(ba)));
RDebugUtils.currentLine=5505027;
 //BA.debugLineNum = 5505027;BA.debugLine="Dim index As Int = chk.Tag";
_index = (int)(BA.ObjectToNumber(_chk.getTag()));
RDebugUtils.currentLine=5505029;
 //BA.debugLineNum = 5505029;BA.debugLine="Dim checkedCount As Int = 0";
_checkedcount = (int) (0);
RDebugUtils.currentLine=5505030;
 //BA.debugLineNum = 5505030;BA.debugLine="For i = 0 To checkedSales.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (__ref._checkedsales /*boolean[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=5505031;
 //BA.debugLineNum = 5505031;BA.debugLine="If checkedSales(i) = True Then checkedCount = c";
if (__ref._checkedsales /*boolean[]*/ [_i]==__c.True) { 
_checkedcount = (int) (_checkedcount+1);};
 }
};
RDebugUtils.currentLine=5505034;
 //BA.debugLineNum = 5505034;BA.debugLine="If Checked = False And checkedCount = 1 Then";
if (_checked==__c.False && _checkedcount==1) { 
RDebugUtils.currentLine=5505035;
 //BA.debugLineNum = 5505035;BA.debugLine="chk.Checked = True";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=5505036;
 //BA.debugLineNum = 5505036;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=5505039;
 //BA.debugLineNum = 5505039;BA.debugLine="checkedSales(index) = Checked";
__ref._checkedsales /*boolean[]*/ [_index] = _checked;
RDebugUtils.currentLine=5505040;
 //BA.debugLineNum = 5505040;BA.debugLine="UpdateGraph ' Call DrawGraph without parameters";
__ref._updategraph /*String*/ (null);
 }else {
RDebugUtils.currentLine=5505042;
 //BA.debugLineNum = 5505042;BA.debugLine="Log(\"Error: Sender is not a CheckBox\")";
__c.LogImpl("35505042","Error: Sender is not a CheckBox",0);
 };
RDebugUtils.currentLine=5505044;
 //BA.debugLineNum = 5505044;BA.debugLine="End Sub";
return "";
}
public String  _updategraph(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "updategraph", false))
	 {return ((String) Debug.delegate(ba, "updategraph", null));}
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Public Sub UpdateGraph";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="DrawGraph(Active1, panel_l, sale_1, sale_2, sale_";
__ref._drawgraph /*String*/ (null,__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/ ,__ref._panel_l /*anywheresoftware.b4a.objects.PanelWrapper*/ ,__ref._sale_1 /*int[]*/ ,__ref._sale_2 /*int[]*/ ,__ref._sale_3 /*int[]*/ ,__ref._product1 /*String[]*/ ,__ref._maxsales1 /*int*/ ,__ref._titlestring1 /*String*/ );
RDebugUtils.currentLine=5111810;
 //BA.debugLineNum = 5111810;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="Private checkBoxes() As CheckBox";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[(int) (0)];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=4915202;
 //BA.debugLineNum = 4915202;BA.debugLine="Public checkedSales() As Boolean";
_checkedsales = new boolean[(int) (0)];
;
RDebugUtils.currentLine=4915203;
 //BA.debugLineNum = 4915203;BA.debugLine="Dim color() As Int = Array As Int(Colors.RGB(255,";
_color = new int[]{__c.Colors.RGB((int) (255),(int) (0),(int) (0)),__c.Colors.RGB((int) (200),(int) (20),(int) (20)),__c.Colors.RGB((int) (100),(int) (10),(int) (10))};
RDebugUtils.currentLine=4915204;
 //BA.debugLineNum = 4915204;BA.debugLine="Dim legendPanel As Panel";
_legendpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4915205;
 //BA.debugLineNum = 4915205;BA.debugLine="Dim Active1 As Activity";
_active1 = new anywheresoftware.b4a.objects.ActivityWrapper();
RDebugUtils.currentLine=4915206;
 //BA.debugLineNum = 4915206;BA.debugLine="Dim panel_l As Panel";
_panel_l = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4915207;
 //BA.debugLineNum = 4915207;BA.debugLine="Dim sale_1() As Int";
_sale_1 = new int[(int) (0)];
;
RDebugUtils.currentLine=4915208;
 //BA.debugLineNum = 4915208;BA.debugLine="Dim sale_2() As Int";
_sale_2 = new int[(int) (0)];
;
RDebugUtils.currentLine=4915209;
 //BA.debugLineNum = 4915209;BA.debugLine="Dim sale_3() As Int";
_sale_3 = new int[(int) (0)];
;
RDebugUtils.currentLine=4915210;
 //BA.debugLineNum = 4915210;BA.debugLine="Dim product1() As String";
_product1 = new String[(int) (0)];
java.util.Arrays.fill(_product1,"");
RDebugUtils.currentLine=4915211;
 //BA.debugLineNum = 4915211;BA.debugLine="Dim legend1() As String";
_legend1 = new String[(int) (0)];
java.util.Arrays.fill(_legend1,"");
RDebugUtils.currentLine=4915212;
 //BA.debugLineNum = 4915212;BA.debugLine="Dim maxSales1 As Int = 0";
_maxsales1 = (int) (0);
RDebugUtils.currentLine=4915213;
 //BA.debugLineNum = 4915213;BA.debugLine="Dim titleString1 As String = \"\"";
_titlestring1 = "";
RDebugUtils.currentLine=4915214;
 //BA.debugLineNum = 4915214;BA.debugLine="Dim comId1() As Int";
_comid1 = new int[(int) (0)];
;
RDebugUtils.currentLine=4915215;
 //BA.debugLineNum = 4915215;BA.debugLine="Private currentPage As Int = 1";
_currentpage = (int) (1);
RDebugUtils.currentLine=4915216;
 //BA.debugLineNum = 4915216;BA.debugLine="Private itemsPerPage As Int = 5";
_itemsperpage = (int) (5);
RDebugUtils.currentLine=4915217;
 //BA.debugLineNum = 4915217;BA.debugLine="Public btnNext As Button";
_btnnext = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=4915218;
 //BA.debugLineNum = 4915218;BA.debugLine="Public btnBack As Button";
_btnback = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=4915219;
 //BA.debugLineNum = 4915219;BA.debugLine="Dim layout As String = \"\"";
_layout = "";
RDebugUtils.currentLine=4915220;
 //BA.debugLineNum = 4915220;BA.debugLine="Private isFirstInit As Boolean = True";
_isfirstinit = __c.True;
RDebugUtils.currentLine=4915221;
 //BA.debugLineNum = 4915221;BA.debugLine="End Sub";
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
int _startindex = 0;
int _endindex = 0;
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
anywheresoftware.b4a.objects.LabelWrapper _productlabel = null;
int _productlabely = 0;
int _productlabelx = 0;
int _numlabels = 0;
int _labelvalue = 0;
int _labelypos = 0;
anywheresoftware.b4a.objects.LabelWrapper _yaxislabel = null;
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Public Sub DrawGraph(Active As Activity, panel As";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="Try";
try {RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="panel.Invalidate";
_panel.Invalidate();
RDebugUtils.currentLine=5046275;
 //BA.debugLineNum = 5046275;BA.debugLine="panel.RemoveAllViews";
_panel.RemoveAllViews();
RDebugUtils.currentLine=5046276;
 //BA.debugLineNum = 5046276;BA.debugLine="panel.Height = 450dip";
_panel.setHeight(__c.DipToCurrent((int) (450)));
RDebugUtils.currentLine=5046277;
 //BA.debugLineNum = 5046277;BA.debugLine="If panel.Width = 0 Then";
if (_panel.getWidth()==0) { 
RDebugUtils.currentLine=5046278;
 //BA.debugLineNum = 5046278;BA.debugLine="panel.Width = 800dip";
_panel.setWidth(__c.DipToCurrent((int) (800)));
 };
RDebugUtils.currentLine=5046281;
 //BA.debugLineNum = 5046281;BA.debugLine="panel.AddView(legendPanel, 0, 0, panel.Width, 30";
_panel.AddView((android.view.View)(__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()),(int) (0),(int) (0),_panel.getWidth(),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=5046283;
 //BA.debugLineNum = 5046283;BA.debugLine="Dim activityPanel As Panel";
_activitypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=5046284;
 //BA.debugLineNum = 5046284;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
_activitypanel.Initialize(ba,"activityPanel");
RDebugUtils.currentLine=5046286;
 //BA.debugLineNum = 5046286;BA.debugLine="activityPanel.Width = 80%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (80),ba));
RDebugUtils.currentLine=5046287;
 //BA.debugLineNum = 5046287;BA.debugLine="If Active.Width > 800 Then";
if (_active.getWidth()>800) { 
RDebugUtils.currentLine=5046288;
 //BA.debugLineNum = 5046288;BA.debugLine="activityPanel.Width = 55%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (55),ba));
 };
RDebugUtils.currentLine=5046290;
 //BA.debugLineNum = 5046290;BA.debugLine="activityPanel.Height = 250dip";
_activitypanel.setHeight(__c.DipToCurrent((int) (250)));
RDebugUtils.currentLine=5046291;
 //BA.debugLineNum = 5046291;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211,";
_activitypanel.setColor(__c.Colors.ARGB((int) (70),(int) (211),(int) (211),(int) (211)));
RDebugUtils.currentLine=5046293;
 //BA.debugLineNum = 5046293;BA.debugLine="Dim alignLeftCenter As Int = (Active.Width - act";
_alignleftcenter = (int) ((_active.getWidth()-_activitypanel.getWidth())/(double)2);
RDebugUtils.currentLine=5046294;
 //BA.debugLineNum = 5046294;BA.debugLine="Dim alignTopCenter As Int = (panel.Height - acti";
_aligntopcenter = (int) ((_panel.getHeight()-_activitypanel.getHeight())/(double)2-__c.DipToCurrent((int) (20)));
RDebugUtils.currentLine=5046296;
 //BA.debugLineNum = 5046296;BA.debugLine="Dim Title As Label";
_title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5046297;
 //BA.debugLineNum = 5046297;BA.debugLine="Title.Initialize(\"\")";
_title.Initialize(ba,"");
RDebugUtils.currentLine=5046298;
 //BA.debugLineNum = 5046298;BA.debugLine="Title.Text = TitleString";
_title.setText(BA.ObjectToCharSequence(_titlestring));
RDebugUtils.currentLine=5046299;
 //BA.debugLineNum = 5046299;BA.debugLine="Title.TextSize = 20";
_title.setTextSize((float) (20));
RDebugUtils.currentLine=5046300;
 //BA.debugLineNum = 5046300;BA.debugLine="Title.Typeface = Typeface.MONOSPACE";
_title.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=5046301;
 //BA.debugLineNum = 5046301;BA.debugLine="Title.Gravity = Gravity.CENTER";
_title.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=5046302;
 //BA.debugLineNum = 5046302;BA.debugLine="Title.TextColor = Colors.Black";
_title.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=5046303;
 //BA.debugLineNum = 5046303;BA.debugLine="panel.AddView(Title, 0, alignTopCenter / 2, pane";
_panel.AddView((android.view.View)(_title.getObject()),(int) (0),(int) (_aligntopcenter/(double)2),_panel.getWidth(),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=5046305;
 //BA.debugLineNum = 5046305;BA.debugLine="panel.AddView(activityPanel, alignLeftCenter, al";
_panel.AddView((android.view.View)(_activitypanel.getObject()),_alignleftcenter,_aligntopcenter,_activitypanel.getWidth(),_activitypanel.getHeight());
RDebugUtils.currentLine=5046307;
 //BA.debugLineNum = 5046307;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=5046308;
 //BA.debugLineNum = 5046308;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(_activitypanel.getObject()));
RDebugUtils.currentLine=5046310;
 //BA.debugLineNum = 5046310;BA.debugLine="Dim maxSale As Int = maxSales * 1.2";
_maxsale = (int) (_maxsales*1.2);
RDebugUtils.currentLine=5046311;
 //BA.debugLineNum = 5046311;BA.debugLine="Dim cv As Canvas";
_cv = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=5046312;
 //BA.debugLineNum = 5046312;BA.debugLine="cv.Initialize(panel)";
_cv.Initialize((android.view.View)(_panel.getObject()));
RDebugUtils.currentLine=5046314;
 //BA.debugLineNum = 5046314;BA.debugLine="Dim totalProducts As Int = sale1.Length";
_totalproducts = _sale1.length;
RDebugUtils.currentLine=5046315;
 //BA.debugLineNum = 5046315;BA.debugLine="Dim startIndex As Int = (currentPage - 1) * item";
_startindex = (int) ((__ref._currentpage /*int*/ -1)*__ref._itemsperpage /*int*/ );
RDebugUtils.currentLine=5046316;
 //BA.debugLineNum = 5046316;BA.debugLine="Dim endIndex As Int = Min(startIndex + itemsPerP";
_endindex = (int) (__c.Min(_startindex+__ref._itemsperpage /*int*/ -1,_totalproducts-1));
RDebugUtils.currentLine=5046317;
 //BA.debugLineNum = 5046317;BA.debugLine="Dim barsPerProduct As Int = 3";
_barsperproduct = (int) (3);
RDebugUtils.currentLine=5046318;
 //BA.debugLineNum = 5046318;BA.debugLine="Dim totalBars As Int = (endIndex - startIndex +";
_totalbars = (int) ((_endindex-_startindex+1)*_barsperproduct);
RDebugUtils.currentLine=5046319;
 //BA.debugLineNum = 5046319;BA.debugLine="Dim gap As Int = 5dip";
_gap = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=5046320;
 //BA.debugLineNum = 5046320;BA.debugLine="Dim productGap As Int = 0dip";
_productgap = __c.DipToCurrent((int) (0));
RDebugUtils.currentLine=5046321;
 //BA.debugLineNum = 5046321;BA.debugLine="Dim padding As Int = 10dip";
_padding = __c.DipToCurrent((int) (10));
RDebugUtils.currentLine=5046323;
 //BA.debugLineNum = 5046323;BA.debugLine="Dim availableWidth As Int = activityPanel.Width";
_availablewidth = (int) (_activitypanel.getWidth()-(_padding*2)-(((_endindex-_startindex+1)-1)*_productgap)-((_totalbars-(_endindex-_startindex+1))*_gap));
RDebugUtils.currentLine=5046324;
 //BA.debugLineNum = 5046324;BA.debugLine="Dim barWidth As Int = availableWidth / totalBars";
_barwidth = (int) (_availablewidth/(double)_totalbars);
RDebugUtils.currentLine=5046325;
 //BA.debugLineNum = 5046325;BA.debugLine="Dim xStart As Int = padding";
_xstart = _padding;
RDebugUtils.currentLine=5046327;
 //BA.debugLineNum = 5046327;BA.debugLine="For i = startIndex To endIndex";
{
final int step44 = 1;
final int limit44 = _endindex;
_i = _startindex ;
for (;_i <= limit44 ;_i = _i + step44 ) {
RDebugUtils.currentLine=5046328;
 //BA.debugLineNum = 5046328;BA.debugLine="Dim xPos As Int = xStart + (i - startIndex) * (";
_xpos = (int) (_xstart+(_i-_startindex)*(_barsperproduct*(_barwidth+_gap)+_productgap));
RDebugUtils.currentLine=5046329;
 //BA.debugLineNum = 5046329;BA.debugLine="Dim saleValues() As Int = Array As Int(sale1(i)";
_salevalues = new int[]{_sale1[_i],_sale2[_i],_sale3[_i]};
RDebugUtils.currentLine=5046330;
 //BA.debugLineNum = 5046330;BA.debugLine="Dim indexOffset As Int = 0";
_indexoffset = (int) (0);
RDebugUtils.currentLine=5046332;
 //BA.debugLineNum = 5046332;BA.debugLine="For j = 0 To barsPerProduct - 1";
{
final int step48 = 1;
final int limit48 = (int) (_barsperproduct-1);
_j = (int) (0) ;
for (;_j <= limit48 ;_j = _j + step48 ) {
RDebugUtils.currentLine=5046333;
 //BA.debugLineNum = 5046333;BA.debugLine="If j < checkedSales.Length And checkedSales(j)";
if (_j<__ref._checkedsales /*boolean[]*/ .length && __ref._checkedsales /*boolean[]*/ [_j]) { 
RDebugUtils.currentLine=5046334;
 //BA.debugLineNum = 5046334;BA.debugLine="Dim sale As Int = saleValues(j)";
_sale = _salevalues[_j];
RDebugUtils.currentLine=5046335;
 //BA.debugLineNum = 5046335;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * (ac";
_barheight = (int) ((_sale/(double)_maxsale)*(_activitypanel.getHeight()));
RDebugUtils.currentLine=5046336;
 //BA.debugLineNum = 5046336;BA.debugLine="Dim xBar As Int = xPos + indexOffset * barWid";
_xbar = (int) (_xpos+_indexoffset*_barwidth);
RDebugUtils.currentLine=5046338;
 //BA.debugLineNum = 5046338;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=5046339;
 //BA.debugLineNum = 5046339;BA.debugLine="r.Initialize(xBar, activityPanel.Height - bar";
_r.Initialize(_xbar,(int) (_activitypanel.getHeight()-_barheight),(int) (_xbar+_barwidth),_activitypanel.getHeight());
RDebugUtils.currentLine=5046340;
 //BA.debugLineNum = 5046340;BA.debugLine="graphCanvas.DrawRect(r, color(j), True, 2dip)";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),__ref._color /*int[]*/ [_j],__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=5046342;
 //BA.debugLineNum = 5046342;BA.debugLine="Dim fontSize As Int = 8";
_fontsize = (int) (8);
RDebugUtils.currentLine=5046343;
 //BA.debugLineNum = 5046343;BA.debugLine="If Active.Width > 800 Then";
if (_active.getWidth()>800) { 
RDebugUtils.currentLine=5046344;
 //BA.debugLineNum = 5046344;BA.debugLine="fontSize = 10";
_fontsize = (int) (10);
 };
RDebugUtils.currentLine=5046346;
 //BA.debugLineNum = 5046346;BA.debugLine="graphCanvas.DrawText(FormatNumberWithSuffix(s";
_graphcanvas.DrawText(ba,__ref._formatnumberwithsuffix /*String*/ (null,_sale),(float) (_xbar+(_barwidth/(double)2)),(float) (_activitypanel.getHeight()-_barheight-__c.DipToCurrent((int) (5))),__c.Typeface.MONOSPACE,(float) (_fontsize),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
RDebugUtils.currentLine=5046347;
 //BA.debugLineNum = 5046347;BA.debugLine="indexOffset = indexOffset + 1";
_indexoffset = (int) (_indexoffset+1);
 };
 }
};
RDebugUtils.currentLine=5046351;
 //BA.debugLineNum = 5046351;BA.debugLine="Dim productLabel As Label";
_productlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5046352;
 //BA.debugLineNum = 5046352;BA.debugLine="productLabel.Initialize(\"productLabel\")";
_productlabel.Initialize(ba,"productLabel");
RDebugUtils.currentLine=5046353;
 //BA.debugLineNum = 5046353;BA.debugLine="productLabel.Text = product(i)";
_productlabel.setText(BA.ObjectToCharSequence(_product[_i]));
RDebugUtils.currentLine=5046354;
 //BA.debugLineNum = 5046354;BA.debugLine="productLabel.Typeface = Typeface.MONOSPACE";
_productlabel.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=5046355;
 //BA.debugLineNum = 5046355;BA.debugLine="productLabel.TextSize = 12";
_productlabel.setTextSize((float) (12));
RDebugUtils.currentLine=5046356;
 //BA.debugLineNum = 5046356;BA.debugLine="productLabel.Tag = comId1(i)";
_productlabel.setTag((Object)(__ref._comid1 /*int[]*/ [_i]));
RDebugUtils.currentLine=5046357;
 //BA.debugLineNum = 5046357;BA.debugLine="productLabel.TextColor = Colors.Black";
_productlabel.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=5046358;
 //BA.debugLineNum = 5046358;BA.debugLine="productLabel.Gravity = Gravity.CENTER";
_productlabel.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=5046359;
 //BA.debugLineNum = 5046359;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
_productlabely = (int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (10)));
RDebugUtils.currentLine=5046360;
 //BA.debugLineNum = 5046360;BA.debugLine="Dim productLabelX As Int = alignLeftCenter";
_productlabelx = _alignleftcenter;
RDebugUtils.currentLine=5046361;
 //BA.debugLineNum = 5046361;BA.debugLine="panel.AddView(productLabel, xPos + productLabel";
_panel.AddView((android.view.View)(_productlabel.getObject()),(int) (_xpos+_productlabelx),_productlabely,__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (30)));
 }
};
RDebugUtils.currentLine=5046364;
 //BA.debugLineNum = 5046364;BA.debugLine="Dim numLabels As Int = 10";
_numlabels = (int) (10);
RDebugUtils.currentLine=5046365;
 //BA.debugLineNum = 5046365;BA.debugLine="For i = 0 To numLabels";
{
final int step77 = 1;
final int limit77 = _numlabels;
_i = (int) (0) ;
for (;_i <= limit77 ;_i = _i + step77 ) {
RDebugUtils.currentLine=5046366;
 //BA.debugLineNum = 5046366;BA.debugLine="Dim labelValue As Int = Round((maxSale / numLab";
_labelvalue = (int) (__c.Round((_maxsale/(double)_numlabels)*_i));
RDebugUtils.currentLine=5046367;
 //BA.debugLineNum = 5046367;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - (";
_labelypos = (int) (_activitypanel.getHeight()-((_labelvalue/(double)_maxsale)*_activitypanel.getHeight()));
RDebugUtils.currentLine=5046369;
 //BA.debugLineNum = 5046369;BA.debugLine="Dim yAxisLabel As Label";
_yaxislabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5046370;
 //BA.debugLineNum = 5046370;BA.debugLine="yAxisLabel.Initialize(\"\")";
_yaxislabel.Initialize(ba,"");
RDebugUtils.currentLine=5046371;
 //BA.debugLineNum = 5046371;BA.debugLine="yAxisLabel.Text = FormatNumberWithLabel(labelVa";
_yaxislabel.setText(BA.ObjectToCharSequence(__ref._formatnumberwithlabel /*String*/ (null,_labelvalue)));
RDebugUtils.currentLine=5046372;
 //BA.debugLineNum = 5046372;BA.debugLine="yAxisLabel.TextSize = 10";
_yaxislabel.setTextSize((float) (10));
RDebugUtils.currentLine=5046373;
 //BA.debugLineNum = 5046373;BA.debugLine="yAxisLabel.Typeface = Typeface.MONOSPACE";
_yaxislabel.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=5046374;
 //BA.debugLineNum = 5046374;BA.debugLine="yAxisLabel.TextColor = Colors.Black";
_yaxislabel.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=5046375;
 //BA.debugLineNum = 5046375;BA.debugLine="yAxisLabel.Gravity = Gravity.RIGHT";
_yaxislabel.setGravity(__c.Gravity.RIGHT);
RDebugUtils.currentLine=5046377;
 //BA.debugLineNum = 5046377;BA.debugLine="panel.AddView(yAxisLabel, alignLeftCenter - 40d";
_panel.AddView((android.view.View)(_yaxislabel.getObject()),(int) (_alignleftcenter-__c.DipToCurrent((int) (40))),(int) (_labelypos+_aligntopcenter-__c.DipToCurrent((int) (5))),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (15)));
 }
};
RDebugUtils.currentLine=5046379;
 //BA.debugLineNum = 5046379;BA.debugLine="btnBack.Enabled = currentPage > 1";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setEnabled(__ref._currentpage /*int*/ >1);
RDebugUtils.currentLine=5046380;
 //BA.debugLineNum = 5046380;BA.debugLine="btnNext.Enabled = (currentPage * itemsPerPage) <";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setEnabled((__ref._currentpage /*int*/ *__ref._itemsperpage /*int*/ )<_sale1.length);
RDebugUtils.currentLine=5046382;
 //BA.debugLineNum = 5046382;BA.debugLine="panel.AddView(btnBack, alignLeftCenter, activity";
_panel.AddView((android.view.View)(__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .getObject()),_alignleftcenter,(int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (50))),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
RDebugUtils.currentLine=5046383;
 //BA.debugLineNum = 5046383;BA.debugLine="panel.AddView(btnNext, activityPanel.Width";
_panel.AddView((android.view.View)(__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .getObject()),(int) (_activitypanel.getWidth()-_alignleftcenter),(int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (50))),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 } 
       catch (Exception e94) {
			ba.setLastException(e94);RDebugUtils.currentLine=5046387;
 //BA.debugLineNum = 5046387;BA.debugLine="Log(LastException)";
__c.LogImpl("35046387",BA.ObjectToString(__c.LastException(ba)),0);
 };
RDebugUtils.currentLine=5046389;
 //BA.debugLineNum = 5046389;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithsuffix(b4a.example.bargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithsuffix", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithsuffix", new Object[] {_number}));}
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
RDebugUtils.currentLine=5373953;
 //BA.debugLineNum = 5373953;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=5373954;
 //BA.debugLineNum = 5373954;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
if (true) return __c.NumberFormat(_number/(double)1000000,(int) (1),(int) (1))+"M";
 }else 
{RDebugUtils.currentLine=5373955;
 //BA.debugLineNum = 5373955;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=5373956;
 //BA.debugLineNum = 5373956;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
if (true) return __c.NumberFormat(_number/(double)1000,(int) (1),(int) (1))+"k";
 }else {
RDebugUtils.currentLine=5373958;
 //BA.debugLineNum = 5373958;BA.debugLine="Return NumberFormat(number, 1, 0)";
if (true) return __c.NumberFormat(_number,(int) (1),(int) (0));
 }}
;
RDebugUtils.currentLine=5373960;
 //BA.debugLineNum = 5373960;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithlabel(b4a.example.bargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithlabel", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithlabel", new Object[] {_number}));}
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
RDebugUtils.currentLine=5439489;
 //BA.debugLineNum = 5439489;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=5439490;
 //BA.debugLineNum = 5439490;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000000))+"M";
 }else 
{RDebugUtils.currentLine=5439491;
 //BA.debugLineNum = 5439491;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=5439492;
 //BA.debugLineNum = 5439492;BA.debugLine="Return Floor(number / 1000) & \"k\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000))+"k";
 }else {
RDebugUtils.currentLine=5439494;
 //BA.debugLineNum = 5439494;BA.debugLine="Return number";
if (true) return BA.NumberToString(_number);
 }}
;
RDebugUtils.currentLine=5439496;
 //BA.debugLineNum = 5439496;BA.debugLine="End Sub";
return "";
}
public int  _getcurrentpage(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "getcurrentpage", false))
	 {return ((Integer) Debug.delegate(ba, "getcurrentpage", null));}
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Public Sub GetCurrentPage As Int";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="Return currentPage";
if (true) return __ref._currentpage /*int*/ ;
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="End Sub";
return 0;
}
public String  _productlabel_click(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "productlabel_click", false))
	 {return ((String) Debug.delegate(ba, "productlabel_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _clickedlabel = null;
int _selectedcompany = 0;
RDebugUtils.currentLine=5308416;
 //BA.debugLineNum = 5308416;BA.debugLine="Sub productLabel_Click";
RDebugUtils.currentLine=5308417;
 //BA.debugLineNum = 5308417;BA.debugLine="Dim clickedLabel As Label = Sender";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(__c.Sender(ba)));
RDebugUtils.currentLine=5308418;
 //BA.debugLineNum = 5308418;BA.debugLine="Dim selectedCompany As Int = clickedLabel.Tag";
_selectedcompany = (int)(BA.ObjectToNumber(_clickedlabel.getTag()));
RDebugUtils.currentLine=5308419;
 //BA.debugLineNum = 5308419;BA.debugLine="Log(\"Selected Company ID: \" & selectedCompany)";
__c.LogImpl("35308419","Selected Company ID: "+BA.NumberToString(_selectedcompany),0);
RDebugUtils.currentLine=5308420;
 //BA.debugLineNum = 5308420;BA.debugLine="Starter.company_selected = selectedCompany";
_starter._company_selected /*String*/  = BA.NumberToString(_selectedcompany);
RDebugUtils.currentLine=5308421;
 //BA.debugLineNum = 5308421;BA.debugLine="StartActivity(layout)";
__c.StartActivity(ba,(Object)(__ref._layout /*String*/ ));
RDebugUtils.currentLine=5308422;
 //BA.debugLineNum = 5308422;BA.debugLine="Active1.Finish";
__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/ .Finish();
RDebugUtils.currentLine=5308423;
 //BA.debugLineNum = 5308423;BA.debugLine="End Sub";
return "";
}
public String  _setcurrentpage(b4a.example.bargraph __ref,int _page) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "setcurrentpage", false))
	 {return ((String) Debug.delegate(ba, "setcurrentpage", new Object[] {_page}));}
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Public Sub SetCurrentPage(page As Int)";
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="currentPage = page";
__ref._currentpage /*int*/  = _page;
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="UpdateGraph";
__ref._updategraph /*String*/ (null);
RDebugUtils.currentLine=5242883;
 //BA.debugLineNum = 5242883;BA.debugLine="End Sub";
return "";
}
}