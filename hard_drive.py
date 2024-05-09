# Simple implementation of a Hard Drive.
class hard_drive:
    
    # this function starting disk and track size.
    def __init__(self, size, tracks, avg_seek):
        self.size = size
        self.tracks = tracks
        self.pos_arm = [0, 0]
        self.data = [[''] * size for _ in range(tracks)]
        self.buffer = []
        self.avg_seek = avg_seek
        self.blocks_by_tracks = block_by_tracks
        self.avg_rotation = avg_rotation


    def write2(self, block_id):
        self.buffer.append(block_id)

    
    def write_private(self, buffer):
        time_total = 0
        for block_id in buffer:
            time = 0
            track = find_track(block_id)
            deslocamento = abs(arm[0] - track)
            time = deslocamento * avg_seek
            deslocamento_hor = abs(arm[1] - (block_id % (blocks_by_tracks * deslocamento)))
            time += deslocamento_hor * avg_rotation
            time_total += time

        return time_total

        
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
hd = hard_drive(10, 5, 12, 5)

# writing.
hd.write(0, 0, 'dado 01')
hd.write(0, 1, 'dado 02')

# reading        
print(hd.read(0,0))
print(hd.read(0,1))
        
        
        
