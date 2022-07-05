# README - Sprint C

## 1. Group Members

| Number  |        Name        |
|:-------:|:------------------:|
| 1190827 |    Luís Araújo     |
| 1201180 | Guilherme Sencadas |
| 1201216 |  Lucas Guimarães   |
| 1201217 |    Marco Ramos     |
| 1201228 |   Ana RIta Silva   |


## 2. Tasks

### 2.1 Task Division

|                                                  Task Number                                                  |                                                                                                  Description                                                                                                   |
|:-------------------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|                                                     2003                                                      |        *As **WarehouseEmployee**, I want to access the list of orders that need to be prepared by an AGV and be able to ask/force any of those orders to be immediately prepared by an AGV available.*         |
|                                                     3000                                                      |                                               *As **ProjectManager**, I want the team to specify a grammar allowing to express several kinds of questionnaires.*                                               |
|                                                     3001                                                      |        *As **SaleManager**, I want to create a new questionnaire to be further answered by customers meeting the specified criteria (e.g.: have ordered a given product; belong to a given age group).*        |
|                                                     4001                                                      |             *As **ProjectManager**, I want that the "AGVManager" component supports properly, at request, the needs of the "BackOfficeApp" application as well as the needs the AGV digital twin.*             |
|                                                     4002                                                      |                                *As **Project Manager**, I want that the "AGVManager" component is enhanced with a basic FIFO algorithm to automatically assign tasks to AGVs.*                                 |
|                                                     5001                                                      |                        *As **ProjectManager**, I want that the team start developing the input communication module of the AGV digital twin to accept requests from the "AGVManager".*                         |
|                                                     5002                                                      |                        *As **ProjectManager**, I want that the team start developing the outputcommunication module of the AGV digital twin to update its status on the "AGVManager".*                         |
|                                                     2004                                                      |     *As **WarehouseEmployee**, I want to access the list of orders that have already been prepared by the AGVs and be able to update any of those orders as having been dispatched for customer delivery.*     |
|                                                     2005                                                      | *As **WarehouseEmployee**, I want to open a web dashboard presenting the current status of the AGVs as well as their position in the warehouse layout and keeps updated automatically (e.g.: at each minute).* |
|                                                     1501                                                      |                                                *As **Customer**, I want to view/search the product catalog and be able to add a product to the shopping cart.*                                                 |
|                                                     1901                                                      |                                 *As **ProjectManager**, I want that the "OrdersServer" component  supports properly, at request, the needs of the "CustomerApp" application.*                                  |

### 1.2 Task Attribution

|       Task Number        | Member  |    Member Name     |           User           |
|:------------------------:|:-------:|:------------------:|:------------------------:|
| [2003](US2003/US2003.md) | 1201228 |   Ana Rita Silva   |    warehouse_employee    |
| [3000](US3000/US3000.md) | 1201180 | Guilherme Sencadas |      sales_manager       |
| [3001](US3001/US3001.md) | 1201180 | Guilherme Sencadas |      sales_manager       |
| [4001](US4001/US4001.md) | 1201228 |   Ana Rita Silva   |           ---            |
| [4002](US4002/US4002.md) | 1190827 |    Luís Araújo     |    warehouse_employee    |
| [5001](US5001/US5001.md) | 1201217 |    Marco Ramos     |                          |
| [5002](US5002/US5002.md) | 1201216 |  Lucas Guimarães   |                          |
| [2004](US2004/US2004.md) | 1190827 |    Luís Araújo     |    warehouse_employee    |
| [2005](US2005/US2005.md) | 1201180 | Guilherme Sencadas | admin/warehouse_employee |
| [1501](US1501/US1501.md) | 1201216 |  Lucas Guimarães   |         Customer         |
| [1901](US1901/US1901.md) | 1201217 |    Marco Ramos     |           ---            |

## 3. Documentation

### 3.1 Domain Model

![Domain Model](../Sprint%20D/Domain%20Model.svg)

## 4 Functional Tests

###US4002

**User:** Warehouse_employee

-----------------  Assign order not periodically -------------------                

|  Input  |                  Input                  |
|:-------:|:---------------------------------------:|
| Console |       Login (warehouse_employee)        |
| Console |               2. Options                |
| Console | 5. Assign order automatically to an AGV |
| Console |           1. Not periodically           |

--------------------  Assign order periodically ---------------------

|  Input  |                      Input                      |
|:-------:|:-----------------------------------------------:|
| Console |           Login (warehouse_employee)            |
| Console |                   2. Options                    |
| Console |     5. Assign order automatically to an AGV     |
| Console |                 2. Periodically                 |
| Console |                     minute                      |
| Console |                       30                        |

###US2003

**User:** Warehouse_employee


|  Input  |                        Input                        |
|:-------:|:---------------------------------------------------:|
| Console |             Login (warehouse_employee)              |
| Console |                     2. Options                      |
| Console |              4. Assign order to an AGV              |
| Console |                          1                          |
| Console |                          1                          |

###US2004

**User:** Warehouse_employee


|  Input  |                        Input                        |
|:-------:|:---------------------------------------------------:|
| Console |             Login (warehouse_employee)              |
| Console |                     2. Options                      |
| Console |      5.  Assign order automatically to an AGV       |
| Console |                          1                          |
| Console |                          1                          |
| Console |                     2. Options                      |
| Console | 3. Update order to dispatched for customer delivery |
| Console |                          1                          |
| Console |                          1                          |

###US2005 

**User:** Admin


|  Input  |                Input                |
|:-------:|:-----------------------------------:|
| Console |         (Login with Admin)          |
| Console |              4.Options              |
| Console |         1.Open Http Server          |
| Browser |            Open browser             |
| Browser |           Type Ip Address           |
| Browser | (Login as Admin/Warehouse Employee) |

### US3001


**User:** Sales Manager

|                                                         Question                                                         |                                                                               Input                                                                                | 
|:------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|                                               Insert the Questionnaire Id:                                               |                                                                                 11                                                                                 | 
|                                             Insert the Questionnaire Title:                                              |                                                                         Client attendance                                                                          | 
|                                   (Optional) Insert the Questionnaire Welcome Message:                                   |                                                                               Hello!                                                                               | 
|                                         Insert the Questionnaire Final Message:                                          |                                                                             Thank you!                                                                             | 
|                                                    Select Section(s):                                                    |                                                                                 1                                                                                  | 
|                                                  Insert the Section Id:                                                  |                                                                                 11                                                                                 | 
|                                                Insert the Section Title:                                                 |                                                                        Client satisfaction                                                                         | 
|                                        (Optional) Insert the Section Description:                                        |                                                                                none                                                                                | 
|                                            Select the Sections repeatability:                                            |                                                                                 1                                                                                  | 
|                                                   Select Question(s):                                                    |                                                                                 1                                                                                  | 
|                                                 Insert the Question Id:                                                  |                                                                                 10                                                                                 | 
|                                            Insert the Question Instructions:                                             |                                                                               (none)                                                                               | 
|                                                 Select a Question Type:                                                  |                                                                                 1                                                                                  | 
|              Insert the Question Text: (Multiple line input supported! When you're finished type 'leave'.)               |                       In a scale of 0 to 10 what is the probability for you to recommend our company to a friend or other person?<br/>leave                        | 
|                                           (Optional) Insert the Question Info:                                           |                                                                                none                                                                                | 
|                                           Select the Questions obligatoriness                                            |                                                                                 1                                                                                  | 
|                                                   Select Question(s):                                                    |                                                                                 2                                                                                  | 
|                                                 Insert the Question Id:                                                  |                                                                                 11                                                                                 | 
|                                       (Optional) Insert the Question Instructions:                                       |                                                                          Choose an option                                                                          | 
|                                                 Select a Question Type:                                                  |                                                                                 3                                                                                  | 
|              Insert the Question Text: (Multiple line input supported! When you're finished type 'leave'.)               | How satisfied are you with our company?<br/>1) Extremely well.<br/>2) Very satisfied.<br/>3) Not so satisfied.<br/>4) Extremely poor.<br/>5) Don't know.<br/>leave | 
|                                           (Optional) Insert the Question Info:                                           |                                                                                none                                                                                | 
|                                           Select the Questions obligatoriness                                            |                                                                                 2                                                                                  | 
|                                                   Select Question(s):                                                    |                                                                                 1                                                                                  |
|                                                   Select Question(s):                                                    |                                                                                 1                                                                                  |                                                                  
|                                                   Select Question(s):                                                    |                                                                                 0                                                                                  |                                                                  
|                                           Select the Sections obligatoriness:                                            |                                                                                 1                                                                                  |                                                                  
|                                                    Select Section(s):                                                    |                                                                                 1                                                                                  |                                                                  
|                                                    Select Section(s):                                                    |                                                                                 0                                                                                  |

|                                                         Question                                                         |                                                                                 Input                                                                                  |
|:------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|                                               Insert the Questionnaire Id:                                               |                                                                                   4                                                                                    | 
|                                             Insert the Questionnaire Title:                                              |                                                                           Computer Approval                                                                            | 
|                                   (Optional) Insert the Questionnaire Welcome Message:                                   |                                                    Welcome to the Computer Questionnaire. Let us know your opinion!                                                    |
|                                         Insert the Questionnaire Final Message:                                          |                                                                    Thank you for your cooperation!                                                                     |
|                                                    Select Section(s):                                                    |                                                                                   1                                                                                    |
|                                                  Insert the Section Id:                                                  |                                                                                   4                                                                                    |
|                                                Insert the Section Title:                                                 |                                                                               Usability                                                                                |
|                                        (Optional) Insert the Section Description:                                        |                                                                                 (none)                                                                                 |
|                                            Select the Sections repeatability:                                            |                                                                                   1                                                                                    |
|                                                   Select Question(s):                                                    |                                                                                   1                                                                                    |
|                                                 Insert the Question Id:                                                  |                                                                                   44                                                                                   |
|                                            Insert the Question Instructions:                                             |                                                                                 (none)                                                                                 |
|                                                 Select a Question Type:                                                  |                                                                                   2                                                                                    |
|              Insert the Question Text: (Multiple line input supported! When you're finished type 'leave'.)               |                                                  How often do you use your computer, in a scale of 1 to 10?<br/>leave                                                  |
|                                           (Optional) Insert the Question Info:                                           |                                                                                 (none)                                                                                 |
|                                           Select the Questions obligatoriness                                            |                                                                                   1                                                                                    |
|                                                   Select Question(s):                                                    |                                                                                   0                                                                                    |
|                                                    Select Section(s):                                                    |                                                                                   1                                                                                    |
|                                                Insert the Section Title:                                                 |                                                                                   5                                                                                    |
|                                                Insert the Section Title:                                                 |                                                                              Improvement                                                                               |
|                                        (Optional) Insert the Section Description:                                        |                                                                                 (none)                                                                                 |
|                                            Select the Sections repeatability:                                            |                                                                                   1                                                                                    |
|                                                   Select Question(s):                                                    |                                                                                   1                                                                                    |
|                                                 Insert the Question Id:                                                  |                                                                                   45                                                                                   |
|                                       (Optional) Insert the Question Instructions:                                       |                                                                                 (none)                                                                                 |
|                                                 Select a Question Type:                                                  |                                                                                   5                                                                                    |
|              Insert the Question Text: (Multiple line input supported! When you're finished type 'leave'.)               | How can we improve this type of computer?<br/>1) Better motherboard<br/>2) Better colling system<br/>3) Add another RAM memory<br/>4) Implement a better CPU<br/>leave |
|                                           (Optional) Insert the Question Info:                                           |                                                                                 (none)                                                                                 |
|                                           Select the Questions obligatoriness                                            |                                                                                   1                                                                                    |
|                                                   Select Question(s):                                                    |                                                                                   0                                                                                    |
|                                                    Select Section(s):                                                    |                                                                                   0                                                                                    |

|                      Question                      |       Input        |
|:--------------------------------------------------:|:------------------:|
|      Insert the Survey Code: (Max: 15 chars)       |      a478bc7       |
|   Insert the Survey Description: (Max: 40 chars)   | Survey Description |
|     Insert the Survey First Date: (dd/MM/yyyy)     |     10/05/2022     |
| Insert the Questionnaire Second Date: (dd/MM/yyyy) |     27/05/2022     |
|              Select Questionnaire(s):              |         1          |
|               Choose a Target Type:                |         3          |
|                 Select a Product:                  |         1          |
|                 Select a Product:                  |         0          |
|        Insert the First Date: (dd/MM/yyyy)         |     10/05/2022     |
|        Insert the First Date: (dd/MM/yyyy)         |     27/05/2022     |

### US1501

|                          Question                           |   Input    |
|:-----------------------------------------------------------:|:----------:|
|      Insert the product identification (Internal Code)      |    Milk    |
|     Insert the quantity of the product you want to add      |     3      |

### US5002

|                         Question                         |  Input   |
|:--------------------------------------------------------:|:--------:|
|                Insert the AGV identifier:                | 00000001 |
| Insert the AGV new status between the available options: | Charging |

