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
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Public Sub Initialize(Active As Activity, panel As";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="If Active.IsInitialized = False Then";
if (_active.IsInitialized()==__c.False) { 
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="Log(\"Error: Activity is not initialized\")";
__c.LogImpl("62555906","Error: Activity is not initialized",0);
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="Active1 = Active";
__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/  = _active;
RDebugUtils.currentLine=2555910;
 //BA.debugLineNum = 2555910;BA.debugLine="panel_l = panel";
__ref._panel_l /*anywheresoftware.b4a.objects.PanelWrapper*/  = _panel;
RDebugUtils.currentLine=2555911;
 //BA.debugLineNum = 2555911;BA.debugLine="sale_1 = sale1";
__ref._sale_1 /*int[]*/  = _sale1;
RDebugUtils.currentLine=2555912;
 //BA.debugLineNum = 2555912;BA.debugLine="sale_2 = sale2";
__ref._sale_2 /*int[]*/  = _sale2;
RDebugUtils.currentLine=2555913;
 //BA.debugLineNum = 2555913;BA.debugLine="sale_3 = sale3";
__ref._sale_3 /*int[]*/  = _sale3;
RDebugUtils.currentLine=2555914;
 //BA.debugLineNum = 2555914;BA.debugLine="product1 = product";
__ref._product1 /*String[]*/  = _product;
RDebugUtils.currentLine=2555915;
 //BA.debugLineNum = 2555915;BA.debugLine="legend1 = legend";
__ref._legend1 /*String[]*/  = _legend;
RDebugUtils.currentLine=2555916;
 //BA.debugLineNum = 2555916;BA.debugLine="maxSales1 = maxSales";
__ref._maxsales1 /*int*/  = _maxsales;
RDebugUtils.currentLine=2555917;
 //BA.debugLineNum = 2555917;BA.debugLine="titleString1 = TitleString";
__ref._titlestring1 /*String*/  = _titlestring;
RDebugUtils.currentLine=2555918;
 //BA.debugLineNum = 2555918;BA.debugLine="comId1 = comId";
__ref._comid1 /*int[]*/  = _comid;
RDebugUtils.currentLine=2555919;
 //BA.debugLineNum = 2555919;BA.debugLine="layout = layout1";
__ref._layout /*String*/  = _layout1;
RDebugUtils.currentLine=2555920;
 //BA.debugLineNum = 2555920;BA.debugLine="btnNext = NextBtn";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/  = _nextbtn;
RDebugUtils.currentLine=2555921;
 //BA.debugLineNum = 2555921;BA.debugLine="btnBack = Backbtn";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/  = _backbtn;
RDebugUtils.currentLine=2555922;
 //BA.debugLineNum = 2555922;BA.debugLine="If sale1.Length <> product.Length Or sale2.Length";
if (_sale1.length!=_product.length || _sale2.length!=_product.length || _sale3.length!=_product.length) { 
RDebugUtils.currentLine=2555923;
 //BA.debugLineNum = 2555923;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2555926;
 //BA.debugLineNum = 2555926;BA.debugLine="legendPanel.Initialize(\"\")";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .Initialize(ba,"");
RDebugUtils.currentLine=2555927;
 //BA.debugLineNum = 2555927;BA.debugLine="legendPanel.Width = panel.Width";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setWidth(_panel.getWidth());
RDebugUtils.currentLine=2555928;
 //BA.debugLineNum = 2555928;BA.debugLine="legendPanel.Height = 30dip";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setHeight(__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=2555930;
 //BA.debugLineNum = 2555930;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
_legendwidth = (int) (__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()/(double)_legend.length);
RDebugUtils.currentLine=2555931;
 //BA.debugLineNum = 2555931;BA.debugLine="checkBoxes = Array As CheckBox()";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/  = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]{};
RDebugUtils.currentLine=2555932;
 //BA.debugLineNum = 2555932;BA.debugLine="checkedSales = Array As Boolean()";
__ref._checkedsales /*boolean[]*/  = new boolean[]{};
RDebugUtils.currentLine=2555934;
 //BA.debugLineNum = 2555934;BA.debugLine="Dim checkBoxes(legend.Length) As CheckBox";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[_legend.length];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=2555935;
 //BA.debugLineNum = 2555935;BA.debugLine="Dim checkedSales(legend.Length) As Boolean";
_checkedsales = new boolean[_legend.length];
;
RDebugUtils.currentLine=2555936;
 //BA.debugLineNum = 2555936;BA.debugLine="If isFirstInit Then";
if (__ref._isfirstinit /*boolean*/ ) { 
RDebugUtils.currentLine=2555938;
 //BA.debugLineNum = 2555938;BA.debugLine="Dim tempCheckBoxes(legend.Length) As CheckBox";
_tempcheckboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[_legend.length];
{
int d0 = _tempcheckboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_tempcheckboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=2555939;
 //BA.debugLineNum = 2555939;BA.debugLine="checkBoxes = tempCheckBoxes";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/  = _tempcheckboxes;
RDebugUtils.currentLine=2555940;
 //BA.debugLineNum = 2555940;BA.debugLine="Dim tempCheckedSales(legend.Length) As Boolean";
_tempcheckedsales = new boolean[_legend.length];
;
RDebugUtils.currentLine=2555941;
 //BA.debugLineNum = 2555941;BA.debugLine="checkedSales = tempCheckedSales";
__ref._checkedsales /*boolean[]*/  = _tempcheckedsales;
RDebugUtils.currentLine=2555944;
 //BA.debugLineNum = 2555944;BA.debugLine="For i = 0 To legend.Length - 1";
{
final int step34 = 1;
final int limit34 = (int) (_legend.length-1);
_i = (int) (0) ;
for (;_i <= limit34 ;_i = _i + step34 ) {
RDebugUtils.currentLine=2555945;
 //BA.debugLineNum = 2555945;BA.debugLine="Dim chk As CheckBox";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=2555946;
 //BA.debugLineNum = 2555946;BA.debugLine="chk.Initialize(\"chkChange\")";
_chk.Initialize(ba,"chkChange");
RDebugUtils.currentLine=2555947;
 //BA.debugLineNum = 2555947;BA.debugLine="chk.Text = legend(i)";
_chk.setText(BA.ObjectToCharSequence(_legend[_i]));
RDebugUtils.currentLine=2555948;
 //BA.debugLineNum = 2555948;BA.debugLine="chk.TextSize = 10";
_chk.setTextSize((float) (10));
RDebugUtils.currentLine=2555949;
 //BA.debugLineNum = 2555949;BA.debugLine="chk.Typeface = Typeface.MONOSPACE";
_chk.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=2555950;
 //BA.debugLineNum = 2555950;BA.debugLine="chk.TextColor = color(i)";
_chk.setTextColor(__ref._color /*int[]*/ [_i]);
RDebugUtils.currentLine=2555951;
 //BA.debugLineNum = 2555951;BA.debugLine="chk.Tag = i";
_chk.setTag((Object)(_i));
RDebugUtils.currentLine=2555952;
 //BA.debugLineNum = 2555952;BA.debugLine="chk.Checked = True  ' Default state";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=2555953;
 //BA.debugLineNum = 2555953;BA.debugLine="checkedSales(i) = True";
__ref._checkedsales /*boolean[]*/ [_i] = __c.True;
RDebugUtils.currentLine=2555954;
 //BA.debugLineNum = 2555954;BA.debugLine="legendPanel.AddView(chk, (legendWidth * i) + 30";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(_chk.getObject()),(int) ((_legendwidth*_i)+__c.DipToCurrent((int) (30))),__c.DipToCurrent((int) (0)),(int) (_legendwidth-__c.DipToCurrent((int) (30))),__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight());
RDebugUtils.currentLine=2555955;
 //BA.debugLineNum = 2555955;BA.debugLine="checkBoxes(i) = chk";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/ [_i] = _chk;
 }
};
RDebugUtils.currentLine=2555957;
 //BA.debugLineNum = 2555957;BA.debugLine="isFirstInit = False";
__ref._isfirstinit /*boolean*/  = __c.False;
 }else {
RDebugUtils.currentLine=2555960;
 //BA.debugLineNum = 2555960;BA.debugLine="For i = 0 To checkBoxes.Length - 1";
{
final int step49 = 1;
final int limit49 = (int) (__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit49 ;_i = _i + step49 ) {
RDebugUtils.currentLine=2555961;
 //BA.debugLineNum = 2555961;BA.debugLine="checkBoxes(i).Checked = checkedSales(i)";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/ [_i].setChecked(__ref._checkedsales /*boolean[]*/ [_i]);
 }
};
 };
RDebugUtils.currentLine=2555967;
 //BA.debugLineNum = 2555967;BA.debugLine="btnBack.Text = \"Back\"";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setText(BA.ObjectToCharSequence("Back"));
RDebugUtils.currentLine=2555968;
 //BA.debugLineNum = 2555968;BA.debugLine="btnBack.TextSize = 14";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextSize((float) (14));
RDebugUtils.currentLine=2555969;
 //BA.debugLineNum = 2555969;BA.debugLine="btnBack.Typeface = Typeface.MONOSPACE";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=2555970;
 //BA.debugLineNum = 2555970;BA.debugLine="btnBack.TextColor = Colors.White";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextColor(__c.Colors.White);
RDebugUtils.currentLine=2555971;
 //BA.debugLineNum = 2555971;BA.debugLine="Dim cdBack As ColorDrawable";
_cdback = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=2555972;
 //BA.debugLineNum = 2555972;BA.debugLine="cdBack.Initialize2(Colors.RGB(61, 12, 2), 10dip,";
_cdback.Initialize2(__c.Colors.RGB((int) (61),(int) (12),(int) (2)),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (2)),__c.Colors.Black);
RDebugUtils.currentLine=2555973;
 //BA.debugLineNum = 2555973;BA.debugLine="btnBack.Background = cdBack";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setBackground((android.graphics.drawable.Drawable)(_cdback.getObject()));
RDebugUtils.currentLine=2555976;
 //BA.debugLineNum = 2555976;BA.debugLine="btnNext.Text = \"Next\"";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setText(BA.ObjectToCharSequence("Next"));
RDebugUtils.currentLine=2555977;
 //BA.debugLineNum = 2555977;BA.debugLine="btnNext.TextSize = 14";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextSize((float) (14));
RDebugUtils.currentLine=2555978;
 //BA.debugLineNum = 2555978;BA.debugLine="btnNext.Typeface = Typeface.MONOSPACE";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=2555979;
 //BA.debugLineNum = 2555979;BA.debugLine="btnNext.TextColor = Colors.White";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextColor(__c.Colors.White);
RDebugUtils.currentLine=2555980;
 //BA.debugLineNum = 2555980;BA.debugLine="Dim cdNext As ColorDrawable";
_cdnext = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=2555981;
 //BA.debugLineNum = 2555981;BA.debugLine="cdNext.Initialize2(Colors.RGB(185, 46, 52), 10dip";
_cdnext.Initialize2(__c.Colors.RGB((int) (185),(int) (46),(int) (52)),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (2)),__c.Colors.Black);
RDebugUtils.currentLine=2555982;
 //BA.debugLineNum = 2555982;BA.debugLine="btnNext.Background = cdNext";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setBackground((android.graphics.drawable.Drawable)(_cdnext.getObject()));
RDebugUtils.currentLine=2555984;
 //BA.debugLineNum = 2555984;BA.debugLine="DrawGraph(Active, panel, sale1, sale2, sale3, pro";
__ref._drawgraph /*String*/ (null,_active,_panel,_sale1,_sale2,_sale3,_product,_maxsales,_titlestring);
RDebugUtils.currentLine=2555985;
 //BA.debugLineNum = 2555985;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub chkChange_CheckedChange(Checked As Boolean)";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="If Sender Is CheckBox Then";
if (__c.Sender(ba) instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="Dim chk As CheckBox = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper(), (android.widget.CheckBox)(__c.Sender(ba)));
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="Dim index As Int = chk.Tag";
_index = (int)(BA.ObjectToNumber(_chk.getTag()));
RDebugUtils.currentLine=3080197;
 //BA.debugLineNum = 3080197;BA.debugLine="Dim checkedCount As Int = 0";
_checkedcount = (int) (0);
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="For i = 0 To checkedSales.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (__ref._checkedsales /*boolean[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=3080199;
 //BA.debugLineNum = 3080199;BA.debugLine="If checkedSales(i) = True Then checkedCount = c";
if (__ref._checkedsales /*boolean[]*/ [_i]==__c.True) { 
_checkedcount = (int) (_checkedcount+1);};
 }
};
RDebugUtils.currentLine=3080202;
 //BA.debugLineNum = 3080202;BA.debugLine="If Checked = False And checkedCount = 1 Then";
if (_checked==__c.False && _checkedcount==1) { 
RDebugUtils.currentLine=3080203;
 //BA.debugLineNum = 3080203;BA.debugLine="chk.Checked = True";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=3080204;
 //BA.debugLineNum = 3080204;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=3080207;
 //BA.debugLineNum = 3080207;BA.debugLine="checkedSales(index) = Checked";
__ref._checkedsales /*boolean[]*/ [_index] = _checked;
RDebugUtils.currentLine=3080208;
 //BA.debugLineNum = 3080208;BA.debugLine="UpdateGraph ' Call DrawGraph without parameters";
__ref._updategraph /*String*/ (null);
 }else {
RDebugUtils.currentLine=3080210;
 //BA.debugLineNum = 3080210;BA.debugLine="Log(\"Error: Sender is not a CheckBox\")";
__c.LogImpl("63080210","Error: Sender is not a CheckBox",0);
 };
RDebugUtils.currentLine=3080212;
 //BA.debugLineNum = 3080212;BA.debugLine="End Sub";
return "";
}
public String  _updategraph(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "updategraph", false))
	 {return ((String) Debug.delegate(ba, "updategraph", null));}
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Public Sub UpdateGraph";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="DrawGraph(Active1, panel_l, sale_1, sale_2, sale_";
__ref._drawgraph /*String*/ (null,__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/ ,__ref._panel_l /*anywheresoftware.b4a.objects.PanelWrapper*/ ,__ref._sale_1 /*int[]*/ ,__ref._sale_2 /*int[]*/ ,__ref._sale_3 /*int[]*/ ,__ref._product1 /*String[]*/ ,__ref._maxsales1 /*int*/ ,__ref._titlestring1 /*String*/ );
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="Private checkBoxes() As CheckBox";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[(int) (0)];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="Public checkedSales() As Boolean";
_checkedsales = new boolean[(int) (0)];
;
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="Dim color() As Int = Array As Int(Colors.RGB(255,";
_color = new int[]{__c.Colors.RGB((int) (255),(int) (0),(int) (0)),__c.Colors.RGB((int) (200),(int) (20),(int) (20)),__c.Colors.RGB((int) (100),(int) (10),(int) (10))};
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="Dim legendPanel As Panel";
_legendpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="Dim Active1 As Activity";
_active1 = new anywheresoftware.b4a.objects.ActivityWrapper();
RDebugUtils.currentLine=2490374;
 //BA.debugLineNum = 2490374;BA.debugLine="Dim panel_l As Panel";
_panel_l = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="Dim sale_1() As Int";
_sale_1 = new int[(int) (0)];
;
RDebugUtils.currentLine=2490376;
 //BA.debugLineNum = 2490376;BA.debugLine="Dim sale_2() As Int";
_sale_2 = new int[(int) (0)];
;
RDebugUtils.currentLine=2490377;
 //BA.debugLineNum = 2490377;BA.debugLine="Dim sale_3() As Int";
_sale_3 = new int[(int) (0)];
;
RDebugUtils.currentLine=2490378;
 //BA.debugLineNum = 2490378;BA.debugLine="Dim product1() As String";
_product1 = new String[(int) (0)];
java.util.Arrays.fill(_product1,"");
RDebugUtils.currentLine=2490379;
 //BA.debugLineNum = 2490379;BA.debugLine="Dim legend1() As String";
_legend1 = new String[(int) (0)];
java.util.Arrays.fill(_legend1,"");
RDebugUtils.currentLine=2490380;
 //BA.debugLineNum = 2490380;BA.debugLine="Dim maxSales1 As Int = 0";
_maxsales1 = (int) (0);
RDebugUtils.currentLine=2490381;
 //BA.debugLineNum = 2490381;BA.debugLine="Dim titleString1 As String = \"\"";
_titlestring1 = "";
RDebugUtils.currentLine=2490382;
 //BA.debugLineNum = 2490382;BA.debugLine="Dim comId1() As Int";
_comid1 = new int[(int) (0)];
;
RDebugUtils.currentLine=2490383;
 //BA.debugLineNum = 2490383;BA.debugLine="Private currentPage As Int = 1";
_currentpage = (int) (1);
RDebugUtils.currentLine=2490384;
 //BA.debugLineNum = 2490384;BA.debugLine="Private itemsPerPage As Int = 5";
_itemsperpage = (int) (5);
RDebugUtils.currentLine=2490385;
 //BA.debugLineNum = 2490385;BA.debugLine="Public btnNext As Button";
_btnnext = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=2490386;
 //BA.debugLineNum = 2490386;BA.debugLine="Public btnBack As Button";
_btnback = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=2490387;
 //BA.debugLineNum = 2490387;BA.debugLine="Dim layout As String = \"\"";
_layout = "";
RDebugUtils.currentLine=2490388;
 //BA.debugLineNum = 2490388;BA.debugLine="Private isFirstInit As Boolean = True";
_isfirstinit = __c.True;
RDebugUtils.currentLine=2490389;
 //BA.debugLineNum = 2490389;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Public Sub DrawGraph(Active As Activity, panel As";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="Try";
try {RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="panel.Invalidate";
_panel.Invalidate();
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="panel.RemoveAllViews";
_panel.RemoveAllViews();
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="panel.Height = 450dip";
_panel.setHeight(__c.DipToCurrent((int) (450)));
RDebugUtils.currentLine=2621445;
 //BA.debugLineNum = 2621445;BA.debugLine="If panel.Width = 0 Then";
if (_panel.getWidth()==0) { 
RDebugUtils.currentLine=2621446;
 //BA.debugLineNum = 2621446;BA.debugLine="panel.Width = 800dip";
_panel.setWidth(__c.DipToCurrent((int) (800)));
 };
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="panel.AddView(legendPanel, 0, 0, panel.Width, 30";
_panel.AddView((android.view.View)(__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()),(int) (0),(int) (0),_panel.getWidth(),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=2621451;
 //BA.debugLineNum = 2621451;BA.debugLine="Dim activityPanel As Panel";
_activitypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2621452;
 //BA.debugLineNum = 2621452;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
_activitypanel.Initialize(ba,"activityPanel");
RDebugUtils.currentLine=2621454;
 //BA.debugLineNum = 2621454;BA.debugLine="activityPanel.Width = 80%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (80),ba));
RDebugUtils.currentLine=2621455;
 //BA.debugLineNum = 2621455;BA.debugLine="If Active.Width > 800 Then";
if (_active.getWidth()>800) { 
RDebugUtils.currentLine=2621456;
 //BA.debugLineNum = 2621456;BA.debugLine="activityPanel.Width = 55%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (55),ba));
 };
RDebugUtils.currentLine=2621458;
 //BA.debugLineNum = 2621458;BA.debugLine="activityPanel.Height = 250dip";
_activitypanel.setHeight(__c.DipToCurrent((int) (250)));
RDebugUtils.currentLine=2621459;
 //BA.debugLineNum = 2621459;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211,";
_activitypanel.setColor(__c.Colors.ARGB((int) (70),(int) (211),(int) (211),(int) (211)));
RDebugUtils.currentLine=2621461;
 //BA.debugLineNum = 2621461;BA.debugLine="Dim alignLeftCenter As Int = (Active.Width - act";
_alignleftcenter = (int) ((_active.getWidth()-_activitypanel.getWidth())/(double)2);
RDebugUtils.currentLine=2621462;
 //BA.debugLineNum = 2621462;BA.debugLine="Dim alignTopCenter As Int = (panel.Height - acti";
_aligntopcenter = (int) ((_panel.getHeight()-_activitypanel.getHeight())/(double)2-__c.DipToCurrent((int) (20)));
RDebugUtils.currentLine=2621464;
 //BA.debugLineNum = 2621464;BA.debugLine="Dim Title As Label";
_title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2621465;
 //BA.debugLineNum = 2621465;BA.debugLine="Title.Initialize(\"\")";
_title.Initialize(ba,"");
RDebugUtils.currentLine=2621466;
 //BA.debugLineNum = 2621466;BA.debugLine="Title.Text = TitleString";
_title.setText(BA.ObjectToCharSequence(_titlestring));
RDebugUtils.currentLine=2621467;
 //BA.debugLineNum = 2621467;BA.debugLine="Title.TextSize = 20";
_title.setTextSize((float) (20));
RDebugUtils.currentLine=2621468;
 //BA.debugLineNum = 2621468;BA.debugLine="Title.Typeface = Typeface.MONOSPACE";
_title.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=2621469;
 //BA.debugLineNum = 2621469;BA.debugLine="Title.Gravity = Gravity.CENTER";
_title.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=2621470;
 //BA.debugLineNum = 2621470;BA.debugLine="Title.TextColor = Colors.Black";
_title.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=2621471;
 //BA.debugLineNum = 2621471;BA.debugLine="panel.AddView(Title, 0, alignTopCenter / 2, pane";
_panel.AddView((android.view.View)(_title.getObject()),(int) (0),(int) (_aligntopcenter/(double)2),_panel.getWidth(),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=2621473;
 //BA.debugLineNum = 2621473;BA.debugLine="panel.AddView(activityPanel, alignLeftCenter, al";
_panel.AddView((android.view.View)(_activitypanel.getObject()),_alignleftcenter,_aligntopcenter,_activitypanel.getWidth(),_activitypanel.getHeight());
RDebugUtils.currentLine=2621475;
 //BA.debugLineNum = 2621475;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=2621476;
 //BA.debugLineNum = 2621476;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(_activitypanel.getObject()));
RDebugUtils.currentLine=2621478;
 //BA.debugLineNum = 2621478;BA.debugLine="Dim maxSale As Int = maxSales * 1.2";
_maxsale = (int) (_maxsales*1.2);
RDebugUtils.currentLine=2621479;
 //BA.debugLineNum = 2621479;BA.debugLine="Dim cv As Canvas";
_cv = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=2621480;
 //BA.debugLineNum = 2621480;BA.debugLine="cv.Initialize(panel)";
_cv.Initialize((android.view.View)(_panel.getObject()));
RDebugUtils.currentLine=2621482;
 //BA.debugLineNum = 2621482;BA.debugLine="Dim totalProducts As Int = sale1.Length";
_totalproducts = _sale1.length;
RDebugUtils.currentLine=2621483;
 //BA.debugLineNum = 2621483;BA.debugLine="Dim startIndex As Int = (currentPage - 1) * item";
_startindex = (int) ((__ref._currentpage /*int*/ -1)*__ref._itemsperpage /*int*/ );
RDebugUtils.currentLine=2621484;
 //BA.debugLineNum = 2621484;BA.debugLine="Dim endIndex As Int = Min(startIndex + itemsPerP";
_endindex = (int) (__c.Min(_startindex+__ref._itemsperpage /*int*/ -1,_totalproducts-1));
RDebugUtils.currentLine=2621485;
 //BA.debugLineNum = 2621485;BA.debugLine="Dim barsPerProduct As Int = 3";
_barsperproduct = (int) (3);
RDebugUtils.currentLine=2621486;
 //BA.debugLineNum = 2621486;BA.debugLine="Dim totalBars As Int = (endIndex - startIndex +";
_totalbars = (int) ((_endindex-_startindex+1)*_barsperproduct);
RDebugUtils.currentLine=2621487;
 //BA.debugLineNum = 2621487;BA.debugLine="Dim gap As Int = 5dip";
_gap = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=2621488;
 //BA.debugLineNum = 2621488;BA.debugLine="Dim productGap As Int = 0dip";
_productgap = __c.DipToCurrent((int) (0));
RDebugUtils.currentLine=2621489;
 //BA.debugLineNum = 2621489;BA.debugLine="Dim padding As Int = 10dip";
_padding = __c.DipToCurrent((int) (10));
RDebugUtils.currentLine=2621491;
 //BA.debugLineNum = 2621491;BA.debugLine="Dim availableWidth As Int = activityPanel.Width";
_availablewidth = (int) (_activitypanel.getWidth()-(_padding*2)-(((_endindex-_startindex+1)-1)*_productgap)-((_totalbars-(_endindex-_startindex+1))*_gap));
RDebugUtils.currentLine=2621492;
 //BA.debugLineNum = 2621492;BA.debugLine="Dim barWidth As Int = availableWidth / totalBars";
_barwidth = (int) (_availablewidth/(double)_totalbars);
RDebugUtils.currentLine=2621493;
 //BA.debugLineNum = 2621493;BA.debugLine="Dim xStart As Int = padding";
_xstart = _padding;
RDebugUtils.currentLine=2621495;
 //BA.debugLineNum = 2621495;BA.debugLine="For i = startIndex To endIndex";
{
final int step44 = 1;
final int limit44 = _endindex;
_i = _startindex ;
for (;_i <= limit44 ;_i = _i + step44 ) {
RDebugUtils.currentLine=2621496;
 //BA.debugLineNum = 2621496;BA.debugLine="Dim xPos As Int = xStart + (i - startIndex) * (";
_xpos = (int) (_xstart+(_i-_startindex)*(_barsperproduct*(_barwidth+_gap)+_productgap));
RDebugUtils.currentLine=2621497;
 //BA.debugLineNum = 2621497;BA.debugLine="Dim saleValues() As Int = Array As Int(sale1(i)";
_salevalues = new int[]{_sale1[_i],_sale2[_i],_sale3[_i]};
RDebugUtils.currentLine=2621498;
 //BA.debugLineNum = 2621498;BA.debugLine="Dim indexOffset As Int = 0";
_indexoffset = (int) (0);
RDebugUtils.currentLine=2621500;
 //BA.debugLineNum = 2621500;BA.debugLine="For j = 0 To barsPerProduct - 1";
{
final int step48 = 1;
final int limit48 = (int) (_barsperproduct-1);
_j = (int) (0) ;
for (;_j <= limit48 ;_j = _j + step48 ) {
RDebugUtils.currentLine=2621501;
 //BA.debugLineNum = 2621501;BA.debugLine="If j < checkedSales.Length And checkedSales(j)";
if (_j<__ref._checkedsales /*boolean[]*/ .length && __ref._checkedsales /*boolean[]*/ [_j]) { 
RDebugUtils.currentLine=2621502;
 //BA.debugLineNum = 2621502;BA.debugLine="Dim sale As Int = saleValues(j)";
_sale = _salevalues[_j];
RDebugUtils.currentLine=2621503;
 //BA.debugLineNum = 2621503;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * (ac";
_barheight = (int) ((_sale/(double)_maxsale)*(_activitypanel.getHeight()));
RDebugUtils.currentLine=2621504;
 //BA.debugLineNum = 2621504;BA.debugLine="Dim xBar As Int = xPos + indexOffset * barWid";
_xbar = (int) (_xpos+_indexoffset*_barwidth);
RDebugUtils.currentLine=2621506;
 //BA.debugLineNum = 2621506;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=2621507;
 //BA.debugLineNum = 2621507;BA.debugLine="r.Initialize(xBar, activityPanel.Height - bar";
_r.Initialize(_xbar,(int) (_activitypanel.getHeight()-_barheight),(int) (_xbar+_barwidth),_activitypanel.getHeight());
RDebugUtils.currentLine=2621508;
 //BA.debugLineNum = 2621508;BA.debugLine="graphCanvas.DrawRect(r, color(j), True, 2dip)";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),__ref._color /*int[]*/ [_j],__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=2621510;
 //BA.debugLineNum = 2621510;BA.debugLine="Dim fontSize As Int = 8";
_fontsize = (int) (8);
RDebugUtils.currentLine=2621511;
 //BA.debugLineNum = 2621511;BA.debugLine="If Active.Width > 800 Then";
if (_active.getWidth()>800) { 
RDebugUtils.currentLine=2621512;
 //BA.debugLineNum = 2621512;BA.debugLine="fontSize = 10";
_fontsize = (int) (10);
 };
RDebugUtils.currentLine=2621514;
 //BA.debugLineNum = 2621514;BA.debugLine="graphCanvas.DrawText(FormatNumberWithSuffix(s";
_graphcanvas.DrawText(ba,__ref._formatnumberwithsuffix /*String*/ (null,_sale),(float) (_xbar+(_barwidth/(double)2)),(float) (_activitypanel.getHeight()-_barheight-__c.DipToCurrent((int) (5))),__c.Typeface.MONOSPACE,(float) (_fontsize),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
RDebugUtils.currentLine=2621515;
 //BA.debugLineNum = 2621515;BA.debugLine="indexOffset = indexOffset + 1";
_indexoffset = (int) (_indexoffset+1);
 };
 }
};
RDebugUtils.currentLine=2621519;
 //BA.debugLineNum = 2621519;BA.debugLine="Dim productLabel As Label";
_productlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2621520;
 //BA.debugLineNum = 2621520;BA.debugLine="productLabel.Initialize(\"productLabel\")";
_productlabel.Initialize(ba,"productLabel");
RDebugUtils.currentLine=2621521;
 //BA.debugLineNum = 2621521;BA.debugLine="productLabel.Text = product(i)";
_productlabel.setText(BA.ObjectToCharSequence(_product[_i]));
RDebugUtils.currentLine=2621522;
 //BA.debugLineNum = 2621522;BA.debugLine="productLabel.Typeface = Typeface.MONOSPACE";
_productlabel.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=2621523;
 //BA.debugLineNum = 2621523;BA.debugLine="productLabel.TextSize = 12";
_productlabel.setTextSize((float) (12));
RDebugUtils.currentLine=2621524;
 //BA.debugLineNum = 2621524;BA.debugLine="productLabel.Tag = comId1(i)";
_productlabel.setTag((Object)(__ref._comid1 /*int[]*/ [_i]));
RDebugUtils.currentLine=2621525;
 //BA.debugLineNum = 2621525;BA.debugLine="productLabel.TextColor = Colors.Black";
_productlabel.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=2621526;
 //BA.debugLineNum = 2621526;BA.debugLine="productLabel.Gravity = Gravity.CENTER";
_productlabel.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=2621527;
 //BA.debugLineNum = 2621527;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
_productlabely = (int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (10)));
RDebugUtils.currentLine=2621528;
 //BA.debugLineNum = 2621528;BA.debugLine="Dim productLabelX As Int = alignLeftCenter";
_productlabelx = _alignleftcenter;
RDebugUtils.currentLine=2621529;
 //BA.debugLineNum = 2621529;BA.debugLine="panel.AddView(productLabel, xPos + productLabel";
_panel.AddView((android.view.View)(_productlabel.getObject()),(int) (_xpos+_productlabelx),_productlabely,__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (30)));
 }
};
RDebugUtils.currentLine=2621532;
 //BA.debugLineNum = 2621532;BA.debugLine="Dim numLabels As Int = 10";
_numlabels = (int) (10);
RDebugUtils.currentLine=2621533;
 //BA.debugLineNum = 2621533;BA.debugLine="For i = 0 To numLabels";
{
final int step77 = 1;
final int limit77 = _numlabels;
_i = (int) (0) ;
for (;_i <= limit77 ;_i = _i + step77 ) {
RDebugUtils.currentLine=2621534;
 //BA.debugLineNum = 2621534;BA.debugLine="Dim labelValue As Int = Round((maxSale / numLab";
_labelvalue = (int) (__c.Round((_maxsale/(double)_numlabels)*_i));
RDebugUtils.currentLine=2621535;
 //BA.debugLineNum = 2621535;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - (";
_labelypos = (int) (_activitypanel.getHeight()-((_labelvalue/(double)_maxsale)*_activitypanel.getHeight()));
RDebugUtils.currentLine=2621537;
 //BA.debugLineNum = 2621537;BA.debugLine="Dim yAxisLabel As Label";
_yaxislabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2621538;
 //BA.debugLineNum = 2621538;BA.debugLine="yAxisLabel.Initialize(\"\")";
_yaxislabel.Initialize(ba,"");
RDebugUtils.currentLine=2621539;
 //BA.debugLineNum = 2621539;BA.debugLine="yAxisLabel.Text = FormatNumberWithLabel(labelVa";
_yaxislabel.setText(BA.ObjectToCharSequence(__ref._formatnumberwithlabel /*String*/ (null,_labelvalue)));
RDebugUtils.currentLine=2621540;
 //BA.debugLineNum = 2621540;BA.debugLine="yAxisLabel.TextSize = 10";
_yaxislabel.setTextSize((float) (10));
RDebugUtils.currentLine=2621541;
 //BA.debugLineNum = 2621541;BA.debugLine="yAxisLabel.Typeface = Typeface.MONOSPACE";
_yaxislabel.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=2621542;
 //BA.debugLineNum = 2621542;BA.debugLine="yAxisLabel.TextColor = Colors.Black";
_yaxislabel.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=2621543;
 //BA.debugLineNum = 2621543;BA.debugLine="yAxisLabel.Gravity = Gravity.RIGHT";
_yaxislabel.setGravity(__c.Gravity.RIGHT);
RDebugUtils.currentLine=2621545;
 //BA.debugLineNum = 2621545;BA.debugLine="panel.AddView(yAxisLabel, alignLeftCenter - 40d";
_panel.AddView((android.view.View)(_yaxislabel.getObject()),(int) (_alignleftcenter-__c.DipToCurrent((int) (40))),(int) (_labelypos+_aligntopcenter-__c.DipToCurrent((int) (5))),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (15)));
 }
};
RDebugUtils.currentLine=2621547;
 //BA.debugLineNum = 2621547;BA.debugLine="btnBack.Enabled = currentPage > 1";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setEnabled(__ref._currentpage /*int*/ >1);
RDebugUtils.currentLine=2621548;
 //BA.debugLineNum = 2621548;BA.debugLine="btnNext.Enabled = (currentPage * itemsPerPage) <";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setEnabled((__ref._currentpage /*int*/ *__ref._itemsperpage /*int*/ )<_sale1.length);
RDebugUtils.currentLine=2621550;
 //BA.debugLineNum = 2621550;BA.debugLine="panel.AddView(btnBack, alignLeftCenter, activity";
_panel.AddView((android.view.View)(__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .getObject()),_alignleftcenter,(int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (50))),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
RDebugUtils.currentLine=2621551;
 //BA.debugLineNum = 2621551;BA.debugLine="panel.AddView(btnNext, activityPanel.Width";
_panel.AddView((android.view.View)(__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .getObject()),(int) (_activitypanel.getWidth()-_alignleftcenter),(int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (50))),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 } 
       catch (Exception e94) {
			ba.setLastException(e94);RDebugUtils.currentLine=2621555;
 //BA.debugLineNum = 2621555;BA.debugLine="Log(LastException)";
__c.LogImpl("62621555",BA.ObjectToString(__c.LastException(ba)),0);
 };
RDebugUtils.currentLine=2621557;
 //BA.debugLineNum = 2621557;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithsuffix(b4a.example.bargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithsuffix", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithsuffix", new Object[] {_number}));}
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
if (true) return __c.NumberFormat(_number/(double)1000000,(int) (1),(int) (1))+"M";
 }else 
{RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
if (true) return __c.NumberFormat(_number/(double)1000,(int) (1),(int) (1))+"k";
 }else {
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="Return NumberFormat(number, 1, 0)";
if (true) return __c.NumberFormat(_number,(int) (1),(int) (0));
 }}
;
RDebugUtils.currentLine=2949128;
 //BA.debugLineNum = 2949128;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithlabel(b4a.example.bargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithlabel", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithlabel", new Object[] {_number}));}
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000000))+"M";
 }else 
{RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="Return Floor(number / 1000) & \"k\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000))+"k";
 }else {
RDebugUtils.currentLine=3014662;
 //BA.debugLineNum = 3014662;BA.debugLine="Return number";
if (true) return BA.NumberToString(_number);
 }}
;
RDebugUtils.currentLine=3014664;
 //BA.debugLineNum = 3014664;BA.debugLine="End Sub";
return "";
}
public int  _getcurrentpage(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "getcurrentpage", false))
	 {return ((Integer) Debug.delegate(ba, "getcurrentpage", null));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Public Sub GetCurrentPage As Int";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="Return currentPage";
if (true) return __ref._currentpage /*int*/ ;
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="End Sub";
return 0;
}
public String  _productlabel_click(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "productlabel_click", false))
	 {return ((String) Debug.delegate(ba, "productlabel_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _clickedlabel = null;
int _selectedcompany = 0;
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub productLabel_Click";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Dim clickedLabel As Label = Sender";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(__c.Sender(ba)));
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="Dim selectedCompany As Int = clickedLabel.Tag";
_selectedcompany = (int)(BA.ObjectToNumber(_clickedlabel.getTag()));
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="Log(\"Selected Company ID: \" & selectedCompany)";
__c.LogImpl("62883587","Selected Company ID: "+BA.NumberToString(_selectedcompany),0);
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="Starter.company_selected = selectedCompany";
_starter._company_selected /*String*/  = BA.NumberToString(_selectedcompany);
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="StartActivity(layout)";
__c.StartActivity(ba,(Object)(__ref._layout /*String*/ ));
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="Active1.Finish";
__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/ .Finish();
RDebugUtils.currentLine=2883591;
 //BA.debugLineNum = 2883591;BA.debugLine="End Sub";
return "";
}
public String  _setcurrentpage(b4a.example.bargraph __ref,int _page) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "setcurrentpage", false))
	 {return ((String) Debug.delegate(ba, "setcurrentpage", new Object[] {_page}));}
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Public Sub SetCurrentPage(page As Int)";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="currentPage = page";
__ref._currentpage /*int*/  = _page;
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="UpdateGraph";
__ref._updategraph /*String*/ (null);
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="End Sub";
return "";
}
}