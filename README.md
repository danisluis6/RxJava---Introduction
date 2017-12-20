# TOTAL TIMES[![Build Status](https://travis-ci.org/nomensa/jquery.hide-show.svg)](https://travis-ci.org/nomensa/jquery.hide-show.svg?branch=master)
## Theory 
### Introduction

> Hello, guys, it's me Filippo I came to this tutorial after a long time I've
  been away for work and yeah always wanted to do the tutorial but didn't have
  the time so bearing that in mind today I will show you how to make an android app using the latest technologies libraries in how to apply them and how to be
  dynamic while using those libraries it would be very nice if I could make it
  quick and also I was thinking to add some additional things like testing once we have done the development part but that would depend on how long we'll spend together so before jumping to the coding section I would like to explain what I want to do in this tutorial and then it would be more clear for all of you then you will be willing to complete the tutorial so I'll open Microsoft Paint and try to draw a diagram on how to proceed first I would like to say what libraries I will be using in this tutorial probably as you can see down in the title of this video I would be using dagger 2 which is a very well known dependency injection which comes after dagger 1 and then improved by Google is
  use somehow to have a more clear and precise code and obviously use that
  dependency on your all your the application so that's the number one the library that I'm going to use the second one is the RX somehow these days I'm not hearing that much about our exes but still is quite useful because lots of technologies have somehow been using that firebase WebSockets yeah you can make it follow the pub/sub design pattern but yeah it just depends by the developer so so what I'm going to do is let me draw the structure or basically let me say how I want to proceed so in this tutorial

> I want to fetch obviously a JSON file and for that, I have created a
  prepare cake Jason which obviously it will give us this kind of information
  it looks quite complicated is a JSON object and then inside a JSON object we
  have a JSON array containing a list of cakes and down at the bottom there is another additional information and all this might not be necessary but just to
  make the tutorial pretty much interesting and at the same time educational and obviously, you might find it really useful because you can apply it also in your workplace or anywhere so this will be with the JSON that I will
  be using also each of the cakes items has their own images so for downloading the images I will be using glide today rather than Picasso it also I will show you how to cache this JSON  5 in case you don't have a mental
  connection for later we use in and it goes on right

> So once I said that pretty much jump into the coding section because even now we have least spent like five minutes without doing nothing so I will be quickly creating or writing these codes but the first thing I want to create is the base activity 

> This base activity class would be my parent class or base class for all my sub activities it should extends from the app compat activity and inside I'll have the own create method.
  Obviously everyone is familiar with activity lifecycle so the first method to be called when the activity is initialized is on create and in here you can set the view by calling
  setcontentview and I say that content
  view because this get content view will be inherited by the child classes to pass their layout file content view and I'll make it an abstract 
  
- onCreate()

>   Another thing is while doing the fetching I'll show a dialog so I'll create a progress dialog and I will initialize my dialog or it might not be necessary. I'll have two simple methods they should be protected 
    void show dialog and just pass a message to it and obviously we want to check if the dialogue is null then we create the new instance of that dialogue Obviously the dialogue requires an activity reference so we'll pass that it should be cancelable if anything happens once we created the instance effects no we assign the message to the dialogue and then finally we show it
     
- void showDialog(String message)

> Similarly, we'll have another method hiding the dialogue and that would be dismiss we will dismiss if there are few conditions and those conditions and a progress dialog is different from null and is
  showing I'll create this method so it can be used for child classes to use it rather than implementing on create or override on creating so here I'll say to be in or
  to be used by child activities okay so we have that and let's make an abstract and now we can create an abstract method
  and then we force each or every activity to implement this get content view so it's mandatory you say well we
  need that in order to have a Content view perfect. 
  
- void onViewReady()

> So the second thing is going to our main activity or before that let's do the structure of the full of the packages so the first package that I want to create is application and inside here I'll create a class called obviously we are we are referring to this JSON in this JSON is obviously the Product type is Cakes. We make class name is CakeApplication
  It's a class and it should extend from application and in here I'll have two methods on create and on terminate it's just like an activity having one create and destroy. The application is a singleton object which will be available throughout the entire
  lifecycle of your app and yeah you can initialize most of the things that it might be required.

- class CakeApplication extends Application

> I want to say that I want to use it we need to specify inside our application. Especially, inside manifest and that's with a tag called name and we specify the application

- Open AndroidManifest.xml

> Perfect so we have done that the second package that I will create might be the API and for instance. Obviously, It's adjacent so we required some of the REST API so we can write our own HTTP URL connection class but that will require more time and obviously to make it perfect. I will use an existing libraries like retrofit . So for doing that. I have created some of my dependency list that I will be using in this tutorial so I'll add them or I can add them want it at a time right so the first thing is a recycler view card we retrofit
  converter Fujisan adapter for RX RX   itself in glide so i will add these dependencies inside my Gradle and I'll click synchronize in Gradle will directly download our dependencies 

- Some of the REST API free
- For example: https://jsonplaceholder.typicode.com/
- Dagger gradle dependency

> So no problem as you can see everything is good for now. At the same time what I'm going to start my genymotion. We can see everything what we are doing and let's go back to API and create a cake API service interface since we are using interface retrofit. What I'm thinking 

- root/api
- CakeApiInterface

> I will show you in two ways 
  >> one using rx
  
  >> the other one using a normal retrofit 
  call object so the first thing. I would do it as you can see this JSON here. Any HTTP request can like the basic one. But you might have like put, pop, delete, patch and There are so many more type. Typically, eight types of request type
  
> This one doesn't require any authorization in here. There is nothing. It just get request so we will use retrofit and specify "filippella/a728a34822a3bc7add98e477a4057b69/raw/310d712e87941f569074a63fedb675d2b611342a/cakes" not the base URL. But What comes after the base URL including the slash so I'll paste that in here

> And as I said I would have to kind of services and the first one is using observable so
  **observable** and that observable 's not database. I'll specify a type 
  so **Look at JSON website** the type will be determined by the type of this object 
  **What I'll do click if it's possible I'll go to file settings I'll go here down
  plugins and I'll find JSON and I'll hit Button Search Repository as you can see there are lots of plugins are already done that we are able to create JSON so I'll use this one because I can see that lots of people has downloaded and the star is good so I will add that and restart Android studio hopefully things will be quickly.**
  




