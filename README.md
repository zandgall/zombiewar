# Zombie War

(Taken from Assignment)

A virus has infected people and turned them into zombies. There are a few survivors that must make it to a safe place without getting killed by the zombies.
There are different types of zombies: Common Infected and Tank. A common infected zombie is weak and does little damage. Tank on the other can do a lot of damage and can take a lot of attack before it dies.
The types of survivors include: soldier, teacher, and child. A soldier is strong and can do serious damage while a teacher or a child does little damage. Since a child is so weak, he or she usually does not survive the escape.

## Character Data

| | Health | Attack |
| - | - | - |
| Common Infect | 30 | 5 |
| Tank | 150 | 20 |
| Child | 20 | 2 |
| Teacher | 50 | 5 |
| Soldier | 100 | 10 |

A character has an initial health. It loses health in each attack. The amount of health lost depends on who is doing the attack. For example, if a tank attacks a survivor, one attack would cause the survivor to lose 20 health points.

## Program Logic

The program randomly generates an array of survivors and zombies. Make each survivor attack every zombie. Next, make each zombie attack every survivor. Repeat until all zombie or all survivors are dead. Then print a report of how many survivors made it to safety. A dead survivor or a dead zombie should not attack.
