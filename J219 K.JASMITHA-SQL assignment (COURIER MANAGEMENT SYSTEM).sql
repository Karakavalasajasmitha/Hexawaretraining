-- TASK-1 Database Design

create database cms;
use cms;

create table user(
userid int PRIMARY KEY,name varchar(255),email varchar(225) unique,Password VARCHAR(255),
ContactNumber VARCHAR(20),Address TEXT);

insert into user values(125,"jasmitha","jasmitha@gmail.com","jessie","8975447875","ABC colony VZM");
insert into user values(126,"hemasree","hemasree@gmail.com","hema","7894561230","xyz nagar Vizag");
insert into user values(127,"varshini","varshini@gmail.com","varshu","1234567890","hitech city hyd");
insert into user values(128,"swathi","swathi@gmail.com","swathi","8931467890","devi junction skota");
insert into user values(129,"john david paul","john12@gmail.com","john","8987546120","anna nagar chennai");

-- to solve some queries these columns [service_id,employeeid,order_date,orderid] 
-- are included in courier table

create table courier(CourierID INT PRIMARY KEY,
SenderName VARCHAR(255),
SenderAddress TEXT,
ReceiverName VARCHAR(255),
ReceiverAddress TEXT,
Weight DECIMAL(5, 2),
Status VARCHAR(50),
TrackingNumber VARCHAR(20) UNIQUE,
serviceid int,employeeid int,orderdate date,orderid int,
DeliveryDate DATE);

insert into courier values(12,"jasmitha","ABC colony vzm","varshini","hitech city hyd",45.54,"delivered",1435,100,789,'2024-02-21',201,'2024-02-29');
insert into courier values(13,"varshini","hitech city hyd","jessie","abc colony vzm",58.54,"undelivered",1485,200,123,'2024-02-22',202,'2024-03-02');
insert into courier values(14,"hemasree","xyz nagar vizag","swathi","devi junction skota",85.54,"delivered",1495,300,456,'2024-02-23',203,'2024-03-9');
insert into courier values(15,"swathi","devi junction skota","john david paul","anna nagar chennai",95.54,"undelivered",1475,400,779,'2024-03-2',204,'2024-03-05');
insert into courier values(10,"john david paul","anna nagar chennai","jasmitha","abc colony vzm",46.54,"delivered",1425,500,219,'2024-02-25',205,'2024-03-10');

create table CourierServices
(ServiceID INT PRIMARY KEY,
ServiceName VARCHAR(100),
Cost DECIMAL(8, 2));

insert into CourierServices values(100,"Express Service",200.85);
insert into CourierServices values(200,"Overnight Services",500.85);
insert into CourierServices values(300,"Express Service",600.85);
insert into CourierServices values(400,"Parcel Services",700.85);
insert into CourierServices values(500,"Overnight Services",800.85);

create table Employee(EmployeeID INT PRIMARY KEY,
Name VARCHAR(255),
Email VARCHAR(255) UNIQUE,
ContactNumber VARCHAR(20),
Role VARCHAR(50),
Salary DECIMAL(10, 2));

insert into Employee values(789,"vamsi","vamsi@gmail.com","89754678152","dispatcher",10000);
insert into Employee values(123,"teja","teja@gmail.com","7849851575","dispatcher",5000);
insert into Employee values(456,"sai","sai@gmail.com","9715487542","logistics specialistsr",14000);
insert into Employee values(779,"charan","charan@gmail.com","9175124879","customer service representative",9000);
insert into Employee values(219,"surya","surya@gmail.com","7842764791","manager",25000);

create table Location
(LocationID INT PRIMARY KEY,
LocationName VARCHAR(100),
Address TEXT);

insert into location values(5320,"kothagraharam","vzm");
insert into location values(2520,"agraharam","hyd");
insert into location values(7320,"poolbagh","vzm");
insert into location values(9320,"devijunction","skota");
insert into location values(5470,"ask towers","chennai");

create table Payment
(PaymentID INT PRIMARY KEY,
CourierID INT,
LocationId INT,
Amount DECIMAL(10, 2),
PaymentDate DATE,
FOREIGN KEY (CourierID) REFERENCES Courier(CourierID),
FOREIGN KEY (LocationID) REFERENCES Location(LocationID));

insert into payment values(475,12,5320,2000,'2024-02-21');
insert into payment values(472,13,2520,1000,'2024-02-22');
insert into payment values(470,14,7320,20,'2024-02-23');
insert into payment values(482,15,9320,500,'2024-03-2');
insert into payment values(485,10,5470,200,'2024-02-25');

-----------------------------------------------------------------------------------------------------------------

-- TASK-2 Select,Where

-- 1. List all customers:
select * from user;

-- 2.List all orders for a specific customer:
select * from courier
where sendername="jasmitha";

-- 3.List all couriers:
select * from courier;

-- 4.List all packages for a specific order:
select * from courier
where orderid=201;

-- 5. List all deliveries for a specific courier:
select * from courier
where courierid=12 and status="delivered";

-- 6. List all undelivered packages:
select * from courier
where status="undelivered";

-- 7. List all packages that are scheduled for delivery today:
select * from courier
where Deliverydate=current_date();

-- 8. List all packages with a specific status:
select * from courier
where status="delivered";

-- 9. Calculate the total number of packages for each courier
select CourierID,count(*)as totalpackages from courier group by courierid;

-- 10. Find the average delivery time for each courier 
SELECT  AVG(DATEDIFF(DeliveryDate, orderdate))
 AS AvgDeliveryTime_indays FROM Courier GROUP BY COURIERID;
 
-- 11. List all packages with a specific weight range:
select * from courier
where weight between 40 and 60;

-- 12. Retrieve employees whose names contain 'John'
select * from user
where name like "%john%";

-- 13. Retrieve all courier records with payments greater than $50
select * from payment
where amount>50;
--------------------------------------------------------------------------------------------------------------
-- TASK-3 GroupBy, Aggregate Functions, Having, Order By, where

-- 14. Find the total number of couriers handled by each employee
select e.employeeid,e.name,count(c.courierid) as totalnumberofcouriers 
from employee e
join courier c
on c.employeeid=e.employeeid
group by employeeid;

-- 15. Calculate the total revenue generated by each location
select locationid,sum(amount) as totalrevenue 
from payment p 
group by locationid;

-- 16.Find the total number of couriers delivered to each location
SELECT LocationID,COUNT(Courierid) AS TotalCouriersDelivered
FROM payment
GROUP BY LocationID;

-- 17. Find the courier with the highest average delivery time:
select courierid, avg(datediff(deliverydate,orderdate)) as averagedeliverytime
from courier 
group by courierid
order by averagedeliverytime desc limit 1;

-- 18. Find Locations with Total Payments Less Than a Certain Amount
select locationid,sum(amount) as totalpayment
from payment p
group by locationid
having totalpayment<2000;

-- 19. Calculate Total Payments per Location
select locationid,sum(amount) as totalpayment
from payment p
group by locationid;

-- 20. Retrieve couriers who have received payments totaling more than $1000 in a specific location
-- (LocationID = X):
select c.*,sum(p.amount) as totalpayment from courier c
join payment p 
on c.courierid=p.courierid
where p.locationid=5320
group by c.courierid
having totalpayment>1000;

-- 21. Retrieve couriers who have received payments totaling more than $1000 after a certain date
-- (PaymentDate > 'YYYY-MM-DD'):
select c.*,sum(p.amount) as totalpayment from courier c
join payment p 
on c.courierid=p.courierid
where c.deliverydate>"2024-02-27"
group by c.courierid
having totalpayment>1000;

-- 22. Retrieve locations where the total amount received is more than $20 before a certain date
-- (PaymentDate > 'YYYY-MM-DD')
select locationid,sum(p.amount) as totalpayment from payment p
where p.paymentdate>"2024-02-23"
group by p.locationid
having totalpayment>20;

-------------------------------------------------------------------------------------------------------------------

-- TASK-4 Inner Join,Full Outer Join, Cross Join, Left Outer Join,Right Outer Join

-- 23. Retrieve Payments with Courier Information
select p.*,c.* 
from payment p
join courier c
on c.courierid=p.courierid;

-- 24. Retrieve Payments with Location Information
select p.*,l.*
from payment p 
join location l
on l.locationid=p.locationid;

-- 25. Retrieve Payments with Courier and Location Information
select p.*,c.*,l.* 
from payment p
join courier c
on c.courierid=p.CourierID
join location l
on l.locationid=p.locationid;

-- 26. List all payments with courier details
select p.*,c.*
from payment p
join courier c
on p.courierid=c.CourierID;

-- 27. Total payments received for each courier
select c.courierid,sum(p.amount) as totalpaymentreceived
from payment p 
join courier c
on p.CourierID=c.CourierID
group by c.CourierID;

-- 28. List payments made on a specific date
select * from payment
where paymentdate="2024-02-23";

-- 29. Get Courier Information for Each Payment
select p.*,c.*
from payment p 
join courier c 
on c.CourierID=p.CourierID;

-- 30. Get Payment Details with Location
select p.*,l.locationname,l.Address
from payment p
join location l
on l.locationid=p.LocationId;

-- 31. Calculating Total Payments for Each Courier
select c.CourierID,sum(p.amount) as totalpayment
from payment p 
join courier c
on p.courierid=c.courierid
group by c.CourierID;

-- 32. List Payments Within a Date Range
select * from payment p
where paymentdate between "2024-02-21" and "2024-03-2";

-- 33. Retrieve a list of all users and their corresponding courier records, including cases where there are
-- no matches on either side
select u.name,c.* from user u
left join courier c on c.sendername=u.name union
select u.name,c.* from user u
right join courier c on c.sendername=u.name;

-- 34 Retrieve a list of all couriers and their corresponding services, including cases where there are no
-- matches on either side
SELECT C.*,S.* FROM CourierServices S 
LEFT JOIN COURIER C ON C.ServiceID=S.ServiceID 
UNION 
SELECT C.*,S.* FROM CourierServices S 
RIGHT JOIN COURIER C ON C.ServiceID=S.ServiceID;

-- 35. Retrieve a list of all employees and their corresponding payments, including cases where there are
-- no matches on either side
SELECT e.EmployeeId,e.Name, SUM(Amount) AS Payment 
FROM EMPLOYEE e 
LEFT JOIN COURIER C ON C.EmployeeID=E.EmployeeID 
LEFT JOIN PAYMENT P ON P.CourierID=C.CourierID 
GROUP BY EmployeeID,E.Name union
SELECT E.EmployeeId,E.Name,SUM(Amount) 
FROM EMPLOYEE E 
RIGHT JOIN COURIER C ON C.EmployeeID=E.EmployeeID 
RIGHT JOIN PAYMENT P ON P.CourierID=C.CourierID 
GROUP BY EmployeeID,E.Name;

-- 36. List all users and all courier services, showing all possible combinations.
select * from user u 
cross join courierservices;

-- 37. List all employees and all locations, showing all possible combinations:
select * from employee e
cross join location l;

-- 38. Retrieve a list of couriers and their corresponding sender information (if available)
select c.*
from courier c
join user u
on u.name=c.sendername;

-- 39. Retrieve a list of couriers and their corresponding receiver information (if available):
select c.*
from courier c
join user u
on u.name=c.ReceiverName;

-- 40. Retrieve a list of couriers along with the courier service details (if available):
select c.*,cs.*
from courier c
left join courierservices cs
on c.serviceid=cs.ServiceID;

-- 41. Retrieve a list of employees and the number of couriers assigned to each employee:
SELECT e.*, COUNT(c.courierid) AS num_couriers_assigned
FROM Employee e
left JOIN Courier c on e.employeeid=c.employeeid
GROUP BY e.employeeid;

-- 42. Retrieve a list of locations and the total payment amount received at each location:
select l.*,sum(p.amount) as totalpayment
from location l
join payment p
on l.locationid=p.LocationId
group by locationid;

-- 43. Retrieve all couriers sent by the same sender (based on SenderName):
select c1.* from courier c1
join courier c2
on c1.SenderName=c2.SenderName and c1.courierid!=c2.CourierID;

-- 44. List all employees who share the same role:
select e1.* from employee e1
join employee e2
on e1.role =e2.role and e1.employeeid!=e2.employeeid;

-- 45. Retrieve all payments made for couriers sent from the same location:
select p1.* from payment p1
join payment p2
on p1.LocationId=p2.LocationId
and p1.PaymentID!=p2.PaymentID;

-- 46. Retrieve all couriers sent from the same location (based on SenderAddress):
select c1.* from courier c1
join courier c2
on c1.SenderAddress=c2.Senderaddress and c1.courierid!=c2.CourierID;

-- 47. List employees and the number of couriers they have delivered:
select e.employeeid,e.name,count(c.courierid) as numberofcouriers
from employee e
join courier c
on c.EmployeeID=e.EmployeeID
where Status="delivered"
group by employeeid;

-- 48 Find couriers that were paid an amount greater than the cost of their respective courier services
SELECT C.* FROM COURIER C 
JOIN PAYMENT P ON C.CourierID=P.CourierID 
JOIN CourierServices S ON C.ServiceID=S.ServiceID
WHERE P.Amount>S.Cost;

------------------------------------------------------------------------------------------------------------------------
-- TASK5 Scope: Inner Queries, Non Equi Joins, Equi joins,Exist,Any,All

-- 49. Find couriers that have a weight greater than the average weight of all couriers:
select c.* from courier c
where weight > (select avg(weight) as averageweight from courier);

-- 50. Find the names of all employees who have a salary greater than the average salary:
select name from employee where Salary > (select avg(salary) as averagesalary from employee);

-- 51. Find the total cost of all courier services where the cost is less than the maximum cost
select sum(cost) as totalcost from courierservices
where cost < (select max(cost) as maximumcost from courierservices);

-- 52. Find all couriers that have been paid for
select c.* from courier c
join payment p 
on p.courierid=c.CourierID
where amount is not null;

-- 53. Find the locations where the maximum payment amount was made
select l.* from location l
join payment p
on l.LocationID=p.LocationId
where p.amount = (select max(p.amount) from payment p);

-- 54. Find all couriers whose weight is greater than the weight of all couriers sent by a specific sender
-- (e.g., 'SenderName'):
select * from courier
where weight>all(select sum(weight) from courier where SenderName="jasmitha");
















































