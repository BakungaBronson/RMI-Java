# RMI-Java
Distributed Systems - Remote Method Invocation done in the Java language

program a minimal RMI client/server program. This program will be a room reservation system using RMI. For this exercise you can assume that everybody is reserving the room for a specific period of time. In other words, our system does not give the guests the liberty to choose the dates for the reservation.
In addition to this, there are 5 room types with different prices.
• We have 10 rooms of type 0 which are single rooms that costs 55,000 UGX a night
• We have 20 rooms of type 1 which are double rooms that costs 75,000 UGX a night
• We have 5 rooms of type 2 which are twin rooms that costs 80,000 UGX a night
• We have 3 rooms of type 3 which are triple rooms that costs 150,000 UGX a night
• We have 2 rooms of type 4 which are quad rooms that costs 230,000 UGX a night
To implement this system, you will have to write a server HotelServer, a client HotelClient, a remote interface RoomManager, and the implementation of the remote interface RoomManagerImpl.
The hotel client HotelClient can be run from a Linux shell by entering the following commands:
• java HotelClient: If no options are supplied, HotelClient just prints and shows how this
command can be used.
• java HotelClient list <server address>: list the available number of rooms in each price range. The output should look like the following:
o vroomsoftype0areavailablefor55,000UGXpernight w rooms of type 1 are available for 75,000 UGX per night x rooms of type 2 are available for 80,000 UGX per night y rooms of type 3 are available for 150,000 UGX per night z rooms of type 4 are available for 230,000 UGX per night
• The values of v, w, x, y, and z should be the current number of available rooms for each type of room.
• java HotelClient book <server address> <room type> <guest name>: books a room of the specified type (if available), and registers the name of the guest.
• java HotelClient guests <server address>: list the names of all the registered guests
• java HotelClient revenue <server address>: prints the revenue breakdown based on
the booked rooms and their types.
So, for the list, book, guests and revenue options, the HotelClient remotely invokes associated methods in a remote object. The HotelClient gets the results of these remote method invocations back from the HotelServer, and prints them out on its standard output.
