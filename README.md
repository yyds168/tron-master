# Tron Game - Maven MVC 架构

这是一个基于Maven和MVC架构的Tron游戏项目。

## 项目结构

```
tron-master/
├── pom.xml                          # Maven配置文件
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── tron/
│       │           ├── controller/  # 控制器层
│       │           │   └── GameController.java
│       │           ├── model/       # 模型层
│       │           │   ├── game/   # 游戏逻辑
│       │           │   │   ├── GameObject.java
│       │           │   │   ├── Player.java
│       │           │   │   ├── PlayerHuman.java
│       │           │   │   ├── PlayerAI.java
│       │           │   │   ├── TronMap.java
│       │           │   │   ├── TronMapSurvival.java
│       │           │   │   ├── TronMapTwoPlayer.java
│       │           │   │   └── TronMapStory.java
│       │           │   ├── score/    # 分数管理
│       │           │   │   └── Score.java
│       │           │   └── util/    # 工具类
│       │           │       ├── Intersection.java
│       │           │       ├── Line.java
│       │           │       ├── Picture.java
│       │           │       └── Shape.java
│       │           └── view/        # 视图层
│       │               ├── game/     # 游戏视图
│       │               │   ├── SurvivalGameView.java
│       │               │   ├── TwoPlayerGameView.java
│       │               │   └── StoryGameView.java
│       │               └── menu/    # 菜单视图
│       │                   ├── MainMenuView.java
│       │                   └── PlayMenuView.java
│       └── resources/                # 资源文件
│           ├── *.png                 # 图片资源
│           ├── *.jpg
│           └── HighScores.txt        # 高分记录
└── README.md
```

## MVC架构说明

### Model层 (模型层)
- **game包**: 包含游戏核心逻辑
  - `GameObject`: 游戏对象基类
  - `Player`: 玩家抽象类
  - `PlayerHuman`: 人类玩家
  - `PlayerAI`: AI玩家
  - `TronMap`: 游戏地图基类
  - `TronMapSurvival`: 生存模式地图
  - `TronMapTwoPlayer`: 双人模式地图
  - `TronMapStory`: 故事模式地图

- **score包**: 分数管理
  - `Score`: 处理高分记录

- **util包**: 工具类
  - `Intersection`: 碰撞检测枚举
  - `Line`: 线条类
  - `Shape`: 形状接口
  - `Picture`: 图片加载工具

### View层 (视图层)
- **menu包**: 菜单视图
  - `MainMenuView`: 主菜单视图
  - `PlayMenuView`: 游戏选择菜单视图

- **game包**: 游戏视图
  - `SurvivalGameView`: 生存模式游戏视图
  - `TwoPlayerGameView`: 双人模式游戏视图
  - `StoryGameView`: 故事模式游戏视图

### Controller层 (控制器层)
- `GameController`: 主控制器，协调Model和View，处理用户交互

## 构建和运行

### 使用Maven构建

```bash
# 编译项目
mvn compile

# 打包项目
mvn package

# 运行游戏
mvn exec:java -Dexec.mainClass="com.tron.controller.GameController"
```

或者直接运行生成的jar文件：

```bash
java -jar target/tron-game-1.0.0.jar
```

## 游戏模式

1. **生存模式 (Survival)**: 玩家需要尽可能长时间生存
2. **双人模式 (Two Player)**: 两个玩家对战
3. **故事模式 (Story)**: 逐级挑战AI对手

## 控制说明

### 玩家1控制
- 方向键: 移动
- 空格键: 跳跃
- B键: 加速

### 玩家2控制 (双人模式)
- WASD: 移动
- Q键: 跳跃
- 1键: 加速

## 技术栈

- Java 23
- Swing (GUI)
- Maven (构建工具)



