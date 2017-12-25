# WELCOME YOU TUTORIAL LEARNING RXJAVA [![Build Status](https://travis-ci.org/nomensa/jquery.hide-show.svg)](https://travis-ci.org/nomensa/jquery.hide-show.svg?branch=master)

> **Nickname:** Lorence

> **Hobby:** Soccer and Chess

> **Major:** Programmer

> **Address:** VietNam

> **Schedule** #[Schedule](#schedule)

# [JavaRx](#javarx)
## [Introduction](#introduction)
  - [Characteristic](#characteristic)
  - [EditText](#edittext)
    - [How to make editText without line at bottom](#how-to-make-edittext-without-line-at-bottom)
    - [How to create EditText with rounded corners](#how-to-create-edittext-with-rounded-corners)
    - [How to add icon inside EditText view in Android](#how-to-add-icon-inside-edittext-view-in-android)
    - [How to set any image for ImageView](#how-to-set-any-image-for-imageview)
    - [How to set dimesion of icon inside EditText](#how-to-set-dimesion-of-icon-inside-edittext)
    - [How to make any html color code semi transparent](#how-to-make-any-html-color-code-semi-transparent)
    - [Load image from url](#load-image-from-url)
    - [Draw GridLayout](#draw-gridLayout)
    - [How to organizate folder in android-studio](#how-to-organizate-folder-in-android-studio)
    - [How to cutomize activity on more device](#How to cutomize activity on more device)
### [Total Page](#total-page)
### [Check Load More](#check-load-more)

# JavaRx
## Introduction
### Characteristic
   > Functional reactive programming is very hard to understand when you come from Object Oriented Programming
   
   > For me: I need to have some articles or a series of articles to help me understand the basic concept of Reactive Programming
   
   > Question 1: What reactive is coming such a big thing in Android?
   
   > Question 2: Find a reason why we need to use RxJava. Maybe, we already have some prolems for issues occurs.
   
    The evaluation matrix
<img src = "https://github.com/danisluis6/RxJava-Introduction/blob/master/The%20evaluation%20matrix.png" alt = "The evaluation matrix">

## Concepts
   > Reactive programming is a programming paradigm oriented around data flows and the propagation of change. This means that it should be possible to express static or dynamic data flows with ease in the programming languages used, and that the underlying execution model will automatically propagate changes through the data flow.
   
   > RX = OBSERVABLE + OBSERVER + SCHEDULERS

## 3 simple steps to use Rx in your application
<img src = "https://github.com/danisluis6/RxJava-Introduction/blob/master/The%20evaluation%20matrix.png" alt = "The evaluation matrix">

## An Example
<img src = "https://github.com/danisluis6/RxJava-Introduction/blob/master/The%20evaluation%20matrix.png" alt = "The evaluation matrix">

   > Step-1 Create observable that emits the data:
   
   >> Here database is an observable which emits the data. In our case, it emits the strings. just() is an operator. Which basically emits the data provided in the argument one by one. (We are going to look into the operators in detail in our upcoming articles. So, don’t worry about them.)
   
   > Step -2 Create observer that consumes data:
   
   >> In above code snippet observer is an observer that consumes the data emitted by the database observable. It processes the data received and also handles error inside it.
   
   > Step-3 Manage concurrency:
   
   >> At the last step, we define our schedulers that manage the concurrency. subscribeOn(Schedulers.newThread()) tells database observable to run on background thread. observeOn(AndroidSchedulers.mainThread()) tells observer to run on the main thread. This is basic code for reactive programming.

## Schedule

> **Version: ** ver22

> **Update list when change release date**

>> **We need to refresh API when change value. So, we need check condition before calling API**

>> **Fix when save RecyclerView's scroll position using RecyclerView.State**

>> **Hello**

> **Update list when change release year**


