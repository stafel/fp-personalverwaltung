import tkinter as tk

from screens.overview import Overview

if __name__ == '__main__':
    root = tk.Tk()
    myapp = Overview(root)
    myapp.mainloop()