export function Card({ className = null, children }: { className: string | null, children: React.ReactNode }) {
  return (
    <div className={`box-border rounded-md border-2 border-zinc-800 bg-zinc-900 p-3 shadow-sm hover:border-red-500 hover:shadow-md transition-all duration-200 ${className}`}>
      {children}
    </div>
  );
}

export function CardHeader({ className = null, children }: { className: string | null, children: React.ReactNode }) {
  return (
    <div className={`flex flex-col space-y-1.5 p-6 ${className}`}>
      {children}
    </div>
  );
}

export function CardTitle({ className = null, children }: { className: string | null, children: string }) {
  return (
    <h1 className={`text-2xl font-semibold leading-none tracking-tight ${className}`}>
      {children}
    </h1>
  );
}

export function CardContent({ className = null, children }: { className: string | null, children: React.ReactNode }) {
  return (
    <div className={`p-6 pt-0 ${className}`}>
      {children}
    </div>
  );
}

export function CardFooter({ className = null, children }: { className: string | null, children: React.ReactNode }) {
  return (
    <div className={`flex items-center p-6 pt-0 ${className}`}>
      {children}
    </div>
  );
}