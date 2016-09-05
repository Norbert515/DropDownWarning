# DropDownWarning
Easy to implemente a drop down warning/ message

<img src="gif/bounce.gif" width="200">
<img src="gif/standart.gif" width="200">

# Installation

[Download the .aar file](https://github.com/Brudigem/DropDownWarning/raw/master/dropdownwarninglibrary-release.aar)

Go to *File* -> *New* -> *New Module* -> *Import .Jar/.AAR Package*

Add this to your dependecies
```
dependecies{
    complile project (":dropdownwarninglibrary-release")
}

```

# Code


First you need the top level Layout (most of the times it's a relative layout), you will need to give it an id in the XML.

```
RelativeLayout rootView = (RelativeLayout) findViewById(R.id.rootView);
```
Next you need to create an instance of the DropDownWarning, there are a few constructors.


```
DropDownWarning dropDownWarning = new DropDownWarning(context, "Message", 0xffff8154, rootView,100, 0xff1122ff, new BounceInterpolator(), new AnticipateInterpolator());
```
Paramters:
```
context = the context of the activity
"Message" = message to display
0xffff8154 = background color in argb (rgb with alpha)
rootView = parent view
100 = height of the notification (in dp)
0xff1122ff = text color in argb
new BounceInterpolator() = interpolator for the "show" animation
new AnticipateInterpolator() = interpolator for the "hide" animation
```


