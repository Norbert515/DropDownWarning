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

Minimum:
```
DropDownWarning dropDownWarning = new DropDownWarning(Context context, String text, int backgroundColor, ViewGroup parent)
```

Maximum:
```
DropDownWarning dropDownWarning = new DropDownWarning(Context context, String text, int backgroundColor, ViewGroup rootView, int height, int textColor, Interpolator inInterpolator, Interpolator outInterpolator);
```
Paramters:
```
context = the context of the activity

text = message to display

backgroundColor = background color in argb (rgb with alpha)

rootView = parent view

height = height of the notification (in dp)

textColor = text color in argb

inInterpolator = interpolator for the "show" animation

outInterpolator = interpolator for the "hide" animation

```


