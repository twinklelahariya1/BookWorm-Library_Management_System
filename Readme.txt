Build process:

1:Start creating database with name::bookworm

2:Populate Admin followed by User(Request Body: userName,userContactNumber,userEmail,userPassword,userTotalFineAmount=0).
//populate user
sample::{
	"userName":"abc",
	"userContactNumber":"9774536789",
	"userEmail":"abc@gmail.com",
	"userPassword":"password",
	"userTotalFineAmount":0
	
	}


3:Populate Genre(Request Body: genreName) and Author(Request body: authorName)(use get to know the id of genre and author which will be needed to create book)

4:Populate Book(Request Body: bookName :: Pathvariable: {authorId},{genreId}) giving reference of Genre Id and Author Id.

5:Create Inventory for books (Request Body: quantityOfBooks=10 :: Pathvariable:{bookId})

6: Assign user card to user (Pathvariable:{userId})

7: All Set to issue book. IssueBook (RequestBody: "issueDate"="2019-05-03" :: PathVariable:{bookId},{cardId},{inventoryId})

8: return book (PathVariable:{issueId},{userId},{inventoryId}).
