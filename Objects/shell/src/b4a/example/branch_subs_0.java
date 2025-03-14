package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class branch_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
<<<<<<< HEAD
		Debug.PushSubsStack("Activity_Create (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,52);
=======
		Debug.PushSubsStack("Activity_Create (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,50);
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
if (RapidSub.canDelegate("activity_create")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","activity_create", _firsttime);}
RemoteObject _gradient = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 52;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(1048576);
branch.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),branch.mostCurrent.activityBA);
 BA.debugLineNum = 54;BA.debugLine="Panel1.Color = Colors.Black";
Debug.ShouldStop(2097152);
branch.mostCurrent._panel1.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 55;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
Debug.ShouldStop(4194304);
branch.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(branch.mostCurrent._label1.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 56;BA.debugLine="Label1.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(8388608);
branch.mostCurrent._label1.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 57;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 241, 2";
Debug.ShouldStop(16777216);
branch.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 241)),(Object)(BA.numberCast(int.class, 241)),(Object)(BA.numberCast(int.class, 241))));
 BA.debugLineNum = 58;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(33554432);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 59;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
Debug.ShouldStop(67108864);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 225)),(Object)(BA.numberCast(int.class, 218)),(Object)(BA.numberCast(int.class, 218))),branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 189)),(Object)(BA.numberCast(int.class, 202)),(Object)(BA.numberCast(int.class, 217)))})));
 BA.debugLineNum = 61;BA.debugLine="ScrollView1.Background = gradient";
Debug.ShouldStop(268435456);
branch.mostCurrent._scrollview1.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 62;BA.debugLine="ScrollView1.Panel.Height = Activity.Height";
Debug.ShouldStop(536870912);
branch.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",branch.mostCurrent._activity.runMethod(true,"getHeight"));
 BA.debugLineNum = 63;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(1073741824);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 64;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
Debug.ShouldStop(-2147483648);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 185)),(Object)(BA.numberCast(int.class, 46)),(Object)(BA.numberCast(int.class, 52))),branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))})));
 BA.debugLineNum = 66;BA.debugLine="Panel2.Background = gradient";
Debug.ShouldStop(2);
branch.mostCurrent._panel2.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 67;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(4);
_loadcompanydata();
 BA.debugLineNum = 68;BA.debugLine="LoadGraphData";
Debug.ShouldStop(8);
_loadgraphdata();
 BA.debugLineNum = 69;BA.debugLine="barPanel.Initialize(\"\")";
Debug.ShouldStop(16);
branch.mostCurrent._barpanel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
<<<<<<< HEAD
		Debug.PushSubsStack("Activity_Pause (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,411);
=======
		Debug.PushSubsStack("Activity_Pause (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,548);
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 411;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 413;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
<<<<<<< HEAD
		Debug.PushSubsStack("Activity_Resume (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,407);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","activity_resume");}
 BA.debugLineNum = 407;BA.debugLine="Sub Activity_Resume";
=======
		Debug.PushSubsStack("Activity_Resume (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,545);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","activity_resume");}
 BA.debugLineNum = 545;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1);
 BA.debugLineNum = 546;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _backbtn_click() throws Exception{
try {
		Debug.PushSubsStack("backbtn_Click (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,570);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","backbtn_click");}
 BA.debugLineNum = 570;BA.debugLine="Sub backbtn_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 571;BA.debugLine="currentPage = currentPage - 1";
Debug.ShouldStop(67108864);
branch._currentpage = RemoteObject.solve(new RemoteObject[] {branch._currentpage,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 572;BA.debugLine="FetchNewPageData";
Debug.ShouldStop(134217728);
_fetchnewpagedata();
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
public static RemoteObject  _closebutton_click() throws Exception{
try {
		Debug.PushSubsStack("closeButton_Click (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,534);
if (RapidSub.canDelegate("closebutton_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","closebutton_click");}
 BA.debugLineNum = 534;BA.debugLine="Sub closeButton_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 535;BA.debugLine="popupPanel.Visible = False";
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
Debug.ShouldStop(4194304);
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
public static RemoteObject  _adjustfontsizetoheight(RemoteObject _lbl,RemoteObject _fontnum) throws Exception{
try {
		Debug.PushSubsStack("AdjustFontSizeToHeight (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,487);
if (RapidSub.canDelegate("adjustfontsizetoheight")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","adjustfontsizetoheight", _lbl, _fontnum);}
RemoteObject _fontsize = RemoteObject.createImmutable(0f);
Debug.locals.put("lbl", _lbl);
Debug.locals.put("fontNum", _fontnum);
 BA.debugLineNum = 487;BA.debugLine="Sub AdjustFontSizeToHeight(lbl As Label,fontNum As";
Debug.ShouldStop(64);
 BA.debugLineNum = 488;BA.debugLine="Dim fontSize As Float = lbl.Height * fontNum / Ge";
Debug.ShouldStop(128);
_fontsize = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_lbl.runMethod(true,"getHeight"),_fontnum,_getdevicedensity()}, "*/",0, 0));Debug.locals.put("fontSize", _fontsize);Debug.locals.put("fontSize", _fontsize);
 BA.debugLineNum = 489;BA.debugLine="lbl.TextSize = fontSize";
Debug.ShouldStop(256);
_lbl.runMethod(true,"setTextSize",_fontsize);
 BA.debugLineNum = 490;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _defbtn_click() throws Exception{
try {
<<<<<<< HEAD
		Debug.PushSubsStack("defBtn_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,441);
if (RapidSub.canDelegate("defbtn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","defbtn_click");}
 BA.debugLineNum = 441;BA.debugLine="Sub defBtn_Click";
=======
		Debug.PushSubsStack("defBtn_Click (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,576);
if (RapidSub.canDelegate("defbtn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","defbtn_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 576;BA.debugLine="Sub defBtn_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 577;BA.debugLine="Dim btn As Button = Sender ' Get the button that";
Debug.ShouldStop(1);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 578;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(2);
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 579;BA.debugLine="sortDefaultValue = \"\"";
Debug.ShouldStop(4);
branch.mostCurrent._sortdefaultvalue = BA.ObjectToString("");
 BA.debugLineNum = 580;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(8);
_loadcompanydata();
 BA.debugLineNum = 581;BA.debugLine="Log(index)";
Debug.ShouldStop(16);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","02228229",_index,0);
 BA.debugLineNum = 582;BA.debugLine="Log(\"(default)\")";
Debug.ShouldStop(32);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","02228230",RemoteObject.createImmutable("(default)"),0);
 BA.debugLineNum = 587;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edit_button_click() throws Exception{
try {
		Debug.PushSubsStack("edit_button_Click (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,509);
if (RapidSub.canDelegate("edit_button_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","edit_button_click");}
RemoteObject _target_id = RemoteObject.createImmutable(0);
RemoteObject _new_value = RemoteObject.createImmutable(0);
 BA.debugLineNum = 509;BA.debugLine="Sub edit_button_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 510;BA.debugLine="Dim target_id As Int = target_id_display.Text";
Debug.ShouldStop(536870912);
_target_id = BA.numberCast(int.class, branch.mostCurrent._target_id_display.runMethod(true,"getText"));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 511;BA.debugLine="Dim new_value As Int = target_countLabel.Text";
Debug.ShouldStop(1073741824);
_new_value = BA.numberCast(int.class, branch.mostCurrent._target_countlabel.runMethod(true,"getText"));Debug.locals.put("new_value", _new_value);Debug.locals.put("new_value", _new_value);
 BA.debugLineNum = 513;BA.debugLine="If IsNumber(target_id) And IsNumber(new_value) Th";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean(".",branch.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.NumberToString(_target_id)))) && RemoteObject.solveBoolean(".",branch.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.NumberToString(_new_value))))) { 
 BA.debugLineNum = 514;BA.debugLine="UpdateData_Remote(target_id, new_value)";
Debug.ShouldStop(2);
_updatedata_remote(_target_id,_new_value);
 BA.debugLineNum = 515;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(4);
_loadcompanydata();
 }else {
 BA.debugLineNum = 517;BA.debugLine="Log(\"Invalid input values\")";
Debug.ShouldStop(16);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","01507336",RemoteObject.createImmutable("Invalid input values"),0);
 };
 BA.debugLineNum = 519;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fetchnewpagedata() throws Exception{
try {
		Debug.PushSubsStack("FetchNewPageData (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,505);
if (RapidSub.canDelegate("fetchnewpagedata")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","fetchnewpagedata");}
 BA.debugLineNum = 505;BA.debugLine="Sub FetchNewPageData";
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
Debug.ShouldStop(16777216);
 BA.debugLineNum = 442;BA.debugLine="Log(\"Default\")";
Debug.ShouldStop(33554432);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","62490369",RemoteObject.createImmutable("Default"),0);
 BA.debugLineNum = 443;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("GetDeviceDensity (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,492);
if (RapidSub.canDelegate("getdevicedensity")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","getdevicedensity");}
RemoteObject _pixelwidth = RemoteObject.createImmutable(0);
RemoteObject _dipwidth = RemoteObject.createImmutable(0);
RemoteObject _dense = RemoteObject.createImmutable(0f);
 BA.debugLineNum = 492;BA.debugLine="Sub GetDeviceDensity As Float";
Debug.ShouldStop(2048);
 BA.debugLineNum = 493;BA.debugLine="Dim pixelWidth As Int = 100%x ' Screen width in p";
Debug.ShouldStop(4096);
_pixelwidth = branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),branch.mostCurrent.activityBA);Debug.locals.put("pixelWidth", _pixelwidth);Debug.locals.put("pixelWidth", _pixelwidth);
 BA.debugLineNum = 494;BA.debugLine="Dim dipWidth As Int = 100dip  ' 100 DIPs in pixel";
Debug.ShouldStop(8192);
_dipwidth = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)));Debug.locals.put("dipWidth", _dipwidth);Debug.locals.put("dipWidth", _dipwidth);
 BA.debugLineNum = 495;BA.debugLine="Dim Dense As Float = pixelWidth / dipWidth";
Debug.ShouldStop(16384);
_dense = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_pixelwidth,_dipwidth}, "/",0, 0));Debug.locals.put("Dense", _dense);Debug.locals.put("Dense", _dense);
 BA.debugLineNum = 496;BA.debugLine="Return Dense";
Debug.ShouldStop(32768);
Debug.CheckDeviceExceptions();if (true) return _dense;
 BA.debugLineNum = 497;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getmapvalueordefault(RemoteObject _m,RemoteObject _key,RemoteObject _defaultvalue) throws Exception{
try {
		Debug.PushSubsStack("GetMapValueOrDefault (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,399);
if (RapidSub.canDelegate("getmapvalueordefault")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","getmapvalueordefault", _m, _key, _defaultvalue);}
Debug.locals.put("m", _m);
Debug.locals.put("Key", _key);
Debug.locals.put("DefaultValue", _defaultvalue);
 BA.debugLineNum = 399;BA.debugLine="Sub GetMapValueOrDefault(m As Map, Key As String,";
Debug.ShouldStop(16384);
 BA.debugLineNum = 400;BA.debugLine="If m.ContainsKey(Key) Then";
Debug.ShouldStop(32768);
if (_m.runMethod(true,"ContainsKey",(Object)((_key))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 401;BA.debugLine="Return m.Get(Key)";
Debug.ShouldStop(65536);
Debug.CheckDeviceExceptions();if (true) return _m.runMethod(false,"Get",(Object)((_key)));
 }else {
 BA.debugLineNum = 403;BA.debugLine="Return DefaultValue";
Debug.ShouldStop(262144);
Debug.CheckDeviceExceptions();if (true) return _defaultvalue;
 };
 BA.debugLineNum = 405;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 9;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 11;BA.debugLine="Private ScrollView1 As ScrollView";
branch.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 12;BA.debugLine="Dim PHPURL As String = \"https://192.168.8.117/Com";
branch.mostCurrent._phpurl = BA.ObjectToString("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page=1");
 //BA.debugLineNum = 14;BA.debugLine="Dim TableDetails As List";
branch.mostCurrent._tabledetails = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 16;BA.debugLine="Private Button1 As Button";
branch.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private navigate As Label";
branch.mostCurrent._navigate = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim primaryFontSize As Int = 1.4%y";
branch._primaryfontsize = branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1.4)),branch.mostCurrent.activityBA);
 //BA.debugLineNum = 19;BA.debugLine="Dim secondaryFontSize As Int = 1%y";
branch._secondaryfontsize = branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1)),branch.mostCurrent.activityBA);
 //BA.debugLineNum = 20;BA.debugLine="Private Panel1 As Panel";
branch.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private Label1 As Label";
branch.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private Panel2 As Panel";
branch.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim barGraph As barGraph";
branch.mostCurrent._bargraph = RemoteObject.createNew ("b4a.example.bargraph");
 //BA.debugLineNum = 24;BA.debugLine="Dim barGraph1 As barGraph";
branch.mostCurrent._bargraph1 = RemoteObject.createNew ("b4a.example.bargraph");
 //BA.debugLineNum = 25;BA.debugLine="Dim purchasePanel As Panel";
branch.mostCurrent._purchasepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim barPanel As Panel";
branch.mostCurrent._barpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim activityPanel As Panel";
branch.mostCurrent._activitypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim saleNxtBtn As Button";
branch.mostCurrent._salenxtbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim saleBackBtn As Button";
branch.mostCurrent._salebackbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim purchNxtBtn As Button";
branch.mostCurrent._purchnxtbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim purchBackBtn As Button";
branch.mostCurrent._purchbackbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Dim sortBtn1 As RadioButton";
branch.mostCurrent._sortbtn1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Public defBtn As RadioButton";
branch.mostCurrent._defbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Public sortBtn2 As RadioButton";
branch.mostCurrent._sortbtn2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Public sales1btn As RadioButton";
branch.mostCurrent._sales1btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Public sales2btn As RadioButton";
branch.mostCurrent._sales2btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Public sales3btn As RadioButton";
branch.mostCurrent._sales3btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Public legend() As String = Array As String(\"Sale";
branch.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Sales1"),BA.ObjectToString("Sales2"),RemoteObject.createImmutable("Sales3")});
 //BA.debugLineNum = 39;BA.debugLine="Dim height As Int = 0";
branch._height = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 40;BA.debugLine="Dim companyPanel As Panel";
branch.mostCurrent._companypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Dim totalGraphDataHeight As Int = 0";
branch._totalgraphdataheight = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 42;BA.debugLine="Dim totalGetDataHeight As Int = 0";
branch._totalgetdataheight = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 43;BA.debugLine="Dim sortDefaultValue As String = \"\"";
branch.mostCurrent._sortdefaultvalue = BA.ObjectToString("");
 //BA.debugLineNum = 44;BA.debugLine="Dim salesData1 As Int = 1";
branch._salesdata1 = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 45;BA.debugLine="Dim currentPage As Int = 1";
branch._currentpage = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 46;BA.debugLine="Dim barGraphInitialized As Boolean = False";
branch._bargraphinitialized = branch.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 47;BA.debugLine="Dim PHPURLCompany As String = $\"https://192.168.8";
branch.mostCurrent._phpurlcompany = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._currentpage))),RemoteObject.createImmutable("&company_sales="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._salesdata1))),RemoteObject.createImmutable("&company_type="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable("")));
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
<<<<<<< HEAD
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,101);
=======
public static RemoteObject  _home_click() throws Exception{
try {
		Debug.PushSubsStack("home_Click (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,551);
if (RapidSub.canDelegate("home_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","home_click");}
 BA.debugLineNum = 551;BA.debugLine="Private Sub home_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 552;BA.debugLine="StartActivity(\"Main\")";
Debug.ShouldStop(128);
branch.mostCurrent.__c.runVoidMethod ("StartActivity",branch.processBA,(Object)((RemoteObject.createImmutable("Main"))));
 BA.debugLineNum = 553;BA.debugLine="Activity.Finish";
Debug.ShouldStop(256);
branch.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 554;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,160);
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
if (RapidSub.canDelegate("jobdone")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","jobdone", _job);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _scrollheight = RemoteObject.createImmutable(0);
RemoteObject _salesarray = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _padding = RemoteObject.createImmutable(0);
RemoteObject _count = RemoteObject.createImmutable(0);
RemoteObject _rownum = RemoteObject.createImmutable(0);
RemoteObject _mainpanelwidth = RemoteObject.createImmutable(0);
RemoteObject _panelheight = RemoteObject.createImmutable(0);
RemoteObject _record = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _col = RemoteObject.createImmutable(0);
RemoteObject _row = RemoteObject.createImmutable(0);
RemoteObject _name = RemoteObject.createImmutable("");
RemoteObject _company_id = RemoteObject.createImmutable(0);
RemoteObject _total_count = RemoteObject.createImmutable(0);
RemoteObject _total_pos = RemoteObject.createImmutable(0);
RemoteObject _dashpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _dashlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _panel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _paneltitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _label17 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _panelwidth = RemoteObject.createImmutable(0);
RemoteObject _labelheight = RemoteObject.createImmutable(0);
RemoteObject _totalstore = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalstorelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalpos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalposlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
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
RemoteObject _totalsalepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _totalsalelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalpurchaselabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _shadowpurchpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
Debug.locals.put("job", _job);
 BA.debugLineNum = 101;BA.debugLine="Sub JobDone(job As HttpJob)";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(32);
branch.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 103;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),branch.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 104;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 106;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(512);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 107;BA.debugLine="parser.Initialize(job.GetString)";
Debug.ShouldStop(1024);
_parser.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 110;BA.debugLine="Select Case job.JobName";
Debug.ShouldStop(8192);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("GetData"),BA.ObjectToString("GetCompany"),BA.ObjectToString("UpdateData"))) {
case 0: {
 BA.debugLineNum = 112;BA.debugLine="Dim scrollHeight As Int = 0";
Debug.ShouldStop(32768);
_scrollheight = BA.numberCast(int.class, 0);Debug.locals.put("scrollHeight", _scrollheight);Debug.locals.put("scrollHeight", _scrollheight);
 BA.debugLineNum = 113;BA.debugLine="Dim salesArray As List = parser.NextArray";
Debug.ShouldStop(65536);
_salesarray = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_salesarray = _parser.runMethod(false,"NextArray");Debug.locals.put("salesArray", _salesarray);Debug.locals.put("salesArray", _salesarray);
 BA.debugLineNum = 114;BA.debugLine="If salesArray.Size = 0 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_salesarray.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 115;BA.debugLine="ToastMessageShow(\"No data received\", True)";
Debug.ShouldStop(262144);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No data received")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 116;BA.debugLine="Return";
Debug.ShouldStop(524288);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 118;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(2097152);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 119;BA.debugLine="Dim count As Int = 0 ' Track panel count";
Debug.ShouldStop(4194304);
_count = BA.numberCast(int.class, 0);Debug.locals.put("count", _count);Debug.locals.put("count", _count);
 BA.debugLineNum = 120;BA.debugLine="Dim rowNum As Int = 3";
Debug.ShouldStop(8388608);
_rownum = BA.numberCast(int.class, 3);Debug.locals.put("rowNum", _rownum);Debug.locals.put("rowNum", _rownum);
 BA.debugLineNum = 121;BA.debugLine="Dim mainPanelWidth As Int = 0";
Debug.ShouldStop(16777216);
_mainpanelwidth = BA.numberCast(int.class, 0);Debug.locals.put("mainPanelWidth", _mainpanelwidth);Debug.locals.put("mainPanelWidth", _mainpanelwidth);
 BA.debugLineNum = 122;BA.debugLine="Dim panelHeight As Int = 150dip ' Adjust heig";
Debug.ShouldStop(33554432);
_panelheight = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)));Debug.locals.put("panelHeight", _panelheight);Debug.locals.put("panelHeight", _panelheight);
 BA.debugLineNum = 123;BA.debugLine="height = panelHeight - 70dip";
Debug.ShouldStop(67108864);
branch._height = RemoteObject.solve(new RemoteObject[] {_panelheight,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))}, "-",1, 1);
 BA.debugLineNum = 125;BA.debugLine="For Each record As Map In salesArray";
Debug.ShouldStop(268435456);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group20 = _salesarray;
final int groupLen20 = group20.runMethod(true,"getSize").<Integer>get()
;int index20 = 0;
;
for (; index20 < groupLen20;index20++){
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group20.runMethod(false,"Get",index20));Debug.locals.put("record", _record);
Debug.locals.put("record", _record);
 BA.debugLineNum = 126;BA.debugLine="If count Mod 3 = 0 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(3)}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 127;BA.debugLine="height = height + panelHeight";
Debug.ShouldStop(1073741824);
<<<<<<< HEAD
branch._height = RemoteObject.solve(new RemoteObject[] {branch._height,_panelheight}, "+",1, 1);
=======
_total_pos = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("total_device")))));Debug.locals.put("total_pos", _total_pos);Debug.locals.put("total_pos", _total_pos);
 BA.debugLineNum = 192;BA.debugLine="Dim totalPur1 As String = record.Get(\"purcha";
Debug.ShouldStop(-2147483648);
_totalpur1 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("purchase_1")))));Debug.locals.put("totalPur1", _totalpur1);Debug.locals.put("totalPur1", _totalpur1);
 BA.debugLineNum = 193;BA.debugLine="Dim totalPur2 As String = record.Get(\"purcha";
Debug.ShouldStop(1);
_totalpur2 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("purchase_2")))));Debug.locals.put("totalPur2", _totalpur2);Debug.locals.put("totalPur2", _totalpur2);
 BA.debugLineNum = 194;BA.debugLine="Dim totalPur3 As String = record.Get(\"purcha";
Debug.ShouldStop(2);
_totalpur3 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("purchase_3")))));Debug.locals.put("totalPur3", _totalpur3);Debug.locals.put("totalPur3", _totalpur3);
 BA.debugLineNum = 195;BA.debugLine="Dim totalSales1 As String = record.Get(\"tota";
Debug.ShouldStop(4);
_totalsales1 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("total_sales1")))));Debug.locals.put("totalSales1", _totalsales1);Debug.locals.put("totalSales1", _totalsales1);
 BA.debugLineNum = 196;BA.debugLine="Dim totalSales2 As String = record.Get(\"tota";
Debug.ShouldStop(8);
_totalsales2 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("total_sales2")))));Debug.locals.put("totalSales2", _totalsales2);Debug.locals.put("totalSales2", _totalsales2);
 BA.debugLineNum = 197;BA.debugLine="Dim totalSales3 As String = record.Get(\"tota";
Debug.ShouldStop(16);
_totalsales3 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("total_sales3")))));Debug.locals.put("totalSales3", _totalsales3);Debug.locals.put("totalSales3", _totalsales3);
 BA.debugLineNum = 198;BA.debugLine="Dim target_id As String = record.Get(\"branch";
Debug.ShouldStop(32);
_target_id = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("branch_target_id")))));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 199;BA.debugLine="totalSales = totalSales1.Length";
Debug.ShouldStop(64);
branch._totalsales = _totalsales1.runMethod(true,"length");
 BA.debugLineNum = 200;BA.debugLine="target_countLabel.Text = total_count";
Debug.ShouldStop(128);
branch.mostCurrent._target_countlabel.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_total_count));
 BA.debugLineNum = 201;BA.debugLine="branches.Text = \"Branches - \" & companyName";
Debug.ShouldStop(256);
branch.mostCurrent._branches.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Branches - "),_companyname)));
 BA.debugLineNum = 202;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
Debug.ShouldStop(512);
branch.mostCurrent._branches.runMethod(true,"setText",BA.ObjectToCharSequence(branch.mostCurrent._branches.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 204;BA.debugLine="LabelTitle.Text = companyName";
Debug.ShouldStop(2048);
branch.mostCurrent._labeltitle.runMethod(true,"setText",BA.ObjectToCharSequence(_companyname));
 BA.debugLineNum = 205;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCas";
Debug.ShouldStop(4096);
branch.mostCurrent._labeltitle.runMethod(true,"setText",BA.ObjectToCharSequence(branch.mostCurrent._labeltitle.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 206;BA.debugLine="LabelTitle.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(8192);
branch.mostCurrent._labeltitle.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 208;BA.debugLine="Panel.Initialize(\"Panel\")";
Debug.ShouldStop(32768);
branch.mostCurrent._panel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel")));
 BA.debugLineNum = 209;BA.debugLine="scrollViewPanel4.Panel.AddView(Panel, leftPo";
Debug.ShouldStop(65536);
branch.mostCurrent._scrollviewpanel4.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((branch.mostCurrent._panel.getObject())),(Object)(_leftposition),(Object)(_topposition),(Object)(_pnlwidth),(Object)(_pnlheight));
 BA.debugLineNum = 210;BA.debugLine="Panel.Color = Colors.Black";
Debug.ShouldStop(131072);
branch.mostCurrent._panel.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 212;BA.debugLine="Dim Panel2 As Panel";
Debug.ShouldStop(524288);
_panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("Panel2", _panel2);
 BA.debugLineNum = 213;BA.debugLine="Panel2.Initialize(\"Panel2\")";
Debug.ShouldStop(1048576);
_panel2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel2")));
 BA.debugLineNum = 214;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(2097152);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 215;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As I";
Debug.ShouldStop(4194304);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 185)),(Object)(BA.numberCast(int.class, 46)),(Object)(BA.numberCast(int.class, 52))),branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))})));
 BA.debugLineNum = 216;BA.debugLine="Panel2.Background = gradient";
Debug.ShouldStop(8388608);
_panel2.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 217;BA.debugLine="Panel2.Tag = name";
Debug.ShouldStop(16777216);
_panel2.runMethod(false,"setTag",(_name));
 BA.debugLineNum = 218;BA.debugLine="Panel2.SendToBack";
Debug.ShouldStop(33554432);
_panel2.runVoidMethod ("SendToBack");
 BA.debugLineNum = 219;BA.debugLine="Panel.AddView(Panel2, 0, 0, Panel.Width, 6%y";
Debug.ShouldStop(67108864);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_panel2.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(branch.mostCurrent._panel.runMethod(true,"getWidth")),(Object)(branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 6)),branch.mostCurrent.activityBA)));
 BA.debugLineNum = 221;BA.debugLine="Dim BranchNameLabel As Label";
Debug.ShouldStop(268435456);
_branchnamelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("BranchNameLabel", _branchnamelabel);
 BA.debugLineNum = 222;BA.debugLine="BranchNameLabel.Initialize(\"Label17\")";
Debug.ShouldStop(536870912);
_branchnamelabel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Label17")));
 BA.debugLineNum = 223;BA.debugLine="BranchNameLabel.Text = name";
Debug.ShouldStop(1073741824);
_branchnamelabel.runMethod(true,"setText",BA.ObjectToCharSequence(_name));
 BA.debugLineNum = 224;BA.debugLine="BranchNameLabel.Tag = id";
Debug.ShouldStop(-2147483648);
_branchnamelabel.runMethod(false,"setTag",(_id));
 BA.debugLineNum = 225;BA.debugLine="BranchNameLabel.TextSize = 18";
Debug.ShouldStop(1);
_branchnamelabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 226;BA.debugLine="BranchNameLabel.TextColor = Colors.White";
Debug.ShouldStop(2);
_branchnamelabel.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 227;BA.debugLine="BranchNameLabel.Typeface = Typeface.MONOSPAC";
Debug.ShouldStop(4);
_branchnamelabel.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 228;BA.debugLine="BranchNameLabel.Gravity = Gravity.CENTER_VER";
Debug.ShouldStop(8);
_branchnamelabel.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 229;BA.debugLine="Panel2.AddView(BranchNameLabel, 10dip, 0dip,";
Debug.ShouldStop(16);
_panel2.runVoidMethod ("AddView",(Object)((_branchnamelabel.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(_panel2.runMethod(true,"getWidth")),(Object)(_panel2.runMethod(true,"getHeight")));
 BA.debugLineNum = 231;BA.debugLine="Dim myImage As Bitmap";
Debug.ShouldStop(64);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 232;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrows";
Debug.ShouldStop(128);
_myimage = branch.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(branch.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("arrows-removebg-preview.png")));Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 233;BA.debugLine="If myImage.IsInitialized Then";
Debug.ShouldStop(256);
if (_myimage.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 234;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resize";
Debug.ShouldStop(512);
_resizedimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_resizedimage = _myimage.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 4.5)),branch.mostCurrent.activityBA))))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_myimage.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 2)),branch.mostCurrent.activityBA))),_myimage.runMethod(true,"getWidth")}, "*/",0, 0))),(Object)(branch.mostCurrent.__c.getField(true,"True")));Debug.locals.put("resizedImage", _resizedimage);Debug.locals.put("resizedImage", _resizedimage);
 BA.debugLineNum = 235;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(1024);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 236;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(2048);
_imgview.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 237;BA.debugLine="imgView.Bitmap = resizedImage";
Debug.ShouldStop(4096);
_imgview.runMethod(false,"setBitmap",(_resizedimage.getObject()));
 BA.debugLineNum = 238;BA.debugLine="Panel2.AddView(imgView, Panel2.Width - 8%x,";
Debug.ShouldStop(8192);
_panel2.runVoidMethod ("AddView",(Object)((_imgview.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panel2.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 8)),branch.mostCurrent.activityBA)}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),branch.mostCurrent.activityBA)),(Object)(_panel2.runMethod(true,"getHeight")));
 }else {
 BA.debugLineNum = 240;BA.debugLine="Log(\"Error loading image\")";
Debug.ShouldStop(32768);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","01376336",RemoteObject.createImmutable("Error loading image"),0);
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
 };
 BA.debugLineNum = 129;BA.debugLine="Dim col As Int = count Mod 3  ' Column posit";
Debug.ShouldStop(1);
_col = RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(3)}, "%",0, 1);Debug.locals.put("col", _col);Debug.locals.put("col", _col);
 BA.debugLineNum = 130;BA.debugLine="Dim row As Int = Floor(count / 3)";
Debug.ShouldStop(2);
_row = BA.numberCast(int.class, branch.mostCurrent.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(3)}, "/",0, 0))));Debug.locals.put("row", _row);Debug.locals.put("row", _row);
 BA.debugLineNum = 131;BA.debugLine="Dim name As String = record.Get(\"company_nam";
Debug.ShouldStop(4);
_name = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("company_name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 132;BA.debugLine="Dim company_id As Int = record.Get(\"comId\")";
Debug.ShouldStop(8);
_company_id = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("comId")))));Debug.locals.put("company_id", _company_id);Debug.locals.put("company_id", _company_id);
 BA.debugLineNum = 133;BA.debugLine="Dim total_count As Int = record.Get(\"total_c";
Debug.ShouldStop(16);
_total_count = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("total_count")))));Debug.locals.put("total_count", _total_count);Debug.locals.put("total_count", _total_count);
 BA.debugLineNum = 134;BA.debugLine="Dim total_pos As Int = record.Get(\"totalDevi";
Debug.ShouldStop(32);
_total_pos = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("totalDevices")))));Debug.locals.put("total_pos", _total_pos);Debug.locals.put("total_pos", _total_pos);
 BA.debugLineNum = 135;BA.debugLine="Dim dashPanel As Panel";
Debug.ShouldStop(64);
_dashpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("dashPanel", _dashpanel);
 BA.debugLineNum = 136;BA.debugLine="dashPanel.Initialize(\"\")";
Debug.ShouldStop(128);
_dashpanel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 137;BA.debugLine="ScrollView1.Panel.AddView(dashPanel, 5dip, P";
Debug.ShouldStop(256);
branch.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_dashpanel.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(branch.mostCurrent._panel2.runMethod(true,"getHeight")),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 149;BA.debugLine="Dim dashLabel As Label";
Debug.ShouldStop(1048576);
_dashlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("dashLabel", _dashlabel);
 BA.debugLineNum = 150;BA.debugLine="dashLabel.Initialize(\"\")";
Debug.ShouldStop(2097152);
_dashlabel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 151;BA.debugLine="dashLabel.Text = \"Dashboard\"";
Debug.ShouldStop(4194304);
_dashlabel.runMethod(true,"setText",BA.ObjectToCharSequence("Dashboard"));
 BA.debugLineNum = 152;BA.debugLine="dashLabel.TextColor = Colors.ARGB(50,156,0,0";
Debug.ShouldStop(8388608);
_dashlabel.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 156)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 153;BA.debugLine="dashLabel.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(16777216);
_dashlabel.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 154;BA.debugLine="dashLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(33554432);
_dashlabel.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 159;BA.debugLine="companyPanel.Initialize(\"Panel\")";
Debug.ShouldStop(1073741824);
branch.mostCurrent._companypanel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel")));
 BA.debugLineNum = 160;BA.debugLine="ScrollView1.Panel.AddView(companyPanel, 5dip";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((branch.mostCurrent._companypanel.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(_dashpanel.runMethod(true,"getHeight")),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._activity.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)),(Object)(branch._height));
 BA.debugLineNum = 163;BA.debugLine="mainPanelWidth = companyPanel.Width / rowNum";
Debug.ShouldStop(4);
_mainpanelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._companypanel.runMethod(true,"getWidth"),_rownum}, "/",0, 0));Debug.locals.put("mainPanelWidth", _mainpanelwidth);
 BA.debugLineNum = 164;BA.debugLine="Dim Panel As Panel";
Debug.ShouldStop(8);
_panel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("Panel", _panel);
 BA.debugLineNum = 165;BA.debugLine="Panel.Initialize(\"\")";
Debug.ShouldStop(16);
_panel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 166;BA.debugLine="companyPanel.AddView(Panel, col * (mainPanel";
Debug.ShouldStop(32);
branch.mostCurrent._companypanel.runVoidMethod ("AddView",(Object)((_panel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_col,(RemoteObject.solve(new RemoteObject[] {_mainpanelwidth,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1))}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._panel2.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {_row,(RemoteObject.solve(new RemoteObject[] {_panelheight,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "+",1, 1))}, "*",0, 1))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_mainpanelwidth,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)),(Object)(_panelheight));
 BA.debugLineNum = 168;BA.debugLine="Dim PanelTitle As Panel";
Debug.ShouldStop(128);
_paneltitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("PanelTitle", _paneltitle);
 BA.debugLineNum = 169;BA.debugLine="PanelTitle.Initialize(\"Panel2\")";
Debug.ShouldStop(256);
_paneltitle.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel2")));
 BA.debugLineNum = 170;BA.debugLine="PanelTitle.Color = Colors.Black";
Debug.ShouldStop(512);
_paneltitle.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 171;BA.debugLine="PanelTitle.Tag = name";
Debug.ShouldStop(1024);
_paneltitle.runMethod(false,"setTag",(_name));
 BA.debugLineNum = 172;BA.debugLine="Panel.AddView(PanelTitle, 0, 0, Panel.Width,";
Debug.ShouldStop(2048);
_panel.runVoidMethod ("AddView",(Object)((_paneltitle.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_panel.runMethod(true,"getWidth")),(Object)(RemoteObject.solve(new RemoteObject[] {_panelheight,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))}, "-",1, 1)));
 BA.debugLineNum = 175;BA.debugLine="Dim Label17 As Label";
Debug.ShouldStop(16384);
_label17 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Label17", _label17);
 BA.debugLineNum = 176;BA.debugLine="Label17.Initialize(\"Label17\")";
Debug.ShouldStop(32768);
_label17.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Label17")));
 BA.debugLineNum = 177;BA.debugLine="Label17.Text = name.ToUpperCase";
Debug.ShouldStop(65536);
_label17.runMethod(true,"setText",BA.ObjectToCharSequence(_name.runMethod(true,"toUpperCase")));
 BA.debugLineNum = 178;BA.debugLine="Label17.Tag = company_id";
Debug.ShouldStop(131072);
_label17.runMethod(false,"setTag",(_company_id));
 BA.debugLineNum = 179;BA.debugLine="Label17.TextSize = 18";
Debug.ShouldStop(262144);
_label17.runMethod(true,"setTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 180;BA.debugLine="Label17.TextColor = Colors.White";
Debug.ShouldStop(524288);
_label17.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 181;BA.debugLine="Label17.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(1048576);
_label17.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 182;BA.debugLine="Label17.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(2097152);
_label17.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 183;BA.debugLine="PanelTitle.AddView(Label17, 5dip, 0dip, Pane";
Debug.ShouldStop(4194304);
_paneltitle.runVoidMethod ("AddView",(Object)((_label17.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(_paneltitle.runMethod(true,"getWidth")),(Object)(_paneltitle.runMethod(true,"getHeight")));
 BA.debugLineNum = 199;BA.debugLine="Dim panelWidth As Int = Panel.Width /3";
Debug.ShouldStop(64);
_panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(3)}, "/",0, 0));Debug.locals.put("panelWidth", _panelwidth);Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 200;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(128);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 201;BA.debugLine="Dim labelheight As Int = panelHeight - Panel";
Debug.ShouldStop(256);
_labelheight = RemoteObject.solve(new RemoteObject[] {_panelheight,_paneltitle.runMethod(true,"getHeight")}, "-",1, 1);Debug.locals.put("labelheight", _labelheight);Debug.locals.put("labelheight", _labelheight);
 BA.debugLineNum = 202;BA.debugLine="panelWidth = Panel.Width /2";
Debug.ShouldStop(512);
_panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 204;BA.debugLine="Dim totalStore As Label";
Debug.ShouldStop(2048);
_totalstore = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalStore", _totalstore);
 BA.debugLineNum = 205;BA.debugLine="totalStore.Initialize(\"\")";
Debug.ShouldStop(4096);
_totalstore.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 206;BA.debugLine="totalStore.Text = total_count";
Debug.ShouldStop(8192);
_totalstore.runMethod(true,"setText",BA.ObjectToCharSequence(_total_count));
 BA.debugLineNum = 207;BA.debugLine="totalStore.TextColor = Colors.Black";
Debug.ShouldStop(16384);
_totalstore.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 208;BA.debugLine="totalStore.TextSize = primaryFontSize";
Debug.ShouldStop(32768);
_totalstore.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 209;BA.debugLine="totalStore.Gravity = Gravity.CENTER";
Debug.ShouldStop(65536);
_totalstore.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 210;BA.debugLine="totalStore.Typeface = Typeface.SERIF";
Debug.ShouldStop(131072);
_totalstore.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 211;BA.debugLine="Panel.AddView(totalStore,0,PanelTitle.Height";
Debug.ShouldStop(262144);
_panel.runVoidMethod ("AddView",(Object)((_totalstore.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_paneltitle.runMethod(true,"getHeight")),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_labelheight,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 1)));
 BA.debugLineNum = 212;BA.debugLine="AdjustFontSizeToHeight(totalStore,1.3)";
Debug.ShouldStop(524288);
_adjustfontsizetoheight(_totalstore,BA.numberCast(float.class, 1.3));
 BA.debugLineNum = 214;BA.debugLine="Dim totalStoreLabel As Label";
Debug.ShouldStop(2097152);
_totalstorelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalStoreLabel", _totalstorelabel);
 BA.debugLineNum = 215;BA.debugLine="totalStoreLabel.Initialize(\"\")";
Debug.ShouldStop(4194304);
_totalstorelabel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 216;BA.debugLine="totalStoreLabel.Text = \" Total Store\"";
Debug.ShouldStop(8388608);
_totalstorelabel.runMethod(true,"setText",BA.ObjectToCharSequence(" Total Store"));
 BA.debugLineNum = 217;BA.debugLine="totalStoreLabel.TextColor = Colors.Gray";
Debug.ShouldStop(16777216);
_totalstorelabel.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 218;BA.debugLine="totalStoreLabel.TextSize = secondaryFontSize";
Debug.ShouldStop(33554432);
_totalstorelabel.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 219;BA.debugLine="totalStoreLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(67108864);
_totalstorelabel.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 220;BA.debugLine="totalStoreLabel.Typeface = Typeface.MONOSPAC";
Debug.ShouldStop(134217728);
_totalstorelabel.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 221;BA.debugLine="totalStoreLabel.Text = totalStoreLabel.Text.";
Debug.ShouldStop(268435456);
_totalstorelabel.runMethod(true,"setText",BA.ObjectToCharSequence(_totalstorelabel.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 222;BA.debugLine="Panel.AddView(totalStoreLabel,0,totalStore.t";
Debug.ShouldStop(536870912);
_panel.runVoidMethod ("AddView",(Object)((_totalstorelabel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_totalstore.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 224;BA.debugLine="Dim totalPos As Label";
Debug.ShouldStop(-2147483648);
_totalpos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPos", _totalpos);
 BA.debugLineNum = 225;BA.debugLine="totalPos.Initialize(\"\")";
Debug.ShouldStop(1);
_totalpos.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 226;BA.debugLine="totalPos.Text = total_pos";
Debug.ShouldStop(2);
_totalpos.runMethod(true,"setText",BA.ObjectToCharSequence(_total_pos));
 BA.debugLineNum = 227;BA.debugLine="totalPos.TextColor = Colors.Black";
Debug.ShouldStop(4);
_totalpos.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 228;BA.debugLine="totalPos.TextSize = primaryFontSize";
Debug.ShouldStop(8);
_totalpos.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 229;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
Debug.ShouldStop(16);
_totalpos.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 230;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
Debug.ShouldStop(32);
_totalpos.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 231;BA.debugLine="Panel.AddView(totalPos,panelWidth,PanelTitle";
Debug.ShouldStop(64);
_panel.runVoidMethod ("AddView",(Object)((_totalpos.getObject())),(Object)(_panelwidth),(Object)(_paneltitle.runMethod(true,"getHeight")),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_labelheight,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 1)));
 BA.debugLineNum = 232;BA.debugLine="AdjustFontSizeToHeight(totalPos,1.3)";
Debug.ShouldStop(128);
_adjustfontsizetoheight(_totalpos,BA.numberCast(float.class, 1.3));
 BA.debugLineNum = 234;BA.debugLine="Dim totalPosLabel As Label";
Debug.ShouldStop(512);
_totalposlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPosLabel", _totalposlabel);
 BA.debugLineNum = 235;BA.debugLine="totalPosLabel.Initialize(\"\")";
Debug.ShouldStop(1024);
_totalposlabel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 236;BA.debugLine="totalPosLabel.Text = \" Total Pos\"";
Debug.ShouldStop(2048);
_totalposlabel.runMethod(true,"setText",BA.ObjectToCharSequence(" Total Pos"));
 BA.debugLineNum = 237;BA.debugLine="totalPosLabel.TextColor = Colors.Gray";
Debug.ShouldStop(4096);
_totalposlabel.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 238;BA.debugLine="totalPosLabel.TextSize = secondaryFontSize";
Debug.ShouldStop(8192);
_totalposlabel.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 239;BA.debugLine="totalPosLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(16384);
_totalposlabel.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 240;BA.debugLine="totalPosLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(32768);
_totalposlabel.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 241;BA.debugLine="totalPosLabel.Text = totalPosLabel.Text.ToUp";
Debug.ShouldStop(65536);
_totalposlabel.runMethod(true,"setText",BA.ObjectToCharSequence(_totalposlabel.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 242;BA.debugLine="Panel.AddView(totalPosLabel,panelWidth,total";
Debug.ShouldStop(131072);
_panel.runVoidMethod ("AddView",(Object)((_totalposlabel.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_totalpos.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 245;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(1048576);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 246;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 0dip, Col";
Debug.ShouldStop(2097152);
_cd.runVoidMethod ("Initialize2",(Object)(branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 247;BA.debugLine="Panel.Background = cd";
Debug.ShouldStop(4194304);
_panel.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 248;BA.debugLine="count = count + 1";
Debug.ShouldStop(8388608);
_count = RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("count", _count);
 }
}Debug.locals.put("record", _record);
;
 BA.debugLineNum = 251;BA.debugLine="totalGetDataHeight = Panel2.Height+companyPan";
Debug.ShouldStop(67108864);
branch._totalgetdataheight = RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._panel2.runMethod(true,"getHeight"),branch.mostCurrent._companypanel.runMethod(true,"getHeight")}, "+",1, 1);
 break; }
case 1: {
 BA.debugLineNum = 253;BA.debugLine="Dim salesArray As List = parser.NextArray";
Debug.ShouldStop(268435456);
_salesarray = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_salesarray = _parser.runMethod(false,"NextArray");Debug.locals.put("salesArray", _salesarray);Debug.locals.put("salesArray", _salesarray);
 BA.debugLineNum = 257;BA.debugLine="If salesArray.Size = 0 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_salesarray.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 258;BA.debugLine="ToastMessageShow(\"No data received\", True)";
Debug.ShouldStop(2);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No data received")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 259;BA.debugLine="Return";
Debug.ShouldStop(4);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 262;BA.debugLine="Dim totalCompanies As Int = salesArray.Size";
Debug.ShouldStop(32);
_totalcompanies = _salesarray.runMethod(true,"getSize");Debug.locals.put("totalCompanies", _totalcompanies);Debug.locals.put("totalCompanies", _totalcompanies);
 BA.debugLineNum = 263;BA.debugLine="Dim sales(totalCompanies) As Int";
Debug.ShouldStop(64);
_sales = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales", _sales);
 BA.debugLineNum = 264;BA.debugLine="Dim comId(totalCompanies) As Int";
Debug.ShouldStop(128);
_comid = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("comId", _comid);
 BA.debugLineNum = 265;BA.debugLine="Dim sales1(totalCompanies) As Int";
Debug.ShouldStop(256);
_sales1 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales1", _sales1);
 BA.debugLineNum = 266;BA.debugLine="Dim sales2(totalCompanies) As Int";
Debug.ShouldStop(512);
_sales2 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales2", _sales2);
 BA.debugLineNum = 267;BA.debugLine="Dim purchase(totalCompanies) As Int";
Debug.ShouldStop(1024);
_purchase = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase", _purchase);
 BA.debugLineNum = 268;BA.debugLine="Dim purchase1(totalCompanies) As Int";
Debug.ShouldStop(2048);
_purchase1 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase1", _purchase1);
 BA.debugLineNum = 269;BA.debugLine="Dim purchase2(totalCompanies) As Int";
Debug.ShouldStop(4096);
_purchase2 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase2", _purchase2);
 BA.debugLineNum = 270;BA.debugLine="Dim companyName(totalCompanies) As String";
Debug.ShouldStop(8192);
_companyname = RemoteObject.createNewArray ("String", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("companyName", _companyname);
 BA.debugLineNum = 271;BA.debugLine="Dim max_value(totalCompanies) As Int";
Debug.ShouldStop(16384);
_max_value = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("max_value", _max_value);
 BA.debugLineNum = 272;BA.debugLine="Dim maxSale As Int=0";
Debug.ShouldStop(32768);
_maxsale = BA.numberCast(int.class, 0);Debug.locals.put("maxSale", _maxsale);Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 274;BA.debugLine="For i = 0 To totalCompanies - 1";
Debug.ShouldStop(131072);
{
final int step122 = 1;
final int limit122 = RemoteObject.solve(new RemoteObject[] {_totalcompanies,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step122 > 0 && _i <= limit122) || (step122 < 0 && _i >= limit122) ;_i = ((int)(0 + _i + step122))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 275;BA.debugLine="Dim record As Map = salesArray.Get(i)";
Debug.ShouldStop(262144);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _salesarray.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("record", _record);Debug.locals.put("record", _record);
 BA.debugLineNum = 276;BA.debugLine="companyName(i) = record.GetDefault(\"company_";
Debug.ShouldStop(524288);
_companyname.setArrayElement (BA.ObjectToString(_record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("company_name"))),(Object)((RemoteObject.createImmutable("Unknown"))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 277;BA.debugLine="comId(i) = record.GetDefault(\"comId\", 0)";
Debug.ShouldStop(1048576);
_comid.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("comId"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 278;BA.debugLine="sales(i) = record.GetDefault(\"sales_1\", 0)";
Debug.ShouldStop(2097152);
_sales.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_1"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 279;BA.debugLine="sales1(i) = record.GetDefault(\"sales_2\", 0)";
Debug.ShouldStop(4194304);
_sales1.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_2"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 280;BA.debugLine="sales2(i) = record.GetDefault(\"sales_3\", 0)";
Debug.ShouldStop(8388608);
_sales2.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_3"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 281;BA.debugLine="purchase(i) = record.GetDefault(\"purchase_1\"";
Debug.ShouldStop(16777216);
_purchase.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_1"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 282;BA.debugLine="purchase1(i) = record.GetDefault(\"purchase_2";
Debug.ShouldStop(33554432);
_purchase1.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_2"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 283;BA.debugLine="purchase2(i) = record.GetDefault(\"purchase_\"";
Debug.ShouldStop(67108864);
_purchase2.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 284;BA.debugLine="max_value(i) = record.GetDefault(\"max_value\"";
Debug.ShouldStop(134217728);
_max_value.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("max_value"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 285;BA.debugLine="maxSale = Max(maxSale, max_value(i))";
Debug.ShouldStop(268435456);
_maxsale = BA.numberCast(int.class, branch.mostCurrent.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, _maxsale)),(Object)(BA.numberCast(double.class, _max_value.getArrayElement(true,BA.numberCast(int.class, _i))))));Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 286;BA.debugLine="Log(companyName(i) & sales(i))";
Debug.ShouldStop(536870912);
<<<<<<< HEAD
branch.mostCurrent.__c.runVoidMethod ("LogImpl","61638585",RemoteObject.concat(_companyname.getArrayElement(true,BA.numberCast(int.class, _i)),_sales.getArrayElement(true,BA.numberCast(int.class, _i))),0);
=======
branch.mostCurrent._bargraph.setField ("_comid1" /*RemoteObject*/ ,_branchsales1);
 BA.debugLineNum = 479;BA.debugLine="barGraph.UpdateGraph";
Debug.ShouldStop(1073741824);
branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_updategraph" /*RemoteObject*/ );
 };
 BA.debugLineNum = 482;BA.debugLine="backbtn.Enabled = currentPage > 1";
Debug.ShouldStop(2);
branch.mostCurrent._backbtn.runMethod(true,"setEnabled",BA.ObjectToBoolean(RemoteObject.solveBoolean(">",branch._currentpage,BA.numberCast(double.class, 1))));
 }else {
 BA.debugLineNum = 485;BA.debugLine="Log($\"Company: ${name} has no branches inf";
Debug.ShouldStop(16);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","01376581",(RemoteObject.concat(RemoteObject.createImmutable("Company: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_name))),RemoteObject.createImmutable(" has no branches information."))),0);
 };
 };
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 289;BA.debugLine="Activity.Initialize(\"\")";
Debug.ShouldStop(1);
branch.mostCurrent._activity.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 291;BA.debugLine="Dim legend() As String = Array As String(\"Sal";
Debug.ShouldStop(4);
branch.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Sales1"),BA.ObjectToString("Sales2"),RemoteObject.createImmutable("Sales3")});
 BA.debugLineNum = 293;BA.debugLine="If barGraphInitialized = False Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",branch._bargraphinitialized,branch.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 294;BA.debugLine="saleNxtBtn.Initialize(\"nxtBtn\")";
Debug.ShouldStop(32);
branch.mostCurrent._salenxtbtn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("nxtBtn")));
 BA.debugLineNum = 295;BA.debugLine="saleBackBtn.Initialize(\"backbtn\")";
Debug.ShouldStop(64);
branch.mostCurrent._salebackbtn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("backbtn")));
 BA.debugLineNum = 296;BA.debugLine="sortBtn1.Initialize(\"sortBtn1\")";
Debug.ShouldStop(128);
branch.mostCurrent._sortbtn1.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtn1")));
 BA.debugLineNum = 297;BA.debugLine="sortBtn2.Initialize(\"sortBtn2\")";
Debug.ShouldStop(256);
branch.mostCurrent._sortbtn2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtn2")));
 BA.debugLineNum = 298;BA.debugLine="defBtn.Initialize(\"defBtn\")";
Debug.ShouldStop(512);
branch.mostCurrent._defbtn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("defBtn")));
 BA.debugLineNum = 299;BA.debugLine="sales1btn.Initialize(\"sales1btn\")";
Debug.ShouldStop(1024);
branch.mostCurrent._sales1btn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales1btn")));
 BA.debugLineNum = 300;BA.debugLine="sales2btn.Initialize(\"sales2btn\")";
Debug.ShouldStop(2048);
branch.mostCurrent._sales2btn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales2btn")));
 BA.debugLineNum = 301;BA.debugLine="sales3btn.Initialize(\"sales3btn\")";
Debug.ShouldStop(4096);
branch.mostCurrent._sales3btn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales3btn")));
 BA.debugLineNum = 302;BA.debugLine="Dim totalSalePanel As Panel";
Debug.ShouldStop(8192);
_totalsalepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("totalSalePanel", _totalsalepanel);
 BA.debugLineNum = 303;BA.debugLine="totalSalePanel.Initialize(\"\")";
Debug.ShouldStop(16384);
_totalsalepanel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 304;BA.debugLine="ScrollView1.Panel.AddView(totalSalePanel,5di";
Debug.ShouldStop(32768);
branch.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_totalsalepanel.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._panel2.runMethod(true,"getHeight"),branch.mostCurrent._companypanel.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 28)))}, "+-",2, 1)),(Object)(branch.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 307;BA.debugLine="Dim totalSaleLabel As Label";
Debug.ShouldStop(262144);
_totalsalelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalSaleLabel", _totalsalelabel);
 BA.debugLineNum = 308;BA.debugLine="totalSaleLabel.Initialize(\"\")";
Debug.ShouldStop(524288);
_totalsalelabel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 309;BA.debugLine="totalSaleLabel.Text = \"Total Sales\"";
Debug.ShouldStop(1048576);
_totalsalelabel.runMethod(true,"setText",BA.ObjectToCharSequence("Total Sales"));
 BA.debugLineNum = 310;BA.debugLine="totalSaleLabel.TextColor = Colors.Black";
Debug.ShouldStop(2097152);
_totalsalelabel.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 311;BA.debugLine="totalSaleLabel.Gravity = Gravity.CENTER_VERT";
Debug.ShouldStop(4194304);
_totalsalelabel.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 312;BA.debugLine="totalSaleLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(8388608);
_totalsalelabel.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 317;BA.debugLine="ScrollView1.Panel.AddView(barPanel,25dip,tot";
Debug.ShouldStop(268435456);
branch.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((branch.mostCurrent._barpanel.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(RemoteObject.solve(new RemoteObject[] {_totalsalelabel.runMethod(true,"getHeight"),branch.mostCurrent._panel2.runMethod(true,"getHeight"),branch.mostCurrent._companypanel.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "++-",3, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._activity.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 450)))));
 BA.debugLineNum = 318;BA.debugLine="barPanel.Color = Colors.White";
Debug.ShouldStop(536870912);
branch.mostCurrent._barpanel.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 320;BA.debugLine="barPanel.RemoveAllViews";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._barpanel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 321;BA.debugLine="barPanel.Invalidate ' Force a redraw";
Debug.ShouldStop(1);
branch.mostCurrent._barpanel.runVoidMethod ("Invalidate");
 BA.debugLineNum = 324;BA.debugLine="barGraph.Initialize(Activity,barPanel,sales,";
Debug.ShouldStop(8);
branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_initialize" /*RemoteObject*/ ,branch.mostCurrent.activityBA,(Object)(branch.mostCurrent._activity),(Object)(branch.mostCurrent._barpanel),(Object)(_sales),(Object)(_sales1),(Object)(_sales2),(Object)(_companyname),(Object)(branch.mostCurrent._legend),(Object)(_maxsale),(Object)(BA.ObjectToString("Total Sale of the Company")),(Object)(_comid),(Object)(BA.ObjectToString("Branch")),(Object)(branch.mostCurrent._salenxtbtn),(Object)(branch.mostCurrent._salebackbtn),(Object)(branch.mostCurrent._sortbtn1),(Object)(branch.mostCurrent._sortbtn2),(Object)(branch.mostCurrent._defbtn),(Object)(branch.mostCurrent._sales1btn),(Object)(branch.mostCurrent._sales2btn),(Object)(branch.mostCurrent._sales3btn));
 BA.debugLineNum = 325;BA.debugLine="legend = Array As String(\"Purchase1\",\"Purcha";
Debug.ShouldStop(16);
branch.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Purchase1"),BA.ObjectToString("Purchase2"),RemoteObject.createImmutable("Purchase3")});
 BA.debugLineNum = 340;BA.debugLine="Dim totalPurchaseLabel As Label";
Debug.ShouldStop(524288);
_totalpurchaselabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPurchaseLabel", _totalpurchaselabel);
 BA.debugLineNum = 341;BA.debugLine="totalPurchaseLabel.Initialize(\"\")";
Debug.ShouldStop(1048576);
_totalpurchaselabel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 342;BA.debugLine="totalPurchaseLabel.Text = \"Total Purchases\"";
Debug.ShouldStop(2097152);
_totalpurchaselabel.runMethod(true,"setText",BA.ObjectToCharSequence("Total Purchases"));
 BA.debugLineNum = 343;BA.debugLine="totalPurchaseLabel.TextColor =Colors.Black";
Debug.ShouldStop(4194304);
_totalpurchaselabel.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 344;BA.debugLine="totalPurchaseLabel.Gravity = Gravity.CENTER_";
Debug.ShouldStop(8388608);
_totalpurchaselabel.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 345;BA.debugLine="totalPurchaseLabel.Typeface = Typeface.MONOS";
Debug.ShouldStop(16777216);
_totalpurchaselabel.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 349;BA.debugLine="Dim shadowPurchPanel As Panel";
Debug.ShouldStop(268435456);
_shadowpurchpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("shadowPurchPanel", _shadowpurchpanel);
 BA.debugLineNum = 350;BA.debugLine="shadowPurchPanel.Initialize(\"\")";
Debug.ShouldStop(536870912);
_shadowpurchpanel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 351;BA.debugLine="shadowPurchPanel.Color = Colors.ARGB(50, 138";
Debug.ShouldStop(1073741824);
_shadowpurchpanel.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 138)),(Object)(BA.numberCast(int.class, 138)),(Object)(BA.numberCast(int.class, 138))));
 BA.debugLineNum = 352;BA.debugLine="ScrollView1.Panel.AddView(shadowPurchPanel,";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_shadowpurchpanel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25))),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_totalsalelabel.runMethod(true,"getHeight"),branch.mostCurrent._panel2.runMethod(true,"getHeight"),branch.mostCurrent._companypanel.runMethod(true,"getHeight"),branch.mostCurrent._barpanel.runMethod(true,"getHeight"),_totalpurchaselabel.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "++++-+",6, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._activity.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 450)))));
 BA.debugLineNum = 354;BA.debugLine="purchasePanel.Initialize(\"\")";
Debug.ShouldStop(2);
branch.mostCurrent._purchasepanel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 355;BA.debugLine="purchasePanel.Color = Colors.White";
Debug.ShouldStop(4);
branch.mostCurrent._purchasepanel.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 356;BA.debugLine="ScrollView1.Panel.AddView(purchasePanel,25di";
Debug.ShouldStop(8);
branch.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((branch.mostCurrent._purchasepanel.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(RemoteObject.solve(new RemoteObject[] {_totalsalelabel.runMethod(true,"getHeight"),branch.mostCurrent._panel2.runMethod(true,"getHeight"),branch.mostCurrent._companypanel.runMethod(true,"getHeight"),branch.mostCurrent._barpanel.runMethod(true,"getHeight"),_totalpurchaselabel.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "++++-",5, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._activity.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 450)))));
 BA.debugLineNum = 357;BA.debugLine="purchNxtBtn.Initialize(\"nxtBtn\")";
Debug.ShouldStop(16);
branch.mostCurrent._purchnxtbtn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("nxtBtn")));
 BA.debugLineNum = 358;BA.debugLine="purchBackBtn.Initialize(\"backbtn\")";
Debug.ShouldStop(32);
branch.mostCurrent._purchbackbtn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("backbtn")));
 BA.debugLineNum = 359;BA.debugLine="sortBtn1.Initialize(\"sortBtn1\")";
Debug.ShouldStop(64);
branch.mostCurrent._sortbtn1.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtn1")));
 BA.debugLineNum = 360;BA.debugLine="sortBtn2.Initialize(\"sortBtn2\")";
Debug.ShouldStop(128);
branch.mostCurrent._sortbtn2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtn2")));
 BA.debugLineNum = 361;BA.debugLine="defBtn.Initialize(\"defBtn\")";
Debug.ShouldStop(256);
branch.mostCurrent._defbtn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("defBtn")));
 BA.debugLineNum = 362;BA.debugLine="sales1btn.Initialize(\"sales1btn\")";
Debug.ShouldStop(512);
branch.mostCurrent._sales1btn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales1btn")));
 BA.debugLineNum = 363;BA.debugLine="sales2btn.Initialize(\"sales2btn\")";
Debug.ShouldStop(1024);
branch.mostCurrent._sales2btn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales2btn")));
 BA.debugLineNum = 364;BA.debugLine="sales3btn.Initialize(\"sales3btn\")";
Debug.ShouldStop(2048);
branch.mostCurrent._sales3btn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales3btn")));
 BA.debugLineNum = 366;BA.debugLine="barGraph1.Initialize(Activity, purchasePanel";
Debug.ShouldStop(8192);
branch.mostCurrent._bargraph1.runClassMethod (b4a.example.bargraph.class, "_initialize" /*RemoteObject*/ ,branch.mostCurrent.activityBA,(Object)(branch.mostCurrent._activity),(Object)(branch.mostCurrent._purchasepanel),(Object)(_purchase),(Object)(_purchase1),(Object)(_purchase2),(Object)(_companyname),(Object)(branch.mostCurrent._legend),(Object)(_maxsale),(Object)(BA.ObjectToString("Total Purchase Per Company")),(Object)(_comid),(Object)(BA.ObjectToString("Branch")),(Object)(branch.mostCurrent._purchnxtbtn),(Object)(branch.mostCurrent._purchbackbtn),(Object)(branch.mostCurrent._sortbtn1),(Object)(branch.mostCurrent._sortbtn2),(Object)(branch.mostCurrent._defbtn),(Object)(branch.mostCurrent._sales1btn),(Object)(branch.mostCurrent._sales2btn),(Object)(branch.mostCurrent._sales3btn));
 BA.debugLineNum = 367;BA.debugLine="Log($\"maxSale:${maxSale}\"$)";
Debug.ShouldStop(16384);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","61638666",(RemoteObject.concat(RemoteObject.createImmutable("maxSale:"),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_maxsale))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 370;BA.debugLine="barGraphInitialized = True";
Debug.ShouldStop(131072);
branch._bargraphinitialized = branch.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 371;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(262144);
branch.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 }else {
 BA.debugLineNum = 373;BA.debugLine="barGraph.sale_1 = sales";
Debug.ShouldStop(1048576);
branch.mostCurrent._bargraph.setField ("_sale_1" /*RemoteObject*/ ,_sales);
 BA.debugLineNum = 374;BA.debugLine="barGraph.sale_2 = sales1";
Debug.ShouldStop(2097152);
branch.mostCurrent._bargraph.setField ("_sale_2" /*RemoteObject*/ ,_sales1);
 BA.debugLineNum = 375;BA.debugLine="barGraph.sale_3 = sales2";
Debug.ShouldStop(4194304);
branch.mostCurrent._bargraph.setField ("_sale_3" /*RemoteObject*/ ,_sales2);
 BA.debugLineNum = 376;BA.debugLine="barGraph.product1 = companyName";
Debug.ShouldStop(8388608);
branch.mostCurrent._bargraph.setField ("_product1" /*RemoteObject*/ ,_companyname);
 BA.debugLineNum = 377;BA.debugLine="barGraph.comId1 = sales ' Assuming comId1 sh";
Debug.ShouldStop(16777216);
branch.mostCurrent._bargraph.setField ("_comid1" /*RemoteObject*/ ,_sales);
 BA.debugLineNum = 378;BA.debugLine="barGraph.UpdateGraph";
Debug.ShouldStop(33554432);
branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_updategraph" /*RemoteObject*/ );
 BA.debugLineNum = 379;BA.debugLine="barGraph.SetCurrentPage(currentPage) ' Updat";
Debug.ShouldStop(67108864);
branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_setcurrentpage" /*RemoteObject*/ ,(Object)(branch._currentpage));
 };
 break; }
case 2: {
 BA.debugLineNum = 382;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
Debug.ShouldStop(536870912);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Data updated successfully")),(Object)(branch.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 383;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(1073741824);
_loadcompanydata();
 break; }
default: {
<<<<<<< HEAD
 BA.debugLineNum = 385;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
Debug.ShouldStop(1);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","61638684",RemoteObject.concat(RemoteObject.createImmutable("Unknown job: "),_job.getField(true,"_jobname" /*RemoteObject*/ )),0);
=======
 BA.debugLineNum = 491;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
Debug.ShouldStop(1024);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","01376587",RemoteObject.concat(RemoteObject.createImmutable("Unknown job: "),_job.getField(true,"_jobname" /*RemoteObject*/ )),0);
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
 break; }
}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e203) {
			BA.rdebugUtils.runVoidMethod("setLastException",branch.processBA, e203.toString()); BA.debugLineNum = 390;BA.debugLine="ToastMessageShow(\"Error parsing sales data\", Tr";
Debug.ShouldStop(32);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Error parsing sales data")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 393;BA.debugLine="ScrollView1.Panel.Height = 1400dip";
Debug.ShouldStop(256);
branch.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1400))));
 }else {
 BA.debugLineNum = 395;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
Debug.ShouldStop(1024);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 397;BA.debugLine="job.Release";
Debug.ShouldStop(4096);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 398;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
<<<<<<< HEAD
		Debug.PushSubsStack("Label17_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,416);
=======
		Debug.PushSubsStack("Label17_Click (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,556);
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
if (RapidSub.canDelegate("label17_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","label17_click");}
RemoteObject _clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _selectedcompany = RemoteObject.createImmutable("");
 BA.debugLineNum = 416;BA.debugLine="Private Sub Label17_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 417;BA.debugLine="Dim clickedLabel As Label = Sender ' Get the clic";
Debug.ShouldStop(1);
_clickedlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("clickedLabel", _clickedlabel);Debug.locals.put("clickedLabel", _clickedlabel);
 BA.debugLineNum = 418;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
Debug.ShouldStop(2);
_selectedcompany = BA.ObjectToString(_clickedlabel.runMethod(false,"getTag"));Debug.locals.put("selectedCompany", _selectedcompany);Debug.locals.put("selectedCompany", _selectedcompany);
 BA.debugLineNum = 420;BA.debugLine="Starter.company_selected = selectedCompany";
Debug.ShouldStop(8);
branch.mostCurrent._starter._company_selected /*RemoteObject*/  = _selectedcompany;
 BA.debugLineNum = 423;BA.debugLine="StartActivity(\"Branch\")";
Debug.ShouldStop(64);
branch.mostCurrent.__c.runVoidMethod ("StartActivity",branch.processBA,(Object)((RemoteObject.createImmutable("Branch"))));
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
public static RemoteObject  _loadcompanydata() throws Exception{
try {
<<<<<<< HEAD
		Debug.PushSubsStack("LoadCompanyData (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,73);
=======
		Debug.PushSubsStack("LoadCompanyData (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,141);
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
if (RapidSub.canDelegate("loadcompanydata")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","loadcompanydata");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 73;BA.debugLine="Sub LoadCompanyData";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="Try";
Debug.ShouldStop(512);
try { BA.debugLineNum = 75;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(1024);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 76;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
Debug.ShouldStop(2048);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,branch.processBA,(Object)(BA.ObjectToString("GetData")),(Object)(branch.getObject()));
 BA.debugLineNum = 77;BA.debugLine="Job1.Download(PHPURL)";
Debug.ShouldStop(4096);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(branch.mostCurrent._phpurl));
 BA.debugLineNum = 78;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
Debug.ShouldStop(8192);
branch.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",branch.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Data..."))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e7) {
			BA.rdebugUtils.runVoidMethod("setLastException",branch.processBA, e7.toString()); BA.debugLineNum = 80;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(32768);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","61507335",branch.mostCurrent.__c.runMethod(false,"LastException",branch.mostCurrent.activityBA).runMethod(true,"getMessage"),0);
 };
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
<<<<<<< HEAD
		Debug.PushSubsStack("LoadGraphData (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,85);
if (RapidSub.canDelegate("loadgraphdata")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","loadgraphdata");}
=======
		Debug.PushSubsStack("LoadCompanyDataBranch (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,128);
if (RapidSub.canDelegate("loadcompanydatabranch")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","loadcompanydatabranch");}
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 85;BA.debugLine="Sub LoadGraphData";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 86;BA.debugLine="Try";
Debug.ShouldStop(2097152);
try { BA.debugLineNum = 88;BA.debugLine="PHPURLCompany = $\"https://192.168.8.117/Company/";
Debug.ShouldStop(8388608);
branch.mostCurrent._phpurlcompany = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._currentpage))),RemoteObject.createImmutable("&company_sales="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._salesdata1))),RemoteObject.createImmutable("&company_type="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable("")));
 BA.debugLineNum = 90;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(33554432);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 91;BA.debugLine="Job1.Initialize(\"GetCompany\", Me)";
Debug.ShouldStop(67108864);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,branch.processBA,(Object)(BA.ObjectToString("GetCompany")),(Object)(branch.getObject()));
 BA.debugLineNum = 92;BA.debugLine="Job1.Download(PHPURLCompany)";
Debug.ShouldStop(134217728);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(branch.mostCurrent._phpurlcompany));
 BA.debugLineNum = 93;BA.debugLine="ProgressDialogShow(\"Loading Graph Data...\")";
Debug.ShouldStop(268435456);
branch.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",branch.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Graph Data..."))));
 Debug.CheckDeviceExceptions();
} 
<<<<<<< HEAD
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",branch.processBA, e8.toString()); BA.debugLineNum = 95;BA.debugLine="Log(\"LoadGraphData Error: \" & LastException.Mess";
Debug.ShouldStop(1073741824);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","69633802",RemoteObject.concat(RemoteObject.createImmutable("LoadGraphData Error: "),branch.mostCurrent.__c.runMethod(false,"LastException",branch.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 BA.debugLineNum = 96;BA.debugLine="ToastMessageShow(\"Error initiating graph load: \"";
Debug.ShouldStop(-2147483648);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error initiating graph load: "),branch.mostCurrent.__c.runMethod(false,"LastException",branch.mostCurrent.activityBA).runMethod(true,"getMessage")))),(Object)(branch.mostCurrent.__c.getField(true,"True")));
=======
       catch (Exception e7) {
			BA.rdebugUtils.runVoidMethod("setLastException",branch.processBA, e7.toString()); BA.debugLineNum = 136;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(128);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","01179656",branch.mostCurrent.__c.runMethod(false,"LastException",branch.mostCurrent.activityBA).runMethod(true,"getMessage"),0);
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
 };
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
<<<<<<< HEAD
		Debug.PushSubsStack("nxtBtn_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,428);
if (RapidSub.canDelegate("nxtbtn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","nxtbtn_click");}
 BA.debugLineNum = 428;BA.debugLine="Sub nxtBtn_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 429;BA.debugLine="Log(\"sad\")";
Debug.ShouldStop(4096);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","62359297",RemoteObject.createImmutable("sad"),0);
 BA.debugLineNum = 430;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
=======
		Debug.PushSubsStack("nxtBtn_Click (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,564);
if (RapidSub.canDelegate("nxtbtn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","nxtbtn_click");}
 BA.debugLineNum = 564;BA.debugLine="Sub nxtBtn_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 565;BA.debugLine="currentPage = currentPage + 1";
Debug.ShouldStop(1048576);
branch._currentpage = RemoteObject.solve(new RemoteObject[] {branch._currentpage,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 566;BA.debugLine="Log(currentPage)";
Debug.ShouldStop(2097152);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","02097154",BA.NumberToString(branch._currentpage),0);
 BA.debugLineNum = 567;BA.debugLine="FetchNewPageData";
Debug.ShouldStop(4194304);
_fetchnewpagedata();
 BA.debugLineNum = 568;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Private xui As XUI";
branch._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 5;BA.debugLine="Public company As String";
branch._company = RemoteObject.createImmutable("");
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sales1btn_click() throws Exception{
try {
<<<<<<< HEAD
		Debug.PushSubsStack("sales1btn_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,454);
if (RapidSub.canDelegate("sales1btn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","sales1btn_click");}
=======
		Debug.PushSubsStack("responsiveLabel (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,538);
if (RapidSub.canDelegate("responsivelabel")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","responsivelabel", _label);}
RemoteObject _charwidth = RemoteObject.createImmutable(0);
RemoteObject _padding = RemoteObject.createImmutable(0);
RemoteObject _homewidth = RemoteObject.createImmutable(0);
Debug.locals.put("label", _label);
 BA.debugLineNum = 538;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 539;BA.debugLine="Dim charWidth As Int = 10dip";
Debug.ShouldStop(67108864);
_charwidth = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("charWidth", _charwidth);Debug.locals.put("charWidth", _charwidth);
 BA.debugLineNum = 540;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(134217728);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 541;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
Debug.ShouldStop(268435456);
_homewidth = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_label.runMethod(true,"getText").runMethod(true,"length"),_charwidth}, "*",0, 1)),_padding}, "+",1, 1);Debug.locals.put("homeWidth", _homewidth);Debug.locals.put("homeWidth", _homewidth);
 BA.debugLineNum = 542;BA.debugLine="Return homeWidth";
Debug.ShouldStop(536870912);
if (true) return _homewidth;
 BA.debugLineNum = 543;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _salesbtn1_click() throws Exception{
try {
		Debug.PushSubsStack("salesBtn1_Click (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,609);
if (RapidSub.canDelegate("salesbtn1_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","salesbtn1_click");}
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 454;BA.debugLine="Sub sales1btn_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 455;BA.debugLine="Dim btn As Button = Sender";
Debug.ShouldStop(64);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 456;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(128);
<<<<<<< HEAD
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 457;BA.debugLine="salesData1 = index.ToLowerCase";
Debug.ShouldStop(256);
branch._salesdata1 = BA.numberCast(int.class, _index.runMethod(true,"toLowerCase"));
 BA.debugLineNum = 458;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 460;BA.debugLine="LoadGraphData";
=======
branch.mostCurrent.__c.runVoidMethod ("LogImpl","02424839",branch.mostCurrent._sortdefaultvalue,0);
 BA.debugLineNum = 617;BA.debugLine="Log(\" sales 1 Button clicked: \" & index)";
Debug.ShouldStop(256);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","02424840",RemoteObject.concat(RemoteObject.createImmutable(" sales 1 Button clicked: "),_index),0);
 BA.debugLineNum = 618;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _salesbtn2_click() throws Exception{
try {
		Debug.PushSubsStack("salesBtn2_Click (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,620);
if (RapidSub.canDelegate("salesbtn2_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","salesbtn2_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 620;BA.debugLine="Sub salesBtn2_Click";
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
Debug.ShouldStop(2048);
_loadgraphdata();
 };
<<<<<<< HEAD
 BA.debugLineNum = 462;BA.debugLine="Log(sortDefaultValue)";
Debug.ShouldStop(8192);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","69764872",branch.mostCurrent._sortdefaultvalue,0);
 BA.debugLineNum = 463;BA.debugLine="Log(\" sales 1 Button clicked: \" & index)";
Debug.ShouldStop(16384);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","69764873",RemoteObject.concat(RemoteObject.createImmutable(" sales 1 Button clicked: "),_index),0);
 BA.debugLineNum = 464;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
=======
 BA.debugLineNum = 627;BA.debugLine="Log(sortDefaultValue)";
Debug.ShouldStop(262144);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","02490375",branch.mostCurrent._sortdefaultvalue,0);
 BA.debugLineNum = 628;BA.debugLine="Log(index)";
Debug.ShouldStop(524288);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","02490376",_index,0);
 BA.debugLineNum = 629;BA.debugLine="Log(\"(Sale2)\")";
Debug.ShouldStop(1048576);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","02490377",RemoteObject.createImmutable("(Sale2)"),0);
 BA.debugLineNum = 630;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
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
<<<<<<< HEAD
		Debug.PushSubsStack("sales2btn_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,466);
if (RapidSub.canDelegate("sales2btn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","sales2btn_click");}
=======
		Debug.PushSubsStack("salesBtn3_Click (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,631);
if (RapidSub.canDelegate("salesbtn3_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","salesbtn3_click");}
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 466;BA.debugLine="Sub sales2btn_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 467;BA.debugLine="Dim btn As Button = Sender";
Debug.ShouldStop(262144);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 468;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(524288);
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 469;BA.debugLine="salesData1 = index.ToLowerCase";
Debug.ShouldStop(1048576);
branch._salesdata1 = BA.numberCast(int.class, _index.runMethod(true,"toLowerCase"));
 BA.debugLineNum = 470;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 471;BA.debugLine="LoadGraphData";
Debug.ShouldStop(4194304);
_loadgraphdata();
 };
 BA.debugLineNum = 473;BA.debugLine="Log(sortDefaultValue)";
Debug.ShouldStop(16777216);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","69830407",branch.mostCurrent._sortdefaultvalue,0);
 BA.debugLineNum = 474;BA.debugLine="Log(\" sales 2 Button clicked: \" & index)";
Debug.ShouldStop(33554432);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","69830408",RemoteObject.concat(RemoteObject.createImmutable(" sales 2 Button clicked: "),_index),0);
 BA.debugLineNum = 475;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("sales3btn_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,476);
if (RapidSub.canDelegate("sales3btn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","sales3btn_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 476;BA.debugLine="Sub sales3btn_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 477;BA.debugLine="Dim btn As Button = Sender";
Debug.ShouldStop(268435456);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 478;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(536870912);
<<<<<<< HEAD
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 479;BA.debugLine="salesData1 = index.ToLowerCase";
Debug.ShouldStop(1073741824);
branch._salesdata1 = BA.numberCast(int.class, _index.runMethod(true,"toLowerCase"));
 BA.debugLineNum = 480;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 };
 BA.debugLineNum = 483;BA.debugLine="Log(sortDefaultValue)";
Debug.ShouldStop(4);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","69895943",branch.mostCurrent._sortdefaultvalue,0);
 BA.debugLineNum = 484;BA.debugLine="Log(\" sales 3 Button clicked: \" & index)";
Debug.ShouldStop(8);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","69895944",RemoteObject.concat(RemoteObject.createImmutable(" sales 3 Button clicked: "),_index),0);
 BA.debugLineNum = 485;BA.debugLine="End Sub";
Debug.ShouldStop(16);
=======
branch.mostCurrent.__c.runVoidMethod ("LogImpl","02555911",branch.mostCurrent._sortdefaultvalue,0);
 BA.debugLineNum = 640;BA.debugLine="Log(index)";
Debug.ShouldStop(-2147483648);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","02555913",_index,0);
 BA.debugLineNum = 641;BA.debugLine="Log(\"(Sale3)\")";
Debug.ShouldStop(1);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","02555914",RemoteObject.createImmutable("(Sale3)"),0);
 BA.debugLineNum = 642;BA.debugLine="End Sub";
Debug.ShouldStop(2);
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
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
<<<<<<< HEAD
		Debug.PushSubsStack("sortBtn1_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,445);
=======
		Debug.PushSubsStack("sortBtn1_Click (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,600);
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
if (RapidSub.canDelegate("sortbtn1_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","sortbtn1_click");}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 445;BA.debugLine="Sub sortBtn1_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 446;BA.debugLine="Dim chk As RadioButton = Sender";
Debug.ShouldStop(536870912);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
<<<<<<< HEAD
 BA.debugLineNum = 447;BA.debugLine="Dim index As String = chk.Tag";
=======
 BA.debugLineNum = 602;BA.debugLine="Dim index As String = chk.Tag";
Debug.ShouldStop(33554432);
_index = BA.ObjectToString(_chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 604;BA.debugLine="sortDefaultValue = index.ToLowerCase";
Debug.ShouldStop(134217728);
branch.mostCurrent._sortdefaultvalue = _index.runMethod(true,"toLowerCase");
 BA.debugLineNum = 605;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
Debug.ShouldStop(268435456);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","02359301",(RemoteObject.concat(RemoteObject.createImmutable("sort value: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 606;BA.debugLine="LoadCompanyDataBranch";
Debug.ShouldStop(536870912);
_loadcompanydatabranch();
 BA.debugLineNum = 607;BA.debugLine="End Sub";
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
Debug.ShouldStop(1073741824);
_index = BA.ObjectToString(_chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 449;BA.debugLine="sortDefaultValue = index.ToLowerCase";
Debug.ShouldStop(1);
branch.mostCurrent._sortdefaultvalue = _index.runMethod(true,"toLowerCase");
 BA.debugLineNum = 450;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
Debug.ShouldStop(2);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","62621445",(RemoteObject.concat(RemoteObject.createImmutable("sort value: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 451;BA.debugLine="LoadGraphData";
Debug.ShouldStop(4);
_loadgraphdata();
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
public static RemoteObject  _sortbtn2_click() throws Exception{
try {
<<<<<<< HEAD
		Debug.PushSubsStack("sortBtn2_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,432);
=======
		Debug.PushSubsStack("sortBtn2_Click (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,590);
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
if (RapidSub.canDelegate("sortbtn2_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","sortbtn2_click");}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 432;BA.debugLine="Sub sortBtn2_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 433;BA.debugLine="Dim chk As RadioButton = Sender";
Debug.ShouldStop(65536);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 434;BA.debugLine="Dim index As String = chk.Tag";
Debug.ShouldStop(131072);
_index = BA.ObjectToString(_chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 436;BA.debugLine="sortDefaultValue = index.ToLowerCase";
Debug.ShouldStop(524288);
branch.mostCurrent._sortdefaultvalue = _index.runMethod(true,"toLowerCase");
<<<<<<< HEAD
 BA.debugLineNum = 437;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
Debug.ShouldStop(1048576);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","62555909",(RemoteObject.concat(RemoteObject.createImmutable("sort value: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 438;BA.debugLine="LoadGraphData";
Debug.ShouldStop(2097152);
_loadgraphdata();
 BA.debugLineNum = 439;BA.debugLine="Log(\"descending\")";
Debug.ShouldStop(4194304);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","62555911",RemoteObject.createImmutable("descending"),0);
 BA.debugLineNum = 440;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
=======
 BA.debugLineNum = 594;BA.debugLine="LoadCompanyDataBranch";
Debug.ShouldStop(131072);
_loadcompanydatabranch();
 BA.debugLineNum = 595;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
Debug.ShouldStop(262144);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","02293765",(RemoteObject.concat(RemoteObject.createImmutable("sort value: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 596;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _totaltarget_click() throws Exception{
try {
		Debug.PushSubsStack("totalTarget_Click (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,521);
if (RapidSub.canDelegate("totaltarget_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","totaltarget_click");}
RemoteObject _target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _target_id = RemoteObject.createImmutable("");
 BA.debugLineNum = 521;BA.debugLine="Sub totalTarget_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 522;BA.debugLine="popupPanel.Visible = True";
Debug.ShouldStop(512);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 523;BA.debugLine="Dim target_id_btn As Label = Sender";
Debug.ShouldStop(1024);
_target_id_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("target_id_btn", _target_id_btn);Debug.locals.put("target_id_btn", _target_id_btn);
 BA.debugLineNum = 524;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
Debug.ShouldStop(2048);
_target_id = BA.ObjectToString(_target_id_btn.runMethod(false,"getTag"));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 525;BA.debugLine="target_id_display.Text = target_id";
Debug.ShouldStop(4096);
branch.mostCurrent._target_id_display.runMethod(true,"setText",BA.ObjectToCharSequence(_target_id));
 BA.debugLineNum = 526;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _totaltargettitle_click() throws Exception{
try {
		Debug.PushSubsStack("totalTargetTitle_Click (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,528);
if (RapidSub.canDelegate("totaltargettitle_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","totaltargettitle_click");}
RemoteObject _target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _target_id = RemoteObject.createImmutable("");
 BA.debugLineNum = 528;BA.debugLine="Sub totalTargetTitle_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 529;BA.debugLine="popupPanel.Visible = True";
Debug.ShouldStop(65536);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 530;BA.debugLine="Dim target_id_btn As Label = Sender";
Debug.ShouldStop(131072);
_target_id_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("target_id_btn", _target_id_btn);Debug.locals.put("target_id_btn", _target_id_btn);
 BA.debugLineNum = 531;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
Debug.ShouldStop(262144);
_target_id = BA.ObjectToString(_target_id_btn.runMethod(false,"getTag"));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 532;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _updatedata_remote(RemoteObject _target_id,RemoteObject _new_value) throws Exception{
try {
		Debug.PushSubsStack("UpdateData_Remote (branch) ","branch",2,branch.mostCurrent.activityBA,branch.mostCurrent,153);
if (RapidSub.canDelegate("updatedata_remote")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","updatedata_remote", _target_id, _new_value);}
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
Debug.locals.put("target_id", _target_id);
Debug.locals.put("new_value", _new_value);
 BA.debugLineNum = 153;BA.debugLine="Sub UpdateData_Remote(target_id As Int, new_value";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 154;BA.debugLine="Dim PHPURL As String = $\"https://192.168.8.141/Co";
Debug.ShouldStop(33554432);
branch.mostCurrent._phpurl = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.141/Company/controller/company.php?action=target_update&id="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_target_id))),RemoteObject.createImmutable("&value="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_new_value))),RemoteObject.createImmutable("")));
 BA.debugLineNum = 155;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(67108864);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 156;BA.debugLine="job.Initialize(\"UpdateData\", Me)";
Debug.ShouldStop(134217728);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,branch.processBA,(Object)(BA.ObjectToString("UpdateData")),(Object)(branch.getObject()));
 BA.debugLineNum = 157;BA.debugLine="job.Download(PHPURL)";
Debug.ShouldStop(268435456);
_job.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(branch.mostCurrent._phpurl));
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
>>>>>>> 1beef7d1ede11fdd330a1990e6c0b2719dc09b75
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}