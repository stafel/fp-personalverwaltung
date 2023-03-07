import tkinter as tk

class Overview(tk.Frame):
    def __init__(self, master):
        super().__init__(master)
        self.pack()

        self.hello = tk.Label(self, text="Hello World")
        self.hello.pack()