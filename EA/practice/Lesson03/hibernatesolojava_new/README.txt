For MySQL:
Must use strategy IDENTITY. MySQL doesn’t support sequence. So by default, it’s gonna use table to mimic sequence.
It’s gonna get the ID first, then holds it in cache until commit
@GeneratedValue(strategy = GenerationType.IDENTITY)


Try to unwrap to get EntityManager
