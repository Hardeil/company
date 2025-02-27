B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.1
@EndOfDesignText@
Sub Class_Globals
	Private checkBoxes() As CheckBox
	Private checkedSales() As Boolean
    
	' Global variables to store DrawGraph parameters
	Private Active As Activity
	Private barPanel As Panel
	Private nxtBtn As Button
	Private backBtn As Button
	Private sales() As Int
	Private sales1() As Int
	Private sales2() As Int
	Private comName() As String
	Private maxSale As Int
End Sub

Public Sub Initialize(Active1 As Activity, barPanel1 As Panel, nextBtn As Button, bckBtn As Button, sales_1() As Int, sales_2() As Int, sales_3() As Int, comName1() As String, maxSale1 As Int, legend() As String)
	' Store parameters in global variables
	Active = Active1
	barPanel = barPanel1
	nxtBtn = nextBtn
	backBtn = bckBtn
	sales = sales_1
	sales1 = sales_2
	sales2 = sales_3
	comName = comName1
	maxSale = maxSale1

	Dim legendCount As Int = legend.Length
	checkBoxes = Array As CheckBox()
	checkedSales = Array As Boolean()
	Dim checkBoxes(legendCount) As CheckBox
	Dim checkedSales(legendCount) As Boolean

	Dim legendPanel As Panel
	legendPanel.Initialize("")
	legendPanel.Width = Active.Width
	legendPanel.Height = 50dip
	Active1.AddView(legendPanel, (barPanel1.Width/3.5), barPanel1.Top + 5dip, barPanel1.Width/1.5, 50dip)

	Dim Color() As Int = Array As Int(Colors.Red, Colors.Green, Colors.Blue)
	Dim legendWidth As Int = legendPanel.Width / legend.Length

	For i = 0 To legendCount - 1
		Dim chk As CheckBox
		chk.Initialize("chkChange") ' Ensure correct event name
		chk.Text = legend(i)
		chk.TextSize = 10
		chk.Typeface = Typeface.MONOSPACE
		chk.TextColor = Color(i)
		chk.Tag = i
		chk.Checked = True ' Initially checked
        
		legendPanel.AddView(chk, (legendWidth * i) + 10dip, 5dip, legendWidth - 20dip, 40dip)
		checkBoxes(i) = chk
		checkedSales(i) = True
	Next
	DrawGraph
End Sub

Sub DrawGraph()
	' Call DrawGraph with stored global variables
	DrawGraph1(Active, barPanel, nxtBtn, backBtn, sales, sales1, sales2, comName, maxSale)
End Sub

Sub chkChange_CheckedChange(Checked As Boolean)
	If Sender Is CheckBox Then
		Dim chk As CheckBox = Sender
		Dim index As Int = chk.Tag
        
		Dim checkedCount As Int = 0
		For i = 0 To checkedSales.Length - 1
			If checkedSales(i) = True Then checkedCount = checkedCount + 1
		Next
        
		If Checked = False And checkedCount = 1 Then
			chk.Checked = True
			Return
		End If
        
		checkedSales(index) = Checked
		DrawGraph ' Call DrawGraph without parameters
	Else
		Log("Error: Sender is not a CheckBox")
	End If
End Sub

Public Sub DrawGraph1(Active1 As Activity,barPanel1 As Panel,nextBtn As Button,bckBtn As Button,sales_1() As Int,sales_2() As Int,sales_3() As Int,comName1() As String,maxSale1 As Int)
	barPanel1.RemoveAllViews ' Clear previous drawings
    
	Dim Color() As Int = Array As Int(Colors.Red, Colors.Green, Colors.Blue)
	Dim activityPanel As Panel
	activityPanel.Initialize("")
	activityPanel.Width = 75%x
	If Active1.Width >800 Then
		activityPanel.Width = 70%x
	End If
	activityPanel.Height = 250dip
	activityPanel.Color = Colors.ARGB(70, 211, 211, 211)

	Dim alignLeftCenter As Int = 0 ' Ensure left alignment when one dataset is checked
	If checkedSales.Length > 1 Then
		alignLeftCenter = (barPanel1.Width - activityPanel.Width) / 2
	End If

	Dim alignTopCenter As Int = (barPanel1.Height - activityPanel.Height) / 2
	Dim btnLeft As Int = 0

	bckBtn.Initialize("backBtn")
	bckBtn.Color = Colors.ARGB(50,0,0,0)
	If Active1.Width > 800 Then
		btnLeft = (alignLeftCenter/2)
	Else
		btnLeft = (alignLeftCenter/2)-30dip
	End If
	barPanel1.AddView(bckBtn,btnLeft,(barPanel1.Height/2)-10dip,30dip,30dip)
	
	nextBtn.Initialize("nxtBtn")
	nextBtn.Color = Colors.ARGB(50,0,0,0)
	barPanel1.AddView(nextBtn,activityPanel.Width+(alignLeftCenter)+15dip,(barPanel1.Height/2)-5dip,30dip,30dip)
	
	If sales_1.Length <= 10 Then
		nextBtn.Visible = False
		bckBtn.Visible = False
	End If
	
	Dim titleLabel As Label
	titleLabel.Initialize("")
	titleLabel.Text="Total Sales For Each Company"
	titleLabel.Gravity = Gravity.CENTER
	titleLabel.Typeface = Typeface.MONOSPACE
	titleLabel.TextSize = 20
	titleLabel.TextColor = Colors.Black
	barPanel1.AddView(titleLabel,0,alignTopCenter - 40dip,barPanel1.Width, 50dip)
	
	barPanel1.AddView(activityPanel, alignLeftCenter, alignTopCenter, activityPanel.Width, activityPanel.Height)

	Dim graphCanvas As Canvas
	graphCanvas.Initialize(activityPanel)

	maxSale1 = maxSale1 * 1.2
	Dim totalProducts As Int = sales_1.Length
	Dim barsPerProduct As Int = 3
	Dim gap As Int = 15dip
	Dim productGap As Int = 5dip
	Dim padding As Int = 0 ' Remove left padding when only one dataset is checked

	' Draw Left-Side Labels (10 labels from 0 to maxSale)
	Dim numLabels As Int = 10
	Dim labelStep As Int = maxSale1 / numLabels
	Dim labelHeightStep As Int = activityPanel.Height / numLabels

	For i = 0 To numLabels
		Dim lblY As Int = activityPanel.Height - (i * labelHeightStep) + alignTopCenter - 10dip
		Dim lblValue As Int = i * labelStep

		Dim lblLeft As Label
		lblLeft.Initialize("")
		lblLeft.Text = FormatNumberWithLabel(lblValue)
		lblLeft.TextColor = Colors.Black
		lblLeft.Gravity = Gravity.RIGHT
		lblLeft.Typeface = Typeface.MONOSPACE
		lblLeft.TextSize = 10
		lblLeft.Color = Colors.Transparent

		barPanel1.AddView(lblLeft, alignLeftCenter - 45dip, lblY, 40dip, 20dip)
	Next

	Dim checkedCount As Int = 0
	For i = 0 To checkedSales.Length - 1
		If checkedSales(i) Then checkedCount = checkedCount + 1
	Next

	Dim availableWidth As Int = activityPanel.Width - ((totalProducts - 1) * productGap)
	Dim barWidth As Int = availableWidth / (totalProducts * checkedCount)
	
	If sales_1.Length <= 4 Then
		barWidth = 30dip
	End If
	If Active1.Width > 800 Then
		If checkedCount =1 Then
			barWidth = 30dip
			productGap = 45.5dip
		End If
	Else
		If checkedCount =1 Then
			barWidth = 30dip
			productGap = 18dip
		End If
	End If

	
	Dim xStart As Int = 5dip ' Start from left when only one dataset is checked

	
	For i = 0 To totalProducts - 1
		Dim xPos As Int = xStart + (i * (checkedCount * barWidth + productGap))
		Dim saleValues() As Int = Array As Int(sales_1(i), sales_2(i), sales_3(i))
    
		Dim indexOffset As Int = 0 ' Shift bars properly based on checked datasets
    
		For j = 0 To barsPerProduct - 1
			If j < checkedSales.Length And checkedSales(j) Then
				Dim sale As Int = saleValues(j)
				Dim barHeight As Int = (sale / maxSale1) * activityPanel.Height
				Dim xBar As Int = xPos + indexOffset * barWidth
            	
				' Draw sale value above the bar
				Dim lblSale As Label
				lblSale.Initialize("")
				lblSale.Text = FormatNumberWithSuffix(sale) ' Display sale value
				lblSale.TextColor = Colors.Black
				lblSale.Gravity = Gravity.CENTER
				lblSale.Typeface = Typeface.MONOSPACE
				lblSale.TextSize = 7
				lblSale.Color = Colors.Transparent
				If Active1.Width > 800 Then
					If checkedCount > 2 Then
						lblSale.TextSize = 5
					End If
				Else
					If checkedCount =3 Then
						lblSale.TextSize = 4
					End If
					If checkedCount =2 Then
						lblSale.TextSize =3.8
					End If
				End If
		
				Dim lblSaleLeft As Int = xBar + alignLeftCenter ' Align with the bar
				Dim lblSaleTop As Int = activityPanel.Height - barHeight - 15dip  + alignTopCenter

				barPanel1.AddView(lblSale, lblSaleLeft, lblSaleTop, barWidth, 15dip)

				
				' Draw bar
				Dim r As Rect
				r.Initialize(xBar, activityPanel.Height - barHeight, xBar + barWidth, activityPanel.Height)
				graphCanvas.DrawRect(r, Color(j), True, 2dip)

				indexOffset = indexOffset + 1 ' Increase offset only for checked datasets
			End If
		Next
		Dim lblCompany As Label
		lblCompany.Initialize("")
		lblCompany.Text = comName(i)
		lblCompany.TextColor = Colors.Black
		lblCompany.Gravity = Gravity.CENTER
		lblCompany.Typeface = Typeface.MONOSPACE
		lblCompany.TextSize = 10
		lblCompany.Color = Colors.Transparent
		If Active1.Width <= 800 Then
			lblCompany.TextSize = 7
			If checkedCount = 1 Then
				lblCompany.TextSize = 8
			End If
		End If
		Dim totalBarWidth As Int = checkedCount * barWidth ' Total width of bars for one company
		Dim lblCompanyWidth As Int = totalBarWidth ' Set label width to match bar width
		Dim lblCompanyLeft As Int = xPos + (totalBarWidth / 2) - (lblCompanyWidth / 2) + alignLeftCenter' Center label under bars
		If checkedCount =1 Then
			lblCompanyWidth = productGap
			lblCompany.Gravity = Gravity.LEFT
			lblCompanyWidth = productGap + barWidth
		End If
		
		Dim lblCompanyTop As Int = activityPanel.Height + 5dip + alignTopCenter

		barPanel1.AddView(lblCompany, lblCompanyLeft, lblCompanyTop, lblCompanyWidth, 15dip)
		
	Next
	
End Sub



Sub DrawWrappedTextRotated(canvas As Canvas, text As String, x As Int, y As Int, maxWidth As Int, fontSize As Float, color As Int, alignment As String, angle As Float) As Int
	Dim words() As String = Regex.Split(" ", text)
	Dim line As String = ""
	Dim lineHeight As Int = 20dip ' Space between lines
	Dim originalY As Int = y ' Store original Y position

	For Each word As String In words
		Dim testLine As String = line & word & " "
		Dim textWidth As Int = canvas.MeasureStringWidth(testLine, Typeface.MONOSPACE, fontSize)

		If textWidth > maxWidth And line <> "" Then
			' Draw the current line
			canvas.DrawTextRotated(line, x, y, Typeface.DEFAULT_BOLD, fontSize, color, alignment, angle)
			y = y + lineHeight ' Move to next line
			line = word & " " ' Start new line
		Else
			line = testLine ' Add word to current line
		End If
	Next

	' Draw the last line
	If line <> "" Then
		canvas.DrawTextRotated(line, x, y, Typeface.DEFAULT_BOLD, fontSize, color, alignment, angle)
		y = y + lineHeight ' Move final Y position
	End If

	' Return the new height
	Return y - originalY
End Sub

Sub FormatNumberWithSuffix(number As Int) As String
	If number >= 1000000 Then
		Return NumberFormat(number / 1000000, 1, 1) & "M"
	Else If number >= 1000 Then
		Return NumberFormat(number / 1000, 1, 1) & "k"
	Else
		Return NumberFormat(number, 1, 0)
	End If
End Sub

Sub FormatNumberWithLabel(number As Int) As String
	If number >= 1000000 Then
		Return Floor(number / 1000000) & "M"
	Else If number >= 1000 Then
		Return Floor(number / 1000) & "k"
	Else
		Return Floor(number)
	End If
End Sub
