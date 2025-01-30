# TD2: Exercices de TDD

**Code fait lors de la séance du TD2**

**L'objectif n'est pas d'avoir exactement le même résultat que le code inclus, mais plutôt de pratiquer le TDD! 
Plusieurs solutions sont possibles.
L'exemple peut être incomplet.**

Implémentez ces fonctionnalités en appliquant le TDD.

## 1. Liste de tâches

Créez la classe `TaskList` qui contient les méthodes suivantes:
- `addTask(task: string, deadline: date): void` qui ajoute une tâche à la liste avec une date d'échéance
  - Si la tâche est déjà dans la liste pour cette date d'échéance, une exception `TaskAlreadyExistsException` doit être levée
- `removeTask(task: string, deadline: date ): void` qui supprime la tâche de la liste "à faire" pour la date d'échéance
  - Si la tâche n'est pas dans la liste, une exception `TaskNotFoundException` doit être levée
- `getTasksToDoByDeadline(date: date): string[]` qui retourne la liste des tâches à effectuer à une date donnée
- 
## 2. Validateur de mots de passe

Créez la classe `PasswordValidator` qui contient une méthode `isValid` qui prend un mot de passe en paramètre 
et retourne `true` si le mot de passe est valide, `false` sinon.

Un mot de passe est valide s'il respecte les règles suivantes:
- Il contient au moins 8 caractères
- Il contient au moins une lettre majuscule
- Il contient au moins une lettre minuscule
- Il contient au moins un chiffre
- Il contient au moins un caractère spécial parmi `!$&`
- Il ne contient pas d'espace