# SOLID Principles
## In this section will discuss what's SOLID principles, what problems it solves & how we identify and solve the problem by keeping these principles in mind.

---
| **Principle Name** | **Description**  |
|--|--|
| **S**ingle Responsibility Principle | Class must be responsible to server only one duty  |
| **O**pen-Closed Principle | Class must be open for extension but strictly not for modification|
| **L**iskov Substitution Principle | The object of the Child class must be replaceable with the object of the parent class without breaking the system |
| **D**ependency Inversion Principle | High/low level module must not be dependent on each other, they must be dependent on abstraction |

---
## 1. Single Responsibility Principle
**This principle says that every class should have well defined and unique responsibility.**

Let's take an example of banking service. If you have single BankService class doing operations like

[![](https://mermaid.ink/img/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG4gICAgY2xhc3MgQmFua1NlcnZpY2VcbiAgICBCYW5rU2VydmljZSA6ICtkZXBvc2l0KGFtb3VudClcbiAgICBCYW5rU2VydmljZSA6ICt3aXRoZHJhd2woYW1vdW50KVxuICAgIEJhbmtTZXJ2aWNlIDogK3ByaW50U3RhdGVtZW50KClcbiAgICBCYW5rU2VydmljZSA6ICtnZXRMb2FuSW5mbygpXG4gICAgQmFua1NlcnZpY2UgOiArc2VuZE9UUCgpXG4gICAgQmFua1NlcnZpY2UgOiArY3JlYXRlRGVtYXRlQWNjb3VudCgpXG4iLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlLCJhdXRvU3luYyI6dHJ1ZSwidXBkYXRlRGlhZ3JhbSI6ZmFsc2V9)](https://mermaid-js.github.io/mermaid-live-editor/edit#eyJjb2RlIjoiY2xhc3NEaWFncmFtXG4gICAgY2xhc3MgQmFua1NlcnZpY2VcbiAgICBCYW5rU2VydmljZSA6ICtkZXBvc2l0KGFtb3VudClcbiAgICBCYW5rU2VydmljZSA6ICt3aXRoZHJhd2woYW1vdW50KVxuICAgIEJhbmtTZXJ2aWNlIDogK3ByaW50U3RhdGVtZW50KClcbiAgICBCYW5rU2VydmljZSA6ICtnZXRMb2FuSW5mbygpXG4gICAgQmFua1NlcnZpY2UgOiArc2VuZE9UUCgpXG4gICAgQmFua1NlcnZpY2UgOiArY3JlYXRlRGVtYXRlQWNjb3VudCgpXG4iLCJtZXJtYWlkIjoie1xuICBcInRoZW1lXCI6IFwiZGVmYXVsdFwiXG59IiwidXBkYXRlRWRpdG9yIjpmYWxzZSwiYXV0b1N5bmMiOnRydWUsInVwZGF0ZURpYWdyYW0iOmZhbHNlfQ)

then you are violating the **SRP principle** because in future there could be requirements where above implementations will be changes in "BankService" class. If you are modifying the class for the new requirements that mean you are violating SRP principle.

### How to implement "Single Responsibility Principle" ?
- Keep only core banking related operations like
	1. deposit
	2. withdraw
in the "BankService" class

[![](https://mermaid.ink/img/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG4gICAgY2xhc3MgQmFua1NlcnZpY2VcbiAgICBCYW5rU2VydmljZSA6ICtkZXBvc2l0KGFtb3VudClcbiAgICBCYW5rU2VydmljZSA6ICt3aXRoZHJhd2woYW1vdW50KVxuXG4iLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlLCJhdXRvU3luYyI6dHJ1ZSwidXBkYXRlRGlhZ3JhbSI6ZmFsc2V9)](https://mermaid-js.github.io/mermaid-live-editor/edit#eyJjb2RlIjoiY2xhc3NEaWFncmFtXG4gICAgY2xhc3MgQmFua1NlcnZpY2VcbiAgICBCYW5rU2VydmljZSA6ICtkZXBvc2l0KGFtb3VudClcbiAgICBCYW5rU2VydmljZSA6ICt3aXRoZHJhd2woYW1vdW50KVxuXG4iLCJtZXJtYWlkIjoie1xuICBcInRoZW1lXCI6IFwiZGVmYXVsdFwiXG59IiwidXBkYXRlRWRpdG9yIjpmYWxzZSwiYXV0b1N5bmMiOnRydWUsInVwZGF0ZURpYWdyYW0iOmZhbHNlfQ)

- for other operations like 
	1. sendOTP - create "_NotificationService_" class 
	2. getLoanInfo - create "_LoanService_" class
	3. createDemateAccount - create "_DemateAccountService_" class
	4. and so on....
and move the methods in above classes respectively.

[![](https://mermaid.ink/img/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG4gICAgY2xhc3MgTG9hblNlcnZpY2V7XG4gICAgICArZ2V0TG9hbkRldGFpbHMoKVxuICAgIH1cbiAgICBjbGFzcyBOb3RpZmljYXRpb25TZXJ2aWNle1xuICAgICAgLXNlbmRTbXNPVFAoKVxuICAgICAgLXNlbmRFbWFpbE9UUCgpXG4gICAgICAtc2VuZFdoYXRzQXBwT1RQKClcbiAgICB9XG4gICAgY2xhc3MgRGVtYXRlQWNjb3VudFNlcnZpY2V7XG4gICAgICArZ2V0U3RvY2tEZXRhaWxzKClcbiAgICAgICtnZXRDdXJyZW50UG9ydGZvbGlvKClcbiAgICB9XG4gICAgICAgICAgICAiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlLCJhdXRvU3luYyI6dHJ1ZSwidXBkYXRlRGlhZ3JhbSI6ZmFsc2V9)](https://mermaid-js.github.io/mermaid-live-editor/edit#eyJjb2RlIjoiY2xhc3NEaWFncmFtXG4gICAgY2xhc3MgTG9hblNlcnZpY2V7XG4gICAgICArZ2V0TG9hbkRldGFpbHMoKVxuICAgIH1cbiAgICBjbGFzcyBOb3RpZmljYXRpb25TZXJ2aWNle1xuICAgICAgLXNlbmRTbXNPVFAoKVxuICAgICAgLXNlbmRFbWFpbE9UUCgpXG4gICAgICAtc2VuZFdoYXRzQXBwT1RQKClcbiAgICB9XG4gICAgY2xhc3MgRGVtYXRlQWNjb3VudFNlcnZpY2V7XG4gICAgICArZ2V0U3RvY2tEZXRhaWxzKClcbiAgICAgICtnZXRDdXJyZW50UG9ydGZvbGlvKClcbiAgICB9XG4gICAgICAgICAgICAiLCJtZXJtYWlkIjoie1xuICBcInRoZW1lXCI6IFwiZGVmYXVsdFwiXG59IiwidXBkYXRlRWRpdG9yIjpmYWxzZSwiYXV0b1N5bmMiOnRydWUsInVwZGF0ZURpYWdyYW0iOmZhbHNlfQ)

## 2. Open Closed Principle
**This principle says that every class should be open for extension but close for the modification.**

Suppose in above example we want to add whatsApp notification feature in NotificationService.
By doing this we are violating OCP principle. We should not modify existing BAU rather we should design our code in such a way that we can achieve it by creating new class and implementing some interface.


