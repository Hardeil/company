package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class branch_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,352);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","activity_create", _firsttime);}
RemoteObject _popuppanelbackground = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _leftposition = RemoteObject.createImmutable(0);
RemoteObject _closebutton = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _popuptext = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _edit_button = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 352;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 354;BA.debugLine="Activity.LoadLayout(\"Branch\")";
Debug.ShouldStop(2);
branch.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Branch")),branch.mostCurrent.activityBA);
 BA.debugLineNum = 357;BA.debugLine="home.Initialize(\"home\")";
Debug.ShouldStop(16);
branch.mostCurrent._home.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("home")));
 BA.debugLineNum = 358;BA.debugLine="home.Text = \"HOME |\"";
Debug.ShouldStop(32);
branch.mostCurrent._home.runMethod(true,"setText",BA.ObjectToCharSequence("HOME |"));
 BA.debugLineNum = 359;BA.debugLine="home.TextColor = Colors.Black";
Debug.ShouldStop(64);
branch.mostCurrent._home.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 360;BA.debugLine="home.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(128);
branch.mostCurrent._home.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 361;BA.debugLine="home.Gravity = Gravity.CENTER";
Debug.ShouldStop(256);
branch.mostCurrent._home.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 362;BA.debugLine="home.TextSize = 16 '";
Debug.ShouldStop(512);
branch.mostCurrent._home.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 363;BA.debugLine="Panel3.AddView(home, 0, 0, responsiveLabel(home),";
Debug.ShouldStop(1024);
branch.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((branch.mostCurrent._home.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_responsivelabel(branch.mostCurrent._home)),(Object)(branch.mostCurrent._panel3.runMethod(true,"getHeight")));
 BA.debugLineNum = 364;BA.debugLine="Panel3.Color = Colors.Transparent";
Debug.ShouldStop(2048);
branch.mostCurrent._panel3.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 366;BA.debugLine="branches.Initialize(\"\")";
Debug.ShouldStop(8192);
branch.mostCurrent._branches.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 367;BA.debugLine="branches.Text = \"Branches\"";
Debug.ShouldStop(16384);
branch.mostCurrent._branches.runMethod(true,"setText",BA.ObjectToCharSequence("Branches"));
 BA.debugLineNum = 368;BA.debugLine="branches.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(32768);
branch.mostCurrent._branches.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 369;BA.debugLine="branches.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(65536);
branch.mostCurrent._branches.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 370;BA.debugLine="branches.TextSize = 16";
Debug.ShouldStop(131072);
branch.mostCurrent._branches.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 371;BA.debugLine="Panel3.AddView(branches, responsiveLabel(home), 0";
Debug.ShouldStop(262144);
branch.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((branch.mostCurrent._branches.getObject())),(Object)(_responsivelabel(branch.mostCurrent._home)),(Object)(BA.numberCast(int.class, 0)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))),(Object)(branch.mostCurrent._panel3.runMethod(true,"getHeight")));
 BA.debugLineNum = 374;BA.debugLine="popupPanel.Initialize(\"\")";
Debug.ShouldStop(2097152);
branch.mostCurrent._popuppanel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 375;BA.debugLine="popupPanel.Color = Colors.ARGB(200, 0, 0, 0) ' Se";
Debug.ShouldStop(4194304);
branch.mostCurrent._popuppanel.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 200)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 376;BA.debugLine="popupPanel.Visible = False";
Debug.ShouldStop(8388608);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 377;BA.debugLine="Activity.AddView(popupPanel, 0, 0, Activity.Width";
Debug.ShouldStop(16777216);
branch.mostCurrent._activity.runVoidMethod ("AddView",(Object)((branch.mostCurrent._popuppanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(branch.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(branch.mostCurrent._activity.runMethod(true,"getHeight")));
 BA.debugLineNum = 382;BA.debugLine="Dim popupPanelBackground As Panel";
Debug.ShouldStop(536870912);
_popuppanelbackground = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("popupPanelBackground", _popuppanelbackground);
 BA.debugLineNum = 383;BA.debugLine="popupPanelBackground.Initialize(\"\")";
Debug.ShouldStop(1073741824);
_popuppanelbackground.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 384;BA.debugLine="popupPanelBackground.Color = Colors.White";
Debug.ShouldStop(-2147483648);
_popuppanelbackground.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 385;BA.debugLine="popupPanel.AddView(popupPanelBackground, 70dip, 5";
Debug.ShouldStop(1);
branch.mostCurrent._popuppanel.runVoidMethod ("AddView",(Object)((_popuppanelbackground.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 550)))),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._activity.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 500)))}, "-",1, 1)));
 BA.debugLineNum = 386;BA.debugLine="Dim leftPosition As Int = (popupPanel.Width - pop";
Debug.ShouldStop(2);
_leftposition = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanel.runMethod(true,"getWidth"),_popuppanelbackground.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("leftPosition", _leftposition);Debug.locals.put("leftPosition", _leftposition);
 BA.debugLineNum = 387;BA.debugLine="popupPanelBackground.Left = leftPosition";
Debug.ShouldStop(4);
_popuppanelbackground.runMethod(true,"setLeft",_leftposition);
 BA.debugLineNum = 390;BA.debugLine="Dim closeButton As Label";
Debug.ShouldStop(32);
_closebutton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("closeButton", _closebutton);
 BA.debugLineNum = 391;BA.debugLine="closeButton.Initialize(\"closeButton\")";
Debug.ShouldStop(64);
_closebutton.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("closeButton")));
 BA.debugLineNum = 392;BA.debugLine="closeButton.Text = \"X\"";
Debug.ShouldStop(128);
_closebutton.runMethod(true,"setText",BA.ObjectToCharSequence("X"));
 BA.debugLineNum = 393;BA.debugLine="closeButton.TextSize = 20";
Debug.ShouldStop(256);
_closebutton.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 394;BA.debugLine="closeButton.TextColor = Colors.Red";
Debug.ShouldStop(512);
_closebutton.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 395;BA.debugLine="closeButton.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(1024);
_closebutton.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 396;BA.debugLine="popupPanelBackground.AddView(closeButton, popupPa";
Debug.ShouldStop(2048);
_popuppanelbackground.runVoidMethod ("AddView",(Object)((_closebutton.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_popuppanelbackground.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 398;BA.debugLine="target_id_display.Initialize(\"target_id_display\")";
Debug.ShouldStop(8192);
branch.mostCurrent._target_id_display.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("target_id_display")));
 BA.debugLineNum = 399;BA.debugLine="target_id_display.TextSize = 20";
Debug.ShouldStop(16384);
branch.mostCurrent._target_id_display.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 400;BA.debugLine="target_id_display.TextColor = Colors.Red";
Debug.ShouldStop(32768);
branch.mostCurrent._target_id_display.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 401;BA.debugLine="target_id_display.Typeface = Typeface.DEFAULT_BOL";
Debug.ShouldStop(65536);
branch.mostCurrent._target_id_display.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 402;BA.debugLine="popupPanelBackground.AddView(target_id_display, p";
Debug.ShouldStop(131072);
_popuppanelbackground.runVoidMethod ("AddView",(Object)((branch.mostCurrent._target_id_display.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_popuppanelbackground.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 406;BA.debugLine="Dim popupText As Label";
Debug.ShouldStop(2097152);
_popuptext = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("popupText", _popuptext);
 BA.debugLineNum = 407;BA.debugLine="popupText.Initialize(\"\")";
Debug.ShouldStop(4194304);
_popuptext.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 408;BA.debugLine="popupText.Text = \"Edit Target\"";
Debug.ShouldStop(8388608);
_popuptext.runMethod(true,"setText",BA.ObjectToCharSequence("Edit Target"));
 BA.debugLineNum = 409;BA.debugLine="popupText.TextColor = Colors.Black";
Debug.ShouldStop(16777216);
_popuptext.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 410;BA.debugLine="popupText.TextSize = 58";
Debug.ShouldStop(33554432);
_popuptext.runMethod(true,"setTextSize",BA.numberCast(float.class, 58));
 BA.debugLineNum = 411;BA.debugLine="popupText.Gravity = Gravity.CENTER";
Debug.ShouldStop(67108864);
_popuptext.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 412;BA.debugLine="popupPanelBackground.AddView(popupText, 25dip, 10";
Debug.ShouldStop(134217728);
_popuppanelbackground.runVoidMethod ("AddView",(Object)((_popuptext.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),branch.mostCurrent.activityBA),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 414;BA.debugLine="target_countLabel.Initialize(\"\")";
Debug.ShouldStop(536870912);
branch.mostCurrent._target_countlabel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 415;BA.debugLine="target_countLabel.TextColor = Colors.Black";
Debug.ShouldStop(1073741824);
branch.mostCurrent._target_countlabel.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 416;BA.debugLine="target_countLabel.TextSize = 58";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._target_countlabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 58));
 BA.debugLineNum = 417;BA.debugLine="target_countLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(1);
branch.mostCurrent._target_countlabel.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 418;BA.debugLine="popupPanelBackground.AddView(target_countLabel, 2";
Debug.ShouldStop(2);
_popuppanelbackground.runVoidMethod ("AddView",(Object)((branch.mostCurrent._target_countlabel.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)))),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),branch.mostCurrent.activityBA),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 419;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 251, 2";
Debug.ShouldStop(4);
branch.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 251)),(Object)(BA.numberCast(int.class, 251)),(Object)(BA.numberCast(int.class, 251))));
 BA.debugLineNum = 421;BA.debugLine="Dim edit_button As Button";
Debug.ShouldStop(16);
_edit_button = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("edit_button", _edit_button);
 BA.debugLineNum = 422;BA.debugLine="edit_button.Initialize(\"edit_button\")";
Debug.ShouldStop(32);
_edit_button.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("edit_button")));
 BA.debugLineNum = 423;BA.debugLine="edit_button.Text = \"Update\"";
Debug.ShouldStop(64);
_edit_button.runMethod(true,"setText",BA.ObjectToCharSequence("Update"));
 BA.debugLineNum = 424;BA.debugLine="edit_button.TextColor = Colors.Black";
Debug.ShouldStop(128);
_edit_button.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 425;BA.debugLine="edit_button.TextSize = 58";
Debug.ShouldStop(256);
_edit_button.runMethod(true,"setTextSize",BA.numberCast(float.class, 58));
 BA.debugLineNum = 426;BA.debugLine="edit_button.Gravity = Gravity.CENTER";
Debug.ShouldStop(512);
_edit_button.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 427;BA.debugLine="popupPanelBackground.AddView(edit_button, 25dip,";
Debug.ShouldStop(1024);
_popuppanelbackground.runVoidMethod ("AddView",(Object)((_edit_button.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),branch.mostCurrent.activityBA),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 429;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(4096);
_loadcompanydata();
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,479);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 479;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 481;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Activity_Resume (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,475);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","activity_resume");}
 BA.debugLineNum = 475;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 477;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("closeButton_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,463);
if (RapidSub.canDelegate("closebutton_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","closebutton_click");}
 BA.debugLineNum = 463;BA.debugLine="Sub closeButton_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 464;BA.debugLine="popupPanel.Visible = False";
Debug.ShouldStop(32768);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 465;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("edit_button_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,432);
if (RapidSub.canDelegate("edit_button_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","edit_button_click");}
RemoteObject _target_id = RemoteObject.createImmutable(0);
RemoteObject _new_value = RemoteObject.createImmutable(0);
 BA.debugLineNum = 432;BA.debugLine="Sub edit_button_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 433;BA.debugLine="Dim target_id As Int = target_id_display.Text '";
Debug.ShouldStop(65536);
_target_id = BA.numberCast(int.class, branch.mostCurrent._target_id_display.runMethod(true,"getText"));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 434;BA.debugLine="Dim new_value As Int = target_countLabel.Text '";
Debug.ShouldStop(131072);
_new_value = BA.numberCast(int.class, branch.mostCurrent._target_countlabel.runMethod(true,"getText"));Debug.locals.put("new_value", _new_value);Debug.locals.put("new_value", _new_value);
 BA.debugLineNum = 436;BA.debugLine="If IsNumber(target_id) And IsNumber(new_value) Th";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean(".",branch.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.NumberToString(_target_id)))) && RemoteObject.solveBoolean(".",branch.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.NumberToString(_new_value))))) { 
 BA.debugLineNum = 437;BA.debugLine="UpdateData_Remote(target_id, new_value)";
Debug.ShouldStop(1048576);
_updatedata_remote(_target_id,_new_value);
 BA.debugLineNum = 438;BA.debugLine="Log(\"Updated target \" & target_id & \" with value";
Debug.ShouldStop(2097152);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","2917510",RemoteObject.concat(RemoteObject.createImmutable("Updated target "),_target_id,RemoteObject.createImmutable(" with value "),_new_value),0);
 BA.debugLineNum = 439;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(4194304);
_loadcompanydata();
 }else {
 BA.debugLineNum = 441;BA.debugLine="Log(\"Invalid input values\")";
Debug.ShouldStop(16777216);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","2917513",RemoteObject.createImmutable("Invalid input values"),0);
 };
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim PHPURL As String = \"https://192.168.8.192/Com";
branch.mostCurrent._phpurl = RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.192/Company/fetch.php?action=get_branch&company_id="),branch.mostCurrent._starter._company_selected /*RemoteObject*/ );
 //BA.debugLineNum = 19;BA.debugLine="Dim TableDetails As List";
branch.mostCurrent._tabledetails = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 20;BA.debugLine="Private ScrollView1 As ScrollView";
branch.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private LabelTitle As Label";
branch.mostCurrent._labeltitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim titleFontSize As Int = 4.5%y";
branch._titlefontsize = branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 4.5)),branch.mostCurrent.activityBA);
 //BA.debugLineNum = 23;BA.debugLine="Dim primaryFontSize As Int = 1.6%y";
branch._primaryfontsize = branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1.6)),branch.mostCurrent.activityBA);
 //BA.debugLineNum = 24;BA.debugLine="Dim secondaryFontSize As Int = 1%y";
branch._secondaryfontsize = branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1)),branch.mostCurrent.activityBA);
 //BA.debugLineNum = 25;BA.debugLine="Dim num As Int = 1";
branch._num = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 26;BA.debugLine="Private Panel3 As Panel";
branch.mostCurrent._panel3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim home As Label";
branch.mostCurrent._home = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim branches As Label";
branch.mostCurrent._branches = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim popupPanel As Panel";
branch.mostCurrent._popuppanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim target_countLabel As EditText";
branch.mostCurrent._target_countlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim target_id_display As Label";
branch.mostCurrent._target_id_display = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Dim totalTarget As Label";
branch.mostCurrent._totaltarget = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Dim Panel As Panel";
branch.mostCurrent._panel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _home_click() throws Exception{
try {
		Debug.PushSubsStack("home_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,484);
if (RapidSub.canDelegate("home_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","home_click");}
 BA.debugLineNum = 484;BA.debugLine="Private Sub home_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 485;BA.debugLine="StartActivity(\"Main\")";
Debug.ShouldStop(16);
branch.mostCurrent.__c.runVoidMethod ("StartActivity",branch.processBA,(Object)((RemoteObject.createImmutable("Main"))));
 BA.debugLineNum = 486;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32);
branch.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 487;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("JobDone (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,56);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","jobdone", _job);}
RemoteObject _scrollheight = RemoteObject.createImmutable(0);
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _numcolumns = RemoteObject.createImmutable(0);
RemoteObject _pnlwidth = RemoteObject.createImmutable(0);
RemoteObject _pnlheight = RemoteObject.createImmutable(0);
RemoteObject _padding = RemoteObject.createImmutable(0);
RemoteObject _leftposition = RemoteObject.createImmutable(0);
RemoteObject _topposition = RemoteObject.createImmutable(0);
RemoteObject _count = RemoteObject.createImmutable(0);
RemoteObject _record = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _companyname = RemoteObject.createImmutable("");
RemoteObject _id = RemoteObject.createImmutable("");
RemoteObject _name = RemoteObject.createImmutable("");
RemoteObject _total_count = RemoteObject.createImmutable(0);
RemoteObject _total_pos = RemoteObject.createImmutable(0);
RemoteObject _totalpur1 = RemoteObject.createImmutable("");
RemoteObject _totalpur2 = RemoteObject.createImmutable("");
RemoteObject _totalpur3 = RemoteObject.createImmutable("");
RemoteObject _totalsales1 = RemoteObject.createImmutable("");
RemoteObject _totalsales2 = RemoteObject.createImmutable("");
RemoteObject _totalsales3 = RemoteObject.createImmutable("");
RemoteObject _target_id = RemoteObject.createImmutable("");
RemoteObject _panel2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _gradient = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
RemoteObject _branchnamelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _myimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _resizedimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _imgview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _panelwidth = RemoteObject.createImmutable(0);
RemoteObject _labelheight = RemoteObject.createImmutable(0);
RemoteObject _purchase1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _purchase1title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _purchase2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _purchase2title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _purchase3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _purchase3title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale1title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale2title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale3title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totaltargettitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalpos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalpostitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
Debug.locals.put("job", _job);
 BA.debugLineNum = 56;BA.debugLine="Sub JobDone(job As HttpJob)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 57;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(16777216);
branch.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 58;BA.debugLine="Dim scrollHeight As Int = 0";
Debug.ShouldStop(33554432);
_scrollheight = BA.numberCast(int.class, 0);Debug.locals.put("scrollHeight", _scrollheight);Debug.locals.put("scrollHeight", _scrollheight);
 BA.debugLineNum = 60;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),branch.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 61;BA.debugLine="Try";
Debug.ShouldStop(268435456);
try { BA.debugLineNum = 62;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(536870912);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 63;BA.debugLine="parser.Initialize(job.GetString)";
Debug.ShouldStop(1073741824);
_parser.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 66;BA.debugLine="Select Case job.JobName";
Debug.ShouldStop(2);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("GetData"),BA.ObjectToString("UpdateData"))) {
case 0: {
 BA.debugLineNum = 68;BA.debugLine="TableDetails = parser.NextArray";
Debug.ShouldStop(8);
branch.mostCurrent._tabledetails = _parser.runMethod(false,"NextArray");
 BA.debugLineNum = 69;BA.debugLine="totalTarget.RemoveView";
Debug.ShouldStop(16);
branch.mostCurrent._totaltarget.runVoidMethod ("RemoveView");
 BA.debugLineNum = 70;BA.debugLine="Dim numColumns As Int = 2 ' Adjust based on p";
Debug.ShouldStop(32);
_numcolumns = BA.numberCast(int.class, 2);Debug.locals.put("numColumns", _numcolumns);Debug.locals.put("numColumns", _numcolumns);
 BA.debugLineNum = 71;BA.debugLine="Dim pnlWidth As Int = Activity.Width - 100dip";
Debug.ShouldStop(64);
_pnlwidth = RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._activity.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))}, "-",1, 1);Debug.locals.put("pnlWidth", _pnlwidth);Debug.locals.put("pnlWidth", _pnlwidth);
 BA.debugLineNum = 72;BA.debugLine="Dim pnlHeight As Int = 280dip";
Debug.ShouldStop(128);
_pnlheight = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 280)));Debug.locals.put("pnlHeight", _pnlheight);Debug.locals.put("pnlHeight", _pnlheight);
 BA.debugLineNum = 73;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(256);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 74;BA.debugLine="Dim leftPosition As Int = 50dip";
Debug.ShouldStop(512);
_leftposition = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)));Debug.locals.put("leftPosition", _leftposition);Debug.locals.put("leftPosition", _leftposition);
 BA.debugLineNum = 75;BA.debugLine="Dim topPosition As Int = 0";
Debug.ShouldStop(1024);
_topposition = BA.numberCast(int.class, 0);Debug.locals.put("topPosition", _topposition);Debug.locals.put("topPosition", _topposition);
 BA.debugLineNum = 76;BA.debugLine="Dim count As Int = 0 ' Track panel count";
Debug.ShouldStop(2048);
_count = BA.numberCast(int.class, 0);Debug.locals.put("count", _count);Debug.locals.put("count", _count);
 BA.debugLineNum = 77;BA.debugLine="If Activity.Width >= 1340 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("g",branch.mostCurrent._activity.runMethod(true,"getWidth"),BA.numberCast(double.class, 1340))) { 
 BA.debugLineNum = 78;BA.debugLine="pnlWidth = 490dip";
Debug.ShouldStop(8192);
_pnlwidth = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 490)));Debug.locals.put("pnlWidth", _pnlwidth);
 BA.debugLineNum = 79;BA.debugLine="pnlHeight = 300dip";
Debug.ShouldStop(16384);
_pnlheight = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)));Debug.locals.put("pnlHeight", _pnlheight);
 BA.debugLineNum = 80;BA.debugLine="padding = 10dip";
Debug.ShouldStop(32768);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);
 BA.debugLineNum = 81;BA.debugLine="leftPosition = 10dip";
Debug.ShouldStop(65536);
_leftposition = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("leftPosition", _leftposition);
 };
 BA.debugLineNum = 84;BA.debugLine="For Each record As Map In TableDetails";
Debug.ShouldStop(524288);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group24 = branch.mostCurrent._tabledetails;
final int groupLen24 = group24.runMethod(true,"getSize").<Integer>get()
;int index24 = 0;
;
for (; index24 < groupLen24;index24++){
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group24.runMethod(false,"Get",index24));Debug.locals.put("record", _record);
Debug.locals.put("record", _record);
 BA.debugLineNum = 86;BA.debugLine="Dim companyName As String = record.Get(\"comp";
Debug.ShouldStop(2097152);
_companyname = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("company_name")))));Debug.locals.put("companyName", _companyname);Debug.locals.put("companyName", _companyname);
 BA.debugLineNum = 87;BA.debugLine="Dim id As String = record.Get(\"id\")";
Debug.ShouldStop(4194304);
_id = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("id")))));Debug.locals.put("id", _id);Debug.locals.put("id", _id);
 BA.debugLineNum = 88;BA.debugLine="Dim name As String = record.Get(\"branch_name";
Debug.ShouldStop(8388608);
_name = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("branch_name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 89;BA.debugLine="Dim total_count As Int = record.Get(\"target_";
Debug.ShouldStop(16777216);
_total_count = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("target_no")))));Debug.locals.put("total_count", _total_count);Debug.locals.put("total_count", _total_count);
 BA.debugLineNum = 90;BA.debugLine="Dim total_pos As Int = record.Get(\"total_dev";
Debug.ShouldStop(33554432);
_total_pos = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("total_device")))));Debug.locals.put("total_pos", _total_pos);Debug.locals.put("total_pos", _total_pos);
 BA.debugLineNum = 91;BA.debugLine="Dim totalPur1 As String = record.Get(\"purcha";
Debug.ShouldStop(67108864);
_totalpur1 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("purchase_1")))));Debug.locals.put("totalPur1", _totalpur1);Debug.locals.put("totalPur1", _totalpur1);
 BA.debugLineNum = 92;BA.debugLine="Dim totalPur2 As String = record.Get(\"purcha";
Debug.ShouldStop(134217728);
_totalpur2 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("purchase_2")))));Debug.locals.put("totalPur2", _totalpur2);Debug.locals.put("totalPur2", _totalpur2);
 BA.debugLineNum = 93;BA.debugLine="Dim totalPur3 As String = record.Get(\"purcha";
Debug.ShouldStop(268435456);
_totalpur3 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("purchase_3")))));Debug.locals.put("totalPur3", _totalpur3);Debug.locals.put("totalPur3", _totalpur3);
 BA.debugLineNum = 94;BA.debugLine="Dim totalSales1 As String = record.Get(\"tota";
Debug.ShouldStop(536870912);
_totalsales1 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("total_sales1")))));Debug.locals.put("totalSales1", _totalsales1);Debug.locals.put("totalSales1", _totalsales1);
 BA.debugLineNum = 95;BA.debugLine="Dim totalSales2 As String = record.Get(\"tota";
Debug.ShouldStop(1073741824);
_totalsales2 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("total_sales2")))));Debug.locals.put("totalSales2", _totalsales2);Debug.locals.put("totalSales2", _totalsales2);
 BA.debugLineNum = 96;BA.debugLine="Dim totalSales3 As String = record.Get(\"tota";
Debug.ShouldStop(-2147483648);
_totalsales3 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("total_sales3")))));Debug.locals.put("totalSales3", _totalsales3);Debug.locals.put("totalSales3", _totalsales3);
 BA.debugLineNum = 97;BA.debugLine="Dim target_id As String = record.Get(\"branch";
Debug.ShouldStop(1);
_target_id = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("branch_target_id")))));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 98;BA.debugLine="target_countLabel.Text = total_count";
Debug.ShouldStop(2);
branch.mostCurrent._target_countlabel.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_total_count));
 BA.debugLineNum = 99;BA.debugLine="branches.Text = \"Branches - \"&companyName";
Debug.ShouldStop(4);
branch.mostCurrent._branches.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Branches - "),_companyname)));
 BA.debugLineNum = 100;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
Debug.ShouldStop(8);
branch.mostCurrent._branches.runMethod(true,"setText",BA.ObjectToCharSequence(branch.mostCurrent._branches.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 102;BA.debugLine="LabelTitle.Text = companyName";
Debug.ShouldStop(32);
branch.mostCurrent._labeltitle.runMethod(true,"setText",BA.ObjectToCharSequence(_companyname));
 BA.debugLineNum = 103;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCas";
Debug.ShouldStop(64);
branch.mostCurrent._labeltitle.runMethod(true,"setText",BA.ObjectToCharSequence(branch.mostCurrent._labeltitle.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 104;BA.debugLine="LabelTitle.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(128);
branch.mostCurrent._labeltitle.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 107;BA.debugLine="Panel.Initialize(\"Panel\")";
Debug.ShouldStop(1024);
branch.mostCurrent._panel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel")));
 BA.debugLineNum = 108;BA.debugLine="ScrollView1.Panel.AddView(Panel, leftPositio";
Debug.ShouldStop(2048);
branch.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((branch.mostCurrent._panel.getObject())),(Object)(_leftposition),(Object)(RemoteObject.solve(new RemoteObject[] {_topposition,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "+",1, 1)),(Object)(_pnlwidth),(Object)(_pnlheight));
 BA.debugLineNum = 109;BA.debugLine="Panel.Color = Colors.Black";
Debug.ShouldStop(4096);
branch.mostCurrent._panel.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 112;BA.debugLine="Dim Panel2 As Panel";
Debug.ShouldStop(32768);
_panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("Panel2", _panel2);
 BA.debugLineNum = 113;BA.debugLine="Panel2.Initialize(\"Panel2\")";
Debug.ShouldStop(65536);
_panel2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel2")));
 BA.debugLineNum = 115;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(262144);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 116;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As I";
Debug.ShouldStop(524288);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 185)),(Object)(BA.numberCast(int.class, 46)),(Object)(BA.numberCast(int.class, 52))),branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))})));
 BA.debugLineNum = 118;BA.debugLine="Panel2.Background = gradient";
Debug.ShouldStop(2097152);
_panel2.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 119;BA.debugLine="Panel2.Tag = name";
Debug.ShouldStop(4194304);
_panel2.runMethod(false,"setTag",(_name));
 BA.debugLineNum = 120;BA.debugLine="Panel2.SendToBack";
Debug.ShouldStop(8388608);
_panel2.runVoidMethod ("SendToBack");
 BA.debugLineNum = 121;BA.debugLine="Panel.AddView(Panel2, 0, 0, Panel.Width, 6%y";
Debug.ShouldStop(16777216);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_panel2.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(branch.mostCurrent._panel.runMethod(true,"getWidth")),(Object)(branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 6)),branch.mostCurrent.activityBA)));
 BA.debugLineNum = 124;BA.debugLine="Dim BranchNameLabel As Label";
Debug.ShouldStop(134217728);
_branchnamelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("BranchNameLabel", _branchnamelabel);
 BA.debugLineNum = 125;BA.debugLine="BranchNameLabel.Initialize(\"Label17\")";
Debug.ShouldStop(268435456);
_branchnamelabel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Label17")));
 BA.debugLineNum = 126;BA.debugLine="BranchNameLabel.Text = name";
Debug.ShouldStop(536870912);
_branchnamelabel.runMethod(true,"setText",BA.ObjectToCharSequence(_name));
 BA.debugLineNum = 127;BA.debugLine="BranchNameLabel.Tag = id";
Debug.ShouldStop(1073741824);
_branchnamelabel.runMethod(false,"setTag",(_id));
 BA.debugLineNum = 128;BA.debugLine="BranchNameLabel.TextSize = 18";
Debug.ShouldStop(-2147483648);
_branchnamelabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 129;BA.debugLine="BranchNameLabel.TextColor = Colors.White";
Debug.ShouldStop(1);
_branchnamelabel.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 130;BA.debugLine="BranchNameLabel.Typeface = Typeface.MONOSPAC";
Debug.ShouldStop(2);
_branchnamelabel.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 131;BA.debugLine="BranchNameLabel.Gravity = Gravity.CENTER_VER";
Debug.ShouldStop(4);
_branchnamelabel.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 132;BA.debugLine="Panel2.AddView(BranchNameLabel, 10dip, 0dip,";
Debug.ShouldStop(8);
_panel2.runVoidMethod ("AddView",(Object)((_branchnamelabel.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(_panel2.runMethod(true,"getWidth")),(Object)(_panel2.runMethod(true,"getHeight")));
 BA.debugLineNum = 134;BA.debugLine="Dim myImage As Bitmap";
Debug.ShouldStop(32);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 135;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrows";
Debug.ShouldStop(64);
_myimage = branch.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(branch.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("arrows-removebg-preview.png")));Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 136;BA.debugLine="If myImage.IsInitialized Then";
Debug.ShouldStop(128);
if (_myimage.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 137;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resize";
Debug.ShouldStop(256);
_resizedimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_resizedimage = _myimage.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 4.5)),branch.mostCurrent.activityBA))))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_myimage.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 2)),branch.mostCurrent.activityBA))),_myimage.runMethod(true,"getWidth")}, "*/",0, 0))),(Object)(branch.mostCurrent.__c.getField(true,"True")));Debug.locals.put("resizedImage", _resizedimage);Debug.locals.put("resizedImage", _resizedimage);
 BA.debugLineNum = 138;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(512);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 139;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(1024);
_imgview.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 140;BA.debugLine="imgView.Bitmap = resizedImage";
Debug.ShouldStop(2048);
_imgview.runMethod(false,"setBitmap",(_resizedimage.getObject()));
 BA.debugLineNum = 141;BA.debugLine="Panel2.AddView(imgView, Panel2.Width - 8%x,";
Debug.ShouldStop(4096);
_panel2.runVoidMethod ("AddView",(Object)((_imgview.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panel2.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 8)),branch.mostCurrent.activityBA)}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),branch.mostCurrent.activityBA)),(Object)(_panel2.runMethod(true,"getHeight")));
 }else {
 BA.debugLineNum = 143;BA.debugLine="Log(\"Error loading image\")";
Debug.ShouldStop(16384);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","2786519",RemoteObject.createImmutable("Error loading image"),0);
 };
 BA.debugLineNum = 146;BA.debugLine="Dim panelWidth As Int = Panel.Width /3";
Debug.ShouldStop(131072);
_panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(3)}, "/",0, 0));Debug.locals.put("panelWidth", _panelwidth);Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 147;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(262144);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 148;BA.debugLine="Dim labelheight As Int = 35dip";
Debug.ShouldStop(524288);
_labelheight = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)));Debug.locals.put("labelheight", _labelheight);Debug.locals.put("labelheight", _labelheight);
 BA.debugLineNum = 150;BA.debugLine="Dim purchase1 As Label";
Debug.ShouldStop(2097152);
_purchase1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase1", _purchase1);
 BA.debugLineNum = 151;BA.debugLine="purchase1.Initialize(\"\")";
Debug.ShouldStop(4194304);
_purchase1.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 152;BA.debugLine="purchase1.Text = totalPur1";
Debug.ShouldStop(8388608);
_purchase1.runMethod(true,"setText",BA.ObjectToCharSequence(_totalpur1));
 BA.debugLineNum = 153;BA.debugLine="purchase1.TextColor = Colors.Black";
Debug.ShouldStop(16777216);
_purchase1.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 154;BA.debugLine="purchase1.TextSize = primaryFontSize";
Debug.ShouldStop(33554432);
_purchase1.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 155;BA.debugLine="purchase1.Gravity = Gravity.CENTER";
Debug.ShouldStop(67108864);
_purchase1.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 156;BA.debugLine="purchase1.Typeface = Typeface.SERIF";
Debug.ShouldStop(134217728);
_purchase1.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 157;BA.debugLine="Panel.AddView(purchase1,0,Panel2.Height+padd";
Debug.ShouldStop(268435456);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_panel2.runMethod(true,"getHeight"),_padding}, "+",1, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 159;BA.debugLine="Dim purchase1Title As Label";
Debug.ShouldStop(1073741824);
_purchase1title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase1Title", _purchase1title);
 BA.debugLineNum = 160;BA.debugLine="purchase1Title.Initialize(\"\")";
Debug.ShouldStop(-2147483648);
_purchase1title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 161;BA.debugLine="purchase1Title.Text = \"First Purchase\"";
Debug.ShouldStop(1);
_purchase1title.runMethod(true,"setText",BA.ObjectToCharSequence("First Purchase"));
 BA.debugLineNum = 162;BA.debugLine="purchase1Title.TextColor = Colors.Gray";
Debug.ShouldStop(2);
_purchase1title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 163;BA.debugLine="purchase1Title.TextSize = secondaryFontSize";
Debug.ShouldStop(4);
_purchase1title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 164;BA.debugLine="purchase1Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(8);
_purchase1title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 165;BA.debugLine="purchase1Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(16);
_purchase1title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 166;BA.debugLine="purchase1Title.Text = purchase1Title.Text.To";
Debug.ShouldStop(32);
_purchase1title.runMethod(true,"setText",BA.ObjectToCharSequence(_purchase1title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 167;BA.debugLine="Panel.AddView(purchase1Title,0,purchase1.top";
Debug.ShouldStop(64);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase1title.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 169;BA.debugLine="Dim purchase2 As Label";
Debug.ShouldStop(256);
_purchase2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase2", _purchase2);
 BA.debugLineNum = 170;BA.debugLine="purchase2.Initialize(\"\")";
Debug.ShouldStop(512);
_purchase2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 171;BA.debugLine="purchase2.Text = totalPur2";
Debug.ShouldStop(1024);
_purchase2.runMethod(true,"setText",BA.ObjectToCharSequence(_totalpur2));
 BA.debugLineNum = 172;BA.debugLine="purchase2.TextColor = Colors.Black";
Debug.ShouldStop(2048);
_purchase2.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 173;BA.debugLine="purchase2.TextSize = primaryFontSize";
Debug.ShouldStop(4096);
_purchase2.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 174;BA.debugLine="purchase2.Gravity = Gravity.CENTER";
Debug.ShouldStop(8192);
_purchase2.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 175;BA.debugLine="purchase2.Typeface = Typeface.SERIF";
Debug.ShouldStop(16384);
_purchase2.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 176;BA.debugLine="Panel.AddView(purchase2,panelWidth,Panel2.He";
Debug.ShouldStop(32768);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase2.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_panel2.runMethod(true,"getHeight"),_padding}, "+",1, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 178;BA.debugLine="Dim purchase2Title As Label";
Debug.ShouldStop(131072);
_purchase2title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase2Title", _purchase2title);
 BA.debugLineNum = 179;BA.debugLine="purchase2Title.Initialize(\"\")";
Debug.ShouldStop(262144);
_purchase2title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 180;BA.debugLine="purchase2Title.Text = \"Second Purchase\"";
Debug.ShouldStop(524288);
_purchase2title.runMethod(true,"setText",BA.ObjectToCharSequence("Second Purchase"));
 BA.debugLineNum = 181;BA.debugLine="purchase2Title.TextColor = Colors.Gray";
Debug.ShouldStop(1048576);
_purchase2title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 182;BA.debugLine="purchase2Title.TextSize = secondaryFontSize";
Debug.ShouldStop(2097152);
_purchase2title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 183;BA.debugLine="purchase2Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(4194304);
_purchase2title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 184;BA.debugLine="purchase2Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(8388608);
_purchase2title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 185;BA.debugLine="purchase2Title.Text = purchase2Title.Text.To";
Debug.ShouldStop(16777216);
_purchase2title.runMethod(true,"setText",BA.ObjectToCharSequence(_purchase2title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 186;BA.debugLine="Panel.AddView(purchase2Title,panelWidth,purc";
Debug.ShouldStop(33554432);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase2title.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 188;BA.debugLine="Dim purchase3 As Label";
Debug.ShouldStop(134217728);
_purchase3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase3", _purchase3);
 BA.debugLineNum = 189;BA.debugLine="purchase3.Initialize(\"\")";
Debug.ShouldStop(268435456);
_purchase3.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 190;BA.debugLine="purchase3.Text = totalPur3";
Debug.ShouldStop(536870912);
_purchase3.runMethod(true,"setText",BA.ObjectToCharSequence(_totalpur3));
 BA.debugLineNum = 191;BA.debugLine="purchase3.TextColor = Colors.Black";
Debug.ShouldStop(1073741824);
_purchase3.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 192;BA.debugLine="purchase3.TextSize = primaryFontSize";
Debug.ShouldStop(-2147483648);
_purchase3.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 193;BA.debugLine="purchase3.Gravity = Gravity.CENTER";
Debug.ShouldStop(1);
_purchase3.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 194;BA.debugLine="purchase3.Typeface = Typeface.SERIF";
Debug.ShouldStop(2);
_purchase3.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 195;BA.debugLine="Panel.AddView(purchase3,panelWidth*2,Panel2.";
Debug.ShouldStop(4);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase3.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_panel2.runMethod(true,"getHeight"),_padding}, "+",1, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 197;BA.debugLine="Dim purchase3Title As Label";
Debug.ShouldStop(16);
_purchase3title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase3Title", _purchase3title);
 BA.debugLineNum = 198;BA.debugLine="purchase3Title.Initialize(\"\")";
Debug.ShouldStop(32);
_purchase3title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 199;BA.debugLine="purchase3Title.Text = \"Third Purchase\"";
Debug.ShouldStop(64);
_purchase3title.runMethod(true,"setText",BA.ObjectToCharSequence("Third Purchase"));
 BA.debugLineNum = 200;BA.debugLine="purchase3Title.TextColor = Colors.Gray";
Debug.ShouldStop(128);
_purchase3title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 201;BA.debugLine="purchase3Title.TextSize = secondaryFontSize";
Debug.ShouldStop(256);
_purchase3title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 202;BA.debugLine="purchase3Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(512);
_purchase3title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 203;BA.debugLine="purchase3Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(1024);
_purchase3title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 204;BA.debugLine="purchase3Title.Text = purchase3Title.Text.To";
Debug.ShouldStop(2048);
_purchase3title.runMethod(true,"setText",BA.ObjectToCharSequence(_purchase3title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 205;BA.debugLine="Panel.AddView(purchase3Title,panelWidth*2,pu";
Debug.ShouldStop(4096);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase3title.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 207;BA.debugLine="Dim sale1 As Label";
Debug.ShouldStop(16384);
_sale1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale1", _sale1);
 BA.debugLineNum = 208;BA.debugLine="sale1.Initialize(\"\")";
Debug.ShouldStop(32768);
_sale1.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 209;BA.debugLine="sale1.Text = totalSales1";
Debug.ShouldStop(65536);
_sale1.runMethod(true,"setText",BA.ObjectToCharSequence(_totalsales1));
 BA.debugLineNum = 210;BA.debugLine="sale1.TextColor = Colors.Black";
Debug.ShouldStop(131072);
_sale1.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 211;BA.debugLine="sale1.TextSize = primaryFontSize";
Debug.ShouldStop(262144);
_sale1.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 212;BA.debugLine="sale1.Gravity = Gravity.CENTER";
Debug.ShouldStop(524288);
_sale1.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 213;BA.debugLine="sale1.Typeface = Typeface.SERIF";
Debug.ShouldStop(1048576);
_sale1.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 214;BA.debugLine="Panel.AddView(sale1,0,purchase3Title.Height+";
Debug.ShouldStop(2097152);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase3title.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 216;BA.debugLine="Dim sale1Title As Label";
Debug.ShouldStop(8388608);
_sale1title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale1Title", _sale1title);
 BA.debugLineNum = 217;BA.debugLine="sale1Title.Initialize(\"\")";
Debug.ShouldStop(16777216);
_sale1title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 218;BA.debugLine="sale1Title.Text = \"First Sale\"";
Debug.ShouldStop(33554432);
_sale1title.runMethod(true,"setText",BA.ObjectToCharSequence("First Sale"));
 BA.debugLineNum = 219;BA.debugLine="sale1Title.TextColor = Colors.Gray";
Debug.ShouldStop(67108864);
_sale1title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 220;BA.debugLine="sale1Title.TextSize = secondaryFontSize";
Debug.ShouldStop(134217728);
_sale1title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 221;BA.debugLine="sale1Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(268435456);
_sale1title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 222;BA.debugLine="sale1Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(536870912);
_sale1title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 223;BA.debugLine="sale1Title.Text = sale1Title.Text.ToUpperCas";
Debug.ShouldStop(1073741824);
_sale1title.runMethod(true,"setText",BA.ObjectToCharSequence(_sale1title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 224;BA.debugLine="Panel.AddView(sale1Title,0,sale1.top+padding";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale1title.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_sale1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 226;BA.debugLine="Dim sale2 As Label";
Debug.ShouldStop(2);
_sale2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale2", _sale2);
 BA.debugLineNum = 227;BA.debugLine="sale2.Initialize(\"\")";
Debug.ShouldStop(4);
_sale2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 228;BA.debugLine="sale2.Text = totalSales2";
Debug.ShouldStop(8);
_sale2.runMethod(true,"setText",BA.ObjectToCharSequence(_totalsales2));
 BA.debugLineNum = 229;BA.debugLine="sale2.TextColor = Colors.Black";
Debug.ShouldStop(16);
_sale2.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 230;BA.debugLine="sale2.TextSize = primaryFontSize";
Debug.ShouldStop(32);
_sale2.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 231;BA.debugLine="sale2.Gravity = Gravity.CENTER";
Debug.ShouldStop(64);
_sale2.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 232;BA.debugLine="sale2.Typeface = Typeface.SERIF";
Debug.ShouldStop(128);
_sale2.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 233;BA.debugLine="Panel.AddView(sale2,panelWidth,purchase3Titl";
Debug.ShouldStop(256);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale2.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase3title.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 235;BA.debugLine="Dim sale2Title As Label";
Debug.ShouldStop(1024);
_sale2title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale2Title", _sale2title);
 BA.debugLineNum = 236;BA.debugLine="sale2Title.Initialize(\"\")";
Debug.ShouldStop(2048);
_sale2title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 237;BA.debugLine="sale2Title.Text = \" Second Sale\"";
Debug.ShouldStop(4096);
_sale2title.runMethod(true,"setText",BA.ObjectToCharSequence(" Second Sale"));
 BA.debugLineNum = 238;BA.debugLine="sale2Title.TextColor = Colors.Gray";
Debug.ShouldStop(8192);
_sale2title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 239;BA.debugLine="sale2Title.TextSize = secondaryFontSize";
Debug.ShouldStop(16384);
_sale2title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 240;BA.debugLine="sale2Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(32768);
_sale2title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 241;BA.debugLine="sale2Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(65536);
_sale2title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 242;BA.debugLine="sale2Title.Text = sale2Title.Text.ToUpperCas";
Debug.ShouldStop(131072);
_sale2title.runMethod(true,"setText",BA.ObjectToCharSequence(_sale2title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 243;BA.debugLine="Panel.AddView(sale2Title,panelWidth,sale2.to";
Debug.ShouldStop(262144);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale2title.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_sale2.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 245;BA.debugLine="Dim sale3 As Label";
Debug.ShouldStop(1048576);
_sale3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale3", _sale3);
 BA.debugLineNum = 246;BA.debugLine="sale3.Initialize(\"\")";
Debug.ShouldStop(2097152);
_sale3.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 247;BA.debugLine="sale3.Text = totalSales3";
Debug.ShouldStop(4194304);
_sale3.runMethod(true,"setText",BA.ObjectToCharSequence(_totalsales3));
 BA.debugLineNum = 248;BA.debugLine="sale3.TextColor = Colors.Black";
Debug.ShouldStop(8388608);
_sale3.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 249;BA.debugLine="sale3.TextSize = primaryFontSize";
Debug.ShouldStop(16777216);
_sale3.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 250;BA.debugLine="sale3.Gravity = Gravity.CENTER";
Debug.ShouldStop(33554432);
_sale3.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 251;BA.debugLine="sale3.Typeface = Typeface.SERIF";
Debug.ShouldStop(67108864);
_sale3.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 252;BA.debugLine="Panel.AddView(sale3,panelWidth*2,sale2Title.";
Debug.ShouldStop(134217728);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale3.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_sale2title.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 254;BA.debugLine="Dim sale3Title As Label";
Debug.ShouldStop(536870912);
_sale3title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale3Title", _sale3title);
 BA.debugLineNum = 255;BA.debugLine="sale3Title.Initialize(\"\")";
Debug.ShouldStop(1073741824);
_sale3title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 256;BA.debugLine="sale3Title.Text = \" Third Sale\"";
Debug.ShouldStop(-2147483648);
_sale3title.runMethod(true,"setText",BA.ObjectToCharSequence(" Third Sale"));
 BA.debugLineNum = 257;BA.debugLine="sale3Title.TextColor = Colors.Gray";
Debug.ShouldStop(1);
_sale3title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 258;BA.debugLine="sale3Title.TextSize = secondaryFontSize";
Debug.ShouldStop(2);
_sale3title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 259;BA.debugLine="sale3Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(4);
_sale3title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 260;BA.debugLine="sale3Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(8);
_sale3title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 261;BA.debugLine="sale3Title.Text = sale3Title.Text.ToUpperCas";
Debug.ShouldStop(16);
_sale3title.runMethod(true,"setText",BA.ObjectToCharSequence(_sale3title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 262;BA.debugLine="Panel.AddView(sale3Title,panelWidth*2,sale1.";
Debug.ShouldStop(32);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale3title.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_sale1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 264;BA.debugLine="panelWidth = Panel.Width /2";
Debug.ShouldStop(128);
_panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 266;BA.debugLine="totalTarget.Initialize(\"totalTarget\")";
Debug.ShouldStop(512);
branch.mostCurrent._totaltarget.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("totalTarget")));
 BA.debugLineNum = 267;BA.debugLine="totalTarget.Text = total_count";
Debug.ShouldStop(1024);
branch.mostCurrent._totaltarget.runMethod(true,"setText",BA.ObjectToCharSequence(_total_count));
 BA.debugLineNum = 268;BA.debugLine="totalTarget.Tag = target_id";
Debug.ShouldStop(2048);
branch.mostCurrent._totaltarget.runMethod(false,"setTag",(_target_id));
 BA.debugLineNum = 269;BA.debugLine="totalTarget.TextColor = Colors.Black";
Debug.ShouldStop(4096);
branch.mostCurrent._totaltarget.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 270;BA.debugLine="totalTarget.Color = Colors.White";
Debug.ShouldStop(8192);
branch.mostCurrent._totaltarget.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 271;BA.debugLine="totalTarget.TextSize = primaryFontSize";
Debug.ShouldStop(16384);
branch.mostCurrent._totaltarget.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 272;BA.debugLine="totalTarget.Gravity = Gravity.CENTER";
Debug.ShouldStop(32768);
branch.mostCurrent._totaltarget.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 273;BA.debugLine="totalTarget.Typeface = Typeface.SERIF";
Debug.ShouldStop(65536);
branch.mostCurrent._totaltarget.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 274;BA.debugLine="Panel.AddView(totalTarget,2dip,sale3Title.He";
Debug.ShouldStop(131072);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((branch.mostCurrent._totaltarget.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(RemoteObject.solve(new RemoteObject[] {_sale3title.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 160)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 276;BA.debugLine="Dim totalTargetTitle As Label";
Debug.ShouldStop(524288);
_totaltargettitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalTargetTitle", _totaltargettitle);
 BA.debugLineNum = 277;BA.debugLine="totalTargetTitle.Initialize(\"totalTargetTitl";
Debug.ShouldStop(1048576);
_totaltargettitle.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("totalTargetTitles")));
 BA.debugLineNum = 278;BA.debugLine="totalTargetTitle.Text = \" Total Target\"";
Debug.ShouldStop(2097152);
_totaltargettitle.runMethod(true,"setText",BA.ObjectToCharSequence(" Total Target"));
 BA.debugLineNum = 279;BA.debugLine="totalTargetTitle.tag = 20";
Debug.ShouldStop(4194304);
_totaltargettitle.runMethod(false,"setTag",RemoteObject.createImmutable((20)));
 BA.debugLineNum = 280;BA.debugLine="totalTargetTitle.TextColor = Colors.Gray";
Debug.ShouldStop(8388608);
_totaltargettitle.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 281;BA.debugLine="totalTargetTitle.TextSize = secondaryFontSiz";
Debug.ShouldStop(16777216);
_totaltargettitle.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 282;BA.debugLine="totalTargetTitle.Gravity = Gravity.CENTER";
Debug.ShouldStop(33554432);
_totaltargettitle.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 283;BA.debugLine="totalTargetTitle.Typeface = Typeface.MONOSPA";
Debug.ShouldStop(67108864);
_totaltargettitle.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 284;BA.debugLine="totalTargetTitle.Text = totalTargetTitle.Tex";
Debug.ShouldStop(134217728);
_totaltargettitle.runMethod(true,"setText",BA.ObjectToCharSequence(_totaltargettitle.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 285;BA.debugLine="Panel.AddView(totalTargetTitle,0,totalTarget";
Debug.ShouldStop(268435456);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_totaltargettitle.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._totaltarget.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 287;BA.debugLine="Dim totalPos As Label";
Debug.ShouldStop(1073741824);
_totalpos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPos", _totalpos);
 BA.debugLineNum = 288;BA.debugLine="totalPos.Initialize(\"\")";
Debug.ShouldStop(-2147483648);
_totalpos.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 289;BA.debugLine="totalPos.Text = total_pos";
Debug.ShouldStop(1);
_totalpos.runMethod(true,"setText",BA.ObjectToCharSequence(_total_pos));
 BA.debugLineNum = 290;BA.debugLine="totalPos.TextColor = Colors.Black";
Debug.ShouldStop(2);
_totalpos.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 291;BA.debugLine="totalPos.TextSize = primaryFontSize";
Debug.ShouldStop(4);
_totalpos.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 292;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
Debug.ShouldStop(8);
_totalpos.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 293;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
Debug.ShouldStop(16);
_totalpos.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 294;BA.debugLine="Panel.AddView(totalPos,panelWidth,totalTarge";
Debug.ShouldStop(32);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_totalpos.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_totaltargettitle.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 160)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 296;BA.debugLine="Dim totalPosTitle As Label";
Debug.ShouldStop(128);
_totalpostitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPosTitle", _totalpostitle);
 BA.debugLineNum = 297;BA.debugLine="totalPosTitle.Initialize(\"\")";
Debug.ShouldStop(256);
_totalpostitle.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 298;BA.debugLine="totalPosTitle.Text = \" Total Pos\"";
Debug.ShouldStop(512);
_totalpostitle.runMethod(true,"setText",BA.ObjectToCharSequence(" Total Pos"));
 BA.debugLineNum = 299;BA.debugLine="totalPosTitle.TextColor = Colors.Gray";
Debug.ShouldStop(1024);
_totalpostitle.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 300;BA.debugLine="totalPosTitle.TextSize = secondaryFontSize";
Debug.ShouldStop(2048);
_totalpostitle.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 301;BA.debugLine="totalPosTitle.Gravity = Gravity.CENTER";
Debug.ShouldStop(4096);
_totalpostitle.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 302;BA.debugLine="totalPosTitle.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(8192);
_totalpostitle.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 303;BA.debugLine="totalPosTitle.Text = totalPosTitle.Text.ToUp";
Debug.ShouldStop(16384);
_totalpostitle.runMethod(true,"setText",BA.ObjectToCharSequence(_totalpostitle.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 304;BA.debugLine="Panel.AddView(totalPosTitle,panelWidth,total";
Debug.ShouldStop(32768);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_totalpostitle.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_totalpos.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 307;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(262144);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 308;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 2dip, Col";
Debug.ShouldStop(524288);
_cd.runVoidMethod ("Initialize2",(Object)(branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 156)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 309;BA.debugLine="Panel.Background = cd";
Debug.ShouldStop(1048576);
branch.mostCurrent._panel.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 315;BA.debugLine="If Activity.Width >= 1340 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("g",branch.mostCurrent._activity.runMethod(true,"getWidth"),BA.numberCast(double.class, 1340))) { 
 BA.debugLineNum = 316;BA.debugLine="count = count + 1";
Debug.ShouldStop(134217728);
_count = RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("count", _count);
 BA.debugLineNum = 317;BA.debugLine="If count Mod numColumns = 0 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {_count,_numcolumns}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 318;BA.debugLine="leftPosition = 10dip";
Debug.ShouldStop(536870912);
_leftposition = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("leftPosition", _leftposition);
 BA.debugLineNum = 319;BA.debugLine="topPosition = topPosition + pnlHeight + pa";
Debug.ShouldStop(1073741824);
_topposition = RemoteObject.solve(new RemoteObject[] {_topposition,_pnlheight,_padding}, "++",2, 1);Debug.locals.put("topPosition", _topposition);
 }else {
 BA.debugLineNum = 321;BA.debugLine="leftPosition = leftPosition + pnlWidth + p";
Debug.ShouldStop(1);
_leftposition = RemoteObject.solve(new RemoteObject[] {_leftposition,_pnlwidth,_padding}, "++",2, 1);Debug.locals.put("leftPosition", _leftposition);
 };
 BA.debugLineNum = 323;BA.debugLine="scrollHeight = scrollHeight + 175dip";
Debug.ShouldStop(4);
_scrollheight = RemoteObject.solve(new RemoteObject[] {_scrollheight,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 175)))}, "+",1, 1);Debug.locals.put("scrollHeight", _scrollheight);
 }else {
 BA.debugLineNum = 325;BA.debugLine="topPosition = topPosition + pnlHeight + pad";
Debug.ShouldStop(16);
_topposition = RemoteObject.solve(new RemoteObject[] {_topposition,_pnlheight,_padding}, "++",2, 1);Debug.locals.put("topPosition", _topposition);
 BA.debugLineNum = 326;BA.debugLine="scrollHeight = scrollHeight + 290dip";
Debug.ShouldStop(32);
_scrollheight = RemoteObject.solve(new RemoteObject[] {_scrollheight,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 290)))}, "+",1, 1);Debug.locals.put("scrollHeight", _scrollheight);
 };
 }
}Debug.locals.put("record", _record);
;
 BA.debugLineNum = 331;BA.debugLine="ScrollView1.Panel.Height = scrollHeight";
Debug.ShouldStop(1024);
branch.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",_scrollheight);
 break; }
case 1: {
 BA.debugLineNum = 335;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
Debug.ShouldStop(16384);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Data updated successfully")),(Object)(branch.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 337;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(65536);
_loadcompanydata();
 break; }
default: {
 BA.debugLineNum = 339;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
Debug.ShouldStop(262144);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","2786715",RemoteObject.concat(RemoteObject.createImmutable("Unknown job: "),_job.getField(true,"_jobname" /*RemoteObject*/ )),0);
 break; }
}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e241) {
			BA.rdebugUtils.runVoidMethod("setLastException",branch.processBA, e241.toString()); BA.debugLineNum = 343;BA.debugLine="ToastMessageShow(\"Error parsing data\", True)";
Debug.ShouldStop(4194304);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Error parsing data")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 346;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
Debug.ShouldStop(33554432);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 349;BA.debugLine="job.Release";
Debug.ShouldStop(268435456);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 350;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Label17_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,489);
if (RapidSub.canDelegate("label17_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","label17_click");}
RemoteObject _clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _selectedcompany = RemoteObject.createImmutable("");
 BA.debugLineNum = 489;BA.debugLine="Private Sub Label17_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 490;BA.debugLine="Dim clickedLabel As Label = Sender";
Debug.ShouldStop(512);
_clickedlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("clickedLabel", _clickedlabel);Debug.locals.put("clickedLabel", _clickedlabel);
 BA.debugLineNum = 491;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
Debug.ShouldStop(1024);
_selectedcompany = BA.ObjectToString(_clickedlabel.runMethod(false,"getTag"));Debug.locals.put("selectedCompany", _selectedcompany);Debug.locals.put("selectedCompany", _selectedcompany);
 BA.debugLineNum = 493;BA.debugLine="branch_selected = selectedCompany";
Debug.ShouldStop(4096);
branch._branch_selected = _selectedcompany;
 BA.debugLineNum = 495;BA.debugLine="StartActivity(\"Device\")";
Debug.ShouldStop(16384);
branch.mostCurrent.__c.runVoidMethod ("StartActivity",branch.processBA,(Object)((RemoteObject.createImmutable("Device"))));
 BA.debugLineNum = 496;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("LoadCompanyData (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,36);
if (RapidSub.canDelegate("loadcompanydata")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","loadcompanydata");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 36;BA.debugLine="Sub LoadCompanyData";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(16);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 38;BA.debugLine="totalTarget.Initialize(\"\")";
Debug.ShouldStop(32);
branch.mostCurrent._totaltarget.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 39;BA.debugLine="totalTarget.RemoveView";
Debug.ShouldStop(64);
branch.mostCurrent._totaltarget.runVoidMethod ("RemoveView");
 BA.debugLineNum = 40;BA.debugLine="Panel.Initialize(\"\")";
Debug.ShouldStop(128);
branch.mostCurrent._panel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 41;BA.debugLine="Panel.RemoveAllViews";
Debug.ShouldStop(256);
branch.mostCurrent._panel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 42;BA.debugLine="PHPURL = \"https://192.168.8.141/Company/fetch.php";
Debug.ShouldStop(512);
branch.mostCurrent._phpurl = RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.141/Company/fetch.php?action=get_branch&company_id="),branch.mostCurrent._starter._company_selected /*RemoteObject*/ );
 BA.debugLineNum = 43;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
Debug.ShouldStop(1024);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,branch.processBA,(Object)(BA.ObjectToString("GetData")),(Object)(branch.getObject()));
 BA.debugLineNum = 44;BA.debugLine="Job1.Download(PHPURL)";
Debug.ShouldStop(2048);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(branch.mostCurrent._phpurl));
 BA.debugLineNum = 45;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
Debug.ShouldStop(4096);
branch.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",branch.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Data..."))));
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private xui As XUI";
branch._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 10;BA.debugLine="Public company_name As String";
branch._company_name = RemoteObject.createImmutable("");
 //BA.debugLineNum = 11;BA.debugLine="Public branch_selected As String";
branch._branch_selected = RemoteObject.createImmutable("");
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _responsivelabel(RemoteObject _label) throws Exception{
try {
		Debug.PushSubsStack("responsiveLabel (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,468);
if (RapidSub.canDelegate("responsivelabel")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","responsivelabel", _label);}
RemoteObject _charwidth = RemoteObject.createImmutable(0);
RemoteObject _padding = RemoteObject.createImmutable(0);
RemoteObject _homewidth = RemoteObject.createImmutable(0);
Debug.locals.put("label", _label);
 BA.debugLineNum = 468;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
Debug.ShouldStop(524288);
 BA.debugLineNum = 469;BA.debugLine="Dim charWidth As Int = 10dip";
Debug.ShouldStop(1048576);
_charwidth = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("charWidth", _charwidth);Debug.locals.put("charWidth", _charwidth);
 BA.debugLineNum = 470;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(2097152);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 471;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
Debug.ShouldStop(4194304);
_homewidth = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_label.runMethod(true,"getText").runMethod(true,"length"),_charwidth}, "*",0, 1)),_padding}, "+",1, 1);Debug.locals.put("homeWidth", _homewidth);Debug.locals.put("homeWidth", _homewidth);
 BA.debugLineNum = 472;BA.debugLine="Return homeWidth";
Debug.ShouldStop(8388608);
if (true) return _homewidth;
 BA.debugLineNum = 473;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _totaltarget_click() throws Exception{
try {
		Debug.PushSubsStack("totalTarget_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,446);
if (RapidSub.canDelegate("totaltarget_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","totaltarget_click");}
RemoteObject _target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _target_id = RemoteObject.createImmutable("");
 BA.debugLineNum = 446;BA.debugLine="Sub totalTarget_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 447;BA.debugLine="popupPanel.Visible = True";
Debug.ShouldStop(1073741824);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 448;BA.debugLine="Dim target_id_btn As Label = Sender ' Get the cli";
Debug.ShouldStop(-2147483648);
_target_id_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("target_id_btn", _target_id_btn);Debug.locals.put("target_id_btn", _target_id_btn);
 BA.debugLineNum = 449;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
Debug.ShouldStop(1);
_target_id = BA.ObjectToString(_target_id_btn.runMethod(false,"getTag"));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 451;BA.debugLine="target_id_display.Text = target_id";
Debug.ShouldStop(4);
branch.mostCurrent._target_id_display.runMethod(true,"setText",BA.ObjectToCharSequence(_target_id));
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
public static RemoteObject  _totaltargettitle_click() throws Exception{
try {
		Debug.PushSubsStack("totalTargetTitle_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,454);
if (RapidSub.canDelegate("totaltargettitle_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","totaltargettitle_click");}
RemoteObject _target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _target_id = RemoteObject.createImmutable("");
 BA.debugLineNum = 454;BA.debugLine="Sub totalTargetTitle_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 455;BA.debugLine="popupPanel.Visible = True";
Debug.ShouldStop(64);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 456;BA.debugLine="Dim target_id_btn As Label = Sender ' Get the cli";
Debug.ShouldStop(128);
_target_id_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("target_id_btn", _target_id_btn);Debug.locals.put("target_id_btn", _target_id_btn);
 BA.debugLineNum = 457;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
Debug.ShouldStop(256);
_target_id = BA.ObjectToString(_target_id_btn.runMethod(false,"getTag"));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 459;BA.debugLine="Log(target_id&\"This is clicked id\")";
Debug.ShouldStop(1024);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","21048581",RemoteObject.concat(_target_id,RemoteObject.createImmutable("This is clicked id")),0);
 BA.debugLineNum = 460;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("UpdateData_Remote (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,48);
if (RapidSub.canDelegate("updatedata_remote")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","updatedata_remote", _target_id, _new_value);}
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
Debug.locals.put("target_id", _target_id);
Debug.locals.put("new_value", _new_value);
 BA.debugLineNum = 48;BA.debugLine="Sub UpdateData_Remote(target_id As Int, new_value";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="Dim PHPURL As String = $\"https://192.168.8.141/Co";
Debug.ShouldStop(65536);
branch.mostCurrent._phpurl = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.141/Company/fetch.php?action=target_update&id="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_target_id))),RemoteObject.createImmutable("&value="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_new_value))),RemoteObject.createImmutable("")));
 BA.debugLineNum = 50;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(131072);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 51;BA.debugLine="job.Initialize(\"UpdateData\", Me)";
Debug.ShouldStop(262144);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,branch.processBA,(Object)(BA.ObjectToString("UpdateData")),(Object)(branch.getObject()));
 BA.debugLineNum = 52;BA.debugLine="job.Download(PHPURL)";
Debug.ShouldStop(524288);
_job.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(branch.mostCurrent._phpurl));
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}