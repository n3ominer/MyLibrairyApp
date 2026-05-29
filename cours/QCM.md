# QCM Android — 3A MOC 2026-2027
## 20 questions · Durée : 30 minutes

> Instructions : une seule réponse correcte par question, sauf mention contraire.

---

### Partie 1 — Connaissances Android (10 questions)

**Q1.** Quel fichier est obligatoire dans tout projet Android et déclare les activités, les permissions et les intent-filters ?

- A) `build.gradle.kts`
- B) `strings.xml`
- C) `AndroidManifest.xml` ✅
- D) `proguard-rules.pro`

---

**Q2.** Dans le cycle de vie d'une Activity, quelle méthode est appelée lorsque l'Activity revient au premier plan après avoir été partiellement cachée ?

- A) `onCreate()`
- B) `onStart()`
- C) `onResume()` ✅
- D) `onRestart()`

---

**Q3.** Quelle est la différence entre un Intent **implicite** et un Intent **explicite** ?

- A) L'Intent implicite est plus rapide que l'explicite
- B) L'Intent explicite cible une classe précise ; l'implicite décrit une action et laisse Android choisir l'app ✅
- C) L'Intent implicite ne fonctionne qu'à l'intérieur d'une même app
- D) Il n'y a aucune différence fonctionnelle

---

**Q4.** À quoi sert `finish()` dans une Activity ?

- A) Vide le back-stack entier
- B) Ferme l'application
- C) Détruit l'Activity courante et la retire du back-stack ✅
- D) Arrête toutes les coroutines en cours

---

**Q5.** Pourquoi préfère-t-on `RecyclerView` à `ListView` ?

- A) `RecyclerView` ne nécessite pas d'Adapter
- B) `RecyclerView` réutilise les vues (ViewHolder pattern), est plus performant et plus flexible ✅
- C) `ListView` ne supporte pas le scroll
- D) `RecyclerView` est automatiquement en réseau

---

**Q6.** Qu'est-ce qu'un **Fragment** ?

- A) Un fichier XML de mise en page
- B) Un composant UI autonome avec son propre cycle de vie, hébergé par une Activity ✅
- C) Une classe qui remplace complètement une Activity
- D) Un type de RecyclerView

---

**Q7.** Pourquoi utilise-t-on un **ViewModel** ?

- A) Pour accélérer les requêtes réseau
- B) Pour stocker des données de manière persistante entre les sessions
- C) Pour survivre aux rotations d'écran et séparer la logique de l'UI ✅
- D) Pour gérer les permissions au runtime

---

**Q8.** `SharedPreferences` stocke des données sous forme de :

- A) Base de données relationnelle
- B) Fichiers JSON chiffrés
- C) Paires clé-valeur dans un fichier XML ✅
- D) Objets sérialisés en binaire

---

**Q9.** À quoi sert **Retrofit** dans un projet Android ?

- A) À afficher des images depuis une URL
- B) À simplifier les appels réseau HTTP en transformant une interface Kotlin en client REST ✅
- C) À gérer les animations entre les écrans
- D) À persister des données localement

---

**Q10.** Qu'est-ce qu'une **Coroutine** Kotlin, et pourquoi l'utilise-t-on en Android ?

- A) Un thread natif Java plus léger
- B) Un mécanisme asynchrone léger qui évite de bloquer le thread principal lors d'opérations longues (réseau, BDD) ✅
- C) Une extension de RecyclerView.Adapter
- D) Un type de callback pour les requêtes Retrofit

---

### Partie 2 — Code (10 questions)

**Q11.** Que fait ce code ?
```kotlin
val intent = Intent(this, MainActivity::class.java)
startActivity(intent)
```

- A) Crée un Intent implicite vers n'importe quelle Activity principale
- B) Lance `MainActivity` depuis l'Activity courante ✅
- C) Remplace l'Activity courante par `MainActivity` sans garder l'historique
- D) Envoie un broadcast à `MainActivity`

---

**Q12.** Que fait `notifyDataSetChanged()` dans un `RecyclerView.Adapter` ?

- A) Recharge les données depuis le réseau
- B) Indique au RecyclerView que toute la liste a changé et qu'il faut tout redessiner ✅
- C) Trie la liste par ordre alphabétique
- D) Supprime tous les éléments de la liste

---

**Q13.** Que fait `lifecycleScope.launch { }` dans une Activity ?

- A) Lance un thread Java bloquant
- B) Exécute un bloc de code dans le thread principal, annulé automatiquement si l'Activity est détruite ✅
- C) Exécute le code dans un thread de fond
- D) Planifie l'exécution dans 5 secondes

---

**Q14.** Comment lit-on une valeur `String` dans `SharedPreferences` ?
```kotlin
val prefs = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
// ?
```

- A) `prefs.readString("key")`
- B) `prefs.get("key", "")`
- C) `prefs.getString("key", "valeur_par_defaut")` ✅
- D) `prefs.fetch<String>("key")`

---

**Q15.** Que fait l'annotation `@GET("volumes")` dans une interface **Retrofit** ?

- A) Définit une méthode de lecture dans une base de données locale
- B) Déclare un endpoint HTTP GET à l'URL `baseUrl + "volumes"` ✅
- C) Récupère automatiquement tous les volumes du système de fichiers
- D) Définit une requête POST vers `/volumes`

---

**Q16.** Quelle est la différence entre `apply()` et `commit()` dans `SharedPreferences.Editor` ?

- A) `apply()` est synchrone, `commit()` est asynchrone
- B) `commit()` est asynchrone, `apply()` est synchrone
- C) `apply()` est asynchrone (recommandé), `commit()` est synchrone et retourne un `Boolean` ✅
- D) Il n'y a aucune différence

---

**Q17.** Que fait ce code ?
```kotlin
supportFragmentManager
    .beginTransaction()
    .replace(R.id.fragment_container, MyFragment())
    .addToBackStack(null)
    .commit()
```

- A) Ajoute `MyFragment` par-dessus le fragment existant
- B) Remplace le fragment dans `fragment_container` par `MyFragment` et permet de revenir en arrière ✅
- C) Ferme le fragment actuel sans en afficher un nouveau
- D) Crée une nouvelle Activity contenant `MyFragment`

---

**Q18.** Comment observe-t-on un `LiveData<List<Book>>` depuis une Activity ?

- A) `liveData.subscribe { books -> ... }`
- B) `liveData.collect { books -> ... }`
- C) `liveData.observe(this) { books -> ... }` ✅
- D) `liveData.listen(lifecycle) { books -> ... }`

---

**Q19.** Quelle est la différence entre `data class` et `class` en Kotlin ?

- A) `data class` est uniquement pour les modèles réseau
- B) `data class` génère automatiquement `equals()`, `hashCode()`, `toString()` et `copy()` ✅
- C) `data class` ne peut pas avoir de méthodes
- D) Il n'y a aucune différence fonctionnelle

---

**Q20.** Que fait `mapNotNull { }` en Kotlin ?

- A) Transforme chaque élément et conserve uniquement ceux dont le résultat n'est pas nul ✅
- B) Filtre les éléments nuls sans transformation
- C) Identique à `map { }` mais ignore les exceptions
- D) Transforme la liste en `Map<Key, Value>`

---

## Corrigé rapide

| Q | R | Q | R |
|---|---|---|---|
| 1 | C | 11 | B |
| 2 | C | 12 | B |
| 3 | B | 13 | B |
| 4 | C | 14 | C |
| 5 | B | 15 | B |
| 6 | B | 16 | C |
| 7 | C | 17 | B |
| 8 | C | 18 | C |
| 9 | B | 19 | B |
| 10 | B | 20 | A |
