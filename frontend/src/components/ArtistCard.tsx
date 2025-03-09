export default function Artist() {
  return (
    <Card className="relative overflow-hidden max-w-[250px]">
        <div className="absolute inset-0 bg-gradient-to-t from-background to-transparent z-10" />
        <img
          src="/placeholder.svg?height=300&width=250"
          alt="Artist"
          className="absolute inset-0 w-full h-full object-cover"
        />
        <div className="relative z-20">
          <CardHeader className="pt-4 px-3">
            <div className="flex justify-center">
              <Avatar className="h-16 w-16 border-2 border-background">
                <AvatarImage src="/placeholder.svg?height=80&width=80" alt="Artist avatar" />
                <AvatarFallback>AR</AvatarFallback>
              </Avatar>
            </div>
          </CardHeader>
          <CardContent className="text-center mt-2 px-3">
            <CardTitle className="text-lg font-bold text-white">Aurora Waves</CardTitle>
            <CardDescription className="text-xs text-white/80">Electronic • Ambient</CardDescription>
            <div className="mt-2">
              <Badge variant="secondary" className="text-xs bg-white/20 hover:bg-white/30">
                2.4M Followers
              </Badge>
            </div>
          </CardContent>
          <CardFooter className="justify-center gap-2 pb-4 px-3">
            <Button variant="default" size="sm" className="gap-1 text-xs h-8">
              <Mic2 className="h-3 w-3" />
              Follow
            </Button>
            <Button variant="secondary" size="sm" className="gap-1 text-xs h-8">
              <Share2 className="h-3 w-3" />
              Share
            </Button>
          </CardFooter>
        </div>
      </Card>
  );
}