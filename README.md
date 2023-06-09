## Section C: Customize the HTML user interface

### Change C1

**Prompt**: The user interface should include the shop name.

- File: `mainscreen.html`
- Line: 14 (title)
    - Change: Changed the title from 'My Bicycle Shop' to 'PerfectPens Shop'.
- Line: 19 (header)
    - Change: Changed the header from 'Shop' to 'PerfectPens'.

### Change C2

**Prompt**: The user interface should include the product names, and the names of the parts.

- File: `mainscreen.html`
- Lines: 41-92 (parts table body)
    - Change: Updated the parts list to add 'Red Paint', 'Yellow Paint', 'Blue Paint', 'Ink Refill', and 'Pen Body'.
- Lines: 118-179 (products table body)
    - Change: Updated the products list to add 'Red Pen', 'Orange Pen', 'Yellow Pen', 'Green Pen', 'Blue Pen', and 'Purple Pen'.

## Section D: Add and About page

### Change D1

**Prompt**: Add an 'About' page to the application to describe your chosen customer’s company.

- File: `about.html`
- Lines 1-22
  - Change: Created an about page.
- Line 19
  - Change: Added description of company.

### Change D2

**Prompt**: Include navigation for the 'About' page on the main screen.

- File: `mainscreen.html`
- Lines 21-24
  - Change: Added a button on the main page that links to the newly created about page.

-File: `MainControllerr.java`
- Lines 55-58
  - Change: Added a mapping method to the main controller handle the request for the about page.

### Change D3

**Prompt**: Include navigation for the main screen on the 'About' page.

-File: `about.html`
- Line 12
  -Change: Added a button on the about page that links back to the main page.

## Section E: Add sample inventory

### Change E1

**Prompt**: Add a sample inventory appropriate for your chosen store to the application.

-File: 'MainScreenControllerr.java'
- Lines 57-87
  - Change: Defined the addSampleInventory() method.
- Lines 45-46
  - Change: Called addSampleInventory() inside listPartsAndProducts() method.

File: 'Part.java'
- Line 22
  - Change: Removed abstract from Part class so that it can be instantiated.

File: 'mainscreen.html'
- Lines 96-105
  - Change: Fixed the Parts table so that Parts added by button on main screen will display.
- Lines 193-202
  - Change: Fixed the Products table so that Products added by button on main screen will display.

## Section F: Add buy now button

### Change F1

**Prompt**: Add 'Buy Now' button next to the buttons that update and delete products.

-File: 'mainscreen.html'
- Lines 17-18
  - Change: Imported RequestParam and Nullable to be able to request itemId and allow the parameters to allow
            null values.
- Lines 142, 153, 164, 175, 186, 197, 208
  - Change: Added a 'Buy Now' button next to the 'Update' and 'Delete' buttons for each product.

### Change F2

**Prompt**: 'Buy Now' button should decrement the quantity of the product by one.

-File: 'MainScreenControllerr.java'
- Lines 13-14
 - Change: Imported RequestParam and Nullable
- Lines 99-118
 - Change: Defined the buyProduct() method.
- Lines 46-55
 - Change: Added the ability to accept null values for partkeyword and productkeyword.

### Change F3

**Prompt**: Display a message that indicates the success or failure of a purchase.

-File: MainScreenControllerr.java
- Lines 103-114
  - Change: Added a message to buyProduct() that displays whether or not the purchase was successful.

-File: 'mainscreen.html'
- Lines 108-111
    - Change: Added a div to display the appropriate message from the controller.

## Section G: Minimum and maximum inventory tracking

### Change G1

**Prompt**: Add additional fields to the part entity for maximum and minimum inventory.

-File: 'Part.java'
- Lines 31-36
  - Change: Added the fields for max and min inventory to the Part class definition.
- Lines 50-51, 58-59
  - Change: Added minInv and maxInv to the other Part constructors.
- Lines 95-106
  - Change: Added getters and setters for max and min inventory.

### Change G2

**Prompt**: Modify the sample inventory to include the maximum and minimum fields.

-File: 'MainScreenControllerr.java'
- Lines 71-75
  - Change: Added max and min inventory values to the sample inventory.

-File: 'mainscreen.html'
- Lines 42-43
  - Change: Added min and max inventory columns to the parts table.
- Lines 52-53, 64-65, 76-77, 88-89, 100-101, 112-113
  - Change: Added min and max inventory fields for sample inventory.
- Line 108
  - Change: Changed from th:if != to th:unless after accidentally erasing the former from my code.

### Change G3

**Prompt**: Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user
            can set the maximum and minimum values.

File: 'InhousePartForm.html'
- Lines 23-28
  - Change: Added max and min inventory fields to the InhousePartForm.

File: 'OutsourcedPartForm.html'
- Lines 25-31
  - Change: Added max and min inventory fields to the OutsourcedPartForm.

### Change G4

**Prompt**:  Rename the file the persistent storage is saved to.

File: 'application.properties'
- Line 6
  - Change: Changed the name of persistent storage file from spring-boot-h2-db101 to perfectpensDB.

### Change G5

**Prompt**: Modify the code to enforce that the inventory is between or at the minimum and maximum value.

File: 'Part.java'
- Lines 92-112
  - Change: Edited setMinInv() and setMaxInv() to automatically set the inventory to the min or max value if the user
            tries to set the inventory to a value outside below or above the respective ranges.

## Section H: Add validation for minimum and maximum values

### Change H1

**Prompt**: Display error messages for low inventory when adding and updating parts 
            if the inventory is less than the minimum number of parts.

-File: 'AddInhousePartController.java'
- Lines 40-59
  - Change: Edited submitForm() to display an error message if the user tries to add a part with an inventory below the
            minimum inventory.

-File: 'InhousePartForm.html'
- Lines 21-27
  - Change: Added a div to display the inventory error message provided by InhousePartController.

-File: 'AddOutsourcedPartController.java'
- Lines 45-64
  - Change: Edited submitForm() to display an error message if the user tries to add a part with an inventory below the
            minimum inventory.

-File: 'OutsourcedPartForm.html'
- Lines 22-28
    - Change: Added a div to display the inventory error message provided by OutsourcedPartController.

-File: 'Part.java'
- Lines 96, 105
  - Change: Removed automatic setting of inventory to min or max value if the user tries to set the inventory to a value
            below or above the min or max value so that validation can be done in the controller.

### Change H2

**Prompt**: Display error messages for low inventory when adding and updating 
            products lowers the part inventory below the minimum.

-File: 'EnufPartsValidator.java'
 -Lines 36-50
  -Change: Edited the validator to compare the inventory of parts associated with a product against the minimum 
          inventory set for the part instead of comparing it agaianst zero.

### Change H3

**Prompt**: Display error messages when adding and updating parts if the inventory is greater than the maximum

-File: 'AddInhousePartController.java'
- Lines 48-50
  - Change: Added to the loop in submitForm() to display an error message if the user tries to add a part 
            with an inventory above the maximum inventory.

-File: 'AddOutsourcedPartController.java'
- Lines 50-52
  - Change: Added to the loop in submitForm() to display an error message if the user tries to add a part with an 
            inventory above the maximum inventory.

## Section I: Add unit tests

**Prompt**: Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

-File: 'PartTest.java'
- Lines 159-195
  - Change: Added unit tests for the minimum and maximum inventory fields.

## Section J: Remove unused validators and clean code

**Prompt**:  Remove the class files for any unused validators in order to clean your code.

-File: 'README.md'
- Lines 233-241
  - Change: Because I edited EnufPartsValidator to compare associated products against their minimum inventories instead
            of zero, there was no need to remove any unused validators as @ValidDeletePart and @ValidProduct are both
            used.

### Aesthetic Changes

-File: 'demo.css'
- Lines 1-4
  - Change: Changed background and foreground element colors
- Lines 6-7
  - Change: Adjusted max width and margin of containers
- Lines 11-14
  - Change: Changed color of h1 and h2 and center aligned them.
- Lines 16-18
    - Change: Changed table foreground element color.
- Lines 20-24
    - Change: Changed border color display elements of btn buttons.
- Lines 26-30
  - Change: Changed width, margin, and alignment of .form-container elements.
- Lines 32-34
  - Change: Changed alignment of button-container elements.
- Lines 36-42
  - Change: Changed alignment of form-container elements.
- Lines 44-55
    Change: Changed display properties of .btn-custom elements.
-  Lines 57-60
  - Change: Changed alignment and margin of about page container.
- Lines 62-68
  - Change: Changed border, width, color, etc. of about-content elements.

-File: 'about.html'
- Lines 7-8
  - Change: Linked demo.css
- Lines 17-32
  - Change: Centered content and made the home link a button.

-File: 'mainscreen.html'
- Lines 14-16
  - Change: Linked demo.css.
- Lines 20, 254
  - Change: Added a div with main-content class to better control the display of its contents.
- Lines 25-28
  - Change: Changed the appeareance of my about page button.
- Line 31
  - Change: Changed alignment of the forms.
- Lines 34-38, 144-148
  - Change: Changed appearance of search and clear buttons.
- Lines 41-44, 144-148 156-157
  - Change: Changed appearance of add inhouse/outsourced part buttons and add product button.
- Lines 65-66, 78-79, 91-92, 104-105, 117-118, 130-131, 175-176, 187-188, 199-200, 211-212, 223-224, 235-236, 247-248
    - Change: Changed the color of the delete buttons to red.

-File: 'inhousepartform.html'
- Lines 8-9
  - Change: Linked demo.css.
- Line 13
  - Change: Added a header row.
- Lines 18-21, 23-27, 30-31, 38-34, 44-48, 50-53
  - Change: Edited the forms to add labels for the input fields and changed the input fields that accet numbers to
            number input fields.
- Lines 59-62
  - Change: Added a back to main screen button.

-File: 'outsourcedpartform.html'
- Lines 8-9
    - Change: Linked demo.css.
- Line 13
    - Change: Added a header row.
- Lines 20-23, 25-28, 32-33, 41-45, 47-51, 53-56
    - Change: Edited the forms to add labels for the input fields and changed the input fields that accet numbers to
      number input fields.
- Lines 60-64
    - Change: Added a back to main screen button.

-File: 'productform.html'
- Line 2
  - Change: Combined the two html tags.
- Lines 8-9
  - Change: Linked demo.css.
- Lines 16, 44
  - Change: Wrapped the form in a div with class form-container.
- Lines 15, 50, 73
  - Change: Added header rows.
- Lines 16-17, 21-24, 27-30, 32-35
  - Change: Edited the forms to add labels for the input fields and changed the input fields that accet numbers to
            number input fields.
- Lines 70, 92
  - Change: Wrapped the table in a div with class table-container.
- Lines 96-98
  - Change: Added a back to main screen button.

    
### Functional Changes Because of Mistakes

-File: 'InHousePart.java'
- Lines 19-21
  - Change: Added minInv and maxInv to the constructor.

-File: 'OutsourcedPart.java'
- Lines 19-21
  - Change: Added minInv and maxInv to the constructor.

-File: 'Part.java'
- Line 22
  - Change: Changed Part class back to abstract after figuring out I should have instantiated the sample inventory
            as InhousePart or OutsourcedPart objects instead of Part objects.

-File: 'MainScreenControllerr.java'
- Lines 3-6, 19
  - Change: Imported necessary classes and Autowired package.
- Lines 38-43
  - Change: Instatiated services and added @Autowired annotation to the constructor.
- Lines 82-86, 88-92
  - Change: Changed the instantiation of the sample inventory to InhousePart or OutsourcedPart objects instead of Part
            objects.
- Lines 100, 107
  - Change: Commented out purplePen product so that I would have exactly five products in the sample inventory just in 
            case having six products violated the requirements of the project.

### Revision Changes

## EnufPartsValidator corrections

-File: 'EnufPartsValidator.java'
- Lines 36-39
  - Change: Edited the isValid() method to assign myProduct = product if the product ID is zero.
- Lines 40-47
  - Change: Edited isValid() to check against the associated part's minimum inventory
- Lines 47-51
  - Change: Edited the error message to give a more detailed display of what the minimum inventory for the associated
            in addition to the previous error message.

## AddProductController inventory setting corrections

-File: 'AddProductController.java'
- Line 83
  - Change: Removed setInv(0) from submitForm() so the inventory could be appropriately set when adding a product.

## Changes to price fields of HTML forms

-File: 'InHousePartForm.html'
- Line 25
  - Change: Added step="0.01 so the price field can accept decimal values.

-File: 'OutsourcedPartForm.html'
- Line 27
  - Change: Added step="0.01 so the price field can accept decimal values.

-File: 'productForm.html'
- Line 29
    - Change: Added step="0.01 so the price field can accept decimal values.

## Aesthetic Corrections

-File: 'mainscreen.html'
- Lines 77-79
  - Change: Corrected the color of the update and delete buttons as they were switched mistakenly.