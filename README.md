## 制作背景
本アプリは、動物病院向けのシンプルな電子カルテシステムです。想定ユーザーは、動物病院で働く獣医師や動物看護師です。
エンジニアへの転職を目指す中で、自分の強みである「動物医療の現場経験」と、新たに身につけた「プログラミングスキル」を掛け合わせたポートフォリオを作成したいと考え、本アプリを開発しました。

## ER図
<img width="565" alt="スクリーンショット 2025-05-20 14 17 54" src="https://github.com/user-attachments/assets/e4a0eea0-fd7c-484c-98f9-c51474b5744e" />

## 使用技術

### バックエンド
- Java 17
- Spring Boot 3.4.5
  - Spring Web（MVC構成）
  - Spring Data JPA（MySQLとのデータ永続化）
  - Spring Security（ログイン・認証）
- Lombok（Getter/Setterなどの自動生成）
- Gradle（ビルド＆依存管理）
- Spring Boot DevTools（開発支援）

### フロントエンド
- Thymeleaf（テンプレートエンジン）
- HTML / CSS / JavaScript

### データベース
- MySQL（本番用RDBMS）

### その他
- Git / GitHub（バージョン管理）
- IntelliJ IDEA（開発環境）
