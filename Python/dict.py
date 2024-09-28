dict={
    "name" : "krishna",
    "surname" : "janoliya",
    "age" : 30,
    "org" : {
        "empId" : "112212",
        "roll": "123"
    }
}

print(dict["name"])

dict["address"]="nagpur"

print(dict)

keys= dict.keys()
values= dict.values()
dictItems= dict.items()
value=dict.get("name")
empId = dict.get("org").get("empId")
roll = dict["org"]["roll"]

dict.update({"school":"jnv" ,  "org":"infy"})

print("keys : ",keys)
print("values :",values)

print("dictItems : ",dictItems)

print("value : ",value)

print("dict : ",dict)

print("empId : ",empId)
print("roll : ",roll)




emptyDict = {}
emptyDict["h"]="kdfhg"
print(emptyDict)