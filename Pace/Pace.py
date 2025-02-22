import tkinter as tk
class Pace:
     def calculate(time, event):
          distance = event.split(" ")[0]
          numOf25 = int(distance) / 25
          numOf50 = int(distance) / 50
          numOf100 = int(distance) / 100
          minutes, seconds = time.split(":")
          seconds, milliseconds = seconds.split(".")
          timeInSeconds = int(minutes) * 60 + int(seconds) + int(milliseconds) / 100
          secondspaceIn25 = timeInSeconds / numOf25
          secondspaceIn50 = timeInSeconds / numOf50
          secondspaceIn100 = timeInSeconds / numOf100
          convertedMinutes25 = int(secondspaceIn25 / 60)
          convertedSeconds25 = int(secondspaceIn25 % 60)
          convertedMilliseconds25 = int((secondspaceIn25 - int(secondspaceIn25)) * 100)
          convertedMinutes50 = int(secondspaceIn50 / 60)
          convertedSeconds50 = int(secondspaceIn50 % 60)
          convertedMilliseconds50 = int((secondspaceIn50 - int(secondspaceIn50)) * 100)
          convertedMinutes100 = int(secondspaceIn100 / 60)
          convertedSeconds100 = int(secondspaceIn100 % 60)
          convertedMilliseconds100 = int((secondspaceIn100 - int(secondspaceIn100)) * 100)
          return f"25: {convertedMinutes25}:{convertedSeconds25:02}.{convertedMilliseconds25:02}, 50: {convertedMinutes50}:{convertedSeconds50:02}.{convertedMilliseconds50:02}, 100: {convertedMinutes100}:{convertedSeconds100:02}.{convertedMilliseconds100:02}"     

class MyGUI:
     def __init__(self):
          self.root = tk.Tk()
          self.root.title("Pace Calculator")
          self.root.geometry("500x500")
          self.label = tk.Label(self.root, text="Pace Calculator", font=("Arial", 24))
          self.label.pack()
          self.time_label = tk.Label(self.root, text="Enter your goal time (MM:SS.HH): ")
          self.time_label.pack()
          self.time_entry = tk.Entry(self.root)
          self.time_entry.pack()
          self.event_label = tk.Label(self.root, text="Enter the event: ")
          self.event_label.pack()
          self.event_entry = tk.Entry(self.root)
          self.event_entry.pack()
          self.calculate_button = tk.Button(self.root, text="Calculate", command=self.calculate)
          self.calculate_button.pack()
          self.result_label = tk.Label(self.root, text="")
          self.result_label.pack()
     def calculate(self):
          time = self.time_entry.get()
          event = self.event_entry.get()
          result = Pace.calculate(time, event)
          self.result_label.config(text=result)
     
     def run(self):
          self.root.mainloop()

          
MyGUI().run()
          
          

