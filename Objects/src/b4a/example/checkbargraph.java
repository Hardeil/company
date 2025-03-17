package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class checkbargraph extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.checkbargraph");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.checkbargraph.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.ActivityWrapper _active = null;
public anywheresoftware.b4a.objects.PanelWrapper _barpanel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nxtbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _backbtn = null;
public int[] _sales = null;
public int[] _sales1 = null;
public int[] _sales2 = null;
public String[] _comname = null;
public int _maxsale = 0;
public b4a.example.main _main = null;
public b4a.example.branch _branch = null;
public b4a.example.device _device = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public String  _chkchange_checkedchange(b4a.example.checkbargraph __ref,boolean _checked) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "chkchange_checkedchange", false))
	 {return ((String) Debug.delegate(ba, "chkchange_checkedchange", new Object[] {_checked}));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
int _index = 0;
int _checkedcount = 0;
int _i = 0;
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub chkChange_CheckedChange(Checked As Boolean)";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="If Sender Is CheckBox Then";
if (__c.Sender(ba) instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="Dim chk As CheckBox = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper(), (android.widget.CheckBox)(__c.Sender(ba)));
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="Dim index As Int = chk.Tag";
_index = (int)(BA.ObjectToNumber(_chk.getTag()));
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="Dim checkedCount As Int = 0";
_checkedcount = (int) (0);
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="For i = 0 To checkedSales.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (__ref._checkedsales /*boolean[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=3801095;
 //BA.debugLineNum = 3801095;BA.debugLine="If checkedSales(i) = True Then checkedCount = c";
if (__ref._checkedsales /*boolean[]*/ [_i]==__c.True) { 
_checkedcount = (int) (_checkedcount+1);};
 }
};
RDebugUtils.currentLine=3801098;
 //BA.debugLineNum = 3801098;BA.debugLine="If Checked = False And checkedCount = 1 Then";
if (_checked==__c.False && _checkedcount==1) { 
RDebugUtils.currentLine=3801099;
 //BA.debugLineNum = 3801099;BA.debugLine="chk.Checked = True";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=3801100;
 //BA.debugLineNum = 3801100;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=3801103;
 //BA.debugLineNum = 3801103;BA.debugLine="checkedSales(index) = Checked";
__ref._checkedsales /*boolean[]*/ [_index] = _checked;
RDebugUtils.currentLine=3801104;
 //BA.debugLineNum = 3801104;BA.debugLine="DrawGraph ' Call DrawGraph without parameters";
__ref._drawgraph /*String*/ (null);
 }else {
RDebugUtils.currentLine=3801106;
 //BA.debugLineNum = 3801106;BA.debugLine="Log(\"Error: Sender is not a CheckBox\")";
__c.LogImpl("23801106","Error: Sender is not a CheckBox",0);
 };
RDebugUtils.currentLine=3801108;
 //BA.debugLineNum = 3801108;BA.debugLine="End Sub";
return "";
}
public String  _drawgraph(b4a.example.checkbargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "drawgraph", false))
	 {return ((String) Debug.delegate(ba, "drawgraph", null));}
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub DrawGraph()";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="DrawGraph1(Active, barPanel, nxtBtn, backBtn, sal";
__ref._drawgraph1 /*String*/ (null,__ref._active /*anywheresoftware.b4a.objects.ActivityWrapper*/ ,__ref._barpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ ,__ref._nxtbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/ ,__ref._backbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/ ,__ref._sales /*int[]*/ ,__ref._sales1 /*int[]*/ ,__ref._sales2 /*int[]*/ ,__ref._comname /*String[]*/ ,__ref._maxsale /*int*/ );
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.checkbargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="Private checkBoxes() As CheckBox";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[(int) (0)];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="Private checkedSales() As Boolean";
_checkedsales = new boolean[(int) (0)];
;
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="Private Active As Activity";
_active = new anywheresoftware.b4a.objects.ActivityWrapper();
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="Private barPanel As Panel";
_barpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3604487;
 //BA.debugLineNum = 3604487;BA.debugLine="Private nxtBtn As Button";
_nxtbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=3604488;
 //BA.debugLineNum = 3604488;BA.debugLine="Private backBtn As Button";
_backbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=3604489;
 //BA.debugLineNum = 3604489;BA.debugLine="Private sales() As Int";
_sales = new int[(int) (0)];
;
RDebugUtils.currentLine=3604490;
 //BA.debugLineNum = 3604490;BA.debugLine="Private sales1() As Int";
_sales1 = new int[(int) (0)];
;
RDebugUtils.currentLine=3604491;
 //BA.debugLineNum = 3604491;BA.debugLine="Private sales2() As Int";
_sales2 = new int[(int) (0)];
;
RDebugUtils.currentLine=3604492;
 //BA.debugLineNum = 3604492;BA.debugLine="Private comName() As String";
_comname = new String[(int) (0)];
java.util.Arrays.fill(_comname,"");
RDebugUtils.currentLine=3604493;
 //BA.debugLineNum = 3604493;BA.debugLine="Private maxSale As Int";
_maxsale = 0;
RDebugUtils.currentLine=3604494;
 //BA.debugLineNum = 3604494;BA.debugLine="End Sub";
return "";
}
public String  _drawgraph1(b4a.example.checkbargraph __ref,anywheresoftware.b4a.objects.ActivityWrapper _active1,anywheresoftware.b4a.objects.PanelWrapper _barpanel1,anywheresoftware.b4a.objects.ButtonWrapper _nextbtn,anywheresoftware.b4a.objects.ButtonWrapper _bckbtn,int[] _sales_1,int[] _sales_2,int[] _sales_3,String[] _comname1,int _maxsale1) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "drawgraph1", false))
	 {return ((String) Debug.delegate(ba, "drawgraph1", new Object[] {_active1,_barpanel1,_nextbtn,_bckbtn,_sales_1,_sales_2,_sales_3,_comname1,_maxsale1}));}
int[] _color = null;
anywheresoftware.b4a.objects.PanelWrapper _activitypanel = null;
int _alignleftcenter = 0;
int _aligntopcenter = 0;
int _btnleft = 0;
anywheresoftware.b4a.objects.LabelWrapper _titlelabel = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _graphcanvas = null;
int _totalproducts = 0;
int _barsperproduct = 0;
int _gap = 0;
int _productgap = 0;
int _padding = 0;
int _numlabels = 0;
int _labelstep = 0;
int _labelheightstep = 0;
int _i = 0;
int _lbly = 0;
int _lblvalue = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblleft = null;
int _checkedcount = 0;
int _availablewidth = 0;
int _barwidth = 0;
int _xstart = 0;
int _xpos = 0;
int[] _salevalues = null;
int _indexoffset = 0;
int _j = 0;
int _sale = 0;
int _barheight = 0;
int _xbar = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblsale = null;
int _lblsaleleft = 0;
int _lblsaletop = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r = null;
anywheresoftware.b4a.objects.LabelWrapper _lblcompany = null;
int _totalbarwidth = 0;
int _lblcompanywidth = 0;
int _lblcompanyleft = 0;
int _lblcompanytop = 0;
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Public Sub DrawGraph1(Active1 As Activity,barPanel";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="barPanel1.Initialize(\"\")";
_barpanel1.Initialize(ba,"");
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="barPanel1.RemoveAllViews ' Clear previous drawing";
_barpanel1.RemoveAllViews();
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="Dim Color() As Int = Array As Int(Colors.Red, Col";
_color = new int[]{__c.Colors.Red,__c.Colors.Green,__c.Colors.Blue};
RDebugUtils.currentLine=3866629;
 //BA.debugLineNum = 3866629;BA.debugLine="Dim activityPanel As Panel";
_activitypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3866630;
 //BA.debugLineNum = 3866630;BA.debugLine="activityPanel.Initialize(\"\")";
_activitypanel.Initialize(ba,"");
RDebugUtils.currentLine=3866631;
 //BA.debugLineNum = 3866631;BA.debugLine="activityPanel.Width = 75%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (75),ba));
RDebugUtils.currentLine=3866632;
 //BA.debugLineNum = 3866632;BA.debugLine="If Active1.Width >800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=3866633;
 //BA.debugLineNum = 3866633;BA.debugLine="activityPanel.Width = 70%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (70),ba));
 };
RDebugUtils.currentLine=3866635;
 //BA.debugLineNum = 3866635;BA.debugLine="activityPanel.Height = 250dip";
_activitypanel.setHeight(__c.DipToCurrent((int) (250)));
RDebugUtils.currentLine=3866636;
 //BA.debugLineNum = 3866636;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
_activitypanel.setColor(__c.Colors.ARGB((int) (70),(int) (211),(int) (211),(int) (211)));
RDebugUtils.currentLine=3866638;
 //BA.debugLineNum = 3866638;BA.debugLine="Dim alignLeftCenter As Int = 0 ' Ensure left alig";
_alignleftcenter = (int) (0);
RDebugUtils.currentLine=3866639;
 //BA.debugLineNum = 3866639;BA.debugLine="If checkedSales.Length > 1 Then";
if (__ref._checkedsales /*boolean[]*/ .length>1) { 
RDebugUtils.currentLine=3866640;
 //BA.debugLineNum = 3866640;BA.debugLine="alignLeftCenter = (barPanel1.Width - activityPan";
_alignleftcenter = (int) ((_barpanel1.getWidth()-_activitypanel.getWidth())/(double)2);
 };
RDebugUtils.currentLine=3866643;
 //BA.debugLineNum = 3866643;BA.debugLine="Dim alignTopCenter As Int = (barPanel1.Height - a";
_aligntopcenter = (int) ((_barpanel1.getHeight()-_activitypanel.getHeight())/(double)2);
RDebugUtils.currentLine=3866644;
 //BA.debugLineNum = 3866644;BA.debugLine="Dim btnLeft As Int = 0";
_btnleft = (int) (0);
RDebugUtils.currentLine=3866646;
 //BA.debugLineNum = 3866646;BA.debugLine="Dim titleLabel As Label";
_titlelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3866647;
 //BA.debugLineNum = 3866647;BA.debugLine="titleLabel.Initialize(\"\")";
_titlelabel.Initialize(ba,"");
RDebugUtils.currentLine=3866648;
 //BA.debugLineNum = 3866648;BA.debugLine="titleLabel.Text=\"Total Sales For Each Company\"";
_titlelabel.setText(BA.ObjectToCharSequence("Total Sales For Each Company"));
RDebugUtils.currentLine=3866649;
 //BA.debugLineNum = 3866649;BA.debugLine="titleLabel.Gravity = Gravity.CENTER";
_titlelabel.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=3866650;
 //BA.debugLineNum = 3866650;BA.debugLine="titleLabel.Typeface = Typeface.MONOSPACE";
_titlelabel.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3866651;
 //BA.debugLineNum = 3866651;BA.debugLine="titleLabel.TextSize = 20";
_titlelabel.setTextSize((float) (20));
RDebugUtils.currentLine=3866652;
 //BA.debugLineNum = 3866652;BA.debugLine="titleLabel.TextColor = Colors.Black";
_titlelabel.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=3866653;
 //BA.debugLineNum = 3866653;BA.debugLine="barPanel1.AddView(titleLabel,0,alignTopCenter - 4";
_barpanel1.AddView((android.view.View)(_titlelabel.getObject()),(int) (0),(int) (_aligntopcenter-__c.DipToCurrent((int) (40))),_barpanel1.getWidth(),__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=3866654;
 //BA.debugLineNum = 3866654;BA.debugLine="barPanel1.AddView(activityPanel, alignLeftCenter,";
_barpanel1.AddView((android.view.View)(_activitypanel.getObject()),_alignleftcenter,_aligntopcenter,_activitypanel.getWidth(),_activitypanel.getHeight());
RDebugUtils.currentLine=3866656;
 //BA.debugLineNum = 3866656;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=3866657;
 //BA.debugLineNum = 3866657;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(_activitypanel.getObject()));
RDebugUtils.currentLine=3866659;
 //BA.debugLineNum = 3866659;BA.debugLine="maxSale1 = maxSale1 * 1.2";
_maxsale1 = (int) (_maxsale1*1.2);
RDebugUtils.currentLine=3866660;
 //BA.debugLineNum = 3866660;BA.debugLine="Dim totalProducts As Int = sales_1.Length";
_totalproducts = _sales_1.length;
RDebugUtils.currentLine=3866661;
 //BA.debugLineNum = 3866661;BA.debugLine="Dim barsPerProduct As Int = 3";
_barsperproduct = (int) (3);
RDebugUtils.currentLine=3866662;
 //BA.debugLineNum = 3866662;BA.debugLine="Dim gap As Int = 15dip";
_gap = __c.DipToCurrent((int) (15));
RDebugUtils.currentLine=3866663;
 //BA.debugLineNum = 3866663;BA.debugLine="Dim productGap As Int = 5dip";
_productgap = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=3866664;
 //BA.debugLineNum = 3866664;BA.debugLine="Dim padding As Int = 0 ' Remove left padding when";
_padding = (int) (0);
RDebugUtils.currentLine=3866667;
 //BA.debugLineNum = 3866667;BA.debugLine="Dim numLabels As Int = 10";
_numlabels = (int) (10);
RDebugUtils.currentLine=3866668;
 //BA.debugLineNum = 3866668;BA.debugLine="Dim labelStep As Int = maxSale1 / numLabels";
_labelstep = (int) (_maxsale1/(double)_numlabels);
RDebugUtils.currentLine=3866669;
 //BA.debugLineNum = 3866669;BA.debugLine="Dim labelHeightStep As Int = activityPanel.Height";
_labelheightstep = (int) (_activitypanel.getHeight()/(double)_numlabels);
RDebugUtils.currentLine=3866671;
 //BA.debugLineNum = 3866671;BA.debugLine="For i = 0 To numLabels";
{
final int step38 = 1;
final int limit38 = _numlabels;
_i = (int) (0) ;
for (;_i <= limit38 ;_i = _i + step38 ) {
RDebugUtils.currentLine=3866672;
 //BA.debugLineNum = 3866672;BA.debugLine="Dim lblY As Int = activityPanel.Height - (i * la";
_lbly = (int) (_activitypanel.getHeight()-(_i*_labelheightstep)+_aligntopcenter-__c.DipToCurrent((int) (10)));
RDebugUtils.currentLine=3866673;
 //BA.debugLineNum = 3866673;BA.debugLine="Dim lblValue As Int = i * labelStep";
_lblvalue = (int) (_i*_labelstep);
RDebugUtils.currentLine=3866675;
 //BA.debugLineNum = 3866675;BA.debugLine="Dim lblLeft As Label";
_lblleft = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3866676;
 //BA.debugLineNum = 3866676;BA.debugLine="lblLeft.Initialize(\"\")";
_lblleft.Initialize(ba,"");
RDebugUtils.currentLine=3866677;
 //BA.debugLineNum = 3866677;BA.debugLine="lblLeft.Text = FormatNumberWithLabel(lblValue)";
_lblleft.setText(BA.ObjectToCharSequence(__ref._formatnumberwithlabel /*String*/ (null,_lblvalue)));
RDebugUtils.currentLine=3866678;
 //BA.debugLineNum = 3866678;BA.debugLine="lblLeft.TextColor = Colors.Black";
_lblleft.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=3866679;
 //BA.debugLineNum = 3866679;BA.debugLine="lblLeft.Gravity = Gravity.RIGHT";
_lblleft.setGravity(__c.Gravity.RIGHT);
RDebugUtils.currentLine=3866680;
 //BA.debugLineNum = 3866680;BA.debugLine="lblLeft.Typeface = Typeface.MONOSPACE";
_lblleft.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3866681;
 //BA.debugLineNum = 3866681;BA.debugLine="lblLeft.TextSize = 10";
_lblleft.setTextSize((float) (10));
RDebugUtils.currentLine=3866682;
 //BA.debugLineNum = 3866682;BA.debugLine="lblLeft.Color = Colors.Transparent";
_lblleft.setColor(__c.Colors.Transparent);
RDebugUtils.currentLine=3866684;
 //BA.debugLineNum = 3866684;BA.debugLine="barPanel1.AddView(lblLeft, alignLeftCenter - 45d";
_barpanel1.AddView((android.view.View)(_lblleft.getObject()),(int) (_alignleftcenter-__c.DipToCurrent((int) (45))),_lbly,__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (20)));
 }
};
RDebugUtils.currentLine=3866687;
 //BA.debugLineNum = 3866687;BA.debugLine="Dim checkedCount As Int = 0";
_checkedcount = (int) (0);
RDebugUtils.currentLine=3866688;
 //BA.debugLineNum = 3866688;BA.debugLine="For i = 0 To checkedSales.Length - 1";
{
final int step52 = 1;
final int limit52 = (int) (__ref._checkedsales /*boolean[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit52 ;_i = _i + step52 ) {
RDebugUtils.currentLine=3866689;
 //BA.debugLineNum = 3866689;BA.debugLine="If checkedSales(i) Then checkedCount = checkedCo";
if (__ref._checkedsales /*boolean[]*/ [_i]) { 
_checkedcount = (int) (_checkedcount+1);};
 }
};
RDebugUtils.currentLine=3866692;
 //BA.debugLineNum = 3866692;BA.debugLine="Dim availableWidth As Int = activityPanel.Width -";
_availablewidth = (int) (_activitypanel.getWidth()-((_totalproducts-1)*_productgap));
RDebugUtils.currentLine=3866693;
 //BA.debugLineNum = 3866693;BA.debugLine="Dim barWidth As Int = availableWidth / (totalProd";
_barwidth = (int) (_availablewidth/(double)(_totalproducts*_checkedcount));
RDebugUtils.currentLine=3866695;
 //BA.debugLineNum = 3866695;BA.debugLine="If sales_1.Length <= 4 Then";
if (_sales_1.length<=4) { 
RDebugUtils.currentLine=3866696;
 //BA.debugLineNum = 3866696;BA.debugLine="barWidth = 30dip";
_barwidth = __c.DipToCurrent((int) (30));
 };
RDebugUtils.currentLine=3866698;
 //BA.debugLineNum = 3866698;BA.debugLine="If Active1.Width > 800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=3866699;
 //BA.debugLineNum = 3866699;BA.debugLine="If checkedCount =1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=3866700;
 //BA.debugLineNum = 3866700;BA.debugLine="barWidth = 30dip";
_barwidth = __c.DipToCurrent((int) (30));
RDebugUtils.currentLine=3866701;
 //BA.debugLineNum = 3866701;BA.debugLine="productGap = 45.5dip";
_productgap = __c.DipToCurrent((int) (45.5));
 };
 }else {
RDebugUtils.currentLine=3866704;
 //BA.debugLineNum = 3866704;BA.debugLine="If checkedCount =1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=3866705;
 //BA.debugLineNum = 3866705;BA.debugLine="barWidth = 30dip";
_barwidth = __c.DipToCurrent((int) (30));
RDebugUtils.currentLine=3866706;
 //BA.debugLineNum = 3866706;BA.debugLine="productGap = 18dip";
_productgap = __c.DipToCurrent((int) (18));
 };
 };
RDebugUtils.currentLine=3866711;
 //BA.debugLineNum = 3866711;BA.debugLine="Dim xStart As Int = 5dip ' Start from left when o";
_xstart = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=3866714;
 //BA.debugLineNum = 3866714;BA.debugLine="For i = 0 To totalProducts - 1";
{
final int step72 = 1;
final int limit72 = (int) (_totalproducts-1);
_i = (int) (0) ;
for (;_i <= limit72 ;_i = _i + step72 ) {
RDebugUtils.currentLine=3866715;
 //BA.debugLineNum = 3866715;BA.debugLine="Dim xPos As Int = xStart + (i * (checkedCount *";
_xpos = (int) (_xstart+(_i*(_checkedcount*_barwidth+_productgap)));
RDebugUtils.currentLine=3866716;
 //BA.debugLineNum = 3866716;BA.debugLine="Dim saleValues() As Int = Array As Int(sales_1(i";
_salevalues = new int[]{_sales_1[_i],_sales_2[_i],_sales_3[_i]};
RDebugUtils.currentLine=3866718;
 //BA.debugLineNum = 3866718;BA.debugLine="Dim indexOffset As Int = 0 ' Shift bars properly";
_indexoffset = (int) (0);
RDebugUtils.currentLine=3866720;
 //BA.debugLineNum = 3866720;BA.debugLine="For j = 0 To barsPerProduct - 1";
{
final int step76 = 1;
final int limit76 = (int) (_barsperproduct-1);
_j = (int) (0) ;
for (;_j <= limit76 ;_j = _j + step76 ) {
RDebugUtils.currentLine=3866721;
 //BA.debugLineNum = 3866721;BA.debugLine="If j < checkedSales.Length And checkedSales(j)";
if (_j<__ref._checkedsales /*boolean[]*/ .length && __ref._checkedsales /*boolean[]*/ [_j]) { 
RDebugUtils.currentLine=3866722;
 //BA.debugLineNum = 3866722;BA.debugLine="Dim sale As Int = saleValues(j)";
_sale = _salevalues[_j];
RDebugUtils.currentLine=3866723;
 //BA.debugLineNum = 3866723;BA.debugLine="Dim barHeight As Int = (sale / maxSale1) * act";
_barheight = (int) ((_sale/(double)_maxsale1)*_activitypanel.getHeight());
RDebugUtils.currentLine=3866724;
 //BA.debugLineNum = 3866724;BA.debugLine="Dim xBar As Int = xPos + indexOffset * barWidt";
_xbar = (int) (_xpos+_indexoffset*_barwidth);
RDebugUtils.currentLine=3866727;
 //BA.debugLineNum = 3866727;BA.debugLine="Dim lblSale As Label";
_lblsale = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3866728;
 //BA.debugLineNum = 3866728;BA.debugLine="lblSale.Initialize(\"\")";
_lblsale.Initialize(ba,"");
RDebugUtils.currentLine=3866729;
 //BA.debugLineNum = 3866729;BA.debugLine="lblSale.Text = FormatNumberWithSuffix(sale) '";
_lblsale.setText(BA.ObjectToCharSequence(__ref._formatnumberwithsuffix /*String*/ (null,_sale)));
RDebugUtils.currentLine=3866730;
 //BA.debugLineNum = 3866730;BA.debugLine="lblSale.TextColor = Colors.Black";
_lblsale.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=3866731;
 //BA.debugLineNum = 3866731;BA.debugLine="lblSale.Gravity = Gravity.CENTER";
_lblsale.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=3866732;
 //BA.debugLineNum = 3866732;BA.debugLine="lblSale.Typeface = Typeface.MONOSPACE";
_lblsale.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3866733;
 //BA.debugLineNum = 3866733;BA.debugLine="lblSale.TextSize = 7";
_lblsale.setTextSize((float) (7));
RDebugUtils.currentLine=3866734;
 //BA.debugLineNum = 3866734;BA.debugLine="lblSale.Color = Colors.Transparent";
_lblsale.setColor(__c.Colors.Transparent);
RDebugUtils.currentLine=3866735;
 //BA.debugLineNum = 3866735;BA.debugLine="If Active1.Width > 800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=3866736;
 //BA.debugLineNum = 3866736;BA.debugLine="If checkedCount > 2 Then";
if (_checkedcount>2) { 
RDebugUtils.currentLine=3866737;
 //BA.debugLineNum = 3866737;BA.debugLine="lblSale.TextSize = 5";
_lblsale.setTextSize((float) (5));
 };
 }else {
RDebugUtils.currentLine=3866740;
 //BA.debugLineNum = 3866740;BA.debugLine="If checkedCount =3 Then";
if (_checkedcount==3) { 
RDebugUtils.currentLine=3866741;
 //BA.debugLineNum = 3866741;BA.debugLine="lblSale.TextSize = 4";
_lblsale.setTextSize((float) (4));
 };
RDebugUtils.currentLine=3866743;
 //BA.debugLineNum = 3866743;BA.debugLine="If checkedCount =2 Then";
if (_checkedcount==2) { 
RDebugUtils.currentLine=3866744;
 //BA.debugLineNum = 3866744;BA.debugLine="lblSale.TextSize =3.8";
_lblsale.setTextSize((float) (3.8));
 };
 };
RDebugUtils.currentLine=3866748;
 //BA.debugLineNum = 3866748;BA.debugLine="Dim lblSaleLeft As Int = xBar + alignLeftCente";
_lblsaleleft = (int) (_xbar+_alignleftcenter);
RDebugUtils.currentLine=3866749;
 //BA.debugLineNum = 3866749;BA.debugLine="Dim lblSaleTop As Int = activityPanel.Height -";
_lblsaletop = (int) (_activitypanel.getHeight()-_barheight-__c.DipToCurrent((int) (15))+_aligntopcenter);
RDebugUtils.currentLine=3866751;
 //BA.debugLineNum = 3866751;BA.debugLine="barPanel1.AddView(lblSale, lblSaleLeft, lblSal";
_barpanel1.AddView((android.view.View)(_lblsale.getObject()),_lblsaleleft,_lblsaletop,_barwidth,__c.DipToCurrent((int) (15)));
RDebugUtils.currentLine=3866755;
 //BA.debugLineNum = 3866755;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=3866756;
 //BA.debugLineNum = 3866756;BA.debugLine="r.Initialize(xBar, activityPanel.Height - barH";
_r.Initialize(_xbar,(int) (_activitypanel.getHeight()-_barheight),(int) (_xbar+_barwidth),_activitypanel.getHeight());
RDebugUtils.currentLine=3866757;
 //BA.debugLineNum = 3866757;BA.debugLine="graphCanvas.DrawRect(r, Color(j), True, 2dip)";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),_color[_j],__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=3866759;
 //BA.debugLineNum = 3866759;BA.debugLine="indexOffset = indexOffset + 1 ' Increase offse";
_indexoffset = (int) (_indexoffset+1);
 };
 }
};
RDebugUtils.currentLine=3866762;
 //BA.debugLineNum = 3866762;BA.debugLine="Dim lblCompany As Label";
_lblcompany = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3866763;
 //BA.debugLineNum = 3866763;BA.debugLine="lblCompany.Initialize(\"\")";
_lblcompany.Initialize(ba,"");
RDebugUtils.currentLine=3866764;
 //BA.debugLineNum = 3866764;BA.debugLine="lblCompany.Text = comName(i)";
_lblcompany.setText(BA.ObjectToCharSequence(__ref._comname /*String[]*/ [_i]));
RDebugUtils.currentLine=3866765;
 //BA.debugLineNum = 3866765;BA.debugLine="lblCompany.TextColor = Colors.Black";
_lblcompany.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=3866766;
 //BA.debugLineNum = 3866766;BA.debugLine="lblCompany.Gravity = Gravity.CENTER";
_lblcompany.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=3866767;
 //BA.debugLineNum = 3866767;BA.debugLine="lblCompany.Typeface = Typeface.MONOSPACE";
_lblcompany.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3866768;
 //BA.debugLineNum = 3866768;BA.debugLine="lblCompany.TextSize = 10";
_lblcompany.setTextSize((float) (10));
RDebugUtils.currentLine=3866769;
 //BA.debugLineNum = 3866769;BA.debugLine="lblCompany.Color = Colors.Transparent";
_lblcompany.setColor(__c.Colors.Transparent);
RDebugUtils.currentLine=3866770;
 //BA.debugLineNum = 3866770;BA.debugLine="If Active1.Width <= 800 Then";
if (_active1.getWidth()<=800) { 
RDebugUtils.currentLine=3866771;
 //BA.debugLineNum = 3866771;BA.debugLine="lblCompany.TextSize = 7";
_lblcompany.setTextSize((float) (7));
RDebugUtils.currentLine=3866772;
 //BA.debugLineNum = 3866772;BA.debugLine="If checkedCount = 1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=3866773;
 //BA.debugLineNum = 3866773;BA.debugLine="lblCompany.TextSize = 8";
_lblcompany.setTextSize((float) (8));
 };
 };
RDebugUtils.currentLine=3866776;
 //BA.debugLineNum = 3866776;BA.debugLine="Dim totalBarWidth As Int = checkedCount * barWid";
_totalbarwidth = (int) (_checkedcount*_barwidth);
RDebugUtils.currentLine=3866777;
 //BA.debugLineNum = 3866777;BA.debugLine="Dim lblCompanyWidth As Int = totalBarWidth ' Set";
_lblcompanywidth = _totalbarwidth;
RDebugUtils.currentLine=3866778;
 //BA.debugLineNum = 3866778;BA.debugLine="Dim lblCompanyLeft As Int = xPos + (totalBarWidt";
_lblcompanyleft = (int) (_xpos+(_totalbarwidth/(double)2)-(_lblcompanywidth/(double)2)+_alignleftcenter);
RDebugUtils.currentLine=3866779;
 //BA.debugLineNum = 3866779;BA.debugLine="If checkedCount =1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=3866780;
 //BA.debugLineNum = 3866780;BA.debugLine="lblCompanyWidth = productGap";
_lblcompanywidth = _productgap;
RDebugUtils.currentLine=3866781;
 //BA.debugLineNum = 3866781;BA.debugLine="lblCompany.Gravity = Gravity.LEFT";
_lblcompany.setGravity(__c.Gravity.LEFT);
RDebugUtils.currentLine=3866782;
 //BA.debugLineNum = 3866782;BA.debugLine="lblCompanyWidth = productGap + barWidth";
_lblcompanywidth = (int) (_productgap+_barwidth);
 };
RDebugUtils.currentLine=3866785;
 //BA.debugLineNum = 3866785;BA.debugLine="Dim lblCompanyTop As Int = activityPanel.Height";
_lblcompanytop = (int) (_activitypanel.getHeight()+__c.DipToCurrent((int) (5))+_aligntopcenter);
RDebugUtils.currentLine=3866787;
 //BA.debugLineNum = 3866787;BA.debugLine="barPanel1.AddView(lblCompany, lblCompanyLeft, lb";
_barpanel1.AddView((android.view.View)(_lblcompany.getObject()),_lblcompanyleft,_lblcompanytop,_lblcompanywidth,__c.DipToCurrent((int) (15)));
 }
};
RDebugUtils.currentLine=3866790;
 //BA.debugLineNum = 3866790;BA.debugLine="bckBtn.Initialize(\"backBtn\")";
_bckbtn.Initialize(ba,"backBtn");
RDebugUtils.currentLine=3866791;
 //BA.debugLineNum = 3866791;BA.debugLine="bckBtn.Color = Colors.ARGB(50,0,0,0)";
_bckbtn.setColor(__c.Colors.ARGB((int) (50),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=3866792;
 //BA.debugLineNum = 3866792;BA.debugLine="bckBtn.Gravity =Gravity.FILL";
_bckbtn.setGravity(__c.Gravity.FILL);
RDebugUtils.currentLine=3866794;
 //BA.debugLineNum = 3866794;BA.debugLine="If Active1.Width > 800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=3866795;
 //BA.debugLineNum = 3866795;BA.debugLine="btnLeft = (alignLeftCenter/2)";
_btnleft = (int) ((_alignleftcenter/(double)2));
 }else {
RDebugUtils.currentLine=3866797;
 //BA.debugLineNum = 3866797;BA.debugLine="btnLeft = (alignLeftCenter/2)-30dip";
_btnleft = (int) ((_alignleftcenter/(double)2)-__c.DipToCurrent((int) (30)));
 };
RDebugUtils.currentLine=3866799;
 //BA.debugLineNum = 3866799;BA.debugLine="barPanel1.AddView(bckBtn,btnLeft,(barPanel1.Heigh";
_barpanel1.AddView((android.view.View)(_bckbtn.getObject()),_btnleft,(int) ((_barpanel1.getHeight()/(double)2)-__c.DipToCurrent((int) (10))),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=3866801;
 //BA.debugLineNum = 3866801;BA.debugLine="nextBtn.Initialize(\"nextBtn\")";
_nextbtn.Initialize(ba,"nextBtn");
RDebugUtils.currentLine=3866802;
 //BA.debugLineNum = 3866802;BA.debugLine="nextBtn.Color = Colors.ARGB(50,0,0,0)";
_nextbtn.setColor(__c.Colors.ARGB((int) (50),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=3866803;
 //BA.debugLineNum = 3866803;BA.debugLine="barPanel1.AddView(nextBtn,activityPanel.Width+(al";
_barpanel1.AddView((android.view.View)(_nextbtn.getObject()),(int) (_activitypanel.getWidth()+(_alignleftcenter)+__c.DipToCurrent((int) (15))),(int) ((_barpanel1.getHeight()/(double)2)-__c.DipToCurrent((int) (5))),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=3866804;
 //BA.debugLineNum = 3866804;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithlabel(b4a.example.checkbargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithlabel", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithlabel", new Object[] {_number}));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000000))+"M";
 }else 
{RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="Return Floor(number / 1000) & \"k\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000))+"k";
 }else {
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="Return Floor(number)";
if (true) return BA.NumberToString(__c.Floor(_number));
 }}
;
RDebugUtils.currentLine=4063240;
 //BA.debugLineNum = 4063240;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithsuffix(b4a.example.checkbargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithsuffix", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithsuffix", new Object[] {_number}));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
if (true) return __c.NumberFormat(_number/(double)1000000,(int) (1),(int) (1))+"M";
 }else 
{RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
if (true) return __c.NumberFormat(_number/(double)1000,(int) (1),(int) (1))+"k";
 }else {
RDebugUtils.currentLine=3997702;
 //BA.debugLineNum = 3997702;BA.debugLine="Return NumberFormat(number, 1, 0)";
if (true) return __c.NumberFormat(_number,(int) (1),(int) (0));
 }}
;
RDebugUtils.currentLine=3997704;
 //BA.debugLineNum = 3997704;BA.debugLine="End Sub";
return "";
}
public int  _drawwrappedtextrotated(b4a.example.checkbargraph __ref,anywheresoftware.b4a.objects.drawable.CanvasWrapper _canvas,String _text,int _x,int _y,int _maxwidth,float _fontsize,int _color,String _alignment,float _angle) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "drawwrappedtextrotated", false))
	 {return ((Integer) Debug.delegate(ba, "drawwrappedtextrotated", new Object[] {_canvas,_text,_x,_y,_maxwidth,_fontsize,_color,_alignment,_angle}));}
String[] _words = null;
String _line = "";
int _lineheight = 0;
int _originaly = 0;
String _word = "";
String _testline = "";
int _textwidth = 0;
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub DrawWrappedTextRotated(canvas As Canvas, text";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="Dim words() As String = Regex.Split(\" \", text)";
_words = __c.Regex.Split(" ",_text);
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="Dim line As String = \"\"";
_line = "";
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="Dim lineHeight As Int = 20dip ' Space between lin";
_lineheight = __c.DipToCurrent((int) (20));
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="Dim originalY As Int = y ' Store original Y posit";
_originaly = _y;
RDebugUtils.currentLine=3932166;
 //BA.debugLineNum = 3932166;BA.debugLine="For Each word As String In words";
{
final String[] group5 = _words;
final int groupLen5 = group5.length
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_word = group5[index5];
RDebugUtils.currentLine=3932167;
 //BA.debugLineNum = 3932167;BA.debugLine="Dim testLine As String = line & word & \" \"";
_testline = _line+_word+" ";
RDebugUtils.currentLine=3932168;
 //BA.debugLineNum = 3932168;BA.debugLine="Dim textWidth As Int = canvas.MeasureStringWidth";
_textwidth = (int) (_canvas.MeasureStringWidth(_testline,__c.Typeface.MONOSPACE,_fontsize));
RDebugUtils.currentLine=3932170;
 //BA.debugLineNum = 3932170;BA.debugLine="If textWidth > maxWidth And line <> \"\" Then";
if (_textwidth>_maxwidth && (_line).equals("") == false) { 
RDebugUtils.currentLine=3932172;
 //BA.debugLineNum = 3932172;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEF";
_canvas.DrawTextRotated(ba,_line,(float) (_x),(float) (_y),__c.Typeface.DEFAULT_BOLD,_fontsize,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,_alignment),_angle);
RDebugUtils.currentLine=3932173;
 //BA.debugLineNum = 3932173;BA.debugLine="y = y + lineHeight ' Move to next line";
_y = (int) (_y+_lineheight);
RDebugUtils.currentLine=3932174;
 //BA.debugLineNum = 3932174;BA.debugLine="line = word & \" \" ' Start new line";
_line = _word+" ";
 }else {
RDebugUtils.currentLine=3932176;
 //BA.debugLineNum = 3932176;BA.debugLine="line = testLine ' Add word to current line";
_line = _testline;
 };
 }
};
RDebugUtils.currentLine=3932181;
 //BA.debugLineNum = 3932181;BA.debugLine="If line <> \"\" Then";
if ((_line).equals("") == false) { 
RDebugUtils.currentLine=3932182;
 //BA.debugLineNum = 3932182;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEFA";
_canvas.DrawTextRotated(ba,_line,(float) (_x),(float) (_y),__c.Typeface.DEFAULT_BOLD,_fontsize,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,_alignment),_angle);
RDebugUtils.currentLine=3932183;
 //BA.debugLineNum = 3932183;BA.debugLine="y = y + lineHeight ' Move final Y position";
_y = (int) (_y+_lineheight);
 };
RDebugUtils.currentLine=3932187;
 //BA.debugLineNum = 3932187;BA.debugLine="Return y - originalY";
if (true) return (int) (_y-_originaly);
RDebugUtils.currentLine=3932188;
 //BA.debugLineNum = 3932188;BA.debugLine="End Sub";
return 0;
}
public String  _initialize(b4a.example.checkbargraph __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _active1,anywheresoftware.b4a.objects.PanelWrapper _panel,anywheresoftware.b4a.objects.ButtonWrapper _nextbtn,anywheresoftware.b4a.objects.ButtonWrapper _bckbtn,int[] _sales_1,int[] _sales_2,int[] _sales_3,String[] _comname1,int _maxsale1,String[] _legend) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_active1,_panel,_nextbtn,_bckbtn,_sales_1,_sales_2,_sales_3,_comname1,_maxsale1,_legend}));}
int _legendcount = 0;
anywheresoftware.b4a.objects.PanelWrapper _legendpanel = null;
int[] _color = null;
int _legendwidth = 0;
int _i = 0;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
anywheresoftware.b4a.objects.PanelWrapper _barpanel1 = null;
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Public Sub Initialize(Active1 As Activity, Panel A";
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Active = Active1";
__ref._active /*anywheresoftware.b4a.objects.ActivityWrapper*/  = _active1;
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="nxtBtn = nextBtn";
__ref._nxtbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/  = _nextbtn;
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="backBtn = bckBtn";
__ref._backbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/  = _bckbtn;
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="sales = sales_1";
__ref._sales /*int[]*/  = _sales_1;
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="sales1 = sales_2";
__ref._sales1 /*int[]*/  = _sales_2;
RDebugUtils.currentLine=3670023;
 //BA.debugLineNum = 3670023;BA.debugLine="sales2 = sales_3";
__ref._sales2 /*int[]*/  = _sales_3;
RDebugUtils.currentLine=3670024;
 //BA.debugLineNum = 3670024;BA.debugLine="comName = comName1";
__ref._comname /*String[]*/  = _comname1;
RDebugUtils.currentLine=3670025;
 //BA.debugLineNum = 3670025;BA.debugLine="maxSale = maxSale1";
__ref._maxsale /*int*/  = _maxsale1;
RDebugUtils.currentLine=3670026;
 //BA.debugLineNum = 3670026;BA.debugLine="Panel.Initialize(\"\")";
_panel.Initialize(ba,"");
RDebugUtils.currentLine=3670027;
 //BA.debugLineNum = 3670027;BA.debugLine="nextBtn.Initialize(\"nxtBtn\")";
_nextbtn.Initialize(ba,"nxtBtn");
RDebugUtils.currentLine=3670028;
 //BA.debugLineNum = 3670028;BA.debugLine="bckBtn.Initialize(\"bckBtn\")";
_bckbtn.Initialize(ba,"bckBtn");
RDebugUtils.currentLine=3670031;
 //BA.debugLineNum = 3670031;BA.debugLine="Dim legendCount As Int = legend.Length";
_legendcount = _legend.length;
RDebugUtils.currentLine=3670034;
 //BA.debugLineNum = 3670034;BA.debugLine="checkBoxes = Array As CheckBox()";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/  = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]{};
RDebugUtils.currentLine=3670035;
 //BA.debugLineNum = 3670035;BA.debugLine="checkedSales = Array As Boolean()";
__ref._checkedsales /*boolean[]*/  = new boolean[]{};
RDebugUtils.currentLine=3670037;
 //BA.debugLineNum = 3670037;BA.debugLine="Dim checkBoxes(legendCount) As CheckBox   ' Resiz";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[_legendcount];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=3670038;
 //BA.debugLineNum = 3670038;BA.debugLine="Dim checkedSales(legendCount) As Boolean";
_checkedsales = new boolean[_legendcount];
;
RDebugUtils.currentLine=3670040;
 //BA.debugLineNum = 3670040;BA.debugLine="Dim legendPanel As Panel";
_legendpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3670041;
 //BA.debugLineNum = 3670041;BA.debugLine="legendPanel.Initialize(\"\")";
_legendpanel.Initialize(ba,"");
RDebugUtils.currentLine=3670042;
 //BA.debugLineNum = 3670042;BA.debugLine="legendPanel.Width = Active.Width";
_legendpanel.setWidth(__ref._active /*anywheresoftware.b4a.objects.ActivityWrapper*/ .getWidth());
RDebugUtils.currentLine=3670043;
 //BA.debugLineNum = 3670043;BA.debugLine="legendPanel.Height = 50dip";
_legendpanel.setHeight(__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=3670044;
 //BA.debugLineNum = 3670044;BA.debugLine="Panel.AddView(legendPanel, (Panel.Width / 3.5), 0";
_panel.AddView((android.view.View)(_legendpanel.getObject()),(int) ((_panel.getWidth()/(double)3.5)),(int) (0),(int) (_panel.getWidth()/(double)1.5),__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=3670046;
 //BA.debugLineNum = 3670046;BA.debugLine="Dim Color() As Int = Array As Int(Colors.Red, Col";
_color = new int[]{__c.Colors.Red,__c.Colors.Green,__c.Colors.Blue};
RDebugUtils.currentLine=3670047;
 //BA.debugLineNum = 3670047;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
_legendwidth = (int) (_legendpanel.getWidth()/(double)_legend.length);
RDebugUtils.currentLine=3670049;
 //BA.debugLineNum = 3670049;BA.debugLine="For i = 0 To legendCount - 1";
{
final int step24 = 1;
final int limit24 = (int) (_legendcount-1);
_i = (int) (0) ;
for (;_i <= limit24 ;_i = _i + step24 ) {
RDebugUtils.currentLine=3670050;
 //BA.debugLineNum = 3670050;BA.debugLine="Dim chk As CheckBox";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=3670051;
 //BA.debugLineNum = 3670051;BA.debugLine="chk.Initialize(\"chkChange\") ' Ensure correct eve";
_chk.Initialize(ba,"chkChange");
RDebugUtils.currentLine=3670052;
 //BA.debugLineNum = 3670052;BA.debugLine="chk.Text = legend(i)";
_chk.setText(BA.ObjectToCharSequence(_legend[_i]));
RDebugUtils.currentLine=3670053;
 //BA.debugLineNum = 3670053;BA.debugLine="chk.TextSize = 10";
_chk.setTextSize((float) (10));
RDebugUtils.currentLine=3670054;
 //BA.debugLineNum = 3670054;BA.debugLine="chk.Typeface = Typeface.MONOSPACE";
_chk.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3670055;
 //BA.debugLineNum = 3670055;BA.debugLine="chk.TextColor = Color(i)";
_chk.setTextColor(_color[_i]);
RDebugUtils.currentLine=3670056;
 //BA.debugLineNum = 3670056;BA.debugLine="chk.Tag = i";
_chk.setTag((Object)(_i));
RDebugUtils.currentLine=3670057;
 //BA.debugLineNum = 3670057;BA.debugLine="chk.Checked = True ' Initially checked";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=3670059;
 //BA.debugLineNum = 3670059;BA.debugLine="legendPanel.AddView(chk, (legendWidth * i) + 10d";
_legendpanel.AddView((android.view.View)(_chk.getObject()),(int) ((_legendwidth*_i)+__c.DipToCurrent((int) (10))),__c.DipToCurrent((int) (5)),(int) (_legendwidth-__c.DipToCurrent((int) (20))),__c.DipToCurrent((int) (40)));
RDebugUtils.currentLine=3670061;
 //BA.debugLineNum = 3670061;BA.debugLine="checkBoxes(i) = chk ' Store reference in global";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/ [_i] = _chk;
RDebugUtils.currentLine=3670062;
 //BA.debugLineNum = 3670062;BA.debugLine="checkedSales(i) = True";
__ref._checkedsales /*boolean[]*/ [_i] = __c.True;
 }
};
RDebugUtils.currentLine=3670065;
 //BA.debugLineNum = 3670065;BA.debugLine="Dim barPanel1 As Panel";
_barpanel1 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3670066;
 //BA.debugLineNum = 3670066;BA.debugLine="barPanel1.Initialize(\"\")";
_barpanel1.Initialize(ba,"");
RDebugUtils.currentLine=3670067;
 //BA.debugLineNum = 3670067;BA.debugLine="Panel.AddView(barPanel1, 0, legendPanel.Height, P";
_panel.AddView((android.view.View)(_barpanel1.getObject()),(int) (0),_legendpanel.getHeight(),_panel.getWidth(),__c.DipToCurrent((int) (350)));
RDebugUtils.currentLine=3670068;
 //BA.debugLineNum = 3670068;BA.debugLine="barPanel = barPanel1";
__ref._barpanel /*anywheresoftware.b4a.objects.PanelWrapper*/  = _barpanel1;
RDebugUtils.currentLine=3670070;
 //BA.debugLineNum = 3670070;BA.debugLine="DrawGraph";
__ref._drawgraph /*String*/ (null);
RDebugUtils.currentLine=3670071;
 //BA.debugLineNum = 3670071;BA.debugLine="End Sub";
return "";
}
}