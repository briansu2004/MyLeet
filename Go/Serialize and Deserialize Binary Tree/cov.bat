@cls

go test -coverprofile main_test.out 
go tool cover -html=main_test.out -o main_test.html
