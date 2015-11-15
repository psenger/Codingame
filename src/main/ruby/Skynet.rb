STDOUT.sync = true # DO NOT REMOVE
# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

@road = gets.to_i # the length of the road before the gap.
@gap = gets.to_i # the length of the gap.
@platform = gets.to_i # the length of the landing platform.

def calculate_jump_speed( gap )
  gap + 1
end

target_jump_speed = calculate_jump_speed( @gap )
we_have_jumped = false

# game loop
loop do
  speed = gets.to_i # the motorbike's speed.
  coord_x = gets.to_i # the position on the road of the motorbike.

  if we_have_jumped
    if speed != 0
      puts 'SLOW'
    end
  else
    if @road -1 == coord_x
      puts 'JUMP'
      we_have_jumped = true
    else
      if speed == target_jump_speed
        puts 'WAIT'
      elsif speed > target_jump_speed
        puts 'SLOW'
      elsif speed < target_jump_speed
        puts 'SPEED'
      end
    end
  end

end