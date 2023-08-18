PL<br>
<h3>System Zarządzania Recepcją Hotelową</h5>

Projekt aplikacji desktopowej połączonej z lokalną bazą danych do obsługi recepcji obiektów turystycznych. <br>
Aplikacja pozwala na zarządzanie rezerwacjami oraz rozliczeniami gości hotelowych, zarządzanie klientami oraz ich danymi, pracownikami, pokojami oraz wyświetla łączne statystyki obiektu i rezerwacji. <br>
Środowiskiem programistycznym był Netbeans IDE 15, MySQL Workbench 8.0 a diagramy jak i sam projekt bazy danych zostały stworzone w Oracle SQL Developer Data Modeler.<br>
<h4>Stworzony z wykorzystaniem Javy i SQL.<br></h4>
<br>ENG

<h3>Hotel Reception Managment System</h5>

<br>Desktop application project connected to a local database for managing reception tasks in tourist facilities.
<br>The application allows for managing hotel guest reservations and financial settlements, client management and their data, employees, rooms, and displays comprehensive facility and reservation statistics.<br>
The programming environment used was Netbeans IDE 15, MySQL Workbench 8.0, and the diagrams as well as the database project itself were created in Oracle SQL Developer Data Modeler<br>
<h4>Created with Java & SQL.</h4>

 <h2> Presentation</h2>
⚠️ All the data of customers in the database is random and does not correspond to real-life information. <br>
⚠️ SQL Diagrams are shown at the end of presentation.
<h2>🍏 Logging screen </h2> 
<h3>We can log in using our login and password, however if we are logging for the first time (when our login is in database inserted by admin) we choose "First Login" button to set our password.</h3>

![image](https://github.com/hubost/SystemZarzadzaniaRecepcja/assets/103451733/fb9cb8de-e75c-4448-acbd-d2e297e34522)


<h2>📗Menu View </h2>
<h3>We can freely navigate through the panels by clicking on their names. As an admin we are able to manage the employees data with button redirecting to employees panel.</h3>


![image](https://github.com/hubost/SystemZarzadzaniaRecepcja/assets/103451733/6c5be329-bbf3-407a-a2da-e8280f8c5ac5)
<br>
<h2>👨‍💼Employee Manage Panel</h2>
<h3>We can find employees in database by their ID or PESEL number. We are allowed to edit, remove and add new employees. Fields such as phone number and PESEL cannot be empty and must have the correct format.</h3>


![image](https://github.com/hubost/SystemZarzadzaniaRecepcja/assets/103451733/f9531b61-7e2a-4716-bb9c-484ead40e532)
<br>
<h2>👱‍♂️Customer Manage Panel (Customer List)</h2>
<h3>Most of the panels are divided into smaller tabs with different purposes. The first one is customer list, where we can see all the customers information. We are able to sort and filter the returned data. </h3>


![image](https://github.com/hubost/SystemZarzadzaniaRecepcja/assets/103451733/9ce3b530-73e8-4096-88d3-9e2d6af8d620)
<br>
<h2>👱‍♂️Customer Manage Panel (Edit or delete customer)</h2>
<h3>In this tab we can find customer by database ID shown in Check List tab or PESEL number and manage his information either by edit or delete.</h3>


![image](https://github.com/hubost/SystemZarzadzaniaRecepcja/assets/103451733/75b4fd24-304d-4f97-8252-a15ddb026932)
<br>
<h2>📚Room Manage Panel (Room List) </h2>
<h3>With the list we have current data about the room statuses. We can sort by the number of people and price per night. We also can filter by room condition (Available, Occupied, Out of order)</h3>


![image](https://github.com/hubost/SystemZarzadzaniaRecepcja/assets/103451733/682c097d-dee8-4ee6-bd1e-7df1c1f86427)
<br>
<h2>📚Room Manage Panel (Add new room)</h2>
<h3>In this tab we can insert new rooms into the database with choosing the amount of beds, preffered amount of people or cost per night.</h3>

![image](https://github.com/hubost/SystemZarzadzaniaRecepcja/assets/103451733/96716f5f-420a-4321-9a82-5fc610b478df)
<br>
<h2>📞Reservation Manage Panel (Reservation List)</h2>
<h3>The window presents us with a customer list along with all the necessary information. The list informs us about the number of nights, total cost, date, and whether the reservation has been settled. We can sort the results by date, customer name, or settlement.</h3>

![image](https://github.com/hubost/SystemZarzadzaniaRecepcja/assets/103451733/f931b2ff-df9b-4939-8b47-c95cdae9a4e2)
<br>
<h2>📞Reservation Manage Panel (Make a Reservation)</h2>
<h3>In the following tab, we can make a reservation using either the ID or the PESEL number of the customer. After selecting the number of people and the check-in/check-out dates, available rooms along with their prices are displayed. Upon selecting a room, a summary will be shown, and after reviewing it, we can confirm the reservation.</h3>

![image](https://github.com/hubost/SystemZarzadzaniaRecepcja/assets/103451733/00790a69-ce3d-472a-bfd1-7be257cc123d)
<br>
<h2>💸Settlement Panel</h2>
<h3>IIn the settlement window, we have the option to settle a customer's reservation. We can search for it using the ID, PESEL number of the customer, room number or reservation ID. <br>
If the settlement is successful, the reservation is recorded in the database as history, and the room status is updated to available.</h3>

![image](https://github.com/hubost/SystemZarzadzaniaRecepcja/assets/103451733/2356314c-c69c-4be5-b1ff-4bf7b4dc2e8b)
<br>
<h2>🗒️ Statistics Panel (Reservation List)</h2>
<h3>The last panel is the statistics panel. It displays general property statistics and allows for a quick overview of room statuses. It includes, among other things, the average cost, average length of stay, and average age of customers with a breakdown by gender.</h3>

![image](https://github.com/hubost/SystemZarzadzaniaRecepcja/assets/103451733/7fee05f6-e492-422c-9fbd-fcd4015d8533)

