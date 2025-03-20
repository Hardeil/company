package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,67);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _gradient = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
RemoteObject _myimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _imgview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _dashlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 67;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(8);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 69;BA.debugLine="Panel1.Color = Colors.Black";
Debug.ShouldStop(16);
main.mostCurrent._panel1.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 70;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
Debug.ShouldStop(32);
main.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._label1.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 71;BA.debugLine="Label1.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(64);
main.mostCurrent._label1.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 72;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 241, 2";
Debug.ShouldStop(128);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 241)),(Object)(BA.numberCast(int.class, 241)),(Object)(BA.numberCast(int.class, 241))));
 BA.debugLineNum = 73;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(256);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 74;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
Debug.ShouldStop(512);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 225)),(Object)(BA.numberCast(int.class, 218)),(Object)(BA.numberCast(int.class, 218))),main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 189)),(Object)(BA.numberCast(int.class, 202)),(Object)(BA.numberCast(int.class, 217)))})));
 BA.debugLineNum = 75;BA.debugLine="ScrollView1.Background = gradient";
Debug.ShouldStop(1024);
main.mostCurrent._scrollview1.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 76;BA.debugLine="ScrollView1.Panel.Height = Activity.Height";
Debug.ShouldStop(2048);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",main.mostCurrent._activity.runMethod(true,"getHeight"));
 BA.debugLineNum = 77;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(4096);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 78;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
Debug.ShouldStop(8192);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 185)),(Object)(BA.numberCast(int.class, 46)),(Object)(BA.numberCast(int.class, 52))),main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))})));
 BA.debugLineNum = 79;BA.debugLine="Panel2.Background = gradient";
Debug.ShouldStop(16384);
main.mostCurrent._panel2.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 82;BA.debugLine="dashPanel.Initialize(\"\")";
Debug.ShouldStop(131072);
main.mostCurrent._dashpanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 83;BA.debugLine="topPositionSale = Panel2.Height";
Debug.ShouldStop(262144);
main._toppositionsale = main.mostCurrent._panel2.runMethod(true,"getHeight");
 BA.debugLineNum = 84;BA.debugLine="ScrollView1.Panel.AddView(dashPanel, 5dip, Panel2";
Debug.ShouldStop(524288);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((main.mostCurrent._dashpanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(main.mostCurrent._panel2.runMethod(true,"getHeight")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 86;BA.debugLine="Dim myImage As Bitmap = LoadBitmap(File.DirAssets";
Debug.ShouldStop(2097152);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_myimage = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("dashboard.png")));Debug.locals.put("myImage", _myimage);Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 87;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(4194304);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 88;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(8388608);
_imgview.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 89;BA.debugLine="imgView.Gravity = Gravity.FILL";
Debug.ShouldStop(16777216);
_imgview.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 90;BA.debugLine="imgView.Bitmap = myImage";
Debug.ShouldStop(33554432);
_imgview.runMethod(false,"setBitmap",(_myimage.getObject()));
 BA.debugLineNum = 91;BA.debugLine="dashPanel.AddView(imgView, 0dip, 12.5dip, 15dip,";
Debug.ShouldStop(67108864);
main.mostCurrent._dashpanel.runVoidMethod ("AddView",(Object)((_imgview.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12.5)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._dashpanel.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))}, "-",1, 1)));
 BA.debugLineNum = 93;BA.debugLine="Dim dashLabel As Label";
Debug.ShouldStop(268435456);
_dashlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("dashLabel", _dashlabel);
 BA.debugLineNum = 94;BA.debugLine="dashLabel.Initialize(\"\")";
Debug.ShouldStop(536870912);
_dashlabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 95;BA.debugLine="dashLabel.Text = \"Dashboard\"";
Debug.ShouldStop(1073741824);
_dashlabel.runMethod(true,"setText",BA.ObjectToCharSequence("Dashboard"));
 BA.debugLineNum = 96;BA.debugLine="dashLabel.TextColor = Colors.Black";
Debug.ShouldStop(-2147483648);
_dashlabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 97;BA.debugLine="dashLabel.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(1);
_dashlabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 98;BA.debugLine="dashLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(2);
_dashlabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 99;BA.debugLine="dashPanel.AddView(dashLabel, imgView.Width + 5dip";
Debug.ShouldStop(4);
main.mostCurrent._dashpanel.runVoidMethod ("AddView",(Object)((_dashlabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_imgview.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent._dashpanel.runMethod(true,"getWidth")),(Object)(main.mostCurrent._dashpanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 100;BA.debugLine="calculatedSize = AdjustFontSizeToHeight(dashLabel";
Debug.ShouldStop(8);
main._calculatedsize = _adjustfontsizetoheight(_dashlabel,BA.numberCast(float.class, 2));
 BA.debugLineNum = 101;BA.debugLine="dashLabel.TextSize = calculatedSize";
Debug.ShouldStop(16);
_dashlabel.runMethod(true,"setTextSize",main._calculatedsize);
 BA.debugLineNum = 104;BA.debugLine="barPanel.Initialize(\"\")";
Debug.ShouldStop(128);
main.mostCurrent._barpanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 105;BA.debugLine="purchasePanel.Initialize(\"\")";
Debug.ShouldStop(256);
main.mostCurrent._purchasepanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 106;BA.debugLine="companyPanel.Initialize(\"Panel\")";
Debug.ShouldStop(512);
main.mostCurrent._companypanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel")));
 BA.debugLineNum = 108;BA.debugLine="LoadGraphData";
Debug.ShouldStop(2048);
_loadgraphdata();
 BA.debugLineNum = 109;BA.debugLine="LoadGraphDataPurchase";
Debug.ShouldStop(4096);
_loadgraphdatapurchase();
 BA.debugLineNum = 110;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(8192);
_loadcompanydata();
 BA.debugLineNum = 111;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,472);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 472;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 473;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,469);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 469;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 470;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _adjustfontsizetoheight(RemoteObject _lbl,RemoteObject _fontscalefactor) throws Exception{
try {
		Debug.PushSubsStack("AdjustFontSizeToHeight (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,812);
if (RapidSub.canDelegate("adjustfontsizetoheight")) { return b4a.example.main.remoteMe.runUserSub(false, "main","adjustfontsizetoheight", _lbl, _fontscalefactor);}
RemoteObject _fontsize = RemoteObject.createImmutable(0f);
Debug.locals.put("lbl", _lbl);
Debug.locals.put("fontScaleFactor", _fontscalefactor);
 BA.debugLineNum = 812;BA.debugLine="Sub AdjustFontSizeToHeight(lbl As Label, fontScale";
Debug.ShouldStop(2048);
 BA.debugLineNum = 813;BA.debugLine="Dim fontSize As Float = lbl.Height * fontScaleFac";
Debug.ShouldStop(4096);
_fontsize = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_lbl.runMethod(true,"getHeight"),_fontscalefactor,_getdevicedensity()}, "*/",0, 0));Debug.locals.put("fontSize", _fontsize);Debug.locals.put("fontSize", _fontsize);
 BA.debugLineNum = 814;BA.debugLine="lbl.TextSize = fontSize ' Apply the size directly";
Debug.ShouldStop(8192);
_lbl.runMethod(true,"setTextSize",_fontsize);
 BA.debugLineNum = 815;BA.debugLine="Return fontSize";
Debug.ShouldStop(16384);
if (true) return _fontsize;
 BA.debugLineNum = 816;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _defbtn_click() throws Exception{
try {
		Debug.PushSubsStack("defBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,563);
if (RapidSub.canDelegate("defbtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","defbtn_click");}
 BA.debugLineNum = 563;BA.debugLine="Sub defBtn_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 564;BA.debugLine="sortDefaultValue = \"\"";
Debug.ShouldStop(524288);
main.mostCurrent._sortdefaultvalue = BA.ObjectToString("");
 BA.debugLineNum = 565;BA.debugLine="Log(\"Default sorting applied\")";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2851970",RemoteObject.createImmutable("Default sorting applied"),0);
 BA.debugLineNum = 566;BA.debugLine="LoadGraphDataDefault";
Debug.ShouldStop(2097152);
_loadgraphdatadefault();
 BA.debugLineNum = 567;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _defbtnpurchase_click() throws Exception{
try {
		Debug.PushSubsStack("defBtnPurchase_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,569);
if (RapidSub.canDelegate("defbtnpurchase_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","defbtnpurchase_click");}
 BA.debugLineNum = 569;BA.debugLine="Sub defBtnPurchase_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 570;BA.debugLine="sortDefaultValue = \"\"";
Debug.ShouldStop(33554432);
main.mostCurrent._sortdefaultvalue = BA.ObjectToString("");
 BA.debugLineNum = 571;BA.debugLine="Log(\"Default sorting applied for purchases\")";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2917506",RemoteObject.createImmutable("Default sorting applied for purchases"),0);
 BA.debugLineNum = 572;BA.debugLine="LoadGraphDataPurchase";
Debug.ShouldStop(134217728);
_loadgraphdatapurchase();
 BA.debugLineNum = 573;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getdevicedensity() throws Exception{
try {
		Debug.PushSubsStack("GetDeviceDensity (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,818);
if (RapidSub.canDelegate("getdevicedensity")) { return b4a.example.main.remoteMe.runUserSub(false, "main","getdevicedensity");}
RemoteObject _pixelwidth = RemoteObject.createImmutable(0);
RemoteObject _dipwidth = RemoteObject.createImmutable(0);
 BA.debugLineNum = 818;BA.debugLine="Sub GetDeviceDensity As Float";
Debug.ShouldStop(131072);
 BA.debugLineNum = 819;BA.debugLine="Dim pixelWidth As Int = 100%x";
Debug.ShouldStop(262144);
_pixelwidth = main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA);Debug.locals.put("pixelWidth", _pixelwidth);Debug.locals.put("pixelWidth", _pixelwidth);
 BA.debugLineNum = 820;BA.debugLine="Dim dipWidth As Int = 100dip";
Debug.ShouldStop(524288);
_dipwidth = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)));Debug.locals.put("dipWidth", _dipwidth);Debug.locals.put("dipWidth", _dipwidth);
 BA.debugLineNum = 821;BA.debugLine="Return pixelWidth / dipWidth";
Debug.ShouldStop(1048576);
if (true) return BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_pixelwidth,_dipwidth}, "/",0, 0));
 BA.debugLineNum = 822;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Private ScrollView1 As ScrollView";
main.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim PHPURL As String = \"https://192.168.8.117/Com";
main.mostCurrent._phpurl = BA.ObjectToString("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page=1");
 //BA.debugLineNum = 22;BA.debugLine="Dim primaryFontSize As Int = 1.4%y";
main._primaryfontsize = main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1.4)),main.mostCurrent.activityBA);
 //BA.debugLineNum = 23;BA.debugLine="Dim secondaryFontSize As Int = 1%y";
main._secondaryfontsize = main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1)),main.mostCurrent.activityBA);
 //BA.debugLineNum = 24;BA.debugLine="Private Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private Label1 As Label";
main.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private Panel2 As Panel";
main.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim barGraph As barGraph ' Corrected casing";
main.mostCurrent._bargraph = RemoteObject.createNew ("b4a.example.bargraph");
 //BA.debugLineNum = 28;BA.debugLine="Dim barGraphPurchase As barGraph ' Renamed for co";
main.mostCurrent._bargraphpurchase = RemoteObject.createNew ("b4a.example.bargraph");
 //BA.debugLineNum = 29;BA.debugLine="Dim purchasePanel As Panel";
main.mostCurrent._purchasepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim barPanel As Panel";
main.mostCurrent._barpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim saleNxtBtn As Button";
main.mostCurrent._salenxtbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Dim saleBackBtn As Button";
main.mostCurrent._salebackbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Dim purchNxtBtn As Button";
main.mostCurrent._purchnxtbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Dim purchBackBtn As Button";
main.mostCurrent._purchbackbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Dim sortBtnPurchase1 As RadioButton";
main.mostCurrent._sortbtnpurchase1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Dim sortBtnPurchase2 As RadioButton";
main.mostCurrent._sortbtnpurchase2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Dim sortBtn1 As RadioButton";
main.mostCurrent._sortbtn1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Public defBtn As RadioButton";
main.mostCurrent._defbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Public sortBtn2 As RadioButton";
main.mostCurrent._sortbtn2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Public sales1btn As RadioButton";
main.mostCurrent._sales1btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Public sales2btn As RadioButton";
main.mostCurrent._sales2btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Public sales3btn As RadioButton";
main.mostCurrent._sales3btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Public defBtnPurchase As RadioButton ' Added for";
main.mostCurrent._defbtnpurchase = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Public purch1btn As RadioButton ' Added for purch";
main.mostCurrent._purch1btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Public purch2btn As RadioButton";
main.mostCurrent._purch2btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Public purch3btn As RadioButton";
main.mostCurrent._purch3btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Public showDetailButton As Button";
main.mostCurrent._showdetailbutton = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Public legend() As String = Array As String(\"Sale";
main.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Sales1"),BA.ObjectToString("Sales2"),RemoteObject.createImmutable("Sales3")});
 //BA.debugLineNum = 49;BA.debugLine="Public legendPurchase() As String = Array As Stri";
main.mostCurrent._legendpurchase = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Purchase1"),BA.ObjectToString("Purchase2"),RemoteObject.createImmutable("Purchase3")});
 //BA.debugLineNum = 50;BA.debugLine="Dim height As Int = 0";
main._height = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 51;BA.debugLine="Dim companyPanel As Panel";
main.mostCurrent._companypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Dim totalGraphDataHeight As Int = 0";
main._totalgraphdataheight = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 53;BA.debugLine="Dim totalGetDataHeight As Int = 0";
main._totalgetdataheight = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 54;BA.debugLine="Dim sortDefaultValue As String = \"\"";
main.mostCurrent._sortdefaultvalue = BA.ObjectToString("");
 //BA.debugLineNum = 55;BA.debugLine="Dim salesData1 As Int = 1";
main._salesdata1 = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 56;BA.debugLine="Dim currentPage As Int = 1";
main._currentpage = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 57;BA.debugLine="Dim barGraphInitialized As Boolean = False";
main._bargraphinitialized = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 58;BA.debugLine="Dim barGraphInitializedPurchase As Boolean = Fals";
main._bargraphinitializedpurchase = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 59;BA.debugLine="Dim PHPURLCompany As String = $\"https://192.168.8";
main.mostCurrent._phpurlcompany = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._currentpage))),RemoteObject.createImmutable("&company_sales="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._salesdata1))),RemoteObject.createImmutable("&company_type="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable("")));
 //BA.debugLineNum = 60;BA.debugLine="Dim PHPURLDefault As String";
main.mostCurrent._phpurldefault = RemoteObject.createImmutable("");
 //BA.debugLineNum = 61;BA.debugLine="Dim calculatedSize As Float = 0";
main._calculatedsize = BA.numberCast(float.class, 0);
 //BA.debugLineNum = 62;BA.debugLine="Dim topPositionSale As Int = 0";
main._toppositionsale = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 63;BA.debugLine="Dim topPositionPurch As Int = 0";
main._toppositionpurch = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 64;BA.debugLine="Dim dashPanel As Panel";
main.mostCurrent._dashpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,163);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.main.remoteMe.runUserSub(false, "main","jobdone", _job);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _getdataheight = RemoteObject.createImmutable(0);
RemoteObject _getcompanysalesheight = RemoteObject.createImmutable(0);
RemoteObject _getcompanypurchaseheight = RemoteObject.createImmutable(0);
RemoteObject _salesarray = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _totalcompanies = RemoteObject.createImmutable(0);
RemoteObject _sales = null;
RemoteObject _comid = null;
RemoteObject _sales1 = null;
RemoteObject _sales2 = null;
RemoteObject _purchase = null;
RemoteObject _purchase1 = null;
RemoteObject _purchase2 = null;
RemoteObject _companyname = null;
RemoteObject _max_value = null;
RemoteObject _maxsale = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _record = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _totalsalepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _myimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _imgview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _totalsalelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalpurchasepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _totalpurchaselabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _padding = RemoteObject.createImmutable(0);
RemoteObject _count = RemoteObject.createImmutable(0);
RemoteObject _rownum = RemoteObject.createImmutable(0);
RemoteObject _mainpanelwidth = RemoteObject.createImmutable(0);
RemoteObject _panelheight = RemoteObject.createImmutable(0);
RemoteObject _col = RemoteObject.createImmutable(0);
RemoteObject _row = RemoteObject.createImmutable(0);
RemoteObject _name = RemoteObject.createImmutable("");
RemoteObject _company_id = RemoteObject.createImmutable(0);
RemoteObject _total_count = RemoteObject.createImmutable(0);
RemoteObject _total_pos = RemoteObject.createImmutable(0);
RemoteObject _panel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _paneltitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _label17 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _resizedimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _panelwidth = RemoteObject.createImmutable(0);
RemoteObject _labelheight = RemoteObject.createImmutable(0);
RemoteObject _totalstore = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalstorelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalpos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalposlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
Debug.locals.put("job", _job);
 BA.debugLineNum = 163;BA.debugLine="Sub JobDone(job As HttpJob)";
Debug.ShouldStop(4);
 BA.debugLineNum = 164;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 165;BA.debugLine="If job.Success Then";
Debug.ShouldStop(16);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 166;BA.debugLine="Try";
Debug.ShouldStop(32);
try { BA.debugLineNum = 167;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(64);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 168;BA.debugLine="parser.Initialize(job.GetString)";
Debug.ShouldStop(128);
_parser.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 169;BA.debugLine="Dim getDataHeight As Int = 0";
Debug.ShouldStop(256);
_getdataheight = BA.numberCast(int.class, 0);Debug.locals.put("getDataHeight", _getdataheight);Debug.locals.put("getDataHeight", _getdataheight);
 BA.debugLineNum = 170;BA.debugLine="Dim GetCompanySalesHeight As Int = 0";
Debug.ShouldStop(512);
_getcompanysalesheight = BA.numberCast(int.class, 0);Debug.locals.put("GetCompanySalesHeight", _getcompanysalesheight);Debug.locals.put("GetCompanySalesHeight", _getcompanysalesheight);
 BA.debugLineNum = 171;BA.debugLine="Dim GetCompanyPurchaseHeight As Int = 0";
Debug.ShouldStop(1024);
_getcompanypurchaseheight = BA.numberCast(int.class, 0);Debug.locals.put("GetCompanyPurchaseHeight", _getcompanypurchaseheight);Debug.locals.put("GetCompanyPurchaseHeight", _getcompanypurchaseheight);
 BA.debugLineNum = 173;BA.debugLine="Select Case job.JobName";
Debug.ShouldStop(4096);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("GetCompany"),BA.ObjectToString("GetCompanyPurchase"),BA.ObjectToString("GetData"),BA.ObjectToString("UpdateData"))) {
case 0: {
 BA.debugLineNum = 175;BA.debugLine="Dim salesArray As List = parser.NextArray";
Debug.ShouldStop(16384);
_salesarray = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_salesarray = _parser.runMethod(false,"NextArray");Debug.locals.put("salesArray", _salesarray);Debug.locals.put("salesArray", _salesarray);
 BA.debugLineNum = 176;BA.debugLine="If salesArray.Size = 0 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_salesarray.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 177;BA.debugLine="ToastMessageShow(\"No data received\", True)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No data received")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 178;BA.debugLine="Return";
Debug.ShouldStop(131072);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 181;BA.debugLine="Dim totalCompanies As Int = salesArray.Size";
Debug.ShouldStop(1048576);
_totalcompanies = _salesarray.runMethod(true,"getSize");Debug.locals.put("totalCompanies", _totalcompanies);Debug.locals.put("totalCompanies", _totalcompanies);
 BA.debugLineNum = 182;BA.debugLine="Dim sales(totalCompanies) As Int";
Debug.ShouldStop(2097152);
_sales = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales", _sales);
 BA.debugLineNum = 183;BA.debugLine="Dim comId(totalCompanies) As Int";
Debug.ShouldStop(4194304);
_comid = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("comId", _comid);
 BA.debugLineNum = 184;BA.debugLine="Dim sales1(totalCompanies) As Int";
Debug.ShouldStop(8388608);
_sales1 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales1", _sales1);
 BA.debugLineNum = 185;BA.debugLine="Dim sales2(totalCompanies) As Int";
Debug.ShouldStop(16777216);
_sales2 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales2", _sales2);
 BA.debugLineNum = 186;BA.debugLine="Dim purchase(totalCompanies) As Int";
Debug.ShouldStop(33554432);
_purchase = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase", _purchase);
 BA.debugLineNum = 187;BA.debugLine="Dim purchase1(totalCompanies) As Int";
Debug.ShouldStop(67108864);
_purchase1 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase1", _purchase1);
 BA.debugLineNum = 188;BA.debugLine="Dim purchase2(totalCompanies) As Int";
Debug.ShouldStop(134217728);
_purchase2 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase2", _purchase2);
 BA.debugLineNum = 189;BA.debugLine="Dim companyName(totalCompanies) As String";
Debug.ShouldStop(268435456);
_companyname = RemoteObject.createNewArray ("String", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("companyName", _companyname);
 BA.debugLineNum = 190;BA.debugLine="Dim max_value(totalCompanies) As Int";
Debug.ShouldStop(536870912);
_max_value = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("max_value", _max_value);
 BA.debugLineNum = 191;BA.debugLine="Dim maxSale As Int = 0";
Debug.ShouldStop(1073741824);
_maxsale = BA.numberCast(int.class, 0);Debug.locals.put("maxSale", _maxsale);Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 193;BA.debugLine="For i = 0 To totalCompanies - 1";
Debug.ShouldStop(1);
{
final int step27 = 1;
final int limit27 = RemoteObject.solve(new RemoteObject[] {_totalcompanies,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step27 > 0 && _i <= limit27) || (step27 < 0 && _i >= limit27) ;_i = ((int)(0 + _i + step27))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 194;BA.debugLine="Dim record As Map = salesArray.Get(i)";
Debug.ShouldStop(2);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _salesarray.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("record", _record);Debug.locals.put("record", _record);
 BA.debugLineNum = 195;BA.debugLine="companyName(i) = record.GetDefault(\"company_";
Debug.ShouldStop(4);
_companyname.setArrayElement (BA.ObjectToString(_record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("company_name"))),(Object)((RemoteObject.createImmutable("Unknown"))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 196;BA.debugLine="comId(i) = record.GetDefault(\"company_id\", 0";
Debug.ShouldStop(8);
_comid.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("company_id"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 197;BA.debugLine="sales(i) = record.GetDefault(\"sales_1\", 0)";
Debug.ShouldStop(16);
_sales.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_1"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 198;BA.debugLine="sales1(i) = record.GetDefault(\"sales_2\", 0)";
Debug.ShouldStop(32);
_sales1.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_2"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 199;BA.debugLine="sales2(i) = record.GetDefault(\"sales_3\", 0)";
Debug.ShouldStop(64);
_sales2.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_3"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 200;BA.debugLine="purchase(i) = record.GetDefault(\"purchase_1\"";
Debug.ShouldStop(128);
_purchase.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_1"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 201;BA.debugLine="purchase1(i) = record.GetDefault(\"purchase_2";
Debug.ShouldStop(256);
_purchase1.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_2"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 202;BA.debugLine="purchase2(i) = record.GetDefault(\"purchase_3";
Debug.ShouldStop(512);
_purchase2.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_3"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 203;BA.debugLine="max_value(i) = record.GetDefault(\"max_sales\"";
Debug.ShouldStop(1024);
_max_value.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("max_sales"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 204;BA.debugLine="maxSale = Max(maxSale, max_value(i))";
Debug.ShouldStop(2048);
_maxsale = BA.numberCast(int.class, main.mostCurrent.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, _maxsale)),(Object)(BA.numberCast(double.class, _max_value.getArrayElement(true,BA.numberCast(int.class, _i))))));Debug.locals.put("maxSale", _maxsale);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 207;BA.debugLine="Dim totalSalePanel As Panel";
Debug.ShouldStop(16384);
_totalsalepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("totalSalePanel", _totalsalepanel);
 BA.debugLineNum = 208;BA.debugLine="totalSalePanel.Initialize(\"\")";
Debug.ShouldStop(32768);
_totalsalepanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 209;BA.debugLine="totalSalePanel.Height = 40dip";
Debug.ShouldStop(65536);
_totalsalepanel.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40))));
 BA.debugLineNum = 210;BA.debugLine="barPanel.Height = 530dip";
Debug.ShouldStop(131072);
main.mostCurrent._barpanel.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 530))));
 BA.debugLineNum = 211;BA.debugLine="GetCompanySalesHeight = Panel2.Height + dashP";
Debug.ShouldStop(262144);
_getcompanysalesheight = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._panel2.runMethod(true,"getHeight"),main.mostCurrent._dashpanel.runMethod(true,"getHeight")}, "+",1, 1);Debug.locals.put("GetCompanySalesHeight", _getcompanysalesheight);
 BA.debugLineNum = 212;BA.debugLine="If Not(barGraphInitialized) Then";
Debug.ShouldStop(524288);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(main._bargraphinitialized)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 213;BA.debugLine="saleNxtBtn.Initialize(\"nxtBtn\")";
Debug.ShouldStop(1048576);
main.mostCurrent._salenxtbtn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("nxtBtn")));
 BA.debugLineNum = 214;BA.debugLine="saleBackBtn.Initialize(\"backbtn\")";
Debug.ShouldStop(2097152);
main.mostCurrent._salebackbtn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("backbtn")));
 BA.debugLineNum = 215;BA.debugLine="sortBtn1.Initialize(\"sortBtn1\")";
Debug.ShouldStop(4194304);
main.mostCurrent._sortbtn1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtn1")));
 BA.debugLineNum = 216;BA.debugLine="sortBtn2.Initialize(\"sortBtn2\")";
Debug.ShouldStop(8388608);
main.mostCurrent._sortbtn2.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtn2")));
 BA.debugLineNum = 217;BA.debugLine="defBtn.Initialize(\"defBtn\")";
Debug.ShouldStop(16777216);
main.mostCurrent._defbtn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("defBtn")));
 BA.debugLineNum = 218;BA.debugLine="sales1btn.Initialize(\"sales1btn\")";
Debug.ShouldStop(33554432);
main.mostCurrent._sales1btn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales1btn")));
 BA.debugLineNum = 219;BA.debugLine="sales2btn.Initialize(\"sales2btn\")";
Debug.ShouldStop(67108864);
main.mostCurrent._sales2btn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales2btn")));
 BA.debugLineNum = 220;BA.debugLine="sales3btn.Initialize(\"sales3btn\")";
Debug.ShouldStop(134217728);
main.mostCurrent._sales3btn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales3btn")));
 BA.debugLineNum = 221;BA.debugLine="showDetailButton.Initialize(\"showDetailButto";
Debug.ShouldStop(268435456);
main.mostCurrent._showdetailbutton.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("showDetailButton")));
 BA.debugLineNum = 224;BA.debugLine="ScrollView1.Panel.AddView(totalSalePanel, 5d";
Debug.ShouldStop(-2147483648);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_totalsalepanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(_getcompanysalesheight),(Object)(main.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(_totalsalepanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 226;BA.debugLine="Dim myImage As Bitmap = LoadBitmap(File.DirA";
Debug.ShouldStop(2);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_myimage = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("stock.png")));Debug.locals.put("myImage", _myimage);Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 227;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(4);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 228;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(8);
_imgview.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 229;BA.debugLine="imgView.Gravity = Gravity.FILL";
Debug.ShouldStop(16);
_imgview.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 230;BA.debugLine="imgView.Bitmap = myImage";
Debug.ShouldStop(32);
_imgview.runMethod(false,"setBitmap",(_myimage.getObject()));
 BA.debugLineNum = 231;BA.debugLine="totalSalePanel.AddView(imgView, 0dip, 12.5di";
Debug.ShouldStop(64);
_totalsalepanel.runVoidMethod ("AddView",(Object)((_imgview.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12.5)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(RemoteObject.solve(new RemoteObject[] {_totalsalepanel.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))}, "-",1, 1)));
 BA.debugLineNum = 233;BA.debugLine="Dim totalSaleLabel As Label";
Debug.ShouldStop(256);
_totalsalelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalSaleLabel", _totalsalelabel);
 BA.debugLineNum = 234;BA.debugLine="totalSaleLabel.Initialize(\"\")";
Debug.ShouldStop(512);
_totalsalelabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 235;BA.debugLine="totalSaleLabel.Text = \"Total Sales\"";
Debug.ShouldStop(1024);
_totalsalelabel.runMethod(true,"setText",BA.ObjectToCharSequence("Total Sales"));
 BA.debugLineNum = 236;BA.debugLine="totalSaleLabel.TextColor = Colors.Black";
Debug.ShouldStop(2048);
_totalsalelabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 237;BA.debugLine="totalSaleLabel.Gravity = Gravity.CENTER_VERT";
Debug.ShouldStop(4096);
_totalsalelabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 238;BA.debugLine="totalSaleLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(8192);
_totalsalelabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 239;BA.debugLine="totalSalePanel.AddView(totalSaleLabel, imgVi";
Debug.ShouldStop(16384);
_totalsalepanel.runVoidMethod ("AddView",(Object)((_totalsalelabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_imgview.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 240;BA.debugLine="AdjustFontSizeToHeight(totalSaleLabel, 2)";
Debug.ShouldStop(32768);
_adjustfontsizetoheight(_totalsalelabel,BA.numberCast(float.class, 2));
 BA.debugLineNum = 242;BA.debugLine="topPositionSale = topPositionSale + totalSal";
Debug.ShouldStop(131072);
main._toppositionsale = RemoteObject.solve(new RemoteObject[] {main._toppositionsale,_totalsalepanel.runMethod(true,"getHeight")}, "+",1, 1);
 BA.debugLineNum = 243;BA.debugLine="GetCompanySalesHeight = GetCompanySalesHeigh";
Debug.ShouldStop(262144);
_getcompanysalesheight = RemoteObject.solve(new RemoteObject[] {_getcompanysalesheight,_totalsalepanel.runMethod(true,"getHeight")}, "+",1, 1);Debug.locals.put("GetCompanySalesHeight", _getcompanysalesheight);
 BA.debugLineNum = 244;BA.debugLine="ScrollView1.Panel.AddView(barPanel, 25dip, G";
Debug.ShouldStop(524288);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((main.mostCurrent._barpanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(_getcompanysalesheight),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(main.mostCurrent._barpanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 245;BA.debugLine="barPanel.Color = Colors.White";
Debug.ShouldStop(1048576);
main.mostCurrent._barpanel.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 246;BA.debugLine="barPanel.RemoveAllViews";
Debug.ShouldStop(2097152);
main.mostCurrent._barpanel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 247;BA.debugLine="barPanel.Invalidate";
Debug.ShouldStop(4194304);
main.mostCurrent._barpanel.runVoidMethod ("Invalidate");
 BA.debugLineNum = 249;BA.debugLine="GetCompanyPurchaseHeight = GetCompanySalesHe";
Debug.ShouldStop(16777216);
_getcompanypurchaseheight = RemoteObject.solve(new RemoteObject[] {_getcompanysalesheight,main.mostCurrent._barpanel.runMethod(true,"getHeight")}, "+",1, 1);Debug.locals.put("GetCompanyPurchaseHeight", _getcompanypurchaseheight);
 BA.debugLineNum = 250;BA.debugLine="Log($\"GetCompanyPurchaseHeight:${GetCompanyP";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2393303",(RemoteObject.concat(RemoteObject.createImmutable("GetCompanyPurchaseHeight:"),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_getcompanypurchaseheight))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 251;BA.debugLine="barGraph.Initialize(Activity, barPanel, sale";
Debug.ShouldStop(67108864);
main.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._activity),(Object)(main.mostCurrent._barpanel),(Object)(_sales),(Object)(_sales1),(Object)(_sales2),(Object)(_companyname),(Object)(main.mostCurrent._legend),(Object)(_maxsale),(Object)(BA.ObjectToString("Total Sale of the Company")),(Object)(_comid),(Object)(BA.ObjectToString("Branch")),(Object)(main.mostCurrent._salenxtbtn),(Object)(main.mostCurrent._salebackbtn),(Object)(main.mostCurrent._sortbtn1),(Object)(main.mostCurrent._sortbtn2),(Object)(main.mostCurrent._defbtn),(Object)(main.mostCurrent._sales1btn),(Object)(main.mostCurrent._sales2btn),(Object)(main.mostCurrent._sales3btn),(Object)(main.mostCurrent._showdetailbutton));
 BA.debugLineNum = 252;BA.debugLine="barGraphInitialized = True";
Debug.ShouldStop(134217728);
main._bargraphinitialized = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 253;BA.debugLine="topPositionSale = topPositionSale + barPanel";
Debug.ShouldStop(268435456);
main._toppositionsale = RemoteObject.solve(new RemoteObject[] {main._toppositionsale,main.mostCurrent._barpanel.runMethod(true,"getHeight")}, "+",1, 1);
 BA.debugLineNum = 254;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 }else {
 BA.debugLineNum = 256;BA.debugLine="barGraph.sale_1 = sales";
Debug.ShouldStop(-2147483648);
main.mostCurrent._bargraph.setField ("_sale_1" /*RemoteObject*/ ,_sales);
 BA.debugLineNum = 257;BA.debugLine="barGraph.sale_2 = sales1";
Debug.ShouldStop(1);
main.mostCurrent._bargraph.setField ("_sale_2" /*RemoteObject*/ ,_sales1);
 BA.debugLineNum = 258;BA.debugLine="barGraph.sale_3 = sales2";
Debug.ShouldStop(2);
main.mostCurrent._bargraph.setField ("_sale_3" /*RemoteObject*/ ,_sales2);
 BA.debugLineNum = 259;BA.debugLine="barGraph.product1 = companyName";
Debug.ShouldStop(4);
main.mostCurrent._bargraph.setField ("_product1" /*RemoteObject*/ ,_companyname);
 BA.debugLineNum = 260;BA.debugLine="barGraph.comId1 = comId ' Corrected to use c";
Debug.ShouldStop(8);
main.mostCurrent._bargraph.setField ("_comid1" /*RemoteObject*/ ,_comid);
 BA.debugLineNum = 261;BA.debugLine="barGraph.UpdateGraph";
Debug.ShouldStop(16);
main.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_updategraph" /*RemoteObject*/ );
 };
 BA.debugLineNum = 263;BA.debugLine="GetCompanySalesHeight = Panel2.Height + dashP";
Debug.ShouldStop(64);
_getcompanysalesheight = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._panel2.runMethod(true,"getHeight"),main.mostCurrent._dashpanel.runMethod(true,"getHeight"),_totalsalepanel.runMethod(true,"getHeight"),main.mostCurrent._barpanel.runMethod(true,"getHeight")}, "+++",3, 1);Debug.locals.put("GetCompanySalesHeight", _getcompanysalesheight);
 BA.debugLineNum = 264;BA.debugLine="topPositionSale = GetCompanySalesHeight";
Debug.ShouldStop(128);
main._toppositionsale = _getcompanysalesheight;
 BA.debugLineNum = 265;BA.debugLine="GetCompanyPurchaseHeight = GetCompanySalesHei";
Debug.ShouldStop(256);
_getcompanypurchaseheight = _getcompanysalesheight;Debug.locals.put("GetCompanyPurchaseHeight", _getcompanypurchaseheight);
 BA.debugLineNum = 266;BA.debugLine="Log($\"GetCompanyPurchaseHeight:${GetCompanyPu";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2393319",(RemoteObject.concat(RemoteObject.createImmutable("GetCompanyPurchaseHeight:"),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_getcompanypurchaseheight))),RemoteObject.createImmutable(""))),0);
 break; }
case 1: {
 BA.debugLineNum = 268;BA.debugLine="Log($\"topPositionSale:${topPositionSale}\"$)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2393321",(RemoteObject.concat(RemoteObject.createImmutable("topPositionSale:"),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._toppositionsale))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 269;BA.debugLine="Dim salesArray As List = parser.NextArray";
Debug.ShouldStop(4096);
_salesarray = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_salesarray = _parser.runMethod(false,"NextArray");Debug.locals.put("salesArray", _salesarray);Debug.locals.put("salesArray", _salesarray);
 BA.debugLineNum = 270;BA.debugLine="If salesArray.Size = 0 Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_salesarray.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 271;BA.debugLine="ToastMessageShow(\"No data received\", True)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No data received")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 272;BA.debugLine="Return";
Debug.ShouldStop(32768);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 274;BA.debugLine="Dim totalCompanies As Int = salesArray.Size";
Debug.ShouldStop(131072);
_totalcompanies = _salesarray.runMethod(true,"getSize");Debug.locals.put("totalCompanies", _totalcompanies);Debug.locals.put("totalCompanies", _totalcompanies);
 BA.debugLineNum = 275;BA.debugLine="Dim purchase(totalCompanies) As Int";
Debug.ShouldStop(262144);
_purchase = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase", _purchase);
 BA.debugLineNum = 276;BA.debugLine="Dim purchase1(totalCompanies) As Int";
Debug.ShouldStop(524288);
_purchase1 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase1", _purchase1);
 BA.debugLineNum = 277;BA.debugLine="Dim purchase2(totalCompanies) As Int";
Debug.ShouldStop(1048576);
_purchase2 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase2", _purchase2);
 BA.debugLineNum = 278;BA.debugLine="Dim companyName(totalCompanies) As String";
Debug.ShouldStop(2097152);
_companyname = RemoteObject.createNewArray ("String", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("companyName", _companyname);
 BA.debugLineNum = 279;BA.debugLine="Dim comId(totalCompanies) As Int";
Debug.ShouldStop(4194304);
_comid = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("comId", _comid);
 BA.debugLineNum = 280;BA.debugLine="Dim maxSale As Int = 0";
Debug.ShouldStop(8388608);
_maxsale = BA.numberCast(int.class, 0);Debug.locals.put("maxSale", _maxsale);Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 282;BA.debugLine="For i = 0 To totalCompanies - 1";
Debug.ShouldStop(33554432);
{
final int step108 = 1;
final int limit108 = RemoteObject.solve(new RemoteObject[] {_totalcompanies,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step108 > 0 && _i <= limit108) || (step108 < 0 && _i >= limit108) ;_i = ((int)(0 + _i + step108))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 283;BA.debugLine="Dim record As Map = salesArray.Get(i)";
Debug.ShouldStop(67108864);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _salesarray.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("record", _record);Debug.locals.put("record", _record);
 BA.debugLineNum = 284;BA.debugLine="companyName(i) = record.GetDefault(\"company_";
Debug.ShouldStop(134217728);
_companyname.setArrayElement (BA.ObjectToString(_record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("company_name"))),(Object)((RemoteObject.createImmutable("Unknown"))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 285;BA.debugLine="comId(i) = record.GetDefault(\"company_id\", 0";
Debug.ShouldStop(268435456);
_comid.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("company_id"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 286;BA.debugLine="purchase(i) = record.GetDefault(\"purchase_1\"";
Debug.ShouldStop(536870912);
_purchase.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_1"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 287;BA.debugLine="purchase1(i) = record.GetDefault(\"purchase_2";
Debug.ShouldStop(1073741824);
_purchase1.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_2"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 288;BA.debugLine="purchase2(i) = record.GetDefault(\"purchase_3";
Debug.ShouldStop(-2147483648);
_purchase2.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_3"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 289;BA.debugLine="maxSale = Max(maxSale, record.GetDefault(\"ma";
Debug.ShouldStop(1);
_maxsale = BA.numberCast(int.class, main.mostCurrent.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, _maxsale)),(Object)(BA.numberCast(double.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("max_sales"))),(Object)(RemoteObject.createImmutable((0))))))));Debug.locals.put("maxSale", _maxsale);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 292;BA.debugLine="Dim totalPurchasePanel As Panel";
Debug.ShouldStop(8);
_totalpurchasepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("totalPurchasePanel", _totalpurchasepanel);
 BA.debugLineNum = 293;BA.debugLine="totalPurchasePanel.Initialize(\"\")";
Debug.ShouldStop(16);
_totalpurchasepanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 294;BA.debugLine="purchasePanel.Height = 450dip";
Debug.ShouldStop(32);
main.mostCurrent._purchasepanel.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 450))));
 BA.debugLineNum = 295;BA.debugLine="totalPurchasePanel.Height = 40dip";
Debug.ShouldStop(64);
_totalpurchasepanel.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40))));
 BA.debugLineNum = 296;BA.debugLine="GetCompanyPurchaseHeight = 900";
Debug.ShouldStop(128);
_getcompanypurchaseheight = BA.numberCast(int.class, 900);Debug.locals.put("GetCompanyPurchaseHeight", _getcompanypurchaseheight);
 BA.debugLineNum = 297;BA.debugLine="If barGraphInitializedPurchase = False Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",main._bargraphinitializedpurchase,main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 298;BA.debugLine="purchNxtBtn.Initialize(\"purchNxtBtn\")";
Debug.ShouldStop(512);
main.mostCurrent._purchnxtbtn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("purchNxtBtn")));
 BA.debugLineNum = 299;BA.debugLine="purchBackBtn.Initialize(\"purchBackBtn\")";
Debug.ShouldStop(1024);
main.mostCurrent._purchbackbtn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("purchBackBtn")));
 BA.debugLineNum = 300;BA.debugLine="sortBtnPurchase1.Initialize(\"sortBtnPurchase";
Debug.ShouldStop(2048);
main.mostCurrent._sortbtnpurchase1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtnPurchase1")));
 BA.debugLineNum = 301;BA.debugLine="sortBtnPurchase2.Initialize(\"sortBtnPurchase";
Debug.ShouldStop(4096);
main.mostCurrent._sortbtnpurchase2.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtnPurchase2")));
 BA.debugLineNum = 302;BA.debugLine="defBtnPurchase.Initialize(\"defBtnPurchase\")";
Debug.ShouldStop(8192);
main.mostCurrent._defbtnpurchase.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("defBtnPurchase")));
 BA.debugLineNum = 303;BA.debugLine="purch1btn.Initialize(\"purch1btn\")";
Debug.ShouldStop(16384);
main.mostCurrent._purch1btn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("purch1btn")));
 BA.debugLineNum = 304;BA.debugLine="purch2btn.Initialize(\"purch2btn\")";
Debug.ShouldStop(32768);
main.mostCurrent._purch2btn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("purch2btn")));
 BA.debugLineNum = 305;BA.debugLine="purch3btn.Initialize(\"purch3btn\")";
Debug.ShouldStop(65536);
main.mostCurrent._purch3btn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("purch3btn")));
 BA.debugLineNum = 306;BA.debugLine="showDetailButton.Initialize(\"showDetailButto";
Debug.ShouldStop(131072);
main.mostCurrent._showdetailbutton.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("showDetailButton")));
 BA.debugLineNum = 308;BA.debugLine="ScrollView1.Panel.AddView(totalPurchasePanel";
Debug.ShouldStop(524288);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_totalpurchasepanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(_getcompanypurchaseheight),(Object)(main.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(_totalpurchasepanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 310;BA.debugLine="Dim myImage As Bitmap = LoadBitmap(File.DirA";
Debug.ShouldStop(2097152);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_myimage = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("stock.png")));Debug.locals.put("myImage", _myimage);Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 311;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(4194304);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 312;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(8388608);
_imgview.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 313;BA.debugLine="imgView.Gravity = Gravity.FILL";
Debug.ShouldStop(16777216);
_imgview.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 314;BA.debugLine="imgView.Bitmap = myImage";
Debug.ShouldStop(33554432);
_imgview.runMethod(false,"setBitmap",(_myimage.getObject()));
 BA.debugLineNum = 315;BA.debugLine="totalPurchasePanel.AddView(imgView, 0dip, 12";
Debug.ShouldStop(67108864);
_totalpurchasepanel.runVoidMethod ("AddView",(Object)((_imgview.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12.5)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(RemoteObject.solve(new RemoteObject[] {_totalpurchasepanel.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))}, "-",1, 1)));
 BA.debugLineNum = 317;BA.debugLine="Dim totalPurchaseLabel As Label";
Debug.ShouldStop(268435456);
_totalpurchaselabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPurchaseLabel", _totalpurchaselabel);
 BA.debugLineNum = 318;BA.debugLine="totalPurchaseLabel.Initialize(\"\")";
Debug.ShouldStop(536870912);
_totalpurchaselabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 319;BA.debugLine="totalPurchaseLabel.Text = \"Total Purchases\"";
Debug.ShouldStop(1073741824);
_totalpurchaselabel.runMethod(true,"setText",BA.ObjectToCharSequence("Total Purchases"));
 BA.debugLineNum = 320;BA.debugLine="totalPurchaseLabel.TextColor = Colors.Black";
Debug.ShouldStop(-2147483648);
_totalpurchaselabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 321;BA.debugLine="totalPurchaseLabel.Gravity = Gravity.CENTER_";
Debug.ShouldStop(1);
_totalpurchaselabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 322;BA.debugLine="totalPurchaseLabel.Typeface = Typeface.MONOS";
Debug.ShouldStop(2);
_totalpurchaselabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 323;BA.debugLine="totalPurchasePanel.AddView(totalPurchaseLabe";
Debug.ShouldStop(4);
_totalpurchasepanel.runVoidMethod ("AddView",(Object)((_totalpurchaselabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_imgview.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(_totalpurchasepanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 324;BA.debugLine="AdjustFontSizeToHeight(totalPurchaseLabel, 2";
Debug.ShouldStop(8);
_adjustfontsizetoheight(_totalpurchaselabel,BA.numberCast(float.class, 2));
 BA.debugLineNum = 326;BA.debugLine="GetCompanyPurchaseHeight = GetCompanyPurchas";
Debug.ShouldStop(32);
_getcompanypurchaseheight = RemoteObject.solve(new RemoteObject[] {_getcompanypurchaseheight,_totalpurchasepanel.runMethod(true,"getHeight")}, "+",1, 1);Debug.locals.put("GetCompanyPurchaseHeight", _getcompanypurchaseheight);
 BA.debugLineNum = 327;BA.debugLine="ScrollView1.Panel.AddView(purchasePanel, 25d";
Debug.ShouldStop(64);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((main.mostCurrent._purchasepanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(_getcompanypurchaseheight),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(main.mostCurrent._purchasepanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 328;BA.debugLine="purchasePanel.Color = Colors.White";
Debug.ShouldStop(128);
main.mostCurrent._purchasepanel.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 329;BA.debugLine="purchasePanel.RemoveAllViews";
Debug.ShouldStop(256);
main.mostCurrent._purchasepanel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 330;BA.debugLine="purchasePanel.Invalidate";
Debug.ShouldStop(512);
main.mostCurrent._purchasepanel.runVoidMethod ("Invalidate");
 BA.debugLineNum = 332;BA.debugLine="barGraphPurchase.Initialize(Activity, purcha";
Debug.ShouldStop(2048);
main.mostCurrent._bargraphpurchase.runClassMethod (b4a.example.bargraph.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._activity),(Object)(main.mostCurrent._purchasepanel),(Object)(_purchase),(Object)(_purchase1),(Object)(_purchase2),(Object)(_companyname),(Object)(main.mostCurrent._legendpurchase),(Object)(_maxsale),(Object)(BA.ObjectToString("Total Purchase Per Company")),(Object)(_comid),(Object)(BA.ObjectToString("Branch")),(Object)(main.mostCurrent._purchnxtbtn),(Object)(main.mostCurrent._purchbackbtn),(Object)(main.mostCurrent._sortbtnpurchase1),(Object)(main.mostCurrent._sortbtnpurchase2),(Object)(main.mostCurrent._defbtnpurchase),(Object)(main.mostCurrent._purch1btn),(Object)(main.mostCurrent._purch2btn),(Object)(main.mostCurrent._purch3btn),(Object)(main.mostCurrent._showdetailbutton));
 BA.debugLineNum = 333;BA.debugLine="barGraphInitializedPurchase = True";
Debug.ShouldStop(4096);
main._bargraphinitializedpurchase = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 334;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 }else {
 BA.debugLineNum = 336;BA.debugLine="barGraphPurchase.sale_1 = purchase ' Adjuste";
Debug.ShouldStop(32768);
main.mostCurrent._bargraphpurchase.setField ("_sale_1" /*RemoteObject*/ ,_purchase);
 BA.debugLineNum = 337;BA.debugLine="barGraphPurchase.sale_2 = purchase1";
Debug.ShouldStop(65536);
main.mostCurrent._bargraphpurchase.setField ("_sale_2" /*RemoteObject*/ ,_purchase1);
 BA.debugLineNum = 338;BA.debugLine="barGraphPurchase.sale_3 = purchase2";
Debug.ShouldStop(131072);
main.mostCurrent._bargraphpurchase.setField ("_sale_3" /*RemoteObject*/ ,_purchase2);
 BA.debugLineNum = 339;BA.debugLine="barGraphPurchase.product1 = companyName";
Debug.ShouldStop(262144);
main.mostCurrent._bargraphpurchase.setField ("_product1" /*RemoteObject*/ ,_companyname);
 BA.debugLineNum = 340;BA.debugLine="barGraphPurchase.comId1 = comId ' Corrected";
Debug.ShouldStop(524288);
main.mostCurrent._bargraphpurchase.setField ("_comid1" /*RemoteObject*/ ,_comid);
 BA.debugLineNum = 341;BA.debugLine="barGraphPurchase.UpdateGraph";
Debug.ShouldStop(1048576);
main.mostCurrent._bargraphpurchase.runClassMethod (b4a.example.bargraph.class, "_updategraph" /*RemoteObject*/ );
 };
 BA.debugLineNum = 343;BA.debugLine="topPositionPurch = topPositionSale + totalPur";
Debug.ShouldStop(4194304);
main._toppositionpurch = RemoteObject.solve(new RemoteObject[] {main._toppositionsale,_totalpurchasepanel.runMethod(true,"getTop"),main.mostCurrent._purchasepanel.runMethod(true,"getHeight")}, "++",2, 1);
 BA.debugLineNum = 344;BA.debugLine="ScrollView1.Panel.Height = purchasePanel.top";
Debug.ShouldStop(8388608);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._purchasepanel.runMethod(true,"getTop"),main.mostCurrent._purchasepanel.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 360)))}, "++",2, 1));
 break; }
case 2: {
 BA.debugLineNum = 346;BA.debugLine="Dim salesArray As List = parser.NextArray";
Debug.ShouldStop(33554432);
_salesarray = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_salesarray = _parser.runMethod(false,"NextArray");Debug.locals.put("salesArray", _salesarray);Debug.locals.put("salesArray", _salesarray);
 BA.debugLineNum = 347;BA.debugLine="If salesArray.Size = 0 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_salesarray.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 348;BA.debugLine="ToastMessageShow(\"No data received\", True)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No data received")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 349;BA.debugLine="Return";
Debug.ShouldStop(268435456);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 351;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(1073741824);
_padding = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 352;BA.debugLine="Dim count As Int = 0";
Debug.ShouldStop(-2147483648);
_count = BA.numberCast(int.class, 0);Debug.locals.put("count", _count);Debug.locals.put("count", _count);
 BA.debugLineNum = 353;BA.debugLine="Dim rowNum As Int = 3";
Debug.ShouldStop(1);
_rownum = BA.numberCast(int.class, 3);Debug.locals.put("rowNum", _rownum);Debug.locals.put("rowNum", _rownum);
 BA.debugLineNum = 354;BA.debugLine="Dim mainPanelWidth As Int = 0";
Debug.ShouldStop(2);
_mainpanelwidth = BA.numberCast(int.class, 0);Debug.locals.put("mainPanelWidth", _mainpanelwidth);Debug.locals.put("mainPanelWidth", _mainpanelwidth);
 BA.debugLineNum = 355;BA.debugLine="Dim panelHeight As Int = 150dip";
Debug.ShouldStop(4);
_panelheight = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)));Debug.locals.put("panelHeight", _panelheight);Debug.locals.put("panelHeight", _panelheight);
 BA.debugLineNum = 356;BA.debugLine="height = panelHeight - 70dip";
Debug.ShouldStop(8);
main._height = RemoteObject.solve(new RemoteObject[] {_panelheight,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))}, "-",1, 1);
 BA.debugLineNum = 357;BA.debugLine="For Each record As Map In salesArray";
Debug.ShouldStop(16);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group177 = _salesarray;
final int groupLen177 = group177.runMethod(true,"getSize").<Integer>get()
;int index177 = 0;
;
for (; index177 < groupLen177;index177++){
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group177.runMethod(false,"Get",index177));Debug.locals.put("record", _record);
Debug.locals.put("record", _record);
 BA.debugLineNum = 358;BA.debugLine="If count Mod 3 = 0 Then height = height + pa";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(3)}, "%",0, 1),BA.numberCast(double.class, 0))) { 
main._height = RemoteObject.solve(new RemoteObject[] {main._height,_panelheight}, "+",1, 1);};
 BA.debugLineNum = 359;BA.debugLine="Dim col As Int = count Mod 3";
Debug.ShouldStop(64);
_col = RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(3)}, "%",0, 1);Debug.locals.put("col", _col);Debug.locals.put("col", _col);
 BA.debugLineNum = 360;BA.debugLine="Dim row As Int = Floor(count / 3)";
Debug.ShouldStop(128);
_row = BA.numberCast(int.class, main.mostCurrent.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(3)}, "/",0, 0))));Debug.locals.put("row", _row);Debug.locals.put("row", _row);
 BA.debugLineNum = 361;BA.debugLine="Dim name As String = record.Get(\"company_nam";
Debug.ShouldStop(256);
_name = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("company_name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 362;BA.debugLine="Dim company_id As Int = record.Get(\"company_";
Debug.ShouldStop(512);
_company_id = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("company_id")))));Debug.locals.put("company_id", _company_id);Debug.locals.put("company_id", _company_id);
 BA.debugLineNum = 363;BA.debugLine="Dim total_count As Int = record.Get(\"total_b";
Debug.ShouldStop(1024);
_total_count = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("total_branch_count")))));Debug.locals.put("total_count", _total_count);Debug.locals.put("total_count", _total_count);
 BA.debugLineNum = 364;BA.debugLine="Dim total_pos As Int = record.Get(\"totalDevi";
Debug.ShouldStop(2048);
_total_pos = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("totalDevices")))));Debug.locals.put("total_pos", _total_pos);Debug.locals.put("total_pos", _total_pos);
 BA.debugLineNum = 367;BA.debugLine="companyPanel.Initialize(\"Panel\")";
Debug.ShouldStop(16384);
main.mostCurrent._companypanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel")));
 BA.debugLineNum = 368;BA.debugLine="ScrollView1.Panel.AddView(companyPanel, 25di";
Debug.ShouldStop(32768);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((main.mostCurrent._companypanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(BA.numberCast(int.class, 1580)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(main._height));
 BA.debugLineNum = 370;BA.debugLine="mainPanelWidth = companyPanel.Width / rowNum";
Debug.ShouldStop(131072);
_mainpanelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._companypanel.runMethod(true,"getWidth"),_rownum}, "/",0, 0));Debug.locals.put("mainPanelWidth", _mainpanelwidth);
 BA.debugLineNum = 371;BA.debugLine="Dim Panel As Panel";
Debug.ShouldStop(262144);
_panel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("Panel", _panel);
 BA.debugLineNum = 372;BA.debugLine="Panel.Initialize(\"\")";
Debug.ShouldStop(524288);
_panel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 373;BA.debugLine="companyPanel.AddView(Panel, col * (mainPanel";
Debug.ShouldStop(1048576);
main.mostCurrent._companypanel.runVoidMethod ("AddView",(Object)((_panel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_col,(RemoteObject.solve(new RemoteObject[] {_mainpanelwidth,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1))}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._panel2.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {_row,(RemoteObject.solve(new RemoteObject[] {_panelheight,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "+",1, 1))}, "*",0, 1))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_mainpanelwidth,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)),(Object)(_panelheight));
 BA.debugLineNum = 375;BA.debugLine="Dim PanelTitle As Panel";
Debug.ShouldStop(4194304);
_paneltitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("PanelTitle", _paneltitle);
 BA.debugLineNum = 376;BA.debugLine="PanelTitle.Initialize(\"Panel2\")";
Debug.ShouldStop(8388608);
_paneltitle.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel2")));
 BA.debugLineNum = 377;BA.debugLine="PanelTitle.Color = Colors.Black";
Debug.ShouldStop(16777216);
_paneltitle.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 378;BA.debugLine="PanelTitle.Tag = name";
Debug.ShouldStop(33554432);
_paneltitle.runMethod(false,"setTag",(_name));
 BA.debugLineNum = 379;BA.debugLine="Panel.AddView(PanelTitle, 0, 0, Panel.Width,";
Debug.ShouldStop(67108864);
_panel.runVoidMethod ("AddView",(Object)((_paneltitle.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_panel.runMethod(true,"getWidth")),(Object)(RemoteObject.solve(new RemoteObject[] {_panelheight,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))}, "-",1, 1)));
 BA.debugLineNum = 381;BA.debugLine="Dim Label17 As Label";
Debug.ShouldStop(268435456);
_label17 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Label17", _label17);
 BA.debugLineNum = 382;BA.debugLine="Label17.Initialize(\"Label17\")";
Debug.ShouldStop(536870912);
_label17.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Label17")));
 BA.debugLineNum = 383;BA.debugLine="Label17.Text = name.ToUpperCase";
Debug.ShouldStop(1073741824);
_label17.runMethod(true,"setText",BA.ObjectToCharSequence(_name.runMethod(true,"toUpperCase")));
 BA.debugLineNum = 384;BA.debugLine="Label17.Tag = company_id";
Debug.ShouldStop(-2147483648);
_label17.runMethod(false,"setTag",(_company_id));
 BA.debugLineNum = 385;BA.debugLine="Label17.TextSize = 18";
Debug.ShouldStop(1);
_label17.runMethod(true,"setTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 386;BA.debugLine="Label17.TextColor = Colors.White";
Debug.ShouldStop(2);
_label17.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 387;BA.debugLine="Label17.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(4);
_label17.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 388;BA.debugLine="Label17.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(8);
_label17.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 389;BA.debugLine="PanelTitle.AddView(Label17, 5dip, 0dip, Pane";
Debug.ShouldStop(16);
_paneltitle.runVoidMethod ("AddView",(Object)((_label17.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(_paneltitle.runMethod(true,"getWidth")),(Object)(_paneltitle.runMethod(true,"getHeight")));
 BA.debugLineNum = 391;BA.debugLine="Dim myImage As Bitmap = LoadBitmap(File.DirA";
Debug.ShouldStop(64);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_myimage = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("arrows-removebg-preview.png")));Debug.locals.put("myImage", _myimage);Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 392;BA.debugLine="If myImage.IsInitialized Then";
Debug.ShouldStop(128);
if (_myimage.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 393;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resize";
Debug.ShouldStop(256);
_resizedimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_resizedimage = _myimage.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 4.5)),main.mostCurrent.activityBA))))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_myimage.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 2)),main.mostCurrent.activityBA))),_myimage.runMethod(true,"getWidth")}, "*/",0, 0))),(Object)(main.mostCurrent.__c.getField(true,"True")));Debug.locals.put("resizedImage", _resizedimage);Debug.locals.put("resizedImage", _resizedimage);
 BA.debugLineNum = 394;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(512);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 395;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(1024);
_imgview.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 396;BA.debugLine="imgView.Gravity = Gravity.FILL";
Debug.ShouldStop(2048);
_imgview.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 397;BA.debugLine="imgView.Bitmap = myImage";
Debug.ShouldStop(4096);
_imgview.runMethod(false,"setBitmap",(_myimage.getObject()));
 BA.debugLineNum = 398;BA.debugLine="PanelTitle.AddView(imgView, PanelTitle.Widt";
Debug.ShouldStop(8192);
_paneltitle.runVoidMethod ("AddView",(Object)((_imgview.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_paneltitle.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_paneltitle.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)));
 }else {
 BA.debugLineNum = 400;BA.debugLine="Log(\"Error loading image\")";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2393453",RemoteObject.createImmutable("Error loading image"),0);
 };
 BA.debugLineNum = 403;BA.debugLine="Dim panelWidth As Int = Panel.Width / 3";
Debug.ShouldStop(262144);
_panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(3)}, "/",0, 0));Debug.locals.put("panelWidth", _panelwidth);Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 404;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(524288);
_padding = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 405;BA.debugLine="Dim labelheight As Int = panelHeight - Panel";
Debug.ShouldStop(1048576);
_labelheight = RemoteObject.solve(new RemoteObject[] {_panelheight,_paneltitle.runMethod(true,"getHeight")}, "-",1, 1);Debug.locals.put("labelheight", _labelheight);Debug.locals.put("labelheight", _labelheight);
 BA.debugLineNum = 406;BA.debugLine="panelWidth = Panel.Width / 2";
Debug.ShouldStop(2097152);
_panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 408;BA.debugLine="Dim totalStore As Label";
Debug.ShouldStop(8388608);
_totalstore = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalStore", _totalstore);
 BA.debugLineNum = 409;BA.debugLine="totalStore.Initialize(\"\")";
Debug.ShouldStop(16777216);
_totalstore.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 410;BA.debugLine="totalStore.Text = total_count";
Debug.ShouldStop(33554432);
_totalstore.runMethod(true,"setText",BA.ObjectToCharSequence(_total_count));
 BA.debugLineNum = 411;BA.debugLine="totalStore.TextColor = Colors.Black";
Debug.ShouldStop(67108864);
_totalstore.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 412;BA.debugLine="totalStore.TextSize = primaryFontSize";
Debug.ShouldStop(134217728);
_totalstore.runMethod(true,"setTextSize",BA.numberCast(float.class, main._primaryfontsize));
 BA.debugLineNum = 413;BA.debugLine="totalStore.Gravity = Gravity.CENTER";
Debug.ShouldStop(268435456);
_totalstore.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 414;BA.debugLine="totalStore.Typeface = Typeface.SERIF";
Debug.ShouldStop(536870912);
_totalstore.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 415;BA.debugLine="Panel.AddView(totalStore, 0, PanelTitle.Heig";
Debug.ShouldStop(1073741824);
_panel.runVoidMethod ("AddView",(Object)((_totalstore.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_paneltitle.runMethod(true,"getHeight")),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_labelheight,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 1)));
 BA.debugLineNum = 417;BA.debugLine="Dim totalStoreLabel As Label";
Debug.ShouldStop(1);
_totalstorelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalStoreLabel", _totalstorelabel);
 BA.debugLineNum = 418;BA.debugLine="totalStoreLabel.Initialize(\"\")";
Debug.ShouldStop(2);
_totalstorelabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 419;BA.debugLine="totalStoreLabel.Text = \" Total Store\"";
Debug.ShouldStop(4);
_totalstorelabel.runMethod(true,"setText",BA.ObjectToCharSequence(" Total Store"));
 BA.debugLineNum = 420;BA.debugLine="totalStoreLabel.TextColor = Colors.Gray";
Debug.ShouldStop(8);
_totalstorelabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 421;BA.debugLine="totalStoreLabel.TextSize = secondaryFontSize";
Debug.ShouldStop(16);
_totalstorelabel.runMethod(true,"setTextSize",BA.numberCast(float.class, main._secondaryfontsize));
 BA.debugLineNum = 422;BA.debugLine="totalStoreLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(32);
_totalstorelabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 423;BA.debugLine="totalStoreLabel.Typeface = Typeface.MONOSPAC";
Debug.ShouldStop(64);
_totalstorelabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 424;BA.debugLine="totalStoreLabel.Text = totalStoreLabel.Text.";
Debug.ShouldStop(128);
_totalstorelabel.runMethod(true,"setText",BA.ObjectToCharSequence(_totalstorelabel.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 425;BA.debugLine="Panel.AddView(totalStoreLabel, 0, totalStore";
Debug.ShouldStop(256);
_panel.runVoidMethod ("AddView",(Object)((_totalstorelabel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_totalstore.runMethod(true,"getTop"),_padding,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 427;BA.debugLine="Dim totalPos As Label";
Debug.ShouldStop(1024);
_totalpos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPos", _totalpos);
 BA.debugLineNum = 428;BA.debugLine="totalPos.Initialize(\"\")";
Debug.ShouldStop(2048);
_totalpos.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 429;BA.debugLine="totalPos.Text = total_pos";
Debug.ShouldStop(4096);
_totalpos.runMethod(true,"setText",BA.ObjectToCharSequence(_total_pos));
 BA.debugLineNum = 430;BA.debugLine="totalPos.TextColor = Colors.Black";
Debug.ShouldStop(8192);
_totalpos.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 431;BA.debugLine="totalPos.TextSize = primaryFontSize";
Debug.ShouldStop(16384);
_totalpos.runMethod(true,"setTextSize",BA.numberCast(float.class, main._primaryfontsize));
 BA.debugLineNum = 432;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
Debug.ShouldStop(32768);
_totalpos.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 433;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
Debug.ShouldStop(65536);
_totalpos.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 434;BA.debugLine="Panel.AddView(totalPos, panelWidth, PanelTit";
Debug.ShouldStop(131072);
_panel.runVoidMethod ("AddView",(Object)((_totalpos.getObject())),(Object)(_panelwidth),(Object)(_paneltitle.runMethod(true,"getHeight")),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_labelheight,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 1)));
 BA.debugLineNum = 436;BA.debugLine="Dim totalPosLabel As Label";
Debug.ShouldStop(524288);
_totalposlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPosLabel", _totalposlabel);
 BA.debugLineNum = 437;BA.debugLine="totalPosLabel.Initialize(\"\")";
Debug.ShouldStop(1048576);
_totalposlabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 438;BA.debugLine="totalPosLabel.Text = \" Total Pos\"";
Debug.ShouldStop(2097152);
_totalposlabel.runMethod(true,"setText",BA.ObjectToCharSequence(" Total Pos"));
 BA.debugLineNum = 439;BA.debugLine="totalPosLabel.TextColor = Colors.Gray";
Debug.ShouldStop(4194304);
_totalposlabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 440;BA.debugLine="totalPosLabel.TextSize = secondaryFontSize";
Debug.ShouldStop(8388608);
_totalposlabel.runMethod(true,"setTextSize",BA.numberCast(float.class, main._secondaryfontsize));
 BA.debugLineNum = 441;BA.debugLine="totalPosLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(16777216);
_totalposlabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 442;BA.debugLine="totalPosLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(33554432);
_totalposlabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 443;BA.debugLine="totalPosLabel.Text = totalPosLabel.Text.ToUp";
Debug.ShouldStop(67108864);
_totalposlabel.runMethod(true,"setText",BA.ObjectToCharSequence(_totalposlabel.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 444;BA.debugLine="Panel.AddView(totalPosLabel, panelWidth, tot";
Debug.ShouldStop(134217728);
_panel.runVoidMethod ("AddView",(Object)((_totalposlabel.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_totalpos.runMethod(true,"getTop"),_padding,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 446;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(536870912);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 447;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 0dip, Col";
Debug.ShouldStop(1073741824);
_cd.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 448;BA.debugLine="Panel.Background = cd";
Debug.ShouldStop(-2147483648);
_panel.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 449;BA.debugLine="count = count + 1";
Debug.ShouldStop(1);
_count = RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("count", _count);
 }
}Debug.locals.put("record", _record);
;
 BA.debugLineNum = 451;BA.debugLine="totalGetDataHeight = Panel2.Height + companyP";
Debug.ShouldStop(4);
main._totalgetdataheight = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._panel2.runMethod(true,"getHeight"),main.mostCurrent._companypanel.runMethod(true,"getHeight")}, "+",1, 1);
 break; }
case 3: {
 BA.debugLineNum = 454;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Data updated successfully")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 455;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(64);
_loadcompanydata();
 break; }
default: {
 BA.debugLineNum = 457;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2393510",RemoteObject.concat(RemoteObject.createImmutable("Unknown job: "),_job.getField(true,"_jobname" /*RemoteObject*/ )),0);
 break; }
}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e267) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e267.toString()); BA.debugLineNum = 461;BA.debugLine="Log(\"Error parsing data: \" & LastException.Mess";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2393514",RemoteObject.concat(RemoteObject.createImmutable("Error parsing data: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 };
 }else {
 BA.debugLineNum = 464;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 466;BA.debugLine="job.Release";
Debug.ShouldStop(131072);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 467;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _label17_click() throws Exception{
try {
		Debug.PushSubsStack("Label17_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,475);
if (RapidSub.canDelegate("label17_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","label17_click");}
RemoteObject _clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _selectedcompany = RemoteObject.createImmutable("");
 BA.debugLineNum = 475;BA.debugLine="Private Sub Label17_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 476;BA.debugLine="Dim clickedLabel As Label = Sender";
Debug.ShouldStop(134217728);
_clickedlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("clickedLabel", _clickedlabel);Debug.locals.put("clickedLabel", _clickedlabel);
 BA.debugLineNum = 477;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
Debug.ShouldStop(268435456);
_selectedcompany = BA.ObjectToString(_clickedlabel.runMethod(false,"getTag"));Debug.locals.put("selectedCompany", _selectedcompany);Debug.locals.put("selectedCompany", _selectedcompany);
 BA.debugLineNum = 478;BA.debugLine="Starter.company_selected = selectedCompany";
Debug.ShouldStop(536870912);
main.mostCurrent._starter._company_selected /*RemoteObject*/  = _selectedcompany;
 BA.debugLineNum = 479;BA.debugLine="StartActivity(\"Branch\")";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("Branch"))));
 BA.debugLineNum = 480;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadcompanydata() throws Exception{
try {
		Debug.PushSubsStack("LoadCompanyData (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,113);
if (RapidSub.canDelegate("loadcompanydata")) { return b4a.example.main.remoteMe.runUserSub(false, "main","loadcompanydata");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 113;BA.debugLine="Sub LoadCompanyData";
Debug.ShouldStop(65536);
 BA.debugLineNum = 114;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 115;BA.debugLine="PHPURLCompany = $\"https://192.168.8.117/Company/";
Debug.ShouldStop(262144);
main.mostCurrent._phpurlcompany = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._currentpage))),RemoteObject.createImmutable("")));
 BA.debugLineNum = 116;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(524288);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 117;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
Debug.ShouldStop(1048576);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("GetData")),(Object)(main.getObject()));
 BA.debugLineNum = 118;BA.debugLine="Job1.Download(PHPURL)";
Debug.ShouldStop(2097152);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(main.mostCurrent._phpurl));
 BA.debugLineNum = 119;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Data..."))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 121;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2196616",main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),0);
 };
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadgraphdata() throws Exception{
try {
		Debug.PushSubsStack("LoadGraphData (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,125);
if (RapidSub.canDelegate("loadgraphdata")) { return b4a.example.main.remoteMe.runUserSub(false, "main","loadgraphdata");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 125;BA.debugLine="Sub LoadGraphData";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 126;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 127;BA.debugLine="PHPURLCompany = $\"https://192.168.8.117/Company/";
Debug.ShouldStop(1073741824);
main.mostCurrent._phpurlcompany = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._currentpage))),RemoteObject.createImmutable("&company_sales="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._salesdata1))),RemoteObject.createImmutable("&sort_type="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable("")));
 BA.debugLineNum = 128;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(-2147483648);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 129;BA.debugLine="Job1.Initialize(\"GetCompany\", Me)";
Debug.ShouldStop(1);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("GetCompany")),(Object)(main.getObject()));
 BA.debugLineNum = 130;BA.debugLine="Job1.Download(PHPURLCompany)";
Debug.ShouldStop(2);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(main.mostCurrent._phpurlcompany));
 BA.debugLineNum = 131;BA.debugLine="ProgressDialogShow(\"Loading Graph Data...\")";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Graph Data..."))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 133;BA.debugLine="Log(\"LoadGraphData Error: \" & LastException.Mess";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2262152",RemoteObject.concat(RemoteObject.createImmutable("LoadGraphData Error: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 BA.debugLineNum = 134;BA.debugLine="ToastMessageShow(\"Error initiating graph load: \"";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error initiating graph load: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadgraphdatadefault() throws Exception{
try {
		Debug.PushSubsStack("LoadGraphDataDefault (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,137);
if (RapidSub.canDelegate("loadgraphdatadefault")) { return b4a.example.main.remoteMe.runUserSub(false, "main","loadgraphdatadefault");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 137;BA.debugLine="Sub LoadGraphDataDefault";
Debug.ShouldStop(256);
 BA.debugLineNum = 138;BA.debugLine="Try";
Debug.ShouldStop(512);
try { BA.debugLineNum = 139;BA.debugLine="PHPURLDefault = $\"https://192.168.8.117/Company/";
Debug.ShouldStop(1024);
main.mostCurrent._phpurldefault = (RemoteObject.createImmutable("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page=1&company_sales=1&sort_type=asc"));
 BA.debugLineNum = 140;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(2048);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 141;BA.debugLine="Job1.Initialize(\"GetCompany\", Me)";
Debug.ShouldStop(4096);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("GetCompany")),(Object)(main.getObject()));
 BA.debugLineNum = 142;BA.debugLine="Job1.Download(PHPURLDefault)";
Debug.ShouldStop(8192);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(main.mostCurrent._phpurldefault));
 BA.debugLineNum = 143;BA.debugLine="ProgressDialogShow(\"Loading Graph Data...\")";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Graph Data..."))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 145;BA.debugLine="Log(\"LoadGraphData Error: \" & LastException.Mess";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("LogImpl","28781832",RemoteObject.concat(RemoteObject.createImmutable("LoadGraphData Error: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 BA.debugLineNum = 146;BA.debugLine="ToastMessageShow(\"Error initiating graph load: \"";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error initiating graph load: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 148;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadgraphdatapurchase() throws Exception{
try {
		Debug.PushSubsStack("LoadGraphDataPurchase (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,150);
if (RapidSub.canDelegate("loadgraphdatapurchase")) { return b4a.example.main.remoteMe.runUserSub(false, "main","loadgraphdatapurchase");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 150;BA.debugLine="Sub LoadGraphDataPurchase";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 151;BA.debugLine="Try";
Debug.ShouldStop(4194304);
try { BA.debugLineNum = 152;BA.debugLine="PHPURLCompany = $\"https://192.168.8.117/Company/";
Debug.ShouldStop(8388608);
main.mostCurrent._phpurlcompany = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._currentpage))),RemoteObject.createImmutable("&company_purchase="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._salesdata1))),RemoteObject.createImmutable("&sort_type="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable("")));
 BA.debugLineNum = 153;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(16777216);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 154;BA.debugLine="Job1.Initialize(\"GetCompanyPurchase\", Me)";
Debug.ShouldStop(33554432);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("GetCompanyPurchase")),(Object)(main.getObject()));
 BA.debugLineNum = 155;BA.debugLine="Job1.Download(PHPURLCompany)";
Debug.ShouldStop(67108864);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(main.mostCurrent._phpurlcompany));
 BA.debugLineNum = 156;BA.debugLine="ProgressDialogShow(\"Loading Graph Data...\")";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Graph Data..."))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 158;BA.debugLine="Log(\"LoadGraphData Error: \" & LastException.Mess";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2327688",RemoteObject.concat(RemoteObject.createImmutable("LoadGraphData Error: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 BA.debugLineNum = 159;BA.debugLine="ToastMessageShow(\"Error initiating graph load: \"";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error initiating graph load: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
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
public static RemoteObject  _nxtbtn_click() throws Exception{
try {
		Debug.PushSubsStack("nxtBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,482);
if (RapidSub.canDelegate("nxtbtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","nxtbtn_click");}
 BA.debugLineNum = 482;BA.debugLine="Sub nxtBtn_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 483;BA.debugLine="Log(\"sad\")";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2655361",RemoteObject.createImmutable("sad"),0);
 BA.debugLineNum = 484;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
branch_subs_0._process_globals();
device_subs_0._process_globals();
starter_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
branch.myClass = BA.getDeviceClass ("b4a.example.branch");
bargraph.myClass = BA.getDeviceClass ("b4a.example.bargraph");
checkbargraph.myClass = BA.getDeviceClass ("b4a.example.checkbargraph");
device.myClass = BA.getDeviceClass ("b4a.example.device");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
httputils2service.myClass = BA.getDeviceClass ("b4a.example.httputils2service");
httpjob.myClass = BA.getDeviceClass ("b4a.example.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 16;BA.debugLine="Public company As String";
main._company = RemoteObject.createImmutable("");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _purch1btn_click() throws Exception{
try {
		Debug.PushSubsStack("purch1btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,732);
if (RapidSub.canDelegate("purch1btn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","purch1btn_click");}
RemoteObject _checkedsales = null;
 BA.debugLineNum = 732;BA.debugLine="Sub purch1btn_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 733;BA.debugLine="salesData1 = 1";
Debug.ShouldStop(268435456);
main._salesdata1 = BA.numberCast(int.class, 1);
 BA.debugLineNum = 734;BA.debugLine="Log(\"Sales 3 selected\")";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("LogImpl","21310722",RemoteObject.createImmutable("Sales 3 selected"),0);
 BA.debugLineNum = 737;BA.debugLine="If Not(barGraphInitializedPurchase) Then";
Debug.ShouldStop(1);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(main._bargraphinitializedpurchase)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 738;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Graph not yet initialized.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 739;BA.debugLine="Return";
Debug.ShouldStop(4);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 743;BA.debugLine="Dim checkedSales() As Boolean = barGraphPurchase.";
Debug.ShouldStop(64);
_checkedsales = main.mostCurrent._bargraphpurchase.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 744;BA.debugLine="If checkedSales.Length > 0 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean(">",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 745;BA.debugLine="If Not(checkedSales(0)) Then ' Check if Sales3 i";
Debug.ShouldStop(256);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 0)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 746;BA.debugLine="ToastMessageShow(\"Please show Purchase 1 in the";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Purchase 1 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 747;BA.debugLine="Return";
Debug.ShouldStop(1024);
if (true) return RemoteObject.createImmutable("");
 };
 };
 BA.debugLineNum = 752;BA.debugLine="If sortDefaultValue = \"asc\" Or sortDefaultValue =";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 753;BA.debugLine="LoadGraphDataPurchase";
Debug.ShouldStop(65536);
_loadgraphdatapurchase();
 }else {
 BA.debugLineNum = 755;BA.debugLine="ToastMessageShow(\"Invalid sort value. Use 'asc'";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Invalid sort value. Use 'asc' or 'desc'.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 757;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _purch2btn_click() throws Exception{
try {
		Debug.PushSubsStack("purch2btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,759);
if (RapidSub.canDelegate("purch2btn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","purch2btn_click");}
RemoteObject _checkedsales = null;
 BA.debugLineNum = 759;BA.debugLine="Sub purch2btn_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 760;BA.debugLine="salesData1 = 2";
Debug.ShouldStop(8388608);
main._salesdata1 = BA.numberCast(int.class, 2);
 BA.debugLineNum = 761;BA.debugLine="Log(\"Sales 3 selected\")";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("LogImpl","21376258",RemoteObject.createImmutable("Sales 3 selected"),0);
 BA.debugLineNum = 764;BA.debugLine="If Not(barGraphInitializedPurchase) Then";
Debug.ShouldStop(134217728);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(main._bargraphinitializedpurchase)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 765;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Graph not yet initialized.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 766;BA.debugLine="Return";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 770;BA.debugLine="Dim checkedSales() As Boolean = barGraphPurchase.";
Debug.ShouldStop(2);
_checkedsales = main.mostCurrent._bargraphpurchase.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 771;BA.debugLine="If checkedSales.Length > 0 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean(">",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 772;BA.debugLine="If Not(checkedSales(1)) Then ' Check if Sales3 i";
Debug.ShouldStop(8);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 1)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 773;BA.debugLine="ToastMessageShow(\"Please show Purchase 2 in the";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Purchase 2 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 774;BA.debugLine="Return";
Debug.ShouldStop(32);
if (true) return RemoteObject.createImmutable("");
 };
 };
 BA.debugLineNum = 779;BA.debugLine="If sortDefaultValue = \"asc\" Or sortDefaultValue =";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 780;BA.debugLine="LoadGraphDataPurchase";
Debug.ShouldStop(2048);
_loadgraphdatapurchase();
 }else {
 BA.debugLineNum = 782;BA.debugLine="ToastMessageShow(\"Invalid sort value. Use 'asc'";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Invalid sort value. Use 'asc' or 'desc'.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 784;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _purch3btn_click() throws Exception{
try {
		Debug.PushSubsStack("purch3btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,786);
if (RapidSub.canDelegate("purch3btn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","purch3btn_click");}
RemoteObject _checkedsales = null;
 BA.debugLineNum = 786;BA.debugLine="Sub purch3btn_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 787;BA.debugLine="salesData1 = 3";
Debug.ShouldStop(262144);
main._salesdata1 = BA.numberCast(int.class, 3);
 BA.debugLineNum = 788;BA.debugLine="Log(\"Sales 3 selected\")";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","21441794",RemoteObject.createImmutable("Sales 3 selected"),0);
 BA.debugLineNum = 791;BA.debugLine="If Not(barGraphInitializedPurchase) Then";
Debug.ShouldStop(4194304);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(main._bargraphinitializedpurchase)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 792;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Graph not yet initialized.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 793;BA.debugLine="Return";
Debug.ShouldStop(16777216);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 797;BA.debugLine="Dim checkedSales() As Boolean = barGraphPurchase.";
Debug.ShouldStop(268435456);
_checkedsales = main.mostCurrent._bargraphpurchase.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 798;BA.debugLine="If checkedSales.Length = 0 Or Not(checkedSales(2)";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean(".",main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 2)))))) { 
 BA.debugLineNum = 799;BA.debugLine="ToastMessageShow(\"Please show Purchase 3 in the";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Purchase 3 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 800;BA.debugLine="Return";
Debug.ShouldStop(-2147483648);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 804;BA.debugLine="If sortDefaultValue = \"asc\" Or sortDefaultValue =";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 805;BA.debugLine="LoadGraphDataPurchase";
Debug.ShouldStop(16);
_loadgraphdatapurchase();
 }else {
 BA.debugLineNum = 807;BA.debugLine="ToastMessageShow(\"Invalid sort value. Use 'asc'";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Invalid sort value. Use 'asc' or 'desc'.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 810;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sales1btn_click() throws Exception{
try {
		Debug.PushSubsStack("sales1btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,575);
if (RapidSub.canDelegate("sales1btn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","sales1btn_click");}
RemoteObject _checkedsales = null;
 BA.debugLineNum = 575;BA.debugLine="Sub sales1btn_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 576;BA.debugLine="salesData1 = 1";
Debug.ShouldStop(-2147483648);
main._salesdata1 = BA.numberCast(int.class, 1);
 BA.debugLineNum = 577;BA.debugLine="Log(\"Sales 3 selected\")";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2983042",RemoteObject.createImmutable("Sales 3 selected"),0);
 BA.debugLineNum = 580;BA.debugLine="If Not(barGraphInitialized) Then";
Debug.ShouldStop(8);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(main._bargraphinitialized)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 581;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Graph not yet initialized.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 582;BA.debugLine="Return";
Debug.ShouldStop(32);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 586;BA.debugLine="Dim checkedSales() As Boolean = barGraph.GetCheck";
Debug.ShouldStop(512);
_checkedsales = main.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 587;BA.debugLine="If checkedSales.Length > 0 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean(">",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 588;BA.debugLine="If Not(checkedSales(0)) Then ' Check if Sales3 i";
Debug.ShouldStop(2048);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 0)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 589;BA.debugLine="ToastMessageShow(\"Please show Sales 1 in the le";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales 1 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 590;BA.debugLine="Return";
Debug.ShouldStop(8192);
if (true) return RemoteObject.createImmutable("");
 };
 };
 BA.debugLineNum = 595;BA.debugLine="If sortDefaultValue = \"asc\" Or sortDefaultValue =";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 596;BA.debugLine="LoadGraphData";
Debug.ShouldStop(524288);
_loadgraphdata();
 }else {
 BA.debugLineNum = 598;BA.debugLine="ToastMessageShow(\"Invalid sort value. Use 'asc'";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Invalid sort value. Use 'asc' or 'desc'.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 603;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sales2btn_click() throws Exception{
try {
		Debug.PushSubsStack("sales2btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,605);
if (RapidSub.canDelegate("sales2btn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","sales2btn_click");}
RemoteObject _checkedsales = null;
 BA.debugLineNum = 605;BA.debugLine="Sub sales2btn_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 606;BA.debugLine="salesData1 = 2";
Debug.ShouldStop(536870912);
main._salesdata1 = BA.numberCast(int.class, 2);
 BA.debugLineNum = 607;BA.debugLine="Log(\"Sales 3 selected\")";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("LogImpl","21048578",RemoteObject.createImmutable("Sales 3 selected"),0);
 BA.debugLineNum = 610;BA.debugLine="If Not(barGraphInitialized) Then";
Debug.ShouldStop(2);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(main._bargraphinitialized)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 611;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Graph not yet initialized.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 612;BA.debugLine="Return";
Debug.ShouldStop(8);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 616;BA.debugLine="Dim checkedSales() As Boolean = barGraph.GetCheck";
Debug.ShouldStop(128);
_checkedsales = main.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 617;BA.debugLine="If checkedSales.Length > 0 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean(">",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 618;BA.debugLine="If Not(checkedSales(1)) Then ' Check if Sales3 i";
Debug.ShouldStop(512);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 1)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 619;BA.debugLine="ToastMessageShow(\"Please show Sales2 in the leg";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales2 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 620;BA.debugLine="Return";
Debug.ShouldStop(2048);
if (true) return RemoteObject.createImmutable("");
 };
 };
 BA.debugLineNum = 625;BA.debugLine="If sortDefaultValue = \"asc\" Or sortDefaultValue =";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 626;BA.debugLine="LoadGraphData";
Debug.ShouldStop(131072);
_loadgraphdata();
 }else {
 BA.debugLineNum = 628;BA.debugLine="ToastMessageShow(\"Invalid sort value. Use 'asc'";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Invalid sort value. Use 'asc' or 'desc'.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 631;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sales3btn_click() throws Exception{
try {
		Debug.PushSubsStack("sales3btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,633);
if (RapidSub.canDelegate("sales3btn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","sales3btn_click");}
RemoteObject _checkedsales = null;
 BA.debugLineNum = 633;BA.debugLine="Sub sales3btn_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 634;BA.debugLine="salesData1 = 3";
Debug.ShouldStop(33554432);
main._salesdata1 = BA.numberCast(int.class, 3);
 BA.debugLineNum = 635;BA.debugLine="Log(\"Sales 3 selected\")";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("LogImpl","21114114",RemoteObject.createImmutable("Sales 3 selected"),0);
 BA.debugLineNum = 638;BA.debugLine="If Not(barGraphInitialized) Then";
Debug.ShouldStop(536870912);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(main._bargraphinitialized)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 639;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Graph not yet initialized.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 640;BA.debugLine="Return";
Debug.ShouldStop(-2147483648);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 644;BA.debugLine="Dim checkedSales() As Boolean = barGraph.GetCheck";
Debug.ShouldStop(8);
_checkedsales = main.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 645;BA.debugLine="If checkedSales.Length = 0 Or Not(checkedSales(2)";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean(".",main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 2)))))) { 
 BA.debugLineNum = 646;BA.debugLine="ToastMessageShow(\"Please show Sales3 in the lege";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales3 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 647;BA.debugLine="Return";
Debug.ShouldStop(64);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 651;BA.debugLine="If sortDefaultValue = \"asc\" Or sortDefaultValue =";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 652;BA.debugLine="LoadGraphData";
Debug.ShouldStop(2048);
_loadgraphdata();
 }else {
 BA.debugLineNum = 654;BA.debugLine="ToastMessageShow(\"Invalid sort value. Use 'asc'";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Invalid sort value. Use 'asc' or 'desc'.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 656;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sortbtn1_click() throws Exception{
try {
		Debug.PushSubsStack("sortBtn1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,486);
if (RapidSub.canDelegate("sortbtn1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","sortbtn1_click");}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
RemoteObject _checkedsales = null;
 BA.debugLineNum = 486;BA.debugLine="Sub sortBtn1_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 487;BA.debugLine="Dim chk As RadioButton = Sender";
Debug.ShouldStop(64);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 488;BA.debugLine="Dim index As String = chk.Tag";
Debug.ShouldStop(128);
_index = BA.ObjectToString(_chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 490;BA.debugLine="sortDefaultValue = index.ToLowerCase ' \"asc\"";
Debug.ShouldStop(512);
main.mostCurrent._sortdefaultvalue = _index.runMethod(true,"toLowerCase");
 BA.debugLineNum = 491;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2720901",(RemoteObject.concat(RemoteObject.createImmutable("sort value: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 493;BA.debugLine="If Not(barGraphInitialized) Then";
Debug.ShouldStop(4096);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(main._bargraphinitialized)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 494;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Graph not yet initialized.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 495;BA.debugLine="Return";
Debug.ShouldStop(16384);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 499;BA.debugLine="Dim checkedSales() As Boolean = barGraph.GetCheck";
Debug.ShouldStop(262144);
_checkedsales = main.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 500;BA.debugLine="If checkedSales.Length > 0 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean(">",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 501;BA.debugLine="Select Case salesData1";
Debug.ShouldStop(1048576);
switch (BA.switchObjectToInt(main._salesdata1,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 503;BA.debugLine="If Not(checkedSales(0)) Then";
Debug.ShouldStop(4194304);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 0)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 504;BA.debugLine="ToastMessageShow(\"Please show Sales1 in the l";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales1 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 505;BA.debugLine="Return";
Debug.ShouldStop(16777216);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 1: {
 BA.debugLineNum = 508;BA.debugLine="If Not(checkedSales(1)) Then";
Debug.ShouldStop(134217728);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 1)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 509;BA.debugLine="ToastMessageShow(\"Please show Sales2 in the l";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales2 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 510;BA.debugLine="Return";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 2: {
 BA.debugLineNum = 513;BA.debugLine="If Not(checkedSales(2)) Then";
Debug.ShouldStop(1);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 2)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 514;BA.debugLine="ToastMessageShow(\"Please show Sales3 in the l";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales3 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 515;BA.debugLine="Return";
Debug.ShouldStop(4);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
}
;
 };
 BA.debugLineNum = 520;BA.debugLine="LoadGraphData";
Debug.ShouldStop(128);
_loadgraphdata();
 BA.debugLineNum = 521;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sortbtn2_click() throws Exception{
try {
		Debug.PushSubsStack("sortBtn2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,524);
if (RapidSub.canDelegate("sortbtn2_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","sortbtn2_click");}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
RemoteObject _checkedsales = null;
 BA.debugLineNum = 524;BA.debugLine="Sub sortBtn2_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 525;BA.debugLine="Dim chk As RadioButton = Sender";
Debug.ShouldStop(4096);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 526;BA.debugLine="Dim index As String = chk.Tag";
Debug.ShouldStop(8192);
_index = BA.ObjectToString(_chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 528;BA.debugLine="sortDefaultValue = index.ToLowerCase ' \"desc\"";
Debug.ShouldStop(32768);
main.mostCurrent._sortdefaultvalue = _index.runMethod(true,"toLowerCase");
 BA.debugLineNum = 529;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2786437",(RemoteObject.concat(RemoteObject.createImmutable("sort value: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 531;BA.debugLine="If Not(barGraphInitialized) Then";
Debug.ShouldStop(262144);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(main._bargraphinitialized)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 532;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Graph not yet initialized.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 533;BA.debugLine="Return";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 537;BA.debugLine="Dim checkedSales() As Boolean = barGraph.GetCheck";
Debug.ShouldStop(16777216);
_checkedsales = main.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 538;BA.debugLine="If checkedSales.Length > 0 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean(">",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 539;BA.debugLine="Select Case salesData1";
Debug.ShouldStop(67108864);
switch (BA.switchObjectToInt(main._salesdata1,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 541;BA.debugLine="If Not(checkedSales(0)) Then";
Debug.ShouldStop(268435456);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 0)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 542;BA.debugLine="ToastMessageShow(\"Please show Sales1 in the l";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales1 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 543;BA.debugLine="Return";
Debug.ShouldStop(1073741824);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 1: {
 BA.debugLineNum = 546;BA.debugLine="If Not(checkedSales(1)) Then";
Debug.ShouldStop(2);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 1)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 547;BA.debugLine="ToastMessageShow(\"Please show Sales2 in the l";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales2 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 548;BA.debugLine="Return";
Debug.ShouldStop(8);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 2: {
 BA.debugLineNum = 551;BA.debugLine="If Not(checkedSales(2)) Then";
Debug.ShouldStop(64);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 2)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 552;BA.debugLine="ToastMessageShow(\"Please show Sales3 in the l";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales3 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 553;BA.debugLine="Return";
Debug.ShouldStop(256);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
}
;
 };
 BA.debugLineNum = 558;BA.debugLine="LoadGraphData";
Debug.ShouldStop(8192);
_loadgraphdata();
 BA.debugLineNum = 559;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sortbtnpurchase1_click() throws Exception{
try {
		Debug.PushSubsStack("sortBtnPurchase1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,658);
if (RapidSub.canDelegate("sortbtnpurchase1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","sortbtnpurchase1_click");}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
RemoteObject _checkedsales = null;
 BA.debugLineNum = 658;BA.debugLine="Sub sortBtnPurchase1_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 659;BA.debugLine="Dim chk As RadioButton = Sender";
Debug.ShouldStop(262144);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 660;BA.debugLine="Dim index As String = chk.Tag";
Debug.ShouldStop(524288);
_index = BA.ObjectToString(_chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 662;BA.debugLine="sortDefaultValue = index.ToLowerCase ' \"desc\"";
Debug.ShouldStop(2097152);
main.mostCurrent._sortdefaultvalue = _index.runMethod(true,"toLowerCase");
 BA.debugLineNum = 663;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("LogImpl","21179653",(RemoteObject.concat(RemoteObject.createImmutable("sort value: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 665;BA.debugLine="If Not(barGraphInitializedPurchase) Then";
Debug.ShouldStop(16777216);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(main._bargraphinitializedpurchase)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 666;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Graph not yet initialized.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 667;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 671;BA.debugLine="Dim checkedSales() As Boolean = barGraphPurchase.";
Debug.ShouldStop(1073741824);
_checkedsales = main.mostCurrent._bargraphpurchase.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 672;BA.debugLine="If checkedSales.Length > 0 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean(">",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 673;BA.debugLine="Select Case salesData1";
Debug.ShouldStop(1);
switch (BA.switchObjectToInt(main._salesdata1,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 675;BA.debugLine="If Not(checkedSales(0)) Then";
Debug.ShouldStop(4);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 0)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 676;BA.debugLine="ToastMessageShow(\"Please show Purchase 1 in t";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Purchase 1 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 677;BA.debugLine="Return";
Debug.ShouldStop(16);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 1: {
 BA.debugLineNum = 680;BA.debugLine="If Not(checkedSales(1)) Then";
Debug.ShouldStop(128);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 1)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 681;BA.debugLine="ToastMessageShow(\"Please show Purchase 2 in t";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Purchase 2 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 682;BA.debugLine="Return";
Debug.ShouldStop(512);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 2: {
 BA.debugLineNum = 685;BA.debugLine="If Not(checkedSales(2)) Then";
Debug.ShouldStop(4096);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 2)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 686;BA.debugLine="ToastMessageShow(\"Please show Purchase 3 in t";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Purchase 3 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 687;BA.debugLine="Return";
Debug.ShouldStop(16384);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
}
;
 };
 BA.debugLineNum = 692;BA.debugLine="LoadGraphDataPurchase";
Debug.ShouldStop(524288);
_loadgraphdatapurchase();
 BA.debugLineNum = 693;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sortbtnpurchase2_click() throws Exception{
try {
		Debug.PushSubsStack("sortBtnPurchase2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,695);
if (RapidSub.canDelegate("sortbtnpurchase2_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","sortbtnpurchase2_click");}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
RemoteObject _checkedsales = null;
 BA.debugLineNum = 695;BA.debugLine="Sub sortBtnPurchase2_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 696;BA.debugLine="Dim chk As RadioButton = Sender";
Debug.ShouldStop(8388608);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 697;BA.debugLine="Dim index As String = chk.Tag";
Debug.ShouldStop(16777216);
_index = BA.ObjectToString(_chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 699;BA.debugLine="sortDefaultValue = index.ToLowerCase ' \"desc\"";
Debug.ShouldStop(67108864);
main.mostCurrent._sortdefaultvalue = _index.runMethod(true,"toLowerCase");
 BA.debugLineNum = 700;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("LogImpl","21245189",(RemoteObject.concat(RemoteObject.createImmutable("sort value: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 702;BA.debugLine="If Not(barGraphInitializedPurchase) Then";
Debug.ShouldStop(536870912);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(main._bargraphinitializedpurchase)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 703;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Graph not yet initialized.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 704;BA.debugLine="Return";
Debug.ShouldStop(-2147483648);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 708;BA.debugLine="Dim checkedSales() As Boolean = barGraphPurchase.";
Debug.ShouldStop(8);
_checkedsales = main.mostCurrent._bargraphpurchase.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 709;BA.debugLine="If checkedSales.Length > 0 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean(">",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 710;BA.debugLine="Select Case salesData1";
Debug.ShouldStop(32);
switch (BA.switchObjectToInt(main._salesdata1,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 712;BA.debugLine="If Not(checkedSales(0)) Then";
Debug.ShouldStop(128);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 0)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 713;BA.debugLine="ToastMessageShow(\"Please show Purchase 1 in t";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Purchase 1 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 714;BA.debugLine="Return";
Debug.ShouldStop(512);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 1: {
 BA.debugLineNum = 717;BA.debugLine="If Not(checkedSales(1)) Then";
Debug.ShouldStop(4096);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 1)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 718;BA.debugLine="ToastMessageShow(\"Please show Purchase 2 in t";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Purchase 2 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 719;BA.debugLine="Return";
Debug.ShouldStop(16384);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 2: {
 BA.debugLineNum = 722;BA.debugLine="If Not(checkedSales(2)) Then";
Debug.ShouldStop(131072);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 2)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 723;BA.debugLine="ToastMessageShow(\"Please show Purchase 3 in t";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Purchase 3 in the legend before sorting by it.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 724;BA.debugLine="Return";
Debug.ShouldStop(524288);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
}
;
 };
 BA.debugLineNum = 729;BA.debugLine="LoadGraphDataPurchase";
Debug.ShouldStop(16777216);
_loadgraphdatapurchase();
 BA.debugLineNum = 730;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}