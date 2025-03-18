B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.1
@EndOfDesignText@
#Region Activity Attributes 
    #FullScreen: False
    #IncludeTitle: False
#End Region

Sub Process_Globals
	Private xui As XUI
	Public company_name As String
	Public branch_selected As String
End Sub

Sub Globals
	Private ScrollView1 As ScrollView
	Dim PHPURL As String = "https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id=" & Starter.company_selected
	Dim PHPURL1 As String = "https://192.168.8.117/Company/controller/company.php?action=get_company_list&page=1"
	Dim TableDetails As List
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
	Dim nxtBtn As Button
	Dim backbtn As Button
	Dim purchasePanel As Panel
	Dim currentPage As Int = 1
	Dim totalSales As Int = 0
	Dim barGraphInitialized As Boolean = False
	Private Panel4 As Panel
	Dim scrollViewPanel4 As ScrollView
	Dim sortBtn1 As RadioButton
	Public defBtn As RadioButton
	Public sortBtn2 As RadioButton
	Public salesBtn1 As RadioButton
	Public salesBtn2 As RadioButton
	Public salesBtn3 As RadioButton
	Dim salesData1 As Int
	Dim salesDataDefault As Int = 1
	Dim sortDefaultValue As String
	Dim showHideBtn As Button
	Dim showHide As Boolean = True
	Dim popupPanelBackground As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("Branch")
	home.Initialize("home")
	home.Text = "HOME |"
	home.TextColor = Colors.Black
	home.Typeface = Typeface.MONOSPACE
	home.Gravity = Gravity.CENTER
	home.TextSize = 16
	Panel3.AddView(home, 0, 0, responsiveLabel(home), Panel3.Height)
	Panel3.Color = Colors.Transparent
    
	branches.Initialize("")
	branches.Text = "Branches"
	branches.Typeface = Typeface.MONOSPACE
	branches.Gravity = Gravity.CENTER_VERTICAL
	branches.TextSize = 16
	Panel3.AddView(branches, responsiveLabel(home), 0, 300dip, Panel3.Height)
    
	popupPanel.Initialize("")
	popupPanel.Color = Colors.ARGB(200, 0, 0, 0)
	popupPanel.Visible = False
	Activity.AddView(popupPanel, 0, 0, Activity.Width, Activity.Height)
    
	Dim cd As ColorDrawable
	cd.Initialize2(Colors.White, 5dip, 1dip, Colors.Black)
	
	
	popupPanelBackground.Initialize("")
	popupPanelBackground.Color = Colors.White
	popupPanel.AddView(popupPanelBackground, 70dip, 50dip, 550dip, Activity.Height - 500dip)
	'popupPanelBackground.Background = cd
	
	Dim leftPosition As Int = (popupPanel.Width - popupPanelBackground.Width) / 2
	popupPanelBackground.Left = leftPosition
    
	
	
	Dim closeButton As Label
	closeButton.Initialize("closeButton")
	closeButton.Text = "X"
	closeButton.TextSize = 15
	closeButton.TextColor = Colors.Red
	closeButton.Typeface = Typeface.DEFAULT_BOLD
	closeButton.Gravity = Gravity.CENTER
	popupPanelBackground.AddView(closeButton, popupPanelBackground.Width - 35dip, 10dip, 30dip, 30dip)
	closeButton.Background = cd
	
	target_id_display.Initialize("target_id_display")
	target_id_display.TextSize = 20
	target_id_display.TextColor = Colors.Red
	target_id_display.Typeface = Typeface.DEFAULT_BOLD
	'popupPanelBackground.AddView(target_id_display, popupPanelBackground.Width - 25dip, 50dip, 100dip, 40dip)

	Dim myImage As Bitmap = LoadBitmap(File.DirAssets, "store.PNG")
	Dim imgView As ImageView
	imgView.Initialize("")
	imgView.Gravity = Gravity.FILL
	imgView.Bitmap = myImage
	popupPanelBackground.AddView(imgView, 25%x, 12.5dip, popupPanelBackground.Width - 50%x, 200dip)
					
					
	Dim popupText As Label
	popupText.Initialize("")
	popupText.Text = "Modify Target Sales"
	popupText.TextColor = Colors.Black
	popupText.TextSize = 50
	popupText.Typeface = Typeface.DEFAULT_BOLD
	popupText.Gravity = Gravity.CENTER
	popupPanelBackground.AddView(popupText, 25dip, imgView.Top + imgView.Height, popupPanelBackground.Width-50dip, 65dip)
    
	Dim popupDirectionText As Label
	popupDirectionText.Initialize("")
	popupDirectionText.Text = "Modify the sales target and set a new goal for total company sales."
	popupDirectionText.TextColor = Colors.ARGB(150,0,0,0)
	popupDirectionText.TextSize = 15
	popupDirectionText.Typeface = Typeface.MONOSPACE
	popupDirectionText.Gravity = Gravity.CENTER
	popupPanelBackground.AddView(popupDirectionText, 50dip, popupText.Top + popupText.Height, popupPanelBackground.Width-100dip, 40dip)
	
	target_countLabel.Initialize("")
	'target_countLabel.Text = total_count
	target_countLabel.TextColor = Colors.Black
	target_countLabel.TextSize = 25
	target_countLabel.Gravity = Gravity.CENTER
							
	popupPanelBackground.AddView(target_countLabel, 50dip, popupDirectionText.Top + popupDirectionText.height, popupPanelBackground.Width - 100dip, 50dip)
	ScrollView1.Panel.Color = Colors.ARGB(255, 251, 251, 251)
    
	AddBottomBorderToLabel(target_countLabel)
	
	Dim edit_button As Button
	edit_button.Initialize("edit_button")
	edit_button.Text = "Update"
	edit_button.TextColor = Colors.White
	edit_button.TextSize = 25
	edit_button.Gravity = Gravity.CENTER
	popupPanelBackground.AddView(edit_button, 30%x, target_countLabel.Top+target_countLabel.Height+25dip, popupPanelBackground.Width - 60%x, 50dip)
    
	Dim cdBack As ColorDrawable
	cdBack.Initialize2(Colors.RGB(61, 12, 2), 10dip, 2dip, Colors.Black)
	edit_button.Background = cdBack
	
	
	
	
	
	purchasePanel.Initialize("")
	Panel4.AddView(purchasePanel, 0, 0dip, Activity.Width, 530dip) ' Ensure purchasePanel has enough height
	purchasePanel.Color = Colors.White ' Set a visible background to debug visibility
    
	scrollViewPanel4.Initialize(Panel4.Height - purchasePanel.Height)
	Panel4.AddView(scrollViewPanel4, 0, purchasePanel.Height, Panel4.Width, Panel4.Height - purchasePanel.Height)
	'Panel.Initialize("")


	LoadCompanyData
	LoadCompanyDataBranchGraph
End Sub
Sub Activity_Resume
		
End Sub

Sub Activity_Pause (UserClosed As Boolean)
End Sub

Sub LoadCompanyDataBranchGraph
	Try
		Dim Job1 As HttpJob
		Job1.Initialize("GetBranches", Me)
		PHPURL1 = $"https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id=${Starter.company_selected}&page=${currentPage}&branch_sales=${salesData1}&sort_type=${sortDefaultValue}"$
		Log(Starter.company_selected & "isd")
		Job1.Download(PHPURL1)
		ProgressDialogShow("Loading Graph Data...")

	Catch
		Log(LastException.Message)
	End Try
End Sub


Sub LoadCompanyData
	Dim Job1 As HttpJob
	totalTarget.Initialize("")
	totalTarget.RemoveView
	PHPURL = $"https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id=${Starter.company_selected}&page=${currentPage}"$
	Log($"Fetching panel data for company ID: ${Starter.company_selected}, page: ${currentPage}"$)
	Job1.Initialize("GetData", Me)
	ProgressDialogShow("Loading Graph Data...")
	Job1.Download(PHPURL)
End Sub

Sub UpdateData_Remote(target_id As Int, new_value As Int)
	Dim PHPURL As String = $"https://192.168.8.117/Company/controller/branch.php?action=target_update&id=${target_id}&value=${new_value}"$
	Dim job As HttpJob
	job.Initialize("UpdateData", Me)
	job.Download(PHPURL)
End Sub

Sub JobDone(job As HttpJob)
	'ProgressDialogHide
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
					For Each record As Map In TableDetails
						
						Panel.Initialize("Panel")
						Panel.Visible = showHide
						scrollViewPanel4.Panel.AddView(Panel, leftPosition, topPosition, pnlWidth, pnlHeight)
						Panel.Color = Colors.Black
						If Panel.Visible = True Then
							Dim companyName As String = record.Get("company_name")
							Dim id As String = record.Get("branch_id")
							Dim name As String = record.Get("branch_name")
							Dim total_count As Int = record.Get("target_no")
							Dim total_pos As Int = record.Get("count_device")
							Dim totalPur1 As String = record.Get("purchase_1")
							Dim totalPur2 As String = record.Get("purchase_2")
							Dim totalPur3 As String = record.Get("purchase_3")
							Dim totalSales1 As String = record.Get("sales_1")
							Dim totalSales2 As String = record.Get("sales_2")
							Dim totalSales3 As String = record.Get("sales_3")
							Dim target_id As String = record.Get("target_id")
							totalSales = totalSales1.Length
							branches.Text = "Branches - " & companyName
							branches.Text = branches.Text.ToUpperCase
	                        
							LabelTitle.Text = companyName
							LabelTitle.Text = LabelTitle.Text.ToUpperCase
							LabelTitle.Typeface = Typeface.MONOSPACE
	                        

							Dim Panel2 As Panel
							Panel2.Initialize("Panel2")
							Dim gradient As GradientDrawable
							gradient.Initialize("RIGHT_LEFT", Array As Int(Colors.ARGB(255, 185, 46, 52), Colors.ARGB(255, 61, 12, 2)))
							Panel2.Background = gradient
							Panel2.Tag = name
							Panel2.SendToBack
							Panel.AddView(Panel2, 0, 0, Panel.Width, 6%y)

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
	                
							Dim panelWidth As Int = Panel.Width / 3
							Dim padding As Int = 10dip
							Dim labelheight As Int = 35dip
	                
							Dim purchase1 As Label
							purchase1.Initialize("")
							purchase1.Text = totalPur1
							purchase1.TextColor = Colors.Black
							purchase1.TextSize = primaryFontSize
							purchase1.Gravity = Gravity.CENTER
							purchase1.Typeface = Typeface.SERIF
							Panel.AddView(purchase1, 0, Panel2.Height + padding, panelWidth, labelheight)
	                
							Dim purchase1Title As Label
							purchase1Title.Initialize("")
							purchase1Title.Text = "First Purchase"
							purchase1Title.TextColor = Colors.Gray
							purchase1Title.TextSize = secondaryFontSize
							purchase1Title.Gravity = Gravity.CENTER
							purchase1Title.Typeface = Typeface.MONOSPACE
							purchase1Title.Text = purchase1Title.Text.ToUpperCase
							Panel.AddView(purchase1Title, 0, purchase1.top + padding + 20dip, panelWidth, labelheight)
	                
							Dim purchase2 As Label
							purchase2.Initialize("")
							purchase2.Text = totalPur2
							purchase2.TextColor = Colors.Black
							purchase2.TextSize = primaryFontSize
							purchase2.Gravity = Gravity.CENTER
							purchase2.Typeface = Typeface.SERIF
							Panel.AddView(purchase2, panelWidth, Panel2.Height + padding, panelWidth, labelheight)
	                
							Dim purchase2Title As Label
							purchase2Title.Initialize("")
							purchase2Title.Text = "Second Purchase"
							purchase2Title.TextColor = Colors.Gray
							purchase2Title.TextSize = secondaryFontSize
							purchase2Title.Gravity = Gravity.CENTER
							purchase2Title.Typeface = Typeface.MONOSPACE
							purchase2Title.Text = purchase2Title.Text.ToUpperCase
							Panel.AddView(purchase2Title, panelWidth, purchase1.top + padding + 20dip, panelWidth, labelheight)
	                
							Dim purchase3 As Label
							purchase3.Initialize("")
							purchase3.Text = totalPur3
							purchase3.TextColor = Colors.Black
							purchase3.TextSize = primaryFontSize
							purchase3.Gravity = Gravity.CENTER
							purchase3.Typeface = Typeface.SERIF
							Panel.AddView(purchase3, panelWidth * 2, Panel2.Height + padding, panelWidth, labelheight)
	                
							Dim purchase3Title As Label
							purchase3Title.Initialize("")
							purchase3Title.Text = "Third Purchase"
							purchase3Title.TextColor = Colors.Gray
							purchase3Title.TextSize = secondaryFontSize
							purchase3Title.Gravity = Gravity.CENTER
							purchase3Title.Typeface = Typeface.MONOSPACE
							purchase3Title.Text = purchase3Title.Text.ToUpperCase
							Panel.AddView(purchase3Title, panelWidth * 2, purchase1.top + padding + 20dip, panelWidth, labelheight)
	                
							Dim sale1 As Label
							sale1.Initialize("")
							sale1.Text = totalSales1
							sale1.TextColor = Colors.Black
							sale1.TextSize = primaryFontSize
							sale1.Gravity = Gravity.CENTER
							sale1.Typeface = Typeface.SERIF
							Panel.AddView(sale1, 0, purchase3Title.Height + padding + 90dip, panelWidth, labelheight)
	                
							Dim sale1Title As Label
							sale1Title.Initialize("")
							sale1Title.Text = "First Sale"
							sale1Title.TextColor = Colors.Gray
							sale1Title.TextSize = secondaryFontSize
							sale1Title.Gravity = Gravity.CENTER
							sale1Title.Typeface = Typeface.MONOSPACE
							sale1Title.Text = sale1Title.Text.ToUpperCase
							Panel.AddView(sale1Title, 0, sale1.top + padding + 20dip, panelWidth, labelheight)
	                
							Dim sale2 As Label
							sale2.Initialize("")
							sale2.Text = totalSales2
							sale2.TextColor = Colors.Black
							sale2.TextSize = primaryFontSize
							sale2.Gravity = Gravity.CENTER
							sale2.Typeface = Typeface.SERIF
							Panel.AddView(sale2, panelWidth, purchase3Title.Height + padding + 90dip, panelWidth, labelheight)
	                
							Dim sale2Title As Label
							sale2Title.Initialize("")
							sale2Title.Text = " Second Sale"
							sale2Title.TextColor = Colors.Gray
							sale2Title.TextSize = secondaryFontSize
							sale2Title.Gravity = Gravity.CENTER
							sale2Title.Typeface = Typeface.MONOSPACE
							sale2Title.Text = sale2Title.Text.ToUpperCase
							Panel.AddView(sale2Title, panelWidth, sale2.top + padding + 20dip, panelWidth, labelheight)
	                
							Dim sale3 As Label
							sale3.Initialize("")
							sale3.Text = totalSales3
							sale3.TextColor = Colors.Black
							sale3.TextSize = primaryFontSize
							sale3.Gravity = Gravity.CENTER
							sale3.Typeface = Typeface.SERIF
							Panel.AddView(sale3, panelWidth * 2, sale2Title.Height + padding + 90dip, panelWidth, labelheight)
	                
							Dim sale3Title As Label
							sale3Title.Initialize("")
							sale3Title.Text = " Third Sale"
							sale3Title.TextColor = Colors.Gray
							sale3Title.TextSize = secondaryFontSize
							sale3Title.Gravity = Gravity.CENTER
							sale3Title.Typeface = Typeface.MONOSPACE
							sale3Title.Text = sale3Title.Text.ToUpperCase
							Panel.AddView(sale3Title, panelWidth * 2, sale1.top + padding + 20dip, panelWidth, labelheight)
	                
							panelWidth = Panel.Width / 2
	                        
							
							totalTarget.Initialize("totalTarget")
							totalTarget.Text = total_count
							totalTarget.Tag = target_id
							totalTarget.TextColor = Colors.Black
							totalTarget.Color = Colors.White
							totalTarget.TextSize = primaryFontSize
							totalTarget.Gravity = Gravity.CENTER
							totalTarget.Typeface = Typeface.SERIF
							Panel.AddView(totalTarget, 2dip, sale3Title.Height + padding + 160dip, panelWidth, labelheight)
	                
							Dim totalTargetTitle As Label
							totalTargetTitle.Initialize("totalTargetTitles")
							totalTargetTitle.Text = " Total Target"
							totalTargetTitle.Tag = 20
							totalTargetTitle.TextColor = Colors.Gray
							totalTargetTitle.TextSize = secondaryFontSize
							totalTargetTitle.Gravity = Gravity.CENTER
							totalTargetTitle.Typeface = Typeface.MONOSPACE
							totalTargetTitle.Text = totalTargetTitle.Text.ToUpperCase
							Panel.AddView(totalTargetTitle, 0, totalTarget.top + padding + 20dip, panelWidth, labelheight)
	                
							Dim totalPos As Label
							totalPos.Initialize("")
							totalPos.Text = total_pos
							totalPos.TextColor = Colors.Black
							totalPos.TextSize = primaryFontSize
							totalPos.Gravity = Gravity.CENTER
							totalPos.Typeface = Typeface.SERIF
							Panel.AddView(totalPos, panelWidth, totalTargetTitle.Height + padding + 160dip, panelWidth, labelheight)
	                
					
					
							Dim totalPosTitle As Label
							totalPosTitle.Initialize("")
							totalPosTitle.Text = " Total Pos"
							totalPosTitle.TextColor = Colors.Gray
							totalPosTitle.TextSize = secondaryFontSize
							totalPosTitle.Gravity = Gravity.CENTER
							totalPosTitle.Typeface = Typeface.MONOSPACE
							totalPosTitle.Text = totalPosTitle.Text.ToUpperCase
							Panel.AddView(totalPosTitle, panelWidth, totalPos.top + padding + 20dip, panelWidth, labelheight)
	                
							Dim cd As ColorDrawable
							cd.Initialize2(Colors.White, 0dip, 2dip, Colors.RGB(156, 0, 0))
							Panel.Background = cd
	                
					
					
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
						End If
					Next
                    
					scrollViewPanel4.Panel.Height = scrollHeight
					ProgressDialogHide
				Case "UpdateData"
					ToastMessageShow("Data updated successfully", False)
					LoadCompanyData
                
				Case "GetBranches"
					Dim salesArray As List = parser.NextArray
					If salesArray.Size = 0 Then
						Log("No branch data returned")
						ToastMessageShow("No branch data available", False)
						Return
					End If

					' Initialize arrays based on the number of branches
					Dim totalBranches As Int = salesArray.Size
					Dim branchNames(totalBranches) As String
					Dim branchSales1(totalBranches) As Int
					Dim branchSales2(totalBranches) As Int
					Dim branchSales3(totalBranches) As Int
					Dim branchCount As Int = 0
                    
					' Populate arrays with data
					For i = 0 To totalBranches - 1
						Dim record As Map = salesArray.Get(i)
						branchNames(i) = record.GetDefault("branch_name", "Unknown")
						branchSales1(i) = record.GetDefault("sales_1", 0)
						branchSales2(i) = record.GetDefault("sales_2", 0)
						branchSales3(i) = record.GetDefault("sales_3", 0)
						branchCount = record.GetDefault("total_branch_count", 0)
					Next
					Log($"branchCount:${branchCount}"$)
					' Define legend for the graph
					Dim legend() As String = Array As String("Sales 1", "Sales 2", "Sales 3")
                    
					' Clear previous views in purchasePanel
					purchasePanel.RemoveAllViews
                    
					' Initialize or update bar graph
					If barGraphInitialized = False Then
						nxtBtn.Initialize("nxtBtn")
						backbtn.Initialize("backbtn")
						sortBtn1.Initialize("sortBtn1")
						sortBtn2.Initialize("sortBtn2")
						defBtn.Initialize("defBtn")
						salesBtn1.Initialize("salesBtn1")
						salesBtn2.Initialize("salesBtn2")
						salesBtn3.Initialize("salesBtn3")
						
						Dim showHideBtn As Button
						showHideBtn.Initialize("showHideBtn")
						barGraph.Initialize(Activity, purchasePanel, branchSales1, branchSales2, branchSales3, branchNames, legend, 10000, "Sales Per Branch", branchSales1, "Branch", nxtBtn, backbtn, sortBtn1, sortBtn2, defBtn, salesBtn1, salesBtn2, salesBtn3,showHideBtn)
						barGraph.totalPages = branchCount / 5
						barGraph.UpdateGraph
						barGraphInitialized = True
						Log("Bar graph initialized")
					Else
						' Update existing bar graph with new data
						barGraph.pageNo = currentPage
						barGraph.sale_1 = branchSales1
						barGraph.sale_2 = branchSales2
						barGraph.sale_3 = branchSales3
						barGraph.product1 = branchNames
						barGraph.comId1 = branchSales1 ' Assuming this is used for some comparison
					'	barGraph.SetCurrentPage(currentPage)
						barGraph.UpdateGraph
						Log("Bar graph updated")
					End If
                    
					' Enable/disable navigation buttons
					backbtn.Enabled = currentPage > 1
					nxtBtn.Enabled = salesArray.Size > 0 ' Adjust based on your pagination logic
                    
				Case "UpdateData"
					ToastMessageShow("Data updated successfully", False)
					LoadCompanyData
                    
				Case Else
					Log("Unknown job: " & job.JobName)
			End Select
            
		Catch
			Log("Error parsing data: " & LastException.Message)
			ToastMessageShow("Error parsing graph data", True)
		End Try
	Else
		Log("Job failed: " & job.ErrorMessage)
		ToastMessageShow("Error: " & job.ErrorMessage, True)
	End If
    
	job.Release
End Sub


Sub FetchNewPageData
	LoadCompanyDataBranchGraph ' Fetch new data for the current page
End Sub

Sub edit_button_Click
	Dim target_id As Int = target_id_display.Text
	Dim new_value As Int = target_countLabel.Text

	If IsNumber(target_id) And IsNumber(new_value) Then
		UpdateData_Remote(target_id, new_value)
		LoadCompanyData
		popupPanel.Visible = False
	Else
		Log("Invalid input values")
	End If
End Sub

Sub totalTarget_Click
	popupPanel.Visible = True
	Dim target_id_btn As Label = Sender
	Dim target_id As String = target_id_btn.Tag
	Dim total_count As String = target_id_btn.Text
	target_id_display.Text = target_id
	target_countLabel.Text = total_count 
End Sub

Sub totalTargetTitle_Click
	popupPanel.Visible = True
	Dim target_id_btn As Label = Sender
	Dim target_id As String = target_id_btn.Tag
End Sub

Sub closeButton_Click
	popupPanel.Visible = False
End Sub

Sub responsiveLabel(label As Label) As Int
	Dim charWidth As Int = 10dip
	Dim padding As Int = 10dip
	Dim homeWidth As Int = (label.Text.Length * charWidth) + padding
	Return homeWidth
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

Sub nxtBtn_Click
	currentPage = currentPage + 1
	Log($"Next page: ${currentPage}"$)
	LoadCompanyDataBranchGraph ' Updates graph
	LoadCompanyData ' Updates panels
End Sub

Sub backbtn_Click
	If currentPage > 1 Then
		currentPage = currentPage - 1
		Log($"Previous page: ${currentPage}"$)
		LoadCompanyDataBranchGraph ' Updates graph
		LoadCompanyData ' Updates panels
	End If
End Sub


Sub defBtn_Click
	Dim btn As Button = Sender ' Get the button that was clicked
	Dim index As String = btn.Tag
	sortDefaultValue = ""
	LoadCompanyData
	Log(index)
	Log("(default)")

	
	'Activity.Finish
	'StartActivity(Me)
End Sub


Sub sortBtn2_Click
	Dim chk As RadioButton = Sender
	Dim index As String = chk.Tag
	sortDefaultValue = index.ToLowerCase
	LoadCompanyDataBranchGraph
	Log($"sort value: ${sortDefaultValue}"$)
End Sub



Sub sortBtn1_Click
	Dim chk As RadioButton = Sender
	Dim index As String = chk.Tag
	
	sortDefaultValue = index.ToLowerCase
	Log($"sort value: ${sortDefaultValue}"$)
	LoadCompanyDataBranchGraph
End Sub

Sub salesBtn1_Click
	Dim btn As Button = Sender
	Dim index As String = btn.Tag
	salesData1 = index.ToLowerCase
	If sortDefaultValue="asc" Or sortDefaultValue="desc" Then
		LoadCompanyDataBranchGraph
	End If
	Log(sortDefaultValue)
	Log(" sales 1 Button clicked: " & index)
End Sub

Sub salesBtn2_Click
	Dim btn As Button = Sender ' Get the button that was clicked
	Dim index As String = btn.Tag
	salesData1 = index.ToLowerCase
	If sortDefaultValue="asc" Or sortDefaultValue="desc" Then
		LoadCompanyDataBranchGraph
	End If
	Log(sortDefaultValue)
	Log(index)
	Log("(Sale2)")
End Sub
Sub salesBtn3_Click
	Dim btn As Button = Sender ' Get the button that was clicked
	Dim index As String = btn.Tag
	salesData1 = index.ToLowerCase
	If sortDefaultValue="asc" Or sortDefaultValue="desc" Then
		LoadCompanyDataBranchGraph
	End If
	Log(sortDefaultValue)
	'LoadCompanyData1
	Log(index)
	Log("(Sale3)")
End Sub


Public Sub showHideBtn_Click
'	hideShowPanel.Visible= False
	If showHide = True Then
		showHide = False
	Else
		showHide = True
	End If
	LoadCompanyData
End Sub

Sub AddBottomBorderToLabel(lbl As EditText)
	' Create a bitmap for the label's background
	Dim bmp As Bitmap
	bmp.InitializeMutable(lbl.Width, lbl.Height)
    
	' Draw on the bitmap with a Canvas
	Dim cvs As Canvas
	cvs.Initialize2(bmp)
	cvs.DrawLine(0, lbl.Height - 2dip, lbl.Width, lbl.Height - 2dip, Colors.Black, 2dip) ' Draw bottom border
    
	' Set the bitmap as the label's background
	Dim bd As BitmapDrawable
	bd.Initialize(bmp)
	lbl.Background = bd
End Sub