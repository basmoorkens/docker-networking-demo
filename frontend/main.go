package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
	"strings"
)

const backendURL = "http://rest-backend:8080/greeting"

//GreetingResult  holds the response from our backend call.
type GreetingResult struct {
	ID       int32
	Name     string
	Greeting string
}

func main() {
	http.HandleFunc("/", sayHello)
	if err := http.ListenAndServe(":8080", nil); err != nil {
		panic(err)
	}
}

func sayHello(w http.ResponseWriter, r *http.Request) {
	message := r.URL.Path
	message = strings.TrimPrefix(message, "/")
	var sCall string
	sCall = backendURL + "?name=" + message
	response, err := http.Get(sCall)
	if err != nil {
		fmt.Printf("Failed to call the backend with error %s\n", err)
	} else {
		data, _ := ioutil.ReadAll(response.Body)
		var result GreetingResult
		json.Unmarshal([]byte(data), &result)
		w.Write([]byte("My message for " + message + " is " + result.Greeting))
	}

}
