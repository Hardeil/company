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
public anywheresoftware.b4a.objects.PanelWrapper _activitypanel = null;
public b4a.example.main _main = null;
public b4a.example.device _device = null;
public b4a.example.branch _branch = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public String  _initialize(b4a.example.bargraph __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _active,anywheresoftware.b4a.objects.PanelWrapper _panel,int[] _sale1,int[] _sale2,int[] _sale3,String[] _product,String[] _legend,int _maxsales,String _titlestring) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_active,_panel,_sale1,_sale2,_sale3,_product,_legend,_maxsales,_titlestring}));}
int _alignleftcenter = 0;
int _aligntopcenter = 0;
anywheresoftware.b4a.objects.LabelWrapper _title = null;
anywheresoftware.b4a.objects.PanelWrapper _legendpanel = null;
int[] _color = null;
int _legendwidth = 0;
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _colorlabel = null;
anywheresoftware.b4a.objects.LabelWrapper _legendlabel = null;
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
int _xpos = 0;
int[] _salevalues = null;
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
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Public Sub Initialize(Active As Activity, panel As";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="panel.RemoveAllViews";
_panel.RemoveAllViews();
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="panel.Height = 400dip";
_panel.setHeight(__c.DipToCurrent((int) (400)));
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="Dim activityPanel As Panel";
_activitypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3932165;
 //BA.debugLineNum = 3932165;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .Initialize(ba,"activityPanel");
RDebugUtils.currentLine=3932167;
 //BA.debugLineNum = 3932167;BA.debugLine="activityPanel.Width = 80%x";
__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setWidth(__c.PerXToCurrent((float) (80),ba));
RDebugUtils.currentLine=3932168;
 //BA.debugLineNum = 3932168;BA.debugLine="If Active.Width > 800 Then";
if (_active.getWidth()>800) { 
RDebugUtils.currentLine=3932169;
 //BA.debugLineNum = 3932169;BA.debugLine="activityPanel.Width = 55%x";
__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setWidth(__c.PerXToCurrent((float) (55),ba));
 };
RDebugUtils.currentLine=3932171;
 //BA.debugLineNum = 3932171;BA.debugLine="activityPanel.Height = 250dip";
__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setHeight(__c.DipToCurrent((int) (250)));
RDebugUtils.currentLine=3932172;
 //BA.debugLineNum = 3932172;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setColor(__c.Colors.ARGB((int) (70),(int) (211),(int) (211),(int) (211)));
RDebugUtils.currentLine=3932174;
 //BA.debugLineNum = 3932174;BA.debugLine="Dim alignLeftCenter As Int = (Active.Width - acti";
_alignleftcenter = (int) ((_active.getWidth()-__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth())/(double)2);
RDebugUtils.currentLine=3932175;
 //BA.debugLineNum = 3932175;BA.debugLine="Dim alignTopCenter As Int = (panel.Height - activ";
_aligntopcenter = (int) ((_panel.getHeight()-__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight())/(double)2);
RDebugUtils.currentLine=3932177;
 //BA.debugLineNum = 3932177;BA.debugLine="Dim Title As Label";
_title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3932178;
 //BA.debugLineNum = 3932178;BA.debugLine="Title.Initialize(\"\")";
_title.Initialize(ba,"");
RDebugUtils.currentLine=3932179;
 //BA.debugLineNum = 3932179;BA.debugLine="Title.Text = TitleString";
_title.setText(BA.ObjectToCharSequence(_titlestring));
RDebugUtils.currentLine=3932180;
 //BA.debugLineNum = 3932180;BA.debugLine="Title.TextSize = 20";
_title.setTextSize((float) (20));
RDebugUtils.currentLine=3932181;
 //BA.debugLineNum = 3932181;BA.debugLine="Title.Typeface = Typeface.MONOSPACE";
_title.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3932182;
 //BA.debugLineNum = 3932182;BA.debugLine="Title.Gravity = Gravity.CENTER";
_title.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=3932183;
 //BA.debugLineNum = 3932183;BA.debugLine="Title.TextColor = Colors.Black";
_title.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=3932186;
 //BA.debugLineNum = 3932186;BA.debugLine="Dim legendPanel As Panel";
_legendpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3932187;
 //BA.debugLineNum = 3932187;BA.debugLine="legendPanel.Initialize(\"\")";
_legendpanel.Initialize(ba,"");
RDebugUtils.currentLine=3932188;
 //BA.debugLineNum = 3932188;BA.debugLine="legendPanel.Width = panel.Width";
_legendpanel.setWidth(_panel.getWidth());
RDebugUtils.currentLine=3932189;
 //BA.debugLineNum = 3932189;BA.debugLine="legendPanel.Height = 30dip";
_legendpanel.setHeight(__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=3932190;
 //BA.debugLineNum = 3932190;BA.debugLine="panel.AddView(legendPanel, (panel.Width/2) + 20di";
_panel.AddView((android.view.View)(_legendpanel.getObject()),(int) ((_panel.getWidth()/(double)2)+__c.DipToCurrent((int) (20))),(int) (0),(int) (__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()/(double)2),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=3932192;
 //BA.debugLineNum = 3932192;BA.debugLine="Dim legend() As String = Array As String(\"Sales 1";
_legend = new String[]{"Sales 1","Sales 2","Sales 3"};
RDebugUtils.currentLine=3932193;
 //BA.debugLineNum = 3932193;BA.debugLine="Dim color() As Int = Array As Int(Colors.RGB(255,";
_color = new int[]{__c.Colors.RGB((int) (255),(int) (0),(int) (0)),__c.Colors.RGB((int) (200),(int) (20),(int) (20)),__c.Colors.RGB((int) (100),(int) (10),(int) (10))};
RDebugUtils.currentLine=3932195;
 //BA.debugLineNum = 3932195;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
_legendwidth = (int) (_legendpanel.getWidth()/(double)_legend.length);
RDebugUtils.currentLine=3932197;
 //BA.debugLineNum = 3932197;BA.debugLine="For i = 0 To legend.Length - 1";
{
final int step28 = 1;
final int limit28 = (int) (_legend.length-1);
_i = (int) (0) ;
for (;_i <= limit28 ;_i = _i + step28 ) {
RDebugUtils.currentLine=3932198;
 //BA.debugLineNum = 3932198;BA.debugLine="Dim colorLabel As Label";
_colorlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3932199;
 //BA.debugLineNum = 3932199;BA.debugLine="colorLabel.Initialize(\"\")";
_colorlabel.Initialize(ba,"");
RDebugUtils.currentLine=3932200;
 //BA.debugLineNum = 3932200;BA.debugLine="colorLabel.Color = color(i)";
_colorlabel.setColor(_color[_i]);
RDebugUtils.currentLine=3932201;
 //BA.debugLineNum = 3932201;BA.debugLine="legendPanel.AddView(colorLabel, (legendWidth * i";
_legendpanel.AddView((android.view.View)(_colorlabel.getObject()),(int) ((_legendwidth*_i)+__c.DipToCurrent((int) (20))),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (10)),(int) (_legendpanel.getHeight()-__c.DipToCurrent((int) (18))));
RDebugUtils.currentLine=3932203;
 //BA.debugLineNum = 3932203;BA.debugLine="Dim legendLabel As Label";
_legendlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3932204;
 //BA.debugLineNum = 3932204;BA.debugLine="legendLabel.Initialize(\"\")";
_legendlabel.Initialize(ba,"");
RDebugUtils.currentLine=3932205;
 //BA.debugLineNum = 3932205;BA.debugLine="legendLabel.Text = legend(i)";
_legendlabel.setText(BA.ObjectToCharSequence(_legend[_i]));
RDebugUtils.currentLine=3932206;
 //BA.debugLineNum = 3932206;BA.debugLine="legendLabel.TextColor = Colors.black  ' Set text";
_legendlabel.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=3932207;
 //BA.debugLineNum = 3932207;BA.debugLine="legendLabel.Gravity = Gravity.CENTER";
_legendlabel.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=3932208;
 //BA.debugLineNum = 3932208;BA.debugLine="legendPanel.AddView(legendLabel, (legendWidth *";
_legendpanel.AddView((android.view.View)(_legendlabel.getObject()),(int) ((_legendwidth*_i)+__c.DipToCurrent((int) (30))),__c.DipToCurrent((int) (0)),(int) (_legendwidth-__c.DipToCurrent((int) (30))),_legendpanel.getHeight());
 }
};
RDebugUtils.currentLine=3932212;
 //BA.debugLineNum = 3932212;BA.debugLine="panel.AddView(Title, 0, alignTopCenter / 2, panel";
_panel.AddView((android.view.View)(_title.getObject()),(int) (0),(int) (_aligntopcenter/(double)2),_panel.getWidth(),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=3932215;
 //BA.debugLineNum = 3932215;BA.debugLine="panel.AddView(activityPanel, alignLeftCenter, ali";
_panel.AddView((android.view.View)(__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()),_alignleftcenter,_aligntopcenter,__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth(),__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight());
RDebugUtils.currentLine=3932218;
 //BA.debugLineNum = 3932218;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=3932219;
 //BA.debugLineNum = 3932219;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()));
RDebugUtils.currentLine=3932222;
 //BA.debugLineNum = 3932222;BA.debugLine="Dim maxSale As Int = maxSales * 1.2";
_maxsale = (int) (_maxsales*1.2);
RDebugUtils.currentLine=3932224;
 //BA.debugLineNum = 3932224;BA.debugLine="Dim cv As Canvas";
_cv = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=3932225;
 //BA.debugLineNum = 3932225;BA.debugLine="cv.Initialize(panel)";
_cv.Initialize((android.view.View)(_panel.getObject()));
RDebugUtils.currentLine=3932228;
 //BA.debugLineNum = 3932228;BA.debugLine="Dim totalProducts As Int =  sale1.Length";
_totalproducts = _sale1.length;
RDebugUtils.currentLine=3932229;
 //BA.debugLineNum = 3932229;BA.debugLine="Dim barsPerProduct As Int = 3";
_barsperproduct = (int) (3);
RDebugUtils.currentLine=3932230;
 //BA.debugLineNum = 3932230;BA.debugLine="Dim totalBars As Int = totalProducts * barsPerPro";
_totalbars = (int) (_totalproducts*_barsperproduct);
RDebugUtils.currentLine=3932231;
 //BA.debugLineNum = 3932231;BA.debugLine="Dim gap As Int = 5dip";
_gap = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=3932232;
 //BA.debugLineNum = 3932232;BA.debugLine="Dim productGap As Int = 15dip";
_productgap = __c.DipToCurrent((int) (15));
RDebugUtils.currentLine=3932233;
 //BA.debugLineNum = 3932233;BA.debugLine="Dim padding As Int = 20dip";
_padding = __c.DipToCurrent((int) (20));
RDebugUtils.currentLine=3932235;
 //BA.debugLineNum = 3932235;BA.debugLine="Dim availableWidth As Int = activityPanel.Width -";
_availablewidth = (int) (__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()-(_padding*2)-((_totalproducts-1)*_productgap)-((_totalbars-_totalproducts)*_gap));
RDebugUtils.currentLine=3932236;
 //BA.debugLineNum = 3932236;BA.debugLine="Dim barWidth As Int = availableWidth / totalBars";
_barwidth = (int) (_availablewidth/(double)_totalbars);
RDebugUtils.currentLine=3932237;
 //BA.debugLineNum = 3932237;BA.debugLine="Dim xStart As Int = padding";
_xstart = _padding;
RDebugUtils.currentLine=3932239;
 //BA.debugLineNum = 3932239;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=3932240;
 //BA.debugLineNum = 3932240;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()));
RDebugUtils.currentLine=3932242;
 //BA.debugLineNum = 3932242;BA.debugLine="For i = 0 To totalProducts - 1";
{
final int step58 = 1;
final int limit58 = (int) (_totalproducts-1);
_i = (int) (0) ;
for (;_i <= limit58 ;_i = _i + step58 ) {
RDebugUtils.currentLine=3932243;
 //BA.debugLineNum = 3932243;BA.debugLine="Dim xPos As Int = xStart + i * (barsPerProduct *";
_xpos = (int) (_xstart+_i*(_barsperproduct*(_barwidth+_gap)+_productgap));
RDebugUtils.currentLine=3932244;
 //BA.debugLineNum = 3932244;BA.debugLine="Dim saleValues() As Int = Array As Int(sale1(i),";
_salevalues = new int[]{_sale1[_i],_sale2[_i],_sale3[_i]};
RDebugUtils.currentLine=3932246;
 //BA.debugLineNum = 3932246;BA.debugLine="For j = 0 To barsPerProduct - 1";
{
final int step61 = 1;
final int limit61 = (int) (_barsperproduct-1);
_j = (int) (0) ;
for (;_j <= limit61 ;_j = _j + step61 ) {
RDebugUtils.currentLine=3932247;
 //BA.debugLineNum = 3932247;BA.debugLine="Dim sale As Int = saleValues(j)";
_sale = _salevalues[_j];
RDebugUtils.currentLine=3932248;
 //BA.debugLineNum = 3932248;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * (acti";
_barheight = (int) ((_sale/(double)_maxsale)*(__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()-__c.DipToCurrent((int) (50))));
RDebugUtils.currentLine=3932249;
 //BA.debugLineNum = 3932249;BA.debugLine="Dim xBar As Int = xPos + j * (barWidth + gap)";
_xbar = (int) (_xpos+_j*(_barwidth+_gap));
RDebugUtils.currentLine=3932251;
 //BA.debugLineNum = 3932251;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=3932252;
 //BA.debugLineNum = 3932252;BA.debugLine="r.Initialize(xBar, activityPanel.Height - barHe";
_r.Initialize(_xbar,(int) (__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()-_barheight),(int) (_xbar+_barwidth),_panel.getHeight());
RDebugUtils.currentLine=3932253;
 //BA.debugLineNum = 3932253;BA.debugLine="graphCanvas.DrawRect(r, color(j), True, 2dip)";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),_color[_j],__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=3932256;
 //BA.debugLineNum = 3932256;BA.debugLine="Dim fontSize As Int = 8";
_fontsize = (int) (8);
RDebugUtils.currentLine=3932257;
 //BA.debugLineNum = 3932257;BA.debugLine="If Active.Width > 800 Then";
if (_active.getWidth()>800) { 
RDebugUtils.currentLine=3932258;
 //BA.debugLineNum = 3932258;BA.debugLine="fontSize = 10";
_fontsize = (int) (10);
 };
RDebugUtils.currentLine=3932260;
 //BA.debugLineNum = 3932260;BA.debugLine="graphCanvas.DrawText( FormatNumberWithSuffix(sa";
_graphcanvas.DrawText(ba,__ref._formatnumberwithsuffix /*String*/ (null,_sale),(float) (_xbar+(_barwidth/(double)2)),(float) (__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()-_barheight-__c.DipToCurrent((int) (5))),__c.Typeface.MONOSPACE,(float) (_fontsize),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
 }
};
RDebugUtils.currentLine=3932263;
 //BA.debugLineNum = 3932263;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
_productlabely = (int) (__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()+_aligntopcenter+__c.DipToCurrent((int) (20)));
RDebugUtils.currentLine=3932264;
 //BA.debugLineNum = 3932264;BA.debugLine="Dim productLabelX As Int = alignLeftCenter + 50d";
_productlabelx = (int) (_alignleftcenter+__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=3932265;
 //BA.debugLineNum = 3932265;BA.debugLine="cv.DrawText(product(i), xPos + productLabelX, pr";
_cv.DrawText(ba,_product[_i],(float) (_xpos+_productlabelx),(float) (_productlabely),__c.Typeface.MONOSPACE,(float) (12),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
 }
};
RDebugUtils.currentLine=3932267;
 //BA.debugLineNum = 3932267;BA.debugLine="Dim numLabels As Int = 10";
_numlabels = (int) (10);
RDebugUtils.currentLine=3932268;
 //BA.debugLineNum = 3932268;BA.debugLine="For i = 0 To numLabels";
{
final int step79 = 1;
final int limit79 = _numlabels;
_i = (int) (0) ;
for (;_i <= limit79 ;_i = _i + step79 ) {
RDebugUtils.currentLine=3932269;
 //BA.debugLineNum = 3932269;BA.debugLine="Dim labelValue As Int = Round((maxSale / numLabe";
_labelvalue = (int) (__c.Round((_maxsale/(double)_numlabels)*_i));
RDebugUtils.currentLine=3932270;
 //BA.debugLineNum = 3932270;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ((";
_labelypos = (int) (__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()-((_labelvalue/(double)_maxsale)*__ref._activitypanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()));
RDebugUtils.currentLine=3932273;
 //BA.debugLineNum = 3932273;BA.debugLine="cv.DrawText(FormatNumberWithLabel(labelValue), a";
_cv.DrawText(ba,__ref._formatnumberwithlabel /*String*/ (null,_labelvalue),(float) (_alignleftcenter-__c.DipToCurrent((int) (10))),(float) (_labelypos+_aligntopcenter+__c.DipToCurrent((int) (5))),__c.Typeface.MONOSPACE,(float) (10),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"RIGHT"));
 }
};
RDebugUtils.currentLine=3932275;
 //BA.debugLineNum = 3932275;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="Dim activityPanel As Panel";
_activitypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="End Sub";
return "";
}
public int  _drawwrappedtextrotated(b4a.example.bargraph __ref,anywheresoftware.b4a.objects.drawable.CanvasWrapper _canvas,String _text,int _x,int _y,int _maxwidth,float _fontsize,int _color,String _alignment,float _angle) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "drawwrappedtextrotated", false))
	 {return ((Integer) Debug.delegate(ba, "drawwrappedtextrotated", new Object[] {_canvas,_text,_x,_y,_maxwidth,_fontsize,_color,_alignment,_angle}));}
String[] _words = null;
String _line = "";
int _lineheight = 0;
int _originaly = 0;
String _word = "";
String _testline = "";
int _textwidth = 0;
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub DrawWrappedTextRotated(canvas As Canvas, text";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="Dim words() As String = Regex.Split(\" \", text)";
_words = __c.Regex.Split(" ",_text);
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="Dim line As String = \"\"";
_line = "";
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="Dim lineHeight As Int = 20dip ' Space between lin";
_lineheight = __c.DipToCurrent((int) (20));
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="Dim originalY As Int = y ' Store original Y posit";
_originaly = _y;
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="For Each word As String In words";
{
final String[] group5 = _words;
final int groupLen5 = group5.length
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_word = group5[index5];
RDebugUtils.currentLine=4063239;
 //BA.debugLineNum = 4063239;BA.debugLine="Dim testLine As String = line & word & \" \"";
_testline = _line+_word+" ";
RDebugUtils.currentLine=4063240;
 //BA.debugLineNum = 4063240;BA.debugLine="Dim textWidth As Int = canvas.MeasureStringWidth";
_textwidth = (int) (_canvas.MeasureStringWidth(_testline,__c.Typeface.MONOSPACE,_fontsize));
RDebugUtils.currentLine=4063242;
 //BA.debugLineNum = 4063242;BA.debugLine="If textWidth > maxWidth And line <> \"\" Then";
if (_textwidth>_maxwidth && (_line).equals("") == false) { 
RDebugUtils.currentLine=4063244;
 //BA.debugLineNum = 4063244;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEF";
_canvas.DrawTextRotated(ba,_line,(float) (_x),(float) (_y),__c.Typeface.DEFAULT_BOLD,_fontsize,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,_alignment),_angle);
RDebugUtils.currentLine=4063245;
 //BA.debugLineNum = 4063245;BA.debugLine="y = y + lineHeight ' Move to next line";
_y = (int) (_y+_lineheight);
RDebugUtils.currentLine=4063246;
 //BA.debugLineNum = 4063246;BA.debugLine="line = word & \" \" ' Start new line";
_line = _word+" ";
 }else {
RDebugUtils.currentLine=4063248;
 //BA.debugLineNum = 4063248;BA.debugLine="line = testLine ' Add word to current line";
_line = _testline;
 };
 }
};
RDebugUtils.currentLine=4063253;
 //BA.debugLineNum = 4063253;BA.debugLine="If line <> \"\" Then";
if ((_line).equals("") == false) { 
RDebugUtils.currentLine=4063254;
 //BA.debugLineNum = 4063254;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEFA";
_canvas.DrawTextRotated(ba,_line,(float) (_x),(float) (_y),__c.Typeface.DEFAULT_BOLD,_fontsize,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,_alignment),_angle);
RDebugUtils.currentLine=4063255;
 //BA.debugLineNum = 4063255;BA.debugLine="y = y + lineHeight ' Move final Y position";
_y = (int) (_y+_lineheight);
 };
RDebugUtils.currentLine=4063259;
 //BA.debugLineNum = 4063259;BA.debugLine="Return y - originalY";
if (true) return (int) (_y-_originaly);
RDebugUtils.currentLine=4063260;
 //BA.debugLineNum = 4063260;BA.debugLine="End Sub";
return 0;
}
public String  _formatnumberwithlabel(b4a.example.bargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithlabel", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithlabel", new Object[] {_number}));}
RDebugUtils.currentLine=7405568;
 //BA.debugLineNum = 7405568;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
RDebugUtils.currentLine=7405569;
 //BA.debugLineNum = 7405569;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=7405570;
 //BA.debugLineNum = 7405570;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000000))+"M";
 }else 
{RDebugUtils.currentLine=7405571;
 //BA.debugLineNum = 7405571;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=7405572;
 //BA.debugLineNum = 7405572;BA.debugLine="Return Floor(number / 1000) & \"k\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000))+"k";
 }else {
RDebugUtils.currentLine=7405574;
 //BA.debugLineNum = 7405574;BA.debugLine="Return number ' No formatting needed for v";
if (true) return BA.NumberToString(_number);
 }}
;
RDebugUtils.currentLine=7405576;
 //BA.debugLineNum = 7405576;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithsuffix(b4a.example.bargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
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
}