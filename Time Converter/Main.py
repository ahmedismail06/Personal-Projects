
# This is the main file for the Time Converter project. This file will contain the main function that will be called when the program is run.
  
import tkinter as tk

class TimeConverter:
     events = {
          "50 free" : 0.7,
          "50 back" : 0.6,
          "50 breast" : 1.0,
          "50 free" : 0.8,
          "100 fly" : 1.4,
          "100 back" : 1.2,
          "100 breast" : 2.0,
          "100 free" : 1.6,
          "200 fly" : 2.8,
          "200 back" : 2.4,
          "200 breast" : 4.0,
          "200 free" : 3.2,
          "200 im" : 3.2,
          "400 im" : 6.4
     }

     def main(self, time, event, from_course, to_course):
          minutes, seconds = time.split(":")
          seconds, milliseconds = seconds.split(".")
          timeInSeconds = int(minutes) * 60 + int(seconds) + int(milliseconds) / 100
          conversionFactor = self.events.get(event, "Invalid event")
          if from_course.lower() == "scy" and to_course.lower() == "scm":
               convertedTime = timeInSeconds * 1.11
          elif from_course.lower() == "lcm" and to_course.lower() == "scy":
               convertedTime = (timeInSeconds -conversionFactor)/1.11
          elif from_course.lower() == "scy" and to_course.lower() == "lcm":
               convertedTime = timeInSeconds * 1.11 + conversionFactor
          elif from_course.lower() == "lcm" and to_course.lower() == "scm":
               convertedTime = timeInSeconds - conversionFactor
          elif from_course.lower() == "scm" and to_course.lower() == "scy":
               convertedTime = timeInSeconds / 1.11
               
          convertedMinutes = int(convertedTime / 60)
          convertedSeconds = int(convertedTime % 60)
          convertedMilliseconds = int((convertedTime - int(convertedTime)) * 100)
          return f"{convertedMinutes}:{convertedSeconds:02}.{convertedMilliseconds:02}"


class MyGUI:
     def __init__(self):
          self.root = tk.Tk()
          self.root.title("Time Converter")
          self.root.geometry("500x500")
          self.label = tk.Label(self.root, text="Time Converter", font=("Arial", 24))
          self.label.pack()
          self.time_label = tk.Label(self.root, text="Enter the time you want to convert (MM:SS.HH): ")
          self.time_label.pack()
          self.time_entry = tk.Entry(self.root)
          self.time_entry.pack()
          self.event_label = tk.Label(self.root, text="Enter the event: ")
          self.event_label.pack()
          self.event_entry = tk.Entry(self.root)
          self.event_entry.pack()
          self.from_course_label = tk.Label(self.root, text="Enter the course you are converting from: ")
          self.from_course_label.pack()
          self.from_course_entry = tk.Entry(self.root)
          self.from_course_entry.pack()
          self.to_course_label = tk.Label(self.root, text="Enter the course you are converting to: ")
          self.to_course_label.pack()
          self.to_course_entry = tk.Entry(self.root)
          self.to_course_entry.pack()
          self.convert_button = tk.Button(self.root, text="Convert", command=self.convert_time)
          self.convert_button.pack()
          self.result = tk.Label(self.root, text="")
          self.result.pack()


          self.root.mainloop()
          
     def convert_time(self):
               converter = TimeConverter()
               result = converter.main(self.time_entry.get(), self.event_entry.get(), self.from_course_entry.get(), self.to_course_entry.get())
               self.result.config(text=result)

MyGUI()