# Simple implementation of a Hard Drive.
class hard_drive:
    
    # this function starting disk and track size.
    def __init__(self, size, tracks):
        self.size = size
        self.tracks = tracks
        self.data = [[''] * size for _ in range(tracks)]
        
    # this function that writes to disk.
    def write(self, track, index, value):
        if track < self.tracks and index < self.size:
            self.data[track][index] = value
        else:
            print('error: index out of bound!')
    
    # this read from disk function.        
    def read(self, track, index):
        if track < self.tracks and index < self.size:
            return self.data[track][index]
        else:
            print('error: index out of bound!')
            return None
        
# defining track size.        
hd = hard_drive(10, 5)

# writing.
hd.write(0, 0, 'dado 01')
hd.write(0, 1, 'dado 02')

# reading        
print(hd.read(0,0))
print(hd.read(0,1))
        
        
        