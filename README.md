# Search & Recommendation System


Background Intro:

I was assigned to work on a personalized item search and recommendation project. It was an interactive web page for users to search mechanical equipment and items based on users’ search history. We used HTML/CSS/JavaScript and AJAX for the front-end page design, and we applied RESTful APIs and Java Servlet for the back-end service. I have mainly worked on the recommendation algorithm to make sure users get recommendations that they are interested in so that users could good user experiences. 


Problem:

At the beginning of first, the project was developed to use history-based recommendation algorithm, which means that users are going to receive recommendations based on their past searching history. if you search one item in the past, it will recommend similar items to you in the future. However, for our new users, we don’t have their past searching history, so they will receive random recommendation which they will probably don’t like it. If users did not gain a good user experience of using our product, consequently, we are going to lose our new users.


Action:

I did research on user-based (similarity of users) and item-based recommendation system, (similarity of items). I compared their pros and coms and trade-offs. Eventually, I decided to optimize our history-based recommendation algorithm to history + user-based recommendation algorithm. Basically, the user-based recommendation is one type of Collaborative Filtering that calculates the similarity of users and then recommend items. Collaborative filtering takes advantage of user's past behavior as well as decisions made by similar users or friends of the user.

We gathered more user data and build user profile such as geo-location, their preferred serving process, expected products, etcs, so that we can match our new users with existing users if they share similarity in their user profile. If they do share similarities, we can recommend items to our new users based on commonality of the user profiles. Therefore, our new users are more possible to receive recommendations that they are interested in. 


Result: This optimized the recommendation algorithm helped to boost users’ search rate by 15% at the end of the quarter. 


Techniques:
- Frontend: HTML/CSS/JavaScript/AJAX
- Backend:
Data Source: MachineEquip API
Java Servlet(rpc):
servlet for login (/login)
servlet for logout (/logout)
servlet for register (/register)
servlet for recommend items(/recommendation)
servlet for browse similar items(/search)
servlet for check favorites (/history)

- Database: MySQL(JDBC), "machines" table, "users" table, "history" table, "categories" table


