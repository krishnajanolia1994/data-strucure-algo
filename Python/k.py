def __init__(self): 
self.stack = [] 
def execute(self, operations):
     try: 
         for op in operations.split(): 
            if op.isdigit():
                 self.stack.append(int(op)) 
            elif op == "POP": 
                if not self.stack: return -1 
                self.stack.pop() 
            elif op == "DUP": 
                if not self.stack: 
                    return -1 
                self.stack.append(self.stack[-1]) 
            elif op == "+": 
                if len(self.stack) < 2: 
                    return -1 top1 = self.stack.pop() top2 = self.stack.pop() result = top1 + top2 if result > 2**31 - 1: return -1 self.stack.append(result) elif op == "-": if len(self.stack) < 2: return -1 top1 = self.stack.pop() top2 = self.stack.pop() result = top1 - top2 if result < 0: return -1 self.stack.append(result) else: return -1 return self.stack[-1] if self.stack else -1 except: return -1 # Example usage: machine = StackMachine() operations = "13 DUP 4 POP 5 DUP + DUP + -" result = machine.execute(operations) print(result) # Output should be 7