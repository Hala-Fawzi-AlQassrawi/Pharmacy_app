# **My Pharmacy App**   <img height="30" src="https://github.com/user-attachments/assets/184db0f2-4d9e-405e-b62f-79974591b991">

 It is a mobile phone application that works on devices that run on the Android operating system. The user enters the medication and it is stored in a database in a file on the device itself. All stored medications are later displayed within the application or based on the type of medication, with the possibility of deleting the medication from the list.
## Details
* **main activity** : Shows a picture of the pharmacy
Two buttons: The first button moves to the interface for adding medications, while the second button moves to the interface for displaying the medication
* **add activity** : The user enters the drug data (name, type, price, available quantity) to be stored in the database
When the storage process is completed successfully, the application sends a notification to the user that the task has been completed
* **choose activity** : Through it, the method of displaying medications is determined, and it is either the display of all medications 
Or display them by type
* **view activity** :All medications stored within the database are displayed in a custom grid type list with the ability to delete items from it. The application displays a dialog box for the user to confirm the deletion process.
* **search activity** :Medicines are searched based on the type that is selected from (radio button  <img height="10" src="https://github.com/user-attachments/assets/8e1f3a4d-a091-4d1a-a53f-5b51b6595e21">  )

## Technologies <img height="25" src="https://github.com/user-attachments/assets/79b77200-ac9e-42c0-ae7d-c92de99a1e43">
Project is created with:
* kotlin 
* xml
* SQLite
 
