B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.1
@EndOfDesignText@
Sub Class_Globals
	Private checkBoxes() As CheckBox
	Private checkedSales() As Boolean
	
	Dim color() As Int = Array As Int(Colors.RGB(255, 0, 0), Colors.RGB(200, 20, 20), Colors.RGB(100, 10, 10))
	Dim legendPanel As Panel
	Dim Active1 As Activity 
	Dim panel_l As Panel
	Dim sale_1() As Int
	Dim sale_2() As Int
	Dim sale_3() As Int
	Dim product1() As String 
	Dim legend1() As String
	Dim maxSales1 As Int = 0
	Dim titleString1 As String = ""
End Sub

Public Sub Initialize(Active As Activity, panel As Panel, sale1() As Int, sale2() As Int, sale3() As Int, product() As String , legend() As String, maxSales As Int, TitleString As String)
	Active1 = Active
	panel_l = panel
	sale_1 = sale1
	sale_2 = sale2
	sale_3 = sale3
	product1 = product
	legend1 = legend
	maxSales1 = maxSales
	titleString1 = TitleString
	
	legendPanel.Initialize("")
	legendPanel.Width = panel.Width
	legendPanel.Height = 30dip
	
	Dim legendWidth As Int = legendPanel.Width / legend.Length
	checkBoxes = Array As CheckBox()
	checkedSales = Array As Boolean()
    
	Dim checkBoxes(sale1.Length) As CheckBox   ' Resize global arrays
	Dim checkedSales(sale1.Length) As Boolean
	For i = 0 To legend.Length - 1
		'Dim colorLabel As Label
		'colorLabel.Initialize("")
		'colorLabel.Color = color(i)
		'legendPanel.AddView(colorLabel, (legendWidth * i)+20dip, 10dip, 10dip, legendPanel.Height-18dip)

		Dim legendLabel As CheckBox
		legendLabel.Initialize("chkChange")
		legendLabel.Text = legend(i)
		legendLabel.TextColor = color(i)
		legendLabel.Gravity = Gravity.CENTER
		legendLabel.Checked = True
		legendPanel.AddView(legendLabel, (legendWidth * i) + 30dip, 0dip, legendWidth - 30dip, legendPanel.Height)

		legendLabel.Tag = i ' Assign the index as the Tag value
		checkBoxes(i) = legendLabel ' Store reference in global array
		checkedSales(i) = True ' Ensure the checkbox is set as checked
	Next

	DrawGraph(Active, panel, sale1, sale2, sale3, product, maxSales, TitleString)
End Sub
Sub DrawGraph(Active As Activity, panel As Panel, sale1() As Int, sale2() As Int, sale3() As Int, product() As String , maxSales As Int, TitleString As String)
	panel.Invalidate
	panel.RemoveAllViews
	panel.Height = 400dip
	
	panel.AddView(legendPanel, 0, 0, panel.Width, 30dip)
	Dim activityPanel As Panel
	activityPanel.Initialize("activityPanel")

	activityPanel.Width = 80%x
	If Active.Width > 800 Then
		activityPanel.Width = 55%x
	End If
	activityPanel.Height = 250dip
	activityPanel.Color = Colors.ARGB(70, 211, 211, 211)
	
	Dim alignLeftCenter As Int = (Active.Width - activityPanel.Width) / 2
	Dim alignTopCenter As Int = (panel.Height - activityPanel.Height) / 2
	
	Dim Title As Label
	Title.Initialize("")
	Title.Text = TitleString
	Title.TextSize = 20
	Title.Typeface = Typeface.MONOSPACE
	Title.Gravity = Gravity.CENTER
	Title.TextColor = Colors.Black
	Title.SendToBack
	' Add legend above the title
	
	' Add title label below the legend
	panel.AddView(Title, 0, alignTopCenter / 2, panel.Width, 30dip)
	
	' Add the panel to the activity
	panel.AddView(activityPanel, alignLeftCenter, alignTopCenter, activityPanel.Width, activityPanel.Height)

	' Create a Canvas object to draw on the panel
	Dim graphCanvas As Canvas
	graphCanvas.Initialize(activityPanel)

	' Define the maximum sale value to scale the bars accordingly
	Dim maxSale As Int = maxSales

	Dim cv As Canvas
	cv.Initialize(panel)
    
	' Draw bars
	Dim totalProducts As Int =  sale1.Length
	Dim barsPerProduct As Int = 3
	Dim totalBars As Int = totalProducts * barsPerProduct
	Dim gap As Int = 5dip
	Dim productGap As Int = 15dip
	Dim padding As Int = 20dip
    
	Dim availableWidth As Int = activityPanel.Width - (padding * 2) - ((totalProducts - 1) * productGap) - ((totalBars - totalProducts) * gap)
	Dim barWidth As Int = availableWidth / totalBars
	Dim xStart As Int = padding
    
	Dim graphCanvas As Canvas
	graphCanvas.Initialize(activityPanel)
    
	For i = 0 To totalProducts - 1
		
		Dim xPos As Int = xStart + i * (barsPerProduct * (barWidth + gap) + productGap)
		Dim saleValues() As Int = Array As Int(sale1(i), sale2(i), sale3(i))
        
		Dim indexOffset As Int = 0
		
		For j = 0 To barsPerProduct - 1
			If j < checkedSales.Length And checkedSales(j) Then
				Dim sale As Int = saleValues(j)
				Dim barHeight As Int = (sale / maxSales) * (activityPanel.Height )
				'Dim xBar As Int = xPos + j * (barWidth + gap)
				Dim xBar As Int = xPos + indexOffset * barWidth
				
				Dim r As Rect
				r.Initialize(xBar, activityPanel.Height - barHeight, xBar + barWidth, panel.Height)
				graphCanvas.DrawRect(r, color(j), True, 2dip)
	            
				' Display sales value
				Dim fontSize As Int = 8
				If Active.Width > 800 Then
					fontSize = 10
				End If
				graphCanvas.DrawText( FormatNumberWithSuffix(sale), xBar + (barWidth / 2), activityPanel.Height - barHeight - 5dip, Typeface.MONOSPACE, fontSize, Colors.Black, "CENTER")
				indexOffset = indexOffset + 1 '
			End If
			
		Next
		
		Dim productLabelY As Int = activityPanel.Height + alignTopCenter + 20dip
		Dim productLabelX As Int = alignLeftCenter + 50dip
		cv.DrawText(product(i), xPos + productLabelX, productLabelY, Typeface.MONOSPACE, 12, Colors.Black, "CENTER")
	Next
	Dim numLabels As Int =10
	For i = 0 To numLabels
		Dim labelValue As Int = Round((maxSales / numLabels) * i) ' Ensure whole number
		Dim labelYPos As Int = activityPanel.Height - ((labelValue / maxSale) * activityPanel.Height) ' Adjust Y position based on the scale

		' Use IntToString to avoid decimal points
		cv.DrawText(FormatNumberWithLabel(labelValue), alignLeftCenter - 10dip, labelYPos + alignTopCenter + 5dip, Typeface.MONOSPACE, 10, Colors.Black, "RIGHT")
	Next
End Sub
Sub chkChange_CheckedChange(Checked As Boolean)
	If Sender Is CheckBox Then
		Dim chk As CheckBox = Sender
        
		' Ensure the checkbox has a valid tag
		If Not(IsNumber(chk.Tag)) Then
			Log("Error: Checkbox Tag is not a valid number")
			Return
		End If

		Dim index As Int = chk.Tag
		Dim checkedCount As Int = 0
        
		' Count checked checkboxes
		For i = 0 To checkedSales.Length - 1
			If checkedSales(i) Then checkedCount = checkedCount + 1
		Next
        
		' Prevent unchecking the last checked checkbox
		If Checked = False And checkedCount = 1 Then
			chk.Checked = True
			Return
		End If
        
		' Update the checkedSales array
		checkedSales(index) = Checked
        
		' Log checkbox changes
		Log("Checkbox " & index & " changed to: " & chk.Checked)
        
		' Redraw the graph to reflect changes
		DrawGraph(Active1, panel_l, sale_1, sale_2, sale_3, product1,  maxSales1, titleString1)
		panel_l.Invalidate
	Else
		Log("Error: Sender is not a CheckBox")
	End If
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
        Return number ' No formatting needed for values below 1000
    End If
End Sub

