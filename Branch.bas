B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.1
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Private xui As XUI
	Public company_name As String
	Public branch_selected As String
	
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.Private ScrollView1 As ScrollView
	Dim PHPURL As String = "https://192.168.8.192/Company/fetch.php?action=get_branch&company_id="&Starter.company_selected
	Dim PHPURL1 As String = "https://192.168.8.117/Company/fetch.php?action=get_company_list&page=1"
	Dim TableDetails As List
	Private ScrollView1 As ScrollView
	Private LabelTitle As Label
	Dim titleFontSize As Int = 4.5%y
	Dim primaryFontSize As Int = 1.6%y
	Dim secondaryFontSize As Int = 1%y
	Dim num As Int = 1
	Private Panel3 As Panel
	Dim home As Label
	Dim branches As Label
	Dim popupPanel As Panel
	Dim target_countLabel As EditText
	Dim target_id_display As Label
	Dim totalTarget As Label
	Dim Panel As Panel
	Dim barGraph As barGraph
	Dim purchasePanel As Panel
End Sub
Sub LoadCompanyData1
	Try
		Dim Job1 As HttpJob
		Job1.Initialize("GetBranches", Me)
		Job1.Download(PHPURL1)
		ProgressDialogShow("Loading Data...")
	Catch
		Log(LastException.Message)
	End Try
End Sub
Sub LoadCompanyData
	Dim Job1 As HttpJob
	totalTarget.Initialize("")
	totalTarget.RemoveView
	Panel.Initialize("")
	Panel.RemoveAllViews
	PHPURL = "https://192.168.8.117/Company/fetch.php?action=get_branch&company_id="&Starter.company_selected
	Job1.Initialize("GetData", Me)
	Job1.Download(PHPURL)
	ProgressDialogShow("Loading Data...")
End Sub

Sub UpdateData_Remote(target_id As Int, new_value As Int)
	Dim PHPURL As String = $"https://192.168.8.141/Company/fetch.php?action=target_update&id=${target_id}&value=${new_value}"$
	Dim job As HttpJob
	job.Initialize("UpdateData", Me)
	job.Download(PHPURL)
	'Activity.LoadLayout("Branch")
End Sub

Sub JobDone(job As HttpJob)
	ProgressDialogHide
	Dim scrollHeight As Int = 0
    
	If job.Success = True Then
		Try
			Dim parser As JSONParser
			parser.Initialize(job.GetString)
			
			
			Select Case job.JobName
				Case "GetData"
					TableDetails = parser.NextArray
					totalTarget.RemoveView
					Dim numColumns As Int = 2 ' Adjust based on preference
					Dim pnlWidth As Int = Activity.Width - 100dip
					Dim pnlHeight As Int = 280dip
					Dim padding As Int = 10dip
					Dim leftPosition As Int = 50dip
					Dim topPosition As Int = 0
					Dim count As Int = 0 ' Track panel count
					If Activity.Width >= 1340 Then
						pnlWidth = 490dip
						pnlHeight = 300dip
						padding = 10dip
						leftPosition = 10dip
					End If
					' Loop through fetched company data
					For Each record As Map In TableDetails
		
						Dim companyName As String = record.Get("company_name")
						Dim id As String = record.Get("id")
						Dim name As String = record.Get("branch_name")
						Dim total_count As Int = record.Get("target_no")
						Dim total_pos As Int = record.Get("total_device")
						Dim totalPur1 As String = record.Get("purchase_1")
						Dim totalPur2 As String = record.Get("purchase_2")
						Dim totalPur3 As String = record.Get("purchase_3")
						Dim totalSales1 As String = record.Get("total_sales1")
						Dim totalSales2 As String = record.Get("total_sales2")
						Dim totalSales3 As String = record.Get("total_sales3")
						Dim target_id As String = record.Get("branch_target_id")
						target_countLabel.Text = total_count
						branches.Text = "Branches - "&companyName
						branches.Text = branches.Text.ToUpperCase
				
						LabelTitle.Text = companyName
						LabelTitle.Text = LabelTitle.Text.ToUpperCase
						LabelTitle.Typeface = Typeface.MONOSPACE
						' Create a new Panel dynamically
					
						Panel.Initialize("Panel")
						ScrollView1.Panel.AddView(Panel, leftPosition, topPosition+400dip, pnlWidth, pnlHeight)
						Panel.Color = Colors.Black

						' Add a sub-panel (Panel2) for the title
						Dim Panel2 As Panel
						Panel2.Initialize("Panel2")
						'Panel2.Color = Colors.ARGB(255,156,0,0)
						Dim gradient As GradientDrawable
						gradient.Initialize("RIGHT_LEFT", Array As Int(Colors.ARGB(255, 185, 46, 52), Colors.ARGB(255, 61, 12, 2)))

						Panel2.Background = gradient
						Panel2.Tag = name
						Panel2.SendToBack
						Panel.AddView(Panel2, 0, 0, Panel.Width, 6%y)

						' Label for the company name
						Dim BranchNameLabel As Label
						BranchNameLabel.Initialize("Label17")
						BranchNameLabel.Text = name
						BranchNameLabel.Tag = id
						BranchNameLabel.TextSize = 18
						BranchNameLabel.TextColor = Colors.White
						BranchNameLabel.Typeface = Typeface.MONOSPACE
						BranchNameLabel.Gravity = Gravity.CENTER_VERTICAL
						Panel2.AddView(BranchNameLabel, 10dip, 0dip, Panel2.Width, Panel2.Height)
				
						Dim myImage As Bitmap
						myImage = LoadBitmap(File.DirAssets, "arrows-removebg-preview.png")
						If myImage.IsInitialized Then
							Dim resizedImage As Bitmap = myImage.Resize(DipToCurrent(4.5%x), myImage.Height * DipToCurrent(2%y) / myImage.Width, True)
							Dim imgView As ImageView
							imgView.Initialize("")
							imgView.Bitmap = resizedImage
							Panel2.AddView(imgView, Panel2.Width - 8%x, 0dip, 10%x, Panel2.Height)
						Else
							Log("Error loading image")
						End If
				
						Dim panelWidth As Int = Panel.Width /3
						Dim padding As Int = 10dip
						Dim labelheight As Int = 35dip
				
						Dim purchase1 As Label
						purchase1.Initialize("")
						purchase1.Text = totalPur1
						purchase1.TextColor = Colors.Black
						purchase1.TextSize = primaryFontSize
						purchase1.Gravity = Gravity.CENTER
						purchase1.Typeface = Typeface.SERIF
						Panel.AddView(purchase1,0,Panel2.Height+padding,panelWidth,labelheight)
				
						Dim purchase1Title As Label
						purchase1Title.Initialize("")
						purchase1Title.Text = "First Purchase"
						purchase1Title.TextColor = Colors.Gray
						purchase1Title.TextSize = secondaryFontSize
						purchase1Title.Gravity = Gravity.CENTER
						purchase1Title.Typeface = Typeface.MONOSPACE
						purchase1Title.Text = purchase1Title.Text.ToUpperCase
						Panel.AddView(purchase1Title,0,purchase1.top+padding+20dip,panelWidth,labelheight)
				
						Dim purchase2 As Label
						purchase2.Initialize("")
						purchase2.Text = totalPur2
						purchase2.TextColor = Colors.Black
						purchase2.TextSize = primaryFontSize
						purchase2.Gravity = Gravity.CENTER
						purchase2.Typeface = Typeface.SERIF
						Panel.AddView(purchase2,panelWidth,Panel2.Height+padding,panelWidth,labelheight)
				
						Dim purchase2Title As Label
						purchase2Title.Initialize("")
						purchase2Title.Text = "Second Purchase"
						purchase2Title.TextColor = Colors.Gray
						purchase2Title.TextSize = secondaryFontSize
						purchase2Title.Gravity = Gravity.CENTER
						purchase2Title.Typeface = Typeface.MONOSPACE
						purchase2Title.Text = purchase2Title.Text.ToUpperCase
						Panel.AddView(purchase2Title,panelWidth,purchase1.top+padding+20dip,panelWidth,labelheight)
				
						Dim purchase3 As Label
						purchase3.Initialize("")
						purchase3.Text = totalPur3
						purchase3.TextColor = Colors.Black
						purchase3.TextSize = primaryFontSize
						purchase3.Gravity = Gravity.CENTER
						purchase3.Typeface = Typeface.SERIF
						Panel.AddView(purchase3,panelWidth*2,Panel2.Height+padding,panelWidth,labelheight)
				
						Dim purchase3Title As Label
						purchase3Title.Initialize("")
						purchase3Title.Text = "Third Purchase"
						purchase3Title.TextColor = Colors.Gray
						purchase3Title.TextSize = secondaryFontSize
						purchase3Title.Gravity = Gravity.CENTER
						purchase3Title.Typeface = Typeface.MONOSPACE
						purchase3Title.Text = purchase3Title.Text.ToUpperCase
						Panel.AddView(purchase3Title,panelWidth*2,purchase1.top+padding+20dip,panelWidth,labelheight)
				
						Dim sale1 As Label
						sale1.Initialize("")
						sale1.Text = totalSales1
						sale1.TextColor = Colors.Black
						sale1.TextSize = primaryFontSize
						sale1.Gravity = Gravity.CENTER
						sale1.Typeface = Typeface.SERIF
						Panel.AddView(sale1,0,purchase3Title.Height+padding+90dip,panelWidth,labelheight)
				
						Dim sale1Title As Label
						sale1Title.Initialize("")
						sale1Title.Text = "First Sale"
						sale1Title.TextColor = Colors.Gray
						sale1Title.TextSize = secondaryFontSize
						sale1Title.Gravity = Gravity.CENTER
						sale1Title.Typeface = Typeface.MONOSPACE
						sale1Title.Text = sale1Title.Text.ToUpperCase
						Panel.AddView(sale1Title,0,sale1.top+padding+20dip,panelWidth,labelheight)
				
						Dim sale2 As Label
						sale2.Initialize("")
						sale2.Text = totalSales2
						sale2.TextColor = Colors.Black
						sale2.TextSize = primaryFontSize
						sale2.Gravity = Gravity.CENTER
						sale2.Typeface = Typeface.SERIF
						Panel.AddView(sale2,panelWidth,purchase3Title.Height+padding+90dip,panelWidth,labelheight)
				
						Dim sale2Title As Label
						sale2Title.Initialize("")
						sale2Title.Text = " Second Sale"
						sale2Title.TextColor = Colors.Gray
						sale2Title.TextSize = secondaryFontSize
						sale2Title.Gravity = Gravity.CENTER
						sale2Title.Typeface = Typeface.MONOSPACE
						sale2Title.Text = sale2Title.Text.ToUpperCase
						Panel.AddView(sale2Title,panelWidth,sale2.top+padding+20dip,panelWidth,labelheight)
				
						Dim sale3 As Label
						sale3.Initialize("")
						sale3.Text = totalSales3
						sale3.TextColor = Colors.Black
						sale3.TextSize = primaryFontSize
						sale3.Gravity = Gravity.CENTER
						sale3.Typeface = Typeface.SERIF
						Panel.AddView(sale3,panelWidth*2,sale2Title.Height+padding+90dip,panelWidth,labelheight)
				
						Dim sale3Title As Label
						sale3Title.Initialize("")
						sale3Title.Text = " Third Sale"
						sale3Title.TextColor = Colors.Gray
						sale3Title.TextSize = secondaryFontSize
						sale3Title.Gravity = Gravity.CENTER
						sale3Title.Typeface = Typeface.MONOSPACE
						sale3Title.Text = sale3Title.Text.ToUpperCase
						Panel.AddView(sale3Title,panelWidth*2,sale1.top+padding+20dip,panelWidth,labelheight)
				
						panelWidth = Panel.Width /2
				 		
						totalTarget.Initialize("totalTarget")
						totalTarget.Text = total_count
						totalTarget.Tag = target_id
						totalTarget.TextColor = Colors.Black
						totalTarget.Color = Colors.White
						totalTarget.TextSize = primaryFontSize
						totalTarget.Gravity = Gravity.CENTER
						totalTarget.Typeface = Typeface.SERIF
						Panel.AddView(totalTarget,2dip,sale3Title.Height+padding+160dip,panelWidth,labelheight)
				
						Dim totalTargetTitle As Label
						totalTargetTitle.Initialize("totalTargetTitles")
						totalTargetTitle.Text = " Total Target"
						totalTargetTitle.tag = 20
						totalTargetTitle.TextColor = Colors.Gray
						totalTargetTitle.TextSize = secondaryFontSize
						totalTargetTitle.Gravity = Gravity.CENTER
						totalTargetTitle.Typeface = Typeface.MONOSPACE
						totalTargetTitle.Text = totalTargetTitle.Text.ToUpperCase
						Panel.AddView(totalTargetTitle,0,totalTarget.top+padding+20dip,panelWidth,labelheight)
				
						Dim totalPos As Label
						totalPos.Initialize("")
						totalPos.Text = total_pos
						totalPos.TextColor = Colors.Black
						totalPos.TextSize = primaryFontSize
						totalPos.Gravity = Gravity.CENTER
						totalPos.Typeface = Typeface.SERIF
						Panel.AddView(totalPos,panelWidth,totalTargetTitle.Height+padding+160dip,panelWidth,labelheight)
				
						Dim totalPosTitle As Label
						totalPosTitle.Initialize("")
						totalPosTitle.Text = " Total Pos"
						totalPosTitle.TextColor = Colors.Gray
						totalPosTitle.TextSize = secondaryFontSize
						totalPosTitle.Gravity = Gravity.CENTER
						totalPosTitle.Typeface = Typeface.MONOSPACE
						totalPosTitle.Text = totalPosTitle.Text.ToUpperCase
						Panel.AddView(totalPosTitle,panelWidth,totalPos.top+padding+20dip,panelWidth,labelheight)
				
						' Apply border styling
						Dim cd As ColorDrawable
						cd.Initialize2(Colors.White, 0dip, 2dip, Colors.RGB(156,0,0))
						Panel.Background = cd
				
	

                        
						' Adjust panel positions in grid layout
						If Activity.Width >= 1340 Then
							count = count + 1
							If count Mod numColumns = 0 Then
								leftPosition = 10dip
								topPosition = topPosition + pnlHeight + padding
							Else
								leftPosition = leftPosition + pnlWidth + padding
							End If
							scrollHeight = scrollHeight + 175dip
						Else
							topPosition = topPosition + pnlHeight + padding
							scrollHeight = scrollHeight + 290dip
						End If
					Next
                    
					' Update ScrollView height
					ScrollView1.Panel.Height = scrollHeight
                
				Case "UpdateData"
					' Handle data update
					ToastMessageShow("Data updated successfully", False)
					'CallSubDelayed(Me, "FetchData") ' Ensure data refresh
					LoadCompanyData
				Case "GetBranches"
					Dim scrollHeight As Int = 0
					Dim salesArray As List = parser.NextArray

					Dim idCom As Int = Starter.company_selected.As(Int)
						For i = 0 To salesArray.Size - 1
						
							Dim record As Map = salesArray.Get(i)
							Dim currentComId As String = record.Get("comId")
    
							' Check if the current company's comId matches the target comId
						If currentComId = idCom Then

								' Check if the company has branches
								If record.ContainsKey("branches") Then
									Dim branches1 As List = record.Get("branches")
									Dim totalBranches As Int = branches1.Size
	            
									' Initialize arrays for the current company's branches
									Dim branchNames(totalBranches) As String
									Dim branchSales1(totalBranches) As Int
									Dim branchSales2(totalBranches) As Int
									Dim branchSales3(totalBranches) As Int

									' Populate the arrays with branch details
									For j = 0 To totalBranches - 1
										Dim branchMap As Map = branches1.Get(j)
										branchNames(j) = branchMap.GetDefault("branch_name","").As(String)
										branchSales1(j) = branchMap.GetDefault("sales1",0)
										branchSales2(j) = branchMap.GetDefault("sales2",0)
										branchSales3(j) = branchMap.GetDefault("sales3",0)
				
									Next
									
							
									purchasePanel.Initialize("")
									ScrollView1.Panel.AddView(purchasePanel,0,20dip,Activity.Width,400dip)
									Dim legend() As String = Array As String("Sales1","Sales2","Sales3")
									barGraph.Initialize(Activity, purchasePanel, branchSales1, branchSales2, branchSales3, branchNames,legend,19000,"Total Purchase of the Company",branchSales1,"Branch")
			
								Else
									Log($"Company: ${name} has no branches information."$)
								End If
							End If
						Next

				Case Else
					Log("Unknown job: " & job.JobName)
			End Select
            
		Catch
			ToastMessageShow("Error parsing data", True)
		End Try
	Else
		ToastMessageShow("Error: " & job.ErrorMessage, True)
	End If
    
	job.Release
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("Branch")
	
	
	home.Initialize("home")
	home.Text = "HOME |"
	home.TextColor = Colors.Black
	home.Typeface = Typeface.MONOSPACE
	home.Gravity = Gravity.CENTER
	home.TextSize = 16 '
	Panel3.AddView(home, 0, 0, responsiveLabel(home), Panel3.Height)
	Panel3.Color = Colors.Transparent
	
	branches.Initialize("")
	branches.Text = "Branches"
	branches.Typeface = Typeface.MONOSPACE
	branches.Gravity = Gravity.CENTER_VERTICAL
	branches.TextSize = 16 
	Panel3.AddView(branches, responsiveLabel(home), 0, 300dip, Panel3.Height)
	
	' Initialize Popup Panel (Hidden by default)
	popupPanel.Initialize("")
	popupPanel.Color = Colors.ARGB(200, 0, 0, 0) ' Semi-transparent background
	popupPanel.Visible = False
	Activity.AddView(popupPanel, 0, 0, Activity.Width, Activity.Height)

	' Add a Close Button
	
	
	Dim popupPanelBackground As Panel
	popupPanelBackground.Initialize("")
	popupPanelBackground.Color = Colors.White
	popupPanel.AddView(popupPanelBackground, 70dip, 50dip, 550dip, Activity.Height-500dip)
	Dim leftPosition As Int = (popupPanel.Width - popupPanelBackground.Width) / 2
	popupPanelBackground.Left = leftPosition
	
	
	Dim closeButton As Label
	closeButton.Initialize("closeButton")
	closeButton.Text = "X"
	closeButton.TextSize = 20
	closeButton.TextColor = Colors.Red
	closeButton.Typeface = Typeface.DEFAULT_BOLD
	popupPanelBackground.AddView(closeButton, popupPanelBackground.Width-25dip, 5dip, 100dip, 40dip)
	
	target_id_display.Initialize("target_id_display")
	target_id_display.TextSize = 20
	target_id_display.TextColor = Colors.Red
	target_id_display.Typeface = Typeface.DEFAULT_BOLD
	popupPanelBackground.AddView(target_id_display, popupPanelBackground.Width-25dip, 50dip, 100dip, 40dip)
	
	
	' Add Text inside Popup
	Dim popupText As Label
	popupText.Initialize("")
	popupText.Text = "Edit Target"
	popupText.TextColor = Colors.Black
	popupText.TextSize = 58
	popupText.Gravity = Gravity.CENTER
	popupPanelBackground.AddView(popupText, 25dip, 10dip, 80%x - 40dip, 100dip)
	
	target_countLabel.Initialize("")
	target_countLabel.TextColor = Colors.Black
	target_countLabel.TextSize = 58
	target_countLabel.Gravity = Gravity.CENTER
	popupPanelBackground.AddView(target_countLabel, 25dip, 80dip, 80%x - 40dip, 100dip)
	ScrollView1.Panel.Color = Colors.ARGB(255, 251, 251, 251)
	
	Dim edit_button As Button
	edit_button.Initialize("edit_button")
	edit_button.Text = "Update"
	edit_button.TextColor = Colors.Black
	edit_button.TextSize = 58
	edit_button.Gravity = Gravity.CENTER
	popupPanelBackground.AddView(edit_button, 25dip, 200dip, 80%x - 40dip, 100dip)
	
	LoadCompanyData
	LoadCompanyData1
End Sub

Sub edit_button_Click
	Dim target_id As Int = target_id_display.Text ' 
	Dim new_value As Int = target_countLabel.Text ' 

	If IsNumber(target_id) And IsNumber(new_value) Then
		UpdateData_Remote(target_id, new_value)
		Log("Updated target " & target_id & " with value " & new_value)
		LoadCompanyData
	Else
		Log("Invalid input values")
	End If
End Sub

' Show popup when clicking totalTarget
Sub totalTarget_Click
	popupPanel.Visible = True
	Dim target_id_btn As Label = Sender ' Get the clicked label
	Dim target_id As String = target_id_btn.Tag
	
	target_id_display.Text = target_id
End Sub

Sub totalTargetTitle_Click
	popupPanel.Visible = True
	Dim target_id_btn As Label = Sender ' Get the clicked label
	Dim target_id As String = target_id_btn.Tag
	
	Log(target_id&"This is clicked id")
End Sub

' Hide popup when clicking close button
Sub closeButton_Click
	popupPanel.Visible = False
End Sub


Sub responsiveLabel(label As Label) As Int
	Dim charWidth As Int = 10dip
	Dim padding As Int = 10dip
	Dim homeWidth As Int = (label.Text.Length * charWidth) + padding
	Return homeWidth
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub home_Click
	StartActivity("Main")
	Activity.Finish
End Sub

Private Sub Label17_Click
	Dim clickedLabel As Label = Sender
	Dim selectedCompany As String = clickedLabel.Tag

	branch_selected = selectedCompany

	StartActivity("Device")
End Sub

