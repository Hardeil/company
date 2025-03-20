package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class branch_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,56);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","activity_create", _firsttime);}
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _leftposition = RemoteObject.createImmutable(0);
RemoteObject _closebutton = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _myimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _imgview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _popuptext = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _popupdirectiontext = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _edit_button = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _cdback = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 56;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 57;BA.debugLine="Activity.LoadLayout(\"Branch\")";
Debug.ShouldStop(16777216);
branch.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Branch")),branch.mostCurrent.activityBA);
 BA.debugLineNum = 58;BA.debugLine="home.Initialize(\"home\")";
Debug.ShouldStop(33554432);
branch.mostCurrent._home.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("home")));
 BA.debugLineNum = 59;BA.debugLine="home.Text = \"HOME |\"";
Debug.ShouldStop(67108864);
branch.mostCurrent._home.runMethod(true,"setText",BA.ObjectToCharSequence("HOME |"));
 BA.debugLineNum = 60;BA.debugLine="home.TextColor = Colors.Black";
Debug.ShouldStop(134217728);
branch.mostCurrent._home.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 61;BA.debugLine="home.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(268435456);
branch.mostCurrent._home.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 62;BA.debugLine="home.Gravity = Gravity.CENTER";
Debug.ShouldStop(536870912);
branch.mostCurrent._home.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 63;BA.debugLine="home.TextSize = 16";
Debug.ShouldStop(1073741824);
branch.mostCurrent._home.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 64;BA.debugLine="Panel3.AddView(home, 0, 0, responsiveLabel(home),";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((branch.mostCurrent._home.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_responsivelabel(branch.mostCurrent._home)),(Object)(branch.mostCurrent._panel3.runMethod(true,"getHeight")));
 BA.debugLineNum = 65;BA.debugLine="Panel3.Color = Colors.Transparent";
Debug.ShouldStop(1);
branch.mostCurrent._panel3.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 67;BA.debugLine="branches.Initialize(\"\")";
Debug.ShouldStop(4);
branch.mostCurrent._branches.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 68;BA.debugLine="branches.Text = \"Branches\"";
Debug.ShouldStop(8);
branch.mostCurrent._branches.runMethod(true,"setText",BA.ObjectToCharSequence("Branches"));
 BA.debugLineNum = 69;BA.debugLine="branches.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(16);
branch.mostCurrent._branches.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 70;BA.debugLine="branches.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(32);
branch.mostCurrent._branches.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 71;BA.debugLine="branches.TextSize = 16";
Debug.ShouldStop(64);
branch.mostCurrent._branches.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 72;BA.debugLine="Panel3.AddView(branches, responsiveLabel(home), 0";
Debug.ShouldStop(128);
branch.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((branch.mostCurrent._branches.getObject())),(Object)(_responsivelabel(branch.mostCurrent._home)),(Object)(BA.numberCast(int.class, 0)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))),(Object)(branch.mostCurrent._panel3.runMethod(true,"getHeight")));
 BA.debugLineNum = 74;BA.debugLine="popupPanel.Initialize(\"\")";
Debug.ShouldStop(512);
branch.mostCurrent._popuppanel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 75;BA.debugLine="popupPanel.Color = Colors.ARGB(200, 0, 0, 0)";
Debug.ShouldStop(1024);
branch.mostCurrent._popuppanel.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 200)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 76;BA.debugLine="popupPanel.Visible = False";
Debug.ShouldStop(2048);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 77;BA.debugLine="Activity.AddView(popupPanel, 0, 0, Activity.Width";
Debug.ShouldStop(4096);
branch.mostCurrent._activity.runVoidMethod ("AddView",(Object)((branch.mostCurrent._popuppanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(branch.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(branch.mostCurrent._activity.runMethod(true,"getHeight")));
 BA.debugLineNum = 79;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(16384);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 80;BA.debugLine="cd.Initialize2(Colors.White, 5dip, 1dip, Colors.B";
Debug.ShouldStop(32768);
_cd.runVoidMethod ("Initialize2",(Object)(branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))),(Object)(branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 83;BA.debugLine="popupPanelBackground.Initialize(\"\")";
Debug.ShouldStop(262144);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 84;BA.debugLine="popupPanelBackground.Color = Colors.White";
Debug.ShouldStop(524288);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 85;BA.debugLine="popupPanel.AddView(popupPanelBackground, 70dip, 5";
Debug.ShouldStop(1048576);
branch.mostCurrent._popuppanel.runVoidMethod ("AddView",(Object)((branch.mostCurrent._popuppanelbackground.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 550)))),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._activity.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 500)))}, "-",1, 1)));
 BA.debugLineNum = 88;BA.debugLine="Dim leftPosition As Int = (popupPanel.Width - pop";
Debug.ShouldStop(8388608);
_leftposition = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanel.runMethod(true,"getWidth"),branch.mostCurrent._popuppanelbackground.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("leftPosition", _leftposition);Debug.locals.put("leftPosition", _leftposition);
 BA.debugLineNum = 89;BA.debugLine="popupPanelBackground.Left = leftPosition";
Debug.ShouldStop(16777216);
branch.mostCurrent._popuppanelbackground.runMethod(true,"setLeft",_leftposition);
 BA.debugLineNum = 93;BA.debugLine="Dim closeButton As Label";
Debug.ShouldStop(268435456);
_closebutton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("closeButton", _closebutton);
 BA.debugLineNum = 94;BA.debugLine="closeButton.Initialize(\"closeButton\")";
Debug.ShouldStop(536870912);
_closebutton.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("closeButton")));
 BA.debugLineNum = 95;BA.debugLine="closeButton.Text = \"X\"";
Debug.ShouldStop(1073741824);
_closebutton.runMethod(true,"setText",BA.ObjectToCharSequence("X"));
 BA.debugLineNum = 96;BA.debugLine="closeButton.TextSize = 15";
Debug.ShouldStop(-2147483648);
_closebutton.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 97;BA.debugLine="closeButton.TextColor = Colors.Red";
Debug.ShouldStop(1);
_closebutton.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 98;BA.debugLine="closeButton.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(2);
_closebutton.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 99;BA.debugLine="closeButton.Gravity = Gravity.CENTER";
Debug.ShouldStop(4);
_closebutton.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 100;BA.debugLine="popupPanelBackground.AddView(closeButton, popupPa";
Debug.ShouldStop(8);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("AddView",(Object)((_closebutton.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanelbackground.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 101;BA.debugLine="closeButton.Background = cd";
Debug.ShouldStop(16);
_closebutton.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 103;BA.debugLine="target_id_display.Initialize(\"target_id_display\")";
Debug.ShouldStop(64);
branch.mostCurrent._target_id_display.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("target_id_display")));
 BA.debugLineNum = 104;BA.debugLine="target_id_display.TextSize = 20";
Debug.ShouldStop(128);
branch.mostCurrent._target_id_display.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 105;BA.debugLine="target_id_display.TextColor = Colors.Red";
Debug.ShouldStop(256);
branch.mostCurrent._target_id_display.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 106;BA.debugLine="target_id_display.Typeface = Typeface.DEFAULT_BOL";
Debug.ShouldStop(512);
branch.mostCurrent._target_id_display.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 109;BA.debugLine="Dim myImage As Bitmap = LoadBitmap(File.DirAssets";
Debug.ShouldStop(4096);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_myimage = branch.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(branch.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("store.PNG")));Debug.locals.put("myImage", _myimage);Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 110;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(8192);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 111;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(16384);
_imgview.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 112;BA.debugLine="imgView.Gravity = Gravity.FILL";
Debug.ShouldStop(32768);
_imgview.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 113;BA.debugLine="imgView.Bitmap = myImage";
Debug.ShouldStop(65536);
_imgview.runMethod(false,"setBitmap",(_myimage.getObject()));
 BA.debugLineNum = 114;BA.debugLine="popupPanelBackground.AddView(imgView, 25%x, 12.5d";
Debug.ShouldStop(131072);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("AddView",(Object)((_imgview.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),branch.mostCurrent.activityBA)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12.5)))),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanelbackground.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),branch.mostCurrent.activityBA)}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))));
 BA.debugLineNum = 117;BA.debugLine="Dim popupText As Label";
Debug.ShouldStop(1048576);
_popuptext = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("popupText", _popuptext);
 BA.debugLineNum = 118;BA.debugLine="popupText.Initialize(\"\")";
Debug.ShouldStop(2097152);
_popuptext.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 119;BA.debugLine="popupText.Text = \"Modify Target Sales\"";
Debug.ShouldStop(4194304);
_popuptext.runMethod(true,"setText",BA.ObjectToCharSequence("Modify Target Sales"));
 BA.debugLineNum = 120;BA.debugLine="popupText.TextColor = Colors.Black";
Debug.ShouldStop(8388608);
_popuptext.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 121;BA.debugLine="popupText.TextSize = 50";
Debug.ShouldStop(16777216);
_popuptext.runMethod(true,"setTextSize",BA.numberCast(float.class, 50));
 BA.debugLineNum = 122;BA.debugLine="popupText.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(33554432);
_popuptext.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 123;BA.debugLine="popupText.Gravity = Gravity.CENTER";
Debug.ShouldStop(67108864);
_popuptext.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 124;BA.debugLine="popupPanelBackground.AddView(popupText, 25dip, im";
Debug.ShouldStop(134217728);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("AddView",(Object)((_popuptext.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(RemoteObject.solve(new RemoteObject[] {_imgview.runMethod(true,"getTop"),_imgview.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanelbackground.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 65)))));
 BA.debugLineNum = 126;BA.debugLine="Dim popupDirectionText As Label";
Debug.ShouldStop(536870912);
_popupdirectiontext = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("popupDirectionText", _popupdirectiontext);
 BA.debugLineNum = 127;BA.debugLine="popupDirectionText.Initialize(\"\")";
Debug.ShouldStop(1073741824);
_popupdirectiontext.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 128;BA.debugLine="popupDirectionText.Text = \"Modify the sales targe";
Debug.ShouldStop(-2147483648);
_popupdirectiontext.runMethod(true,"setText",BA.ObjectToCharSequence("Modify the sales target and set a new goal for total company sales."));
 BA.debugLineNum = 129;BA.debugLine="popupDirectionText.TextColor = Colors.ARGB(150,0,";
Debug.ShouldStop(1);
_popupdirectiontext.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 150)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 130;BA.debugLine="popupDirectionText.TextSize = 15";
Debug.ShouldStop(2);
_popupdirectiontext.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 131;BA.debugLine="popupDirectionText.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(4);
_popupdirectiontext.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 132;BA.debugLine="popupDirectionText.Gravity = Gravity.CENTER";
Debug.ShouldStop(8);
_popupdirectiontext.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 133;BA.debugLine="popupPanelBackground.AddView(popupDirectionText,";
Debug.ShouldStop(16);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("AddView",(Object)((_popupdirectiontext.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(RemoteObject.solve(new RemoteObject[] {_popuptext.runMethod(true,"getTop"),_popuptext.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanelbackground.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 135;BA.debugLine="target_countLabel.Initialize(\"\")";
Debug.ShouldStop(64);
branch.mostCurrent._target_countlabel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 137;BA.debugLine="target_countLabel.TextColor = Colors.Black";
Debug.ShouldStop(256);
branch.mostCurrent._target_countlabel.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 138;BA.debugLine="target_countLabel.TextSize = 25";
Debug.ShouldStop(512);
branch.mostCurrent._target_countlabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 25));
 BA.debugLineNum = 139;BA.debugLine="target_countLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(1024);
branch.mostCurrent._target_countlabel.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 141;BA.debugLine="popupPanelBackground.AddView(target_countLabel, 5";
Debug.ShouldStop(4096);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("AddView",(Object)((branch.mostCurrent._target_countlabel.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(RemoteObject.solve(new RemoteObject[] {_popupdirectiontext.runMethod(true,"getTop"),_popupdirectiontext.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanelbackground.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 142;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 251, 2";
Debug.ShouldStop(8192);
branch.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 251)),(Object)(BA.numberCast(int.class, 251)),(Object)(BA.numberCast(int.class, 251))));
 BA.debugLineNum = 144;BA.debugLine="AddBottomBorderToLabel(target_countLabel)";
Debug.ShouldStop(32768);
_addbottombordertolabel(branch.mostCurrent._target_countlabel);
 BA.debugLineNum = 146;BA.debugLine="Dim edit_button As Button";
Debug.ShouldStop(131072);
_edit_button = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("edit_button", _edit_button);
 BA.debugLineNum = 147;BA.debugLine="edit_button.Initialize(\"edit_button\")";
Debug.ShouldStop(262144);
_edit_button.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("edit_button")));
 BA.debugLineNum = 148;BA.debugLine="edit_button.Text = \"Update\"";
Debug.ShouldStop(524288);
_edit_button.runMethod(true,"setText",BA.ObjectToCharSequence("Update"));
 BA.debugLineNum = 149;BA.debugLine="edit_button.TextColor = Colors.White";
Debug.ShouldStop(1048576);
_edit_button.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 150;BA.debugLine="edit_button.TextSize = 25";
Debug.ShouldStop(2097152);
_edit_button.runMethod(true,"setTextSize",BA.numberCast(float.class, 25));
 BA.debugLineNum = 151;BA.debugLine="edit_button.Gravity = Gravity.CENTER";
Debug.ShouldStop(4194304);
_edit_button.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 152;BA.debugLine="popupPanelBackground.AddView(edit_button, 30%x, t";
Debug.ShouldStop(8388608);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("AddView",(Object)((_edit_button.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 30)),branch.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._target_countlabel.runMethod(true,"getTop"),branch.mostCurrent._target_countlabel.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))}, "++",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanelbackground.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),branch.mostCurrent.activityBA)}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 154;BA.debugLine="Dim cdBack As ColorDrawable";
Debug.ShouldStop(33554432);
_cdback = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cdBack", _cdback);
 BA.debugLineNum = 155;BA.debugLine="cdBack.Initialize2(Colors.RGB(61, 12, 2), 10dip,";
Debug.ShouldStop(67108864);
_cdback.runVoidMethod ("Initialize2",(Object)(branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 156;BA.debugLine="edit_button.Background = cdBack";
Debug.ShouldStop(134217728);
_edit_button.runMethod(false,"setBackground",(_cdback.getObject()));
 BA.debugLineNum = 159;BA.debugLine="purchasePanel.Initialize(\"\")";
Debug.ShouldStop(1073741824);
branch.mostCurrent._purchasepanel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 160;BA.debugLine="Panel4.AddView(purchasePanel, 0, 0dip, Activity.W";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._panel4.runVoidMethod ("AddView",(Object)((branch.mostCurrent._purchasepanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(branch.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 530)))));
 BA.debugLineNum = 161;BA.debugLine="purchasePanel.Color = Colors.White";
Debug.ShouldStop(1);
branch.mostCurrent._purchasepanel.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 163;BA.debugLine="scrollViewPanel4.Initialize(Panel4.Height - purch";
Debug.ShouldStop(4);
branch.mostCurrent._scrollviewpanel4.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._panel4.runMethod(true,"getHeight"),branch.mostCurrent._purchasepanel.runMethod(true,"getHeight")}, "-",1, 1)));
 BA.debugLineNum = 164;BA.debugLine="Panel4.AddView(scrollViewPanel4, 0, purchasePanel";
Debug.ShouldStop(8);
branch.mostCurrent._panel4.runVoidMethod ("AddView",(Object)((branch.mostCurrent._scrollviewpanel4.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(branch.mostCurrent._purchasepanel.runMethod(true,"getHeight")),(Object)(branch.mostCurrent._panel4.runMethod(true,"getWidth")),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._panel4.runMethod(true,"getHeight"),branch.mostCurrent._purchasepanel.runMethod(true,"getHeight")}, "-",1, 1)));
 BA.debugLineNum = 169;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(256);
_loadcompanydata();
 BA.debugLineNum = 170;BA.debugLine="LoadCompanyDataBranchGraphSales";
Debug.ShouldStop(512);
_loadcompanydatabranchgraphsales();
 BA.debugLineNum = 171;BA.debugLine="LoadCompanyDataBranchGraphPurchase";
Debug.ShouldStop(1024);
_loadcompanydatabranchgraphpurchase();
 BA.debugLineNum = 172;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Activity_Pause (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,177);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 177;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 178;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Activity_Resume (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,173);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","activity_resume");}
 BA.debugLineNum = 173;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4096);
 BA.debugLineNum = 175;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addbottombordertolabel(RemoteObject _lbl) throws Exception{
try {
		Debug.PushSubsStack("AddBottomBorderToLabel (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,944);
if (RapidSub.canDelegate("addbottombordertolabel")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","addbottombordertolabel", _lbl);}
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _bd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 944;BA.debugLine="Sub AddBottomBorderToLabel(lbl As EditText)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 946;BA.debugLine="Dim bmp As Bitmap";
Debug.ShouldStop(131072);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 947;BA.debugLine="bmp.InitializeMutable(lbl.Width, lbl.Height)";
Debug.ShouldStop(262144);
_bmp.runVoidMethod ("InitializeMutable",(Object)(_lbl.runMethod(true,"getWidth")),(Object)(_lbl.runMethod(true,"getHeight")));
 BA.debugLineNum = 950;BA.debugLine="Dim cvs As Canvas";
Debug.ShouldStop(2097152);
_cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 951;BA.debugLine="cvs.Initialize2(bmp)";
Debug.ShouldStop(4194304);
_cvs.runVoidMethod ("Initialize2",(Object)((_bmp.getObject())));
 BA.debugLineNum = 952;BA.debugLine="cvs.DrawLine(0, lbl.Height - 2dip, lbl.Width, lbl";
Debug.ShouldStop(8388608);
_cvs.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_lbl.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 1))),(Object)(BA.numberCast(float.class, _lbl.runMethod(true,"getWidth"))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_lbl.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 1))),(Object)(branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.numberCast(float.class, branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 955;BA.debugLine="Dim bd As BitmapDrawable";
Debug.ShouldStop(67108864);
_bd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("bd", _bd);
 BA.debugLineNum = 956;BA.debugLine="bd.Initialize(bmp)";
Debug.ShouldStop(134217728);
_bd.runVoidMethod ("Initialize",(Object)((_bmp.getObject())));
 BA.debugLineNum = 957;BA.debugLine="lbl.Background = bd";
Debug.ShouldStop(268435456);
_lbl.runMethod(false,"setBackground",(_bd.getObject()));
 BA.debugLineNum = 958;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("backbtn_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,721);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","backbtn_click");}
 BA.debugLineNum = 721;BA.debugLine="Sub backbtn_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 722;BA.debugLine="If currentPage > 1 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean(">",branch._currentpage,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 723;BA.debugLine="currentPage = currentPage - 1";
Debug.ShouldStop(262144);
branch._currentpage = RemoteObject.solve(new RemoteObject[] {branch._currentpage,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 724;BA.debugLine="Log($\"Previous page: ${currentPage}\"$)";
Debug.ShouldStop(524288);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22818051",(RemoteObject.concat(RemoteObject.createImmutable("Previous page: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._currentpage))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 725;BA.debugLine="LoadCompanyDataBranchGraphSales ' Updates graph";
Debug.ShouldStop(1048576);
_loadcompanydatabranchgraphsales();
 BA.debugLineNum = 726;BA.debugLine="LoadCompanyData ' Updates panels";
Debug.ShouldStop(2097152);
_loadcompanydata();
 BA.debugLineNum = 727;BA.debugLine="ProgressDialogShow(\"Loading Graph Data...\")";
Debug.ShouldStop(4194304);
branch.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",branch.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Graph Data..."))));
 };
 BA.debugLineNum = 729;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("closeButton_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,687);
if (RapidSub.canDelegate("closebutton_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","closebutton_click");}
 BA.debugLineNum = 687;BA.debugLine="Sub closeButton_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 688;BA.debugLine="popupPanel.Visible = False";
Debug.ShouldStop(32768);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 689;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("defBtn_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,732);
if (RapidSub.canDelegate("defbtn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","defbtn_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 732;BA.debugLine="Sub defBtn_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 733;BA.debugLine="Dim btn As Button = Sender ' Get the button that";
Debug.ShouldStop(268435456);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 734;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(536870912);
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 735;BA.debugLine="sortDefaultValue = \"\"";
Debug.ShouldStop(1073741824);
branch.mostCurrent._sortdefaultvalue = BA.ObjectToString("");
 BA.debugLineNum = 736;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(-2147483648);
_loadcompanydata();
 BA.debugLineNum = 737;BA.debugLine="Log(index)";
Debug.ShouldStop(1);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22883589",_index,0);
 BA.debugLineNum = 738;BA.debugLine="Log(\"(default)\")";
Debug.ShouldStop(2);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22883590",RemoteObject.createImmutable("(default)"),0);
 BA.debugLineNum = 743;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("edit_button_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,659);
if (RapidSub.canDelegate("edit_button_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","edit_button_click");}
RemoteObject _target_id = RemoteObject.createImmutable(0);
RemoteObject _new_value = RemoteObject.createImmutable(0);
 BA.debugLineNum = 659;BA.debugLine="Sub edit_button_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 660;BA.debugLine="Dim target_id As Int = target_id_display.Text";
Debug.ShouldStop(524288);
_target_id = BA.numberCast(int.class, branch.mostCurrent._target_id_display.runMethod(true,"getText"));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 661;BA.debugLine="Dim new_value As Int = target_countLabel.Text";
Debug.ShouldStop(1048576);
_new_value = BA.numberCast(int.class, branch.mostCurrent._target_countlabel.runMethod(true,"getText"));Debug.locals.put("new_value", _new_value);Debug.locals.put("new_value", _new_value);
 BA.debugLineNum = 663;BA.debugLine="If IsNumber(target_id) And IsNumber(new_value) Th";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean(".",branch.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.NumberToString(_target_id)))) && RemoteObject.solveBoolean(".",branch.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.NumberToString(_new_value))))) { 
 BA.debugLineNum = 664;BA.debugLine="UpdateData_Remote(target_id, new_value)";
Debug.ShouldStop(8388608);
_updatedata_remote(_target_id,_new_value);
 BA.debugLineNum = 665;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(16777216);
_loadcompanydata();
 BA.debugLineNum = 666;BA.debugLine="popupPanel.Visible = False";
Debug.ShouldStop(33554432);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 668;BA.debugLine="Log(\"Invalid input values\")";
Debug.ShouldStop(134217728);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22293769",RemoteObject.createImmutable("Invalid input values"),0);
 };
 BA.debugLineNum = 670;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Private ScrollView1 As ScrollView";
branch.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Dim PHPURL As String = \"https://192.168.8.117/Com";
branch.mostCurrent._phpurl = RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id="),branch.mostCurrent._starter._company_selected /*RemoteObject*/ );
 //BA.debugLineNum = 15;BA.debugLine="Dim PHPURL1 As String = \"https://192.168.8.117/Co";
branch.mostCurrent._phpurl1 = BA.ObjectToString("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page=1");
 //BA.debugLineNum = 16;BA.debugLine="Dim TableDetails As List";
branch.mostCurrent._tabledetails = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 17;BA.debugLine="Private LabelTitle As Label";
branch.mostCurrent._labeltitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim titleFontSize As Int = 4.5%y";
branch._titlefontsize = branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 4.5)),branch.mostCurrent.activityBA);
 //BA.debugLineNum = 19;BA.debugLine="Dim primaryFontSize As Int = 1.6%y";
branch._primaryfontsize = branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1.6)),branch.mostCurrent.activityBA);
 //BA.debugLineNum = 20;BA.debugLine="Dim secondaryFontSize As Int = 1%y";
branch._secondaryfontsize = branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1)),branch.mostCurrent.activityBA);
 //BA.debugLineNum = 21;BA.debugLine="Dim num As Int = 1";
branch._num = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 22;BA.debugLine="Private Panel3 As Panel";
branch.mostCurrent._panel3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim home As Label";
branch.mostCurrent._home = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim branches As Label";
branch.mostCurrent._branches = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Dim popupPanel As Panel";
branch.mostCurrent._popuppanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim target_countLabel As EditText";
branch.mostCurrent._target_countlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim target_id_display As Label";
branch.mostCurrent._target_id_display = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim totalTarget As Label";
branch.mostCurrent._totaltarget = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim Panel As Panel";
branch.mostCurrent._panel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim barGraph As barGraph";
branch.mostCurrent._bargraph = RemoteObject.createNew ("b4a.example.bargraph");
 //BA.debugLineNum = 31;BA.debugLine="Dim barGraphPurchase As barGraph";
branch.mostCurrent._bargraphpurchase = RemoteObject.createNew ("b4a.example.bargraph");
 //BA.debugLineNum = 32;BA.debugLine="Dim nxtBtn As Button";
branch.mostCurrent._nxtbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Dim backbtn As Button";
branch.mostCurrent._backbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Dim salesPanel As Panel ' New panel for sales gra";
branch.mostCurrent._salespanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Dim purchasePanel As Panel ' Existing panel renam";
branch.mostCurrent._purchasepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Dim currentPage As Int = 1";
branch._currentpage = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 37;BA.debugLine="Dim totalSales As Int = 0";
branch._totalsales = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 38;BA.debugLine="Dim barGraphInitialized As Boolean = False";
branch._bargraphinitialized = branch.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 39;BA.debugLine="Dim barGraphInitializedPurchase As Boolean = Fals";
branch._bargraphinitializedpurchase = branch.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 40;BA.debugLine="Private Panel4 As Panel";
branch.mostCurrent._panel4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Dim scrollViewPanel4 As ScrollView";
branch.mostCurrent._scrollviewpanel4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Dim sortBtn1 As RadioButton";
branch.mostCurrent._sortbtn1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Public defBtn As RadioButton";
branch.mostCurrent._defbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Public sortBtn2 As RadioButton";
branch.mostCurrent._sortbtn2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Public salesBtn1 As RadioButton";
branch.mostCurrent._salesbtn1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Public salesBtn2 As RadioButton";
branch.mostCurrent._salesbtn2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Public salesBtn3 As RadioButton";
branch.mostCurrent._salesbtn3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Dim salesData1 As Int";
branch._salesdata1 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 49;BA.debugLine="Dim salesDataDefault As Int = 1";
branch._salesdatadefault = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 50;BA.debugLine="Dim sortDefaultValue As String";
branch.mostCurrent._sortdefaultvalue = RemoteObject.createImmutable("");
 //BA.debugLineNum = 51;BA.debugLine="Dim showHideBtn As Button";
branch.mostCurrent._showhidebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Dim showHide As Boolean = True";
branch._showhide = branch.mostCurrent.__c.getField(true,"True");
 //BA.debugLineNum = 53;BA.debugLine="Dim popupPanelBackground As Panel";
branch.mostCurrent._popuppanelbackground = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _home_click() throws Exception{
try {
		Debug.PushSubsStack("home_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,700);
if (RapidSub.canDelegate("home_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","home_click");}
 BA.debugLineNum = 700;BA.debugLine="Private Sub home_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 701;BA.debugLine="StartActivity(\"Main\")";
Debug.ShouldStop(268435456);
branch.mostCurrent.__c.runVoidMethod ("StartActivity",branch.processBA,(Object)((RemoteObject.createImmutable("Main"))));
 BA.debugLineNum = 702;BA.debugLine="Activity.Finish";
Debug.ShouldStop(536870912);
branch.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 703;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("JobDone (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,227);
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
RemoteObject _salesarray = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _totalbranches = RemoteObject.createImmutable(0);
RemoteObject _branchnames = null;
RemoteObject _branchsales1 = null;
RemoteObject _branchsales2 = null;
RemoteObject _branchsales3 = null;
RemoteObject _branchpurchase1 = null;
RemoteObject _branchpurchase2 = null;
RemoteObject _branchpurchase3 = null;
RemoteObject _branchcount = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _legend = null;
Debug.locals.put("job", _job);
 BA.debugLineNum = 227;BA.debugLine="Sub JobDone(job As HttpJob)";
Debug.ShouldStop(4);
 BA.debugLineNum = 229;BA.debugLine="Dim scrollHeight As Int = 0";
Debug.ShouldStop(16);
_scrollheight = BA.numberCast(int.class, 0);Debug.locals.put("scrollHeight", _scrollheight);Debug.locals.put("scrollHeight", _scrollheight);
 BA.debugLineNum = 231;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),branch.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 232;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 233;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(256);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 234;BA.debugLine="parser.Initialize(job.GetString)";
Debug.ShouldStop(512);
_parser.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 236;BA.debugLine="Select Case job.JobName";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("GetData"),BA.ObjectToString("UpdateData"),BA.ObjectToString("GetBranches"),BA.ObjectToString("UpdateData"))) {
case 0: {
 BA.debugLineNum = 238;BA.debugLine="TableDetails = parser.NextArray";
Debug.ShouldStop(8192);
branch.mostCurrent._tabledetails = _parser.runMethod(false,"NextArray");
 BA.debugLineNum = 239;BA.debugLine="totalTarget.RemoveView";
Debug.ShouldStop(16384);
branch.mostCurrent._totaltarget.runVoidMethod ("RemoveView");
 BA.debugLineNum = 240;BA.debugLine="Dim numColumns As Int = 2 ' Adjust based on p";
Debug.ShouldStop(32768);
_numcolumns = BA.numberCast(int.class, 2);Debug.locals.put("numColumns", _numcolumns);Debug.locals.put("numColumns", _numcolumns);
 BA.debugLineNum = 241;BA.debugLine="Dim pnlWidth As Int = Activity.Width - 100dip";
Debug.ShouldStop(65536);
_pnlwidth = RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._activity.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))}, "-",1, 1);Debug.locals.put("pnlWidth", _pnlwidth);Debug.locals.put("pnlWidth", _pnlwidth);
 BA.debugLineNum = 242;BA.debugLine="Dim pnlHeight As Int = 280dip";
Debug.ShouldStop(131072);
_pnlheight = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 280)));Debug.locals.put("pnlHeight", _pnlheight);Debug.locals.put("pnlHeight", _pnlheight);
 BA.debugLineNum = 243;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(262144);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 244;BA.debugLine="Dim leftPosition As Int = 50dip";
Debug.ShouldStop(524288);
_leftposition = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)));Debug.locals.put("leftPosition", _leftposition);Debug.locals.put("leftPosition", _leftposition);
 BA.debugLineNum = 245;BA.debugLine="Dim topPosition As Int = 0";
Debug.ShouldStop(1048576);
_topposition = BA.numberCast(int.class, 0);Debug.locals.put("topPosition", _topposition);Debug.locals.put("topPosition", _topposition);
 BA.debugLineNum = 246;BA.debugLine="Dim count As Int = 0 ' Track panel count";
Debug.ShouldStop(2097152);
_count = BA.numberCast(int.class, 0);Debug.locals.put("count", _count);Debug.locals.put("count", _count);
 BA.debugLineNum = 247;BA.debugLine="If Activity.Width >= 1340 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("g",branch.mostCurrent._activity.runMethod(true,"getWidth"),BA.numberCast(double.class, 1340))) { 
 BA.debugLineNum = 248;BA.debugLine="pnlWidth = 490dip";
Debug.ShouldStop(8388608);
_pnlwidth = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 490)));Debug.locals.put("pnlWidth", _pnlwidth);
 BA.debugLineNum = 249;BA.debugLine="pnlHeight = 300dip";
Debug.ShouldStop(16777216);
_pnlheight = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)));Debug.locals.put("pnlHeight", _pnlheight);
 BA.debugLineNum = 250;BA.debugLine="padding = 10dip";
Debug.ShouldStop(33554432);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);
 BA.debugLineNum = 251;BA.debugLine="leftPosition = 10dip";
Debug.ShouldStop(67108864);
_leftposition = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("leftPosition", _leftposition);
 };
 BA.debugLineNum = 253;BA.debugLine="For Each record As Map In TableDetails";
Debug.ShouldStop(268435456);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group23 = branch.mostCurrent._tabledetails;
final int groupLen23 = group23.runMethod(true,"getSize").<Integer>get()
;int index23 = 0;
;
for (; index23 < groupLen23;index23++){
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group23.runMethod(false,"Get",index23));Debug.locals.put("record", _record);
Debug.locals.put("record", _record);
 BA.debugLineNum = 255;BA.debugLine="Panel.Initialize(\"Panel\")";
Debug.ShouldStop(1073741824);
branch.mostCurrent._panel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel")));
 BA.debugLineNum = 256;BA.debugLine="Panel.Visible = showHide";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._panel.runMethod(true,"setVisible",branch._showhide);
 BA.debugLineNum = 257;BA.debugLine="scrollViewPanel4.Panel.AddView(Panel, leftPo";
Debug.ShouldStop(1);
branch.mostCurrent._scrollviewpanel4.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((branch.mostCurrent._panel.getObject())),(Object)(_leftposition),(Object)(_topposition),(Object)(_pnlwidth),(Object)(_pnlheight));
 BA.debugLineNum = 258;BA.debugLine="Panel.Color = Colors.Black";
Debug.ShouldStop(2);
branch.mostCurrent._panel.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 259;BA.debugLine="If Panel.Visible = True Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",branch.mostCurrent._panel.runMethod(true,"getVisible"),branch.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 260;BA.debugLine="Dim companyName As String = record.Get(\"com";
Debug.ShouldStop(8);
_companyname = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("company_name")))));Debug.locals.put("companyName", _companyname);Debug.locals.put("companyName", _companyname);
 BA.debugLineNum = 261;BA.debugLine="Dim id As String = record.Get(\"branch_id\")";
Debug.ShouldStop(16);
_id = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("branch_id")))));Debug.locals.put("id", _id);Debug.locals.put("id", _id);
 BA.debugLineNum = 262;BA.debugLine="Dim name As String = record.Get(\"branch_nam";
Debug.ShouldStop(32);
_name = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("branch_name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 263;BA.debugLine="Dim total_count As Int = record.Get(\"target";
Debug.ShouldStop(64);
_total_count = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("target_no")))));Debug.locals.put("total_count", _total_count);Debug.locals.put("total_count", _total_count);
 BA.debugLineNum = 264;BA.debugLine="Dim total_pos As Int = record.Get(\"count_de";
Debug.ShouldStop(128);
_total_pos = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("count_device")))));Debug.locals.put("total_pos", _total_pos);Debug.locals.put("total_pos", _total_pos);
 BA.debugLineNum = 265;BA.debugLine="Dim totalPur1 As String = record.Get(\"purch";
Debug.ShouldStop(256);
_totalpur1 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("purchase_1")))));Debug.locals.put("totalPur1", _totalpur1);Debug.locals.put("totalPur1", _totalpur1);
 BA.debugLineNum = 266;BA.debugLine="Dim totalPur2 As String = record.Get(\"purch";
Debug.ShouldStop(512);
_totalpur2 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("purchase_2")))));Debug.locals.put("totalPur2", _totalpur2);Debug.locals.put("totalPur2", _totalpur2);
 BA.debugLineNum = 267;BA.debugLine="Dim totalPur3 As String = record.Get(\"purch";
Debug.ShouldStop(1024);
_totalpur3 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("purchase_3")))));Debug.locals.put("totalPur3", _totalpur3);Debug.locals.put("totalPur3", _totalpur3);
 BA.debugLineNum = 268;BA.debugLine="Dim totalSales1 As String = record.Get(\"sal";
Debug.ShouldStop(2048);
_totalsales1 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("sales_1")))));Debug.locals.put("totalSales1", _totalsales1);Debug.locals.put("totalSales1", _totalsales1);
 BA.debugLineNum = 269;BA.debugLine="Dim totalSales2 As String = record.Get(\"sal";
Debug.ShouldStop(4096);
_totalsales2 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("sales_2")))));Debug.locals.put("totalSales2", _totalsales2);Debug.locals.put("totalSales2", _totalsales2);
 BA.debugLineNum = 270;BA.debugLine="Dim totalSales3 As String = record.Get(\"sal";
Debug.ShouldStop(8192);
_totalsales3 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("sales_3")))));Debug.locals.put("totalSales3", _totalsales3);Debug.locals.put("totalSales3", _totalsales3);
 BA.debugLineNum = 271;BA.debugLine="Dim target_id As String = record.Get(\"targe";
Debug.ShouldStop(16384);
_target_id = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("target_id")))));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 272;BA.debugLine="totalSales = totalSales1.Length";
Debug.ShouldStop(32768);
branch._totalsales = _totalsales1.runMethod(true,"length");
 BA.debugLineNum = 273;BA.debugLine="branches.Text = \"Branches - \" & companyName";
Debug.ShouldStop(65536);
branch.mostCurrent._branches.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Branches - "),_companyname)));
 BA.debugLineNum = 274;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
Debug.ShouldStop(131072);
branch.mostCurrent._branches.runMethod(true,"setText",BA.ObjectToCharSequence(branch.mostCurrent._branches.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 276;BA.debugLine="LabelTitle.Text = companyName";
Debug.ShouldStop(524288);
branch.mostCurrent._labeltitle.runMethod(true,"setText",BA.ObjectToCharSequence(_companyname));
 BA.debugLineNum = 277;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCa";
Debug.ShouldStop(1048576);
branch.mostCurrent._labeltitle.runMethod(true,"setText",BA.ObjectToCharSequence(branch.mostCurrent._labeltitle.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 278;BA.debugLine="LabelTitle.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(2097152);
branch.mostCurrent._labeltitle.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 281;BA.debugLine="Dim Panel2 As Panel";
Debug.ShouldStop(16777216);
_panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("Panel2", _panel2);
 BA.debugLineNum = 282;BA.debugLine="Panel2.Initialize(\"Panel2\")";
Debug.ShouldStop(33554432);
_panel2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel2")));
 BA.debugLineNum = 283;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(67108864);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 284;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As";
Debug.ShouldStop(134217728);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 185)),(Object)(BA.numberCast(int.class, 46)),(Object)(BA.numberCast(int.class, 52))),branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))})));
 BA.debugLineNum = 285;BA.debugLine="Panel2.Background = gradient";
Debug.ShouldStop(268435456);
_panel2.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 286;BA.debugLine="Panel2.Tag = name";
Debug.ShouldStop(536870912);
_panel2.runMethod(false,"setTag",(_name));
 BA.debugLineNum = 287;BA.debugLine="Panel2.SendToBack";
Debug.ShouldStop(1073741824);
_panel2.runVoidMethod ("SendToBack");
 BA.debugLineNum = 288;BA.debugLine="Panel.AddView(Panel2, 0, 0, Panel.Width, 6%";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_panel2.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(branch.mostCurrent._panel.runMethod(true,"getWidth")),(Object)(branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 6)),branch.mostCurrent.activityBA)));
 BA.debugLineNum = 290;BA.debugLine="Dim BranchNameLabel As Label";
Debug.ShouldStop(2);
_branchnamelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("BranchNameLabel", _branchnamelabel);
 BA.debugLineNum = 291;BA.debugLine="BranchNameLabel.Initialize(\"Label17\")";
Debug.ShouldStop(4);
_branchnamelabel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Label17")));
 BA.debugLineNum = 292;BA.debugLine="BranchNameLabel.Text = name";
Debug.ShouldStop(8);
_branchnamelabel.runMethod(true,"setText",BA.ObjectToCharSequence(_name));
 BA.debugLineNum = 293;BA.debugLine="BranchNameLabel.Tag = id";
Debug.ShouldStop(16);
_branchnamelabel.runMethod(false,"setTag",(_id));
 BA.debugLineNum = 294;BA.debugLine="BranchNameLabel.TextSize = 18";
Debug.ShouldStop(32);
_branchnamelabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 295;BA.debugLine="BranchNameLabel.TextColor = Colors.White";
Debug.ShouldStop(64);
_branchnamelabel.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 296;BA.debugLine="BranchNameLabel.Typeface = Typeface.MONOSPA";
Debug.ShouldStop(128);
_branchnamelabel.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 297;BA.debugLine="BranchNameLabel.Gravity = Gravity.CENTER_VE";
Debug.ShouldStop(256);
_branchnamelabel.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 298;BA.debugLine="Panel2.AddView(BranchNameLabel, 10dip, 0dip";
Debug.ShouldStop(512);
_panel2.runVoidMethod ("AddView",(Object)((_branchnamelabel.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(_panel2.runMethod(true,"getWidth")),(Object)(_panel2.runMethod(true,"getHeight")));
 BA.debugLineNum = 300;BA.debugLine="Dim myImage As Bitmap";
Debug.ShouldStop(2048);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 301;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrow";
Debug.ShouldStop(4096);
_myimage = branch.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(branch.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("arrows-removebg-preview.png")));Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 302;BA.debugLine="If myImage.IsInitialized Then";
Debug.ShouldStop(8192);
if (_myimage.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 303;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resiz";
Debug.ShouldStop(16384);
_resizedimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_resizedimage = _myimage.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 4.5)),branch.mostCurrent.activityBA))))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_myimage.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 2)),branch.mostCurrent.activityBA))),_myimage.runMethod(true,"getWidth")}, "*/",0, 0))),(Object)(branch.mostCurrent.__c.getField(true,"True")));Debug.locals.put("resizedImage", _resizedimage);Debug.locals.put("resizedImage", _resizedimage);
 BA.debugLineNum = 304;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(32768);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 305;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(65536);
_imgview.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 306;BA.debugLine="imgView.Bitmap = resizedImage";
Debug.ShouldStop(131072);
_imgview.runMethod(false,"setBitmap",(_resizedimage.getObject()));
 BA.debugLineNum = 307;BA.debugLine="Panel2.AddView(imgView, Panel2.Width - 8%x";
Debug.ShouldStop(262144);
_panel2.runVoidMethod ("AddView",(Object)((_imgview.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panel2.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 8)),branch.mostCurrent.activityBA)}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),branch.mostCurrent.activityBA)),(Object)(_panel2.runMethod(true,"getHeight")));
 }else {
 BA.debugLineNum = 309;BA.debugLine="Log(\"Error loading image\")";
Debug.ShouldStop(1048576);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22228306",RemoteObject.createImmutable("Error loading image"),0);
 };
 BA.debugLineNum = 312;BA.debugLine="Dim panelWidth As Int = Panel.Width / 3";
Debug.ShouldStop(8388608);
_panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(3)}, "/",0, 0));Debug.locals.put("panelWidth", _panelwidth);Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 313;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(16777216);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 314;BA.debugLine="Dim labelheight As Int = 35dip";
Debug.ShouldStop(33554432);
_labelheight = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)));Debug.locals.put("labelheight", _labelheight);Debug.locals.put("labelheight", _labelheight);
 BA.debugLineNum = 316;BA.debugLine="Dim purchase1 As Label";
Debug.ShouldStop(134217728);
_purchase1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase1", _purchase1);
 BA.debugLineNum = 317;BA.debugLine="purchase1.Initialize(\"\")";
Debug.ShouldStop(268435456);
_purchase1.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 318;BA.debugLine="purchase1.Text = totalPur1";
Debug.ShouldStop(536870912);
_purchase1.runMethod(true,"setText",BA.ObjectToCharSequence(_totalpur1));
 BA.debugLineNum = 319;BA.debugLine="purchase1.TextColor = Colors.Black";
Debug.ShouldStop(1073741824);
_purchase1.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 320;BA.debugLine="purchase1.TextSize = primaryFontSize";
Debug.ShouldStop(-2147483648);
_purchase1.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 321;BA.debugLine="purchase1.Gravity = Gravity.CENTER";
Debug.ShouldStop(1);
_purchase1.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 322;BA.debugLine="purchase1.Typeface = Typeface.SERIF";
Debug.ShouldStop(2);
_purchase1.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 323;BA.debugLine="Panel.AddView(purchase1, 0, Panel2.Height +";
Debug.ShouldStop(4);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_panel2.runMethod(true,"getHeight"),_padding}, "+",1, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 325;BA.debugLine="Dim purchase1Title As Label";
Debug.ShouldStop(16);
_purchase1title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase1Title", _purchase1title);
 BA.debugLineNum = 326;BA.debugLine="purchase1Title.Initialize(\"\")";
Debug.ShouldStop(32);
_purchase1title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 327;BA.debugLine="purchase1Title.Text = \"First Purchase\"";
Debug.ShouldStop(64);
_purchase1title.runMethod(true,"setText",BA.ObjectToCharSequence("First Purchase"));
 BA.debugLineNum = 328;BA.debugLine="purchase1Title.TextColor = Colors.Gray";
Debug.ShouldStop(128);
_purchase1title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 329;BA.debugLine="purchase1Title.TextSize = secondaryFontSize";
Debug.ShouldStop(256);
_purchase1title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 330;BA.debugLine="purchase1Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(512);
_purchase1title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 331;BA.debugLine="purchase1Title.Typeface = Typeface.MONOSPAC";
Debug.ShouldStop(1024);
_purchase1title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 332;BA.debugLine="purchase1Title.Text = purchase1Title.Text.T";
Debug.ShouldStop(2048);
_purchase1title.runMethod(true,"setText",BA.ObjectToCharSequence(_purchase1title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 333;BA.debugLine="Panel.AddView(purchase1Title, 0, purchase1.";
Debug.ShouldStop(4096);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase1title.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 335;BA.debugLine="Dim purchase2 As Label";
Debug.ShouldStop(16384);
_purchase2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase2", _purchase2);
 BA.debugLineNum = 336;BA.debugLine="purchase2.Initialize(\"\")";
Debug.ShouldStop(32768);
_purchase2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 337;BA.debugLine="purchase2.Text = totalPur2";
Debug.ShouldStop(65536);
_purchase2.runMethod(true,"setText",BA.ObjectToCharSequence(_totalpur2));
 BA.debugLineNum = 338;BA.debugLine="purchase2.TextColor = Colors.Black";
Debug.ShouldStop(131072);
_purchase2.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 339;BA.debugLine="purchase2.TextSize = primaryFontSize";
Debug.ShouldStop(262144);
_purchase2.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 340;BA.debugLine="purchase2.Gravity = Gravity.CENTER";
Debug.ShouldStop(524288);
_purchase2.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 341;BA.debugLine="purchase2.Typeface = Typeface.SERIF";
Debug.ShouldStop(1048576);
_purchase2.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 342;BA.debugLine="Panel.AddView(purchase2, panelWidth, Panel2";
Debug.ShouldStop(2097152);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase2.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_panel2.runMethod(true,"getHeight"),_padding}, "+",1, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 344;BA.debugLine="Dim purchase2Title As Label";
Debug.ShouldStop(8388608);
_purchase2title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase2Title", _purchase2title);
 BA.debugLineNum = 345;BA.debugLine="purchase2Title.Initialize(\"\")";
Debug.ShouldStop(16777216);
_purchase2title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 346;BA.debugLine="purchase2Title.Text = \"Second Purchase\"";
Debug.ShouldStop(33554432);
_purchase2title.runMethod(true,"setText",BA.ObjectToCharSequence("Second Purchase"));
 BA.debugLineNum = 347;BA.debugLine="purchase2Title.TextColor = Colors.Gray";
Debug.ShouldStop(67108864);
_purchase2title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 348;BA.debugLine="purchase2Title.TextSize = secondaryFontSize";
Debug.ShouldStop(134217728);
_purchase2title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 349;BA.debugLine="purchase2Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(268435456);
_purchase2title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 350;BA.debugLine="purchase2Title.Typeface = Typeface.MONOSPAC";
Debug.ShouldStop(536870912);
_purchase2title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 351;BA.debugLine="purchase2Title.Text = purchase2Title.Text.T";
Debug.ShouldStop(1073741824);
_purchase2title.runMethod(true,"setText",BA.ObjectToCharSequence(_purchase2title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 352;BA.debugLine="Panel.AddView(purchase2Title, panelWidth, p";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase2title.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 354;BA.debugLine="Dim purchase3 As Label";
Debug.ShouldStop(2);
_purchase3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase3", _purchase3);
 BA.debugLineNum = 355;BA.debugLine="purchase3.Initialize(\"\")";
Debug.ShouldStop(4);
_purchase3.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 356;BA.debugLine="purchase3.Text = totalPur3";
Debug.ShouldStop(8);
_purchase3.runMethod(true,"setText",BA.ObjectToCharSequence(_totalpur3));
 BA.debugLineNum = 357;BA.debugLine="purchase3.TextColor = Colors.Black";
Debug.ShouldStop(16);
_purchase3.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 358;BA.debugLine="purchase3.TextSize = primaryFontSize";
Debug.ShouldStop(32);
_purchase3.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 359;BA.debugLine="purchase3.Gravity = Gravity.CENTER";
Debug.ShouldStop(64);
_purchase3.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 360;BA.debugLine="purchase3.Typeface = Typeface.SERIF";
Debug.ShouldStop(128);
_purchase3.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 361;BA.debugLine="Panel.AddView(purchase3, panelWidth * 2, Pa";
Debug.ShouldStop(256);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase3.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_panel2.runMethod(true,"getHeight"),_padding}, "+",1, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 363;BA.debugLine="Dim purchase3Title As Label";
Debug.ShouldStop(1024);
_purchase3title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase3Title", _purchase3title);
 BA.debugLineNum = 364;BA.debugLine="purchase3Title.Initialize(\"\")";
Debug.ShouldStop(2048);
_purchase3title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 365;BA.debugLine="purchase3Title.Text = \"Third Purchase\"";
Debug.ShouldStop(4096);
_purchase3title.runMethod(true,"setText",BA.ObjectToCharSequence("Third Purchase"));
 BA.debugLineNum = 366;BA.debugLine="purchase3Title.TextColor = Colors.Gray";
Debug.ShouldStop(8192);
_purchase3title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 367;BA.debugLine="purchase3Title.TextSize = secondaryFontSize";
Debug.ShouldStop(16384);
_purchase3title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 368;BA.debugLine="purchase3Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(32768);
_purchase3title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 369;BA.debugLine="purchase3Title.Typeface = Typeface.MONOSPAC";
Debug.ShouldStop(65536);
_purchase3title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 370;BA.debugLine="purchase3Title.Text = purchase3Title.Text.T";
Debug.ShouldStop(131072);
_purchase3title.runMethod(true,"setText",BA.ObjectToCharSequence(_purchase3title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 371;BA.debugLine="Panel.AddView(purchase3Title, panelWidth *";
Debug.ShouldStop(262144);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase3title.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 373;BA.debugLine="Dim sale1 As Label";
Debug.ShouldStop(1048576);
_sale1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale1", _sale1);
 BA.debugLineNum = 374;BA.debugLine="sale1.Initialize(\"\")";
Debug.ShouldStop(2097152);
_sale1.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 375;BA.debugLine="sale1.Text = totalSales1";
Debug.ShouldStop(4194304);
_sale1.runMethod(true,"setText",BA.ObjectToCharSequence(_totalsales1));
 BA.debugLineNum = 376;BA.debugLine="sale1.TextColor = Colors.Black";
Debug.ShouldStop(8388608);
_sale1.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 377;BA.debugLine="sale1.TextSize = primaryFontSize";
Debug.ShouldStop(16777216);
_sale1.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 378;BA.debugLine="sale1.Gravity = Gravity.CENTER";
Debug.ShouldStop(33554432);
_sale1.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 379;BA.debugLine="sale1.Typeface = Typeface.SERIF";
Debug.ShouldStop(67108864);
_sale1.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 380;BA.debugLine="Panel.AddView(sale1, 0, purchase3Title.Heig";
Debug.ShouldStop(134217728);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase3title.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 382;BA.debugLine="Dim sale1Title As Label";
Debug.ShouldStop(536870912);
_sale1title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale1Title", _sale1title);
 BA.debugLineNum = 383;BA.debugLine="sale1Title.Initialize(\"\")";
Debug.ShouldStop(1073741824);
_sale1title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 384;BA.debugLine="sale1Title.Text = \"First Sale\"";
Debug.ShouldStop(-2147483648);
_sale1title.runMethod(true,"setText",BA.ObjectToCharSequence("First Sale"));
 BA.debugLineNum = 385;BA.debugLine="sale1Title.TextColor = Colors.Gray";
Debug.ShouldStop(1);
_sale1title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 386;BA.debugLine="sale1Title.TextSize = secondaryFontSize";
Debug.ShouldStop(2);
_sale1title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 387;BA.debugLine="sale1Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(4);
_sale1title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 388;BA.debugLine="sale1Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(8);
_sale1title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 389;BA.debugLine="sale1Title.Text = sale1Title.Text.ToUpperCa";
Debug.ShouldStop(16);
_sale1title.runMethod(true,"setText",BA.ObjectToCharSequence(_sale1title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 390;BA.debugLine="Panel.AddView(sale1Title, 0, sale1.top + pa";
Debug.ShouldStop(32);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale1title.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_sale1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 392;BA.debugLine="Dim sale2 As Label";
Debug.ShouldStop(128);
_sale2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale2", _sale2);
 BA.debugLineNum = 393;BA.debugLine="sale2.Initialize(\"\")";
Debug.ShouldStop(256);
_sale2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 394;BA.debugLine="sale2.Text = totalSales2";
Debug.ShouldStop(512);
_sale2.runMethod(true,"setText",BA.ObjectToCharSequence(_totalsales2));
 BA.debugLineNum = 395;BA.debugLine="sale2.TextColor = Colors.Black";
Debug.ShouldStop(1024);
_sale2.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 396;BA.debugLine="sale2.TextSize = primaryFontSize";
Debug.ShouldStop(2048);
_sale2.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 397;BA.debugLine="sale2.Gravity = Gravity.CENTER";
Debug.ShouldStop(4096);
_sale2.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 398;BA.debugLine="sale2.Typeface = Typeface.SERIF";
Debug.ShouldStop(8192);
_sale2.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 399;BA.debugLine="Panel.AddView(sale2, panelWidth, purchase3T";
Debug.ShouldStop(16384);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale2.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase3title.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 401;BA.debugLine="Dim sale2Title As Label";
Debug.ShouldStop(65536);
_sale2title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale2Title", _sale2title);
 BA.debugLineNum = 402;BA.debugLine="sale2Title.Initialize(\"\")";
Debug.ShouldStop(131072);
_sale2title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 403;BA.debugLine="sale2Title.Text = \" Second Sale\"";
Debug.ShouldStop(262144);
_sale2title.runMethod(true,"setText",BA.ObjectToCharSequence(" Second Sale"));
 BA.debugLineNum = 404;BA.debugLine="sale2Title.TextColor = Colors.Gray";
Debug.ShouldStop(524288);
_sale2title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 405;BA.debugLine="sale2Title.TextSize = secondaryFontSize";
Debug.ShouldStop(1048576);
_sale2title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 406;BA.debugLine="sale2Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(2097152);
_sale2title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 407;BA.debugLine="sale2Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(4194304);
_sale2title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 408;BA.debugLine="sale2Title.Text = sale2Title.Text.ToUpperCa";
Debug.ShouldStop(8388608);
_sale2title.runMethod(true,"setText",BA.ObjectToCharSequence(_sale2title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 409;BA.debugLine="Panel.AddView(sale2Title, panelWidth, sale2";
Debug.ShouldStop(16777216);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale2title.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_sale2.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 411;BA.debugLine="Dim sale3 As Label";
Debug.ShouldStop(67108864);
_sale3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale3", _sale3);
 BA.debugLineNum = 412;BA.debugLine="sale3.Initialize(\"\")";
Debug.ShouldStop(134217728);
_sale3.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 413;BA.debugLine="sale3.Text = totalSales3";
Debug.ShouldStop(268435456);
_sale3.runMethod(true,"setText",BA.ObjectToCharSequence(_totalsales3));
 BA.debugLineNum = 414;BA.debugLine="sale3.TextColor = Colors.Black";
Debug.ShouldStop(536870912);
_sale3.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 415;BA.debugLine="sale3.TextSize = primaryFontSize";
Debug.ShouldStop(1073741824);
_sale3.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 416;BA.debugLine="sale3.Gravity = Gravity.CENTER";
Debug.ShouldStop(-2147483648);
_sale3.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 417;BA.debugLine="sale3.Typeface = Typeface.SERIF";
Debug.ShouldStop(1);
_sale3.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 418;BA.debugLine="Panel.AddView(sale3, panelWidth * 2, sale2T";
Debug.ShouldStop(2);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale3.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_sale2title.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 420;BA.debugLine="Dim sale3Title As Label";
Debug.ShouldStop(8);
_sale3title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale3Title", _sale3title);
 BA.debugLineNum = 421;BA.debugLine="sale3Title.Initialize(\"\")";
Debug.ShouldStop(16);
_sale3title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 422;BA.debugLine="sale3Title.Text = \" Third Sale\"";
Debug.ShouldStop(32);
_sale3title.runMethod(true,"setText",BA.ObjectToCharSequence(" Third Sale"));
 BA.debugLineNum = 423;BA.debugLine="sale3Title.TextColor = Colors.Gray";
Debug.ShouldStop(64);
_sale3title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 424;BA.debugLine="sale3Title.TextSize = secondaryFontSize";
Debug.ShouldStop(128);
_sale3title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 425;BA.debugLine="sale3Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(256);
_sale3title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 426;BA.debugLine="sale3Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(512);
_sale3title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 427;BA.debugLine="sale3Title.Text = sale3Title.Text.ToUpperCa";
Debug.ShouldStop(1024);
_sale3title.runMethod(true,"setText",BA.ObjectToCharSequence(_sale3title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 428;BA.debugLine="Panel.AddView(sale3Title, panelWidth * 2, s";
Debug.ShouldStop(2048);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale3title.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_sale1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 430;BA.debugLine="panelWidth = Panel.Width / 2";
Debug.ShouldStop(8192);
_panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 433;BA.debugLine="totalTarget.Initialize(\"totalTarget\")";
Debug.ShouldStop(65536);
branch.mostCurrent._totaltarget.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("totalTarget")));
 BA.debugLineNum = 434;BA.debugLine="totalTarget.Text = total_count";
Debug.ShouldStop(131072);
branch.mostCurrent._totaltarget.runMethod(true,"setText",BA.ObjectToCharSequence(_total_count));
 BA.debugLineNum = 435;BA.debugLine="totalTarget.Tag = target_id";
Debug.ShouldStop(262144);
branch.mostCurrent._totaltarget.runMethod(false,"setTag",(_target_id));
 BA.debugLineNum = 436;BA.debugLine="totalTarget.TextColor = Colors.Black";
Debug.ShouldStop(524288);
branch.mostCurrent._totaltarget.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 437;BA.debugLine="totalTarget.Color = Colors.White";
Debug.ShouldStop(1048576);
branch.mostCurrent._totaltarget.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 438;BA.debugLine="totalTarget.TextSize = primaryFontSize";
Debug.ShouldStop(2097152);
branch.mostCurrent._totaltarget.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 439;BA.debugLine="totalTarget.Gravity = Gravity.CENTER";
Debug.ShouldStop(4194304);
branch.mostCurrent._totaltarget.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 440;BA.debugLine="totalTarget.Typeface = Typeface.SERIF";
Debug.ShouldStop(8388608);
branch.mostCurrent._totaltarget.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 441;BA.debugLine="Panel.AddView(totalTarget, 2dip, sale3Title";
Debug.ShouldStop(16777216);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((branch.mostCurrent._totaltarget.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(RemoteObject.solve(new RemoteObject[] {_sale3title.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 160)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 443;BA.debugLine="Dim totalTargetTitle As Label";
Debug.ShouldStop(67108864);
_totaltargettitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalTargetTitle", _totaltargettitle);
 BA.debugLineNum = 444;BA.debugLine="totalTargetTitle.Initialize(\"totalTargetTit";
Debug.ShouldStop(134217728);
_totaltargettitle.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("totalTargetTitles")));
 BA.debugLineNum = 445;BA.debugLine="totalTargetTitle.Text = \" Total Target\"";
Debug.ShouldStop(268435456);
_totaltargettitle.runMethod(true,"setText",BA.ObjectToCharSequence(" Total Target"));
 BA.debugLineNum = 446;BA.debugLine="totalTargetTitle.Tag = 20";
Debug.ShouldStop(536870912);
_totaltargettitle.runMethod(false,"setTag",RemoteObject.createImmutable((20)));
 BA.debugLineNum = 447;BA.debugLine="totalTargetTitle.TextColor = Colors.Gray";
Debug.ShouldStop(1073741824);
_totaltargettitle.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 448;BA.debugLine="totalTargetTitle.TextSize = secondaryFontSi";
Debug.ShouldStop(-2147483648);
_totaltargettitle.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 449;BA.debugLine="totalTargetTitle.Gravity = Gravity.CENTER";
Debug.ShouldStop(1);
_totaltargettitle.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 450;BA.debugLine="totalTargetTitle.Typeface = Typeface.MONOSP";
Debug.ShouldStop(2);
_totaltargettitle.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 451;BA.debugLine="totalTargetTitle.Text = totalTargetTitle.Te";
Debug.ShouldStop(4);
_totaltargettitle.runMethod(true,"setText",BA.ObjectToCharSequence(_totaltargettitle.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 452;BA.debugLine="Panel.AddView(totalTargetTitle, 0, totalTar";
Debug.ShouldStop(8);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_totaltargettitle.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._totaltarget.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 454;BA.debugLine="Dim totalPos As Label";
Debug.ShouldStop(32);
_totalpos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPos", _totalpos);
 BA.debugLineNum = 455;BA.debugLine="totalPos.Initialize(\"\")";
Debug.ShouldStop(64);
_totalpos.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 456;BA.debugLine="totalPos.Text = total_pos";
Debug.ShouldStop(128);
_totalpos.runMethod(true,"setText",BA.ObjectToCharSequence(_total_pos));
 BA.debugLineNum = 457;BA.debugLine="totalPos.TextColor = Colors.Black";
Debug.ShouldStop(256);
_totalpos.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 458;BA.debugLine="totalPos.TextSize = primaryFontSize";
Debug.ShouldStop(512);
_totalpos.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 459;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
Debug.ShouldStop(1024);
_totalpos.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 460;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
Debug.ShouldStop(2048);
_totalpos.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 461;BA.debugLine="Panel.AddView(totalPos, panelWidth, totalTa";
Debug.ShouldStop(4096);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_totalpos.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_totaltargettitle.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 160)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 465;BA.debugLine="Dim totalPosTitle As Label";
Debug.ShouldStop(65536);
_totalpostitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPosTitle", _totalpostitle);
 BA.debugLineNum = 466;BA.debugLine="totalPosTitle.Initialize(\"\")";
Debug.ShouldStop(131072);
_totalpostitle.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 467;BA.debugLine="totalPosTitle.Text = \" Total Pos\"";
Debug.ShouldStop(262144);
_totalpostitle.runMethod(true,"setText",BA.ObjectToCharSequence(" Total Pos"));
 BA.debugLineNum = 468;BA.debugLine="totalPosTitle.TextColor = Colors.Gray";
Debug.ShouldStop(524288);
_totalpostitle.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 469;BA.debugLine="totalPosTitle.TextSize = secondaryFontSize";
Debug.ShouldStop(1048576);
_totalpostitle.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 470;BA.debugLine="totalPosTitle.Gravity = Gravity.CENTER";
Debug.ShouldStop(2097152);
_totalpostitle.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 471;BA.debugLine="totalPosTitle.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(4194304);
_totalpostitle.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 472;BA.debugLine="totalPosTitle.Text = totalPosTitle.Text.ToU";
Debug.ShouldStop(8388608);
_totalpostitle.runMethod(true,"setText",BA.ObjectToCharSequence(_totalpostitle.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 473;BA.debugLine="Panel.AddView(totalPosTitle, panelWidth, to";
Debug.ShouldStop(16777216);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_totalpostitle.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_totalpos.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 475;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(67108864);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 476;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 2dip, Co";
Debug.ShouldStop(134217728);
_cd.runVoidMethod ("Initialize2",(Object)(branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 156)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 477;BA.debugLine="Panel.Background = cd";
Debug.ShouldStop(268435456);
branch.mostCurrent._panel.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 481;BA.debugLine="If Activity.Width >= 1340 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("g",branch.mostCurrent._activity.runMethod(true,"getWidth"),BA.numberCast(double.class, 1340))) { 
 BA.debugLineNum = 482;BA.debugLine="count = count + 1";
Debug.ShouldStop(2);
_count = RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("count", _count);
 BA.debugLineNum = 483;BA.debugLine="If count Mod numColumns = 0 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {_count,_numcolumns}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 484;BA.debugLine="leftPosition = 10dip";
Debug.ShouldStop(8);
_leftposition = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("leftPosition", _leftposition);
 BA.debugLineNum = 485;BA.debugLine="topPosition = topPosition + pnlHeight + p";
Debug.ShouldStop(16);
_topposition = RemoteObject.solve(new RemoteObject[] {_topposition,_pnlheight,_padding}, "++",2, 1);Debug.locals.put("topPosition", _topposition);
 }else {
 BA.debugLineNum = 487;BA.debugLine="leftPosition = leftPosition + pnlWidth +";
Debug.ShouldStop(64);
_leftposition = RemoteObject.solve(new RemoteObject[] {_leftposition,_pnlwidth,_padding}, "++",2, 1);Debug.locals.put("leftPosition", _leftposition);
 };
 BA.debugLineNum = 489;BA.debugLine="scrollHeight = scrollHeight + 175dip";
Debug.ShouldStop(256);
_scrollheight = RemoteObject.solve(new RemoteObject[] {_scrollheight,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 175)))}, "+",1, 1);Debug.locals.put("scrollHeight", _scrollheight);
 }else {
 BA.debugLineNum = 491;BA.debugLine="topPosition = topPosition + pnlHeight + pa";
Debug.ShouldStop(1024);
_topposition = RemoteObject.solve(new RemoteObject[] {_topposition,_pnlheight,_padding}, "++",2, 1);Debug.locals.put("topPosition", _topposition);
 BA.debugLineNum = 492;BA.debugLine="scrollHeight = scrollHeight + 290dip";
Debug.ShouldStop(2048);
_scrollheight = RemoteObject.solve(new RemoteObject[] {_scrollheight,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 290)))}, "+",1, 1);Debug.locals.put("scrollHeight", _scrollheight);
 };
 };
 }
}Debug.locals.put("record", _record);
;
 BA.debugLineNum = 497;BA.debugLine="scrollViewPanel4.Panel.Height = scrollHeight";
Debug.ShouldStop(65536);
branch.mostCurrent._scrollviewpanel4.runMethod(false,"getPanel").runMethod(true,"setHeight",_scrollheight);
 BA.debugLineNum = 498;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(131072);
branch.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 break; }
case 1: {
 BA.debugLineNum = 500;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
Debug.ShouldStop(524288);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Data updated successfully")),(Object)(branch.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 501;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(1048576);
_loadcompanydata();
 break; }
case 2: {
 BA.debugLineNum = 504;BA.debugLine="Dim salesArray As List = parser.NextArray";
Debug.ShouldStop(8388608);
_salesarray = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_salesarray = _parser.runMethod(false,"NextArray");Debug.locals.put("salesArray", _salesarray);Debug.locals.put("salesArray", _salesarray);
 BA.debugLineNum = 505;BA.debugLine="If salesArray.Size = 0 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_salesarray.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 506;BA.debugLine="Log(\"No branch data returned\")";
Debug.ShouldStop(33554432);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22228503",RemoteObject.createImmutable("No branch data returned"),0);
 BA.debugLineNum = 507;BA.debugLine="ToastMessageShow(\"No branch data available\",";
Debug.ShouldStop(67108864);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No branch data available")),(Object)(branch.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 508;BA.debugLine="Return";
Debug.ShouldStop(134217728);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 512;BA.debugLine="Dim totalBranches As Int = salesArray.Size";
Debug.ShouldStop(-2147483648);
_totalbranches = _salesarray.runMethod(true,"getSize");Debug.locals.put("totalBranches", _totalbranches);Debug.locals.put("totalBranches", _totalbranches);
 BA.debugLineNum = 513;BA.debugLine="Dim branchNames(totalBranches) As String";
Debug.ShouldStop(1);
_branchnames = RemoteObject.createNewArray ("String", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchNames", _branchnames);
 BA.debugLineNum = 514;BA.debugLine="Dim branchSales1(totalBranches) As Int";
Debug.ShouldStop(2);
_branchsales1 = RemoteObject.createNewArray ("int", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchSales1", _branchsales1);
 BA.debugLineNum = 515;BA.debugLine="Dim branchSales2(totalBranches) As Int";
Debug.ShouldStop(4);
_branchsales2 = RemoteObject.createNewArray ("int", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchSales2", _branchsales2);
 BA.debugLineNum = 516;BA.debugLine="Dim branchSales3(totalBranches) As Int";
Debug.ShouldStop(8);
_branchsales3 = RemoteObject.createNewArray ("int", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchSales3", _branchsales3);
 BA.debugLineNum = 517;BA.debugLine="Dim branchPurchase1(totalBranches) As Int";
Debug.ShouldStop(16);
_branchpurchase1 = RemoteObject.createNewArray ("int", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchPurchase1", _branchpurchase1);
 BA.debugLineNum = 518;BA.debugLine="Dim branchPurchase2(totalBranches) As Int";
Debug.ShouldStop(32);
_branchpurchase2 = RemoteObject.createNewArray ("int", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchPurchase2", _branchpurchase2);
 BA.debugLineNum = 519;BA.debugLine="Dim branchPurchase3(totalBranches) As Int";
Debug.ShouldStop(64);
_branchpurchase3 = RemoteObject.createNewArray ("int", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchPurchase3", _branchpurchase3);
 BA.debugLineNum = 520;BA.debugLine="Dim branchCount As Int = 0";
Debug.ShouldStop(128);
_branchcount = BA.numberCast(int.class, 0);Debug.locals.put("branchCount", _branchcount);Debug.locals.put("branchCount", _branchcount);
 BA.debugLineNum = 523;BA.debugLine="For i = 0 To totalBranches - 1";
Debug.ShouldStop(1024);
{
final int step256 = 1;
final int limit256 = RemoteObject.solve(new RemoteObject[] {_totalbranches,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step256 > 0 && _i <= limit256) || (step256 < 0 && _i >= limit256) ;_i = ((int)(0 + _i + step256))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 524;BA.debugLine="Dim record As Map = salesArray.Get(i)";
Debug.ShouldStop(2048);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _salesarray.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("record", _record);Debug.locals.put("record", _record);
 BA.debugLineNum = 525;BA.debugLine="branchNames(i) = record.GetDefault(\"branch_n";
Debug.ShouldStop(4096);
_branchnames.setArrayElement (BA.ObjectToString(_record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("branch_name"))),(Object)((RemoteObject.createImmutable("Unknown"))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 526;BA.debugLine="branchSales1(i) = record.GetDefault(\"sales_1";
Debug.ShouldStop(8192);
_branchsales1.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_1"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 527;BA.debugLine="branchSales2(i) = record.GetDefault(\"sales_2";
Debug.ShouldStop(16384);
_branchsales2.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_2"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 528;BA.debugLine="branchSales3(i) = record.GetDefault(\"sales_3";
Debug.ShouldStop(32768);
_branchsales3.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_3"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 529;BA.debugLine="branchCount = record.GetDefault(\"total_branc";
Debug.ShouldStop(65536);
_branchcount = BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("total_branch_count"))),(Object)(RemoteObject.createImmutable((0)))));Debug.locals.put("branchCount", _branchcount);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 531;BA.debugLine="Log($\"branchCount:${branchCount}\"$)";
Debug.ShouldStop(262144);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22228528",(RemoteObject.concat(RemoteObject.createImmutable("branchCount:"),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_branchcount))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 533;BA.debugLine="Dim legend() As String = Array As String(\"Sal";
Debug.ShouldStop(1048576);
_legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Sales 1"),BA.ObjectToString("Sales 2"),RemoteObject.createImmutable("Sales 3")});Debug.locals.put("legend", _legend);Debug.locals.put("legend", _legend);
 BA.debugLineNum = 536;BA.debugLine="purchasePanel.RemoveAllViews";
Debug.ShouldStop(8388608);
branch.mostCurrent._purchasepanel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 539;BA.debugLine="If barGraphInitialized = False Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",branch._bargraphinitialized,branch.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 540;BA.debugLine="nxtBtn.Initialize(\"nxtBtn\")";
Debug.ShouldStop(134217728);
branch.mostCurrent._nxtbtn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("nxtBtn")));
 BA.debugLineNum = 541;BA.debugLine="backbtn.Initialize(\"backbtn\")";
Debug.ShouldStop(268435456);
branch.mostCurrent._backbtn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("backbtn")));
 BA.debugLineNum = 542;BA.debugLine="sortBtn1.Initialize(\"sortBtn1\")";
Debug.ShouldStop(536870912);
branch.mostCurrent._sortbtn1.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtn1")));
 BA.debugLineNum = 543;BA.debugLine="sortBtn2.Initialize(\"sortBtn2\")";
Debug.ShouldStop(1073741824);
branch.mostCurrent._sortbtn2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtn2")));
 BA.debugLineNum = 544;BA.debugLine="defBtn.Initialize(\"defBtn\")";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._defbtn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("defBtn")));
 BA.debugLineNum = 545;BA.debugLine="salesBtn1.Initialize(\"salesBtn1\")";
Debug.ShouldStop(1);
branch.mostCurrent._salesbtn1.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("salesBtn1")));
 BA.debugLineNum = 546;BA.debugLine="salesBtn2.Initialize(\"salesBtn2\")";
Debug.ShouldStop(2);
branch.mostCurrent._salesbtn2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("salesBtn2")));
 BA.debugLineNum = 547;BA.debugLine="salesBtn3.Initialize(\"salesBtn3\")";
Debug.ShouldStop(4);
branch.mostCurrent._salesbtn3.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("salesBtn3")));
 BA.debugLineNum = 548;BA.debugLine="showHideBtn.Initialize(\"showHideBtn\")";
Debug.ShouldStop(8);
branch.mostCurrent._showhidebtn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("showHideBtn")));
 BA.debugLineNum = 549;BA.debugLine="barGraph.Initialize(Activity, purchasePanel,";
Debug.ShouldStop(16);
branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_initialize" /*RemoteObject*/ ,branch.mostCurrent.activityBA,(Object)(branch.mostCurrent._activity),(Object)(branch.mostCurrent._purchasepanel),(Object)(_branchsales1),(Object)(_branchsales2),(Object)(_branchsales3),(Object)(_branchnames),(Object)(_legend),(Object)(BA.numberCast(int.class, 10000)),(Object)(BA.ObjectToString("Sales Per Branch")),(Object)(_branchsales1),(Object)(BA.ObjectToString("Branch")),(Object)(branch.mostCurrent._nxtbtn),(Object)(branch.mostCurrent._backbtn),(Object)(branch.mostCurrent._sortbtn1),(Object)(branch.mostCurrent._sortbtn2),(Object)(branch.mostCurrent._defbtn),(Object)(branch.mostCurrent._salesbtn1),(Object)(branch.mostCurrent._salesbtn2),(Object)(branch.mostCurrent._salesbtn3),(Object)(branch.mostCurrent._showhidebtn));
 BA.debugLineNum = 550;BA.debugLine="barGraph.totalPages = branchCount / 5";
Debug.ShouldStop(32);
branch.mostCurrent._bargraph.setField ("_totalpages" /*RemoteObject*/ ,BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_branchcount,RemoteObject.createImmutable(5)}, "/",0, 0)));
 BA.debugLineNum = 551;BA.debugLine="barGraph.UpdateGraph";
Debug.ShouldStop(64);
branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_updategraph" /*RemoteObject*/ );
 BA.debugLineNum = 552;BA.debugLine="barGraphInitialized = True";
Debug.ShouldStop(128);
branch._bargraphinitialized = branch.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 553;BA.debugLine="Log(\"Bar graph initialized\")";
Debug.ShouldStop(256);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22228550",RemoteObject.createImmutable("Bar graph initialized"),0);
 BA.debugLineNum = 554;BA.debugLine="salesData1 = 1";
Debug.ShouldStop(512);
branch._salesdata1 = BA.numberCast(int.class, 1);
 }else {
 BA.debugLineNum = 557;BA.debugLine="barGraph.pageNo = currentPage";
Debug.ShouldStop(4096);
branch.mostCurrent._bargraph.setField ("_pageno" /*RemoteObject*/ ,branch._currentpage);
 BA.debugLineNum = 558;BA.debugLine="barGraph.sale_1 = branchSales1";
Debug.ShouldStop(8192);
branch.mostCurrent._bargraph.setField ("_sale_1" /*RemoteObject*/ ,_branchsales1);
 BA.debugLineNum = 559;BA.debugLine="barGraph.sale_2 = branchSales2";
Debug.ShouldStop(16384);
branch.mostCurrent._bargraph.setField ("_sale_2" /*RemoteObject*/ ,_branchsales2);
 BA.debugLineNum = 560;BA.debugLine="barGraph.sale_3 = branchSales3";
Debug.ShouldStop(32768);
branch.mostCurrent._bargraph.setField ("_sale_3" /*RemoteObject*/ ,_branchsales3);
 BA.debugLineNum = 561;BA.debugLine="barGraph.product1 = branchNames";
Debug.ShouldStop(65536);
branch.mostCurrent._bargraph.setField ("_product1" /*RemoteObject*/ ,_branchnames);
 BA.debugLineNum = 562;BA.debugLine="barGraph.comId1 = branchSales1 ' Assuming th";
Debug.ShouldStop(131072);
branch.mostCurrent._bargraph.setField ("_comid1" /*RemoteObject*/ ,_branchsales1);
 BA.debugLineNum = 564;BA.debugLine="barGraph.UpdateGraph";
Debug.ShouldStop(524288);
branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_updategraph" /*RemoteObject*/ );
 BA.debugLineNum = 565;BA.debugLine="Log(\"Bar graph updated\")";
Debug.ShouldStop(1048576);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22228562",RemoteObject.createImmutable("Bar graph updated"),0);
 };
 BA.debugLineNum = 636;BA.debugLine="backbtn.Enabled = currentPage > 1";
Debug.ShouldStop(134217728);
branch.mostCurrent._backbtn.runMethod(true,"setEnabled",BA.ObjectToBoolean(RemoteObject.solveBoolean(">",branch._currentpage,BA.numberCast(double.class, 1))));
 BA.debugLineNum = 637;BA.debugLine="nxtBtn.Enabled = salesArray.Size > 0 ' Adjust";
Debug.ShouldStop(268435456);
branch.mostCurrent._nxtbtn.runMethod(true,"setEnabled",BA.ObjectToBoolean(RemoteObject.solveBoolean(">",_salesarray.runMethod(true,"getSize"),BA.numberCast(double.class, 0))));
 break; }
case 3: {
 BA.debugLineNum = 640;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
Debug.ShouldStop(-2147483648);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Data updated successfully")),(Object)(branch.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 641;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(1);
_loadcompanydata();
 break; }
default: {
 BA.debugLineNum = 644;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
Debug.ShouldStop(8);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22228641",RemoteObject.concat(RemoteObject.createImmutable("Unknown job: "),_job.getField(true,"_jobname" /*RemoteObject*/ )),0);
 break; }
}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e302) {
			BA.rdebugUtils.runVoidMethod("setLastException",branch.processBA, e302.toString()); BA.debugLineNum = 648;BA.debugLine="Log(\"Error parsing data: \" & LastException.Mess";
Debug.ShouldStop(128);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22228645",RemoteObject.concat(RemoteObject.createImmutable("Error parsing data: "),branch.mostCurrent.__c.runMethod(false,"LastException",branch.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 BA.debugLineNum = 649;BA.debugLine="ToastMessageShow(\"Error parsing graph data\", Tr";
Debug.ShouldStop(256);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Error parsing graph data")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 652;BA.debugLine="Log(\"Job failed: \" & job.ErrorMessage)";
Debug.ShouldStop(2048);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22228649",RemoteObject.concat(RemoteObject.createImmutable("Job failed: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )),0);
 BA.debugLineNum = 653;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
Debug.ShouldStop(4096);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 656;BA.debugLine="job.Release";
Debug.ShouldStop(32768);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 657;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Label17_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,705);
if (RapidSub.canDelegate("label17_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","label17_click");}
RemoteObject _clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _selectedcompany = RemoteObject.createImmutable("");
 BA.debugLineNum = 705;BA.debugLine="Private Sub Label17_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 706;BA.debugLine="Dim clickedLabel As Label = Sender";
Debug.ShouldStop(2);
_clickedlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("clickedLabel", _clickedlabel);Debug.locals.put("clickedLabel", _clickedlabel);
 BA.debugLineNum = 707;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
Debug.ShouldStop(4);
_selectedcompany = BA.ObjectToString(_clickedlabel.runMethod(false,"getTag"));Debug.locals.put("selectedCompany", _selectedcompany);Debug.locals.put("selectedCompany", _selectedcompany);
 BA.debugLineNum = 708;BA.debugLine="branch_selected = selectedCompany";
Debug.ShouldStop(8);
branch._branch_selected = _selectedcompany;
 BA.debugLineNum = 709;BA.debugLine="Log(branch_selected&\"this is device\")";
Debug.ShouldStop(16);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22686980",RemoteObject.concat(branch._branch_selected,RemoteObject.createImmutable("this is device")),0);
 BA.debugLineNum = 710;BA.debugLine="StartActivity(\"Device\")";
Debug.ShouldStop(32);
branch.mostCurrent.__c.runVoidMethod ("StartActivity",branch.processBA,(Object)((RemoteObject.createImmutable("Device"))));
 BA.debugLineNum = 711;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("LoadCompanyData (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,209);
if (RapidSub.canDelegate("loadcompanydata")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","loadcompanydata");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 209;BA.debugLine="Sub LoadCompanyData";
Debug.ShouldStop(65536);
 BA.debugLineNum = 210;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(131072);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 211;BA.debugLine="totalTarget.Initialize(\"\")";
Debug.ShouldStop(262144);
branch.mostCurrent._totaltarget.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 212;BA.debugLine="totalTarget.RemoveView";
Debug.ShouldStop(524288);
branch.mostCurrent._totaltarget.runVoidMethod ("RemoveView");
 BA.debugLineNum = 213;BA.debugLine="PHPURL = $\"https://192.168.8.117/Company/controll";
Debug.ShouldStop(1048576);
branch.mostCurrent._phpurl = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._starter._company_selected /*RemoteObject*/ ))),RemoteObject.createImmutable("&page="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._currentpage))),RemoteObject.createImmutable("&branch_sales="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._salesdata1))),RemoteObject.createImmutable("&sort_type="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable("")));
 BA.debugLineNum = 214;BA.debugLine="Log($\"Fetching panel data for company ID: ${Start";
Debug.ShouldStop(2097152);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22097157",(RemoteObject.concat(RemoteObject.createImmutable("Fetching panel data for company ID: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._starter._company_selected /*RemoteObject*/ ))),RemoteObject.createImmutable(", page: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._currentpage))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 215;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
Debug.ShouldStop(4194304);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,branch.processBA,(Object)(BA.ObjectToString("GetData")),(Object)(branch.getObject()));
 BA.debugLineNum = 217;BA.debugLine="Job1.Download(PHPURL)";
Debug.ShouldStop(16777216);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(branch.mostCurrent._phpurl));
 BA.debugLineNum = 218;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadcompanydatabranchgraphpurchase() throws Exception{
try {
		Debug.PushSubsStack("LoadCompanyDataBranchGraphPurchase (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,194);
if (RapidSub.canDelegate("loadcompanydatabranchgraphpurchase")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","loadcompanydatabranchgraphpurchase");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 194;BA.debugLine="Sub LoadCompanyDataBranchGraphPurchase";
Debug.ShouldStop(2);
 BA.debugLineNum = 195;BA.debugLine="Try";
Debug.ShouldStop(4);
try { BA.debugLineNum = 196;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(8);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 197;BA.debugLine="Job1.Initialize(\"GetBranchesPurchase\", Me)";
Debug.ShouldStop(16);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,branch.processBA,(Object)(BA.ObjectToString("GetBranchesPurchase")),(Object)(branch.getObject()));
 BA.debugLineNum = 198;BA.debugLine="PHPURL1 = $\"https://192.168.8.117/Company/contro";
Debug.ShouldStop(32);
branch.mostCurrent._phpurl1 = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._starter._company_selected /*RemoteObject*/ ))),RemoteObject.createImmutable("&page="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._currentpage))),RemoteObject.createImmutable("&branch_purchase="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._salesdata1))),RemoteObject.createImmutable("&sort_type="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable("")));
 BA.debugLineNum = 199;BA.debugLine="Log(Starter.company_selected & \"isd\")";
Debug.ShouldStop(64);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22031621",RemoteObject.concat(branch.mostCurrent._starter._company_selected /*RemoteObject*/ ,RemoteObject.createImmutable("isd")),0);
 BA.debugLineNum = 200;BA.debugLine="Job1.Download(PHPURL1)";
Debug.ShouldStop(128);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(branch.mostCurrent._phpurl1));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",branch.processBA, e8.toString()); BA.debugLineNum = 204;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(2048);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22031626",branch.mostCurrent.__c.runMethod(false,"LastException",branch.mostCurrent.activityBA).runMethod(true,"getMessage"),0);
 };
 BA.debugLineNum = 206;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadcompanydatabranchgraphsales() throws Exception{
try {
		Debug.PushSubsStack("LoadCompanyDataBranchGraphSales (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,180);
if (RapidSub.canDelegate("loadcompanydatabranchgraphsales")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","loadcompanydatabranchgraphsales");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 180;BA.debugLine="Sub LoadCompanyDataBranchGraphSales";
Debug.ShouldStop(524288);
 BA.debugLineNum = 181;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 182;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(2097152);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 183;BA.debugLine="Job1.Initialize(\"GetBranches\", Me)";
Debug.ShouldStop(4194304);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,branch.processBA,(Object)(BA.ObjectToString("GetBranches")),(Object)(branch.getObject()));
 BA.debugLineNum = 184;BA.debugLine="PHPURL1 = $\"https://192.168.8.117/Company/contro";
Debug.ShouldStop(8388608);
branch.mostCurrent._phpurl1 = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._starter._company_selected /*RemoteObject*/ ))),RemoteObject.createImmutable("&page="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._currentpage))),RemoteObject.createImmutable("&branch_sales="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._salesdata1))),RemoteObject.createImmutable("&sort_type="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable("")));
 BA.debugLineNum = 185;BA.debugLine="Log(Starter.company_selected & \"isd\")";
Debug.ShouldStop(16777216);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","21966085",RemoteObject.concat(branch.mostCurrent._starter._company_selected /*RemoteObject*/ ,RemoteObject.createImmutable("isd")),0);
 BA.debugLineNum = 186;BA.debugLine="Job1.Download(PHPURL1)";
Debug.ShouldStop(33554432);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(branch.mostCurrent._phpurl1));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",branch.processBA, e8.toString()); BA.debugLineNum = 190;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(536870912);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","21966090",branch.mostCurrent.__c.runMethod(false,"LastException",branch.mostCurrent.activityBA).runMethod(true,"getMessage"),0);
 };
 BA.debugLineNum = 192;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("nxtBtn_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,713);
if (RapidSub.canDelegate("nxtbtn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","nxtbtn_click");}
 BA.debugLineNum = 713;BA.debugLine="Sub nxtBtn_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 714;BA.debugLine="currentPage = currentPage + 1";
Debug.ShouldStop(512);
branch._currentpage = RemoteObject.solve(new RemoteObject[] {branch._currentpage,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 715;BA.debugLine="Log($\"Next page: ${currentPage}\"$)";
Debug.ShouldStop(1024);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22752514",(RemoteObject.concat(RemoteObject.createImmutable("Next page: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._currentpage))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 716;BA.debugLine="LoadCompanyDataBranchGraphSales ' Updates graph";
Debug.ShouldStop(2048);
_loadcompanydatabranchgraphsales();
 BA.debugLineNum = 717;BA.debugLine="LoadCompanyData ' Updates panels";
Debug.ShouldStop(4096);
_loadcompanydata();
 BA.debugLineNum = 718;BA.debugLine="ProgressDialogShow(\"Loading Graph Data...\")";
Debug.ShouldStop(8192);
branch.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",branch.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Graph Data..."))));
 BA.debugLineNum = 719;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
 //BA.debugLineNum = 7;BA.debugLine="Private xui As XUI";
branch._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 8;BA.debugLine="Public company_name As String";
branch._company_name = RemoteObject.createImmutable("");
 //BA.debugLineNum = 9;BA.debugLine="Public branch_selected As String";
branch._branch_selected = RemoteObject.createImmutable("");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _responsivelabel(RemoteObject _label) throws Exception{
try {
		Debug.PushSubsStack("responsiveLabel (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,691);
if (RapidSub.canDelegate("responsivelabel")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","responsivelabel", _label);}
RemoteObject _charwidth = RemoteObject.createImmutable(0);
RemoteObject _padding = RemoteObject.createImmutable(0);
RemoteObject _homewidth = RemoteObject.createImmutable(0);
Debug.locals.put("label", _label);
 BA.debugLineNum = 691;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
Debug.ShouldStop(262144);
 BA.debugLineNum = 692;BA.debugLine="Dim charWidth As Int = 10dip";
Debug.ShouldStop(524288);
_charwidth = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("charWidth", _charwidth);Debug.locals.put("charWidth", _charwidth);
 BA.debugLineNum = 693;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(1048576);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 694;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
Debug.ShouldStop(2097152);
_homewidth = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_label.runMethod(true,"getText").runMethod(true,"length"),_charwidth}, "*",0, 1)),_padding}, "+",1, 1);Debug.locals.put("homeWidth", _homewidth);Debug.locals.put("homeWidth", _homewidth);
 BA.debugLineNum = 695;BA.debugLine="Return homeWidth";
Debug.ShouldStop(4194304);
if (true) return _homewidth;
 BA.debugLineNum = 696;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("salesBtn1_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,836);
if (RapidSub.canDelegate("salesbtn1_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","salesbtn1_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
RemoteObject _checkedsales = null;
 BA.debugLineNum = 836;BA.debugLine="Sub salesBtn1_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 837;BA.debugLine="Dim btn As RadioButton = Sender";
Debug.ShouldStop(16);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 838;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(32);
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 839;BA.debugLine="Dim checkedSales() As Boolean = barGraph.GetCheck";
Debug.ShouldStop(64);
_checkedsales = branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 841;BA.debugLine="salesData1 = 1 ' Set directly instead of using in";
Debug.ShouldStop(256);
branch._salesdata1 = BA.numberCast(int.class, 1);
 BA.debugLineNum = 842;BA.debugLine="Log(\"Sales 1 selected\")";
Debug.ShouldStop(512);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23080198",RemoteObject.createImmutable("Sales 1 selected"),0);
 BA.debugLineNum = 845;BA.debugLine="If Not(barGraphInitialized) Then";
Debug.ShouldStop(4096);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(branch._bargraphinitialized)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 846;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
Debug.ShouldStop(8192);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Graph not yet initialized.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 847;BA.debugLine="Return";
Debug.ShouldStop(16384);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 851;BA.debugLine="If checkedSales.Length = 0 Or Not(checkedSales(0)";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean(".",branch.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 0)))))) { 
 BA.debugLineNum = 852;BA.debugLine="ToastMessageShow(\"Please show Sales1 in the lege";
Debug.ShouldStop(524288);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales1 in the legend before sorting by it.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 853;BA.debugLine="Return";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 857;BA.debugLine="If sortDefaultValue = \"asc\" Or sortDefaultValue =";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 858;BA.debugLine="LoadCompanyDataBranchGraphSales";
Debug.ShouldStop(33554432);
_loadcompanydatabranchgraphsales();
 };
 BA.debugLineNum = 861;BA.debugLine="Log(\"salesBtn1_Click executed with sortDefaultVal";
Debug.ShouldStop(268435456);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23080217",RemoteObject.concat(RemoteObject.createImmutable("salesBtn1_Click executed with sortDefaultValue: "),branch.mostCurrent._sortdefaultvalue),0);
 BA.debugLineNum = 862;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("salesBtn2_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,864);
if (RapidSub.canDelegate("salesbtn2_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","salesbtn2_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
RemoteObject _checkedsales = null;
 BA.debugLineNum = 864;BA.debugLine="Sub salesBtn2_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 865;BA.debugLine="Dim btn As Button = Sender";
Debug.ShouldStop(1);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 866;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(2);
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 867;BA.debugLine="Dim checkedSales() As Boolean = barGraph.GetCheck";
Debug.ShouldStop(4);
_checkedsales = branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 869;BA.debugLine="salesData1 = index.ToLowerCase";
Debug.ShouldStop(16);
branch._salesdata1 = BA.numberCast(int.class, _index.runMethod(true,"toLowerCase"));
 BA.debugLineNum = 870;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 871;BA.debugLine="LoadCompanyDataBranchGraphSales";
Debug.ShouldStop(64);
_loadcompanydatabranchgraphsales();
 };
 BA.debugLineNum = 874;BA.debugLine="If checkedSales.Length > 0 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean(">",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 875;BA.debugLine="Select Case salesData1";
Debug.ShouldStop(1024);
switch (BA.switchObjectToInt(branch._salesdata1,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 877;BA.debugLine="If Not(checkedSales(0)) Then";
Debug.ShouldStop(4096);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 0)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 878;BA.debugLine="ToastMessageShow(\"Please show Sales1 in the l";
Debug.ShouldStop(8192);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales1 in the legend before sorting by it.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 879;BA.debugLine="Return";
Debug.ShouldStop(16384);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 1: {
 BA.debugLineNum = 882;BA.debugLine="If Not(checkedSales(1)) Then";
Debug.ShouldStop(131072);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 1)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 883;BA.debugLine="ToastMessageShow(\"Please show Sales2 in the l";
Debug.ShouldStop(262144);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales2 in the legend before sorting by it.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 884;BA.debugLine="Return";
Debug.ShouldStop(524288);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 2: {
 BA.debugLineNum = 887;BA.debugLine="If Not(checkedSales(2)) Then";
Debug.ShouldStop(4194304);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 2)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 888;BA.debugLine="ToastMessageShow(\"Please show Sales3 in the l";
Debug.ShouldStop(8388608);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales3 in the legend before sorting by it.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 889;BA.debugLine="Return";
Debug.ShouldStop(16777216);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
}
;
 };
 BA.debugLineNum = 895;BA.debugLine="Log(sortDefaultValue)";
Debug.ShouldStop(1073741824);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23145759",branch.mostCurrent._sortdefaultvalue,0);
 BA.debugLineNum = 896;BA.debugLine="Log(\" sales 1 Button clicked: \" & index)";
Debug.ShouldStop(-2147483648);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23145760",RemoteObject.concat(RemoteObject.createImmutable(" sales 1 Button clicked: "),_index),0);
 BA.debugLineNum = 897;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _salesbtn3_click() throws Exception{
try {
		Debug.PushSubsStack("salesBtn3_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,898);
if (RapidSub.canDelegate("salesbtn3_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","salesbtn3_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
RemoteObject _checkedsales = null;
 BA.debugLineNum = 898;BA.debugLine="Sub salesBtn3_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 899;BA.debugLine="Dim btn As Button = Sender";
Debug.ShouldStop(4);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 900;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(8);
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 901;BA.debugLine="Dim checkedSales() As Boolean = barGraph.GetCheck";
Debug.ShouldStop(16);
_checkedsales = branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 903;BA.debugLine="salesData1 = index.ToLowerCase";
Debug.ShouldStop(64);
branch._salesdata1 = BA.numberCast(int.class, _index.runMethod(true,"toLowerCase"));
 BA.debugLineNum = 904;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 905;BA.debugLine="LoadCompanyDataBranchGraphSales";
Debug.ShouldStop(256);
_loadcompanydatabranchgraphsales();
 };
 BA.debugLineNum = 908;BA.debugLine="If checkedSales.Length > 0 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean(">",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 909;BA.debugLine="Select Case salesData1";
Debug.ShouldStop(4096);
switch (BA.switchObjectToInt(branch._salesdata1,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 911;BA.debugLine="If Not(checkedSales(0)) Then";
Debug.ShouldStop(16384);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 0)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 912;BA.debugLine="ToastMessageShow(\"Please show Sales1 in the l";
Debug.ShouldStop(32768);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales1 in the legend before sorting by it.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 913;BA.debugLine="Return";
Debug.ShouldStop(65536);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 1: {
 BA.debugLineNum = 916;BA.debugLine="If Not(checkedSales(1)) Then";
Debug.ShouldStop(524288);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 1)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 917;BA.debugLine="ToastMessageShow(\"Please show Sales2 in the l";
Debug.ShouldStop(1048576);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales2 in the legend before sorting by it.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 918;BA.debugLine="Return";
Debug.ShouldStop(2097152);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 2: {
 BA.debugLineNum = 921;BA.debugLine="If Not(checkedSales(2)) Then";
Debug.ShouldStop(16777216);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 2)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 922;BA.debugLine="ToastMessageShow(\"Please show Sales3 in the l";
Debug.ShouldStop(33554432);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales3 in the legend before sorting by it.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 923;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
}
;
 };
 BA.debugLineNum = 929;BA.debugLine="Log(sortDefaultValue)";
Debug.ShouldStop(1);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23211295",branch.mostCurrent._sortdefaultvalue,0);
 BA.debugLineNum = 930;BA.debugLine="Log(\" sales 1 Button clicked: \" & index)";
Debug.ShouldStop(2);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23211296",RemoteObject.concat(RemoteObject.createImmutable(" sales 1 Button clicked: "),_index),0);
 BA.debugLineNum = 931;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showhidebtn_click() throws Exception{
try {
		Debug.PushSubsStack("showHideBtn_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,934);
if (RapidSub.canDelegate("showhidebtn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","showhidebtn_click");}
 BA.debugLineNum = 934;BA.debugLine="Public Sub showHideBtn_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 936;BA.debugLine="If showHide = True Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",branch._showhide,branch.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 937;BA.debugLine="showHide = False";
Debug.ShouldStop(256);
branch._showhide = branch.mostCurrent.__c.getField(true,"False");
 }else {
 BA.debugLineNum = 939;BA.debugLine="showHide = True";
Debug.ShouldStop(1024);
branch._showhide = branch.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 941;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(4096);
_loadcompanydata();
 BA.debugLineNum = 942;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("sortBtn1_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,792);
if (RapidSub.canDelegate("sortbtn1_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","sortbtn1_click");}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
RemoteObject _checkedsales = null;
 BA.debugLineNum = 792;BA.debugLine="Sub sortBtn1_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 793;BA.debugLine="Dim chk As RadioButton = Sender";
Debug.ShouldStop(16777216);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 794;BA.debugLine="Dim index As String = chk.Tag";
Debug.ShouldStop(33554432);
_index = BA.ObjectToString(_chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 796;BA.debugLine="sortDefaultValue = index.ToLowerCase ' \"asc\"";
Debug.ShouldStop(134217728);
branch.mostCurrent._sortdefaultvalue = _index.runMethod(true,"toLowerCase");
 BA.debugLineNum = 797;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
Debug.ShouldStop(268435456);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23014661",(RemoteObject.concat(RemoteObject.createImmutable("sort value: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 800;BA.debugLine="If Not(barGraphInitialized) Then";
Debug.ShouldStop(-2147483648);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(branch._bargraphinitialized)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 801;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
Debug.ShouldStop(1);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Graph not yet initialized.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 802;BA.debugLine="Return";
Debug.ShouldStop(2);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 806;BA.debugLine="Dim checkedSales() As Boolean = barGraph.GetCheck";
Debug.ShouldStop(32);
_checkedsales = branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 807;BA.debugLine="If checkedSales.Length = 0 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 808;BA.debugLine="ToastMessageShow(\"No sales data available in leg";
Debug.ShouldStop(128);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No sales data available in legend.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 809;BA.debugLine="Return";
Debug.ShouldStop(256);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 813;BA.debugLine="Select Case salesData1";
Debug.ShouldStop(4096);
switch (BA.switchObjectToInt(branch._salesdata1,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 815;BA.debugLine="If Not(checkedSales(0)) Then";
Debug.ShouldStop(16384);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 0)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 816;BA.debugLine="ToastMessageShow(\"Please show Sales1 in the le";
Debug.ShouldStop(32768);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales1 in the legend before sorting by it.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 817;BA.debugLine="Return";
Debug.ShouldStop(65536);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 1: {
 BA.debugLineNum = 820;BA.debugLine="If Not(checkedSales(1)) Then";
Debug.ShouldStop(524288);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 1)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 821;BA.debugLine="ToastMessageShow(\"Please show Sales2 in the le";
Debug.ShouldStop(1048576);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales2 in the legend before sorting by it.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 822;BA.debugLine="Return";
Debug.ShouldStop(2097152);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 2: {
 BA.debugLineNum = 825;BA.debugLine="If Not(checkedSales(2)) Then";
Debug.ShouldStop(16777216);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 2)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 826;BA.debugLine="ToastMessageShow(\"Please show Sales3 in the le";
Debug.ShouldStop(33554432);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales3 in the legend before sorting by it.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 827;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
}
;
 BA.debugLineNum = 832;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(-2147483648);
_loadcompanydata();
 BA.debugLineNum = 833;BA.debugLine="LoadCompanyDataBranchGraphSales";
Debug.ShouldStop(1);
_loadcompanydatabranchgraphsales();
 BA.debugLineNum = 834;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("sortBtn2_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,746);
if (RapidSub.canDelegate("sortbtn2_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","sortbtn2_click");}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
RemoteObject _checkedsales = null;
 BA.debugLineNum = 746;BA.debugLine="Sub sortBtn2_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 747;BA.debugLine="Dim chk As RadioButton = Sender";
Debug.ShouldStop(1024);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 748;BA.debugLine="Dim index As String = chk.Tag";
Debug.ShouldStop(2048);
_index = BA.ObjectToString(_chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 750;BA.debugLine="sortDefaultValue = index.ToLowerCase ' \"desc\"";
Debug.ShouldStop(8192);
branch.mostCurrent._sortdefaultvalue = _index.runMethod(true,"toLowerCase");
 BA.debugLineNum = 751;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
Debug.ShouldStop(16384);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22949125",(RemoteObject.concat(RemoteObject.createImmutable("sort value: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 754;BA.debugLine="If Not(barGraphInitialized) Then";
Debug.ShouldStop(131072);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(branch._bargraphinitialized)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 755;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
Debug.ShouldStop(262144);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Graph not yet initialized.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 756;BA.debugLine="Return";
Debug.ShouldStop(524288);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 760;BA.debugLine="Dim checkedSales() As Boolean = barGraph.GetCheck";
Debug.ShouldStop(8388608);
_checkedsales = branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_getcheckedsales" /*RemoteObject*/ );Debug.locals.put("checkedSales", _checkedsales);Debug.locals.put("checkedSales", _checkedsales);
 BA.debugLineNum = 761;BA.debugLine="If checkedSales.Length = 0 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_checkedsales.getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 762;BA.debugLine="ToastMessageShow(\"No sales data available in leg";
Debug.ShouldStop(33554432);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No sales data available in legend.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 763;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 767;BA.debugLine="Select Case salesData1";
Debug.ShouldStop(1073741824);
switch (BA.switchObjectToInt(branch._salesdata1,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 769;BA.debugLine="If Not(checkedSales(0)) Then";
Debug.ShouldStop(1);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 0)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 770;BA.debugLine="ToastMessageShow(\"Please show Sales1 in the le";
Debug.ShouldStop(2);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales1 in the legend before sorting by it.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 771;BA.debugLine="Return";
Debug.ShouldStop(4);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 1: {
 BA.debugLineNum = 774;BA.debugLine="If Not(checkedSales(1)) Then";
Debug.ShouldStop(32);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 1)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 775;BA.debugLine="ToastMessageShow(\"Please show Sales2 in the le";
Debug.ShouldStop(64);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales2 in the legend before sorting by it.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 776;BA.debugLine="Return";
Debug.ShouldStop(128);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
case 2: {
 BA.debugLineNum = 779;BA.debugLine="If Not(checkedSales(2)) Then";
Debug.ShouldStop(1024);
if (branch.mostCurrent.__c.runMethod(true,"Not",(Object)(_checkedsales.getArrayElement(true,BA.numberCast(int.class, 2)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 780;BA.debugLine="ToastMessageShow(\"Please show Sales3 in the le";
Debug.ShouldStop(2048);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please show Sales3 in the legend before sorting by it.")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 781;BA.debugLine="Return";
Debug.ShouldStop(4096);
if (true) return RemoteObject.createImmutable("");
 };
 break; }
}
;
 BA.debugLineNum = 786;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(131072);
_loadcompanydata();
 BA.debugLineNum = 787;BA.debugLine="LoadCompanyDataBranchGraphSales";
Debug.ShouldStop(262144);
_loadcompanydatabranchgraphsales();
 BA.debugLineNum = 788;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("totalTarget_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,672);
if (RapidSub.canDelegate("totaltarget_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","totaltarget_click");}
RemoteObject _target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _target_id = RemoteObject.createImmutable("");
RemoteObject _total_count = RemoteObject.createImmutable("");
 BA.debugLineNum = 672;BA.debugLine="Sub totalTarget_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 673;BA.debugLine="popupPanel.Visible = True";
Debug.ShouldStop(1);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 674;BA.debugLine="Dim target_id_btn As Label = Sender";
Debug.ShouldStop(2);
_target_id_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("target_id_btn", _target_id_btn);Debug.locals.put("target_id_btn", _target_id_btn);
 BA.debugLineNum = 675;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
Debug.ShouldStop(4);
_target_id = BA.ObjectToString(_target_id_btn.runMethod(false,"getTag"));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 676;BA.debugLine="Dim total_count As String = target_id_btn.Text";
Debug.ShouldStop(8);
_total_count = _target_id_btn.runMethod(true,"getText");Debug.locals.put("total_count", _total_count);Debug.locals.put("total_count", _total_count);
 BA.debugLineNum = 677;BA.debugLine="target_id_display.Text = target_id";
Debug.ShouldStop(16);
branch.mostCurrent._target_id_display.runMethod(true,"setText",BA.ObjectToCharSequence(_target_id));
 BA.debugLineNum = 678;BA.debugLine="target_countLabel.Text = total_count";
Debug.ShouldStop(32);
branch.mostCurrent._target_countlabel.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_total_count));
 BA.debugLineNum = 679;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("totalTargetTitle_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,681);
if (RapidSub.canDelegate("totaltargettitle_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","totaltargettitle_click");}
RemoteObject _target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _target_id = RemoteObject.createImmutable("");
 BA.debugLineNum = 681;BA.debugLine="Sub totalTargetTitle_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 682;BA.debugLine="popupPanel.Visible = True";
Debug.ShouldStop(512);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 683;BA.debugLine="Dim target_id_btn As Label = Sender";
Debug.ShouldStop(1024);
_target_id_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("target_id_btn", _target_id_btn);Debug.locals.put("target_id_btn", _target_id_btn);
 BA.debugLineNum = 684;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
Debug.ShouldStop(2048);
_target_id = BA.ObjectToString(_target_id_btn.runMethod(false,"getTag"));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 685;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("UpdateData_Remote (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,220);
if (RapidSub.canDelegate("updatedata_remote")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","updatedata_remote", _target_id, _new_value);}
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
Debug.locals.put("target_id", _target_id);
Debug.locals.put("new_value", _new_value);
 BA.debugLineNum = 220;BA.debugLine="Sub UpdateData_Remote(target_id As Int, new_value";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 221;BA.debugLine="Dim PHPURL As String = $\"https://192.168.8.117/Co";
Debug.ShouldStop(268435456);
branch.mostCurrent._phpurl = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/branch.php?action=target_update&id="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_target_id))),RemoteObject.createImmutable("&value="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_new_value))),RemoteObject.createImmutable("")));
 BA.debugLineNum = 222;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(536870912);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 223;BA.debugLine="job.Initialize(\"UpdateData\", Me)";
Debug.ShouldStop(1073741824);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,branch.processBA,(Object)(BA.ObjectToString("UpdateData")),(Object)(branch.getObject()));
 BA.debugLineNum = 224;BA.debugLine="job.Download(PHPURL)";
Debug.ShouldStop(-2147483648);
_job.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(branch.mostCurrent._phpurl));
 BA.debugLineNum = 225;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}